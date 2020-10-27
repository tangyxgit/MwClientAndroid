package com.mwim.qcloud.tim.uikit.base;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.business.helper.wemeet.WemeetSdkHelper;
import com.mwim.qcloud.tim.uikit.business.modal.UserApi;
import com.work.api.open.model.BaseResp;
import com.work.util.ToastUtil;
import com.workstation.android.TakePhotoActivity;

public class BaseActivity extends TakePhotoActivity {
    @Override
    public void setStatusBar() {
        super.setStatusBar();
        setStatusBar(ContextCompat.getColor(this, R.color.status_bar_color));
    }

    public void setStatusBar(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(color);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.navigation_bar_color));
            int vis = getWindow().getDecorView().getSystemUiVisibility();
            vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            vis |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
            getWindow().getDecorView().setSystemUiVisibility(vis);
        }
    }

    public void logout() {
        IMKitAgent.logout(new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onError(String module, int errCode, String errMsg) {

            }
        });
        IMKitAgent.unInit();
        WemeetSdkHelper.logout();
        UserApi.instance().clear();
        Intent intent = new Intent();
        intent.setClassName(this.getApplicationContext(), "com.work.mw.activity.LoginActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onResult(RequestWork req, ResponseWork resp) throws Exception {
        super.onResult(req, resp);
        if (!resp.isSuccess()
                && resp instanceof BaseResp
                && ((BaseResp) resp).getCode() == 501) {//登录失效
            ToastUtil.info(this, "登录已失效，请重新登录。");
            logout();
        }
    }
}
