package com.huawei.jmessage;

import androidx.annotation.NonNull;

/* compiled from: HEX.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f32028a = "0123456789abcdef".toCharArray();

    @NonNull
    public static String a(byte[] bArr) {
        return bArr != null ? new String(a(bArr, f32028a)) : "";
    }

    private static char[] a(byte[] bArr, char[] cArr) {
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
}
