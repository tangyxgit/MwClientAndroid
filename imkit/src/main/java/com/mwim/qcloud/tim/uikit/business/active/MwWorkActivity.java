package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.mwim.liteav.model.CallModel;
import com.mwim.liteav.model.TRTCAVCallImpl;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.base.BaseFragment;
import com.mwim.qcloud.tim.uikit.business.Constants;
import com.mwim.qcloud.tim.uikit.business.adapter.TabPagerAdapter;
import com.mwim.qcloud.tim.uikit.business.fragment.ContactFragment;
import com.mwim.qcloud.tim.uikit.business.fragment.ConversationFragment;
import com.mwim.qcloud.tim.uikit.business.fragment.ProfileFragment;
import com.mwim.qcloud.tim.uikit.business.fragment.WorkFragment;
import com.mwim.qcloud.tim.uikit.business.thirdpush.HUAWEIHmsMessageService;
import com.mwim.qcloud.tim.uikit.business.thirdpush.ThirdPushTokenMgr;
import com.mwim.qcloud.tim.uikit.modules.chat.GroupChatManagerKit;
import com.mwim.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.mwim.qcloud.tim.uikit.utils.BrandUtil;
import com.mwim.qcloud.tim.uikit.utils.FileUtil;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.mwim.qcloud.tim.uikit.R;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.work.util.SLog;
import com.work.util.SharedUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangyx
 * Date 2020/8/16
 * email tangyx@live.com
 */

