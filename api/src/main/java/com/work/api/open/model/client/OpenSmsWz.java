package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

/**
 * Created by tangyx
 * Date 2020/4/3
 * email tangyx@live.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenSmsWz extends ClientModel {

    /**
     * date : 2020-04-03
     * amount : 0
     * balance : 0
     * companyType : 普通版
     * billingType : 消费
     * id : 870758b90ed
     * smsNo : 0
     */

    private String date;
    private String amount;
    private String balance;
    private String companyType;
    private String billingType;
    private String id;
    private String smsNo;
    /**
     * smsFailed : 0
     * wzCheck : 0
     * ttlSuccess : 0
     * sendSms : 0
     * sendTtl : 0
     * smsSuccess : 0
     * wzSuccess : 0
     * ttlFailed : 0
     * wzFailed : 0
     */

    private String smsFailed;
    private String wzCheck;
    private String ttlSuccess;
    private String sendSms;
    private String sendTtl;
    private String smsSuccess;
    private String wzSuccess;
    private String ttlFailed;
    private String wzFailed;
    /**
     * receiveTime : 2020-03-08 10:00:32
     * countryNumber : 86
     * phone : 18713375200
     * fee : 1
     * count : 1
     * content : 【车队管家】您好，贵公司爱车(浙A88888)今天有一项提醒，内容：保养，请及时处理。
     * sendTime : 2020-03-08 10:00:09
     * status : 发送成功
     */

    private String receiveTime;
    private String countryNumber;
    private String phone;
    private String phoneB;
    private String fee;
    private String count;
    private String content;
    private String sendTime;
    private String status;
    /**
     * seconds : 0
     * startTime :
     * endTime : 2020-02-10 12:38:31
     */

    private String seconds;
    private String startTime;
    private String endTime;
    /**
     * balance : 115
     * billingType : 3
     * gmtCreated : 2020-04-15 15:30:12
     * num : 2
     * companyName : 试用专用公司
     * nickname : 车队管家测试
     * remark :
     * type : 1
     */
    private String gmtCreated;
    private String num;
    private String companyName;
    private String nickname;
    private String remark;
    private int type;

    public String getPhoneB() {
        return phoneB;
    }

    public void setPhoneB(String phoneB) {
        this.phoneB = phoneB;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSmsNo() {
        return smsNo;
    }

    public void setSmsNo(String smsNo) {
        this.smsNo = smsNo;
    }

    public String getSmsFailed() {
        return smsFailed;
    }

    public void setSmsFailed(String smsFailed) {
        this.smsFailed = smsFailed;
    }

    public String getWzCheck() {
        return wzCheck;
    }

    public void setWzCheck(String wzCheck) {
        this.wzCheck = wzCheck;
    }

    public String getTtlSuccess() {
        return ttlSuccess;
    }

    public void setTtlSuccess(String ttlSuccess) {
        this.ttlSuccess = ttlSuccess;
    }

    public String getSendSms() {
        return sendSms;
    }

    public void setSendSms(String sendSms) {
        this.sendSms = sendSms;
    }

    public String getSendTtl() {
        return sendTtl;
    }

    public void setSendTtl(String sendTtl) {
        this.sendTtl = sendTtl;
    }

    public String getSmsSuccess() {
        return smsSuccess;
    }

    public void setSmsSuccess(String smsSuccess) {
        this.smsSuccess = smsSuccess;
    }

    public String getWzSuccess() {
        return wzSuccess;
    }

    public void setWzSuccess(String wzSuccess) {
        this.wzSuccess = wzSuccess;
    }

    public String getTtlFailed() {
        return ttlFailed;
    }

    public void setTtlFailed(String ttlFailed) {
        this.ttlFailed = ttlFailed;
    }

    public String getWzFailed() {
        return wzFailed;
    }

    public void setWzFailed(String wzFailed) {
        this.wzFailed = wzFailed;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(String countryNumber) {
        this.countryNumber = countryNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

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

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
