package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/7/2
 * email tangyx@live.com
 */

public class OpenCustomerTree extends ClientModel {

    private String customerName;
    private String id;
    private String parentId;
    private String parentName;
    private List<OpenCustomerTree> children;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<OpenCustomerTree> getChildren() {
        return children;
    }

    public void setChildren(List<OpenCustomerTree> children) {
        this.children = children;
    }
}
