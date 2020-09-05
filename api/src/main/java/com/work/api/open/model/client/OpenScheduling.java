package com.work.api.open.model.client;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/4/30
 * Description
 */

public class OpenScheduling extends OpenApplyFor {

    /**
     * orderType : 出差
     * vehicleName :
     * week :
     * endIsDel :
     * endDate : 2019-05-05
     * driverIsDel :
     * remark :
     * contactsName : 林
     * endStop : 好
     * startStop : 浙江省杭州市余杭区高顺路
     * travelType :
     * isDeleted : 1
     * endId :
     * vehicleCap :
     * contactsId : 367d9846650
     * vehicleModel :
     * startTime : 12:02
     * vehicleId :
     * id : 2a8f438a9d50
     * schedulingStatus : 1
     * contactsIsDel : 1
     * driverMessage :
     * plateNo :
     * stopType :
     * customerName : 管理员
     * schedulingType : 4
     * contactsPhone : 15257180594
     * driverId :
     * isGrab : 1
     * startId :
     * vehicleIsDel :
     * closed : 0
     * counted : 0
     * driverPhone :
     * driverName :
     * startIsDel :
     * endTime :
     * startDate : 2019-05-05
     */
    private String cityName;
    private String cityId;
    private String orderType;
    private String orderTypeId;
    private String schAssignTypeName;
    private String schAssignType;
    private String driverVehicleType;
    private String vehicleName;
    private String week;
    private String endIsDel;
    private String endDate;
    private String driverIsDel;
    private String remark;
    private String contactsName;
    private String endStop;
    private String startStop;
    private String travelType;
    private String isDeleted;
    private String endId;
    private String vehicleCap;
    private String contactsId;
    private String vehicleModel;
    private String startTime;
    private String vehicleId;
    private int schedulingStatus;
    private String contactsIsDel;
    private String driverMessage;
    private String plateNo;
    private String stopType;
    private String customerName;
    private int schedulingType;
    private String contactsPhone;
    private String driverId;
    private int isGrab;
    private String startId;
    private String vehicleIsDel;
    private String closed;
    private String counted;
    private String driverPhone;
    private String driverName;
    private String startIsDel;
    private String endTime;
    private String startDate;
    private String routeName;
    private String mileage;
    private String settlementName;
    private String jobFee;
    private String driverFee;
    private String noticeName;
    private String noticeId;
    private OpenExtend extend;
    private int isConflict;
    private String star;
    private String content;
    private String countryCode;
    private String countryNumber;
    private String countryName;
    private String contactsAddress;

    public String getContactsAddress() {
        return contactsAddress;
    }

    public void setContactsAddress(String contactsAddress) {
        this.contactsAddress = contactsAddress;
    }

    public String getSchAssignTypeName() {
        return schAssignTypeName;
    }

    public void setSchAssignTypeName(String schAssignTypeName) {
        this.schAssignTypeName = schAssignTypeName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getDriverVehicleType() {
        return driverVehicleType;
    }

    public void setDriverVehicleType(String driverVehicleType) {
        this.driverVehicleType = driverVehicleType;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsConflict() {
        return isConflict;
    }

    public void setIsConflict(int isConflict) {
        this.isConflict = isConflict;
    }

    private HashMap<String, List<OpenScheduling>> schedulings;
    private List<OpenDriver> sons;

    public OpenExtend getExtend() {
        return extend;
    }

    public void setExtend(OpenExtend extend) {
        this.extend = extend;
    }

    public String getDriverFee() {
        return driverFee;
    }

    public void setDriverFee(String driverFee) {
        this.driverFee = driverFee;
    }

    public String getJobFee() {
        return jobFee;
    }

    public void setJobFee(String jobFee) {
        this.jobFee = jobFee;
    }

    public List<OpenDriver> getSons() {
        return sons;
    }

    public String getSettlementName() {
        return settlementName;
    }

    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public void setSons(List<OpenDriver> sons) {
        this.sons = sons;
    }

    public void setSchedulings(HashMap<String, List<OpenScheduling>> schedulings) {
        this.schedulings = schedulings;
    }

    public HashMap<String, List<OpenScheduling>> getSchedulings() {
        return schedulings;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getSchAssignType() {
        return schAssignType;
    }

    public void setSchAssignType(String schAssignType) {
        this.schAssignType = schAssignType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getEndIsDel() {
        return endIsDel;
    }

    public void setEndIsDel(String endIsDel) {
        this.endIsDel = endIsDel;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDriverIsDel() {
        return driverIsDel;
    }

    public void setDriverIsDel(String driverIsDel) {
        this.driverIsDel = driverIsDel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getEndStop() {
        return endStop;
    }

    public void setEndStop(String endStop) {
        this.endStop = endStop;
    }

    public String getStartStop() {
        return startStop;
    }

    public void setStartStop(String startStop) {
        this.startStop = startStop;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEndId() {
        return endId;
    }

    public void setEndId(String endId) {
        this.endId = endId;
    }

    public String getVehicleCap() {
        return vehicleCap;
    }

    public void setVehicleCap(String vehicleCap) {
        this.vehicleCap = vehicleCap;
    }

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getSchedulingStatus() {
        return schedulingStatus;
    }

    public void setSchedulingStatus(int schedulingStatus) {
        this.schedulingStatus = schedulingStatus;
    }

    public String getContactsIsDel() {
        return contactsIsDel;
    }

    public void setContactsIsDel(String contactsIsDel) {
        this.contactsIsDel = contactsIsDel;
    }

    public String getDriverMessage() {
        return driverMessage;
    }

    public void setDriverMessage(String driverMessage) {
        this.driverMessage = driverMessage;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSchedulingType() {
        return schedulingType;
    }

    public void setSchedulingType(int schedulingType) {
        this.schedulingType = schedulingType;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getIsGrab() {
        return isGrab;
    }

    public void setIsGrab(int isGrab) {
        this.isGrab = isGrab;
    }

    public String getStartId() {
        return startId;
    }

    public void setStartId(String startId) {
        this.startId = startId;
    }

    public String getVehicleIsDel() {
        return vehicleIsDel;
    }

    public void setVehicleIsDel(String vehicleIsDel) {
        this.vehicleIsDel = vehicleIsDel;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getCounted() {
        return counted;
    }

    public void setCounted(String counted) {
        this.counted = counted;
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

    public String getStartIsDel() {
        return startIsDel;
    }

    public void setStartIsDel(String startIsDel) {
        this.startIsDel = startIsDel;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
}
