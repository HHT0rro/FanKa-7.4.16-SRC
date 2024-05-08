package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FaceVerify {
    public static final Double SAME_FACE_SCORE = Double.valueOf(67.6d);
    private volatile boolean mInited = false;
    private long mNativeFacePtr;
    private long mNativeVerifyPtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreateHandle(String str, String str2, int i10);

    private native double nativeDistanceToScore(double d10);

    private native int nativeExtractFeature(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefFaceFeature befFaceFeature);

    private native int nativeExtractFeatureSingle(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefFaceFeature befFaceFeature);

    private native void nativeRelease();

    private native double nativeVerify(float[] fArr, float[] fArr2);

    public double distToScore(double d10) {
        return nativeDistanceToScore(d10);
    }

    public BefFaceFeature extractFeature(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefFaceFeature befFaceFeature = new BefFaceFeature();
        int nativeExtractFeature = nativeExtractFeature(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befFaceFeature);
        if (nativeExtractFeature == 0) {
            return befFaceFeature;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeVerifyFace return ");
        sb2.append(nativeExtractFeature);
        return null;
    }

    public BefFaceFeature extractFeatureSingle(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefFaceFeature befFaceFeature = new BefFaceFeature();
        int nativeExtractFeatureSingle = nativeExtractFeatureSingle(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befFaceFeature);
        if (nativeExtractFeatureSingle == 0) {
            return befFaceFeature;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeVerifyFace return ");
        sb2.append(nativeExtractFeatureSingle);
        return null;
    }

    public int init(Context context, String str, String str2, int i10, String str3, boolean z10) {
        int nativeCreateHandle = nativeCreateHandle(str, str2, i10);
        if (nativeCreateHandle != 0) {
            this.mInited = false;
            return nativeCreateHandle;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str3, z10);
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

    public double verify(float[] fArr, float[] fArr2) {
        return nativeVerify(fArr, fArr2);
    }

    public int init(Context context, String str, String str2, int i10, String str3) {
        return init(context, str, str2, i10, str3, false);
    }
}
