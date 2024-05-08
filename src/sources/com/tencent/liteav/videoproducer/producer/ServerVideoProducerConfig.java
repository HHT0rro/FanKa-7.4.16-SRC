package com.tencent.liteav.videoproducer.producer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ServerVideoProducerConfig {
    private Rotation gsensorRotationCorrection;
    private Boolean hardwareEncoderBitrateModeCBRSupported;
    private int hardwareEncodeType = 2;
    private boolean hardwareEncoderHighProfileEnable = true;
    private boolean hardwareEncoderHighProfileSupport = true;
    private int camera2SupportMinApiLevel = Integer.MAX_VALUE;
    private Rotation frontCameraRealRotation = null;
    private Rotation backCameraRealRotation = null;

    @CalledByNative
    public ServerVideoProducerConfig() {
    }

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getCamera2SupportMinApiLevel() {
        return this.camera2SupportMinApiLevel;
    }

    public Rotation getCameraRealRotation(boolean z10) {
        return z10 ? this.frontCameraRealRotation : this.backCameraRealRotation;
    }

    @Nullable
    public Rotation getGsensorRotationCorrection() {
        return this.gsensorRotationCorrection;
    }

    public boolean isHardwareEncoderAllowed() {
        return this.hardwareEncodeType != 0;
    }

    public Boolean isHardwareEncoderBitrateModeCBRSupported() {
        return this.hardwareEncoderBitrateModeCBRSupported;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        return this.hardwareEncodeType == 2 && this.hardwareEncoderHighProfileEnable && this.hardwareEncoderHighProfileSupport;
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

    @CalledByNative
    public void setGSensorRotationCorrection(int i10) {
        if (i10 < 0 || i10 > 3) {
            return;
        }
        this.gsensorRotationCorrection = Rotation.a(i10 * 90);
    }

    @CalledByNative
    public void setHardwareEncodeType(int i10) {
        this.hardwareEncodeType = i10;
    }

    @CalledByNative
    public void setHardwareEncoderBitrateModeCBRSupported(boolean z10) {
        this.hardwareEncoderBitrateModeCBRSupported = Boolean.valueOf(z10);
    }

    @CalledByNative
    public void setHardwareEncoderHighProfileEnable(boolean z10) {
        this.hardwareEncoderHighProfileEnable = z10;
    }

    @CalledByNative
    public void setHardwareEncoderHighProfileSupport(boolean z10) {
        this.hardwareEncoderHighProfileSupport = z10;
    }

    @NonNull
    public String toString() {
        return "hardwareEncodeType: " + this.hardwareEncodeType + ", hardwareEncoderHighProfileEnable: " + this.hardwareEncoderHighProfileEnable + ", hardwareEncoderHighProfileSupport: " + this.hardwareEncoderHighProfileSupport + ", camera2SupportMinApiLevel: " + this.camera2SupportMinApiLevel + ", frontCameraRealRotation: " + ((Object) this.frontCameraRealRotation) + ", backCameraRealRotation: " + ((Object) this.backCameraRealRotation) + ", hardwareEncoderBitrateModeCBRSupported: " + ((Object) this.hardwareEncoderBitrateModeCBRSupported) + ", gsensorRotationCorrection: " + ((Object) this.gsensorRotationCorrection);
    }
}
