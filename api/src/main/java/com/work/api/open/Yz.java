package com.work.api.open;


import com.http.network.listener.OnResultDataListener;
import com.work.api.open.contacts.ModeApi;
import com.work.api.open.model.BaseResp;
import com.work.api.open.model.LoginReq;
import com.work.api.open.model.LoginResp;
import com.work.api.open.model.RegisterReq;
import com.work.api.open.model.SendSmsReq;

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
}
