package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HumanDistance {
    private boolean inited = false;
    private long mNativeDistPtr;
    private long mNativeFaceAttrPtr;
    private long mNativeFacePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreateHandle(String str, String str2);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, String str, boolean z10, BefDistanceInfo befDistanceInfo);

    private native int nativeLoadModel(int i10, String str);

    private native void nativeRelease();

    private native int nativeSetParam(int i10, float f10);

    public BefDistanceInfo detectDistance(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, String str, boolean z10, EffectsSDKEffectConstants.Rotation rotation) {
        BefDistanceInfo befDistanceInfo = new BefDistanceInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, str, z10, befDistanceInfo);
        if (nativeDetect == 0) {
            return befDistanceInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int init(Context context, String str, String str2, String str3, String str4, boolean z10) {
        if (this.inited) {
            return -1;
        }
        int nativeCreateHandle = nativeCreateHandle(str, str2);
        if (nativeCreateHandle != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("nativeCreateHandle fail!! return ");
            sb2.append(nativeCreateHandle);
            return nativeCreateHandle;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str4, z10);
        if (nativeCheckLicense != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("nativeCheckLicense fail!! return ");
            sb3.append(nativeCheckLicense);
            return nativeCheckLicense;
        }
        int nativeLoadModel = nativeLoadModel(EffectsSDKEffectConstants.HumanDistanceModelType.BEF_HUMAN_DISTANCE_MODEL1.getValue(), str3);
        if (nativeLoadModel != 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("nativeLoadModel fail!! return ");
            sb4.append(nativeLoadModel);
            return nativeLoadModel;
        }
        this.inited = nativeLoadModel == 0;
        return nativeLoadModel;
    }

    public boolean isInited() {
        return this.inited;
    }

    public void release() {
        if (this.inited) {
            nativeRelease();
        }
        this.inited = false;
    }

    public int setParam(int i10, float f10) {
        if (!this.inited) {
            return -1;
        }
        int nativeSetParam = nativeSetParam(i10, f10);
        if (nativeSetParam != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("nativeSetParam return ");
            sb2.append(nativeSetParam);
        }
        return nativeSetParam;
    }

    public int init(Context context, String str, String str2, String str3, String str4) {
        return init(context, str, str2, str3, str4, false);
    }
}
