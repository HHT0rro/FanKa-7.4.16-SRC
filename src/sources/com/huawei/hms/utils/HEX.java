package com.huawei.hms.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class HEX {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f31923a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f31924b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private HEX() {
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return new char[0];
        }
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i10 + 1;
            cArr2[i10] = cArr[(bArr[i11] & 240) >>> 4];
            i10 = i12 + 1;
            cArr2[i12] = cArr[bArr[i11] & 15];
        }
        return cArr2;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z10) {
        return new String(encodeHex(bArr, z10));
    }

    public static char[] encodeHex(byte[] bArr, boolean z10) {
        return a(bArr, z10 ? f31924b : f31923a);
    }
}
