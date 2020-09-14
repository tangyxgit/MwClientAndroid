package com.work.mw.activity;

import android.Manifest;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.dd.processbutton.iml.ActionProcessButton;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.business.active.MwWorkActivity;
import com.work.api.open.Yz;
import com.work.api.open.model.LoginReq;
import com.work.api.open.model.LoginResp;
import com.work.api.open.model.RegisterReq;
import com.work.api.open.model.client.OpenData;
import com.work.mw.R;
import com.work.mw.modal.UserApi;
import com.work.util.AppUtils;
import com.work.util.SLog;
import com.work.util.ToastUtil;
import com.workstation.permission.PermissionsResultAction;

/**
 * Created by tangyx
 * Date 2020/8/17
 * email tangyx@live.com
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    public static String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.CHANGE_NETWORK_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO};
    private EditText mPhone;
    private ImageView mAccount;
    private EditText mPassword;
    private ActionProcessButton mSubmit;

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        mPhone = findViewById(R.id.phone);
        mAccount = findViewById(R.id.account);
        mPassword = findViewById(R.id.password);
        mSubmit = findViewById(R.id.submit);
        TextView mVersion = findViewById(R.id.version);
        AppUtils.AppInfo appInfo = AppUtils.getAppInfo(this);
        if(appInfo!=null){
            mVersion.setText(getString(R.string.text_version,appInfo.getVersionName()));
        }
        findViewById(R.id.forget).setOnClickListener(this);
        findViewById(R.id.register_layout).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
    }

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        setSubEnable(false);
        mAccount.setColorFilter(ContextCompat.getColor(this,R.color.color_2da0f0));
        mPhone.addTextChangedListener(this);
        mPassword.addTextChangedListener(this);
        if(!hasPermission(PERMISSIONS)){
            onPermissionChecker(PERMISSIONS, new PermissionsResultAction() {
                @Override
                public void onGranted() {
                }

                @Override
                public void onDenied(String permission) {

                    ToastUtil.error(LoginActivity.this,R.string.toast_permission_error);
                }
            });
        }
    }

    private void setSubEnable(boolean enable){
        if(enable){
            mSubmit.setBackgroundCompat(ContextCompat.getDrawable(this,R.drawable.shape_2da0f0_radius_5));
            mSubmit.setEnabled(true);
        }else{
            mSubmit.setBackgroundCompat(ContextCompat.getDrawable(this,R.drawable.shape_dbe7ef_radius_5));
            mSubmit.setEnabled(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        String phone = UserApi.instance().getPhone();
        if(!TextUtils.isEmpty(phone)){
            mPhone.setText(phone);
        }
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forget:
                startActivity(new Intent(this, RegisterActivity.class).putExtra(RegisterActivity.class.getSimpleName(),false));
                break;
            case R.id.register_layout:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.submit:
                LoginReq loginReq = new LoginReq();
                loginReq.setMobile(mPhone.getText().toString().trim());
                loginReq.setPassword(mPassword.getText().toString().trim());
                mSubmit.setEnabled(false);
                mSubmit.setProgress(50);
                Yz.getSession().login(loginReq,this);
//                String account = mPhone.getText().toString();
//                UserInfo.getInstance().setUserId(account);
//                final String userSig = GenerateTestUserSig.genTestUserSig(account);
//                IMKitAgent.login(account, userSig, new IUIKitCallBack() {
//                    @Override
//                    public void onError(String module, final int code, final String desc) {
//                        runOnUiThread(new Runnable() {
//                            public void run() {
//                                ToastUtil.error(LoginActivity.this,"登录失败, errCode = " + code + "errInfo = " + desc);
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onSuccess(Object data) {
//                        UserInfo.getInstance().setAutoLogin(true);
//                        UserInfo.getInstance().setUserSig(userSig);
//                        Intent intent = new Intent(LoginActivity.this, MwWorkActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                });
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        setSubEnable(!TextUtils.isEmpty(mPhone.getText().toString().trim()) && !TextUtils.isEmpty(mPassword.getText().toString().trim()));
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onResult(RequestWork req, ResponseWork resp) throws Exception {
        super.onResult(req, resp);
        mSubmit.setProgress(0);
        mSubmit.setEnabled(true);
        if(resp.isSuccess()){
            if(resp instanceof LoginResp){
                OpenData data = ((LoginResp) resp).getData();
                if(data!=null){
                    UserApi userApi = UserApi.instance();
                    userApi.setUserId(data.getUserId());
                    userApi.setUserSign(data.getUserSign());
                    LoginReq loginReq = (LoginReq) req;
                    userApi.setPhone(loginReq.getMobile());
                    IMKitAgent.login(userApi.getPhone(), userApi.getUserSign(), new IUIKitCallBack() {
                        @Override
                        public void onSuccess(Object data) {
                            SLog.e("im success:"+data);
                            Intent intent = new Intent(LoginActivity.this, MwWorkActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onError(String module, final int errCode, final String errMsg) {
                            SLog.e("登录失败, errCode = " + errCode + "errInfo = " + errMsg);
                        }
                    });
                }
            }
        }else{
            ToastUtil.warning(this,resp.getMessage());
        }
    }
}
