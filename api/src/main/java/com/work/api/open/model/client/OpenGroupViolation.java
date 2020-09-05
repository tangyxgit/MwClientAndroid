package com.work.api.open.model.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by tangyx
 * Date 2019-11-13
 * email tangyx@live.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenGroupViolation extends ClientModel {

    /**
     * plateNo : 浙A3003W
     * handled : 0
     * vehicleId : 521a4e50f58
     * notHandled : 2
     */
    private String total;
    private String plateNo;
    private String handled;
    private String vehicleId;
    private String notHandled;
    private String sumFen;
    private String sumMoney;

    public String getSumFen() {
        return sumFen;
    }

    public void setSumFen(String sumFen) {
        this.sumFen = sumFen;
    }

    public String getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(String sumMoney) {
        this.sumMoney = sumMoney;
    }

    private List<OpenViolation> violations;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getHandled() {
        return handled;
    }

    public void setHandled(String handled) {
        this.handled = handled;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getNotHandled() {
        return notHandled;
    }

    public void setNotHandled(String notHandled) {
        this.notHandled = notHandled;
    }

    public List<OpenViolation> getViolations() {
        return violations;
    }

    public void setViolations(List<OpenViolation> violations) {
        this.violations = violations;
    }
}
