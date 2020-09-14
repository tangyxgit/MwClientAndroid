package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

/**
 * Created by tangyx
 * Date 2020/9/13
 * email tangyx@live.com
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenData extends ClientModel {

    /**
     * userId : 93c97cd2f1ababc7b6b0c91277a12a13
     * userSign : eJwtjNsKgkAURf9lnsNmDmecRugpulBBF5PwMZpRD5WOZmFE-56oj2sv1v6y0zb03rZiAQOPs1HHZGxeU0LdLJRSqBFgIgf9NLeLc2RYIJBzBClR98Y2jirLAp-3XNOjJSG11koDwtBT2v665J7mTbYIj591dC4R5sVLRO5a7jcVLFezcZqZ*lDAzo*n7PcHtNoxAg__
     */

    private String userId;
    private String userSign;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }
}
