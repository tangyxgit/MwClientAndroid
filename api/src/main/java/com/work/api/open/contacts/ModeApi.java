package com.work.api.open.contacts;


/**
 * Created by tangyx on 15/9/18.
 *
 */
public final class ModeApi {
    /**
     *短信验证码
     */
    public final static String sendSms = "user/sendSms";
    public final static String sendSmsReset = "user/sendSmsReset";
    /**
     * 注册
     */
    public final static String register = "user/register";
    /**
     * 忘记密码
     */
    public final static String resetPwd = "user/resetPwd";
    /**
     * 修改密码
     */
    public final static String updatePwd = "user/updatePwd";
    /**
     * 登录
     */
    public final static String login ="user/login";
    /**
     * 修改信息
     */
    public final static String update="user/update";
    /**
     * 获取用户信息
     */
    public final static String getUserByUserId="user/getUserByUserId";
    /**
     * 上传文件
     */
    public final static String upload = "api/upload";
    /**
     * 退出登录
     */
    public final static String logout = "user.logout";
}