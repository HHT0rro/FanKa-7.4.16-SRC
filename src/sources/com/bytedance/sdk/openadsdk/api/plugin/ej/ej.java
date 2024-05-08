package com.bytedance.sdk.openadsdk.api.plugin.ej;

import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej {

    /* renamed from: m, reason: collision with root package name */
    private static final char[] f11116m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String m(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return m(bArr, 0, bArr.length);
    }

    public static String m(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i10 >= 0 && i10 + i11 <= bArr.length) {
            int i12 = i11 * 2;
            char[] cArr = new char[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = bArr[i14 + i10] & 255;
                int i16 = i13 + 1;
                char[] cArr2 = f11116m;
                cArr[i13] = cArr2[i15 >> 4];
                i13 = i16 + 1;
                cArr[i16] = cArr2[i15 & 15];
            }
            return new String(cArr, 0, i12);
        }
        throw new IndexOutOfBoundsException();
    }
}
