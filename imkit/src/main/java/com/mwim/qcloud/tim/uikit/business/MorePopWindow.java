package com.mwim.qcloud.tim.uikit.business;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.mwim.qcloud.tim.uikit.R;
import com.work.util.SizeUtils;

import android.view.ViewGroup.LayoutParams;

/**
 * Created by tangyx
 * Date 2020/11/19
 * email tangyx@live.com
 */

public class MorePopWindow extends PopupWindow {

    public MorePopWindow(final Activity context, View.OnClickListener listener) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.pop_menu_conversation, null);

        // 设置SelectPicPopupWindow的View
        this.setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);

        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationMainTitleMore);
        contentView.findViewById(R.id.add_friends).setOnClickListener(listener);
        contentView.findViewById(R.id.add_group).setOnClickListener(listener);
    }


    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAtLocation(parent, Gravity.END | Gravity.TOP,SizeUtils.dp2px(parent.getContext(),8) , SizeUtils.dp2px(parent.getContext(),60));
        } else {
            this.dismiss();
        }
    }
}
