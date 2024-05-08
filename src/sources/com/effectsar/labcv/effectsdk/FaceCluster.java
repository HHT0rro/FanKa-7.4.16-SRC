package com.effectsar.labcv.effectsdk;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FaceCluster {
    private volatile boolean mInited = false;
    private long mNativeClusterPtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCluster(float[] fArr, int i10, int[] iArr);

    private native int nativeCreateHandle();

    private native void nativeRelease();

    private native int nativeSetParam(int i10, int i11);

    public int[] cluster(float[][] fArr, int i10) {
        int[] iArr = new int[i10];
        int i11 = 0;
        for (float[] fArr2 : fArr) {
            i11 += fArr2.length;
        }
        float[] fArr3 = new float[i11];
        int i12 = 0;
        for (float[] fArr4 : fArr) {
            int length = fArr4.length;
            int i13 = 0;
            while (i13 < length) {
                fArr3[i12] = fArr4[i13];
                i13++;
                i12++;
            }
        }
        int nativeCluster = nativeCluster(fArr3, i10, iArr);
        if (nativeCluster == 0) {
            return iArr;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeCluster return ");
        sb2.append(nativeCluster);
        return null;
    }

    public int init(Context context, String str, boolean z10) {
        int nativeCreateHandle = nativeCreateHandle();
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

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int setDetectParam(int i10, int i11) {
        return nativeSetParam(i10, i11);
    }

    public int init(Context context, String str) {
        return init(context, str, false);
    }
}
