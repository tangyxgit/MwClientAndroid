package com.work.api.open;


import com.http.network.RequestParams;
import com.http.network.listener.OnResultDataListener;
import com.http.network.task.ConnectDataTask;
import com.work.api.open.contacts.ModeApi;
import com.work.api.open.model.BaseReq;
import com.work.api.open.model.BaseResp;
import com.work.api.open.model.LoginReq;
import com.work.api.open.model.LoginResp;
import com.work.api.open.model.RegisterReq;
import com.work.api.open.model.SendSmsReq;
import com.work.api.open.model.UploadResp;
import com.work.util.SLog;

import java.io.File;

/**
 * Created by Administrator on 2019/4/2
 * Description
 */

public class Yz extends ApiClient {

    private static Yz INSTANCE;
    public static Yz getSession(){
        return INSTANCE==null?INSTANCE = new Yz():INSTANCE;
    }
    /**
     * 发送验证码
     */
    public void sendSms(SendSmsReq sendSmsReq, OnResultDataListener onResultDataListener){
        requestPost(ModeApi.sendSms,sendSmsReq,new BaseResp(),onResultDataListener);
    }
    public void sendSmsReset(SendSmsReq sendSmsReq, OnResultDataListener onResultDataListener){
        requestPost(ModeApi.sendSmsReset,sendSmsReq,new BaseResp(),onResultDataListener);
    }
    /**
     * 注册
     */
    public void register(RegisterReq registerReq,OnResultDataListener onResultDataListener){
        requestPost(ModeApi.register,registerReq,new LoginResp(),onResultDataListener);
    }
    /**
     * 忘记密码
     */
    public void resetPwd(RegisterReq registerReq,OnResultDataListener onResultDataListener){
        requestPost(ModeApi.resetPwd,registerReq,new BaseResp(),onResultDataListener);
    }
    /**
     * 登录
     */
    public void login(LoginReq loginReq,OnResultDataListener onResultDataListener){
        requestPost(ModeApi.login,loginReq,new LoginResp(),onResultDataListener);
    }
    /**
     * 修改信息
     */
    public void update(RegisterReq registerReq,OnResultDataListener onResultDataListener,Object... objects){
        requestPost(ModeApi.update,registerReq,new BaseResp(),onResultDataListener,objects);
    }
    /**
     * 修改密码
     */
    public void updatePwd(RegisterReq registerReq,OnResultDataListener onResultDataListener){
        requestPost(ModeApi.updatePwd,registerReq,new BaseResp(),onResultDataListener);
    }
    /**
     * 获取用户基本信息
     */
    public void getUserByUserId(OnResultDataListener onResultDataListener){
        requestPost(ModeApi.getUserByUserId,new BaseReq(),new LoginResp(),onResultDataListener);
    }
    /**
     * 上传文件
     */
    public void upload(String path,OnResultDataListener onResultDataListener){
        RequestParams params = new RequestParams();
        params.url = clientModelUrl(ModeApi.upload);
        params.onResultDataListener = onResultDataListener;
        params.req = new BaseReq();
        params.resp = new UploadResp();
        if(SLog.debug)SLog.e("Upload File:"+path);
        params.addFileParam("file",new File(path));
        params.addTextParam("token",path);
        ConnectDataTask dataTask = new ConnectDataTask(params);
        dataTask.uploadFile();
    }
}
