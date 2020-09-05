package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

/**
 * Created by Administrator on 2019/4/15
 * Description
 */

public class OpenStickyData extends ClientModel {
    private String Py;
    private String sortName;
    private String sortLetter;

    public String getPy() {
        return Py;
    }

    public void setPy(String py) {
        Py = py;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortLetter() {
        return sortLetter;
    }

    public void setSortLetter(String sortLetter) {
        this.sortLetter = sortLetter;
    }
}
