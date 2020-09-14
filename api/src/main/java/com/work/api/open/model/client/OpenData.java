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
    /**
     * id : 1305013785716416514
     * userIcon : null
     * companyId : jiangpeng00001
     * departmentId : jiangpeng00002
     * mobile : 17774942284
     * nickName : 汤
     * card : 1145882254
     * position : 工程师
     * email : null
     * password : 03179606eb45fd5bec307b2d6587c37e
     * longitude : null
     * dimension :
     * createTime : null
     * createId : null
     * lastModifyId : null
     * lastModifyTime : null
     * departName : 平台研发中心
     * companyName : 元知智能研究院
     */

    private long id;
    private String userIcon;
    private String companyId;
    private String departmentId;
    private String mobile;
    private String nickName;
    private String card;
    private String position;
    private String email;
    private String password;
    private String longitude;
    private String dimension;
    private String createTime;
    private String createId;
    private String lastModifyId;
    private String lastModifyTime;
    private String departName;
    private String companyName;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getLastModifyId() {
        return lastModifyId;
    }

    public void setLastModifyId(String lastModifyId) {
        this.lastModifyId = lastModifyId;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
