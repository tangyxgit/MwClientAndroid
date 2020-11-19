package com.mwim.qcloud.tim.uikit.modules.conversation;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.PopupMenu;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.TUIKit;
import com.mwim.qcloud.tim.uikit.business.active.SearchAddMoreActivity;
import com.mwim.qcloud.tim.uikit.business.active.StartGroupChatActivity;
import com.mwim.qcloud.tim.uikit.business.helper.PopMenuHelper;
import com.mwim.qcloud.tim.uikit.modules.conversation.base.ConversationInfo;
import com.mwim.qcloud.tim.uikit.modules.conversation.interfaces.IConversationAdapter;
import com.mwim.qcloud.tim.uikit.modules.conversation.interfaces.IConversationLayout;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.component.TitleBarLayout;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.work.util.ToastUtil;

public class ConversationLayout extends RelativeLayout implements IConversationLayout {

    private ConversationListLayout mConversationList;
    private PopMenuHelper mMenu;

    public ConversationLayout(Context context) {
        super(context);
        init();
    }

    public ConversationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ConversationLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化相关UI元素
     */
    private void init() {
        inflate(getContext(), R.layout.conversation_layout, this);
        EditText mSearch = findViewById(R.id.search);
        mSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchAddMoreActivity.startSearchMore(getContext(),1);
            }
        });
        mConversationList = findViewById(R.id.conversation_list);
    }
    private IConversationAdapter adapter;
    public void initDefault() {
        final View mAddMore = findViewById(R.id.add_more);
        mAddMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMenu==null){
                    mMenu = new PopMenuHelper(R.menu.chat_group, mAddMore, new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.add_friends) {
                                getContext().startActivity(new Intent(getContext(), SearchAddMoreActivity.class));
                            }else if(item.getItemId() == R.id.add_group){
                                Intent intent = new Intent(TUIKit.getAppContext(), StartGroupChatActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra(TUIKitConstants.GroupType.TYPE, TUIKitConstants.GroupType.PUBLIC);
                                getContext().startActivity(intent);
                            }
                            return false;
                        }
                    });
                }
                mMenu.showMenu(getContext());
            }
        });
        if(adapter==null){
            adapter = new ConversationListAdapter();
            mConversationList.setAdapter(adapter);
        }
        ConversationManagerKit.getInstance().loadConversation(new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                adapter.setDataProvider((ConversationProvider) data);
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                ToastUtil.error(TUIKit.getAppContext(),"加载消息失败");
            }
        });
    }

    public TitleBarLayout getTitleBar() {
        return null;
    }

    @Override
    public void setParentLayout(Object parent) {

    }

    @Override
    public ConversationListLayout getConversationList() {
        return mConversationList;
    }

    public void addConversationInfo(int position, ConversationInfo info) {
        mConversationList.getAdapter().addItem(position, info);
    }

    public void removeConversationInfo(int position) {
        mConversationList.getAdapter().removeItem(position);
    }

    @Override
    public void setConversationTop(int position, ConversationInfo conversation) {
        ConversationManagerKit.getInstance().setConversationTop(position, conversation);
    }

    @Override
    public void deleteConversation(int position, ConversationInfo conversation) {
        ConversationManagerKit.getInstance().deleteConversation(position, conversation);
    }
}
