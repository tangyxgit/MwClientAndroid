package com.work.api.open.model.client;

import java.util.List;

/**
 * Created by Administrator on 2019/4/3
 * Description
 */

public class OpenVehicle extends OpenStickyData {

    /**
     * vehicleName : 1
     * address : 浙江省杭州市余杭区五常街道五常大道103号
     * lng : 120.0209688888889
     * distance :
     * city : 杭州市
     * plateNo : 浙123456
     * companyName : 试用专用公司
     * speed : 4
     * acceleration :
     * citycode : 0571
     * driverId : 95a4b74bde6
     * vehicleCap :
     * gpsStatus : 3
     * vehicleModel :
     * imei : 0868120183890588
     * driverPhone : 13157137012
     * driverName : 测试1
     * vehicleId : 2efa95f36d6
     * validity : 2019-08-10
     * time : 2019-03-27 09:33:01
     * lat : 30.246264444444442
     * oilStatus : 0
     * direction : 131
     * status : 53
     */
    private String id;
    private String vehicleName;
    private String address;
    private double lng;
    private String distance;
    private String city;
    private String plateNo;
    private String companyName;
    private String speed;
    private String acceleration;
    private String citycode;
    private String driverId;
    private String vehicleCap;
    private int gpsStatus;
    private String vehicleModel;
    private String imei;
    private String stopLimit;
    private String degreeMin;
    private String degreeMax;
    private String driverPhone;
    private String driverName;
    private String vehicleId;
    private String validity;
    private String time;
    private String statusTime;
    private double lat;
    private int oilStatus;
    private int direction;
    private String status;
    /**
     * gmtModified : 2018-12-19 18:42:36
     * maintenanceInterval :
     * gmtCreated : 2018-05-03 10:10:08
     * remark :
     * capacity :
     * operatingLicense :
     * pic1 :
     * vin :
     * pic2 :
     * pic3 :
     * vehicleType : 1
     * fatigueLimit :
     * engineNo :
     * speedLimit :
     * updateName : 车队管家测试
     * extend :
     * dateOfPurchase :
     * oilType :
     * drivingLicense :
     * createName : 试用专用
     * vehicleStatus : 1
     */

    private String gmtModified;
    private String maintenanceInterval;
    private String gmtCreated;
    private String remark;
    private String capacity;
    private String operatingLicense;
    private String pic1;
    private String vin;
    private String pic2;
    private String pic3;
    private int vehicleType;
    private String fatigueLimit;
    private String engineNo;
    private String speedLimit;
    private String updateName;
    private String extend;
    private String dateOfPurchase;
    private String oilType;
    private String drivingLicense;
    private String createName;
    private int vehicleStatus;
    private List<OpenScheduling> schedulings;
    private int groupCode;
    private String totalTravel;
    private String initMiles;
    private String vioType;
    private String isOnMaintenance;
    private int isDoing;
    private String schedulingId;
    private String schContent;
    private int imeiDeviceType;
    private String countryCode;
    private String countryNumber;
    private String countryName;
    private String vehicleIcon;
    private String acc;
    private String accTime;
    private String voltage;
    private String parentId;
    private String parentName;
    private String oilVolume;
    private String degree1;
    private int isRestriction;

    public int getIsRestriction() {
        return isRestriction;
    }

    public void setIsRestriction(int isRestriction) {
        this.isRestriction = isRestriction;
    }

    public String getDegree1() {
        return degree1;
    }

    public void setDegree1(String degree1) {
        this.degree1 = degree1;
    }

    public String getOilVolume() {
        return oilVolume;
    }

    public void setOilVolume(String oilVolume) {
        this.oilVolume = oilVolume;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getAccTime() {
        return accTime;
    }

    public void setAccTime(String accTime) {
        this.accTime = accTime;
    }

    public String getVehicleIcon() {
        return vehicleIcon;
    }

    public void setVehicleIcon(String vehicleIcon) {
        this.vehicleIcon = vehicleIcon;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public void setImeiDeviceType(int imeiDeviceType) {
        this.imeiDeviceType = imeiDeviceType;
    }

    public int getImeiDeviceType() {
        return imeiDeviceType;
    }

    public String getSchContent() {
        return schContent;
    }

    public void setSchContent(String schContent) {
        this.schContent = schContent;
    }

    public String getSchedulingId() {
        return schedulingId;
    }

    public void setSchedulingId(String schedulingId) {
        this.schedulingId = schedulingId;
    }

    public int getIsDoing() {
        return isDoing;
    }

    public void setIsDoing(int isDoing) {
        this.isDoing = isDoing;
    }

    public String getIsOnMaintenance() {
        return isOnMaintenance;
    }

    public void setIsOnMaintenance(String isOnMaintenance) {
        this.isOnMaintenance = isOnMaintenance;
    }

    public String getStopLimit() {
        return stopLimit;
    }

    public void setStopLimit(String stopLimit) {
        this.stopLimit = stopLimit;
    }

    public String getDegreeMin() {
        return degreeMin;
    }

    public void setDegreeMin(String degreeMin) {
        this.degreeMin = degreeMin;
    }

    public String getDegreeMax() {
        return degreeMax;
    }

    public void setDegreeMax(String degreeMax) {
        this.degreeMax = degreeMax;
    }

    public String getVioType() {
        return vioType;
    }

    public void setVioType(String vioType) {
        this.vioType = vioType;
    }

    public void setGroupCode(int groupCode) {
        this.groupCode = groupCode;
    }

    public String getTotalTravel() {
        return totalTravel;
    }

    public void setTotalTravel(String totalTravel) {
        this.totalTravel = totalTravel;
    }

    public String getInitMiles() {
        return initMiles;
    }

    public void setInitMiles(String initMiles) {
        this.initMiles = initMiles;
    }

    public int getGroupCode() {
        return groupCode;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    public List<OpenScheduling> getSchedulings() {
        return schedulings;
    }

    public void setSchedulings(List<OpenScheduling> schedulings) {
        this.schedulings = schedulings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getVehicleCap() {
        return vehicleCap;
    }

    public void setVehicleCap(String vehicleCap) {
        this.vehicleCap = vehicleCap;
    }

    public int getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(int gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getOilStatus() {
        return oilStatus;
    }

    public void setOilStatus(int oilStatus) {
        this.oilStatus = oilStatus;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getSortName() {
        return plateNo;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getMaintenanceInterval() {
        return maintenanceInterval;
    }

    public void setMaintenanceInterval(String maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getOperatingLicense() {
        return operatingLicense;
    }

    public void setOperatingLicense(String operatingLicense) {
        this.operatingLicense = operatingLicense;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFatigueLimit() {
        return fatigueLimit;
    }

    public void setFatigueLimit(String fatigueLimit) {
        this.fatigueLimit = fatigueLimit;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(String speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public int getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(int vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

}
