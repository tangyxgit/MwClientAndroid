package com.mwim.qcloud.tim.uikit.business.message;

import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;

/**
 * 自定义消息的bean实体，用来与json的相互转化
 */
public class CustomHelloMessage {
    public String businessID = TUIKitConstants.BUSINESS_ID_CUSTOM_HELLO;
    public String text = "欢迎加入云通信IM大家庭！";
    public String link = "https://cloud.tencent.com/document/product/269/3794";

    public int version = TUIKitConstants.JSON_VERSION_UNKNOWN;
}
