package com.work.api.open.model.client;

import androidx.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

/**
 * Created by tangyx
 * Date 2019-10-08
 * email tangyx@live.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenGroup extends ClientModel {

    /**
     * id :
     * groupName : 全部分组
     * remark :
     * extend :
     * code : 65535
     */

    private String id;
    private String groupName;
    private String remark;
    private String extend;
    private int code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof OpenGroup){
            return ((OpenGroup) obj).getId().equals(id);
        }
        return super.equals(obj);
    }
}
