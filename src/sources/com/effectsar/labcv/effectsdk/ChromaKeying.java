package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ChromaKeying {
    private boolean mInited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(Context context, String str, String str2, boolean z10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefChromaKeyingInfo befChromaKeyingInfo, boolean z10);

    private native int nativeRelease();

    private native int nativeSetParamF(int i10, float f10);

    private native int nativeSetParamI(int i10, int i11);

    private native int nativeSetProcessParam(float f10, float f11, float f12, float f13, float f14);

    public BefChromaKeyingInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, boolean z10) {
        if (!this.mInited) {
            return null;
        }
        BefChromaKeyingInfo befChromaKeyingInfo = new BefChromaKeyingInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befChromaKeyingInfo, z10);
        if (nativeDetect == 0) {
            return befChromaKeyingInfo;
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

    public int setParamF(EffectsSDKEffectConstants.ChromaKeyingParamType chromaKeyingParamType, float f10) {
        if (this.mInited) {
            return nativeSetParamF(chromaKeyingParamType.getValue(), f10);
        }
        return -1;
    }

    public int setParamI(EffectsSDKEffectConstants.ChromaKeyingParamType chromaKeyingParamType, int i10) {
        if (this.mInited) {
            return nativeSetParamI(chromaKeyingParamType.getValue(), i10);
        }
        return -1;
    }

    public int setProcessParam(float f10, float f11, float f12, float f13, float f14) {
        if (this.mInited) {
            return nativeSetProcessParam(f10, f11, f12, f13, f14);
        }
        return -1;
    }
}
