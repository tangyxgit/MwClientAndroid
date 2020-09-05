package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/4/15
 * Description
 */

public class OpenMessage extends ClientModel {

    /**
     * extend :
     * msgType : GPS异常
     * gmtCreated : 2019-04-12 14:09:03
     * hasRead : 2
     * id : 7ad6d64fa43a
     * title : 【浙123456】GPS异常提醒
     */

    private String extend;
    private String msgType;
    private String gmtCreated;
    private int hasRead;
    private String id;
    private String title;
    /**
     * driverId :
     * remark :
     * vehicleId : 2efa960d07a
     * content : 贵公司的爱车【浙123456】GPS无信号或断电，请注意！
     */

    private String driverId;
    private String remark;
    private String vehicleId;
    private String content;
    private int position;

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public int getHasRead() {
        return hasRead;
    }

    public void setHasRead(int hasRead) {
        this.hasRead = hasRead;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
