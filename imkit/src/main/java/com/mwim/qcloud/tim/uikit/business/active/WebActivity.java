package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.business.fragment.ChatFragment;
import com.mwim.qcloud.tim.uikit.business.fragment.WebViewFragment;


/**
 * Created by Administrator on 2019/5/14
 * Description
 */

public class WebActivity extends BaseActivity {

    private WebViewFragment webViewFragment;

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        String url = getIntent().getStringExtra(WebActivity.class.getSimpleName());
        if(TextUtils.isEmpty(url)){
            finish();
            return;
        }
        webViewFragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(WebActivity.class.getSimpleName(),url);
        webViewFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.empty_view, webViewFragment).commitAllowingStateLoss();
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
        Intent intent = new Intent(IMKitAgent.instance(),WebActivity.class);
        intent.putExtra(WebActivity.class.getSimpleName(),url);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        IMKitAgent.instance().startActivity(intent);
    }
}
