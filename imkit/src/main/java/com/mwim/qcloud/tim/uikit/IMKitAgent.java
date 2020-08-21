package com.mwim.qcloud.tim.uikit;

import android.content.Context;
import android.os.Environment;

import com.mwim.qcloud.tim.uikit.base.IMEventListener;
import com.mwim.qcloud.tim.uikit.base.IUIKitCallBack;
import com.mwim.qcloud.tim.uikit.component.face.CustomFace;
import com.mwim.qcloud.tim.uikit.component.face.CustomFaceGroup;
import com.mwim.qcloud.tim.uikit.config.CustomFaceConfig;
import com.mwim.qcloud.tim.uikit.config.GeneralConfig;
import com.mwim.qcloud.tim.uikit.config.TUIKitConfigs;

import java.io.File;

/**
 * Created by tangyx
 * Date 2020/8/15
 * email tangyx@live.com
 */

public final class IMKitAgent {

    private static final int SDKAPPID = 1400411394;
    private static final int EXPIRETIME = 604800;
    private static final String SECRETKEY = "cca5cda88a8b72e3b9f9697471eded3fd83366b166a48a6152801f923ea67ebb";

    private static Context instance;

    public static Context instance(){
        return instance;
    }

    public static void init(Context context,String appKey){
        instance = context;
        TUIKit.init(context,SDKAPPID,getConfigs(context));
    };
    private static TUIKitConfigs getConfigs(Context context) {
        GeneralConfig config = new GeneralConfig();
        // 显示对方是否已读的view将会展示
        config.setShowRead(true);
        config.setAppCacheDir(context.getFilesDir().getPath());
        if (new File(Environment.getExternalStorageDirectory() + "/111222333").exists()) {
            config.setTestEnv(true);
        }
        TUIKit.getConfigs().setGeneralConfig(config);
        TUIKit.getConfigs().setCustomFaceConfig(initCustomFaceConfig());
        return TUIKit.getConfigs();
    }

    public static Context getAppContext() {
        return TUIKitImpl.getAppContext();
    }

    private static CustomFaceConfig initCustomFaceConfig() {
        CustomFaceConfig config = new CustomFaceConfig();
        CustomFaceGroup faceConfigs = new CustomFaceGroup();
        faceConfigs.setPageColumnCount(5);
        faceConfigs.setPageRowCount(2);
        faceConfigs.setFaceGroupId(1);
        faceConfigs.setFaceIconPath("4350/tt01@2x.png");
        faceConfigs.setFaceIconName("4350");
        for (int i = 0; i <= 16; i++) {
            CustomFace customFace = new CustomFace();
            String index = "" + i;
            if (i < 10)
                index = "0" + i;
            customFace.setAssetPath("4350/tt" + index + "@2x.png");
            customFace.setFaceName("tt" + index + "@2x");
            customFace.setFaceWidth(170);
            customFace.setFaceHeight(170);
            faceConfigs.addCustomFace(customFace);
        }
        config.addFaceGroup(faceConfigs);

        return config;
    }
    public static void addIMEventListener(IMEventListener eventListener){
        TUIKit.addIMEventListener(eventListener);
    }
    public static void login(String userid, String usersig, final IUIKitCallBack callback) {
        TUIKitImpl.login(userid, usersig, callback);
    }

}
