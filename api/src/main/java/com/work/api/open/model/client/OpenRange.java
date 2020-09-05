package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by Administrator on 2019/5/16
 * Description
 */

public class OpenRange extends ClientModel {

    /**
     * vehicleName :
     * travelTime : 1056
     * plateNo : 测试车
     * maxSpeed : 55
     * avgSpeed : 17
     * driverId : ee77117c47b
     * vehicleCap :
     * vehicleModel : 3
     * driverPhone : 17774945523
     * driverName : 唐悠悠
     * vehicleId : 24d3036873b
     * totalDistance : 4982
     */

    private String vehicleName;
    private long travelTime;
    private String plateNo;
    private String maxSpeed;
    private String avgSpeed;
    private String driverId;
    private String vehicleCap;
    private String vehicleModel;
    private String driverPhone;
    private String driverName;
    private String vehicleId;
    private int totalDistance;
    private List<OpenLngLat> lngLats;

    public List<OpenLngLat> getLngLats() {
        return lngLats;
    }

    public void setLngLats(List<OpenLngLat> lngLats) {
        this.lngLats = lngLats;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getVehicleCap() {
        return vehicleCap;
    }

    public void setVehicleCap(String vehicleCap) {
        this.vehicleCap = vehicleCap;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }
}
