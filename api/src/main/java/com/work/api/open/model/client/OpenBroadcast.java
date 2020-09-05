package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBroadcast extends ClientModel {

    /**
     * id : 15e1d6d2
     * gmtModified : 2019-12-01 11:00:00
     * startDate : 2019-12-01
     * gmtCreated : 2019-12-01 11:00:00
     * updateName :
     * remark : 1
     * endDate : 2020-12-01
     * createName :
     * url : http://www.cheoa.cn
     * htmlContent : 车队管理系统——车队管家用户数突破一万两千家！，详情看：<a href="http://www.cheoa.cn" target="_blank">链接</a> 谢谢
     */

    private String id;
    private String gmtModified;
    private String startDate;
    private String gmtCreated;
    private String updateName;
    private String remark;
    private String endDate;
    private String createName;
    private String url;
    private String htmlContent;
    /**
     * userType : 1
     */

    private String userType;
    private String jetTime;

    public String getJetTime() {
        return jetTime;
    }

    public void setJetTime(String jetTime) {
        this.jetTime = jetTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
