package com.work.mw;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.mwim.qcloud.tim.uikit.IMKitAgent;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public class MwClientApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        IMKitAgent.init(this,"");
        IMKitAgent.registerPush();
        registerActivityLifecycleCallbacks(new StatisticActivityLifecycleCallback());
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
