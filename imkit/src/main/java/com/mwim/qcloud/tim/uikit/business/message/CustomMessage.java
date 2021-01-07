package com.mwim.qcloud.tim.uikit.business.message;

import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;

import java.io.Serializable;

/**
 * 自定义消息的bean实体，用来与json的相互转化
 */
public class CustomMessage implements Serializable {
    private String businessID = TUIKitConstants.BUSINESS_ID_CUSTOM_CARD;
    private String title = "元信IM生态工具元信IM生态工具元信IM生态工具元信IM生态工具元信IM生态工具";
    private String desc = "欢迎加入元信大家庭！欢迎加入元信大家庭！欢迎加入元信大家庭！欢迎加入元信大家庭！";
    private String link = "http://yzmsri.com/";
    private String logo = "https://yzkj-im.oss-cn-beijing.aliyuncs.com/user/16037885020911603788500745.png";

    public final int version = TUIKitConstants.version;

    public String getBusinessID() {
        return businessID;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
