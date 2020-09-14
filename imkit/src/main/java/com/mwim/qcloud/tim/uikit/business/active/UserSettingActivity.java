package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Intent;
import android.view.View;

import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.business.dialog.ConfirmDialog;

/**
 * Created by tangyx
 * Date 2020/9/14
 * email tangyx@live.com
 */

public class UserSettingActivity extends BaseActivity implements View.OnClickListener {
    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        findViewById(R.id.update_pwd).setOnClickListener(this);
        findViewById(R.id.logout).setOnClickListener(this);
    }

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        setTitleName(R.string.modify_setting);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.update_pwd) {
            startActivity(new Intent(this,UpdatePwdActivity.class));
        }else if(view.getId() == R.id.logout){
            new ConfirmDialog().setContent(R.string.dialog_logout).setOnConfirmListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    logout();
                }
            }).show(getSupportFragmentManager(),"logout");
        }
    }
}
