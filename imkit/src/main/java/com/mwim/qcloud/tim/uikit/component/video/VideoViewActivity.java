package com.mwim.qcloud.tim.uikit.component.video;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.component.video.proxy.IPlayer;
import com.mwim.qcloud.tim.uikit.utils.ImageUtil;
import com.mwim.qcloud.tim.uikit.utils.ScreenUtil;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.mwim.qcloud.tim.uikit.R;
import com.workstation.view.MaterialMenuDrawable;
import com.workstation.view.MaterialMenuView;

public class VideoViewActivity extends BaseActivity {

    private UIKitVideoView mVideoView;
    private int videoWidth = 0;
    private int videoHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() throws Exception {
        super.onInitView();
        mVideoView = findViewById(R.id.video_play_view);

        String imagePath = getIntent().getStringExtra(TUIKitConstants.CAMERA_IMAGE_PATH);
        Uri videoUri = getIntent().getParcelableExtra(TUIKitConstants.CAMERA_VIDEO_PATH);
        Bitmap firstFrame = ImageUtil.getBitmapFormPath(imagePath);
        if (firstFrame != null) {
            videoWidth = firstFrame.getWidth();
            videoHeight = firstFrame.getHeight();
            updateVideoView();
        }

        mVideoView.setVideoURI(videoUri);
        mVideoView.setOnPreparedListener(new IPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IPlayer mediaPlayer) {
                mVideoView.start();
            }
        });
        mVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                } else {
                    mVideoView.start();
                }
            }
        });
        MaterialMenuView mBack = findViewById(R.id.photo_view_back);
        mBack.setState(MaterialMenuDrawable.IconState.X);
        findViewById(R.id.video_view_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.stop();
                finish();
            }
        });
    }

    @Override
    public int onCustomContentId() {
        return R.layout.activity_video_view;
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateVideoView();
    }

    private void updateVideoView() {
        if (videoWidth <= 0 && videoHeight <= 0) {
            return;
        }
        boolean isLandscape = true;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            isLandscape = false;
        }

        int deviceWidth;
        int deviceHeight;
        if (isLandscape) {
            deviceWidth = Math.max(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
            deviceHeight = Math.min(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
        } else {
            deviceWidth = Math.min(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
            deviceHeight = Math.max(ScreenUtil.getScreenWidth(this), ScreenUtil.getScreenHeight(this));
        }
        int[] scaledSize = ScreenUtil.scaledSize(deviceWidth, deviceHeight, videoWidth, videoHeight);
        ViewGroup.LayoutParams params = mVideoView.getLayoutParams();
        params.width = scaledSize[0];
        params.height = scaledSize[1];
        mVideoView.setLayoutParams(params);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mVideoView != null) {
            mVideoView.stop();
        }
    }
}
