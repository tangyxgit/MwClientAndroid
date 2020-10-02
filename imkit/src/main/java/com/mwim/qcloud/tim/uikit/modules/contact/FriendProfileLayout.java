package com.mwim.qcloud.tim.uikit.modules.contact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.http.network.listener.OnResultDataListener;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMFriendAddApplication;
import com.tencent.imsdk.v2.V2TIMFriendApplication;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMFriendOperationResult;
import com.tencent.imsdk.v2.V2TIMGroupApplication;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.TUIKit;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.component.LineControllerView;
import com.mwim.qcloud.tim.uikit.component.SelectionActivity;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.mwim.qcloud.tim.uikit.modules.chat.GroupChatManagerKit;
import com.mwim.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.mwim.qcloud.tim.uikit.modules.group.apply.GroupApplyInfo;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.work.api.open.Yz;
import com.work.api.open.model.LoginReq;
import com.work.api.open.model.LoginResp;
import com.work.api.open.model.client.OpenData;
import com.work.util.SLog;
import com.work.util.StringUtils;
import com.work.util.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FriendProfileLayout extends LinearLayout implements View.OnClickListener {

    private ImageView mHeadImageView;
    private TextView mNickNameView;
    private TextView mMobile;
    private LineControllerView mDepartment;
    private LineControllerView mPosition;
    private LineControllerView mCard;
    private LineControllerView mEmail;
    private EditText mAddWordingView;
    private LineControllerView mRemarkView;
    private LineControllerView mAddBlackView;
    private LineControllerView mChatTopView;
    private TextView mDeleteView;
    private TextView mChatView;

    private ContactItemBean mContactInfo;
    private V2TIMFriendApplication mFriendApplication;
    private OnButtonClickListener mListener;
    private String mId;
    private String mNickname;

    public FriendProfileLayout(Context context) {
        super(context);
        init();
    }

    public FriendProfileLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FriendProfileLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.contact_friend_profile_layout, this);
        mHeadImageView = findViewById(R.id.avatar);
        mNickNameView = findViewById(R.id.name);
        mMobile = findViewById(R.id.mobile);
        mAddWordingView = findViewById(R.id.add_wording);
        mAddWordingView.setSingleLine(false);
        mRemarkView = findViewById(R.id.remark);
        mRemarkView.setOnClickListener(this);
        mChatTopView = findViewById(R.id.chat_to_top);
        mAddBlackView = findViewById(R.id.blackList);
        mDeleteView = findViewById(R.id.btnDel);
        mDeleteView.setOnClickListener(this);
        mChatView = findViewById(R.id.btnChat);
        mChatView.setOnClickListener(this);
        mDepartment = findViewById(R.id.modify_department);
        mPosition = findViewById(R.id.modify_position);
        mCard = findViewById(R.id.modify_card);
        mEmail = findViewById(R.id.modify_email);
    }

    public void initData(Object data) {
        if (data instanceof ChatInfo) {
            ChatInfo mChatInfo = (ChatInfo) data;
            mId = mChatInfo.getId();
            mChatTopView.setVisibility(View.VISIBLE);
            mChatTopView.setChecked(ConversationManagerKit.getInstance().isTopConversation(mId));
            mChatTopView.setCheckListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ConversationManagerKit.getInstance().setConversationTop(mId, isChecked);
                }
            });
            findViewById(R.id.add_wording_layout).setVisibility(GONE);
            findViewById(R.id.dep_layout).setVisibility(VISIBLE);
            loadUserProfile();
            loadUser();
            return;
        } else if (data instanceof ContactItemBean) {
            mContactInfo = (ContactItemBean) data;
            mId = mContactInfo.getId();
            mNickname = mContactInfo.getNickname();
            mRemarkView.setVisibility(VISIBLE);
            mRemarkView.setContent(mContactInfo.getRemark());
            mAddBlackView.setChecked(mContactInfo.isBlackList());
            mAddBlackView.setCheckListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        addBlack();
                    } else {
                        deleteBlack();
                    }
                }
            });
            findViewById(R.id.add_wording_layout).setVisibility(GONE);
            findViewById(R.id.dep_layout).setVisibility(VISIBLE);
            loadUser();
        } else if (data instanceof V2TIMFriendApplication) {
            mFriendApplication = (V2TIMFriendApplication) data;
            mId = mFriendApplication.getUserID();
            mNickname = mFriendApplication.getNickname();
            mAddWordingView.setVisibility(View.VISIBLE);
            mAddWordingView.setText(mFriendApplication.getAddWording());
            mRemarkView.setVisibility(GONE);
            mAddBlackView.setVisibility(GONE);
            mDeleteView.setText(R.string.refuse);
            mDeleteView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    refuse();
                }
            });
            mChatView.setText(R.string.accept);
            mChatView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    accept();
                }
            });
            loadUser();
        } else if (data instanceof GroupApplyInfo) {
            final GroupApplyInfo info = (GroupApplyInfo) data;
            V2TIMGroupApplication item = ((GroupApplyInfo) data).getGroupApplication();
            mId = item.getFromUser();
            mNickname = item.getFromUserNickName();
            mAddWordingView.setVisibility(View.VISIBLE);
            mAddWordingView.setText(item.getRequestMsg());
            mRemarkView.setVisibility(GONE);
            mAddBlackView.setVisibility(GONE);
            mDeleteView.setText(R.string.refuse);
            mDeleteView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    refuseApply(info);
                }
            });
            mChatView.setText(R.string.accept);
            mChatView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    acceptApply(info);
                }
            });
        } else if (data instanceof OpenData) {
            mId = ((OpenData) data).getUserId();
            loadUser();
            mDeleteView.setVisibility(GONE);
            mRemarkView.setVisibility(GONE);
            mAddBlackView.setVisibility(GONE);
            mAddWordingView.setHint(R.string.conversation_wording_send);
            mAddWordingView.setEnabled(true);
            mChatView.setText(R.string.user_add_friends);
            mChatView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    V2TIMFriendAddApplication v2TIMFriendAddApplication = new V2TIMFriendAddApplication(mId);
                    v2TIMFriendAddApplication.setAddWording(mAddWordingView.getText().toString());
                    v2TIMFriendAddApplication.setAddSource("android");
                    V2TIMManager.getFriendshipManager().addFriend(v2TIMFriendAddApplication, new V2TIMValueCallback<V2TIMFriendOperationResult>() {
                        @Override
                        public void onError(int code, String desc) {
                            SLog.e("addFriend err code = " + code + ", desc = " + desc);
                        }

                        @Override
                        public void onSuccess(V2TIMFriendOperationResult v2TIMFriendOperationResult) {
                            SLog.i("addFriend success");
                            switch (v2TIMFriendOperationResult.getResultCode()) {
                                case BaseConstants.ERR_SUCC:
                                    ToastUtil.success(getContext(), "成功");
                                    break;
                                case BaseConstants.ERR_SVR_FRIENDSHIP_INVALID_PARAMETERS:
                                    if (TextUtils.equals(v2TIMFriendOperationResult.getResultInfo(), "Err_SNS_FriendAdd_Friend_Exist")) {
                                        ToastUtil.info(getContext(), "对方已是您的好友");
                                        break;
                                    }
                                case BaseConstants.ERR_SVR_FRIENDSHIP_COUNT_LIMIT:
                                    ToastUtil.info(getContext(), "您的好友数已达系统上限");
                                    break;
                                case BaseConstants.ERR_SVR_FRIENDSHIP_PEER_FRIEND_LIMIT:
                                    ToastUtil.info(getContext(), "对方的好友数已达系统上限");
                                    break;
                                case BaseConstants.ERR_SVR_FRIENDSHIP_IN_SELF_BLACKLIST:
                                    ToastUtil.info(getContext(), "被加好友在自己的黑名单中");
                                    break;
                                case BaseConstants.ERR_SVR_FRIENDSHIP_ALLOW_TYPE_DENY_ANY:
                                    ToastUtil.info(getContext(), "对方已禁止加好友");
                                    break;
                                case BaseConstants.ERR_SVR_FRIENDSHIP_IN_PEER_BLACKLIST:
                                    ToastUtil.info(getContext(), "您已被对方设置为黑名单");
                                    break;
                                case BaseConstants.ERR_SVR_FRIENDSHIP_ALLOW_TYPE_NEED_CONFIRM:
                                    ToastUtil.info(getContext(), "等待好友审核同意");
                                    break;
                                default:
                                    ToastUtil.info(getContext(), v2TIMFriendOperationResult.getResultCode() + " " + v2TIMFriendOperationResult.getResultInfo());
                                    break;
                            }
                            ((Activity) getContext()).finish();
                        }
                    });
                }
            });
        }
        if (!TextUtils.isEmpty(mNickname)) {
            mNickNameView.setText(mNickname);
        }
    }

    private void loadUser() {
        LoginReq loginReq = new LoginReq();
        loginReq.setUserId(mId);
        Yz.getSession().getUserByUserId(loginReq, new OnResultDataListener() {
            @Override
            public void onResult(RequestWork req, ResponseWork resp) {
                if (resp.isSuccess() && resp instanceof LoginResp) {
                    OpenData data = ((LoginResp) resp).getData();
                    if (!TextUtils.isEmpty(data.getUserIcon())) {
                        GlideEngine.loadCornerAvatar(mHeadImageView, data.getUserIcon());
                    }else{
                        GlideEngine.loadImage(mHeadImageView,R.drawable.default_head);
                    }
                    mNickNameView.setText(data.getNickName());
                    mMobile.setText(StringUtils.hideStr(data.getMobile()));
                    mDepartment.setContent(data.getDepartName());
                    mPosition.setContent(data.getPosition());
                    mCard.setContent(data.getCard());
                    mEmail.setContent(data.getEmail());
                }
            }
        });
    }

    private void updateViews(ContactItemBean bean) {
        mContactInfo = bean;
        mChatTopView.setVisibility(View.VISIBLE);
        boolean top = ConversationManagerKit.getInstance().isTopConversation(mId);
        if (mChatTopView.isChecked() != top) {
            mChatTopView.setChecked(top);
        }
        mChatTopView.setCheckListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ConversationManagerKit.getInstance().setConversationTop(mId, isChecked);
            }
        });
        mId = bean.getId();
        mNickname = bean.getNickname();
        if (bean.isFriend()) {
            mRemarkView.setVisibility(VISIBLE);
            mRemarkView.setContent(bean.getRemark());
            mAddBlackView.setVisibility(VISIBLE);
            mAddBlackView.setChecked(bean.isBlackList());
            mAddBlackView.setCheckListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        addBlack();
                    } else {
                        deleteBlack();
                    }
                }
            });
            mDeleteView.setVisibility(VISIBLE);
        } else {
            mRemarkView.setVisibility(GONE);
            mAddBlackView.setVisibility(GONE);
            mDeleteView.setVisibility(GONE);
        }

        if (!TextUtils.isEmpty(mNickname)) {
            mNickNameView.setText(mNickname);
        } else {
            mNickNameView.setText(mId);
        }

        if (!TextUtils.isEmpty(bean.getAvatarurl())) {
            GlideEngine.loadCornerAvatar(mHeadImageView, bean.getAvatarurl());
        }else{
            GlideEngine.loadImage(mHeadImageView,R.drawable.default_head);
        }
