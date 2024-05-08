package com.kwad.components.core.e.b;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c {
    private final int[] Kd;

    private c(int[] iArr) {
        this.Kd = iArr;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long b(long j10, int[] iArr) {
        int i10 = 31;
        while (i10 > 23) {
            j10 = d(i10, iArr, j10);
            i10--;
        }
        while (i10 > 15) {
            j10 = c(i10, iArr, j10);
            i10--;
        }
        while (i10 > 7) {
            j10 = d(i10, iArr, j10);
            i10--;
        }
        while (i10 >= 0) {
            j10 = c(i10, iArr, j10);
            i10--;
        }
        return j10;
    }

    private static long c(int i10, int[] iArr, long j10) {
        long j11 = (j10 >> 32) & 65535;
        long j12 = (j10 >> 16) & 65535;
        return ((i10 + 1) ^ ((j10 >>> 48) ^ j11)) | ((j10 & 65535) << 16) | (f(i10, iArr, j11) << 48) | (j12 << 32);
    }

    private static long d(int i10, int[] iArr, long j10) {
        long j11 = (j10 >> 32) & 65535;
        return (((i10 + 1) ^ (f(i10, iArr, j11) ^ ((j10 >> 16) & 65535))) << 32) | (f(i10, iArr, j11) << 48) | ((j10 & 65535) << 16) | (j10 >>> 48);
    }

    private static long e(int i10, int[] iArr, long j10) {
        int i11 = (int) (j10 >>> 8);
        int i12 = (int) (j10 & 255);
        int i13 = i10 * 4;
        int i14 = iArr[i13 % 10];
        int i15 = iArr[(i13 + 1) % 10];
        int i16 = iArr[(i13 + 2) % 10];
        int i17 = iArr[(i13 + 3) % 10];
        int[] iArr2 = b.Kc;
        int i18 = iArr2[i14 ^ i12] ^ i11;
        return ((i18 ^ iArr2[(i12 ^ iArr2[i15 ^ i18]) ^ i16]) << 8) | (iArr2[i17 ^ r7] ^ r8);
    }

    private static long f(int i10, int[] iArr, long j10) {
        int i11 = (int) (255 & j10);
        int i12 = (int) (j10 >>> 8);
        int i13 = i10 * 4;
        int i14 = iArr[(i13 + 3) % 10];
        int i15 = iArr[(i13 + 2) % 10];
        int i16 = iArr[(i13 + 1) % 10];
        int i17 = iArr[i13 % 10];
        int[] iArr2 = b.Kc;
        int i18 = iArr2[i14 ^ i12] ^ i11;
        return ((iArr2[i17 ^ r6] ^ r7) << 8) | (i18 ^ iArr2[(i12 ^ iArr2[i18 ^ i15]) ^ i16]);
    }

    public final long ad(String str) {
        byte[] decode = com.kwad.sdk.core.a.c.Dv().decode(str);
        if (decode != null && decode.length == 8) {
            return b(ByteBuffer.wrap(decode).getLong(), this.Kd);
        }
        throw new RuntimeException("fail to decode: " + str);
    }

    public final String u(long j10) {
        return com.kwad.sdk.core.a.c.Dt().encodeToString(ByteBuffer.allocate(8).putLong(a(j10, this.Kd)).array());
    }

    private static long a(long j10, int[] iArr) {
        int i10 = 0;
        while (i10 < 8) {
            j10 = a(i10, iArr, j10);
            i10++;
        }
        while (i10 < 16) {
            j10 = b(i10, iArr, j10);
            i10++;
        }
        while (i10 < 24) {
            j10 = a(i10, iArr, j10);
            i10++;
        }
        while (i10 < 32) {
            j10 = b(i10, iArr, j10);
            i10++;
        }
        return j10;
    }

    private static long b(int i10, int[] iArr, long j10) {
        long j11 = j10 >>> 48;
        long j12 = (j10 >> 16) & 65535;
        long e2 = e(i10, iArr, j11);
        return (((i10 + 1) ^ (j11 ^ ((j10 >> 32) & 65535))) << 16) | ((j10 & 65535) << 48) | (e2 << 32) | j12;
    }

    private static long a(int i10, int[] iArr, long j10) {
        long j11 = j10 >>> 48;
        long j12 = (j10 >> 32) & 65535;
        return (e(i10, iArr, j11) << 32) | ((((j10 & 65535) ^ e(i10, iArr, j11)) ^ (i10 + 1)) << 48) | (j12 << 16) | ((j10 >> 16) & 65535);
    }
}
