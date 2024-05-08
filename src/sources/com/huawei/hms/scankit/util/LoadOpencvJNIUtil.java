package com.huawei.hms.scankit.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LoadOpencvJNIUtil {
    private static final String TAG = "LoadOpencvJNIUtil";

    public static byte[] QRCornerDetect(byte[] bArr, int i10, int i11, float[] fArr) {
        if (bArr != null) {
            return OpencvJNI.QRCornerDetect(bArr, i10, i11, fArr);
        }
        return null;
    }

    public static float[] QuadFitting(float[] fArr, int i10, float[] fArr2) {
        if (fArr2 != null) {
            return OpencvJNI.QuadFitting(fArr, i10, fArr2);
        }
        return null;
    }

    public static byte[] adaptivebinary(byte[] bArr, int i10, int i11, int i12, boolean z10) {
        if (bArr == null || i10 < i12 || i11 < i12) {
            return null;
        }
        return OpencvJNI.adaptiveBinary(bArr, i10, i11, i12, z10);
    }

    public static byte[] imageResize(byte[] bArr, int i10, int i11, int i12, int i13) {
        if (bArr != null) {
            return OpencvJNI.imageResize(bArr, i10, i11, i12, i13);
        }
        return null;
    }

    public static byte[] imageRotate(byte[] bArr, int i10, int i11, int i12, int i13, float f10, double d10) {
        if (bArr != null) {
            return OpencvJNI.imageRotate(bArr, i10, i11, i12, i13, f10, d10);
        }
        return null;
    }

    public static float[] multiBarcodeDetect(byte[] bArr, int i10, int i11, int i12, boolean z10) {
        if (bArr != null) {
            return OpencvJNI.multiBarcodeDetect(bArr, i10, i11, i12, z10);
        }
        return null;
    }

    public static byte[] removeMoirePattern(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            return OpencvJNI.removeMoirePattern(bArr, i10, i11);
        }
        return null;
    }

    public static void setModel(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        if (bArr != null) {
            OpencvJNI.setModel(bArr, i10, bArr2, i11, bArr3, i12);
        }
    }

    public static byte[] sharpen(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            return OpencvJNI.sharpen(bArr, i10, i11);
        }
        return null;
    }
}
