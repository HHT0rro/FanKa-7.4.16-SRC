package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HandDetect {
    public static final String TAG = "HandDetect";
    private boolean inited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            System.err.println("WARNING: Could not load library!");
            System.err.print(e2);
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreateHandler();

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, long j10, BefHandInfo befHandInfo, int i15);

    private native void nativeRelease();

    private native int nativeSetModel(long j10, String str);

    private native int nativeSetParam(int i10, float f10);

    public int createHandle(Context context, String str, boolean z10) {
        if (this.inited) {
            return 0;
        }
        if (nativeCreateHandler() != 0) {
            return -4;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str, z10);
        if (nativeCheckLicense != 0) {
            return nativeCheckLicense;
        }
        this.inited = true;
        return nativeCheckLicense;
    }

    public BefHandInfo detectHand(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, int i13, int i14) {
        BefHandInfo befHandInfo = new BefHandInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, i13, befHandInfo, i14);
        if (nativeDetect == 0) {
            return befHandInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetect);
        return null;
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

    public int setModel(EffectsSDKEffectConstants.HandModelType handModelType, String str) {
        return nativeSetModel(handModelType.getValue(), str);
    }

    public int setParam(EffectsSDKEffectConstants.HandParamType handParamType, float f10) {
        return nativeSetParam(handParamType.getValue(), f10);
    }

    public int createHandle(Context context, String str) {
        return createHandle(context, str, false);
    }
}
