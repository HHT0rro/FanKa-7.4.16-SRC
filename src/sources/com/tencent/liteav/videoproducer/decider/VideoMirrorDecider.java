package com.tencent.liteav.videoproducer.decider;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.MirrorInfo;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoMirrorDecider {
    private long mNativePtr = 0;

    private static native long nativeCreate();

    private static native void nativeDestroy(long j10);

    private static native MirrorInfo nativeGetEncodeMirrorInfo(long j10);

    private static native MirrorInfo nativeGetPreprocessorMirrorInfo(long j10);

    private static native MirrorInfo nativeGetRenderMirrorInfo(long j10, int i10);

    private static native void nativeSetCaptureMirror(long j10, boolean z10, boolean z11);

    private static native void nativeSetCaptureRotation(long j10, int i10);

    private static native void nativeSetDisplayRotation(long j10, int i10);

    private static native void nativeSetEncodeMirrorByUser(long j10, boolean z10);

    private static native void nativeSetFront(long j10, boolean z10);

    private static native void nativeSetGSensorMode(long j10, int i10);

    private static native void nativeSetHomeOrientation(long j10, int i10);

    private static native void nativeSetRenderMirrorModeByUser(long j10, int i10);

    private static native void nativeSetResolutionMode(long j10, int i10);

    private static native void nativeSetSensorRotation(long j10, int i10);

    private static native void nativeSetSourceType(long j10, int i10);

    @NonNull
    public MirrorInfo getEncodeMirrorInfo() {
        long j10 = this.mNativePtr;
        return j10 != 0 ? nativeGetEncodeMirrorInfo(j10) : new MirrorInfo();
    }

    @NonNull
    public MirrorInfo getPreprocessorMirrorInfo() {
        long j10 = this.mNativePtr;
        return j10 != 0 ? nativeGetPreprocessorMirrorInfo(j10) : new MirrorInfo();
    }

    @NonNull
    public MirrorInfo getRenderMirrorInfo(Rotation rotation) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            return nativeGetRenderMirrorInfo(j10, Rotation.a(rotation));
        }
        return new MirrorInfo();
    }

    public void initialize() {
        if (this.mNativePtr == 0) {
            this.mNativePtr = nativeCreate();
        }
    }

    public void setCaptureMirror(boolean z10, boolean z11) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetCaptureMirror(j10, z10, z11);
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

    public void setEncodeMirrorByUser(boolean z10) {
        long j10 = this.mNativePtr;
        if (j10 != 0) {
            nativeSetEncodeMirrorByUser(j10, z10);
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

    public void setRenderMirrorModeByUser(GLConstants.MirrorMode mirrorMode) {
        long j10 = this.mNativePtr;
        if (j10 == 0 || mirrorMode == null) {
            return;
        }
        nativeSetRenderMirrorModeByUser(j10, mirrorMode.mValue);
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
