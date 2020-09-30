package com.mwim.qcloud.tim.uikit.component.photoview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.mwim.qcloud.tim.uikit.base.BaseActivity;
import com.mwim.qcloud.tim.uikit.utils.FileUtil;
import com.mwim.qcloud.tim.uikit.utils.TUIKitConstants;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.mwim.qcloud.tim.uikit.R;
import com.workstation.view.MaterialMenuDrawable;
import com.workstation.view.MaterialMenuView;

import java.io.File;


public class PhotoViewActivity extends BaseActivity {

    public static V2TIMImageElem.V2TIMImage mCurrentOriginalImage;
    private PhotoView mPhotoView;
    private TextView mViewOriginalBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitView() throws Exception {
        super.onInitView();

        Uri uri = FileUtil.getUriFromPath(getIntent().getStringExtra(TUIKitConstants.IMAGE_DATA));
        boolean isSelf = getIntent().getBooleanExtra(TUIKitConstants.SELF_MESSAGE, false);
        Matrix mCurrentDisplayMatrix = new Matrix();
        mPhotoView = findViewById(R.id.photo_view);
        mPhotoView.setDisplayMatrix(mCurrentDisplayMatrix);
        mPhotoView.setOnMatrixChangeListener(new MatrixChangeListener());
        mPhotoView.setOnPhotoTapListener(new PhotoTapListener());
        mPhotoView.setOnSingleFlingListener(new SingleFlingListener());
        mViewOriginalBtn = findViewById(R.id.view_original_btn);
        if (isSelf || mCurrentOriginalImage == null) {
            mPhotoView.setImageURI(uri);
        } else {
            String path = TUIKitConstants.IMAGE_DOWNLOAD_DIR + mCurrentOriginalImage.getUUID();
            File file = new File(path);
            if (file.exists()) {
                mPhotoView.setImageURI(FileUtil.getUriFromPath(file.getPath()));
            }
            else {
                mPhotoView.setImageURI(uri);
                mViewOriginalBtn.setVisibility(View.VISIBLE);
                mViewOriginalBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mCurrentOriginalImage != null) {

                            final String path = TUIKitConstants.IMAGE_DOWNLOAD_DIR + mCurrentOriginalImage.getUUID();
                            final File file = new File(path);
                            if (!file.exists()) {
                                mCurrentOriginalImage.downloadImage(path, new V2TIMDownloadCallback() {
                                    @Override
                                    public void onProgress(V2TIMElem.V2ProgressInfo progressInfo) {

                                    }

                                    @Override
                                    public void onError(int code, String desc) {

                                    }

                                    @Override
                                    public void onSuccess() {
                                        mPhotoView.setImageURI(FileUtil.getUriFromPath(file.getPath()));
                                        mViewOriginalBtn.setText("已完成");
                                        mViewOriginalBtn.setOnClickListener(null);
                                    }
                                });
                            } else {
                                mPhotoView.setImageURI(FileUtil.getUriFromPath(file.getPath()));
                            }
                        }
                    }
                });
            }

        }
        MaterialMenuView mBack = findViewById(R.id.photo_view_back);
        mBack.setState(MaterialMenuDrawable.IconState.X);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int onCustomContentId() {
        return R.layout.activity_photo_view;
    }

    @Override
    public boolean isShowTitleBar() {
        return false;
    }

    private static class PhotoTapListener implements OnPhotoTapListener {

        @Override
        public void onPhotoTap(ImageView view, float x, float y) {
            float xPercentage = x * 100f;
            float yPercentage = y * 100f;
        }
    }


    private static class MatrixChangeListener implements OnMatrixChangedListener {

        @Override
        public void onMatrixChanged(RectF rect) {

        }
    }

    private static class SingleFlingListener implements OnSingleFlingListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return true;
        }
    }
}
