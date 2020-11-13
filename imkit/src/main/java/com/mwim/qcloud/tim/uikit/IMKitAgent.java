package com.mwim.qcloud.tim.uikit;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;

import com.huawei.hms.push.HmsMessaging;
import com.mwim.qcloud.tim.uikit.base.IMEventListener;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.business.helper.wemeet.RdmSDK;
import com.mwim.qcloud.tim.uikit.business.message.MessageNotification;
import com.mwim.qcloud.tim.uikit.business.thirdpush.HUAWEIHmsMessageService;
import com.mwim.qcloud.tim.uikit.business.thirdpush.OfflineMessageDispatcher;
import com.mwim.qcloud.tim.uikit.component.face.CustomFace;
import com.mwim.qcloud.tim.uikit.component.face.CustomFaceGroup;
import com.mwim.qcloud.tim.uikit.config.CustomFaceConfig;
import com.mwim.qcloud.tim.uikit.config.GeneralConfig;
import com.mwim.qcloud.tim.uikit.config.TUIKitConfigs;
import com.mwim.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.mwim.qcloud.tim.uikit.utils.BrandUtil;
import com.mwim.qcloud.tim.uikit.utils.PrivateConstants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tim.uikit.modules.chat.base.OfflineMessageBean;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.wemeet.sdk.app.AppGlobals;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.vivo.push.PushClient;
import com.work.util.AppUtils;
import com.work.util.SLog;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.io.File;
import java.util.HashMap;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public final class IMKitAgent {

    private static final int AppId = 1400432221;

    private static IMEventListener IMEventPushListener = new IMEventListener() {
        @Override
        public void onNewMessage(V2TIMMessage msg) {
            MessageNotification notification = MessageNotification.getInstance();
            notification.notify(msg);
        }
    };
    private static ConversationManagerKit.MessageUnreadWatcher UnreadWatcher = new ConversationManagerKit.MessageUnreadWatcher() {
        @Override
        public void updateUnread(int count) {
            // 华为离线推送角标
            HUAWEIHmsMessageService.updateBadge(instance(), count);
        }

        @Override
        public void updateContacts() {

        }

        @Override
        public void updateConversion() {

        }
    };
    private static Context instance;

    public static Context instance(){
        return instance;
    }

    public static void init(Application context,String appKey){
        instance = context;
        UMConfigure.init(context, "5f8d583980455950e4af10d9", "Yz", UMConfigure.DEVICE_TYPE_PHONE, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        TUIKit.init(context,AppId,getConfigs(context));
        HashMap<String,Object> map = new HashMap<>();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
        QbSdk.setDownloadWithoutWifi(true);
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {
                SLog.e("x5 web init:"+b);
            }
        };
        QbSdk.initX5Environment(context,cb);
        //腾讯会议
        AppGlobals.INSTANCE.init(context);
        RdmSDK.INSTANCE.init(context);
    };
    private static TUIKitConfigs getConfigs(Context context) {
        GeneralConfig config = new GeneralConfig();
        // 显示对方是否已读的view将会展示
        config.setShowRead(true);
        config.setAppCacheDir(context.getFilesDir().getPath());
        if (new File(Environment.getExternalStorageDirectory() + "/111222333").exists()) {
            config.setTestEnv(true);
        }
        TUIKit.getConfigs().setGeneralConfig(config);
//        TUIKit.getConfigs().setCustomFaceConfig(initCustomFaceConfig());
        return TUIKit.getConfigs();
    }

    public static Context getAppContext() {
        return TUIKitImpl.getAppContext();
    }

    private static CustomFaceConfig initCustomFaceConfig() {
        CustomFaceConfig config = new CustomFaceConfig();
        CustomFaceGroup faceConfigs_1 = new CustomFaceGroup();
        faceConfigs_1.setPageColumnCount(5);
        faceConfigs_1.setPageRowCount(2);
        faceConfigs_1.setFaceGroupId(1);
        faceConfigs_1.setFaceIconPath("4350/yz00@2x.png");
        faceConfigs_1.setFaceIconName("4350");
        for (int i = 0; i <= 17; i++) {
            CustomFace customFace = new CustomFace();
            String index = "" + i;
            if (i < 10)
                index = "0" + i;
            customFace.setAssetPath("4350/yz" + index + "@2x.png");
            customFace.setFaceName("yz" + index + "@2x");
            customFace.setFaceWidth(170);
            customFace.setFaceHeight(170);
            faceConfigs_1.addCustomFace(customFace);
        }
        config.addFaceGroup(faceConfigs_1);

        CustomFaceGroup faceConfigs_2 = new CustomFaceGroup();
        faceConfigs_2.setPageColumnCount(5);
        faceConfigs_2.setPageRowCount(2);
        faceConfigs_2.setFaceGroupId(2);
        faceConfigs_2.setFaceIconPath("4351/ys00@2x.png");
        faceConfigs_2.setFaceIconName("4351");
        for (int i = 0; i <= 15; i++) {
            CustomFace customFace = new CustomFace();
            String index = "" + i;
            if (i < 10)
                index = "0" + i;
            customFace.setAssetPath("4351/ys" + index + "@2x.png");
            customFace.setFaceName("ys" + index + "@2x");
            customFace.setFaceWidth(170);
            customFace.setFaceHeight(170);
            faceConfigs_2.addCustomFace(customFace);
        }
        config.addFaceGroup(faceConfigs_2);

        CustomFaceGroup faceConfigs_3 = new CustomFaceGroup();
        faceConfigs_3.setPageColumnCount(5);
        faceConfigs_3.setPageRowCount(2);
        faceConfigs_3.setFaceGroupId(3);
        faceConfigs_3.setFaceIconPath("4352/gcs00@2x.png");
        faceConfigs_3.setFaceIconName("4352");
        for (int i = 0; i <= 16; i++) {
            CustomFace customFace = new CustomFace();
            String index = "" + i;
            if (i < 10)
                index = "0" + i;
            customFace.setAssetPath("4352/gcs" + index + "@2x.png");
            customFace.setFaceName("gcs" + index + "@2x");
            customFace.setFaceWidth(170);
            customFace.setFaceHeight(170);
            faceConfigs_3.addCustomFace(customFace);
        }
        config.addFaceGroup(faceConfigs_3);

        return config;
    }
    public static void addIMEventListener(IMEventListener eventListener){
        TUIKit.addIMEventListener(eventListener);
    }
    public static void login(String userid, String usersig, final IUIKitCallBack callback) {
        TUIKitImpl.login(userid, usersig, callback);
    }
    /**
     * 注册推送
     */
    public static void registerPush(){
        if (BrandUtil.isBrandXiaoMi()) {
            // 小米离线推送
            MiPushClient.registerPush(instance(), PrivateConstants.XM_PUSH_APPID, PrivateConstants.XM_PUSH_APPKEY);
        } else if (BrandUtil.isBrandHuawei()) {
            // 华为离线推送，设置是否接收Push通知栏消息调用示例
            HmsMessaging.getInstance(instance()).turnOnPush().addOnCompleteListener(new com.huawei.hmf.tasks.OnCompleteListener<Void>() {
                @Override
                public void onComplete(com.huawei.hmf.tasks.Task<Void> task) {
                    if (task.isSuccessful()) {
                        SLog.i( "huawei turnOnPush Complete");
                    } else {
                        SLog.e("huawei turnOnPush failed: ret=" + task.getException().getMessage());
                    }
                }
            });
        } else if (BrandUtil.isBrandVivo()) {
            // vivo离线推送
            PushClient.getInstance(instance.getApplicationContext()).initialize();
        }
    }

    public static void onActivityStarted(){
        V2TIMManager.getOfflinePushManager().doForeground(new V2TIMCallback() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("doForeground err = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess() {
                SLog.i( "doForeground success");
            }
        });
        removeIMEventListener(IMEventPushListener);
        ConversationManagerKit.getInstance().removeUnreadWatcher(UnreadWatcher);
        MessageNotification.getInstance().cancelTimeout();
    }

    public static boolean parseOfflineMessage(Intent intent){
        OfflineMessageBean bean = OfflineMessageDispatcher.parseOfflineMessage(intent);
        if (bean != null) {
            OfflineMessageDispatcher.redirect(bean);
            return true;
        }
        return false;
    }

    public static void onActivityStopped(){
        if(AppUtils.isAppBackground(instance())){
            int unReadCount = ConversationManagerKit.getInstance().getUnreadTotal();
            V2TIMManager.getOfflinePushManager().doBackground(unReadCount, new V2TIMCallback() {
                @Override
                public void onError(int code, String desc) {
                    SLog.e("doBackground err = " + code + ", desc = " + desc);
                }

                @Override
                public void onSuccess() {
                    SLog.i( "doBackground success");
                }
            });
            // 应用退到后台，消息转化为系统通知
            addIMEventListener(IMEventPushListener);
            ConversationManagerKit.getInstance().addUnreadWatcher(UnreadWatcher);
        }
    }

    public static void removeIMEventListener(IMEventListener listener) {
        TUIKitImpl.removeIMEventListener(listener);
    }

    public static void logout(final IUIKitCallBack callback) {
        TUIKitImpl.logout(callback);
    }

    /**
     * 释放一些资源等，一般可以在退出登录时调用
     */
    public static void unInit() {
        TUIKitImpl.unInit();
    }
}
