package com.work.api.open.model.client;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/6/5
 * email tangyx@live.com
 */

public class OpenGroupNode extends OpenVehicle {
    private String id;
    private String total;
    private String name;
    private List<OpenVehicle> lngLat;
    private List<OpenGroupNode> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OpenVehicle> getLngLat() {
        return lngLat;
    }

    public void setLngLat(List<OpenVehicle> lngLat) {
        this.lngLat = lngLat;
    }

    public List<OpenGroupNode> getChildren() {
        return children;
    }

    public void setChildren(List<OpenGroupNode> children) {
        this.children = children;
    }
}
