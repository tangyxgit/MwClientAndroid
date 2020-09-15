package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.mwim.qcloud.tim.uikit.business.Constants;
import com.mwim.qcloud.tim.uikit.business.fragment.ChatFragment;
import com.mwim.qcloud.tim.uikit.business.thirdpush.OfflineMessageDispatcher;
import com.mwim.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.mwim.qcloud.tim.uikit.modules.chat.base.OfflineMessageBean;
import com.tencent.imsdk.v2.V2TIMManager;
import com.mwim.qcloud.tim.uikit.R;

import static com.tencent.imsdk.v2.V2TIMManager.V2TIM_STATUS_LOGINED;

public class ChatActivity extends IMBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_chat);

        chat(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        chat(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void chat(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            startSplashActivity(null);
            return;
        }

        OfflineMessageBean bean = OfflineMessageDispatcher.parseOfflineMessage(intent);
        ChatInfo mChatInfo;
        if (bean != null) {
            mChatInfo = new ChatInfo();
            mChatInfo.setType(bean.chatType);
            mChatInfo.setId(bean.sender);
            bundle.putSerializable(Constants.CHAT_INFO, mChatInfo);
        } else {
            mChatInfo = (ChatInfo) bundle.getSerializable(Constants.CHAT_INFO);
            if (mChatInfo == null) {
                startSplashActivity(null);
                return;
            }
        }

        if (V2TIMManager.getInstance().getLoginStatus() == V2TIM_STATUS_LOGINED) {
            ChatFragment mChatFragment = new ChatFragment();
            mChatFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.empty_view, mChatFragment).commitAllowingStateLoss();
        } else {
            startSplashActivity(bundle);
        }
    }

    private void startSplashActivity(Bundle bundle) {
//        Intent intent = new Intent(ChatActivity.this, SplashActivity.class);
//        if (bundle != null) {
//            intent.putExtras(bundle);
//        }
//        startActivity(intent);
//        finish();
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }
}
