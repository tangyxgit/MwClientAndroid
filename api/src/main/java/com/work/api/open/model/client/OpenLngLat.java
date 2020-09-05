package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/5/16
 * Description
 */

public class OpenLngLat extends ClientModel {

    /**
     * acceleration : 0
     * lng : 120.05828444444445
     * distance : 0
     * timeInterval : 0
     * stopType : 0
     * time : 2019-05-16 08:45:25
     * speed : 0
     * lat : 30.24505333333333
     * direction : 119
     * status : 7
     */

    private String acceleration;
    private double lng;
    private String distance;
    private long timeInterval;
    private int stopType;
    private String time;
    private int speed;
    private double lat;
    private String direction;
    private int status;
    private String address;
    private String reduceVolume1;
    private String addVolume1;

    public String getReduceVolume1() {
        return reduceVolume1;
    }

    public void setReduceVolume1(String reduceVolume1) {
        this.reduceVolume1 = reduceVolume1;
    }

    public String getAddVolume1() {
        return addVolume1;
    }

    public void setAddVolume1(String addVolume1) {
        this.addVolume1 = addVolume1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public long getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(long timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getStopType() {
        return stopType;
    }

    public void setStopType(int stopType) {
        this.stopType = stopType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
