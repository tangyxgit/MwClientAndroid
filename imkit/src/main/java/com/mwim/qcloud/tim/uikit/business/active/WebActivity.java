package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.business.fragment.WebViewFragment;
import com.work.util.SLog;


/**
 * Created by Administrator on 2019/5/14
 * Description
 */

public class WebActivity extends BaseActivity {

    public final static String UA = "UA";
    private WebViewFragment webViewFragment;

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        Bundle bundle = getIntent().getExtras();
        if(bundle==null){
            finish();
            return;
        }
        String url = bundle.getString(WebActivity.class.getSimpleName());
        SLog.e("web url:"+url);
        if(TextUtils.isEmpty(url)){
            finish();
            return;
        }
        webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, webViewFragment).commitAllowingStateLoss();
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }

    @Override
    public int onCustomContentId() {
        return R.layout.activity_im_chat;
    }

    @Override
    public void onBackPressed() {
        webViewFragment.onBack();
    }

    public static void startWebView(String url){
        startWebView(url,null);
    }
    public static void startWebView(String url,String ua){
        Intent intent = new Intent(IMKitAgent.instance(),WebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(WebActivity.class.getSimpleName(),url);
        if(!TextUtils.isEmpty(ua)){
            bundle.putString(UA,ua);
        }
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        IMKitAgent.instance().startActivity(intent);
    }
}
