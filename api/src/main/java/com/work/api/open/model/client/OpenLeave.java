package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tangyx
 * Date 2019-09-24
 * email tangyx@live.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLeave extends OpenApplyFor {

    /**
     * gmtModified : 2019-09-24 16:47:55
     * startDate : 2019-09-24
     * groupName : 全部分组
     * phone : 17774942284
     * reason :
     * endDate : 2019-09-24
     * date : 2019-09-24 15:59:52
     * createName : 汤译祥
     * id : 10de4b8acc
     * pic1 : https://oss.qicheoa.com/201909/24/155952831.jpg
     * leaveTypeName : 调休
     * gmtCreated : 2019-09-24 15:59:52
     * updateName : 汤译祥
     * days : 1
     * leaveTypeId : 4
     * leaveStatus : 1
     * userName : 汤译祥
     * pic2 : https://oss.qicheoa.com/201909/24/155953147.jpg
     */

    private String gmtModified;
    private String startDate;
    private String groupName;
    private String phone;
    private String reason;
    private String endDate;
    private String date;
    private String leaveTypeName;
    private String updateName;
    private String days;
    private String leaveTypeId;
    private int leaveStatus;
    private String userName;
    private String name;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public int getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(int leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
