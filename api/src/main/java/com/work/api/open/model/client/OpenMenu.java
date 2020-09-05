package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/6/17
 * email tangyx@live.com
 */

public class OpenMenu extends ClientModel {
    private int no;
    private List<OpenMenu> subMenus;

    /**
     * no : 1001
     * icon : https://oss.cheoa.cn/202006/17/10012222.png
     * isSelected : 1
     * name : 车辆管理
     * permission : 0
     * id : 8be72f8ae
     * userId : 2effe81feb6e
     * url : com.cheoa.admin.activity.VehicleActivity
     * icon2 :
     */
    private String icon;
    private int isSelected;
    private String name;
    private int permission;
    private String id;
    private String userId;
    private String url;
    private String icon2;
    private int count;
    private boolean remind;

    public boolean getRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<OpenMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<OpenMenu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }
}
