package com.alibaba.security.realidentity.build;

import java.lang.reflect.Array;
import java.util.zip.Checksum;

/* compiled from: CRC64.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cq implements Checksum {

    /* renamed from: a, reason: collision with root package name */
    private static final long f3354a = -3932672073523589310L;

    /* renamed from: b, reason: collision with root package name */
    private static final long[][] f3355b = (long[][]) Array.newInstance((Class<?>) long.class, 8, 256);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3356c = 64;

    /* renamed from: d, reason: collision with root package name */
    private long f3357d = 0;

    static {
        for (int i10 = 0; i10 < 256; i10++) {
            long j10 = i10;
            for (int i11 = 0; i11 < 8; i11++) {
                j10 = (j10 & 1) == 1 ? (j10 >>> 1) ^ f3354a : j10 >>> 1;
            }
            f3355b[0][i10] = j10;
        }
        for (int i12 = 0; i12 < 256; i12++) {
            long j11 = f3355b[0][i12];
            for (int i13 = 1; i13 < 8; i13++) {
                long[][] jArr = f3355b;
                j11 = (j11 >>> 8) ^ jArr[0][(int) (255 & j11)];
                jArr[i13][i12] = j11;
            }
        }
    }

    private static long a(long[] jArr, long j10) {
        int i10 = 0;
        long j11 = 0;
        while (j10 != 0) {
            if ((j10 & 1) == 1) {
                j11 ^= jArr[i10];
            }
            j10 >>>= 1;
            i10++;
        }
        return j11;
    }

    @Override // java.util.zip.Checksum
    public final long getValue() {
        return this.f3357d;
    }

    @Override // java.util.zip.Checksum
    public final void reset() {
        this.f3357d = 0L;
    }

    @Override // java.util.zip.Checksum
    public final void update(byte[] bArr, int i10, int i11) {
        this.f3357d = ~this.f3357d;
        int i12 = i10;
        int i13 = i11;
        while (i13 >= 8) {
            long[][] jArr = f3355b;
            long[] jArr2 = jArr[7];
            long j10 = this.f3357d;
            this.f3357d = ((((((jArr[6][(int) ((bArr[i12 + 1] & 255) ^ ((j10 >>> 8) & 255))] ^ jArr2[(int) ((j10 & 255) ^ (bArr[i12] & 255))]) ^ jArr[5][(int) (((j10 >>> 16) & 255) ^ (bArr[i12 + 2] & 255))]) ^ jArr[4][(int) (((j10 >>> 24) & 255) ^ (bArr[i12 + 3] & 255))]) ^ jArr[3][(int) (((j10 >>> 32) & 255) ^ (bArr[i12 + 4] & 255))]) ^ jArr[2][(int) (((j10 >>> 40) & 255) ^ (bArr[i12 + 5] & 255))]) ^ jArr[1][(int) ((255 & (j10 >>> 48)) ^ (bArr[i12 + 6] & 255))]) ^ jArr[0][(int) ((j10 >>> 56) ^ (bArr[i12 + 7] & 255))];
            i12 += 8;
            i13 -= 8;
        }
        while (i13 > 0) {
            long[] jArr3 = f3355b[0];
            long j11 = this.f3357d;
            this.f3357d = (j11 >>> 8) ^ jArr3[(int) ((bArr[i12] ^ j11) & 255)];
            i12++;
            i13--;
        }
        this.f3357d = ~this.f3357d;
    }

    private static void a(long[] jArr, long[] jArr2) {
        for (int i10 = 0; i10 < 64; i10++) {
            jArr[i10] = a(jArr2, jArr2[i10]);
        }
    }

    public static long a(long j10, long j11, long j12) {
        if (j12 == 0) {
            return j10;
        }
        long[] jArr = new long[64];
        long[] jArr2 = new long[64];
        jArr2[0] = -3932672073523589310L;
        long j13 = 1;
        for (int i10 = 1; i10 < 64; i10++) {
            jArr2[i10] = j13;
            j13 <<= 1;
        }
        a(jArr, jArr2);
        a(jArr2, jArr);
        long j14 = j10;
        long j15 = j12;
        do {
            a(jArr, jArr2);
            if ((j15 & 1) == 1) {
                j14 = a(jArr, j14);
            }
            long j16 = j15 >>> 1;
            if (j16 == 0) {
                break;
            }
            a(jArr2, jArr);
            if ((j16 & 1) == 1) {
                j14 = a(jArr2, j14);
            }
            j15 = j16 >>> 1;
        } while (j15 != 0);
        return j14 ^ j11;
    }

    @Override // java.util.zip.Checksum
    public final void update(int i10) {
        update(new byte[]{(byte) (i10 & 255)}, 0, 1);
    }

    private void a(byte[] bArr) {
        update(bArr, 0, 1);
    }
}
