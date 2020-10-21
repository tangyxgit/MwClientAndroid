package com.mwim.qcloud.tim.uikit.business.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mwim.qcloud.tim.uikit.R;
import com.work.util.PhoneUtils;
import com.work.util.SLog;
import com.work.util.SizeUtils;
import com.work.util.StringUtils;

import java.util.HashMap;

public class WebViewProgress extends WebView {

    private ProgressBar progressbar;
    private OnWebLoadListener onWebLoadListener;
    private boolean needClearHistory;
    private boolean isWebError;

    public WebViewProgress(Context context) {
        super(getFixedContext(context));
        init(context);
    }

    public WebViewProgress(Context context, AttributeSet attrs) {
        super(getFixedContext(context), attrs);
        init(context);
    }
    public WebViewProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(getFixedContext(context), attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        int h = SizeUtils.dp2px(context,3);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,h);
        progressbar.setLayoutParams(params);
        addView(progressbar);
        setJavaScript();
        final CheoaWebJs mCheoa = new CheoaWebJs(getContext());
        addJavascriptInterface(mCheoa, "cheoa");//第二个参数cheoa不可更改，
        setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("weixin://") || url.contains("alipays://platformapi")) {//如果微信或者支付宝，跳转到相应的app界面,
                    goBack();
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        getContext().startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }else if(url.startsWith("tel:")){
                    PhoneUtils.dial(getContext(), StringUtils.subStr(url,"tel:","",0));
                    return true;
                }
                if (mCheoa.getKey() != null) {
                    HashMap<String,String> extraHeaders = new HashMap<>();
                    extraHeaders.put(mCheoa.getKey(), mCheoa.getValue());
                    view.loadUrl(url, extraHeaders);
                }else{
                    view.loadUrl(url);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String title = view.getTitle();
                if(onWebLoadListener!=null){
                    if(isWebError){
                        title = getContext().getString(R.string.app_name);
                    }
                    onWebLoadListener.onWebTitleChange(title);
                }
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                if(onWebLoadListener!=null){
                    onWebLoadListener.onLoadResource(url);
                }
            }

            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                super.doUpdateVisitedHistory(view, url, isReload);
                if(needClearHistory){
                    view.clearHistory();
                    needClearHistory=false;
                }
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                isWebError = true;
                if(onWebLoadListener!=null){
                    onWebLoadListener.onReceivedError();
                }
            }

        });
        setWebChromeClient(new WebChromeClient());
//        setWebChromeClientExtension(new ProxyWebChromeClientExtension(){
//            @Override
//            public void openFileChooser(android.webkit.ValueCallback<Uri[]> valueCallback, String s, String s1) {
//                super.openFileChooser(valueCallback, s, s1);
//                SLog.e("多选文件...");
//            }
//        });
        setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                SLog.e("下载文件："+s+">"+s1+">"+s2+">"+s3+">"+l);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(s));
                getContext().startActivity(intent);
            }
        });
    }
    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            onWebProgressChanged(newProgress);
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if(onWebLoadListener!=null){
                if(isWebError){
                    title = getContext().getString(R.string.app_name);
                }
                onWebLoadListener.onWebTitleChange(title);
            }
        }

        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            SLog.e("onShowFileChooser...");
            fileValueCallback = valueCallback;
            if(onWebLoadListener!=null){
                onWebLoadListener.onShowFileChooser();
            }
            return true;
        }
    }
    public void onWebProgressChanged(int newProgress){
        if (newProgress == 100) {
            progressbar.setVisibility(GONE);
            if(onWebLoadListener!=null)onWebLoadListener.onLoadFinal();
        } else {
            if (progressbar.getVisibility() == GONE)
                progressbar.setVisibility(VISIBLE);
            progressbar.setProgress(newProgress);
        }
    }

    @Override
    public void reload() {
        isWebError = false;
        super.reload();
    }

    public boolean isWebError() {
        return isWebError;
    }

    /**
     * 设置支持JavaScript
     */
    public void setJavaScript(){
        WebSettings webSetting = getSettings();
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);//禁止页面放大缩小
        webSetting.setDisplayZoomControls(false);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSetting.setTextZoom(100);//设置字体比例
        webSetting.setDefaultTextEncodingName("utf-8");
        clearCache(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
    }

    public void setUserAgentString(String ua){
        getSettings().setUserAgentString(ua);
    }

    /**
     * 移除历史页面
     */
    public void setNeedClearHistory(){
        this.needClearHistory = true;
    }

    public void setOnWebLoadListener(OnWebLoadListener onWebLoadListener) {
        this.onWebLoadListener = onWebLoadListener;
    }
    /**
     * 默认支持支付等功能
     */
    private static class CheoaWebJs {

        private Context mContext;

        CheoaWebJs(Context context) {
            this.mContext = context;
        }

        private String key,value;
        //拿到需要设置webView的微信下单属性
        @JavascriptInterface
        public void setExtraInfoHead(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
    /**
     * 加载监听
     */
    public interface OnWebLoadListener{
        void onLoadFinal();
        void onWebTitleChange(String title);
        void onLoadResource(String url);
        void onReceivedError();
        void onShowFileChooser();
    }
    private ValueCallback<Uri[]> fileValueCallback;
    public void fileValueCallbackResult(int requestCode, int resultCode, @Nullable Intent data){
        SLog.e("文件选择完成:"+resultCode+">"+data);
        if(fileValueCallback==null){
            return;
        }
        if(resultCode == AppCompatActivity.RESULT_OK && data!=null){
            Uri fileUri = data.getData();
            fileValueCallback.onReceiveValue(new Uri[]{fileUri});
        }else if(resultCode == AppCompatActivity.RESULT_CANCELED){
            fileValueCallback.onReceiveValue(null);
        }
    }

    public static Context getFixedContext(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) // Android Lollipop 5.0 & 5.1
            return context.createConfigurationContext(new Configuration());
        return context;
    }
}