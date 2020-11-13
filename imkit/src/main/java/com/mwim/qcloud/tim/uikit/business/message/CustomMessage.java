package com.mwim.qcloud.tim.uikit.business.message;

import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;

import java.io.Serializable;

/**
 * 自定义消息的bean实体，用来与json的相互转化
 */
public class CustomMessage implements Serializable {
    public String businessID = TUIKitConstants.BUSINESS_ID_CUSTOM_CARD;
    public String title = "元信IM生态工具元信IM生态工具元信IM生态工具元信IM生态工具元信IM生态工具";
    public String desc = "欢迎加入元信大家庭！欢迎加入元信大家庭！欢迎加入元信大家庭！欢迎加入元信大家庭！";
    public String link = "http://yzmsri.com/";
    public String logo = "https://yzkj-im.oss-cn-beijing.aliyuncs.com/user/16037885020911603788500745.png";

    public int version = TUIKitConstants.version;


}
