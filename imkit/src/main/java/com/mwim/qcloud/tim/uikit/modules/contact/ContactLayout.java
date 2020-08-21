package com.mwim.qcloud.tim.uikit.modules.contact;

import android.content.Context;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.mwim.qcloud.tim.uikit.modules.contact.interfaces.IContactLayout;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.component.TitleBarLayout;


public class ContactLayout extends LinearLayout implements IContactLayout {

    private static final String TAG = ContactLayout.class.getSimpleName();

    private TitleBarLayout mTitleBar;
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

        mTitleBar = findViewById(R.id.contact_titlebar);
        mTitleBar.setTitle(getResources().getString(R.string.contact_title), TitleBarLayout.POSITION.MIDDLE);
        mTitleBar.getLeftGroup().setVisibility(View.GONE);
        mTitleBar.getRightIcon().setImageResource(R.drawable.conversation_more);

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
        return mTitleBar;
    }

    @Override
    public void setParentLayout(Object parent) {

    }
}
