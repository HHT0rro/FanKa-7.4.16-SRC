package com.amap.api.col.p0003l;

import java.text.SimpleDateFormat;

/* compiled from: DataTypeUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class la {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f6864a;

    /* renamed from: b, reason: collision with root package name */
    private static String f6865b;

    public static byte[] a(long j10) {
        byte[] bArr = new byte[6];
        for (int i10 = 0; i10 < 6; i10++) {
            bArr[i10] = (byte) ((j10 >> (((6 - i10) - 1) * 8)) & 255);
        }
        return bArr;
    }

    public static String a(byte[] bArr, String str) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            String hexString = Integer.toHexString(bArr[i10] & 255);
            if (hexString.length() < 2) {
                sb2.append("0");
            }
            sb2.append(hexString);
            if (str.length() > 0 && i10 < bArr.length - 1) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }
}
