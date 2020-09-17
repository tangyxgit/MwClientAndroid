package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.business.Constants;
import com.mwim.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.mwim.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.mwim.qcloud.tim.uikit.modules.contact.FriendProfileLayout;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.mwim.qcloud.tim.uikit.R;

public class FriendProfileActivity extends IMBaseActivity {

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        FriendProfileLayout layout = findViewById(R.id.friend_profile);
        layout.initData(getIntent().getSerializableExtra(TUIKitConstants.ProfileType.CONTENT));
        layout.setOnButtonClickListener(new FriendProfileLayout.OnButtonClickListener() {
            @Override
            public void onStartConversationClick(ContactItemBean info) {
                ChatInfo chatInfo = new ChatInfo();
                chatInfo.setType(V2TIMConversation.V2TIM_C2C);
                chatInfo.setId(info.getId());
                String chatName = info.getId();
                if (!TextUtils.isEmpty(info.getRemark())) {
                    chatName = info.getRemark();
                } else if (!TextUtils.isEmpty(info.getNickname())) {
                    chatName = info.getNickname();
                }
                chatInfo.setChatName(chatName);
                Intent intent = new Intent(IMKitAgent.instance(), ChatActivity.class);
                intent.putExtra(Constants.CHAT_INFO, chatInfo);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                IMKitAgent.instance().startActivity(intent);
            }

            @Override
            public void onDeleteFriendClick(String id) {
//                Intent intent = new Intent(IMKitAgent.instance(), MwWorkActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        setTitleName(null);
        setStatusBar(Color.WHITE);
        mTitleLayout.setBackgroundColor(Color.WHITE);

    }

    @Override
    public int onCustomContentId() {
        return R.layout.activity_im_contact_friend_profile;
    }
}
