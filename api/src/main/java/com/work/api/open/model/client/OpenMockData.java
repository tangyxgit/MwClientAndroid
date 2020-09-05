package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/6/9
 * email tangyx@live.com
 */

public class OpenMockData extends ClientModel {

    private List<OpenGroupNode> lngLats;

    public List<OpenGroupNode> getLngLats() {
        return lngLats;
    }
}
