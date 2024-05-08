package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class LightClsDetect {
    private volatile boolean mInited = false;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreateHandle(String str, int i10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefLightclsInfo befLightclsInfo);

    private native void nativeRelease();

    public BefLightclsInfo detectLightCls(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefLightclsInfo befLightclsInfo = new BefLightclsInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befLightclsInfo);
        if (nativeDetect == 0) {
            return befLightclsInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int init(Context context, String str, String str2, int i10, boolean z10) {
        int nativeCreateHandle = nativeCreateHandle(str, i10);
        if (nativeCreateHandle != 0) {
            this.mInited = false;
            return nativeCreateHandle;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str2, z10);
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

    public void setmInited(boolean z10) {
        this.mInited = z10;
    }

    public int init(Context context, String str, String str2, int i10) {
        return init(context, str, str2, i10, false);
    }
}