//        mMobile.setText(mId);
    }

    private void loadUserProfile() {
        ArrayList<String> list = new ArrayList<>();
        list.add(mId);
        final ContactItemBean bean = new ContactItemBean();
        bean.setFriend(false);

        V2TIMManager.getInstance().getUsersInfo(list, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("loadUserProfile err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess(List<V2TIMUserFullInfo> v2TIMUserFullInfos) {
                if (v2TIMUserFullInfos == null || v2TIMUserFullInfos.size() != 1) {
                    return;
                }
                final V2TIMUserFullInfo timUserFullInfo = v2TIMUserFullInfos.get(0);
                bean.setNickname(timUserFullInfo.getNickName());
                bean.setId(timUserFullInfo.getUserID());
                bean.setAvatarurl(timUserFullInfo.getFaceUrl());
                updateViews(bean);
            }
        });

        V2TIMManager.getFriendshipManager().getBlackList(new V2TIMValueCallback<List<V2TIMFriendInfo>>() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("getBlackList err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess(List<V2TIMFriendInfo> v2TIMFriendInfos) {
                if (v2TIMFriendInfos != null && v2TIMFriendInfos.size() > 0) {
                    for (V2TIMFriendInfo friendInfo : v2TIMFriendInfos) {
                        if (TextUtils.equals(friendInfo.getUserID(), mId)) {
                            bean.setBlackList(true);
                            updateViews(bean);
                            break;
                        }
                    }
                }
            }
        });

        V2TIMManager.getFriendshipManager().getFriendList(new V2TIMValueCallback<List<V2TIMFriendInfo>>() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("getFriendList err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess(List<V2TIMFriendInfo> v2TIMFriendInfos) {
                if (v2TIMFriendInfos != null && v2TIMFriendInfos.size() > 0) {
                    for (V2TIMFriendInfo friendInfo : v2TIMFriendInfos) {
                        if (TextUtils.equals(friendInfo.getUserID(), mId)) {
                            bean.setFriend(true);
                            bean.setRemark(friendInfo.getFriendRemark());
                            bean.setAvatarurl(friendInfo.getUserProfile().getFaceUrl());
                            break;
                        }
                    }
                }
                updateViews(bean);
            }
        });
    }

    private void accept() {
        V2TIMManager.getFriendshipManager().acceptFriendApplication(
                mFriendApplication, V2TIMFriendApplication.V2TIM_FRIEND_ACCEPT_AGREE_AND_ADD, new V2TIMValueCallback<V2TIMFriendOperationResult>() {
                    @Override
                    public void onError(int code, String desc) {
                        SLog.e("accept err code = " + code + ", desc = " + desc);
                    }

                    @Override
                    public void onSuccess(V2TIMFriendOperationResult v2TIMFriendOperationResult) {
                        SLog.i("accept success");
                        mChatView.setText(R.string.accepted);
                        ((Activity) getContext()).finish();
                    }
                });
    }

    private void refuse() {
        V2TIMManager.getFriendshipManager().refuseFriendApplication(mFriendApplication, new V2TIMValueCallback<V2TIMFriendOperationResult>() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("accept err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess(V2TIMFriendOperationResult v2TIMFriendOperationResult) {
                SLog.i("refuse success");
                mDeleteView.setText(R.string.refused);
                ((Activity) getContext()).finish();
            }
        });
    }

    public void acceptApply(final GroupApplyInfo item) {
        GroupChatManagerKit.getInstance().getProvider().acceptApply(item, new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                Intent intent = new Intent();
                intent.putExtra(TUIKitConstants.Group.MEMBER_APPLY, item);
                ((Activity) getContext()).setResult(Activity.RESULT_OK, intent);
                ((Activity) getContext()).finish();
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                ToastUtil.error(getContext(), errMsg);
            }
        });
    }

    public void refuseApply(final GroupApplyInfo item) {
        GroupChatManagerKit.getInstance().getProvider().refuseApply(item, new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                Intent intent = new Intent();
                intent.putExtra(TUIKitConstants.Group.MEMBER_APPLY, item);
                ((Activity) getContext()).setResult(Activity.RESULT_OK, intent);
                ((Activity) getContext()).finish();
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                ToastUtil.error(getContext(), errMsg);
            }
        });
    }

    private void delete() {
        List<String> identifiers = new ArrayList<>();
        identifiers.add(mId);

        V2TIMManager.getFriendshipManager().deleteFromFriendList(identifiers, V2TIMFriendInfo.V2TIM_FRIEND_TYPE_BOTH, new V2TIMValueCallback<List<V2TIMFriendOperationResult>>() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("deleteFriends err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess(List<V2TIMFriendOperationResult> v2TIMFriendOperationResults) {
                SLog.i("deleteFriends success");
                ConversationManagerKit.getInstance().deleteConversation(mId, false);
                if (mListener != null) {
                    mListener.onDeleteFriendClick(mId);
                }
//                ((Activity) getContext()).finish();
            }
        });
    }

    private void chat() {
        if (mListener != null && mContactInfo != null) {
            mListener.onStartConversationClick(mContactInfo);
        }
        ((Activity) getContext()).finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnChat) {
            chat();
        } else if (v.getId() == R.id.btnDel) {
            delete();
        } else if (v.getId() == R.id.remark) {
            Bundle bundle = new Bundle();
            bundle.putString(TUIKitConstants.Selection.TITLE, getResources().getString(R.string.profile_remark_edit));
            bundle.putString(TUIKitConstants.Selection.INIT_CONTENT, mRemarkView.getContent());
            bundle.putInt(TUIKitConstants.Selection.LIMIT, 20);
            SelectionActivity.startTextSelection(TUIKit.getAppContext(), bundle, new SelectionActivity.OnResultReturnListener() {
                @Override
                public void onReturn(Object text) {
                    mRemarkView.setContent(text.toString());
                    if (TextUtils.isEmpty(text.toString())) {
                        text = "";
                    }
                    modifyRemark(text.toString());
                }
            });
        }
    }

    private void modifyRemark(final String txt) {
        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
        v2TIMFriendInfo.setUserID(mId);
        v2TIMFriendInfo.setFriendRemark(txt);

        V2TIMManager.getFriendshipManager().setFriendInfo(v2TIMFriendInfo, new V2TIMCallback() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("modifyRemark err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess() {
                mContactInfo.setRemark(txt);
                SLog.i("modifyRemark success");
            }
        });
    }

    private void addBlack() {
        String[] idStringList = mId.split(",");
        List<String> idList = new ArrayList<>(Arrays.asList(idStringList));
        V2TIMManager.getFriendshipManager().addToBlackList(idList, new V2TIMValueCallback<List<V2TIMFriendOperationResult>>() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("addBlackList err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess(List<V2TIMFriendOperationResult> v2TIMFriendOperationResults) {
                SLog.v("addBlackList success");
            }
        });
    }

    private void deleteBlack() {
        String[] idStringList = mId.split(",");
        List<String> idList = new ArrayList<>(Arrays.asList(idStringList));
        V2TIMManager.getFriendshipManager().deleteFromBlackList(idList, new V2TIMValueCallback<List<V2TIMFriendOperationResult>>() {
            @Override
            public void onError(int code, String desc) {
                SLog.e("deleteBlackList err code = " + code + ", desc = " + desc);
            }

            @Override
            public void onSuccess(List<V2TIMFriendOperationResult> v2TIMFriendOperationResults) {
                SLog.i("deleteBlackList success");
            }
        });
    }

    public void setOnButtonClickListener(OnButtonClickListener l) {
        mListener = l;
    }

    public interface OnButtonClickListener {
        void onStartConversationClick(ContactItemBean info);

        void onDeleteFriendClick(String id);
    }

}
