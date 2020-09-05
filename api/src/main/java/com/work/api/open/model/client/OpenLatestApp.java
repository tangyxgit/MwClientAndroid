package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

public class OpenLatestApp extends ClientModel {
    /**
     * code : 325
     * appUrl : https://soft.cheoa.cn/online/admin/app-admin.apk
     * version : 3.2.5
     */

    private int code;
    private String appUrl;
    private String content;
    private String version;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
