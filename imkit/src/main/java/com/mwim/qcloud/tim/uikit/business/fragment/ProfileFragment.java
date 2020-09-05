package com.mwim.qcloud.tim.uikit.business.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.mwim.qcloud.tim.uikit.IMKitAgent;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseFragment;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.component.dialog.TUIKitDialog;
import com.mwim.qcloud.tim.uikit.utils.ToastUtil;


public class ProfileFragment extends BaseFragment {

    private View mBaseView;
    private ProfileLayout mProfileLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mBaseView = inflater.inflate(R.layout.profile_fragment, container, false);
        initView();
        return mBaseView;
    }

    private void initView() {
        mProfileLayout = mBaseView.findViewById(R.id.profile_view);
        mBaseView.findViewById(R.id.logout_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TUIKitDialog(getActivity())
                        .builder()
                        .setCancelable(true)
                        .setCancelOutside(true)
                        .setTitle("您确定要退出登录么？")
                        .setDialogWidth(0.75f)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                IMKitAgent.logout(new IUIKitCallBack() {

                                    @Override
                                    public void onSuccess(Object data) {
                                        logout();
                                    }

                                    @Override
                                    public void onError(String module, int errCode, String errMsg) {
                                        ToastUtil.toastLongMessage("logout fail: " + errCode + "=" + errMsg);
                                        logout();
                                    }

                                    private void logout() {
                                        IMKitAgent.logout(null);
                                        IMKitAgent.unInit();
                                        if (getActivity() != null) {
                                            getActivity().finish();
                                        }
                                    }
                                } );
                            }
                        })
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();

            }
        });

    }
}
