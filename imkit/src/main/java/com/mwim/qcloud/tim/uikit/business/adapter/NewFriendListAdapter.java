package com.mwim.qcloud.tim.uikit.business.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.mwim.qcloud.tim.uikit.utils.DemoLog;
import com.tencent.imsdk.v2.V2TIMFriendApplication;
import com.tencent.imsdk.v2.V2TIMFriendOperationResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.mwim.qcloud.tim.uikit.R;
import com.work.util.SLog;

import java.util.List;

/**
 * 好友关系链管理消息adapter
 */
public class NewFriendListAdapter extends BaseQuickAdapter<V2TIMFriendApplication, BaseViewHolder> {

    public NewFriendListAdapter(@Nullable List<V2TIMFriendApplication> data) {
        super(R.layout.contact_new_friend_item, data);
    }

    private void doResponse(final Button view, V2TIMFriendApplication data) {
        V2TIMManager.getFriendshipManager().acceptFriendApplication(
                data, V2TIMFriendApplication.V2TIM_FRIEND_ACCEPT_AGREE_AND_ADD, new V2TIMValueCallback<V2TIMFriendOperationResult>() {
                    @Override
                    public void onError(int code, String desc) {
                        SLog.e("deleteFriends err code = " + code + ", desc = " + desc);
                    }

                    @Override
                    public void onSuccess(V2TIMFriendOperationResult v2TIMFriendOperationResult) {
                        DemoLog.i(TAG, "deleteFriends success");
                        view.setText(getContext().getResources().getString(R.string.request_accepted));
                        view.setBackgroundColor(Color.TRANSPARENT);
                    }
                });
    }

    @Override
    protected void convert(BaseViewHolder helper, final V2TIMFriendApplication item) {
        ImageView mAvatar = helper.getView(R.id.avatar);
        if(TextUtils.isEmpty(item.getFaceUrl())){
            GlideEngine.loadImage(mAvatar, R.drawable.default_head);
        }else{
            GlideEngine.loadCornerImage(mAvatar, item.getFaceUrl(),null,10);
        }
        helper.setText(R.id.name,TextUtils.isEmpty(item.getNickname()) ? item.getUserID() : item.getNickname());
        TextView mDesc = helper.getView(R.id.description);
        if(TextUtils.isEmpty(item.getAddWording())){
            mDesc.setVisibility(View.GONE);
        }else{
            mDesc.setVisibility(View.VISIBLE);
            mDesc.setText(item.getAddWording());
        }
        Button mAgree = helper.getView(R.id.agree);
        switch (item.getType()) {
            case V2TIMFriendApplication.V2TIM_FRIEND_APPLICATION_COME_IN:
                mAgree.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.background_color));
                mAgree.setText(R.string.request_agree);
                mAgree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Button vv = (Button) v;
                        doResponse(vv, item);
                    }
                });
                break;
            case V2TIMFriendApplication.V2TIM_FRIEND_APPLICATION_SEND_OUT:
                mAgree.setBackgroundColor(Color.TRANSPARENT);
                mAgree.setText(R.string.request_waiting);
                break;
            case V2TIMFriendApplication.V2TIM_FRIEND_APPLICATION_BOTH:
                mAgree.setBackgroundColor(Color.TRANSPARENT);
                mAgree.setText(R.string.request_accepted);
                break;
        }
    }

}
