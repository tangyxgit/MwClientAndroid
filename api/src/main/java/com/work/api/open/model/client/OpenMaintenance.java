package com.work.api.open.model.client;

/**
 * Created by tangyx
 * Date 2019-10-15
 * email tangyx@live.com
 */
public class OpenMaintenance extends OpenApplyFor {

    private int maintenanceType;
    private String plateNo;
    private String amount;
    private String startDate;
    private String endDate;
    private String reason;
    private String days;
    /**
     * groupName : 默认分组
     * maintenanceType : 2
     * vehicleName :
     * date : 2019-12-07 15:38:45
     * maintenanceStatus : 1
     */

    private String groupName;
    private String vehicleName;
    private String date;
    private String maintenanceStatus;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(int maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }
}
