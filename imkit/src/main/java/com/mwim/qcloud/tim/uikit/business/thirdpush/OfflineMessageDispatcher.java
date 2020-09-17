package com.mwim.qcloud.tim.uikit.business.thirdpush;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.mwim.liteav.model.CallModel;
import com.mwim.liteav.model.TRTCAVCallImpl;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.business.Constants;
import com.mwim.qcloud.tim.uikit.business.active.ChatActivity;
import com.mwim.qcloud.tim.uikit.business.active.MwWorkActivity;
import com.mwim.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.mwim.qcloud.tim.uikit.modules.chat.base.OfflineMessageBean;
import com.mwim.qcloud.tim.uikit.modules.chat.base.OfflineMessageContainerBean;
import com.mwim.qcloud.tim.uikit.utils.BrandUtil;
import com.mwim.qcloud.tim.uikit.utils.ToastUtil;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.work.util.SLog;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;

import java.util.Map;
import java.util.Set;

public class OfflineMessageDispatcher {

    public static OfflineMessageBean parseOfflineMessage(Intent intent) {
        SLog.i( "intent: " + intent);
        if (intent == null) {
            return null;
        }
        Bundle bundle = intent.getExtras();
        SLog.i( "bundle: " + bundle);
        if (bundle == null) {
//            String ext = VIVOPushMessageReceiverImpl.getParams();
//            if (!TextUtils.isEmpty(ext)) {
//                return getOfflineMessageBeanFromContainer(ext);
//            }
            return null;
        } else {
            String ext = bundle.getString("ext");
            SLog.i( "push custom data ext: " + ext);
            if (TextUtils.isEmpty(ext)) {
                if (BrandUtil.isBrandXiaoMi()) {
                    ext = getXiaomiMessage(bundle);
                    return getOfflineMessageBeanFromContainer(ext);
                } else if (BrandUtil.isBrandOppo()) {
                    ext = getOPPOMessage(bundle);
                    return getOfflineMessageBean(ext);
                }
            } else {
                return getOfflineMessageBeanFromContainer(ext);
            }
            return null;
        }
    }

    private static String getXiaomiMessage(Bundle bundle) {
        MiPushMessage miPushMessage = (MiPushMessage) bundle.getSerializable(PushMessageHelper.KEY_MESSAGE);
        if (miPushMessage == null) {
            return null;
        }
        Map extra = miPushMessage.getExtra();
        return extra.get("ext").toString();
    }

    private static String getOPPOMessage(Bundle bundle) {
        Set<String> set = bundle.keySet();
        if (set != null) {
            for (String key : set) {
                Object value = bundle.get(key);
                SLog.i( "push custom data key: " + key + " value: " + value);
                if (TextUtils.equals("entity", key)) {
                    return value.toString();
                }
            }
        }
        return null;
    }

    private static OfflineMessageBean getOfflineMessageBeanFromContainer(String ext) {
        if (TextUtils.isEmpty(ext)) {
            return null;
        }
        OfflineMessageContainerBean bean = new Gson().fromJson(ext, OfflineMessageContainerBean.class);
        if (bean == null) {
            return null;
        }
        return offlineMessageBeanValidCheck(bean.entity);
    }

    private static OfflineMessageBean getOfflineMessageBean(String ext) {
        if (TextUtils.isEmpty(ext)) {
            return null;
        }
        OfflineMessageBean bean = new Gson().fromJson(ext, OfflineMessageBean.class);
        return offlineMessageBeanValidCheck(bean);
    }

    private static OfflineMessageBean offlineMessageBeanValidCheck(OfflineMessageBean bean) {
        if (bean == null) {
            return null;
        } else if (bean.version != 1
                || (bean.action != OfflineMessageBean.REDIRECT_ACTION_CHAT
                    && bean.action != OfflineMessageBean.REDIRECT_ACTION_CALL) ) {
            PackageManager packageManager = IMKitAgent.instance().getPackageManager();
            String label = String.valueOf(packageManager.getApplicationLabel(IMKitAgent.instance().getApplicationInfo()));
            ToastUtil.toastLongMessage("您的应用 " + label + " 版本太低，不支持打开该离线消息");
            SLog.e("unknown version: " + bean.version + " or action: " + bean.action);
            return null;
        }
        return bean;
    }

    public static boolean redirect(final OfflineMessageBean bean) {
        if (bean.action == OfflineMessageBean.REDIRECT_ACTION_CHAT) {
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setType(bean.chatType);
            chatInfo.setId(bean.sender);
            Intent intent = new Intent(IMKitAgent.instance(), ChatActivity.class);
            intent.putExtra(Constants.CHAT_INFO, chatInfo);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            IMKitAgent.instance().startActivity(intent);
            return true;
        } else if (bean.action == OfflineMessageBean.REDIRECT_ACTION_CALL) {
            final CallModel model = new Gson().fromJson(bean.content, CallModel.class);
            SLog.i("bean: "+ bean + " model: " + model);
            if (model != null) {
                long timeout = System.currentTimeMillis() / 1000 - bean.sendTime;
                if (timeout >= model.timeout) {
                    ToastUtil.toastLongMessage("本次通话已超时");
                } else {
                    if (TextUtils.isEmpty(model.groupId)) {
                        if (bean.chatType == TIMConversationType.C2C.value()) {
                            // c2c 登录之后会同步消息，所以不需要主动调用通话界面
                        } else {
                            SLog.e("group call but no group id");
                        }
                    } else {
                        V2TIMSignalingInfo info = new V2TIMSignalingInfo();
                        info.setInviteID(model.callId);
                        info.setInviteeList(model.invitedList);
                        info.setGroupID(model.groupId);
                        info.setInviter(bean.sender);
                        V2TIMManager.getSignalingManager().addInvitedSignaling(info, new V2TIMCallback() {

                            @Override
                            public void onError(int code, String desc) {
                                SLog.e("addInvitedSignaling code: " + code + " desc: " + desc);
                            }

                            @Override
                            public void onSuccess() {
                                ((TRTCAVCallImpl)(TRTCAVCallImpl.sharedInstance(IMKitAgent.instance()))).
                                        processInvite(model.callId, bean.sender, model.groupId, model.invitedList, bean.content);
                            }
                        });
                        return true;
                    }
                }
            }
        }
        Intent intent = new Intent(IMKitAgent.instance(), MwWorkActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        IMKitAgent.instance().startActivity(intent);
        return true;
    }
}
