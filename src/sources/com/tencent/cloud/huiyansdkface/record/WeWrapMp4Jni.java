package com.tencent.cloud.huiyansdkface.record;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeWrapMp4Jni {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42143a = "WeWrapMp4Jni";

    /* renamed from: b, reason: collision with root package name */
    private int f42144b = 0;

    static {
        System.loadLibrary("weyuv");
        System.loadLibrary("weconvert");
    }

    private final native void NV21ToI420(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, byte[] bArr3, byte[] bArr4);

    private final native void NV21ToNV12(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, byte[] bArr3, byte[] bArr4);

    public void NV21ToTarget(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, byte[] bArr3, byte[] bArr4) {
        if (i12 != 39 && i12 != 2130706688) {
            switch (i12) {
                case 19:
                case 20:
                    NV21ToI420(bArr, bArr2, i10, i11, i13, bArr3, bArr4);
                    return;
                case 21:
                    break;
                default:
                    return;
            }
        }
        NV21ToNV12(bArr, bArr2, i10, i11, i13, bArr3, bArr4);
    }
}
