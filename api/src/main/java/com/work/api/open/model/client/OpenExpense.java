package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created by Administrator on 2019/4/17
 * Description
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenExpense extends OpenApplyFor {

    /**
     * date : 2019-04-10
     * vehicleName :
     * schedulingId : 285df9c40ee6
     * driverIsDel : 1
     * typeName : 订单支出
     * remark : 任务结束后自动生成
     * contactsName : 阿兰
     * inOut : 2
     * contactsId : 36a02073be6
     * vehicleModel : 3
     * payTo : 2
     * vehicleId : 24d3033e726
     * id : 4cdfc6a9f5a6
     * amount : 0.0
     * contactsIsDel : 1
     * plateNo : 测试车
     * settlementDate :
     * extend :
     * contactsPhone : 13831122318
     * driverId : 41a270737a6
     * settlementName :
     * vehicleIsDel : 1
     * driverPhone : 15257180594
     * typeId : 1a9c36a6
     * driverName : 1号司机
     * isSettled : 1
     */

    private String date;
    private String vehicleName;
    private String schedulingId;
    private String driverIsDel;
    private String typeName;
    private String remark;
    private String contactsName;
    private int inOut;
    private String contactsId;
    private String vehicleModel;
    private int payTo;
    private String vehicleId;
    private double amount;
    private String fuelAmount;
    private String contactsIsDel;
    private String plateNo;
    private String settlementDate;
    private String extend;
    private String contactsPhone;
    private String driverId;
    private String settlementName;
    private String vehicleIsDel;
    private String driverPhone;
    private String typeId;
    private String driverName;
    private int isSettled;
    private String content;
    private String travel;
    private String settleId;
    /**
     * total : -900.0
     * in : 200.0
     * out : 1100.0
     */

    private double total;
    private double in;
    private double out;
    private String cardNumber;
    private String cardType;
    private String oilCardId;

    public String getOilCardId() {
        return oilCardId;
    }

    public void setOilCardId(String oilCardId) {
        this.oilCardId = oilCardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getSettleId() {
        return settleId;
    }

    public void setSettleId(String settleId) {
        this.settleId = settleId;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getSchedulingId() {
        return schedulingId;
    }

    public void setSchedulingId(String schedulingId) {
        this.schedulingId = schedulingId;
    }

    public String getDriverIsDel() {
        return driverIsDel;
    }

    public void setDriverIsDel(String driverIsDel) {
        this.driverIsDel = driverIsDel;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public int getInOut() {
        return inOut;
    }

    public void setInOut(int inOut) {
        this.inOut = inOut;
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

    public int getPayTo() {
        return payTo;
    }

    public void setPayTo(int payTo) {
        this.payTo = payTo;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(String fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public String getContactsIsDel() {
        return contactsIsDel;
    }

    public void setContactsIsDel(String contactsIsDel) {
        this.contactsIsDel = contactsIsDel;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
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

    public String getSettlementName() {
        return settlementName;
    }

    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName;
    }

    public String getVehicleIsDel() {
        return vehicleIsDel;
    }

    public void setVehicleIsDel(String vehicleIsDel) {
        this.vehicleIsDel = vehicleIsDel;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(int isSettled) {
        this.isSettled = isSettled;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIn() {
        return in;
    }

    public void setIn(double in) {
        this.in = in;
    }

    public double getOut() {
        return out;
    }

    public void setOut(double out) {
        this.out = out;
    }
}
