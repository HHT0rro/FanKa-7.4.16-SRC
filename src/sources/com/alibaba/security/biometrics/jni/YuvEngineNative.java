package com.alibaba.security.biometrics.jni;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class YuvEngineNative {
    public static final native void I420ClockWiseRotate90(long j10, byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void I420ToNv21(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static native void I420ToYv12(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static native void Nv12ClockWiseRotate90(long j10, byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv12ToNv21(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static native void Nv21ClockWiseRotate180(long j10, byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv21ClockWiseRotate270(long j10, byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv21ClockWiseRotate90(long j10, byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Nv21ToI420(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static native void Nv21ToNv12(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static native void Nv21ToYV12(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static native void YV12ToNv21(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static final native void Yv12ClockWiseRotate90(long j10, byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2);

    public static native void Yv12ToI420(long j10, byte[] bArr, byte[] bArr2, int i10, int i11);

    public static native void cutCommonYuv(long j10, int i10, int i11, int i12, byte[] bArr, int i13, int i14, byte[] bArr2, int i15, int i16);

    public static native void getSpecYuvBuffer(long j10, int i10, byte[] bArr, byte[] bArr2, int i11, int i12, int i13, int i14);

    public static native long startYuvEngine();

    public static native void stopYuvEngine(long j10);

    public static native void yuvAddWaterMark(long j10, int i10, int i11, int i12, byte[] bArr, int i13, int i14, byte[] bArr2, int i15, int i16);
}
