package com.mwim.qcloud.tim.uikit.business.helper

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.mwim.qcloud.tim.uikit.IMKitAgent
import com.tencent.wemeet.sdk.WemeetSDK
import com.tencent.wemeet.sdk.data.InitParams
import com.tencent.wemeet.sdk.data.WemeetError
import com.tencent.wemeet.sdk.ipc.RemoteCallback

object WemeetSdkHelper {
    private const val TAG = "SLog"

    // TODO SDKKEY替换
    private const val SDKKEY = "2009233371"
    // TODO sdktoken替换
    private const val SDKTOKEN = "IovLcFwpNOkC4KYzRePd7B63VHX02qyQxEs1"
    private var currentToken = ""

    @JvmStatic
    fun init(context: Context) {
        WemeetSDK.getInstance().initialize(context, InitParams(SDKKEY, SDKTOKEN))
    }

    @JvmStatic
    fun startAuth(token: String) {
        if (SDKKEY.isBlank() || SDKTOKEN.isBlank()) {
            Toast.makeText(IMKitAgent.instance(), "Invalid parameter in $TAG:SDKKEY or SDKTOKEN,", Toast.LENGTH_SHORT).show()
            return
        }
        currentToken = token
        WemeetSDK.getInstance().login(LOGIN_CALLBACK)
    }

    fun logout() {
        WemeetSDK.getInstance().logout(LOGOUT_CALLBACK)
    }

    private val LOGIN_CALLBACK: RemoteCallback.LoginCallback = object : RemoteCallback.LoginCallback() {
        override fun onLoginFinished(errorCode: Int, errorMsg: String) {
            Toast.makeText(IMKitAgent.instance(), "auth callback resultcode:$errorCode", Toast.LENGTH_SHORT).show()
            when (errorCode) {
                WemeetError.SUCCESS -> {
                    Log.i(TAG, "auth success")
                }
                else -> {
                    Log.i(TAG, "auth fail resultcode:$errorCode")
                    Toast.makeText(IMKitAgent.instance(),"auth fail resultcode:$errorCode errorMsg:$errorMsg",Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onAuthCodeRefresh(callback: RemoteCallback.AuthCodeCallback) {
            Log.i(TAG, "onAuthCodeRefresh")
            Toast.makeText(IMKitAgent.instance(), "authcode refreshing", Toast.LENGTH_SHORT).show()
            AuthCodeHelper.getAuthCode(currentToken) { authCode ->
                if (authCode.isBlank()) {
                    Toast.makeText(IMKitAgent.instance(), "获取auth code失败，请重试", Toast.LENGTH_SHORT).show()
                } else {
                    callback.onAuthCodeResult(authCode)
                }
            }
        }
    }

    private val LOGOUT_CALLBACK: RemoteCallback.LogoutCallback = object : RemoteCallback.LogoutCallback() {
        override fun onLogoutFinished(errorCode: Int) {
            if (WemeetError.SUCCESS == errorCode) {
                Log.i(TAG, "logout success")
            } else {
                Log.i(TAG, "logout failed result code:$errorCode")
            }
        }
    }
}
