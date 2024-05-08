package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l {
    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            bArr2[i10] = bArr[i10 >>> 4];
            bArr3[i10] = bArr[i10 & 15];
        }
    }

    public static boolean a(int i10, int i11) {
        return i10 == i11;
    }

    public static boolean a(long j10, long j11) {
        return j10 == j11;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static boolean a(boolean z10, boolean z11) {
        return z10 == z11;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy((Object) byteBuffer.array(), 0, (Object) bArr, 0, position);
        return bArr;
    }
}
