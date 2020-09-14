package com.mwim.qcloud.tim.uikit.business.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.http.network.listener.OnResultDataListener;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.business.active.UserInfoActivity;
import com.mwim.qcloud.tim.uikit.business.active.UserSettingActivity;
import com.mwim.qcloud.tim.uikit.business.modal.UserApi;
import com.mwim.qcloud.tim.uikit.component.LineControllerView;
import com.mwim.qcloud.tim.uikit.component.TitleBarLayout;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.work.api.open.Yz;
import com.work.api.open.model.LoginResp;
import com.work.api.open.model.client.OpenData;
import com.work.util.SLog;
import com.work.util.StringUtils;

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
        TitleBarLayout mTitleBar = findViewById(R.id.self_info_title_bar);
        mTitleBar.setBackgroundColor(Color.WHITE);
        mTitleBar.getLeftGroup().setVisibility(GONE);
        mTitleBar.getRightGroup().setVisibility(GONE);
        mTitleBar.setTitle(getResources().getString(R.string.profile), TitleBarLayout.POSITION.MIDDLE);

        findViewById(R.id.user_layout).setOnClickListener(this);
        mDepartment = findViewById(R.id.modify_department);
        mPosition = findViewById(R.id.modify_position);
        mCard = findViewById(R.id.modify_card);
        mEmail = findViewById(R.id.modify_email);
        LineControllerView mModifySettingView = findViewById(R.id.modify_setting);
        mModifySettingView.setCanNav(true);
        mModifySettingView.setOnClickListener(this);
        updateProfile();
        Yz.getSession().getUserByUserId(new OnResultDataListener() {
            @Override
            public void onResult(RequestWork req, ResponseWork resp) {
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
        if(v.getId() == R.id.user_layout){
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
            GlideEngine.loadCornerImage(mUserIcon, mIconUrl,null,10);
        }else{
            GlideEngine.loadImage(mUserIcon, R.drawable.default_head);
        }
        // 昵称
        String nickName = userApi.getNickName();
        //手机号
        String phone = userApi.getMobile();
        mNickname.setText(TextUtils.isEmpty(nickName)?phone:nickName);
        mSubMessage.setText(StringUtils.hideStr(phone));
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
