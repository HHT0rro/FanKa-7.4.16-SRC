package com.android.internal.org.bouncycastle.math.raw;

import com.android.internal.org.bouncycastle.util.Pack;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Nat192 {
    private static final long M = 4294967295L;

    public static int add(int[] x10, int[] y10, int[] z10) {
        long c4 = 0 + (x10[0] & 4294967295L) + (y10[0] & 4294967295L);
        z10[0] = (int) c4;
        long c10 = (c4 >>> 32) + (x10[1] & 4294967295L) + (y10[1] & 4294967295L);
        z10[1] = (int) c10;
        long c11 = (c10 >>> 32) + (x10[2] & 4294967295L) + (y10[2] & 4294967295L);
        z10[2] = (int) c11;
        long c12 = (c11 >>> 32) + (x10[3] & 4294967295L) + (y10[3] & 4294967295L);
        z10[3] = (int) c12;
        long c13 = (c12 >>> 32) + (x10[4] & 4294967295L) + (y10[4] & 4294967295L);
        z10[4] = (int) c13;
        long c14 = (c13 >>> 32) + (x10[5] & 4294967295L) + (y10[5] & 4294967295L);
        z10[5] = (int) c14;
        return (int) (c14 >>> 32);
    }

    public static int addBothTo(int[] x10, int[] y10, int[] z10) {
        long c4 = 0 + (x10[0] & 4294967295L) + (y10[0] & 4294967295L) + (z10[0] & 4294967295L);
        z10[0] = (int) c4;
        long c10 = (c4 >>> 32) + (x10[1] & 4294967295L) + (y10[1] & 4294967295L) + (z10[1] & 4294967295L);
        z10[1] = (int) c10;
        long c11 = (c10 >>> 32) + (x10[2] & 4294967295L) + (y10[2] & 4294967295L) + (z10[2] & 4294967295L);
        z10[2] = (int) c11;
        long c12 = (c11 >>> 32) + (x10[3] & 4294967295L) + (y10[3] & 4294967295L) + (z10[3] & 4294967295L);
        z10[3] = (int) c12;
        long c13 = (c12 >>> 32) + (x10[4] & 4294967295L) + (y10[4] & 4294967295L) + (z10[4] & 4294967295L);
        z10[4] = (int) c13;
        long c14 = (c13 >>> 32) + (x10[5] & 4294967295L) + (y10[5] & 4294967295L) + (z10[5] & 4294967295L);
        z10[5] = (int) c14;
        return (int) (c14 >>> 32);
    }

    public static int addTo(int[] x10, int[] z10) {
        long c4 = 0 + (x10[0] & 4294967295L) + (z10[0] & 4294967295L);
        z10[0] = (int) c4;
        long c10 = (c4 >>> 32) + (x10[1] & 4294967295L) + (z10[1] & 4294967295L);
        z10[1] = (int) c10;
        long c11 = (c10 >>> 32) + (x10[2] & 4294967295L) + (z10[2] & 4294967295L);
        z10[2] = (int) c11;
        long c12 = (c11 >>> 32) + (x10[3] & 4294967295L) + (z10[3] & 4294967295L);
        z10[3] = (int) c12;
        long c13 = (c12 >>> 32) + (x10[4] & 4294967295L) + (z10[4] & 4294967295L);
        z10[4] = (int) c13;
        long c14 = (c13 >>> 32) + (x10[5] & 4294967295L) + (z10[5] & 4294967295L);
        z10[5] = (int) c14;
        return (int) (c14 >>> 32);
    }

    public static int addTo(int[] x10, int xOff, int[] z10, int zOff, int cIn) {
        long c4 = (cIn & 4294967295L) + (x10[xOff + 0] & 4294967295L) + (z10[zOff + 0] & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (x10[xOff + 1] & 4294967295L) + (z10[zOff + 1] & 4294967295L);
        z10[zOff + 1] = (int) c10;
        long c11 = (c10 >>> 32) + (x10[xOff + 2] & 4294967295L) + (z10[zOff + 2] & 4294967295L);
        z10[zOff + 2] = (int) c11;
        long c12 = (c11 >>> 32) + (x10[xOff + 3] & 4294967295L) + (z10[zOff + 3] & 4294967295L);
        z10[zOff + 3] = (int) c12;
        long c13 = (c12 >>> 32) + (x10[xOff + 4] & 4294967295L) + (z10[zOff + 4] & 4294967295L);
        z10[zOff + 4] = (int) c13;
        long c14 = (c13 >>> 32) + (x10[xOff + 5] & 4294967295L) + (4294967295L & z10[zOff + 5]);
        z10[zOff + 5] = (int) c14;
        return (int) (c14 >>> 32);
    }

    public static int addToEachOther(int[] u10, int uOff, int[] v2, int vOff) {
        long c4 = 0 + (u10[uOff + 0] & 4294967295L) + (v2[vOff + 0] & 4294967295L);
        u10[uOff + 0] = (int) c4;
        v2[vOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (u10[uOff + 1] & 4294967295L) + (v2[vOff + 1] & 4294967295L);
        u10[uOff + 1] = (int) c10;
        v2[vOff + 1] = (int) c10;
        long c11 = (c10 >>> 32) + (u10[uOff + 2] & 4294967295L) + (v2[vOff + 2] & 4294967295L);
        u10[uOff + 2] = (int) c11;
        v2[vOff + 2] = (int) c11;
        long c12 = (c11 >>> 32) + (u10[uOff + 3] & 4294967295L) + (v2[vOff + 3] & 4294967295L);
        u10[uOff + 3] = (int) c12;
        v2[vOff + 3] = (int) c12;
        long c13 = (c12 >>> 32) + (u10[uOff + 4] & 4294967295L) + (v2[vOff + 4] & 4294967295L);
        u10[uOff + 4] = (int) c13;
        v2[vOff + 4] = (int) c13;
        long c14 = (c13 >>> 32) + (u10[uOff + 5] & 4294967295L) + (v2[vOff + 5] & 4294967295L);
        u10[uOff + 5] = (int) c14;
        v2[vOff + 5] = (int) c14;
        return (int) (c14 >>> 32);
    }

    public static void copy(int[] x10, int[] z10) {
        z10[0] = x10[0];
        z10[1] = x10[1];
        z10[2] = x10[2];
        z10[3] = x10[3];
        z10[4] = x10[4];
        z10[5] = x10[5];
    }

    public static void copy(int[] x10, int xOff, int[] z10, int zOff) {
        z10[zOff + 0] = x10[xOff + 0];
        z10[zOff + 1] = x10[xOff + 1];
        z10[zOff + 2] = x10[xOff + 2];
        z10[zOff + 3] = x10[xOff + 3];
        z10[zOff + 4] = x10[xOff + 4];
        z10[zOff + 5] = x10[xOff + 5];
    }

    public static void copy64(long[] x10, long[] z10) {
        z10[0] = x10[0];
        z10[1] = x10[1];
        z10[2] = x10[2];
    }

    public static void copy64(long[] x10, int xOff, long[] z10, int zOff) {
        z10[zOff + 0] = x10[xOff + 0];
        z10[zOff + 1] = x10[xOff + 1];
        z10[zOff + 2] = x10[xOff + 2];
    }

    public static int[] create() {
        return new int[6];
    }

    public static long[] create64() {
        return new long[3];
    }

    public static int[] createExt() {
        return new int[12];
    }

    public static long[] createExt64() {
        return new long[6];
    }

    public static boolean diff(int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        boolean pos = gte(x10, xOff, y10, yOff);
        if (pos) {
            sub(x10, xOff, y10, yOff, z10, zOff);
        } else {
            sub(y10, yOff, x10, xOff, z10, zOff);
        }
        return pos;
    }

    public static boolean eq(int[] x10, int[] y10) {
        for (int i10 = 5; i10 >= 0; i10--) {
            if (x10[i10] != y10[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] x10, long[] y10) {
        for (int i10 = 2; i10 >= 0; i10--) {
            if (x10[i10] != y10[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger x10) {
        if (x10.signum() < 0 || x10.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] z10 = create();
        for (int i10 = 0; i10 < 6; i10++) {
            z10[i10] = x10.intValue();
            x10 = x10.shiftRight(32);
        }
        return z10;
    }

    public static long[] fromBigInteger64(BigInteger x10) {
        if (x10.signum() < 0 || x10.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        long[] z10 = create64();
        for (int i10 = 0; i10 < 3; i10++) {
            z10[i10] = x10.longValue();
            x10 = x10.shiftRight(64);
        }
        return z10;
    }

    public static int getBit(int[] x10, int bit) {
        if (bit == 0) {
            return x10[0] & 1;
        }
        int w3 = bit >> 5;
        if (w3 < 0 || w3 >= 6) {
            return 0;
        }
        int b4 = bit & 31;
        return (x10[w3] >>> b4) & 1;
    }

    public static boolean gte(int[] x10, int[] y10) {
        for (int i10 = 5; i10 >= 0; i10--) {
            int x_i = x10[i10] ^ Integer.MIN_VALUE;
            int y_i = Integer.MIN_VALUE ^ y10[i10];
            if (x_i < y_i) {
                return false;
            }
            if (x_i > y_i) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] x10, int xOff, int[] y10, int yOff) {
        for (int i10 = 5; i10 >= 0; i10--) {
            int x_i = x10[xOff + i10] ^ Integer.MIN_VALUE;
            int y_i = Integer.MIN_VALUE ^ y10[yOff + i10];
            if (x_i < y_i) {
                return false;
            }
            if (x_i > y_i) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] x10) {
        if (x10[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 6; i10++) {
            if (x10[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] x10) {
        if (x10[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 3; i10++) {
            if (x10[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] x10) {
        for (int i10 = 0; i10 < 6; i10++) {
            if (x10[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] x10) {
        for (int i10 = 0; i10 < 3; i10++) {
            if (x10[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] x10, int[] y10, int[] zz) {
        long y_0 = y10[0] & 4294967295L;
        long y_1 = y10[1] & 4294967295L;
        long y_2 = y10[2] & 4294967295L;
        long y_3 = y10[3] & 4294967295L;
        long y_4 = y10[4] & 4294967295L;
        long y_5 = y10[5] & 4294967295L;
        long x_0 = x10[0] & 4294967295L;
        long c4 = 0 + (x_0 * y_0);
        zz[0] = (int) c4;
        long c10 = (c4 >>> 32) + (x_0 * y_1);
        zz[1] = (int) c10;
        long c11 = (c10 >>> 32) + (x_0 * y_2);
        zz[2] = (int) c11;
        long c12 = (c11 >>> 32) + (x_0 * y_3);
        zz[3] = (int) c12;
        long c13 = (c12 >>> 32) + (x_0 * y_4);
        zz[4] = (int) c13;
        long c14 = (c13 >>> 32) + (x_0 * y_5);
        zz[5] = (int) c14;
        zz[6] = (int) (c14 >>> 32);
        int i10 = 1;
        for (int i11 = 6; i10 < i11; i11 = 6) {
            long x_i = x10[i10] & 4294967295L;
            long y_52 = y_5;
            long c15 = 0 + (x_i * y_0) + (zz[i10 + 0] & 4294967295L);
            zz[i10 + 0] = (int) c15;
            long y_12 = y_1;
            long c16 = (c15 >>> 32) + (x_i * y_1) + (zz[i10 + 1] & 4294967295L);
            zz[i10 + 1] = (int) c16;
            long y_42 = y_4;
            long c17 = (c16 >>> 32) + (x_i * y_2) + (zz[i10 + 2] & 4294967295L);
            zz[i10 + 2] = (int) c17;
            long c18 = (c17 >>> 32) + (x_i * y_3) + (zz[i10 + 3] & 4294967295L);
            zz[i10 + 3] = (int) c18;
            long c19 = (c18 >>> 32) + (x_i * y_42) + (zz[i10 + 4] & 4294967295L);
            zz[i10 + 4] = (int) c19;
            long c20 = (c19 >>> 32) + (x_i * y_52) + (zz[i10 + 5] & 4294967295L);
            zz[i10 + 5] = (int) c20;
            zz[i10 + 6] = (int) (c20 >>> 32);
            i10++;
            y_1 = y_12;
            y_5 = y_52;
            y_4 = y_42;
        }
    }

    public static void mul(int[] x10, int xOff, int[] y10, int yOff, int[] zz, int zzOff) {
        long y_0 = y10[yOff + 0] & 4294967295L;
        long y_1 = y10[yOff + 1] & 4294967295L;
        long y_2 = y10[yOff + 2] & 4294967295L;
        long y_3 = y10[yOff + 3] & 4294967295L;
        long y_4 = y10[yOff + 4] & 4294967295L;
        long y_5 = y10[yOff + 5] & 4294967295L;
        long x_0 = x10[xOff + 0] & 4294967295L;
        long c4 = 0 + (x_0 * y_0);
        zz[zzOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (x_0 * y_1);
        zz[zzOff + 1] = (int) c10;
        long c11 = (c10 >>> 32) + (x_0 * y_2);
        zz[zzOff + 2] = (int) c11;
        long c12 = (c11 >>> 32) + (x_0 * y_3);
        zz[zzOff + 3] = (int) c12;
        long c13 = (c12 >>> 32) + (x_0 * y_4);
        zz[zzOff + 4] = (int) c13;
        long c14 = (c13 >>> 32) + (x_0 * y_5);
        zz[zzOff + 5] = (int) c14;
        zz[zzOff + 6] = (int) (c14 >>> 32);
        int i10 = 1;
        int zzOff2 = zzOff;
        while (i10 < 6) {
            zzOff2++;
            long x_i = x10[xOff + i10] & 4294967295L;
            long c15 = 0 + (x_i * y_0) + (zz[zzOff2 + 0] & 4294967295L);
            zz[zzOff2 + 0] = (int) c15;
            long y_12 = y_1;
            long c16 = (c15 >>> 32) + (x_i * y_1) + (zz[zzOff2 + 1] & 4294967295L);
            zz[zzOff2 + 1] = (int) c16;
            long c17 = (c16 >>> 32) + (x_i * y_2) + (zz[zzOff2 + 2] & 4294967295L);
            zz[zzOff2 + 2] = (int) c17;
            long c18 = (c17 >>> 32) + (x_i * y_3) + (zz[zzOff2 + 3] & 4294967295L);
            zz[zzOff2 + 3] = (int) c18;
            long c19 = (c18 >>> 32) + (x_i * y_4) + (zz[zzOff2 + 4] & 4294967295L);
            zz[zzOff2 + 4] = (int) c19;
            long c20 = (c19 >>> 32) + (x_i * y_5) + (zz[zzOff2 + 5] & 4294967295L);
            zz[zzOff2 + 5] = (int) c20;
            zz[zzOff2 + 6] = (int) (c20 >>> 32);
            i10++;
            y_1 = y_12;
            y_0 = y_0;
        }
    }

    public static int mulAddTo(int[] x10, int[] y10, int[] zz) {
        long y_0 = y10[0] & 4294967295L;
        long y_1 = y10[1] & 4294967295L;
        long y_2 = y10[2] & 4294967295L;
        long y_3 = y10[3] & 4294967295L;
        long y_4 = y10[4] & 4294967295L;
        long y_5 = y10[5] & 4294967295L;
        long x_i = 0;
        int i10 = 0;
        while (i10 < 6) {
            long zc2 = x_i;
            long zc3 = x10[i10];
            long x_i2 = zc3 & 4294967295L;
            long j10 = x_i2 * y_0;
            long y_02 = y_0;
            long y_03 = zz[i10 + 0];
            long c4 = 0 + j10 + (y_03 & 4294967295L);
            long y_52 = y_5;
            zz[i10 + 0] = (int) c4;
            long c10 = (c4 >>> 32) + (x_i2 * y_1) + (zz[i10 + 1] & 4294967295L);
            zz[i10 + 1] = (int) c10;
            long c11 = (c10 >>> 32) + (x_i2 * y_2) + (zz[i10 + 2] & 4294967295L);
            zz[i10 + 2] = (int) c11;
            long c12 = (c11 >>> 32) + (x_i2 * y_3) + (zz[i10 + 3] & 4294967295L);
            zz[i10 + 3] = (int) c12;
            long c13 = (c12 >>> 32) + (x_i2 * y_4) + (zz[i10 + 4] & 4294967295L);
            zz[i10 + 4] = (int) c13;
            long c14 = (c13 >>> 32) + (x_i2 * y_52) + (zz[i10 + 5] & 4294967295L);
            zz[i10 + 5] = (int) c14;
            long zc4 = zc2 + (zz[i10 + 6] & 4294967295L) + (c14 >>> 32);
            zz[i10 + 6] = (int) zc4;
            x_i = zc4 >>> 32;
            i10++;
            y_5 = y_52;
            y_0 = y_02;
            y_1 = y_1;
        }
        return (int) x_i;
    }

    public static int mulAddTo(int[] x10, int xOff, int[] y10, int yOff, int[] zz, int zzOff) {
        long y_0 = y10[yOff + 0] & 4294967295L;
        long y_1 = y10[yOff + 1] & 4294967295L;
        long y_2 = y10[yOff + 2] & 4294967295L;
        long y_3 = y10[yOff + 3] & 4294967295L;
        long y_4 = y10[yOff + 4] & 4294967295L;
        long y_5 = y10[yOff + 5] & 4294967295L;
        long zc2 = 0;
        int i10 = 0;
        int zzOff2 = zzOff;
        while (i10 < 6) {
            long y_52 = y_5;
            long y_53 = x10[xOff + i10];
            long x_i = y_53 & 4294967295L;
            long c4 = 0 + (x_i * y_0) + (zz[zzOff2 + 0] & 4294967295L);
            zz[zzOff2 + 0] = (int) c4;
            long c10 = (c4 >>> 32) + (x_i * y_1) + (zz[zzOff2 + 1] & 4294967295L);
            zz[zzOff2 + 1] = (int) c10;
            long c11 = (c10 >>> 32) + (x_i * y_2) + (zz[zzOff2 + 2] & 4294967295L);
            zz[zzOff2 + 2] = (int) c11;
            long c12 = (c11 >>> 32) + (x_i * y_3) + (zz[zzOff2 + 3] & 4294967295L);
            zz[zzOff2 + 3] = (int) c12;
            long c13 = (c12 >>> 32) + (x_i * y_4) + (zz[zzOff2 + 4] & 4294967295L);
            zz[zzOff2 + 4] = (int) c13;
            long c14 = (c13 >>> 32) + (x_i * y_52) + (zz[zzOff2 + 5] & 4294967295L);
            zz[zzOff2 + 5] = (int) c14;
            long zc3 = (zz[zzOff2 + 6] & 4294967295L) + (c14 >>> 32) + zc2;
            zz[zzOff2 + 6] = (int) zc3;
            zc2 = zc3 >>> 32;
            zzOff2++;
            y_2 = y_2;
            y_5 = y_52;
            y_1 = y_1;
            i10++;
            y_0 = y_0;
        }
        return (int) zc2;
    }

    public static long mul33Add(int w3, int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        long wVal = w3 & 4294967295L;
        long x02 = x10[xOff + 0] & 4294967295L;
        long c4 = 0 + (wVal * x02) + (y10[yOff + 0] & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long x12 = x10[xOff + 1] & 4294967295L;
        long c10 = (c4 >>> 32) + (wVal * x12) + x02 + (y10[yOff + 1] & 4294967295L);
        z10[zOff + 1] = (int) c10;
        long x22 = x10[xOff + 2] & 4294967295L;
        long c11 = (c10 >>> 32) + (wVal * x22) + x12 + (y10[yOff + 2] & 4294967295L);
        z10[zOff + 2] = (int) c11;
        long x32 = x10[xOff + 3] & 4294967295L;
        long c12 = (c11 >>> 32) + (wVal * x32) + x22 + (y10[yOff + 3] & 4294967295L);
        z10[zOff + 3] = (int) c12;
        long x42 = x10[xOff + 4] & 4294967295L;
        long c13 = (c12 >>> 32) + (wVal * x42) + x32 + (y10[yOff + 4] & 4294967295L);
        z10[zOff + 4] = (int) c13;
        long x52 = x10[xOff + 5] & 4294967295L;
        long c14 = (c13 >>> 32) + (wVal * x52) + x42 + (y10[yOff + 5] & 4294967295L);
        z10[zOff + 5] = (int) c14;
        return (c14 >>> 32) + x52;
    }

    public static int mulWordAddExt(int x10, int[] yy, int yyOff, int[] zz, int zzOff) {
        long xVal = x10 & 4294967295L;
        long c4 = 0 + ((yy[yyOff + 0] & 4294967295L) * xVal) + (zz[zzOff + 0] & 4294967295L);
        zz[zzOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + ((yy[yyOff + 1] & 4294967295L) * xVal) + (zz[zzOff + 1] & 4294967295L);
        zz[zzOff + 1] = (int) c10;
        long c11 = (c10 >>> 32) + ((yy[yyOff + 2] & 4294967295L) * xVal) + (zz[zzOff + 2] & 4294967295L);
        zz[zzOff + 2] = (int) c11;
        long c12 = (c11 >>> 32) + ((yy[yyOff + 3] & 4294967295L) * xVal) + (zz[zzOff + 3] & 4294967295L);
        zz[zzOff + 3] = (int) c12;
        long c13 = (c12 >>> 32) + ((yy[yyOff + 4] & 4294967295L) * xVal) + (zz[zzOff + 4] & 4294967295L);
        zz[zzOff + 4] = (int) c13;
        long c14 = (c13 >>> 32) + ((yy[yyOff + 5] & 4294967295L) * xVal) + (4294967295L & zz[zzOff + 5]);
        zz[zzOff + 5] = (int) c14;
        return (int) (c14 >>> 32);
    }

    public static int mul33DWordAdd(int x10, long y10, int[] z10, int zOff) {
        long xVal = x10 & 4294967295L;
        long y00 = y10 & 4294967295L;
        long c4 = 0 + (xVal * y00) + (z10[zOff + 0] & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long y01 = y10 >>> 32;
        long c10 = (c4 >>> 32) + (xVal * y01) + y00 + (z10[zOff + 1] & 4294967295L);
        z10[zOff + 1] = (int) c10;
        long c11 = (c10 >>> 32) + (z10[zOff + 2] & 4294967295L) + y01;
        z10[zOff + 2] = (int) c11;
        long c12 = (c11 >>> 32) + (z10[zOff + 3] & 4294967295L);
        z10[zOff + 3] = (int) c12;
        if ((c12 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(6, z10, zOff, 4);
    }

    public static int mul33WordAdd(int x10, int y10, int[] z10, int zOff) {
        long xVal = x10 & 4294967295L;
        long yVal = y10 & 4294967295L;
        long c4 = 0 + (yVal * xVal) + (z10[zOff + 0] & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (z10[zOff + 1] & 4294967295L) + yVal;
        z10[zOff + 1] = (int) c10;
        long c11 = (c10 >>> 32) + (4294967295L & z10[zOff + 2]);
        z10[zOff + 2] = (int) c11;
        if ((c11 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(6, z10, zOff, 3);
    }

    public static int mulWordDwordAdd(int x10, long y10, int[] z10, int zOff) {
        long xVal = x10 & 4294967295L;
        long c4 = 0 + ((y10 & 4294967295L) * xVal) + (z10[zOff + 0] & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + ((y10 >>> 32) * xVal) + (z10[zOff + 1] & 4294967295L);
        z10[zOff + 1] = (int) c10;
        long c11 = (c10 >>> 32) + (4294967295L & z10[zOff + 2]);
        z10[zOff + 2] = (int) c11;
        if ((c11 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(6, z10, zOff, 3);
    }

    public static int mulWord(int x10, int[] y10, int[] z10, int zOff) {
        long c4 = 0;
        long xVal = x10 & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((y10[i10] & 4294967295L) * xVal);
            z10[zOff + i10] = (int) c10;
            c4 = c10 >>> 32;
            i10++;
        } while (i10 < 6);
        return (int) c4;
    }

    public static void square(int[] x10, int[] zz) {
        long x_0 = x10[0] & 4294967295L;
        int c4 = 0;
        int i10 = 5;
        int j10 = 12;
        while (true) {
            int i11 = i10 - 1;
            long xVal = x10[i10] & 4294967295L;
            long p10 = xVal * xVal;
            int j11 = j10 - 1;
            zz[j11] = (c4 << 31) | ((int) (p10 >>> 33));
            j10 = j11 - 1;
            zz[j10] = (int) (p10 >>> 1);
            c4 = (int) p10;
            if (i11 <= 0) {
                long p11 = x_0 * x_0;
                long zz_1 = ((c4 << 31) & 4294967295L) | (p11 >>> 33);
                zz[0] = (int) p11;
                int c10 = ((int) (p11 >>> 32)) & 1;
                int j12 = x10[1];
                long x_1 = j12 & 4294967295L;
                long zz_12 = zz_1 + (x_1 * x_0);
                int w3 = (int) zz_12;
                zz[1] = (w3 << 1) | c10;
                int c11 = w3 >>> 31;
                long x_2 = x10[2] & 4294967295L;
                long zz_2 = (zz[2] & 4294967295L) + (zz_12 >>> 32) + (x_2 * x_0);
                int w10 = (int) zz_2;
                zz[2] = (w10 << 1) | c11;
                int c12 = w10 >>> 31;
                long zz_3 = (zz[3] & 4294967295L) + (zz_2 >>> 32) + (x_2 * x_1);
                long zz_4 = (zz[4] & 4294967295L) + (zz_3 >>> 32);
                long x_3 = x10[3] & 4294967295L;
                long zz_5 = (zz[5] & 4294967295L) + (zz_4 >>> 32);
                long zz_6 = (zz[6] & 4294967295L) + (zz_5 >>> 32);
                long zz_32 = (zz_3 & 4294967295L) + (x_3 * x_0);
                int w11 = (int) zz_32;
                zz[3] = (w11 << 1) | c12;
                int c13 = w11 >>> 31;
                long zz_42 = (zz_4 & 4294967295L) + (zz_32 >>> 32) + (x_3 * x_1);
                long zz_52 = (zz_5 & 4294967295L) + (zz_42 >>> 32) + (x_3 * x_2);
                long zz_62 = zz_6 + (zz_52 >>> 32);
                long zz_33 = x10[4];
                long x_4 = zz_33 & 4294967295L;
                long zz_7 = (zz[7] & 4294967295L) + (zz_62 >>> 32);
                long zz_8 = (zz[8] & 4294967295L) + (zz_7 >>> 32);
                long zz_43 = (zz_42 & 4294967295L) + (x_4 * x_0);
                int w12 = (int) zz_43;
                zz[4] = (w12 << 1) | c13;
                int c14 = w12 >>> 31;
                long zz_53 = (zz_52 & 4294967295L) + (zz_43 >>> 32) + (x_4 * x_1);
                long zz_63 = (zz_62 & 4294967295L) + (zz_53 >>> 32) + (x_4 * x_2);
                long zz_72 = (zz_7 & 4294967295L) + (zz_63 >>> 32) + (x_4 * x_3);
                long zz_64 = zz_63 & 4294967295L;
                long zz_65 = zz_72 >>> 32;
                long zz_82 = zz_8 + zz_65;
                long x_5 = x10[5] & 4294967295L;
                long zz_9 = (zz[9] & 4294967295L) + (zz_82 >>> 32);
                long zz_10 = (zz[10] & 4294967295L) + (zz_9 >>> 32);
                long zz_54 = (zz_53 & 4294967295L) + (x_5 * x_0);
                int w13 = (int) zz_54;
                zz[5] = (w13 << 1) | c14;
                int c15 = w13 >>> 31;
                long zz_55 = zz_64 + (zz_54 >>> 32) + (x_5 * x_1);
                long zz_73 = (zz_72 & 4294967295L) + (zz_55 >>> 32) + (x_5 * x_2);
                long zz_83 = (zz_82 & 4294967295L) + (zz_73 >>> 32) + (x_5 * x_3);
                long zz_92 = (zz_9 & 4294967295L) + (zz_83 >>> 32) + (x_5 * x_4);
                long zz_102 = zz_10 + (zz_92 >>> 32);
                int w14 = (int) zz_55;
                zz[6] = (w14 << 1) | c15;
                int c16 = w14 >>> 31;
                int w15 = (int) zz_73;
                zz[7] = (w15 << 1) | c16;
                int c17 = w15 >>> 31;
                int w16 = (int) zz_83;
                zz[8] = (w16 << 1) | c17;
                int c18 = w16 >>> 31;
                int w17 = (int) zz_92;
                zz[9] = (w17 << 1) | c18;
                int c19 = w17 >>> 31;
                int w18 = (int) zz_102;
                zz[10] = (w18 << 1) | c19;
                int c20 = w18 >>> 31;
                zz[11] = ((zz[11] + ((int) (zz_102 >>> 32))) << 1) | c20;
                return;
            }
            i10 = i11;
        }
    }

    public static void square(int[] x10, int xOff, int[] zz, int zzOff) {
        long x_0 = x10[xOff + 0] & 4294967295L;
        int c4 = 0;
        int i10 = 5;
        int j10 = 12;
        while (true) {
            int i11 = i10 - 1;
            long xVal = x10[xOff + i10] & 4294967295L;
            long p10 = xVal * xVal;
            int j11 = j10 - 1;
            zz[zzOff + j11] = (c4 << 31) | ((int) (p10 >>> 33));
            j10 = j11 - 1;
            zz[zzOff + j10] = (int) (p10 >>> 1);
            c4 = (int) p10;
            if (i11 <= 0) {
                long p11 = x_0 * x_0;
                long zz_1 = ((c4 << 31) & 4294967295L) | (p11 >>> 33);
                zz[zzOff + 0] = (int) p11;
                int c10 = ((int) (p11 >>> 32)) & 1;
                int j12 = xOff + 1;
                long x_1 = x10[j12] & 4294967295L;
                long zz_2 = zz[zzOff + 2] & 4294967295L;
                long zz_12 = zz_1 + (x_1 * x_0);
                int w3 = (int) zz_12;
                zz[zzOff + 1] = (w3 << 1) | c10;
                int c11 = w3 >>> 31;
                long zz_22 = zz_2 + (zz_12 >>> 32);
                long x_2 = x10[xOff + 2] & 4294967295L;
                long zz_13 = zz[zzOff + 4];
                long zz_23 = zz_22 + (x_2 * x_0);
                int w10 = (int) zz_23;
                zz[zzOff + 2] = (w10 << 1) | c11;
                int c12 = w10 >>> 31;
                long zz_3 = (zz[zzOff + 3] & 4294967295L) + (zz_23 >>> 32) + (x_2 * x_1);
                long zz_4 = (zz_13 & 4294967295L) + (zz_3 >>> 32);
                long x_3 = x10[xOff + 3] & 4294967295L;
                long zz_5 = (zz[zzOff + 5] & 4294967295L) + (zz_4 >>> 32);
                long zz_32 = (zz_3 & 4294967295L) + (x_3 * x_0);
                int w11 = (int) zz_32;
                zz[zzOff + 3] = (w11 << 1) | c12;
                int c13 = w11 >>> 31;
                long zz_42 = (zz_4 & 4294967295L) + (zz_32 >>> 32) + (x_3 * x_1);
                long zz_52 = (zz_5 & 4294967295L) + (zz_42 >>> 32) + (x_3 * x_2);
                long zz_6 = (zz[zzOff + 6] & 4294967295L) + (zz_5 >>> 32) + (zz_52 >>> 32);
                long x_4 = x10[xOff + 4] & 4294967295L;
                long zz_7 = (zz[zzOff + 7] & 4294967295L) + (zz_6 >>> 32);
                long zz_8 = (zz[zzOff + 8] & 4294967295L) + (zz_7 >>> 32);
                long zz_43 = (zz_42 & 4294967295L) + (x_4 * x_0);
                int w12 = (int) zz_43;
                zz[zzOff + 4] = (w12 << 1) | c13;
                int c14 = w12 >>> 31;
                long zz_53 = (zz_52 & 4294967295L) + (zz_43 >>> 32) + (x_4 * x_1);
                long zz_62 = (zz_6 & 4294967295L) + (zz_53 >>> 32) + (x_4 * x_2);
                long zz_72 = (zz_7 & 4294967295L) + (zz_62 >>> 32) + (x_4 * x_3);
                long zz_82 = zz_8 + (zz_72 >>> 32);
                long x_5 = x10[xOff + 5] & 4294967295L;
                long zz_9 = (zz[zzOff + 9] & 4294967295L) + (zz_82 >>> 32);
                long zz_83 = zz_82 & 4294967295L;
                long zz_84 = zz[zzOff + 10];
                long zz_10 = (zz_84 & 4294967295L) + (zz_9 >>> 32);
                long zz_54 = (zz_53 & 4294967295L) + (x_5 * x_0);
                int w13 = (int) zz_54;
                zz[zzOff + 5] = (w13 << 1) | c14;
                int c15 = w13 >>> 31;
                long zz_63 = (zz_62 & 4294967295L) + (zz_54 >>> 32) + (x_5 * x_1);
                long zz_73 = (zz_72 & 4294967295L) + (zz_63 >>> 32) + (x_5 * x_2);
                long x_02 = zz_83 + (zz_73 >>> 32) + (x_5 * x_3);
                long zz_92 = (zz_9 & 4294967295L) + (x_02 >>> 32) + (x_5 * x_4);
                long zz_102 = zz_10 + (zz_92 >>> 32);
                int w14 = (int) zz_63;
                zz[zzOff + 6] = (w14 << 1) | c15;
                int c16 = w14 >>> 31;
                int w15 = (int) zz_73;
                zz[zzOff + 7] = (w15 << 1) | c16;
                int c17 = w15 >>> 31;
                int w16 = (int) x_02;
                zz[zzOff + 8] = (w16 << 1) | c17;
                int c18 = w16 >>> 31;
                int w17 = (int) zz_92;
                zz[zzOff + 9] = (w17 << 1) | c18;
                int c19 = w17 >>> 31;
                int w18 = (int) zz_102;
                zz[zzOff + 10] = (w18 << 1) | c19;
                int c20 = w18 >>> 31;
                long zz_85 = zz_102 >>> 32;
                zz[zzOff + 11] = ((zz[zzOff + 11] + ((int) zz_85)) << 1) | c20;
                return;
            }
            i10 = i11;
        }
    }

    public static int sub(int[] x10, int[] y10, int[] z10) {
        long c4 = 0 + ((x10[0] & 4294967295L) - (y10[0] & 4294967295L));
        z10[0] = (int) c4;
        long c10 = (c4 >> 32) + ((x10[1] & 4294967295L) - (y10[1] & 4294967295L));
        z10[1] = (int) c10;
        long c11 = (c10 >> 32) + ((x10[2] & 4294967295L) - (y10[2] & 4294967295L));
        z10[2] = (int) c11;
        long c12 = (c11 >> 32) + ((x10[3] & 4294967295L) - (y10[3] & 4294967295L));
        z10[3] = (int) c12;
        long c13 = (c12 >> 32) + ((x10[4] & 4294967295L) - (y10[4] & 4294967295L));
        z10[4] = (int) c13;
        long c14 = (c13 >> 32) + ((x10[5] & 4294967295L) - (y10[5] & 4294967295L));
        z10[5] = (int) c14;
        return (int) (c14 >> 32);
    }

    public static int sub(int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        long c4 = 0 + ((x10[xOff + 0] & 4294967295L) - (y10[yOff + 0] & 4294967295L));
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >> 32) + ((x10[xOff + 1] & 4294967295L) - (y10[yOff + 1] & 4294967295L));
        z10[zOff + 1] = (int) c10;
        long c11 = (c10 >> 32) + ((x10[xOff + 2] & 4294967295L) - (y10[yOff + 2] & 4294967295L));
        z10[zOff + 2] = (int) c11;
        long c12 = (c11 >> 32) + ((x10[xOff + 3] & 4294967295L) - (y10[yOff + 3] & 4294967295L));
        z10[zOff + 3] = (int) c12;
        long c13 = (c12 >> 32) + ((x10[xOff + 4] & 4294967295L) - (y10[yOff + 4] & 4294967295L));
        z10[zOff + 4] = (int) c13;
        long c14 = (c13 >> 32) + ((x10[xOff + 5] & 4294967295L) - (y10[yOff + 5] & 4294967295L));
        z10[zOff + 5] = (int) c14;
        return (int) (c14 >> 32);
    }

    public static int subBothFrom(int[] x10, int[] y10, int[] z10) {
        long c4 = 0 + (((z10[0] & 4294967295L) - (x10[0] & 4294967295L)) - (y10[0] & 4294967295L));
        z10[0] = (int) c4;
        long c10 = (c4 >> 32) + (((z10[1] & 4294967295L) - (x10[1] & 4294967295L)) - (y10[1] & 4294967295L));
        z10[1] = (int) c10;
        long c11 = (c10 >> 32) + (((z10[2] & 4294967295L) - (x10[2] & 4294967295L)) - (y10[2] & 4294967295L));
        z10[2] = (int) c11;
        long c12 = (c11 >> 32) + (((z10[3] & 4294967295L) - (x10[3] & 4294967295L)) - (y10[3] & 4294967295L));
        z10[3] = (int) c12;
        long c13 = (c12 >> 32) + (((z10[4] & 4294967295L) - (x10[4] & 4294967295L)) - (y10[4] & 4294967295L));
        z10[4] = (int) c13;
        long c14 = (c13 >> 32) + (((z10[5] & 4294967295L) - (x10[5] & 4294967295L)) - (y10[5] & 4294967295L));
        z10[5] = (int) c14;
        return (int) (c14 >> 32);
    }

    public static int subFrom(int[] x10, int[] z10) {
        long c4 = 0 + ((z10[0] & 4294967295L) - (x10[0] & 4294967295L));
        z10[0] = (int) c4;
        long c10 = (c4 >> 32) + ((z10[1] & 4294967295L) - (x10[1] & 4294967295L));
        z10[1] = (int) c10;
        long c11 = (c10 >> 32) + ((z10[2] & 4294967295L) - (x10[2] & 4294967295L));
        z10[2] = (int) c11;
        long c12 = (c11 >> 32) + ((z10[3] & 4294967295L) - (x10[3] & 4294967295L));
        z10[3] = (int) c12;
        long c13 = (c12 >> 32) + ((z10[4] & 4294967295L) - (x10[4] & 4294967295L));
        z10[4] = (int) c13;
        long c14 = (c13 >> 32) + ((z10[5] & 4294967295L) - (x10[5] & 4294967295L));
        z10[5] = (int) c14;
        return (int) (c14 >> 32);
    }

    public static int subFrom(int[] x10, int xOff, int[] z10, int zOff) {
        long c4 = 0 + ((z10[zOff + 0] & 4294967295L) - (x10[xOff + 0] & 4294967295L));
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >> 32) + ((z10[zOff + 1] & 4294967295L) - (x10[xOff + 1] & 4294967295L));
        z10[zOff + 1] = (int) c10;
        long c11 = (c10 >> 32) + ((z10[zOff + 2] & 4294967295L) - (x10[xOff + 2] & 4294967295L));
        z10[zOff + 2] = (int) c11;
        long c12 = (c11 >> 32) + ((z10[zOff + 3] & 4294967295L) - (x10[xOff + 3] & 4294967295L));
        z10[zOff + 3] = (int) c12;
        long c13 = (c12 >> 32) + ((z10[zOff + 4] & 4294967295L) - (x10[xOff + 4] & 4294967295L));
        z10[zOff + 4] = (int) c13;
        long c14 = (c13 >> 32) + ((z10[zOff + 5] & 4294967295L) - (x10[xOff + 5] & 4294967295L));
        z10[zOff + 5] = (int) c14;
        return (int) (c14 >> 32);
    }

    public static BigInteger toBigInteger(int[] x10) {
        byte[] bs = new byte[24];
        for (int i10 = 0; i10 < 6; i10++) {
            int x_i = x10[i10];
            if (x_i != 0) {
                Pack.intToBigEndian(x_i, bs, (5 - i10) << 2);
            }
        }
        return new BigInteger(1, bs);
    }

    public static BigInteger toBigInteger64(long[] x10) {
        byte[] bs = new byte[24];
        for (int i10 = 0; i10 < 3; i10++) {
            long x_i = x10[i10];
            if (x_i != 0) {
                Pack.longToBigEndian(x_i, bs, (2 - i10) << 3);
            }
        }
        return new BigInteger(1, bs);
    }

    public static void zero(int[] z10) {
        z10[0] = 0;
        z10[1] = 0;
        z10[2] = 0;
        z10[3] = 0;
        z10[4] = 0;
        z10[5] = 0;
    }
}
