package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by Administrator on 2019/5/10
 * Description
 */

public class OpenExtend extends ClientModel {

    private List<OpenCustomize> customize;

    public List<OpenCustomize> getCustomize() {
        return customize;
    }

    public void setCustomize(List<OpenCustomize> customize) {
        this.customize = customize;
    }
}
