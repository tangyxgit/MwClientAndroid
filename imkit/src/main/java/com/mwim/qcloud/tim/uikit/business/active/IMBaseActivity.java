package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.base.IMEventListener;
import com.mwim.qcloud.tim.uikit.utils.DemoLog;
import com.work.util.ToastUtil;

/**
 * 登录状态的Activity都要集成该类，来完成被踢下线等监听处理。
 */
public abstract class IMBaseActivity extends BaseActivity {

    private static final String TAG = IMBaseActivity.class.getSimpleName();

    // 监听做成静态可以让每个子类重写时都注册相同的一份。
    private IMEventListener mIMEventListener = new IMEventListener() {
        @Override
        public void onForceOffline() {
            ToastUtil.warning(IMBaseActivity.this,"您的帐号已在其它终端登录");
            logout();
        }

        @Override
        public void onUserSigExpired() {
            ToastUtil.warning(IMBaseActivity.this,"账号已过期，请重新登录");
            logout();
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IMKitAgent.addIMEventListener(mIMEventListener);
    }

    @Override
    protected void onStart() {
        DemoLog.i(TAG, "onStart");
        super.onStart();
//        boolean login = UserInfo.getInstance().isAutoLogin();
//        if (!login) {
//            BaseActivity.logout(DemoApplication.instance());
//        }
    }

    @Override
    protected void onResume() {
        DemoLog.i(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        DemoLog.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        DemoLog.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        DemoLog.i(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        DemoLog.i(TAG, "onNewIntent");
        super.onNewIntent(intent);
    }
}
