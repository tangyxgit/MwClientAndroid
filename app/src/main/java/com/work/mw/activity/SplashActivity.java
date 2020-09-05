package com.work.mw.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.business.active.MwWorkActivity;
import com.mwim.qcloud.tim.uikit.business.thirdpush.OfflineMessageDispatcher;
import com.mwim.qcloud.tim.uikit.modules.chat.base.OfflineMessageBean;
import com.mwim.qcloud.tim.uikit.utils.ToastUtil;
import com.work.mw.R;
import com.work.mw.modal.UserInfo;
import com.workstation.android.BaseHomeActivity;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public class SplashActivity extends BaseHomeActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();
    private UserInfo mUserInfo;

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        mUserInfo = UserInfo.getInstance();
        handleData();
    }

    private void handleData() {
        if (mUserInfo != null && mUserInfo.isAutoLogin()) {
            login();
        } else {
            View mFlashView = findViewById(R.id.loading_view);
            mFlashView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startLogin();
                }
            }, 1000);
        }
    }
    private void login() {
        IMKitAgent.login(mUserInfo.getUserId(), mUserInfo.getUserSig(), new IUIKitCallBack() {
            @Override
            public void onError(String module, final int code, final String desc) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        ToastUtil.toastLongMessage("登录失败, errCode = " + code + ", errInfo = " + desc);
                        startLogin();
                    }
                });
                Log.i(TAG, "imLogin errorCode = " + code + ", errorInfo = " + desc);
            }

            @Override
            public void onSuccess(Object data) {
                startMain();
            }
        });
    }
    private void startLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void startMain() {
        OfflineMessageBean bean = OfflineMessageDispatcher.parseOfflineMessage(getIntent());
        if (bean != null) {
            OfflineMessageDispatcher.redirect(bean);
            finish();
            return;
        }

        Intent intent = new Intent(SplashActivity.this, MwWorkActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }
}
