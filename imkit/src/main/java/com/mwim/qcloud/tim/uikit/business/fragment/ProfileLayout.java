package com.mwim.qcloud.tim.uikit.business.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.http.network.listener.OnResultDataListener;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.business.active.UserInfoActivity;
import com.mwim.qcloud.tim.uikit.business.active.UserSettingActivity;
import com.mwim.qcloud.tim.uikit.business.modal.UserApi;
import com.mwim.qcloud.tim.uikit.component.LineControllerView;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.work.api.open.Yz;
import com.work.api.open.model.LoginReq;
import com.work.api.open.model.LoginResp;
import com.work.api.open.model.client.OpenData;

public class ProfileLayout extends LinearLayout implements View.OnClickListener {

    private ImageView mUserIcon;
    private TextView mNickname;
    private TextView mSubMessage;

    private LineControllerView mDepartment;
    private LineControllerView mPosition;
    private LineControllerView mCard;
    private LineControllerView mEmail;

    public ProfileLayout(Context context) {
        super(context);
        init();
    }

    public ProfileLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProfileLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.profile_layout, this);
        mUserIcon = findViewById(R.id.self_icon);
        mNickname = findViewById(R.id.self_account);
        mSubMessage = findViewById(R.id.sub_message);
        ImageView mArrowRight = findViewById(R.id.arrow_right);
        mArrowRight.setColorFilter(ContextCompat.getColor(getContext(),R.color.white), PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.user_bg_layout).setOnClickListener(this);
        mDepartment = findViewById(R.id.modify_department);
        mDepartment.setLeftDrawable(R.drawable.icon_department_fill);
        mPosition = findViewById(R.id.modify_position);
        mPosition.setLeftDrawable(R.drawable.icon_position_fill);
        mCard = findViewById(R.id.modify_card);
        mCard.setLeftDrawable(R.drawable.icon_employee_id);
        mEmail = findViewById(R.id.modify_email);
        mEmail.setLeftDrawable(R.drawable.icon_mail_fill);
        LineControllerView mModifySettingView = findViewById(R.id.modify_setting);
        mModifySettingView.setCanNav(true);
        mModifySettingView.setOnClickListener(this);
        mModifySettingView.setLeftDrawable(R.drawable.icon_setting_fill);
        updateProfile();
        LoginReq loginReq = new LoginReq();
        loginReq.setUserId(UserApi.instance().getUserId());
        Yz.getSession().getUserByUserId(loginReq,new OnResultDataListener() {
            @Override
            public void onResult(RequestWork req, ResponseWork resp) throws Exception{
                if(getContext() instanceof BaseActivity){
                    ((BaseActivity) getContext()).onResult(req,resp);
                }
                if(resp.isSuccess() && resp instanceof LoginResp){
                    OpenData data = ((LoginResp) resp).getData();
                    UserApi userApi = UserApi.instance();
                    userApi.setNickName(data.getNickName());
                    userApi.setUserIcon(data.getUserIcon());
                    userApi.setMobile(data.getMobile());
                    userApi.setDepartment(data.getDepartName());
                    userApi.setPosition(data.getPosition());
                    userApi.setCard(data.getCard());
                    userApi.setEmail(data.getEmail());
                    updateProfile();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.user_bg_layout){
            getContext().startActivity(new Intent(getContext(), UserInfoActivity.class));
        }else if(v.getId() == R.id.modify_setting){
            getContext().startActivity(new Intent(getContext(), UserSettingActivity.class));
        }
    }

    public void updateProfile() {
        UserApi userApi = UserApi.instance();
        // 头像
        String mIconUrl = userApi.getUserIcon();
        if (!TextUtils.isEmpty(mIconUrl)) {
            GlideEngine.loadCornerAvatar(mUserIcon, mIconUrl);
        }else{
            GlideEngine.loadImage(mUserIcon, R.drawable.default_user_me);
        }
        // 昵称
        String nickName = userApi.getNickName();
        //手机号
        String phone = userApi.getMobile();
        mNickname.setText(TextUtils.isEmpty(nickName)?phone:nickName);
        mSubMessage.setText(phone);
        String contentDefault = getResources().getString(R.string.user_content_default);
        String email = userApi.getEmail();
        String department = userApi.getDepartment();
        String position = userApi.getPosition();
        String card = userApi.getCard();
        mDepartment.setContent(TextUtils.isEmpty(department)?contentDefault:department);
        mPosition.setContent(TextUtils.isEmpty(position)?contentDefault:position);
        mCard.setContent(TextUtils.isEmpty(card)?contentDefault:card);
        mEmail.setContent(TextUtils.isEmpty(email)?contentDefault:email);
    }

}
