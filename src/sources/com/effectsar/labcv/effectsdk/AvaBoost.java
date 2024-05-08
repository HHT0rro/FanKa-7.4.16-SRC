package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AvaBoost {
    private volatile boolean mInited = false;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(Context context, String str, String str2, boolean z10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefAvaBoostInfo befAvaBoostInfo);

    private native int nativeRelease();

    private native int nativeSetParamF(int i10, float f10);

    private native int nativeSetParamI(int i10, int i11);

    private native int nativeSetParamS(int i10, String str);

    public BefAvaBoostInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefAvaBoostInfo befAvaBoostInfo = new BefAvaBoostInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befAvaBoostInfo);
        if (nativeDetect == 0) {
            return befAvaBoostInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("native detect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int init(Context context, String str, String str2, boolean z10) {
        int nativeCreate = nativeCreate(context, str, str2, z10);
        this.mInited = nativeCreate == 0;
        return nativeCreate;
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

    public int setParamF(EffectsSDKEffectConstants.SkinSegmentationParamType skinSegmentationParamType, float f10) {
        if (this.mInited) {
            return nativeSetParamF(skinSegmentationParamType.getValue(), f10);
        }
        return -1;
    }

    public int setParamI(EffectsSDKEffectConstants.SkinSegmentationParamType skinSegmentationParamType, int i10) {
        if (this.mInited) {
            return nativeSetParamI(skinSegmentationParamType.getValue(), i10);
        }
        return -1;
    }

    public int setParamS(EffectsSDKEffectConstants.SkinSegmentationParamType skinSegmentationParamType, String str) {
        if (this.mInited) {
            return nativeSetParamS(skinSegmentationParamType.getValue(), str);
        }
        return -1;
    }
}
