package com.mwim.qcloud.tim.uikit.modules.contact;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.business.active.SearchAddMoreActivity;
import com.mwim.qcloud.tim.uikit.business.active.StartGroupChatActivity;
import com.mwim.qcloud.tim.uikit.business.helper.PopMenuHelper;
import com.mwim.qcloud.tim.uikit.modules.contact.interfaces.IContactLayout;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.component.TitleBarLayout;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;


public class ContactLayout extends LinearLayout implements IContactLayout {

//    private TitleBarLayout mTitleBar;
    private ContactListView mContactListView;

    public ContactLayout(Context context) {
        super(context);
        init();
    }

    public ContactLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContactLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.contact_layout, this);

        final View mAddMore = findViewById(R.id.add_more);
        mAddMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), SearchAddMoreActivity.class));
            }
        });
        mContactListView = findViewById(R.id.contact_listview);
    }

    public void initDefault() {
        mContactListView.loadDataSource(ContactListView.DataSource.CONTACT_LIST);
    }

    @Override
    public ContactListView getContactListView() {
        return mContactListView;
    }

    @Override
    public TitleBarLayout getTitleBar() {
        return null;
    }

    @Override
    public void setParentLayout(Object parent) {

    }
}
