package com.mwim.qcloud.tim.uikit;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;

import com.http.network.listener.OnResultDataListener;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.huawei.hms.push.HmsMessaging;
import com.mwim.qcloud.tim.uikit.base.IMEventListener;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.business.inter.YzStatusListener;
import com.mwim.qcloud.tim.uikit.business.inter.WorkAppItemClickListener;
import com.mwim.qcloud.tim.uikit.business.message.MessageNotification;
import com.mwim.qcloud.tim.uikit.business.modal.UserApi;
import com.mwim.qcloud.tim.uikit.business.thirdpush.HUAWEIHmsMessageService;
import com.mwim.qcloud.tim.uikit.business.thirdpush.OfflineMessageDispatcher;
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
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.vivo.push.PushClient;
import com.work.api.open.Yz;
import com.work.api.open.model.SysUserReq;
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

    private IMEventListener IMEventPushListener = new IMEventListener() {
        @Override
        public void onNewMessage(V2TIMMessage msg) {
            MessageNotification notification = MessageNotification.getInstance();
            notification.notify(msg);
        }
    };
    private ConversationManagerKit.MessageUnreadWatcher UnreadWatcher = new ConversationManagerKit.MessageUnreadWatcher() {
        @Override
        public void updateUnread(int count) {
            // 华为离线推送角标
            HUAWEIHmsMessageService.updateBadge(mContext, count);
        }

        @Override
        public void updateContacts() {

        }

        @Override
        public void updateConversion() {

        }
    };
    private static IMKitAgent singleton;
    private Context mContext;
    private String mYzAppId;
    private YzStatusListener mIMKitStatusListener;
    private WorkAppItemClickListener mWorkAppItemClickListener;

    private IMKitAgent(Context context,String mYzAppId) {
        this.mContext = context;
        this.mYzAppId = mYzAppId;
        loadConfig();
    }

    public static void init(Context context,String appId){
        if(singleton==null){
            singleton = new IMKitAgent(context,appId);
        }
    }

    public static IMKitAgent instance(){
        return singleton;
    }

    public void addStatusListener(YzStatusListener listener){
        this.mIMKitStatusListener = listener;
    }

    private void loadConfig(){
        UMConfigure.init(mContext, "5f8d583980455950e4af10d9", "Yz", UMConfigure.DEVICE_TYPE_PHONE, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        //初始化im
        TUIKit.init(mContext,1400432221,getConfigs());
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
        QbSdk.initX5Environment(mContext,cb);
        registerPush();
    };
    private TUIKitConfigs getConfigs() {
        GeneralConfig config = new GeneralConfig();
        // 显示对方是否已读的view将会展示
        config.setShowRead(true);
        config.setAppCacheDir(mContext.getFilesDir().getPath());
        if (new File(Environment.getExternalStorageDirectory() + "/111222333").exists()) {
            config.setTestEnv(true);
        }
        TUIKit.getConfigs().setGeneralConfig(config);
//        TUIKit.getConfigs().setCustomFaceConfig(initCustomFaceConfig());
        return TUIKit.getConfigs();
    }
    public void addIMEventListener(IMEventListener eventListener){
        TUIKit.addIMEventListener(eventListener);
    }

    private String userId;
    private String userSign;
    public void register(final SysUserReq userReq, final YzStatusListener listener) {
        if(TextUtils.isEmpty(userId) || TextUtils.isEmpty(userSign)){
            Yz.getSession().sysUser(userReq, new OnResultDataListener() {
                @Override
                public void onResult(RequestWork req, ResponseWork resp) {
                    userId = userReq.getUserId();
                    userSign = userReq.getUserSign();
                    loginIM(listener);
                }
            });
        }else{
            loginIM(listener);
        }
    }
    private void loginIM(final YzStatusListener listener){
        TUIKitImpl.login(userId, userSign, new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                if(listener!=null){
                    listener.loginSuccess(data);
                }
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                if(listener!=null){
                    listener.loginFail(module,errCode,errMsg);
                }
            }
        });
    }
    /**
     * 启动im
     */
    public void startAuto(){

    }
    /**
     * 注册推送
     */
    private void registerPush(){
        if (BrandUtil.isBrandXiaoMi()) {
            // 小米离线推送
            MiPushClient.registerPush(mContext, PrivateConstants.XM_PUSH_APPID, PrivateConstants.XM_PUSH_APPKEY);
        } else if (BrandUtil.isBrandHuawei()) {
            // 华为离线推送，设置是否接收Push通知栏消息调用示例
            HmsMessaging.getInstance(mContext).turnOnPush().addOnCompleteListener(new com.huawei.hmf.tasks.OnCompleteListener<Void>() {
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
            PushClient.getInstance(mContext.getApplicationContext()).initialize();
        }
    }

    public void onActivityStarted(){
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

    public boolean parseOfflineMessage(Intent intent){
        OfflineMessageBean bean = OfflineMessageDispatcher.parseOfflineMessage(intent);
        if (bean != null) {
            OfflineMessageDispatcher.redirect(bean);
            return true;
        }
        return false;
    }

    public void onActivityStopped(){
        if(AppUtils.isAppBackground(mContext)){
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

    private void removeIMEventListener(IMEventListener listener) {
        TUIKitImpl.removeIMEventListener(listener);
    }

    public void logout() {
        TUIKitImpl.logout(new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onError(String module, int errCode, String errMsg) {

            }
        });
        UserApi.instance().clear();
        unInit();
    }

    /**
     * 释放一些资源等，一般可以在退出登录时调用
     */
    public void unInit() {
        TUIKitImpl.unInit();
        if(mIMKitStatusListener!=null){
            mIMKitStatusListener.logout();
        }
    }
}
