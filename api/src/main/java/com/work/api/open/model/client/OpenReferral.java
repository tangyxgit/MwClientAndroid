package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by tangyx
 * Date 2020/3/11
 * email tangyx@live.com
 */
public class OpenReferral extends ClientModel {

    private String gmtCreated;
    private String referName;
    private String nickname;
    private String phone;

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getReferName() {
        return referName;
    }

    public void setReferName(String referName) {
        this.referName = referName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
