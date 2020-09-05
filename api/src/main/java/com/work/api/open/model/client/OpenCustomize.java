package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/5/6
 * Description
 */

public class OpenCustomize extends ClientModel {

    /**
     * extend :
     * listValue :
     * showDriver : 2
     * contactsEdit : 2
     * showContacts : 2
     * driverEdit : 2
     * name : 人数
     * remark :
     * id : fe2506c783
     * type : 2
     */

    private String extend;
    private String listValue;
    private int showDriver;
    private int contactsEdit;
    private int showContacts;
    private int driverEdit;
    private String name;
    private String remark;
    private String id;
    private int type;
    private String value;
    private int isRequired;
    private String managerPos="";

    public String getManagerPos() {
        return managerPos;
    }

    public void setManagerPos(String managerPos) {
        this.managerPos = managerPos;
    }

    public int getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(int isRequired) {
        this.isRequired = isRequired;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public int getShowDriver() {
        return showDriver;
    }

    public void setShowDriver(int showDriver) {
        this.showDriver = showDriver;
    }

    public int getContactsEdit() {
        return contactsEdit;
    }

    public void setContactsEdit(int contactsEdit) {
        this.contactsEdit = contactsEdit;
    }

    public int getShowContacts() {
        return showContacts;
    }

    public void setShowContacts(int showContacts) {
        this.showContacts = showContacts;
    }

    public int getDriverEdit() {
        return driverEdit;
    }

    public void setDriverEdit(int driverEdit) {
        this.driverEdit = driverEdit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
