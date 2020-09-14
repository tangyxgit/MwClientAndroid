package com.work.mw;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.work.api.open.ApiClient;
import com.work.mw.modal.UserApi;
import com.work.util.SharedUtils;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public class MwClientApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        onChannel();
        SharedUtils.init(this);
        MultiDex.install(this);
        IMKitAgent.init(this,"");
        IMKitAgent.registerPush();
        registerActivityLifecycleCallbacks(new StatisticActivityLifecycleCallback());
    }

    /**
     * 读取渠道号/版本号等信息
     */
    private void onChannel(){
        try {
            ApplicationInfo applicationInfo = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String channel = applicationInfo.metaData.getString("UMENG_CHANNEL");
            UserApi userApi = UserApi.instance();
            userApi.setStore(channel);
            //配置网络相关
            ApiClient.setApiConfig(new ApiClient.ApiConfig().setHostName(BuildConfig.HOST_NAME).setParamObj(userApi));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    static class StatisticActivityLifecycleCallback implements ActivityLifecycleCallbacks {


        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityStarted(Activity activity) {
            IMKitAgent.onActivityStarted();
        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {
            IMKitAgent.onActivityStopped();
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }
}
