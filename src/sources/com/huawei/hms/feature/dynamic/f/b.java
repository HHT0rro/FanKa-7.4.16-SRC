package com.huawei.hms.feature.dynamic.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f29900a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f29901b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] a(byte[] bArr) {
        return a(bArr, false);
    }

    public static char[] a(byte[] bArr, boolean z10) {
        return a(bArr, z10 ? f29901b : f29900a);
    }

    public static char[] a(byte[] bArr, char[] cArr) {
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

    public static String b(byte[] bArr, boolean z10) {
        return new String(a(bArr, z10));
    }
}
