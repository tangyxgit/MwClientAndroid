package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/9/1
 * email tangyx@live.com
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenOrder extends ClientModel {

    /**
     * gmtModified : 2020-09-01 11:03:02
     * invoiceId :
     * remark : 142427071627797
     * createPhone : 17774942284
     * companyName : 试用专用公司
     * orderStatus : 1
     * createName : 汤译祥
     * addressId :
     * invoiceStatus : 未开票
     * productId : 7a04c0697d
     * addressStr :
     * id : eb9bc589bd
     * amount : 0.1
     * categoryName : SCH
     * gmtCreated : 2020-09-01 10:58:07
     * orderNo : 2020090110580759087
     * wxcode : https://oss.cheoa.cn/applet/120318024.jpg
     * images : []
     * payType : 未知
     * quantity : 1.0
     * companyId : 1cf96b97d
     * productName : SCH
     * renewYear :
     */

    private String gmtModified;
    private String invoiceId;
    private String remark;
    private String createPhone;
    private String companyName;
    private int orderStatus;
    private String createName;
    private String addressId;
    private String invoiceStatus;
    private String productId;
    private String addressStr;
    private String id;
    private double amount;
    private String categoryName;
    private String gmtCreated;
    private String orderNo;
    private String wxcode;
    private String payType;
    private String quantity;
    private String companyId;
    private String productName;
    private String renewYear;
    private List<?> images;

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatePhone() {
        return createPhone;
    }

    public void setCreatePhone(String createPhone) {
        this.createPhone = createPhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWxcode() {
        return wxcode;
    }

    public void setWxcode(String wxcode) {
        this.wxcode = wxcode;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRenewYear() {
        return renewYear;
    }

    public void setRenewYear(String renewYear) {
        this.renewYear = renewYear;
    }

    public List<?> getImages() {
        return images;
    }

    public void setImages(List<?> images) {
        this.images = images;
    }
}
