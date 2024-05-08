package com.kycgm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GmCipher {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36654a = 0;

    static {
        System.loadLibrary("kycgm");
    }

    public GmCipher() {
        throw new UnsupportedOperationException();
    }

    public static native byte[] sm2Encrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] sm4CbcDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] sm4CbcEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
