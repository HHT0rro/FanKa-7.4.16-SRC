package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f47871a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder(i11 * 2);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = bArr[i10 + i12] & 255;
            char[] cArr = f47871a;
            sb2.append(cArr[i13 >> 4]);
            sb2.append(cArr[i13 & 15]);
        }
        return sb2.toString();
    }

    public static boolean b(Context context) {
        return i.f47502a;
    }
}
