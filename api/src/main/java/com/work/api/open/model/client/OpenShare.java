package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/5/15
 * Description
 */

public class OpenShare extends ClientModel {

    /**
     * path : pages/sharelocation/sharelocation
     * shareToken : 00389922F9A30D847ACDA739205FA885
     * url : https://wx.cheoa.cn/share/monitor?token=00389922F9A30D847ACDA739205FA885
     */

    private String path;
    private String shareToken;
    private String url;
    private String title;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getShareToken() {
        return shareToken;
    }

    public void setShareToken(String shareToken) {
        this.shareToken = shareToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
