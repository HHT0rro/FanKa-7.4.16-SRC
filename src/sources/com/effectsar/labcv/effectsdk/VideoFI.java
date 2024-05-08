package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class VideoFI {
    private ByteBuffer buffer;
    private int bufferHeight;
    private int bufferWidth;
    private boolean mInited = false;
    private long mNativePtr;
    private String mRwDir;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(String str, boolean z10);

    private native int nativeCreate(String str, int i10, int i11, int i12, int i13);

    private native void nativeDestroy();

    private native int nativeProcessTexture(int i10, int i11, int i12, int i13, int i14, float f10, float f11, float f12);

    public int checkLicense(String str, boolean z10) {
        int nativeCheckLicense = nativeCheckLicense(str, z10);
        if (nativeCheckLicense == 0) {
            this.mInited = true;
        } else {
            this.mInited = false;
        }
        return nativeCheckLicense;
    }

    public int create(String str, EffectsSDKEffectConstants.ImageQualityVfiType imageQualityVfiType, EffectsSDKEffectConstants.ImageQualityVfiDataType imageQualityVfiDataType, int i10, EffectsSDKEffectConstants.ImageQulityPowerLevel imageQulityPowerLevel) {
        if (nativeCreate(str, imageQualityVfiDataType.getValue(), imageQualityVfiType.getValue(), imageQulityPowerLevel.getLevel(), i10) != 0) {
            return 0;
        }
        this.mInited = true;
        return 0;
    }

    public void destroy() {
        nativeDestroy();
    }

    public int processTexture(int i10, int i11, int i12, int i13, int i14, float f10, float f11, float f12) {
        return nativeProcessTexture(i10, i11, i12, i13, i14, f10, f11, f12);
    }
}
