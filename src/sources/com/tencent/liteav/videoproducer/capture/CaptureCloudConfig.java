package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CaptureCloudConfig {
    private Rotation frontCameraRealRotation = null;
    private Rotation backCameraRealRotation = null;
    private int camera2SupportMinApiLevel = Integer.MAX_VALUE;

    @CalledByNative
    public CaptureCloudConfig() {
    }

    public int getCamera2SupportMinApiLevel() {
        return this.camera2SupportMinApiLevel;
    }

    public Rotation getCameraRealRotation(boolean z10) {
        return z10 ? this.frontCameraRealRotation : this.backCameraRealRotation;
    }

    @CalledByNative
    public void setCamera2SupportMinApiLevel(int i10) {
        this.camera2SupportMinApiLevel = i10;
    }

    @CalledByNative
    public void setCameraRealRotation(int i10, int i11) {
        this.frontCameraRealRotation = Rotation.b(i10) ? Rotation.a(i10) : null;
        this.backCameraRealRotation = Rotation.b(i11) ? Rotation.a(i11) : null;
    }
}
