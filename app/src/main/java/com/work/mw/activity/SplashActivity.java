package com.work.mw.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.business.active.MwWorkActivity;
import com.mwim.qcloud.tim.uikit.business.dialog.ConfirmDialog;
import com.mwim.qcloud.tim.uikit.business.modal.UserApi;
import com.mwim.qcloud.tim.uikit.business.thirdpush.OfflineMessageDispatcher;
import com.mwim.qcloud.tim.uikit.modules.chat.base.OfflineMessageBean;
import com.work.api.open.Yz;
import com.work.api.open.model.BaseResp;
import com.work.api.open.model.LoginReq;
import com.work.api.open.model.LoginResp;
import com.work.mw.R;
import com.work.util.SLog;
import com.work.util.ToastUtil;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public class SplashActivity extends BaseActivity {

    private UserApi mUserInfo;

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        setStatusBar(ContextCompat.getColor(this,R.color.background_color));
        mUserInfo = UserApi.instance();
        handleData();
    }
    private void handleData() {
        if (mUserInfo != null && !TextUtils.isEmpty(mUserInfo.getToken()) &&!TextUtils.isEmpty(mUserInfo.getUserSign())) {
            LoginReq loginReq = new LoginReq();
            loginReq.setUserId(mUserInfo.getUserId());
            Yz.getSession().getUserByUserId(loginReq,this);
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
        IMKitAgent.login(mUserInfo.getUserId(), mUserInfo.getUserSign(), new IUIKitCallBack() {
            @Override
            public void onError(String module, final int code, final String desc) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        startLogin();
                    }
                });
                SLog.e("imLogin errorCode = " + code + ", errorInfo = " + desc);
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
        if (IMKitAgent.parseOfflineMessage(getIntent())) {
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

    @Override
    public void onResult(RequestWork req, ResponseWork resp) throws Exception {
        super.onResult(req, resp);
        if(resp.isSuccess() && resp instanceof LoginResp){
            login();
        }else{
            ToastUtil.warning(this,resp.getMessage());
            if(((BaseResp) resp).getCode() != 501){
                String message = resp.getMessage();
                if(TextUtils.isEmpty(message)){
                    message = "服务器繁忙。";
                }
                new ConfirmDialog().setContent(message).setOnConfirmListener(view -> finish()).setOnCancelListener(view -> finish()).show(getSupportFragmentManager(),"error_service");
            }
        }
    }
}
