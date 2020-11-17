package com.mwim.qcloud.tim.uikit.business.helper;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.business.active.WebActivity;
import com.mwim.qcloud.tim.uikit.business.message.CustomMessage;
import com.mwim.qcloud.tim.uikit.component.picture.imageEngine.impl.GlideEngine;
import com.mwim.qcloud.tim.uikit.modules.chat.layout.message.holder.ICustomMessageViewGroup;
import com.mwim.qcloud.tim.uikit.R;

public class CustomIMUIController {


    public static void onDraw(ICustomMessageViewGroup parent, final CustomMessage data) {
        // 把自定义消息view添加到TUIKit内部的父容器里
        View view = LayoutInflater.from(IMKitAgent.instance()).inflate(R.layout.test_custom_message_layout1, null, false);
        parent.addMessageContentView(view);

        // 自定义消息view的实现，这里仅仅展示文本信息，并且实现超链接跳转
        TextView mTitle = view.findViewById(R.id.title);
        TextView mDesc = view.findViewById(R.id.desc);
        ImageView mLogo = view.findViewById(R.id.logo);
        final String text = "不支持的自定义消息";
        if (data == null) {
            mTitle.setText(text);
        } else {
            mTitle.setText(data.title);
            mDesc.setText(data.desc);
            GlideEngine.loadImage(mLogo,data.logo);
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebActivity.startWebView(data.link);
                }
            });
        }
    }
}
