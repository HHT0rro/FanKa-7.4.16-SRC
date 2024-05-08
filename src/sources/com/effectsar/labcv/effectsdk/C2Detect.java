package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class C2Detect {
    private boolean mInited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(int i10, String str, String str2, boolean z10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefC2Info befC2Info);

    private native int nativeRelease();

    private native int nativeSetParam(int i10, float f10);

    public BefC2Info detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefC2Info befC2Info = new BefC2Info();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befC2Info);
        if (nativeDetect == 0) {
            return befC2Info;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("native detect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int init(EffectsSDKEffectConstants.C2ModelType c2ModelType, String str, String str2, boolean z10) {
        int nativeCreate = nativeCreate(c2ModelType.getValue(), str, str2, z10);
        if (nativeCreate != 0) {
            this.mInited = false;
            return nativeCreate;
        }
        this.mInited = true;
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

    public int setParam(EffectsSDKEffectConstants.C2ParamType c2ParamType, float f10) {
        if (this.mInited) {
            return nativeSetParam(c2ParamType.getValue(), f10);
        }
        return -1;
    }

    public int init(EffectsSDKEffectConstants.C2ModelType c2ModelType, String str, String str2) {
        return init(c2ModelType, str, str2, false);
    }
}
