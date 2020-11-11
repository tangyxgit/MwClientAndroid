package com.mwim.qcloud.tim.uikit.modules.chat.layout.message.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.business.active.MapLocationActivity;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.mwim.qcloud.tim.uikit.modules.message.MessageInfo;
import com.tencent.imsdk.v2.V2TIMLocationElem;
import com.work.util.SizeUtils;

/**
 * Created by tangyx
 * Date 2020/11/11
 * email tangyx@live.com
 */

public class MessageLocationHolder extends MessageContentHolder {

    private View mLayout;
    private TextView mTitle;
    private TextView mAddress;
    private ImageView mImage;

    public MessageLocationHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void layoutVariableViews(MessageInfo msg, int position) {
        final V2TIMLocationElem locationElem = msg.getTimMessage().getLocationElem();
        String desc = locationElem.getDesc();
        String[] s = desc.split("##");
        final String title;
        final String address;
        if(s.length>1){
            mAddress.setVisibility(View.VISIBLE);
            title = s[0];
            address = s[1];
        }else{
            title = desc;
            address = "";
            mAddress.setVisibility(View.GONE);
        }
        mTitle.setText(title);
        mAddress.setText(address);
        GlideEngine.loadImage(mImage,R.drawable.img_location_default, SizeUtils.dp2px(itemView.getContext(),5),true,true,false,false);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapLocationActivity.launcherLocation(itemView.getContext(),title,address,locationElem.getLatitude(),locationElem.getLongitude());
            }
        });
    }

    @Override
    public int getVariableLayout() {
        return R.layout.message_adapter_content_location;
    }

    @Override
    public void initVariableViews() {
        mLayout = rootView.findViewById(R.id.location_layout);
        mTitle = rootView.findViewById(R.id.title);
        mAddress = rootView.findViewById(R.id.address);
        mImage = rootView.findViewById(R.id.image);
    }
}
