package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class StudentIdOcr {
    private volatile boolean mInitialized = false;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(String str);

    private native int nativeCreateHandle();

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefStudentIdOcrInfo befStudentIdOcrInfo);

    private native int nativeRelease();

    private native int nativeSetModel(int i10, String str);

    public BefStudentIdOcrInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInitialized) {
            return null;
        }
        BefStudentIdOcrInfo befStudentIdOcrInfo = new BefStudentIdOcrInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befStudentIdOcrInfo);
        if (nativeDetect == 0) {
            return befStudentIdOcrInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("native detect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int init(String str) {
        int nativeCreateHandle = nativeCreateHandle();
        if (nativeCreateHandle != 0) {
            this.mInitialized = false;
            return nativeCreateHandle;
        }
        int nativeCheckLicense = nativeCheckLicense(str);
        if (nativeCheckLicense != 0) {
            this.mInitialized = false;
            return nativeCheckLicense;
        }
        this.mInitialized = true;
        return nativeCheckLicense;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public int release() {
        if (!this.mInitialized) {
            return 0;
        }
        this.mInitialized = false;
        return nativeRelease();
    }

    public int setModel(EffectsSDKEffectConstants.StudentIdOcrModelType studentIdOcrModelType, String str) {
        return nativeSetModel(studentIdOcrModelType.getValue(), str);
    }
}
