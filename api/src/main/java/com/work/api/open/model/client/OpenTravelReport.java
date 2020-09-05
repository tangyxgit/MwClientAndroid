package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/4/22
 * Description
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenTravelReport extends ClientModel {

    /**
     * travelTime : 3434
     * name : 2019-04-01
     * maxSpeed : 58
     * avgSpeed : 21
     * mileage : 20266
     */

    private long travelTime;
    private String name;
    private String maxSpeed;
    private String avgSpeed;
    private long mileage;
    private String avgFee;
    private String avgFuel;
    /**
     * date : 03月03日
     * vehicleName : 02F-白
     * plateNo : 浙A02FCD
     * start : 2020-03-03 09:09:03
     * travelType : 4
     * endName : 浙江省杭州市余杭区五常街道德强饭店(五常店)
     * stopTime : 36596
     * driverName : 林
     * driverPhone : 15257180594
     * end : 2020-03-03 19:18:59
     * startName : 浙江省杭州市余杭区五常街道德强饭店(五常店)
     */

    private String date;
    private String vehicleName;
    private String plateNo;
    private String start;
    private String travelType;
    private String endName;
    private long stopTime;
    private String driverName;
    private String driverPhone;
    private String end;
    private String startName;
    private long idleTime;

    public long getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(long idleTime) {
        this.idleTime = idleTime;
    }

    public String getAvgFee() {
        return avgFee;
    }

    public void setAvgFee(String avgFee) {
        this.avgFee = avgFee;
    }

    public String getAvgFuel() {
        return avgFuel;
    }

    public void setAvgFuel(String avgFuel) {
        this.avgFuel = avgFuel;
    }

    public long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }
}
