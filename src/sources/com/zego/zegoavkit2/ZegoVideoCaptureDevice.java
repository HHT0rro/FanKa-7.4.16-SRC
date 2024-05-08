package com.zego.zegoavkit2;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.View;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ZegoVideoCaptureDevice {
    public static final int PIXEL_BUFFER_TYPE_CV_PIXEL_BUFFER = 2;
    public static final int PIXEL_BUFFER_TYPE_ENCODED_FRAME = 16;
    public static final int PIXEL_BUFFER_TYPE_GL_TEXTURE_2D = 8;
    public static final int PIXEL_BUFFER_TYPE_GL_TEXTURE_EXTERNAL_OES = 64;
    public static final int PIXEL_BUFFER_TYPE_MEM = 1;
    public static final int PIXEL_BUFFER_TYPE_SURFACE_TEXTURE = 4;
    public static final int PIXEL_BUFFER_TYPE_UNKNOWN = 0;
    public static final int PIXEL_FORMAT_BGRA32 = 4;
    public static final int PIXEL_FORMAT_I420 = 1;
    public static final int PIXEL_FORMAT_NV12 = 2;
    public static final int PIXEL_FORMAT_NV21 = 3;
    public static final int PIXEL_FORMAT_RGBA32 = 5;
    public static final int PIXEL_FORMAT_UNKNOWN = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Client {
        void destroy();

        SurfaceTexture getSurfaceTexture();

        void onByteBufferFrameCaptured(ByteBuffer byteBuffer, int i10, VideoCaptureFormat videoCaptureFormat, long j10, int i11);

        void onByteBufferFrameCaptured(byte[] bArr, int i10, VideoCaptureFormat videoCaptureFormat, long j10, int i11);

        void onEncodedFrameCaptured(ByteBuffer byteBuffer, int i10, VideoCodecConfig videoCodecConfig, boolean z10, double d10);

        void onTakeSnapshot(Bitmap bitmap);

        void onTextureCaptured(int i10, int i11, int i12, double d10);

        void resetTextureContext();

        void setFillMode(int i10);

        void setFlipMode(int i10);

        void setRotation(int i10);

        void setStatusReason(boolean z10, int i10);

        void setTextureResolution(int i10, int i11);

        void setTransformMatrix(float[] fArr);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class VideoCaptureFormat {
        public int[] strides = {0, 0, 0, 0};
        public int width = 0;
        public int height = 0;
        public int rotation = 0;
        public int pixel_format = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class VideoCodecConfig {
        public int width = 0;
        public int height = 0;
        public int codec_type = 0;
        public int rotation = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ZegoVideoCodecType {
        public static final int ZegoVideoCodecTypeAVCANNEXB = 1;
        public static final int ZegoVideoCodecTypeAVCAVCC = 0;
        public static final int ZegoVideoCodecTypeHEVCANNEXB = 4;
        public static final int ZegoVideoCodecTypeHEVCAVCC = 3;
        public static final int ZegoVideoCodecTypeVP8 = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ZegoVideoFlipMode {
        public static final int Horizontal = 1;
        public static final int None = 0;
        public static final int Vertical = 2;
    }

    public abstract void allocateAndStart(Client client);

    public abstract int enableTorch(boolean z10);

    public abstract int setCaptureRotation(int i10);

    public abstract int setFrameRate(int i10);

    public abstract int setFrontCam(int i10);

    public abstract int setPowerlineFreq(int i10);

    public abstract int setResolution(int i10, int i11);

    public abstract int setView(View view);

    public abstract int setViewMode(int i10);

    public abstract int setViewRotation(int i10);

    public abstract int startCapture();

    public abstract int startPreview();

    public abstract void stopAndDeAllocate();

    public abstract int stopCapture();

    public abstract int stopPreview();

    public abstract int supportBufferType();

    public abstract int takeSnapshot();
}
