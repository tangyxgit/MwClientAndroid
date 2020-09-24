package com.mwim.qcloud.tim.uikit.business.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.http.network.listener.OnResultDataListener;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseFragment;
import com.work.api.open.Yz;

/**
 * Created by tangyx
 * Date 2020/9/21
 * email tangyx@live.com
 */

public class WorkFragment extends BaseFragment implements OnResultDataListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_work, container, false);
        Yz.getSession().getToolListByUserId(this);
        return baseView;
    }

    @Override
    public void onResult(RequestWork req, ResponseWork resp) {

    }
}
