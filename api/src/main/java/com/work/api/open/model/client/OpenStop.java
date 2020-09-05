package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tangyx
 * Date 2020/5/18
 * email tangyx@live.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenStop extends OpenStickyData {

    /**
     * id : 15affc7e7526
     * stopName : 这么晚还
     * groupName : 全部分组
     * address :
     * remark :
     * extend :
     * lng :
     * lat :
     */

    private String id;
    private String stopName;
    private String groupName;
    private String address;
    private String remark;
    private String extend;
    private String lng;
    private String lat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String getSortName() {
        return stopName;
    }
}
