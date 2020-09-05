package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

public class OpenNotice extends ClientModel {

    /**
     * extend :
     * checkStatus : 2
     * isDefault : true
     * noticeName : 无短信
     * remark : 无
     * id : 112dcaeb056
     */

    private String extend;
    private int checkStatus;
    private boolean isDefault;
    private String noticeName;
    private String remark;
    private String id;

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
