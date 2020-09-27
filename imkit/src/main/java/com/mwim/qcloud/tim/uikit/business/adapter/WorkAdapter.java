package com.mwim.qcloud.tim.uikit.business.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mwim.qcloud.tim.uikit.R;
import com.work.api.open.model.client.OpenWork;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/9/27
 * email tangyx@live.com
 */

public class WorkAdapter extends BaseQuickAdapter<OpenWork, BaseViewHolder> {

    public WorkAdapter(@Nullable List<OpenWork> data) {
        super(R.layout.adapter_work_item,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OpenWork item) {
        helper.setText(R.id.title,item.getToolCategory());
        RecyclerView recyclerView = helper.getView(R.id.recycler_view);
        WorkAppAdapter mAdapter = (WorkAppAdapter) recyclerView.getAdapter();
        if(mAdapter==null){
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
            mAdapter = new WorkAppAdapter(item.getToolDataList());
            recyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.setNewData(item.getToolDataList());
        }
    }
}