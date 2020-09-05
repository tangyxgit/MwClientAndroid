package com.mwim.qcloud.tim.uikit.business.active;

import android.app.Fragment;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.jaeger.library.StatusBarUtil;
import com.mwim.liteav.model.CallModel;
import com.mwim.liteav.model.TRTCAVCallImpl;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.business.Constants;
import com.mwim.qcloud.tim.uikit.business.fragment.ContactFragment;
import com.mwim.qcloud.tim.uikit.business.fragment.ConversationFragment;
import com.mwim.qcloud.tim.uikit.business.fragment.ProfileFragment;
import com.mwim.qcloud.tim.uikit.business.thirdpush.HUAWEIHmsMessageService;
import com.mwim.qcloud.tim.uikit.business.thirdpush.ThirdPushTokenMgr;
import com.mwim.qcloud.tim.uikit.modules.chat.GroupChatManagerKit;
import com.mwim.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.mwim.qcloud.tim.uikit.utils.BrandUtil;
import com.mwim.qcloud.tim.uikit.utils.DemoLog;
import com.mwim.qcloud.tim.uikit.utils.FileUtil;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.mwim.qcloud.tim.uikit.R;

/**
 * Created by tangyx
 * Date 2020/8/16
 * email tangyx@live.com
 */

public class MwWorkActivity extends IMBaseActivity implements ConversationManagerKit.MessageUnreadWatcher{
    private static final String TAG = MwWorkActivity.class.getSimpleName();
    private TextView mConversationBtn;
    private TextView mContactBtn;
    private TextView mProfileSelfBtn;
    private TextView mMsgUnread;
    private View mLastTab;
    private CallModel mCallModel;

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        initView();
        prepareThirdPushToken();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DemoLog.i(TAG, "onStart");
        super.onStart();

    }

    @Override
    protected void onStop() {
        ConversationManagerKit.getInstance().destroyConversation();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mLastTab = null;
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        DemoLog.i(TAG, "onNewIntent");
        super.onNewIntent(intent);
        mCallModel = (CallModel)intent.getSerializableExtra(Constants.CHAT_INFO);
    }


    private void prepareThirdPushToken() {
        ThirdPushTokenMgr.getInstance().setPushTokenToTIM();

        if (BrandUtil.isBrandHuawei()) {
            // 华为离线推送
            new Thread() {
                @Override
                public void run() {
                    try {
                        // read from agconnect-services.json
                        String appId = AGConnectServicesConfig.fromContext(MwWorkActivity.this).getString("client/app_id");
                        String token = HmsInstanceId.getInstance(MwWorkActivity.this).getToken(appId, "HCM");
                        DemoLog.i(TAG, "huawei get token:" + token);
                        if(!TextUtils.isEmpty(token)) {
                            ThirdPushTokenMgr.getInstance().setThirdPushToken(token);
                            ThirdPushTokenMgr.getInstance().setPushTokenToTIM();
                        }
                    } catch (ApiException e) {
                        DemoLog.e(TAG, "huawei get token failed, " + e);
                    }
                }
            }.start();
        }
        else if (BrandUtil.isBrandVivo()) {
            // vivo离线推送
//            DemoLog.i(TAG, "vivo support push: " + PushClient.getInstance(getApplicationContext()).isSupport());
//            PushClient.getInstance(getApplicationContext()).turnOnPush(new IPushActionListener() {
//                @Override
//                public void onStateChanged(int state) {
//                    if (state == 0) {
//                        String regId = PushClient.getInstance(getApplicationContext()).getRegId();
//                        DemoLog.i(TAG, "vivopush open vivo push success regId = " + regId);
//                        ThirdPushTokenMgr.getInstance().setThirdPushToken(regId);
//                        ThirdPushTokenMgr.getInstance().setPushTokenToTIM();
//                    } else {
//                        // 根据vivo推送文档说明，state = 101 表示该vivo机型或者版本不支持vivo推送，链接：https://dev.vivo.com.cn/documentCenter/doc/156
//                        DemoLog.i(TAG, "vivopush open vivo push fail state = " + state);
//                    }
//                }
//            });
        }
//        else if (HeytapPushManager.isSupportPush()) {
//            // oppo离线推送
//            OPPOPushImpl oppo = new OPPOPushImpl();
//            oppo.createNotificationChannel(this);
//            HeytapPushManager.register(this, PrivateConstants.OPPO_PUSH_APPKEY, PrivateConstants.OPPO_PUSH_APPSECRET, oppo);
//        }

    }

    private void initView() {
        mConversationBtn = findViewById(R.id.conversation);
        mContactBtn = findViewById(R.id.contact);
        mProfileSelfBtn = findViewById(R.id.mine);
        mMsgUnread = findViewById(R.id.msg_total_unread);
        Log.e(TAG,"mMsgUnread:"+mMsgUnread);
        getFragmentManager().beginTransaction().replace(R.id.empty_view, new ConversationFragment()).commitAllowingStateLoss();
        FileUtil.initPath(); // 从application移入到这里，原因在于首次装上app，需要获取一系列权限，如创建文件夹，图片下载需要指定创建好的文件目录，否则会下载本地失败，聊天页面从而获取不到图片、表情

        // 未读消息监视器
        ConversationManagerKit.getInstance().addUnreadWatcher(this);
        GroupChatManagerKit.getInstance();
        if (mLastTab == null) {
            mLastTab = findViewById(R.id.conversation_btn_group);
        } else {
            // 初始化时，强制切换tab到上一次的位置
            View tmp = mLastTab;
            mLastTab = null;
            tabClick(tmp);
            mLastTab = tmp;
        }
    }

    @Override
    protected void onResume() {
        DemoLog.i(TAG, "onResume");
        super.onResume();
        if (mCallModel != null) {
            TRTCAVCallImpl impl = (TRTCAVCallImpl) TRTCAVCallImpl.sharedInstance(IMKitAgent.instance());
            impl.stopCall();
            final V2TIMSignalingInfo info = new V2TIMSignalingInfo();
            info.setInviteID(mCallModel.callId);
            info.setInviteeList(mCallModel.invitedList);
            info.setGroupID(mCallModel.groupId);
            info.setInviter(mCallModel.sender);
            info.setData(mCallModel.data);
            ((TRTCAVCallImpl)(TRTCAVCallImpl.sharedInstance(IMKitAgent.instance()))).processInvite(
                    info.getInviteID(), info.getInviter(), info.getGroupID(), info.getInviteeList(), info.getData());
            mCallModel = null;
        }
    }

    public void tabClick(View view) {
        DemoLog.i(TAG, "tabClick last: " + mLastTab + " current: " + view);
        if (mLastTab != null && mLastTab.getId() == view.getId()) {
            return;
        }
        mLastTab = view;
        resetMenuState();
        Fragment current = null;
        int id = view.getId();
        if (id == R.id.conversation_btn_group) {
            current = new ConversationFragment();
            mConversationBtn.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
            mConversationBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.conversation_selected), null, null);
        } else if (id == R.id.contact_btn_group) {
            current = new ContactFragment();
            mContactBtn.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
            mContactBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.contact_selected), null, null);
        } else if (id == R.id.myself_btn_group) {
            current = new ProfileFragment();
            mProfileSelfBtn.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
            mProfileSelfBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.myself_selected), null, null);
        }

        if (current != null && !current.isAdded()) {
            getFragmentManager().beginTransaction().replace(R.id.empty_view, current).commitAllowingStateLoss();
            getFragmentManager().executePendingTransactions();
        } else {
            DemoLog.w(TAG, "fragment added!");
        }
    }

    private void resetMenuState() {
        mConversationBtn.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
        mConversationBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.conversation_normal), null, null);
        mContactBtn.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
        mContactBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.contact_normal), null, null);
        mProfileSelfBtn.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
        mProfileSelfBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.myself_normal), null, null);
    }

    @Override
    public void updateUnread(int count) {
        if (count > 0) {
            mMsgUnread.setVisibility(View.VISIBLE);
        } else {
            mMsgUnread.setVisibility(View.GONE);
        }
        String unreadStr = "" + count;
        if (count > 100) {
            unreadStr = "99+";
        }
        mMsgUnread.setText(unreadStr);
        // 华为离线推送角标
        HUAWEIHmsMessageService.updateBadge(this, count);
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.status_bar_color));
    }
}
