package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

public class OpenCount extends ClientModel {
    private int leave;
    private int scheduling;
    private int expense;
    private int message;
    private int maintenance;

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public int getScheduling() {
        return scheduling;
    }

    public void setScheduling(int scheduling) {
        this.scheduling = scheduling;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }
}
