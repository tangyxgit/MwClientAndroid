package com.mwim.qcloud.tim.uikit;

import android.content.Context;
import android.os.Environment;

import com.huawei.hms.push.HmsMessaging;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.mwim.qcloud.tim.uikit.base.IMEventListener;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.business.message.MessageNotification;
import com.mwim.qcloud.tim.uikit.business.thirdpush.HUAWEIHmsMessageService;
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
import com.work.util.AppUtils;
import com.work.util.SLog;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.io.File;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public final class IMKitAgent {

    private static final int AppId = 1400425549;

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
    };
    private static Context instance;

    public static Context instance(){
        return instance;
    }

    public static void init(Context context,String appKey){
        instance = context;
        TUIKit.init(context,AppId,getConfigs(context));
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
        TUIKit.getConfigs().setCustomFaceConfig(initCustomFaceConfig());
        return TUIKit.getConfigs();
    }

    public static Context getAppContext() {
        return TUIKitImpl.getAppContext();
    }

    private static CustomFaceConfig initCustomFaceConfig() {
        CustomFaceConfig config = new CustomFaceConfig();
        CustomFaceGroup faceConfigs = new CustomFaceGroup();
        faceConfigs.setPageColumnCount(5);
        faceConfigs.setPageRowCount(2);
        faceConfigs.setFaceGroupId(1);
        faceConfigs.setFaceIconPath("4350/tt01@2x.png");
        faceConfigs.setFaceIconName("4350");
        for (int i = 0; i <= 16; i++) {
            CustomFace customFace = new CustomFace();
            String index = "" + i;
            if (i < 10)
                index = "0" + i;
            customFace.setAssetPath("4350/tt" + index + "@2x.png");
            customFace.setFaceName("tt" + index + "@2x");
            customFace.setFaceWidth(170);
            customFace.setFaceHeight(170);
            faceConfigs.addCustomFace(customFace);
        }
        config.addFaceGroup(faceConfigs);

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
//                        DemoLog.i(TAG, "huawei turnOnPush Complete");
                    } else {
//                        DemoLog.e(TAG, "huawei turnOnPush failed: ret=" + task.getException().getMessage());
                    }
                }
            });
        } else if (MzSystemUtils.isBrandMeizu(instance())) {
            // 魅族离线推送
            PushManager.register(instance(), PrivateConstants.MZ_PUSH_APPID, PrivateConstants.MZ_PUSH_APPKEY);
        }
//        else if (BrandUtil.isBrandVivo()) {
//            // vivo离线推送
//            PushClient.getInstance(getApplicationContext()).initialize();
//        }
//        else if (HeytapPushManager.isSupportPush()) {
//            // oppo离线推送，因为需要登录成功后向我们后台设置token，所以注册放在MainActivity中做
//        }
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
