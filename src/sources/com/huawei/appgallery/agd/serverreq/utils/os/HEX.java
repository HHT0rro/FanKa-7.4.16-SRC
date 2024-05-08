package com.huawei.appgallery.agd.serverreq.utils.os;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class HEX {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f27553a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f27554b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @NonNull
    public static char[] a(@Nullable byte[] bArr, @NonNull char[] cArr) {
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

    @NonNull
    public static char[] encode(@Nullable byte[] bArr, boolean z10) {
        return a(bArr, z10 ? f27554b : f27553a);
    }

    @NonNull
    public static String encodeString(@Nullable byte[] bArr) {
        return encodeString(bArr, false);
    }

    @NonNull
    public static String encodeString(@Nullable byte[] bArr, boolean z10) {
        return bArr == null ? "" : new String(encode(bArr, z10));
    }
}
