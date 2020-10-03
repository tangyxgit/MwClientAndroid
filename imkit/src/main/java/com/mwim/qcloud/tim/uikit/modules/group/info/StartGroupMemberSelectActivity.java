package com.mwim.qcloud.tim.uikit.modules.group.info;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.modules.contact.ContactItemBean;
import com.mwim.qcloud.tim.uikit.modules.contact.ContactListView;
import com.mwim.qcloud.tim.uikit.modules.group.member.GroupMemberInfo;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;

import java.util.ArrayList;

/**
 * Created by tangyx
 * Date 2020/9/24
 * email tangyx@live.com
 */

public class StartGroupMemberSelectActivity extends BaseActivity {

    private ArrayList<GroupMemberInfo> mMembers = new ArrayList<>();

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        mMembers.clear();
        GroupInfo groupInfo = (GroupInfo) getIntent().getExtras().getSerializable(TUIKitConstants.Group.GROUP_INFO);
        ContactListView mContactListView = findViewById(R.id.group_create_member_list);
        mContactListView.setGroupInfo(groupInfo);
        mContactListView.loadDataSource(ContactListView.DataSource.GROUP_MEMBER_LIST);
        mContactListView.setOnSelectChangeListener(new ContactListView.OnSelectChangedListener() {
            @Override
            public void onSelectChanged(ContactItemBean contact, boolean selected) {
                if (selected) {
                    GroupMemberInfo memberInfo = new GroupMemberInfo();
                    memberInfo.setAccount(contact.getId());
                    memberInfo.setNameCard(TextUtils.isEmpty(contact.getNickname()) ? contact.getId() : contact.getNickname());
                    mMembers.add(memberInfo);
                } else {
                    for (int i = mMembers.size() - 1; i >= 0; i--) {
                        if (mMembers.get(i).getAccount().equals(contact.getId())) {
                            mMembers.remove(i);
                        }
                    }
                }
            }
        });
    }


    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        setTitleName("选择提醒的人");
    }

    @Override
    public View onCustomTitleRight(TextView view) {
        view.setText(R.string.sure);
        return view;
    }

    @Override
    public void onRightClickListener(View view) {
        super.onRightClickListener(view);
        Intent i = new Intent();
        i.putExtra(TUIKitConstants.Selection.USER_NAMECARD_SELECT, getMembersNameCard());
        i.putExtra(TUIKitConstants.Selection.USER_ID_SELECT, getMembersUserId());
        setResult(3, i);

        finish();
    }

    @Override
    public int onCustomContentId() {
        return R.layout.popup_start_group_select_activity;
    }

    private String getMembersNameCard(){
        if (mMembers.size() == 0) {
            return "";
        }

        //TUIKitLog.i(TAG, "getMembersNameCard mMembers.size() = " + mMembers.size());
        String nameCardString = "";
        for(int i = 0; i < mMembers.size(); i++){
            nameCardString += mMembers.get(i).getNameCard();
            nameCardString += " ";
        }
        //TUIKitLog.i(TAG, "nameCardString = " + nameCardString);
        return nameCardString;
    }

    private String getMembersUserId(){
        if (mMembers.size() == 0) {
            return "";
        }

        //TUIKitLog.i(TAG, "getMembersUserId mMembers.size() = " + mMembers.size());
        String userIdString = "";
        for(int i = 0; i < mMembers.size(); i++){
            userIdString += mMembers.get(i).getAccount();
            userIdString += " ";
        }
        //TUIKitLog.i(TAG, "userIdString = " + userIdString);
        return userIdString;
    }

}
