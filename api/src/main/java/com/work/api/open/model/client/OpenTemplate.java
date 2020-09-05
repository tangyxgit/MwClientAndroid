package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

public class OpenTemplate extends ClientModel {

    /**
     * fieldNO : 3
     * checkStatus : 2
     * gmtCreated : 2019-12-13 15:09:52
     * name : 开会通知
     * id : a5793db6
     * fields : ["time","address","content"]
     * createName :
     * content : 全体司机请注意！请于${time}，前往${address}，进行关于${content}的会议。
     */

    private String fieldNO;
    private int checkStatus;
    private String gmtCreated;
    private String name;
    private String id;
    private String createName;
    private String content;
    private List<String> fields;

    public String getFieldNO() {
        return fieldNO;
    }

    public void setFieldNO(String fieldNO) {
        this.fieldNO = fieldNO;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }
}
