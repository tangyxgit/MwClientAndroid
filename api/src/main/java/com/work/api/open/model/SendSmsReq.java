package com.work.api.open.model;

/**
 * Created by tangyx
 * Date 2020/9/13
 * email tangyx@live.com
 */

public class SendSmsReq extends BaseReq {

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
