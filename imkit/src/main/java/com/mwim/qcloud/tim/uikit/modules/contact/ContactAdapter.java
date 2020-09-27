package com.mwim.qcloud.tim.uikit.modules.contact;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mwim.qcloud.tim.uikit.modules.conversation.base.ConversationIconView;
import com.tencent.imsdk.v2.V2TIMFriendApplicationResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.TUIKit;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.mwim.qcloud.tim.uikit.utils.ToastUtil;
import com.work.util.SizeUtils;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    protected List<ContactItemBean> mData;
    protected LayoutInflater mInflater;
    private ContactListView.OnSelectChangedListener mOnSelectChangedListener;
    private ContactListView.OnItemClickListener mOnClickListener;

    private int mPreSelectedPosition;
    private boolean isSingleSelectMode;

    public ContactAdapter(List<ContactItemBean> data) {
        this.mData = data;
        mInflater = LayoutInflater.from(TUIKit.getAppContext());
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactAdapter.ViewHolder(mInflater.inflate(R.layout.contact_selecable_adapter_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ContactAdapter.ViewHolder holder, final int position) {
        final ContactItemBean contactBean = mData.get(position);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.line.getLayoutParams();
        if (position < mData.size() - 1) {
            String tag1 = contactBean.getSuspensionTag();
            String tag2 = mData.get(position + 1).getSuspensionTag();
            // tag不同时对item的分割线进行重新处理
            if (TextUtils.equals(tag1, tag2)) {
                params.leftMargin = holder.tvName.getLeft();
            } else {
                params.leftMargin = 0;
            }
        } else {
            params.leftMargin = 0;
        }
        holder.line.setLayoutParams(params);
        if (!TextUtils.isEmpty(contactBean.getRemark())) {
            holder.tvName.setText(contactBean.getRemark());
        } else if (!TextUtils.isEmpty(contactBean.getNickname())) {
            holder.tvName.setText(contactBean.getNickname());
        } else {
            holder.tvName.setText(contactBean.getId());
        }
        if (mOnSelectChangedListener != null) {
            holder.ccSelect.setVisibility(View.VISIBLE);
            holder.ccSelect.setChecked(contactBean.isSelected());
        }

        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!contactBean.isEnable()) {
                    return;
                }
                holder.ccSelect.setChecked(!holder.ccSelect.isChecked());
                if (mOnSelectChangedListener != null) {
                    mOnSelectChangedListener.onSelectChanged(getItem(position), holder.ccSelect.isChecked());
                }
                contactBean.setSelected(holder.ccSelect.isChecked());
                if (mOnClickListener != null) {
                    mOnClickListener.onItemClick(position, contactBean);
                }
                if (isSingleSelectMode && position != mPreSelectedPosition && contactBean.isSelected()) {
                    //单选模式的prePos处理
                    mData.get(mPreSelectedPosition).setSelected(false);
                    notifyItemChanged(mPreSelectedPosition);
                }
                mPreSelectedPosition = position;
            }
        });
        holder.unreadText.setVisibility(View.GONE);
        if (TextUtils.equals(TUIKit.getAppContext().getResources().getString(R.string.new_friend), contactBean.getId())) {
//            holder.avatar.setImageResource(R.drawable.group_new_friend);
//            holder.avatar.setDefaultImageResId(R.drawable.group_new_friend);
            Drawable drawable = ContextCompat.getDrawable(holder.avatar.getContext(),R.drawable.icon_add_contact_stroke);
            if(drawable!=null){
                drawable.setColorFilter(ContextCompat.getColor(holder.avatar.getContext(),R.color.defaultColorAccent), PorterDuff.Mode.SRC_ATOP);
            }
            holder.avatar.setBackground(drawable);
            holder.avatar.getLayoutParams().width = SizeUtils.dp2px(holder.avatar.getContext(),24);
            holder.avatar.getLayoutParams().height = SizeUtils.dp2px(holder.avatar.getContext(),24);
            V2TIMManager.getFriendshipManager().getFriendApplicationList(new V2TIMValueCallback<V2TIMFriendApplicationResult>() {
                @Override
                public void onError(int code, String desc) {
                    ToastUtil.toastShortMessage("Error code = " + code + ", desc = " + desc);
                }

                @Override
                public void onSuccess(V2TIMFriendApplicationResult v2TIMFriendApplicationResult) {
                    if (v2TIMFriendApplicationResult.getFriendApplicationList() != null) {
                        int pendingRequest = v2TIMFriendApplicationResult.getFriendApplicationList().size();
                        if (pendingRequest == 0) {
                            holder.unreadText.setVisibility(View.GONE);
                        } else {
                            holder.unreadText.setVisibility(View.VISIBLE);
                            holder.unreadText.setText("" + pendingRequest);
                        }
                    }
                }
            });
        } else if (TextUtils.equals(TUIKit.getAppContext().getResources().getString(R.string.group), contactBean.getId())) {
//            holder.avatar.setImageResource(R.drawable.group_common_list);
//            holder.avatar.setDefaultImageResId(R.drawable.group_common_list);
            Drawable drawable = ContextCompat.getDrawable(holder.avatar.getContext(),R.drawable.icon_chat_group_stroke);
            if(drawable!=null){
                drawable.setColorFilter(ContextCompat.getColor(holder.avatar.getContext(),R.color.color_fdac3b), PorterDuff.Mode.SRC_ATOP);
            }
            holder.avatar.setBackground(drawable);
            holder.avatar.getLayoutParams().width = SizeUtils.dp2px(holder.avatar.getContext(),24);
            holder.avatar.getLayoutParams().height = SizeUtils.dp2px(holder.avatar.getContext(),24);
        } else if (TextUtils.equals(TUIKit.getAppContext().getResources().getString(R.string.blacklist), contactBean.getId())) {
//            holder.avatar.setImageResource(R.drawable.group_black_list);
//            holder.avatar.setDefaultImageResId(R.drawable.group_black_list);
            Drawable drawable = ContextCompat.getDrawable(holder.avatar.getContext(),R.drawable.icon_block_fill);
            if(drawable!=null){
                drawable.setColorFilter(ContextCompat.getColor(holder.avatar.getContext(),R.color.color_999999), PorterDuff.Mode.SRC_ATOP);
            }
            holder.avatar.setBackground(drawable);
            holder.avatar.getLayoutParams().width = SizeUtils.dp2px(holder.avatar.getContext(),24);
            holder.avatar.getLayoutParams().height = SizeUtils.dp2px(holder.avatar.getContext(),24);
        } else {
            if (contactBean.getIconUrlList()==null) {
                holder.avatar.setDefaultImageResId(R.drawable.default_head);
            } else {
//                GlideEngine.loadCornerImage(holder.avatar, contactBean.getAvatarurl(),null,10);
                holder.avatar.setIconUrls(contactBean.getIconUrlList());
            }
            holder.avatar.getLayoutParams().width = SizeUtils.dp2px(holder.avatar.getContext(),49);
            holder.avatar.getLayoutParams().height = SizeUtils.dp2px(holder.avatar.getContext(),49);
        }

    }

    @Override
    public void onViewRecycled(ContactAdapter.ViewHolder holder) {
        if (holder != null) {
//            GlideEngine.clear(holder.avatar);
//            holder.avatar.setImageResource(0);

        }
        super.onViewRecycled(holder);
    }

    private ContactItemBean getItem(int position) {
        if (position < mData.size()) {
            return mData.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public void setDataSource(List<ContactItemBean> datas) {
        this.mData = datas;
        notifyDataSetChanged();
    }

    public void setSingleSelectMode(boolean mode) {
        isSingleSelectMode = mode;
    }

    public void setOnSelectChangedListener(ContactListView.OnSelectChangedListener selectListener) {
        mOnSelectChangedListener = selectListener;
    }

    public void setOnItemClickListener(ContactListView.OnItemClickListener listener) {
        mOnClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView unreadText;
        ConversationIconView avatar;
        CheckBox ccSelect;
        View content;
        View line;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCity);
            unreadText = itemView.findViewById(R.id.conversation_unread);
            unreadText.setVisibility(View.GONE);
            avatar = itemView.findViewById(R.id.ivAvatar);
            ccSelect = itemView.findViewById(R.id.contact_check_box);
            content = itemView.findViewById(R.id.selectable_contact_item);
            line = itemView.findViewById(R.id.view_line);
        }
    }
}
