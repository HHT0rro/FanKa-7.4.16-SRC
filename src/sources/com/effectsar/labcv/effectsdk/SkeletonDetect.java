package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SkeletonDetect {
    private long mNativePtr;
    private volatile boolean mInited = false;
    private final int MaxSkeletonNum = 1;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefSkeletonInfo befSkeletonInfo);

    private native int nativeDetectImageMode(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefSkeletonInfo befSkeletonInfo);

    private native int nativeInit(String str);

    private native void nativeRelease();

    private native int nativeSetDetectionInput(int i10, int i11);

    private native int nativeSetTrackingInput(int i10, int i11);

    private native int nativeTargetNum(int i10);

    public BefSkeletonInfo detectSkeleton(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefSkeletonInfo befSkeletonInfo = new BefSkeletonInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befSkeletonInfo);
        if (nativeDetect == 0) {
            return befSkeletonInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public BefSkeletonInfo detectSkeletonImageMode(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefSkeletonInfo befSkeletonInfo = new BefSkeletonInfo();
        int nativeDetectImageMode = nativeDetectImageMode(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befSkeletonInfo);
        if (nativeDetectImageMode == 0) {
            return befSkeletonInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetectImageMode);
        return null;
    }

    public int init(Context context, String str, String str2, boolean z10) {
        int nativeInit = nativeInit(str);
        if (nativeInit != 0) {
            this.mInited = false;
            return nativeInit;
        }
        if (nativeInit != 0) {
            this.mInited = false;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str2, z10);
        if (nativeCheckLicense != 0) {
            this.mInited = false;
            return nativeCheckLicense;
        }
        int nativeTargetNum = nativeTargetNum(1);
        if (nativeTargetNum != 0) {
            this.mInited = false;
            return nativeTargetNum;
        }
        this.mInited = true;
        return nativeTargetNum;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int setDetectionInput(int i10, int i11) {
        return nativeSetDetectionInput(i10, i11);
    }

    public int setTargetNum(int i10) {
        return nativeTargetNum(i10);
    }

    public int setTrackingInput(int i10, int i11) {
        return nativeSetTrackingInput(i10, i11);
    }

    public int init(Context context, String str, String str2) {
        return init(context, str, str2, false);
    }
}
