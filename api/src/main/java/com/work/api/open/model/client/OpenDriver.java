package com.work.api.open.model.client;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import java.util.List;

/**
 * Created by Administrator on 2019/4/15
 * Description
 */

public class OpenDriver extends OpenStickyData {

    /**
     * vehicleName :
     * userStatus : 1
     * plateNo :
     * remark :
     * userName : 周东丽
     * extend :
     * groupName : 无分组
     * phone : 13728161313
     * vehicleCap :
     * vehicleModel :
     * userType : 4
     * vehicleId :
     * id : 5022045ee4d
     */

    private String vehicleName;
    private int userStatus;
    private String plateNo;
    private String remark;
    private String userName;
    private String extend;
    private String groupName;
    private String phone;
    private String vehicleCap;
    private String vehicleModel;
    private int userType;
    private String vehicleId;
    private String driverId;
    private String id;
    /**
     * licenseNo :
     * gmtModified : 2019-04-11 16:55:57
     * gmtCreated : 2018-05-14 14:27:50
     * idNo :
     * nickname :
     * email :
     * homeAddress :
     * groupCode : 0
     * dateOfJoin :
     * emergencyContact :
     * updateName : 车队管家测试
     * emergencyPhone :
     * createName : 试用专用
     */

    private String licenseNo;
    private String gmtModified;
    private String gmtCreated;
    private String idNo;
    private String nickname;
    private String email;
    private String homeAddress;
    private int groupCode;
    private String dateOfJoin;
    private String emergencyContact;
    private String updateName;
    private String emergencyPhone;
    private String createName;
    /**
     * driverPhone : 17774945523
     * driverName : 唐悠悠
     */

    private String driverPhone;
    private String driverName;
    private List<OpenScheduling> schedulings;
    private int schedulingStatus;
    private String isOnLeave;
    private String countryNumber;
    private String countryCode;
    private String shortNumber;

    public String getShortNumber() {
        return shortNumber;
    }

    public void setShortNumber(String shortNumber) {
        this.shortNumber = shortNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(String countryNumber) {
        this.countryNumber = countryNumber;
    }

    public String getIsOnLeave() {
        return isOnLeave;
    }

    public void setIsOnLeave(String isOnLeave) {
        this.isOnLeave = isOnLeave;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getSchedulingStatus() {
        return schedulingStatus;
    }

    public void setSchedulingStatus(int schedulingStatus) {
        this.schedulingStatus = schedulingStatus;
    }

    public List<OpenScheduling> getSchedulings() {
        return schedulings;
    }

    public void setSchedulings(List<OpenScheduling> schedulings) {
        this.schedulings = schedulings;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
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

    public String getVehicleCap() {
        return vehicleCap;
    }

    public void setVehicleCap(String vehicleCap) {
        this.vehicleCap = vehicleCap;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getSortName() {
        if(TextUtils.isEmpty(userName)){
            return driverName;
        }
        return userName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(int groupCode) {
        this.groupCode = groupCode;
    }

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof OpenDriver){
            return ((OpenDriver) obj).getPhone().equals(getPhone());
        }
        return super.equals(obj);
    }
}
