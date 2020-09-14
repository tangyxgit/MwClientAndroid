package com.work.mw.modal;

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
    private static UserApi INSTANCE;
    @JsonIgnore
    private String userId;
    @JsonIgnore
    private String userSign;
    private String phone;
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

    public static UserApi getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(UserApi INSTANCE) {
        UserApi.INSTANCE = INSTANCE;
    }

    public String getPhone() {
        if(TextUtils.isEmpty(phone)){
            phone = SharedUtils.getString(USER_PHONE);
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        SharedUtils.putData(USER_PHONE,phone);
    }
}
