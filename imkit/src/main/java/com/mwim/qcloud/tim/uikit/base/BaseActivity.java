package com.mwim.qcloud.tim.uikit.base;

import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.mwim.qcloud.tim.uikit.R;
import com.workstation.android.BaseHomeActivity;

public class BaseActivity extends BaseHomeActivity {
    @Override
    public void setStatusBar() {
        super.setStatusBar();
        setStatusBar(ContextCompat.getColor(this,R.color.status_bar_color));
    }
    public void setStatusBar(int color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(color);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.navigation_bar_color));
            int vis = getWindow().getDecorView().getSystemUiVisibility();
            vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            vis |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
            getWindow().getDecorView().setSystemUiVisibility(vis);
        }
    }
}
