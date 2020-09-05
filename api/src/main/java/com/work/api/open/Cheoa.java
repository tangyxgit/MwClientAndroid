package com.work.api.open;


/**
 * Created by Administrator on 2019/4/2
 * Description
 */

public class Cheoa extends ApiClient {

    private static Cheoa INSTANCE;
    public static Cheoa getSession(){
        return INSTANCE==null?INSTANCE = new Cheoa():INSTANCE;
    }
}
