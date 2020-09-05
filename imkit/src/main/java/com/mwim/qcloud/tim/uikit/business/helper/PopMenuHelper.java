package com.mwim.qcloud.tim.uikit.business.helper;


import android.content.Context;
import android.view.View;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;

import com.mwim.qcloud.tim.uikit.R;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2019/4/25
 * Description
 */

public class PopMenuHelper {

    private PopupMenu mMenu;
    private int mMenuRes;
    private View mAnchor;
    private PopupMenu.OnMenuItemClickListener mOnMenuItemClickListener;

    public PopMenuHelper(@MenuRes int mMenuRes, View mAnchor, PopupMenu.OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mMenuRes = mMenuRes;
        this.mAnchor = mAnchor;
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }

    public PopMenuHelper(View mAnchor, PopupMenu.OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mAnchor = mAnchor;
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }

    public void showMenu(@NonNull Context context){
        if(mMenu==null){
            mMenu = createMenu(context);
            mMenu.inflate(mMenuRes);
            try {
                Field field = mMenu.getClass().getDeclaredField("mPopup");
                field.setAccessible(true);
                MenuPopupHelper mHelper = (MenuPopupHelper) field.get(mMenu);
                mHelper.setForceShowIcon(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mMenu.show();
    }
    public PopupMenu createMenu(Context context){
        ContextThemeWrapper contextThemeWrapper =
                new ContextThemeWrapper(context, R.style.PopMenuStyle);
        mMenu = new PopupMenu(contextThemeWrapper,mAnchor);
        mMenu.setOnMenuItemClickListener(mOnMenuItemClickListener);
        return mMenu;
    }

    public PopupMenu getMenu() {
        return mMenu;
    }
}
