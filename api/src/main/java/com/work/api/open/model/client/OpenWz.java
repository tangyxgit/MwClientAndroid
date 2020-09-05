package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/4/17
 * email tangyx@live.com
 */
public class OpenWz extends ClientModel {

    private String total;
    private List<OpenSmsWz> items;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<OpenSmsWz> getItems() {
        return items;
    }

    public void setItems(List<OpenSmsWz> items) {
        this.items = items;
    }
}
