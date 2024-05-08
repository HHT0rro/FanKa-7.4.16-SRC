package com.zego.zegoliveroom.constants;

import com.android.internal.logging.nano.MetricsProto;
import com.huawei.openalliance.ad.constant.u;
import com.irisdt.StatConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoAvConfig {
    private int mVideoBitrate;
    private int mVideoCaptureResolutionHeight;
    private int mVideoCaptureResolutionWidth;
    private int mVideoEncodeResolutionHeight;
    private int mVideoEncodeResolutionWidth;
    private int mVideoFPS;
    public static final int[] VIDEO_FPSS = {5, 10, 15, 20, 25, 30};
    public static final int[] VIDEO_BITRATES = {StatConfig.STAT_DAU_PERIOD, 400000, u.Y, 1200000, 1500000, 3000000};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Level {
        public static final int Generic = 2;
        public static final int High = 3;
        public static final int Low = 1;
        public static final int SuperHigh = 5;
        public static final int VeryHigh = 4;
        public static final int VeryLow = 0;
    }

    public ZegoAvConfig(int i10) {
        i10 = (i10 < 0 || i10 > 5) ? 2 : i10;
        if (i10 == 0) {
            this.mVideoEncodeResolutionWidth = 180;
            this.mVideoEncodeResolutionHeight = 320;
            this.mVideoCaptureResolutionWidth = 180;
            this.mVideoCaptureResolutionHeight = 320;
        } else if (i10 == 1) {
            this.mVideoEncodeResolutionWidth = 270;
            this.mVideoEncodeResolutionHeight = 480;
            this.mVideoCaptureResolutionWidth = 270;
            this.mVideoCaptureResolutionHeight = 480;
        } else if (i10 == 2) {
            this.mVideoEncodeResolutionWidth = 360;
            this.mVideoEncodeResolutionHeight = 640;
            this.mVideoCaptureResolutionWidth = 360;
            this.mVideoCaptureResolutionHeight = 640;
        } else if (i10 == 3) {
            this.mVideoEncodeResolutionWidth = 540;
            this.mVideoEncodeResolutionHeight = 960;
            this.mVideoCaptureResolutionWidth = 540;
            this.mVideoCaptureResolutionHeight = 960;
        } else if (i10 == 4) {
            this.mVideoEncodeResolutionWidth = MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH;
            this.mVideoEncodeResolutionHeight = 1280;
            this.mVideoCaptureResolutionWidth = MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH;
            this.mVideoCaptureResolutionHeight = 1280;
        } else if (i10 == 5) {
            this.mVideoEncodeResolutionWidth = 1080;
            this.mVideoEncodeResolutionHeight = 1920;
            this.mVideoCaptureResolutionWidth = 1080;
            this.mVideoCaptureResolutionHeight = 1920;
        }
        this.mVideoFPS = 15;
        this.mVideoBitrate = VIDEO_BITRATES[i10];
    }

    public int getVideoBitrate() {
        return this.mVideoBitrate;
    }

    public int getVideoCaptureResolutionHeight() {
        return this.mVideoCaptureResolutionHeight;
    }

    public int getVideoCaptureResolutionWidth() {
        return this.mVideoCaptureResolutionWidth;
    }

    public int getVideoEncodeResolutionHeight() {
        return this.mVideoEncodeResolutionHeight;
    }

    public int getVideoEncodeResolutionWidth() {
        return this.mVideoEncodeResolutionWidth;
    }

    public int getVideoFPS() {
        return this.mVideoFPS;
    }

    public void setVideoBitrate(int i10) {
        this.mVideoBitrate = i10;
    }

    public void setVideoCaptureResolution(int i10, int i11) {
        this.mVideoCaptureResolutionWidth = i10;
        this.mVideoCaptureResolutionHeight = i11;
    }

    public void setVideoEncodeResolution(int i10, int i11) {
        this.mVideoEncodeResolutionWidth = i10;
        this.mVideoEncodeResolutionHeight = i11;
    }

    public void setVideoFPS(int i10) {
        this.mVideoFPS = i10;
    }
}
