package com.work.api.open.model;

/**
 * Created by tangyx
 * Date 2020/11/18
 * email tangyx@live.com
 */

public class SysUserReq extends BaseReq {

    private String userId;
    private String userSign;

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
