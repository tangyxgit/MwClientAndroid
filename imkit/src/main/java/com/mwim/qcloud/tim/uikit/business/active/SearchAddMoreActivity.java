package com.mwim.qcloud.tim.uikit.business.active;


import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.divider.HorizontalDividerItemDecoration;
import com.http.network.model.RequestWork;
import com.http.network.model.ResponseWork;
import com.mwim.qcloud.tim.uikit.R;
import com.mwim.qcloud.tim.uikit.business.adapter.SearchAddMoreAdapter;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.work.api.open.Yz;
import com.work.api.open.model.GetUserByParamReq;
import com.work.api.open.model.GetUserByParamResp;
import com.work.api.open.model.client.OpenData;

/**
 * Created by tangyx
 * Date 2020/9/15
 * email tangyx@live.com
 */

public class SearchAddMoreActivity extends IMBaseActivity implements View.OnClickListener, TextWatcher, BaseQuickAdapter.OnItemClickListener {

    private EditText mSearch;
    private GetUserByParamReq mUserByParamReq;
    private SearchAddMoreAdapter mAdapter;

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        mSearch = findViewById(R.id.search);
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).colorResId(R.color.background_color).build());
        mAdapter = new SearchAddMoreAdapter(null);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onInitValue() throws Exception {
        super.onInitValue();
        mSearch.requestFocus();
        mSearch.addTextChangedListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(mUserByParamReq == null){
            mUserByParamReq = new GetUserByParamReq();
        }
        if(TextUtils.isEmpty(charSequence)){
            mAdapter.clear();
        }else{
            mUserByParamReq.setParam(charSequence.toString().trim());
            Yz.getSession().getUserByParam(mUserByParamReq,this);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onResult(RequestWork req, ResponseWork resp) throws Exception {
        super.onResult(req, resp);
        if(resp.isSuccess()){
            if(resp instanceof GetUserByParamResp){
                if(TextUtils.isEmpty(mSearch.getText())){
                    mAdapter.clear();
                }else{
                    mAdapter.setNewData(((GetUserByParamResp) resp).getData());
                }
            }
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        OpenData item = mAdapter.getItem(position);
        if(item!=null){
            Intent intent = new Intent(this, FriendProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(TUIKitConstants.ProfileType.CONTENT, item);
            startActivity(intent);
        }
    }
}
