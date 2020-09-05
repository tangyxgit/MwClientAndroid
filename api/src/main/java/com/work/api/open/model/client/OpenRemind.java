package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/4/16
 * Description
 */

public class OpenRemind extends ClientModel {

    /**
     * extend :
     * period : 11
     * plateNo : 112233
     * needSms : 1
     * remark : 14275875
     * id : c68dacc1cb
     * nextDate : 2019-03-06
     * content : 保养0
     */
    private int type;
    private String extend;
    private String period;
    private String plateNo;
    private String vehicleId;
    private String driverId;
    private String driverName;
    private int needSms;
    private String remark;
    private String id;
    private String nextDate;
    private String content;
    private String name;
    private int dateConfig;
    private int mileage;
    private int totalTravel;
    private int intervalMileage;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getTotalTravel() {
        return totalTravel;
    }

    public void setTotalTravel(int totalTravel) {
        this.totalTravel = totalTravel;
    }

    public int getIntervalMileage() {
        return intervalMileage;
    }

    public void setIntervalMileage(int intervalMileage) {
        this.intervalMileage = intervalMileage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDateConfig() {
        return dateConfig;
    }

    public void setDateConfig(int dateConfig) {
        this.dateConfig = dateConfig;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getNeedSms() {
        return needSms;
    }

    public void setNeedSms(int needSms) {
        this.needSms = needSms;
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

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