public class MwWorkActivity extends IMBaseActivity implements ConversationManagerKit.MessageUnreadWatcher,
        BottomNavigationBar.OnTabSelectedListener,ViewPager.OnPageChangeListener {
//    private TextView mConversationBtn;
//    private TextView mContactBtn;
//    private TextView mProfileSelfBtn;
//    private TextView mMsgUnread;
    private BottomNavigationBar mNavigationBar;
    private ViewPager mPager;
    private TabPagerAdapter mAdapter;
    private TextBadgeItem mMessageBadge;
    private List<BaseFragment> mFragments;

    private View mLastTab;
    private CallModel mCallModel;
    public static Context instance;

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        instance = this;
        prepareThirdPushToken();
        //设置为必须要验证才能加好友
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        v2TIMUserFullInfo.setAllowType(V2TIMUserFullInfo.V2TIM_FRIEND_NEED_CONFIRM);
        V2TIMManager.getInstance().setSelfInfo(v2TIMUserFullInfo, null);

        mNavigationBar = findViewById(R.id.bottom_navigation_bar);
        BottomNavigationItem messageItem = new BottomNavigationItem(R.drawable.conversation_selected,R.string.tab_conversation_tab_text).setInactiveIcon(ContextCompat.getDrawable(this,R.drawable.conversation_normal));
        mMessageBadge = new TextBadgeItem();
        mMessageBadge.hide();
        messageItem.setBadgeItem(mMessageBadge);
        mNavigationBar.addItem(messageItem);
        BottomNavigationItem contactItem = new BottomNavigationItem(R.drawable.contact_selected,R.string.tab_contact_tab_text).setInactiveIcon(ContextCompat.getDrawable(this,R.drawable.contact_normal));
        mNavigationBar.addItem(contactItem);
        BottomNavigationItem workItem = new BottomNavigationItem(R.drawable.icon_work,R.string.tab_work_tab_text).setActiveColorResource(R.color.color_1473FB);
        mNavigationBar.addItem(workItem);
        BottomNavigationItem profileItem = new BottomNavigationItem(R.drawable.myself_selected,R.string.tab_profile_tab_text).setInactiveIcon(ContextCompat.getDrawable(this,R.drawable.myself_normal));
        mNavigationBar.addItem(profileItem);
//        mConversationBtn = findViewById(R.id.conversation);
//        mContactBtn = findViewById(R.id.contact);
//        mProfileSelfBtn = findViewById(R.id.mine);
//        mMsgUnread = findViewById(R.id.msg_total_unread);
        mNavigationBar.initialise();
        mNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        mFragments = new ArrayList<>();
        mFragments.add(new ConversationFragment());
        mFragments.add(new ContactFragment());
        mFragments.add(new WorkFragment());
        mFragments.add(new ProfileFragment());
        mPager = findViewById(R.id.pager);
        mPager.addOnPageChangeListener(this);
        mAdapter = new TabPagerAdapter(this.getSupportFragmentManager(), mFragments);
        mPager.setAdapter(mAdapter);
        mPager.setOffscreenPageLimit(mFragments.size());
//        getFragmentManager().beginTransaction().replace(R.id.empty_view, new ConversationFragment()).commitAllowingStateLoss();
        FileUtil.initPath(); // 从application移入到这里，原因在于首次装上app，需要获取一系列权限，如创建文件夹，图片下载需要指定创建好的文件目录，否则会下载本地失败，聊天页面从而获取不到图片、表情
//        // 未读消息监视器
        ConversationManagerKit.getInstance().addUnreadWatcher(this);
        GroupChatManagerKit.getInstance();
//        if (mLastTab == null) {
//            mLastTab = findViewById(R.id.conversation_btn_group);
//        } else {
//            // 初始化时，强制切换tab到上一次的位置
//            View tmp = mLastTab;
//            mLastTab = null;
//            tabClick(tmp);
//            mLastTab = tmp;
//        }

    }

    @Override
    protected void onDestroy() {
        ConversationManagerKit.getInstance().destroyConversation();
        mLastTab = null;
        instance = null;
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mCallModel = (CallModel) intent.getSerializableExtra(Constants.CHAT_INFO);
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
                        if (!TextUtils.isEmpty(token)) {
                            ThirdPushTokenMgr.getInstance().setThirdPushToken(token);
                            ThirdPushTokenMgr.getInstance().setPushTokenToTIM();
                        }
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } else if (BrandUtil.isBrandVivo()) {
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


    @Override
    protected void onResume() {
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
            ((TRTCAVCallImpl) (TRTCAVCallImpl.sharedInstance(IMKitAgent.instance()))).processInvite(
                    info.getInviteID(), info.getInviter(), info.getGroupID(), info.getInviteeList(), info.getData());
            mCallModel = null;
        }
    }

    public void tabClick(View view) {
//        if (mLastTab != null && mLastTab.getId() == view.getId()) {
//            return;
//        }
//        mLastTab = view;
//        resetMenuState();
//        Fragment current = null;
//        int id = view.getId();
//        if (id == R.id.conversation_btn_group) {
//            current = new ConversationFragment();
//            mConversationBtn.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
//            mConversationBtn.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.drawable.conversation_selected), null, null);
//            setStatusBar(ContextCompat.getColor(this, R.color.status_bar_color));
//        } else if (id == R.id.contact_btn_group) {
//            current = new ContactFragment();
//            mContactBtn.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
//            mContactBtn.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.drawable.contact_selected), null, null);
//            setStatusBar(ContextCompat.getColor(this, R.color.status_bar_color));
//        } else if (id == R.id.myself_btn_group) {
//            current = new ProfileFragment();
//            mProfileSelfBtn.setTextColor(getResources().getColor(R.color.tab_text_selected_color));
//            mProfileSelfBtn.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.drawable.myself_selected), null, null);
//            setStatusBar(ContextCompat.getColor(this, R.color.white));
//        }
//
//        if (current != null && !current.isAdded()) {
//            getFragmentManager().beginTransaction().replace(R.id.empty_view, current).commitAllowingStateLoss();
//            getFragmentManager().executePendingTransactions();
//        }
    }

    private void resetMenuState() {
//        mConversationBtn.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
//        mConversationBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.conversation_normal), null, null);
//        mContactBtn.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
//        mContactBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.contact_normal), null, null);
//        mProfileSelfBtn.setTextColor(getResources().getColor(R.color.tab_text_normal_color));
//        mProfileSelfBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.myself_normal), null, null);
    }

    @Override
    public void updateUnread(int count) {
        if (count > 0) {
            mMessageBadge.show(true);
        } else {
            mMessageBadge.hide();
        }
        String unreadStr = "" + count;
        if (count > 100) {
            unreadStr = "99+";
        }
        mMessageBadge.setText(unreadStr);
//        // 华为离线推送角标
        HUAWEIHmsMessageService.updateBadge(this, count);
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    @Override
    public void onTabSelected(int position) {
        mPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mNavigationBar.selectTab(position,false);
        updateFragment(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void updateFragment(int position){
        BaseFragment fragment = mFragments.get(position);
        if(fragment instanceof ContactFragment){
            ((ContactFragment) fragment).refreshData();
        }
        if(fragment instanceof WorkFragment){
            setStatusBar(ContextCompat.getColor(this,R.color.background_color));
        }else{
            setStatusBar(ContextCompat.getColor(this,R.color.white));
        }
    }
}
