package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

public class OpenTask extends ClientModel {

    /**
     * templateName : 开会通知
     * gmtCreated : 2019-12-16 11:17:46
     * receiverType : 全部司机
     * receiverCount : 2
     * name : 开会啦
     * msgCount : 2
     * id : 1269d8547
     * templateId : a582fbc7
     * createName :
     * content : 全体司机请注意！请于2019-12-20，前往华立科技园区，进行关于吃饭时间的会议。
     */

    private String templateName;
    private String gmtCreated;
    private String receiverType;
    private String receiverCount;
    private String name;
    private String msgCount;
    private String id;
    private String templateId;
    private String createName;
    private String content;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getReceiverCount() {
        return receiverCount;
    }

    public void setReceiverCount(String receiverCount) {
        this.receiverCount = receiverCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(String msgCount) {
        this.msgCount = msgCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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
}
