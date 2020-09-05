package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

/**
 * Created by tangyx
 * Date 2020/8/4
 * email tangyx@live.com
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenOilCard extends ClientModel {

    /**
     * bindingType : 1
     * bindingObject : 林2
     * cardMoney : 99.00
     * curMoney : 99.00
     * cardType : 1
     * id : 1df32c2d2b
     * cardholder :
     * cardNumber : vgghj
     * groupCodeName : 北京公司
     */

    private String bindingType;
    private String bindingObject;
    private String cardMoney;
    private String curMoney;
    private String cardType;
    private String id;
    private String cardholder;
    private String carderPhone;
    private String cardNumber;
    private String groupCodeName;
    private String bindingId;
    private int type;
    private String remark;
    private String gmtModified;
    private String updateName;
    private String volume;
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    public String getBindingObject() {
        return bindingObject;
    }

    public void setBindingObject(String bindingObject) {
        this.bindingObject = bindingObject;
    }

    public String getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(String cardMoney) {
        this.cardMoney = cardMoney;
    }

    public String getCurMoney() {
        return curMoney;
    }

    public void setCurMoney(String curMoney) {
        this.curMoney = curMoney;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCarderPhone() {
        return carderPhone;
    }

    public void setCarderPhone(String carderPhone) {
        this.carderPhone = carderPhone;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getGroupCodeName() {
        return groupCodeName;
    }

    public void setGroupCodeName(String groupCodeName) {
        this.groupCodeName = groupCodeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
