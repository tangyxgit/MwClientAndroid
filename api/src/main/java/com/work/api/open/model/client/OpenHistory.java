package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

/**
 * Created by tangyx
 * Date 2019/5/10
 * email tangyx@live.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenHistory extends ClientModel {

    /**
     * gmtCreated : 2019-05-10 23:20:37
     * remark :
     * userType : 管理员
     * id : bd6f517586e6
     * userName : 汤译祥
     * content : 更新排班
     */

    private String gmtCreated;
    private String remark;
    private String userType;
    private String id;
    private String userName;
    private String content;

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
