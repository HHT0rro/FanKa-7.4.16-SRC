package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class YUVUtils {
    public static final int NV12 = 6;
    public static final int NV21 = 7;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 2;
    public static final int ORIENTATION_270 = 3;
    public static final int ORIENTATION_90 = 1;
    public static final int RGBA = 0;
    public static final int YUV420P = 5;

    public static native void RGBA2BGR(byte[] bArr, byte[] bArr2, int i10, int i11, int i12);

    public static native void RGBA2YUV(byte[] bArr, byte[] bArr2, int i10, int i11, int i12);

    public static native void YUV2RGBA(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10);

    public static native void YUVRESIZE(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, int i14);
}
