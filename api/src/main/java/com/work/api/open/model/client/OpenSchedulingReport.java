package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/4/19
 * Description
 */

public class OpenSchedulingReport extends ClientModel {

    /**
     * total : 0
     * noNotice : 0
     * name : 2019-04-19
     * executed : 0
     * noDriver : 0
     */

    private String total;
    private String noNotice;
    private String name;
    private String executed;
    private String noDriver;
    private String unExecuted;

    public String getUnExecuted() {
        return unExecuted;
    }

    public void setUnExecuted(String unExecuted) {
        this.unExecuted = unExecuted;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNoNotice() {
        return noNotice;
    }

    public void setNoNotice(String noNotice) {
        this.noNotice = noNotice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExecuted() {
        return executed;
    }

    public void setExecuted(String executed) {
        this.executed = executed;
    }

    public String getNoDriver() {
        return noDriver;
    }

    public void setNoDriver(String noDriver) {
        this.noDriver = noDriver;
    }
}
