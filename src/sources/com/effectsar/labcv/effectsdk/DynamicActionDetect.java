package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DynamicActionDetect {
    private boolean mInited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreateHandle(int i10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, long j10, int i15, BefDynamicActionInfo befDynamicActionInfo);

    private native int nativeRelease();

    private native int nativeSetModel(int i10, String str);

    private native int nativeSetParam(int i10, float f10);

    public BefDynamicActionInfo detectDynamicAction(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, long j10, int i13) {
        if (!this.mInited) {
            return null;
        }
        BefDynamicActionInfo befDynamicActionInfo = new BefDynamicActionInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, j10, i13, befDynamicActionInfo);
        if (nativeDetect == 0) {
            return befDynamicActionInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int init(Context context, int i10, String str, boolean z10) {
        int nativeCreateHandle = nativeCreateHandle(i10);
        if (nativeCreateHandle != 0) {
            this.mInited = false;
            return nativeCreateHandle;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str, z10);
        if (nativeCheckLicense != 0) {
            this.mInited = false;
            return nativeCheckLicense;
        }
        this.mInited = true;
        return nativeCheckLicense;
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

    public int setModel(EffectsSDKEffectConstants.DynamicActionModelType dynamicActionModelType, String str) {
        if (this.mInited) {
            return nativeSetModel(dynamicActionModelType.getValue(), str);
        }
        return -1;
    }

    public int setParam(EffectsSDKEffectConstants.DynamicActionParamType dynamicActionParamType, float f10) {
        if (this.mInited) {
            return nativeSetParam(dynamicActionParamType.getValue(), f10);
        }
        return -1;
    }
}
