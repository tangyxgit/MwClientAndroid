package com.mwim.qcloud.tim.uikit.business.modal;

import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.work.util.SharedUtils;

/**
 * Created by Administrator on 2019/3/25
 * Description
 */

public class UserApi {
    private final static String USER_SIGN="userSign";
    private final static String USER_PHONE="userPhone";
    private final static String USER_ID="userId";
    private final static String USER_ICON="userIcon";
    private final static String USER_NAME="nickName";
    private final static String USER_CARD="userCard";
    private final static String USER_POSITION="userPosition";
    private final static String USER_EMAIL="userEmailKey";
    private final static String USER_DEPARTMENT="userDepartment";
    private static UserApi INSTANCE;
    private String userId;
    @JsonIgnore
    private String userSign;
    @JsonIgnore
    private String userIcon;
    @JsonIgnore
    private String nickName;
    @JsonIgnore
    private String card;
    @JsonIgnore
    private String position;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String department;

    private String mobile;
    private String token;
    private String store;
    private String version;

    public static UserApi instance(){
        return INSTANCE==null?INSTANCE = new UserApi():INSTANCE;
    }

    private UserApi() {
    }

    public String getUserId() {
        if(TextUtils.isEmpty(userId)){
            userId = SharedUtils.getString(USER_ID);
        }
        return userId;
    }

    public void setUserId(String userId) {
        SharedUtils.putData(USER_ID,userId);
        this.userId = userId;
    }

    public String getUserSign() {
        if(TextUtils.isEmpty(userSign)){
            userSign = SharedUtils.getString(USER_SIGN);
        }
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
        SharedUtils.putData(USER_SIGN,userSign);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getMobile() {
        if(TextUtils.isEmpty(mobile)){
            mobile = SharedUtils.getString(USER_PHONE);
        }
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
        SharedUtils.putData(USER_PHONE, mobile);
    }

    public String getUserIcon() {
        if(TextUtils.isEmpty(userIcon)){
            userIcon = SharedUtils.getString(USER_ICON);
        }
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
        SharedUtils.putData(USER_ICON,userIcon);
    }

    public String getNickName() {
        if(TextUtils.isEmpty(nickName)){
            nickName = SharedUtils.getString(USER_NAME);
        }
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
        SharedUtils.putData(USER_NAME,nickName);
    }

    public String getCard() {
        if(TextUtils.isEmpty(card)){
            card = SharedUtils.getString(USER_CARD);
        }
        return card;
    }

    public void setCard(String card) {
        this.card = card;
        SharedUtils.putData(USER_CARD,card);
    }

    public String getPosition() {
        if(TextUtils.isEmpty(position)){
            position = SharedUtils.getString(USER_POSITION);
        }
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
        SharedUtils.putData(USER_POSITION,position);
    }

    public String getEmail() {
        if(TextUtils.isEmpty(email)){
            email = SharedUtils.getString(USER_EMAIL);
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        SharedUtils.putData(USER_EMAIL,email);
    }

    public String getDepartment() {
        if(TextUtils.isEmpty(department)){
            department = SharedUtils.getString(USER_DEPARTMENT);
        }
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
        SharedUtils.putData(USER_DEPARTMENT,USER_DEPARTMENT);
    }

    public void clear(){
        SharedUtils.removeData(USER_ID);
        SharedUtils.removeData(USER_SIGN);
    }
}
