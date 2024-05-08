package com.jd.ad.sdk.jad_zi;

import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_ob {
    public static final Charset jad_an = Charset.forName("UTF-8");

    public static void jad_an(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    public static boolean jad_an(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }
}
