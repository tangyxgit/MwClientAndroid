package com.mwim.qcloud.tim.uikit.modules.chat.layout.message.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.business.Constants;
import com.mwim.qcloud.tim.uikit.business.active.WebActivity;
import com.mwim.qcloud.tim.uikit.modules.message.MessageInfo;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.component.face.FaceManager;
import com.work.util.StringUtils;

public class MessageTextHolder extends MessageContentHolder {

    private TextView msgBodyText;

    public MessageTextHolder(View itemView) {
        super(itemView);
    }

    @Override
    public int getVariableLayout() {
        return R.layout.message_adapter_content_text;
    }

    @Override
    public void initVariableViews() {
        msgBodyText = rootView.findViewById(R.id.msg_body_tv);
    }

    @Override
    public void layoutVariableViews(final MessageInfo msg, final int position) {
        msgBodyText.setVisibility(View.VISIBLE);
        if (msg.getExtra() != null) {
            FaceManager.handlerEmojiText(msgBodyText, msg.getExtra().toString(), false, ContextCompat.getColor(IMKitAgent.instance(), msg.isSelf() ? R.color.white : R.color.black), new StringUtils.OnSpanClickListener() {
                @Override
                public void onClickSpan(String content) {
                    WebActivity.startWebView(content);
                }

                @Override
                public void onLongClickSpan() {
                    if(onItemClickListener!=null){
                        onItemClickListener.onMessageLongClick(msgContentFrame,position,msg);
                    }
                }
            });
        }
        if(msg.isSelf()){
            msgBodyText.setTextColor(Color.WHITE);
        }else{
            msgBodyText.setTextColor(Color.BLACK);
        }
        if (properties.getChatContextFontSize() != 0) {
            msgBodyText.setTextSize(properties.getChatContextFontSize());
        }
        if (msg.isSelf()) {
            if (properties.getRightChatContentFontColor() != 0) {
                msgBodyText.setTextColor(properties.getRightChatContentFontColor());
            }
        } else {
            if (properties.getLeftChatContentFontColor() != 0) {
                msgBodyText.setTextColor(properties.getLeftChatContentFontColor());
            }
        }
    }

}
