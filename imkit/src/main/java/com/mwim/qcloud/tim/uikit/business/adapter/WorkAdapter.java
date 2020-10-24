package com.mwim.qcloud.tim.uikit.business.adapter;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.divider.HorizontalDividerItemDecoration;
import com.http.network.listener.OnResultDataListener;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.business.active.WebActivity;
import com.mwim.qcloud.tim.uikit.business.modal.UserApi;
import com.mwim.qcloud.tim.uikit.business.helper.WemeetSdkHelper;
import com.work.api.open.Yz;
import com.work.api.open.model.GetCarWebViewUrlResp;
import com.work.api.open.model.GetToolTokenReq;
import com.work.api.open.model.GetToolTokenResp;
import com.work.api.open.model.client.OpenData;
import com.work.api.open.model.client.OpenWork;
import com.work.util.ToastUtil;

import java.util.List;

/**
 * Created by tangyx
 * Date 2020/9/27
 * email tangyx@live.com
 */

public class WorkAdapter extends BaseQuickAdapter<OpenWork, BaseViewHolder> implements OnResultDataListener{

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
            recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).color(Color.TRANSPARENT).sizeResId(R.dimen.dp_30).build());
            mAdapter = new WorkAppAdapter(item.getToolDataList());
            recyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    OpenData data = (OpenData) adapter.getItem(position);
                    if(data!=null){
                        if("code001".equals(data.getToolCode()) //腾讯会议
                                || "code002".equals(data.getToolCode())//网盘
                                || "code003".equals(data.getToolCode())){//打车
                            if(getContext() instanceof BaseActivity){
                                ((BaseActivity) getContext()).showProgressLoading(false,false);
                            }
                            if("code001".equals(data.getToolCode())){
                                WemeetSdkHelper.init(getContext());
                            }
                            GetToolTokenReq getToolTokenReq = new GetToolTokenReq();
                            getToolTokenReq.setToolCode(data.getToolCode());
                            getToolTokenReq.setUserName(UserApi.instance().getNickName());
                            Yz.getSession().getToolToken(getToolTokenReq, WorkAdapter.this,data.getToolUrl());
                        }else{
                            WebActivity.startWebView(data.getToolUrl());
                        }
                    }
                }
            });
        }else{
            mAdapter.setNewData(item.getToolDataList());
        }
    }

    @Override
    public void onResult(RequestWork req, ResponseWork resp) throws Exception{
        if(getContext() instanceof BaseActivity){
            ((BaseActivity) getContext()).onResult(req,resp);
        }
        if(resp.isSuccess()){
            if(req instanceof GetToolTokenReq && resp instanceof GetToolTokenResp){
                String token = ((GetToolTokenResp) resp).getData();
                String url = resp.getPositionParams(0);
                if("code001".equals(((GetToolTokenReq) req).getToolCode())){//腾讯会议
                    WemeetSdkHelper.startAuth(url+"eyJraWQiOiI3IiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJ5dWFuemhpX3Rlc3QwMSIsImlzcyI6InRlbmNlbnQgbWVldGluZyIsIm5hbWUiOiJ5dWFuemhpX3Rlc3QwMSIsImV4cCI6MTYwNjU1Mjk2NiwiaWF0IjoxNjAxMzg3MTY2fQ.XljVdtibXPxg29VM4kDFejlJoSyx1RXoWsXlyZhj_IplgMAtwMctEqVO84seGQxVMKcYUMi-7YiQRTph1-nzg1JuxVvruLVQnYSm3iIWrmj9XgHbbOWVAP1oA5XZfDOHG2QGev4OgWxwS6l1SZNLJLUunHy4UlwTqQvzDbQyZ7-WubJ5balAre30DkYNAyxI2IE5DXOgSpSFeHF30aQiq-4WGxREF84uP--43TXKfd5H76ZyDdluKzmEXoQBJywnK9KOwLOrTB4u7nyB_MnNMH9a33IESwa1ePIZklsQsDnxZnp8M-7o32Pa--D5krq0dR2UeqrHvgqPlRPFVKD9Tg");
                }else if("code002".equals(((GetToolTokenReq) req).getToolCode())){//网盘
                    WebActivity.startWebView(url+"?token="+token);
                }else if("code003".equals(((GetToolTokenReq) req).getToolCode())){//打车
                    Yz.getSession().getCarWebViewUrl(url+token,WorkAdapter.this);
                }
            }else if(resp instanceof GetCarWebViewUrlResp){
                OpenData result = ((GetCarWebViewUrlResp) resp).Result;
                if(result!=null){
                    WebActivity.startWebView(result.getUrl(),"hsh_android",true);
                }
            }
        }else{
            ToastUtil.warning(getContext(),resp.getMessage());
        }
    }
}
