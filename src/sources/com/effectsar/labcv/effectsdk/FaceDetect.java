package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FaceDetect {
    private static final int MaxFaceNum = 10;
    private long mAttriNativePtr;
    private long mNativePtr;
    private volatile boolean mInited = false;
    private volatile boolean mInitedExtra = false;
    private volatile boolean mInitedAttri = false;
    private int mFaceDetectConfig = -1;
    private int mFaceAttriConfig = -1;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, long j10, BefFaceInfo befFaceInfo);

    private native int nativeGetFaceMask(long j10, int i10, BefFaceInfo befFaceInfo);

    private native int nativeInit(int i10, String str);

    private native int nativeInitAttri(int i10, String str, Context context, String str2, boolean z10);

    private native int nativeInitExtra(int i10, String str);

    private native void nativeRelease();

    private native void nativeReleaseAttri();

    private native int nativeSetParam(int i10, int i11);

    public BefFaceInfo detectFace(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited || this.mFaceDetectConfig == -1) {
            return null;
        }
        BefFaceInfo befFaceInfo = new BefFaceInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, this.mFaceDetectConfig, befFaceInfo);
        if (nativeDetect == 0) {
            return befFaceInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int getFaceAttriConfig() {
        return this.mFaceAttriConfig;
    }

    public int getFaceDetectConfig() {
        return this.mFaceDetectConfig;
    }

    public void getFaceMask(BefFaceInfo befFaceInfo, int i10) {
        int nativeGetFaceMask;
        if (!this.mInited || befFaceInfo == null || (nativeGetFaceMask = nativeGetFaceMask(this.mFaceDetectConfig, i10, befFaceInfo)) == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeGetFaceMask return ");
        sb2.append(nativeGetFaceMask);
    }

    public int init(Context context, String str, int i10, String str2, boolean z10) {
        int nativeInit = nativeInit(i10, str);
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
        int detectParam = setDetectParam(2, 10);
        if (detectParam != 0) {
            this.mInited = false;
            return detectParam;
        }
        this.mInited = true;
        return detectParam;
    }

    public int initAttri(Context context, String str, String str2, boolean z10) {
        int i10 = this.mInited ? 0 : -1;
        if (i10 == 0) {
            i10 = nativeInitAttri(0, str, context, str2, z10);
        }
        this.mInitedAttri = true;
        return i10;
    }

    public int initExtra(Context context, String str, int i10) {
        int i11 = this.mInited ? 0 : -1;
        if (i11 == 0) {
            i11 = nativeInitExtra(i10, str);
        }
        this.mInitedExtra = true;
        return i11;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public boolean isInitedAttri() {
        return this.mInitedAttri;
    }

    public boolean isInitedExtra() {
        return this.mInitedExtra;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        if (this.mInitedAttri) {
            nativeReleaseAttri();
        }
        this.mInited = false;
        this.mInitedExtra = false;
        this.mInitedAttri = false;
    }

    public void releaseAttri() {
        if (this.mInitedAttri) {
            nativeReleaseAttri();
        }
        this.mInitedAttri = false;
    }

    public void setAttriDetectConfig(int i10) {
        this.mFaceAttriConfig = i10;
    }

    public int setDetectParam(int i10, int i11) {
        return nativeSetParam(i10, i11);
    }

    public void setFaceDetectConfig(int i10) {
        this.mFaceDetectConfig = i10;
    }

    public int initAttri(Context context, String str, String str2) {
        return initAttri(context, str, str2, false);
    }

    public int init(Context context, String str, int i10, String str2) {
        return init(context, str, i10, str2, false);
    }
}
