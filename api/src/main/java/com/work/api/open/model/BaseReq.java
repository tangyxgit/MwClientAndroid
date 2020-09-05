package com.work.api.open.model;

import com.http.network.model.RequestWork;
import com.work.api.open.BuildConfig;
/**
 * Created by tangyx on 16/6/15.
 *
 */
public class BaseReq extends RequestWork {

    public int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public String getVersion(){
        return BuildConfig.VERSION_NAME;
    }
}
