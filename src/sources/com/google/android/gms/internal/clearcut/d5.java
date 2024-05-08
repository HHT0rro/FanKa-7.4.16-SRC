package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d5 {
    public static int a(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static long b(long j10, long j11, long j12) {
        long j13 = (j10 ^ j11) * j12;
        long j14 = ((j13 ^ (j13 >>> 47)) ^ j11) * j12;
        return (j14 ^ (j14 >>> 47)) * j12;
    }

    public static long c(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            StringBuilder sb2 = new StringBuilder(67);
            sb2.append("Out of bound index with offput: 0 and length: ");
            sb2.append(length);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i10 = 37;
        char c4 = 0;
        if (length <= 32) {
            if (length > 16) {
                long j10 = (length << 1) - 7286425919675154353L;
                long e2 = e(bArr, 0) * (-5435081209227447693L);
                long e10 = e(bArr, 8);
                int i11 = length + 0;
                long e11 = e(bArr, i11 - 8) * j10;
                return b(Long.rotateRight(e2 + e10, 43) + Long.rotateRight(e11, 30) + (e(bArr, i11 - 16) * (-7286425919675154353L)), e2 + Long.rotateRight(e10 - 7286425919675154353L, 18) + e11, j10);
            }
            if (length >= 8) {
                long j11 = (length << 1) - 7286425919675154353L;
                long e12 = e(bArr, 0) - 7286425919675154353L;
                long e13 = e(bArr, (length + 0) - 8);
                return b((Long.rotateRight(e13, 37) * j11) + e12, (Long.rotateRight(e12, 25) + e13) * j11, j11);
            }
            if (length >= 4) {
                return b(length + ((a(bArr, 0) & 4294967295L) << 3), a(bArr, (length + 0) - 4) & 4294967295L, (length << 1) - 7286425919675154353L);
            }
            if (length <= 0) {
                return -7286425919675154353L;
            }
            long j12 = (((bArr[0] & 255) + ((bArr[(length >> 1) + 0] & 255) << 8)) * (-7286425919675154353L)) ^ ((length + ((bArr[(length - 1) + 0] & 255) << 2)) * (-4348849565147123417L));
            return (j12 ^ (j12 >>> 47)) * (-7286425919675154353L);
        }
        if (length <= 64) {
            long j13 = (length << 1) - 7286425919675154353L;
            long e14 = e(bArr, 0) * (-7286425919675154353L);
            long e15 = e(bArr, 8);
            int i12 = length + 0;
            long e16 = e(bArr, i12 - 8) * j13;
            long rotateRight = Long.rotateRight(e14 + e15, 43) + Long.rotateRight(e16, 30) + (e(bArr, i12 - 16) * (-7286425919675154353L));
            long b4 = b(rotateRight, Long.rotateRight((-7286425919675154353L) + e15, 18) + e14 + e16, j13);
            long e17 = e(bArr, 16) * j13;
            long e18 = e(bArr, 24);
            long e19 = (rotateRight + e(bArr, i12 - 32)) * j13;
            return b(Long.rotateRight(e17 + e18, 43) + Long.rotateRight(e19, 30) + ((b4 + e(bArr, i12 - 24)) * j13), e17 + Long.rotateRight(e18 + e14, 18) + e19, j13);
        }
        long j14 = 2480279821605975764L;
        long j15 = 1390051526045402406L;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long e20 = e(bArr, 0) + 95310865018149119L;
        int i13 = length - 1;
        int i14 = ((i13 / 64) << 6) + 0;
        int i15 = i13 & 63;
        int i16 = (i14 + i15) - 63;
        int i17 = 0;
        while (true) {
            long rotateRight2 = Long.rotateRight(e20 + j14 + jArr[c4] + e(bArr, i17 + 8), i10) * (-5435081209227447693L);
            long rotateRight3 = Long.rotateRight(j14 + jArr[1] + e(bArr, i17 + 48), 42) * (-5435081209227447693L);
            long j16 = rotateRight2 ^ jArr2[1];
            long e21 = rotateRight3 + jArr[0] + e(bArr, i17 + 40);
            long rotateRight4 = Long.rotateRight(j15 + jArr2[0], 33) * (-5435081209227447693L);
            int i18 = i15;
            int i19 = i14;
            d(bArr, i17, jArr[1] * (-5435081209227447693L), j16 + jArr2[0], jArr);
            d(bArr, i17 + 32, rotateRight4 + jArr2[1], e21 + e(bArr, i17 + 16), jArr2);
            int i20 = i17 + 64;
            if (i20 == i19) {
                long j17 = ((255 & j16) << 1) - 5435081209227447693L;
                jArr2[0] = jArr2[0] + i18;
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long rotateRight5 = Long.rotateRight(rotateRight4 + e21 + jArr[0] + e(bArr, i16 + 8), 37) * j17;
                long rotateRight6 = Long.rotateRight(e21 + jArr[1] + e(bArr, i16 + 48), 42) * j17;
                long j18 = rotateRight5 ^ (jArr2[1] * 9);
                long e22 = rotateRight6 + (jArr[0] * 9) + e(bArr, i16 + 40);
                long rotateRight7 = Long.rotateRight(j16 + jArr2[0], 33) * j17;
                d(bArr, i16, jArr[1] * j17, j18 + jArr2[0], jArr);
                d(bArr, i16 + 32, jArr2[1] + rotateRight7, e(bArr, i16 + 16) + e22, jArr2);
                return b(b(jArr[0], jArr2[0], j17) + (((e22 >>> 47) ^ e22) * (-4348849565147123417L)) + j18, b(jArr[1], jArr2[1], j17) + rotateRight7, j17);
            }
            i17 = i20;
            i14 = i19;
            i15 = i18;
            j15 = j16;
            j14 = e21;
            e20 = rotateRight4;
            i10 = 37;
            c4 = 0;
        }
    }

    public static void d(byte[] bArr, int i10, long j10, long j11, long[] jArr) {
        long e2 = e(bArr, i10);
        long e10 = e(bArr, i10 + 8);
        long e11 = e(bArr, i10 + 16);
        long e12 = e(bArr, i10 + 24);
        long j12 = j10 + e2;
        long j13 = e10 + j12 + e11;
        long rotateRight = Long.rotateRight(j11 + j12 + e12, 21) + Long.rotateRight(j13, 44);
        jArr[0] = j13 + e12;
        jArr[1] = rotateRight + j12;
    }

    public static long e(byte[] bArr, int i10) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i10, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }
}
