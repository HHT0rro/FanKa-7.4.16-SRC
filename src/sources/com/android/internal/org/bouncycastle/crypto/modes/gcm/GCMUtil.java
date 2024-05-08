package com.android.internal.org.bouncycastle.crypto.modes.gcm;

import com.android.internal.org.bouncycastle.math.raw.Interleave;
import com.android.internal.org.bouncycastle.util.Longs;
import com.android.internal.org.bouncycastle.util.Pack;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class GCMUtil {
    private static final int E1 = -520093696;
    private static final long E1L = -2233785415175766016L;

    public static byte[] oneAsBytes() {
        byte[] tmp = new byte[16];
        tmp[0] = Byte.MIN_VALUE;
        return tmp;
    }

    public static int[] oneAsInts() {
        int[] tmp = new int[4];
        tmp[0] = Integer.MIN_VALUE;
        return tmp;
    }

    public static long[] oneAsLongs() {
        long[] tmp = {Long.MIN_VALUE};
        return tmp;
    }

    public static byte[] asBytes(int[] x10) {
        byte[] z10 = new byte[16];
        Pack.intToBigEndian(x10, z10, 0);
        return z10;
    }

    public static void asBytes(int[] x10, byte[] z10) {
        Pack.intToBigEndian(x10, z10, 0);
    }

    public static byte[] asBytes(long[] x10) {
        byte[] z10 = new byte[16];
        Pack.longToBigEndian(x10, z10, 0);
        return z10;
    }

    public static void asBytes(long[] x10, byte[] z10) {
        Pack.longToBigEndian(x10, z10, 0);
    }

    public static int[] asInts(byte[] x10) {
        int[] z10 = new int[4];
        Pack.bigEndianToInt(x10, 0, z10);
        return z10;
    }

    public static void asInts(byte[] x10, int[] z10) {
        Pack.bigEndianToInt(x10, 0, z10);
    }

    public static long[] asLongs(byte[] x10) {
        long[] z10 = new long[2];
        Pack.bigEndianToLong(x10, 0, z10);
        return z10;
    }

    public static void asLongs(byte[] x10, long[] z10) {
        Pack.bigEndianToLong(x10, 0, z10);
    }

    public static void copy(int[] x10, int[] z10) {
        z10[0] = x10[0];
        z10[1] = x10[1];
        z10[2] = x10[2];
        z10[3] = x10[3];
    }

    public static void copy(long[] x10, long[] z10) {
        z10[0] = x10[0];
        z10[1] = x10[1];
    }

    public static void divideP(long[] x10, long[] z10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long m10 = x02 >> 63;
        z10[0] = ((x02 ^ (E1L & m10)) << 1) | (x12 >>> 63);
        z10[1] = (x12 << 1) | (-m10);
    }

    public static void multiply(byte[] x10, byte[] y10) {
        long[] t12 = asLongs(x10);
        long[] t2 = asLongs(y10);
        multiply(t12, t2);
        asBytes(t12, x10);
    }

    public static void multiply(int[] x10, int[] y10) {
        int y02 = y10[0];
        int y1 = y10[1];
        int y22 = y10[2];
        int y32 = y10[3];
        int z02 = 0;
        int z1 = 0;
        int z22 = 0;
        int z32 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            int bits = x10[i10];
            for (int j10 = 0; j10 < 32; j10++) {
                int m12 = bits >> 31;
                bits <<= 1;
                z02 ^= y02 & m12;
                z1 ^= y1 & m12;
                z22 ^= y22 & m12;
                z32 ^= y32 & m12;
                int m22 = (y32 << 31) >> 8;
                y32 = (y32 >>> 1) | (y22 << 31);
                y22 = (y22 >>> 1) | (y1 << 31);
                y1 = (y1 >>> 1) | (y02 << 31);
                y02 = (y02 >>> 1) ^ (m22 & E1);
            }
        }
        x10[0] = z02;
        x10[1] = z1;
        x10[2] = z22;
        x10[3] = z32;
    }

    public static void multiply(long[] x10, long[] y10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long y02 = y10[0];
        long y1 = y10[1];
        long x0r = Longs.reverse(x02);
        long x1r = Longs.reverse(x12);
        long y0r = Longs.reverse(y02);
        long y1r = Longs.reverse(y1);
        long h02 = Longs.reverse(implMul64(x0r, y0r));
        long h12 = implMul64(x02, y02) << 1;
        long h22 = Longs.reverse(implMul64(x1r, y1r));
        long h32 = implMul64(x12, y1) << 1;
        long h42 = Longs.reverse(implMul64(x0r ^ x1r, y0r ^ y1r));
        long h52 = implMul64(x02 ^ x12, y02 ^ y1) << 1;
        long z1 = ((h12 ^ h02) ^ h22) ^ h42;
        long z22 = (((h22 ^ h12) ^ h32) ^ h52) ^ ((h32 << 62) ^ (h32 << 57));
        long z02 = h02 ^ (((z22 ^ (z22 >>> 1)) ^ (z22 >>> 2)) ^ (z22 >>> 7));
        x10[0] = z02;
        x10[1] = (z1 ^ (((h32 ^ (h32 >>> 1)) ^ (h32 >>> 2)) ^ (h32 >>> 7))) ^ (((z22 << 63) ^ (z22 << 62)) ^ (z22 << 57));
    }

    public static void multiplyP(int[] x10) {
        int x02 = x10[0];
        int x12 = x10[1];
        int x22 = x10[2];
        int x32 = x10[3];
        int m10 = (x32 << 31) >> 31;
        x10[0] = (x02 >>> 1) ^ (E1 & m10);
        x10[1] = (x12 >>> 1) | (x02 << 31);
        x10[2] = (x22 >>> 1) | (x12 << 31);
        x10[3] = (x32 >>> 1) | (x22 << 31);
    }

    public static void multiplyP(int[] x10, int[] z10) {
        int x02 = x10[0];
        int x12 = x10[1];
        int x22 = x10[2];
        int x32 = x10[3];
        int m10 = (x32 << 31) >> 31;
        z10[0] = (x02 >>> 1) ^ (E1 & m10);
        z10[1] = (x12 >>> 1) | (x02 << 31);
        z10[2] = (x22 >>> 1) | (x12 << 31);
        z10[3] = (x32 >>> 1) | (x22 << 31);
    }

    public static void multiplyP(long[] x10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long m10 = (x12 << 63) >> 63;
        x10[0] = (x02 >>> 1) ^ (E1L & m10);
        x10[1] = (x12 >>> 1) | (x02 << 63);
    }

    public static void multiplyP(long[] x10, long[] z10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long m10 = (x12 << 63) >> 63;
        z10[0] = (x02 >>> 1) ^ (E1L & m10);
        z10[1] = (x12 >>> 1) | (x02 << 63);
    }

    public static void multiplyP3(long[] x10, long[] z10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long c4 = x12 << 61;
        z10[0] = ((((x02 >>> 3) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        z10[1] = (x12 >>> 3) | (x02 << 61);
    }

    public static void multiplyP4(long[] x10, long[] z10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long c4 = x12 << 60;
        z10[0] = ((((x02 >>> 4) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        z10[1] = (x12 >>> 4) | (x02 << 60);
    }

    public static void multiplyP7(long[] x10, long[] z10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long c4 = x12 << 57;
        z10[0] = ((((x02 >>> 7) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        z10[1] = (x12 >>> 7) | (x02 << 57);
    }

    public static void multiplyP8(int[] x10) {
        int x02 = x10[0];
        int x12 = x10[1];
        int x22 = x10[2];
        int x32 = x10[3];
        int c4 = x32 << 24;
        x10[0] = ((((x02 >>> 8) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        x10[1] = (x12 >>> 8) | (x02 << 24);
        x10[2] = (x22 >>> 8) | (x12 << 24);
        x10[3] = (x32 >>> 8) | (x22 << 24);
    }

    public static void multiplyP8(int[] x10, int[] y10) {
        int x02 = x10[0];
        int x12 = x10[1];
        int x22 = x10[2];
        int x32 = x10[3];
        int c4 = x32 << 24;
        y10[0] = ((((x02 >>> 8) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        y10[1] = (x12 >>> 8) | (x02 << 24);
        y10[2] = (x22 >>> 8) | (x12 << 24);
        y10[3] = (x32 >>> 8) | (x22 << 24);
    }

    public static void multiplyP8(long[] x10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long c4 = x12 << 56;
        x10[0] = ((((x02 >>> 8) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        x10[1] = (x12 >>> 8) | (x02 << 56);
    }

    public static void multiplyP8(long[] x10, long[] y10) {
        long x02 = x10[0];
        long x12 = x10[1];
        long c4 = x12 << 56;
        y10[0] = ((((x02 >>> 8) ^ c4) ^ (c4 >>> 1)) ^ (c4 >>> 2)) ^ (c4 >>> 7);
        y10[1] = (x12 >>> 8) | (x02 << 56);
    }

    public static long[] pAsLongs() {
        long[] tmp = {4611686018427387904L};
        return tmp;
    }

    public static void square(long[] x10, long[] z10) {
        long[] t2 = new long[4];
        Interleave.expand64To128Rev(x10[0], t2, 0);
        Interleave.expand64To128Rev(x10[1], t2, 2);
        long z02 = t2[0];
        long z1 = t2[1];
        long z22 = t2[2];
        long z32 = t2[3];
        long z23 = z22 ^ (((z32 << 63) ^ (z32 << 62)) ^ (z32 << 57));
        z10[0] = z02 ^ ((((z23 >>> 1) ^ z23) ^ (z23 >>> 2)) ^ (z23 >>> 7));
        z10[1] = (z1 ^ ((((z32 >>> 1) ^ z32) ^ (z32 >>> 2)) ^ (z32 >>> 7))) ^ (((z23 << 62) ^ (z23 << 63)) ^ (z23 << 57));
    }

    public static void xor(byte[] x10, byte[] y10) {
        int i10 = 0;
        do {
            x10[i10] = (byte) (x10[i10] ^ y10[i10]);
            int i11 = i10 + 1;
            x10[i11] = (byte) (x10[i11] ^ y10[i11]);
            int i12 = i11 + 1;
            x10[i12] = (byte) (x10[i12] ^ y10[i12]);
            int i13 = i12 + 1;
            x10[i13] = (byte) (x10[i13] ^ y10[i13]);
            i10 = i13 + 1;
        } while (i10 < 16);
    }

    public static void xor(byte[] x10, byte[] y10, int yOff) {
        int i10 = 0;
        do {
            x10[i10] = (byte) (x10[i10] ^ y10[yOff + i10]);
            int i11 = i10 + 1;
            x10[i11] = (byte) (x10[i11] ^ y10[yOff + i11]);
            int i12 = i11 + 1;
            x10[i12] = (byte) (x10[i12] ^ y10[yOff + i12]);
            int i13 = i12 + 1;
            x10[i13] = (byte) (x10[i13] ^ y10[yOff + i13]);
            i10 = i13 + 1;
        } while (i10 < 16);
    }

    public static void xor(byte[] x10, int xOff, byte[] y10, int yOff, byte[] z10, int zOff) {
        int i10 = 0;
        do {
            z10[zOff + i10] = (byte) (x10[xOff + i10] ^ y10[yOff + i10]);
            int i11 = i10 + 1;
            z10[zOff + i11] = (byte) (x10[xOff + i11] ^ y10[yOff + i11]);
            int i12 = i11 + 1;
            z10[zOff + i12] = (byte) (x10[xOff + i12] ^ y10[yOff + i12]);
            int i13 = i12 + 1;
            z10[zOff + i13] = (byte) (x10[xOff + i13] ^ y10[yOff + i13]);
            i10 = i13 + 1;
        } while (i10 < 16);
    }

    public static void xor(byte[] x10, byte[] y10, int yOff, int yLen) {
        while (true) {
            yLen--;
            if (yLen >= 0) {
                x10[yLen] = (byte) (x10[yLen] ^ y10[yOff + yLen]);
            } else {
                return;
            }
        }
    }

    public static void xor(byte[] x10, int xOff, byte[] y10, int yOff, int len) {
        while (true) {
            len--;
            if (len >= 0) {
                int i10 = xOff + len;
                x10[i10] = (byte) (x10[i10] ^ y10[yOff + len]);
            } else {
                return;
            }
        }
    }

    public static void xor(byte[] x10, byte[] y10, byte[] z10) {
        int i10 = 0;
        do {
            z10[i10] = (byte) (x10[i10] ^ y10[i10]);
            int i11 = i10 + 1;
            z10[i11] = (byte) (x10[i11] ^ y10[i11]);
            int i12 = i11 + 1;
            z10[i12] = (byte) (x10[i12] ^ y10[i12]);
            int i13 = i12 + 1;
            z10[i13] = (byte) (x10[i13] ^ y10[i13]);
            i10 = i13 + 1;
        } while (i10 < 16);
    }

    public static void xor(int[] x10, int[] y10) {
        x10[0] = x10[0] ^ y10[0];
        x10[1] = x10[1] ^ y10[1];
        x10[2] = x10[2] ^ y10[2];
        x10[3] = x10[3] ^ y10[3];
    }

    public static void xor(int[] x10, int[] y10, int[] z10) {
        z10[0] = x10[0] ^ y10[0];
        z10[1] = x10[1] ^ y10[1];
        z10[2] = x10[2] ^ y10[2];
        z10[3] = x10[3] ^ y10[3];
    }

    public static void xor(long[] x10, long[] y10) {
        x10[0] = x10[0] ^ y10[0];
        x10[1] = x10[1] ^ y10[1];
    }

    public static void xor(long[] x10, long[] y10, long[] z10) {
        z10[0] = x10[0] ^ y10[0];
        z10[1] = x10[1] ^ y10[1];
    }

    private static long implMul64(long x10, long y10) {
        long x02 = x10 & 1229782938247303441L;
        long x12 = x10 & 2459565876494606882L;
        long x22 = x10 & 4919131752989213764L;
        long x32 = x10 & (-8608480567731124088L);
        long y02 = y10 & 1229782938247303441L;
        long y1 = y10 & 2459565876494606882L;
        long y22 = y10 & 4919131752989213764L;
        long y32 = y10 & (-8608480567731124088L);
        long z02 = (((x02 * y02) ^ (x12 * y32)) ^ (x22 * y22)) ^ (x32 * y1);
        long z1 = (((x02 * y1) ^ (x12 * y02)) ^ (x22 * y32)) ^ (x32 * y22);
        long z22 = (((x02 * y22) ^ (x12 * y1)) ^ (x22 * y02)) ^ (x32 * y32);
        long z32 = (((x02 * y32) ^ (x12 * y22)) ^ (x22 * y1)) ^ (x32 * y02);
        return (z02 & 1229782938247303441L) | (z1 & 2459565876494606882L) | (z22 & 4919131752989213764L) | (z32 & (-8608480567731124088L));
    }
}
