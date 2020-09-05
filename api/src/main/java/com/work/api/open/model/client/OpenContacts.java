package com.work.api.open.model.client;

import androidx.annotation.Nullable;

/**
 * Created by Administrator on 2019/4/15
 * Description
 */

public class OpenContacts extends OpenStickyData {

    /**
     * extend :
     * groupName : 无分组
     * isBooking : 1
     * address :
     * phone : 13112200139
     * customerId : 2d970654f2e
     * remark :
     * invoice :
     * id : d64427375df
     * userName : 龙飞
     * contactsName : 龙飞
     * customerName : 龘飝公司
     */

    private String extend;
    private String groupName;
    private int isBooking;
    private String address;
    private String phone;
    private String customerId;
    private String remark;
    private String invoice;
    private String id;
    private String userName;
    private String contactsName;
    private String customerName;
    private String customerAddress;
    private String settlementName;
    private String settleId;
    private int isRegular;
    private int groupCode;
    private int canApprove;
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

    public String getSettlementName() {
        return settlementName;
    }

    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName;
    }

    public String getSettleId() {
        return settleId;
    }

    public void setSettleId(String settleId) {
        this.settleId = settleId;
    }

    public int getCanApprove() {
        return canApprove;
    }

    public void setCanApprove(int canApprove) {
        this.canApprove = canApprove;
    }

    public int getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(int groupCode) {
        this.groupCode = groupCode;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getIsRegular() {
        return isRegular;
    }

    public void setIsRegular(int isRegular) {
        this.isRegular = isRegular;
    }

    public String getCustomerAddress() {
        return customerAddress;
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

    public int getIsBooking() {
        return isBooking;
    }

    public void setIsBooking(int isBooking) {
        this.isBooking = isBooking;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String getSortName() {
        return customerName;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof OpenContacts){
            return ((OpenContacts) obj).getPhone().equals(getPhone());
        }
        return super.equals(obj);
    }
}
