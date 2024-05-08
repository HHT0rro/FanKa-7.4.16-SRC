package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f40124a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b4 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = f40124a;
            cArr[i11 + 1] = cArr2[b4 & 15];
            cArr[i11] = cArr2[((byte) (b4 >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
