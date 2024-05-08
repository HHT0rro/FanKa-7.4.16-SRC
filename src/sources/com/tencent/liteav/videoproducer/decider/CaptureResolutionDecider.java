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
public class CaptureResolutionDecider {
    private long mNativePtr = 0;

    private static native long nativeCreate();

    private static native void nativeDestroy(long j10);

    private static native Size nativeGetCaptureSize(long j10);

    private static native void nativeSetCameraCaptureMode(long j10, int i10);

    private static native void nativeSetEncodeRotation(long j10, int i10);

    private static native void nativeSetEncodeSize(long j10, int i10, int i11);

    private static native void nativeSetManualCaptureSize(long j10, int i10, int i11);

    private static native void nativeSetRealCaptureFrameSize(long j10, int i10, int i11, int i12, boolean z10);

    private static native void nativeSetResolutionMode(long j10, int i10);

    private static native void nativeSetSourceType(long j10, int i10);

    @NonNull
    public Size getCaptureSize() {
        long j10 = this.mNativePtr;
        return j10 != 0 ? nativeGetCaptureSize(j10) : new Size();
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

    public void setManualCaptureSize(int i10, int i11) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetManualCaptureSize(j10, i10, i11);
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
