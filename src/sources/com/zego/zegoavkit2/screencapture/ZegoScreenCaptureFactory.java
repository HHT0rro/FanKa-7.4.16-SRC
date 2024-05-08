package com.zego.zegoavkit2.screencapture;

import android.content.Context;
import android.media.projection.MediaProjection;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import com.zego.zegoavkit2.ZegoVideoCaptureFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoScreenCaptureFactory extends ZegoVideoCaptureFactory {
    public static final int SCREEN_CAPTURE_SIZE_DEFAULT = 0;
    private Context mContext;
    private volatile ZegoScreenCaptureDevice mDevice = null;
    private volatile MediaProjection mMediaProjection = null;
    private volatile int mCaptureWidth = 0;
    private volatile int mCaptureHeight = 0;

    public ZegoScreenCaptureFactory(Context context) {
        this.mContext = context;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureFactory
    public ZegoVideoCaptureDevice create(String str) {
        if (this.mDevice == null) {
            this.mDevice = new ZegoScreenCaptureDevice(this.mContext, this.mMediaProjection, this.mCaptureWidth, this.mCaptureHeight);
        }
        return this.mDevice;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureFactory
    public void destroy(ZegoVideoCaptureDevice zegoVideoCaptureDevice) {
        if (zegoVideoCaptureDevice == this.mDevice) {
            if (this.mMediaProjection != null) {
                this.mMediaProjection.stop();
                this.mMediaProjection = null;
            }
            this.mDevice = null;
        }
    }

    public void setCaptureResolution(int i10, int i11) {
        if (!(i10 == 0 && i11 == 0) && i10 <= 0 && i11 <= 0) {
            return;
        }
        this.mCaptureWidth = i10;
        this.mCaptureHeight = i11;
        ZegoScreenCaptureDevice zegoScreenCaptureDevice = this.mDevice;
        if (zegoScreenCaptureDevice != null) {
            zegoScreenCaptureDevice.setCaptureResolution(i10, i11);
        }
    }

    public void setMediaProjection(MediaProjection mediaProjection) {
        this.mMediaProjection = mediaProjection;
        ZegoScreenCaptureDevice zegoScreenCaptureDevice = this.mDevice;
        if (zegoScreenCaptureDevice != null) {
            zegoScreenCaptureDevice.setMediaProjection(mediaProjection);
        }
    }
}
