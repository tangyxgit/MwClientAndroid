package com.mwim.qcloud.tim.uikit.business.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.work.api.open.model.client.OpenData;
import com.work.util.StringUtils;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/9/15
 * email tangyx@live.com
 */

public class SearchAddMoreAdapter extends BaseQuickAdapter<OpenData, BaseViewHolder> {

    public SearchAddMoreAdapter(@Nullable List<OpenData> data) {
        super(R.layout.contact_new_friend_item_search,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OpenData item) {
        ImageView mAvatar = helper.getView(R.id.avatar);
        if(TextUtils.isEmpty(item.getUserIcon())){
            GlideEngine.loadImage(mAvatar,R.drawable.default_head);
        }else{
            GlideEngine.loadCornerImage(mAvatar,item.getUserIcon(),null,10);
        }
        helper.setText(R.id.name,item.getNickName());
        helper.setText(R.id.description, StringUtils.hideStr(item.getMobile()));
    }
}