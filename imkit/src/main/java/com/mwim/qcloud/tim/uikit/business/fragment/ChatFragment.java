package com.mwim.qcloud.tim.uikit.business.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.base.BaseFragment;
import com.mwim.qcloud.tim.uikit.business.Constants;
import com.mwim.qcloud.tim.uikit.business.active.FriendProfileActivity;
import com.mwim.qcloud.tim.uikit.business.active.MwWorkActivity;
import com.mwim.qcloud.tim.uikit.business.helper.ChatLayoutHelper;
import com.mwim.qcloud.tim.uikit.component.AudioPlayer;
import com.mwim.qcloud.tim.uikit.component.TitleBarLayout;
import com.mwim.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.mwim.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.mwim.qcloud.tim.uikit.modules.chat.layout.message.MessageLayout;
import com.mwim.qcloud.tim.uikit.modules.message.MessageInfo;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.mwim.qcloud.tim.uikit.R;


public class ChatFragment extends BaseFragment {

    private View mBaseView;
    private ChatLayout mChatLayout;
    private ChatInfo mChatInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.fragment_im_chat, container, false);
        return mBaseView;
    }

    private void initView() {
        //从布局文件中获取聊天面板组件
        mChatLayout = mBaseView.findViewById(R.id.chat_layout);

        //单聊组件的默认UI和交互初始化
        mChatLayout.initDefault();

        /*
         * 需要聊天的基本信息
         */
        mChatLayout.setChatInfo(mChatInfo);

        //获取单聊面板的标题栏
        TitleBarLayout mTitleBar = mChatLayout.getTitleBar();

        //单聊面板标记栏返回按钮点击事件，这里需要开发者自行控制
        mTitleBar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MwWorkActivity.instance==null){
                    Intent intent = new Intent(getActivity(),MwWorkActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                getActivity().finish();
            }
        });
        if (mChatInfo.getType() == V2TIMConversation.V2TIM_C2C) {
            mTitleBar.setOnRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(IMKitAgent.instance(), FriendProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, mChatInfo);
                    IMKitAgent.instance().startActivity(intent);
                }
            });
        }
        mChatLayout.getMessageLayout().setOnItemClickListener(new MessageLayout.OnItemClickListener() {
            @Override
            public void onMessageLongClick(View view, int position, MessageInfo messageInfo) {
                //因为adapter中第一条为加载条目，位置需减1
                mChatLayout.getMessageLayout().showItemPopMenu(position - 1, messageInfo, view);
            }

            @Override
            public void onUserIconClick(View view, int position, MessageInfo messageInfo) {
                if (null == messageInfo) {
                    return;
                }
                ChatInfo info = new ChatInfo();
                info.setId(messageInfo.getFromUser());
                Intent intent = new Intent(IMKitAgent.instance(), FriendProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(TUIKitConstants.ProfileType.CONTENT, info);
                IMKitAgent.instance().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle bundle = getArguments();
        mChatInfo = (ChatInfo) bundle.getSerializable(Constants.CHAT_INFO);
        if (mChatInfo == null) {
            return;
        }
        initView();

        // TODO 通过api设置ChatLayout各种属性的样例
        ChatLayoutHelper helper = new ChatLayoutHelper(getActivity());
        helper.customizeChatLayout(mChatLayout);
    }

    @Override
    public void onPause() {
        super.onPause();
        AudioPlayer.getInstance().stopPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mChatLayout != null) {
            mChatLayout.exitChat();
        }
    }

}
