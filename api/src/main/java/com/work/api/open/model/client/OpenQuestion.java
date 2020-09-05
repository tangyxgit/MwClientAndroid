package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/4/4
 * Description
 */

public class OpenQuestion extends ClientModel {

    private String id;
    private String title;
    /**
     * extend :
     * image :
     * remark :
     * content : 车队管家系统已经有超10000个车队在使用，车辆数达10万辆以上，并且基础功能模块完全免费。典型案例有：中国一汽、中国人寿、国家电投、中海油、中国中铁、中国移动、中国石油、中国国旅等等。我们非常注重代码质量，业务实现的代码量在10万+行，测试的代码（测试业务代码的正确性、可用性等）在20万+行（作为对比，西游记字数：86万字，行数在5万行以内）。更多咨询请联系客服：4000-961-926
     */

    private String extend;
    private String image;
    private String remark;
    private String content;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
