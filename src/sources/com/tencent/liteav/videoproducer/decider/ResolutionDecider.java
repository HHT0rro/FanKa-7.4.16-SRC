package com.tencent.liteav.videoproducer.decider;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ResolutionDecider {
    private long mNativePtr = 0;

    private static native long nativeCreate();

    private static native void nativeDestroy(long j10);

    private static native Size nativeGetEncodeSize(long j10);

    private static native Size nativeGetRenderSize(long j10);

    private static native void nativeSetCameraCaptureMode(long j10, int i10);

    private static native void nativeSetComplexFilterExist(long j10, boolean z10);

    private static native void nativeSetEncodeRotation(long j10, int i10);

    private static native void nativeSetEncodeSize(long j10, int i10, int i11);

    private static native void nativeSetGSensorMode(long j10, int i10);

    private static native void nativeSetHomeOrientation(long j10, int i10);

    private static native void nativeSetPreprocessRotation(long j10, int i10);

    private static native void nativeSetRealCaptureFrameSize(long j10, int i10, int i11, int i12, boolean z10);

    private static native void nativeSetResolutionMode(long j10, int i10);

    private static native void nativeSetScreenAutoRotateEnable(long j10, boolean z10);

    private static native void nativeSetScreenDisplayRotation(long j10, int i10);

    private static native void nativeSetSourceType(long j10, int i10);

    @NonNull
    public Size getEncodeSize() {
        long j10 = this.mNativePtr;
        return j10 != 0 ? nativeGetEncodeSize(j10) : new Size();
    }

    @NonNull
    public Size getRenderSize() {
        long j10 = this.mNativePtr;
        return j10 != 0 ? nativeGetRenderSize(j10) : new Size();
    }

    public void initialize() {
        if (this.mNativePtr == 0) {
            this.mNativePtr = nativeCreate();
        }
    }

    public void setCameraCaptureMode(VideoProducerDef.CameraCaptureMode cameraCaptureMode) {
        long j10 = this.mNativePtr;
        if (j10 == 0 || cameraCaptureMode == null) {
            return;
        }
        nativeSetCameraCaptureMode(j10, cameraCaptureMode.mValue);
    }

    public void setComplexFilterExist(boolean z10) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetComplexFilterExist(j10, z10);
        }
    }

    public void setEncodeRotation(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetEncodeRotation(j10, Rotation.a(rotation));
        }
    }

    public void setEncodeSize(int i10, int i11) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetEncodeSize(j10, i10, i11);
        }
    }

    public void setGSensorMode(VideoProducerDef.GSensorMode gSensorMode) {
        long j10 = this.mNativePtr;
        if (j10 == 0 || gSensorMode == null) {
            return;
        }
        nativeSetGSensorMode(j10, gSensorMode.mValue);
    }

    public void setHomeOrientation(VideoProducerDef.HomeOrientation homeOrientation) {
        long j10 = this.mNativePtr;
        if (j10 == 0 || homeOrientation == null) {
            return;
        }
        nativeSetHomeOrientation(j10, homeOrientation.mValue);
    }

    public void setPreprocessRotation(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetPreprocessRotation(j10, Rotation.a(rotation));
        }
    }

    public void setRealCaptureFrameSize(int i10, int i11, Rotation rotation, boolean z10) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetRealCaptureFrameSize(j10, i10, i11, Rotation.a(rotation), z10);
        }
    }

    public void setResolutionMode(GLConstants.ResolutionMode resolutionMode) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetResolutionMode(j10, resolutionMode == null ? -1 : resolutionMode.mValue);
        }
    }

    public void setScreenAutoRotateEnable(boolean z10) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetScreenAutoRotateEnable(j10, z10);
        }
    }

    public void setScreenDisplayRotation(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetScreenDisplayRotation(j10, Rotation.a(rotation));
        }
    }

    public void setSourceType(CaptureSourceInterface.SourceType sourceType) {
        long j10 = this.mNativePtr;
        if (j10 == 0 || sourceType == null) {
            return;
        }
        nativeSetSourceType(j10, sourceType.mValue);
    }

    public void uninitialize() {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeDestroy(j10);
            this.mNativePtr = 0L;
        }
    }
}
