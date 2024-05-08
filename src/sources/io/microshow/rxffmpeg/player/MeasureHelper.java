package io.microshow.rxffmpeg.player;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MeasureHelper {
    private FitModel mFitModel = FitModel.FM_DEFAULT;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private VideoSizeInfo mVideoSizeInfo;
    private WeakReference<View> mWeakView;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum FitModel {
        FM_DEFAULT,
        FM_FULL_SCREEN_WIDTH,
        FM_FULL_SCREEN_HEIGHT,
        FM_WH_16X9
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class VideoSizeInfo {
        private float mDar;
        private int mHeight;
        private int mWidth;

        public VideoSizeInfo(int i10, int i11, float f10) {
            this.mWidth = i10;
            this.mHeight = i11;
            this.mDar = f10;
        }

        public float getDar() {
            return this.mDar;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getWidth() {
            return this.mWidth;
        }
    }

    public MeasureHelper(View view) {
        this.mWeakView = new WeakReference<>(view);
    }

    public int[] doMeasure(int i10, int i11) {
        FitModel fitModel = this.mFitModel;
        if (fitModel == FitModel.FM_DEFAULT || fitModel == FitModel.FM_FULL_SCREEN_HEIGHT) {
            i11 = this.mMeasuredHeight;
        }
        return new int[]{i10, i11};
    }

    public FitModel getFitModel() {
        return this.mFitModel;
    }

    public VideoSizeInfo getVideoSizeInfo() {
        return this.mVideoSizeInfo;
    }

    public View getView() {
        View view;
        WeakReference<View> weakReference = this.mWeakView;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return null;
        }
        return view;
    }

    public boolean isFullScreen() {
        return false;
    }

    public void setDefaultVideoLayoutParams() {
        View view = getView();
        if (view instanceof RxFFmpegPlayerView) {
            RxFFmpegPlayerView rxFFmpegPlayerView = (RxFFmpegPlayerView) view;
            int screenWidth = Helper.getScreenWidth(view.getContext());
            int i10 = (screenWidth * 9) / 16;
            setVideoSizeInfo(new VideoSizeInfo(screenWidth, i10, screenWidth / i10));
            setVideoLayoutParams(rxFFmpegPlayerView.getTextureView(), rxFFmpegPlayerView.getContainerView());
        }
    }

    public void setFitModel(FitModel fitModel) {
        this.mFitModel = fitModel;
    }

    public void setVideoLayoutParams(TextureView textureView, FrameLayout frameLayout) {
        int i10;
        if (textureView == null || frameLayout == null || getVideoSizeInfo() == null) {
            return;
        }
        int width = getVideoSizeInfo().getWidth();
        int height = getVideoSizeInfo().getHeight();
        getVideoSizeInfo().getDar();
        float f10 = width / height;
        int screenWidth = Helper.getScreenWidth(getView().getContext());
        if (isFullScreen()) {
            screenWidth = Helper.getScreenHeight(getView().getContext());
        } else {
            FitModel fitModel = this.mFitModel;
            if (fitModel != FitModel.FM_FULL_SCREEN_WIDTH) {
                if (fitModel == FitModel.FM_FULL_SCREEN_HEIGHT) {
                    screenWidth = Helper.getFullScreenHeight(getView().getContext());
                } else if (fitModel == FitModel.FM_WH_16X9) {
                    screenWidth = (screenWidth * 9) / 16;
                } else if (width <= height) {
                    if (width >= height) {
                        i10 = screenWidth;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWidth, i10);
                        layoutParams.gravity = 17;
                        textureView.setLayoutParams(layoutParams);
                        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(Helper.getScreenWidth(getView().getContext()), i10));
                        this.mMeasuredHeight = i10;
                        getView().requestLayout();
                    }
                }
            }
            i10 = (int) (screenWidth / f10);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(screenWidth, i10);
            layoutParams2.gravity = 17;
            textureView.setLayoutParams(layoutParams2);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(Helper.getScreenWidth(getView().getContext()), i10));
            this.mMeasuredHeight = i10;
            getView().requestLayout();
        }
        int i11 = screenWidth;
        screenWidth = (int) (screenWidth * f10);
        i10 = i11;
        FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(screenWidth, i10);
        layoutParams22.gravity = 17;
        textureView.setLayoutParams(layoutParams22);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(Helper.getScreenWidth(getView().getContext()), i10));
        this.mMeasuredHeight = i10;
        getView().requestLayout();
    }

    public void setVideoSizeInfo(VideoSizeInfo videoSizeInfo) {
        this.mVideoSizeInfo = videoSizeInfo;
    }
}
