package com.mwim.qcloud.tim.uikit.business.active;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.mwim.qcloud.tim.uikit.component.TitleBarLayout;
import com.mwim.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.mwim.qcloud.tim.uikit.modules.contact.ContactListView;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.mwim.qcloud.tim.uikit.R;

public class BlackListActivity extends IMBaseActivity {

    private TitleBarLayout mTitleBar;
    private ContactListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_contact_blacklist);

        init();
    }

    private void init() {
        mTitleBar = findViewById(R.id.black_list_titlebar);
        mTitleBar.setTitle(getResources().getString(R.string.blacklist), TitleBarLayout.POSITION.LEFT);
        mTitleBar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.getRightGroup().setVisibility(View.GONE);

        mListView = findViewById(R.id.black_list);
        mListView.setOnItemClickListener(new ContactListView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ContactItemBean contact) {
                Intent intent = new Intent(BlackListActivity.this, FriendProfileActivity.class);
                intent.putExtra(TUIKitConstants.ProfileType.CONTENT, contact);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataSource();
    }

    public void loadDataSource() {
        mListView.loadDataSource(ContactListView.DataSource.BLACK_LIST);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
