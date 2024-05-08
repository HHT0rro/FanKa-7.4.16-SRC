package com.huawei.hms.scankit.util;

import com.huawei.hms.scankit.p.m1;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class OpencvJNI {
    public static native byte[] QRCornerDetect(byte[] bArr, int i10, int i11, float[] fArr);

    public static native float[] QuadFitting(float[] fArr, int i10, float[] fArr2);

    public static native byte[] adaptiveBinary(byte[] bArr, int i10, int i11, int i12, boolean z10);

    public static native byte[] imageResize(byte[] bArr, int i10, int i11, int i12, int i13);

    public static native byte[] imageRotate(byte[] bArr, int i10, int i11, int i12, int i13, float f10, double d10);

    public static void init() {
        o4.d("OpencvJNI", "init()");
        o4.d("OpencvJNI", "start load method");
        try {
            System.loadLibrary("scannative");
            r3.A = true;
        } catch (UnsatisfiedLinkError e2) {
            o4.b("OpencvJNI", e2.getMessage());
            m1.a(false);
        }
    }

    public static native float[] multiBarcodeDetect(byte[] bArr, int i10, int i11, int i12, boolean z10);

    public static native byte[] removeMoirePattern(byte[] bArr, int i10, int i11);

    public static native void setModel(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12);

    public static native byte[] sharpen(byte[] bArr, int i10, int i11);
}
