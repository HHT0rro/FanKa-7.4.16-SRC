package com.tencent.liteav.videoproducer.decider;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoRotationDecider {
    private long mNativePtr = 0;

    private static native long nativeCreate();

    private static native void nativeDestroy(long j10);

    private static native int nativeGetEncodeRotation(long j10);

    private static native int nativeGetPreprocessorRotation(long j10, boolean z10);

    private static native int nativeGetRenderRotation(long j10);

    private static native void nativeSetCaptureRotation(long j10, int i10);

    private static native void nativeSetDisplayRotation(long j10, int i10);

    private static native void nativeSetEncodeRotationByUser(long j10, int i10);

    private static native void nativeSetFront(long j10, boolean z10);

    private static native void nativeSetGSensorMode(long j10, int i10);

    private static native void nativeSetHomeOrientation(long j10, int i10);

    private static native void nativeSetRenderRotationByUser(long j10, int i10);

    private static native void nativeSetResolutionMode(long j10, int i10);

    private static native void nativeSetSensorRotation(long j10, int i10);

    private static native void nativeSetSourceType(long j10, int i10);

    @NonNull
    public Rotation getEncodeRotation() {
        long j10 = this.mNativePtr;
        return j10 != 0 ? Rotation.a(nativeGetEncodeRotation(j10)) : Rotation.NORMAL;
    }

    @NonNull
    public Rotation getPreprocessorRotation(boolean z10) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            return Rotation.a(nativeGetPreprocessorRotation(j10, z10));
        }
        return Rotation.NORMAL;
    }

    @NonNull
    public Rotation getRenderRotation() {
        long j10 = this.mNativePtr;
        return j10 != 0 ? Rotation.a(nativeGetRenderRotation(j10)) : Rotation.NORMAL;
    }

    public void initialize() {
        if (this.mNativePtr == 0) {
            this.mNativePtr = nativeCreate();
        }
    }

    public void setCaptureRotation(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetCaptureRotation(j10, Rotation.a(rotation));
        }
    }

    public void setDisplayRotation(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetDisplayRotation(j10, Rotation.a(rotation));
        }
    }

    public void setEncodeRotationByUser(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetEncodeRotationByUser(j10, Rotation.a(rotation));
        }
    }

    public void setFront(boolean z10) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetFront(j10, z10);
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

    public void setRenderRotationByUser(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetRenderRotationByUser(j10, Rotation.a(rotation));
        }
    }

    public void setResolutionMode(GLConstants.ResolutionMode resolutionMode) {
        long j10 = this.mNativePtr;
        if (j10 == 0 || resolutionMode == null) {
            return;
        }
        nativeSetResolutionMode(j10, resolutionMode.mValue);
    }

    public void setSensorRotation(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetSensorRotation(j10, Rotation.a(rotation));
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
