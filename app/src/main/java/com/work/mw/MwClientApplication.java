package com.work.mw;

import android.app.Application;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.business.StatisticActivityLifecycleCallback;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public class MwClientApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        IMKitAgent.init(this,"");
//        if (BrandUtil.isBrandXiaoMi()) {
//            // 小米离线推送
//            MiPushClient.registerPush(this, PrivateConstants.XM_PUSH_APPID, PrivateConstants.XM_PUSH_APPKEY);
//        } else if (BrandUtil.isBrandHuawei()) {
//            // 华为离线推送，设置是否接收Push通知栏消息调用示例
//            HmsMessaging.getInstance(this).turnOnPush().addOnCompleteListener(new com.huawei.hmf.tasks.OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(com.huawei.hmf.tasks.Task<Void> task) {
//                    if (task.isSuccessful()) {
//                        DemoLog.i(TAG, "huawei turnOnPush Complete");
//                    } else {
//                        DemoLog.e(TAG, "huawei turnOnPush failed: ret=" + task.getException().getMessage());
//                    }
//                }
//            });
//        } else if (MzSystemUtils.isBrandMeizu(this)) {
//            // 魅族离线推送
//            PushManager.register(this, PrivateConstants.MZ_PUSH_APPID, PrivateConstants.MZ_PUSH_APPKEY);
//        } else if (BrandUtil.isBrandVivo()) {
//            // vivo离线推送
//            PushClient.getInstance(getApplicationContext()).initialize();
//        } else if (HeytapPushManager.isSupportPush()) {
//            // oppo离线推送，因为需要登录成功后向我们后台设置token，所以注册放在MainActivity中做
//        }

        registerActivityLifecycleCallbacks(new StatisticActivityLifecycleCallback());
    }
}
