package com.android.internal.org.bouncycastle.math.raw;

import com.android.internal.org.bouncycastle.util.Pack;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Nat {
    private static final long M = 4294967295L;

    public static int add(int len, int[] x10, int[] y10, int[] z10) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (x10[i10] & 4294967295L) + (4294967295L & y10[i10]);
            z10[i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int add33At(int len, int x10, int[] z10, int zPos) {
        long c4 = (z10[zPos + 0] & 4294967295L) + (x10 & 4294967295L);
        z10[zPos + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[zPos + 1]) + 1;
        z10[zPos + 1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zPos + 2);
    }

    public static int add33At(int len, int x10, int[] z10, int zOff, int zPos) {
        long c4 = (z10[zOff + zPos] & 4294967295L) + (x10 & 4294967295L);
        z10[zOff + zPos] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[zOff + zPos + 1]) + 1;
        z10[zOff + zPos + 1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zOff, zPos + 2);
    }

    public static int add33To(int len, int x10, int[] z10) {
        long c4 = (z10[0] & 4294967295L) + (x10 & 4294967295L);
        z10[0] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[1]) + 1;
        z10[1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, 2);
    }

    public static int add33To(int len, int x10, int[] z10, int zOff) {
        long c4 = (z10[zOff + 0] & 4294967295L) + (x10 & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[zOff + 1]) + 1;
        z10[zOff + 1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zOff, 2);
    }

    public static int addBothTo(int len, int[] x10, int[] y10, int[] z10) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (x10[i10] & 4294967295L) + (y10[i10] & 4294967295L) + (4294967295L & z10[i10]);
            z10[i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int addBothTo(int len, int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (x10[xOff + i10] & 4294967295L) + (y10[yOff + i10] & 4294967295L) + (4294967295L & z10[zOff + i10]);
            z10[zOff + i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int addDWordAt(int len, long x10, int[] z10, int zPos) {
        long c4 = (z10[zPos + 0] & 4294967295L) + (x10 & 4294967295L);
        z10[zPos + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[zPos + 1]) + (x10 >>> 32);
        z10[zPos + 1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zPos + 2);
    }

    public static int addDWordAt(int len, long x10, int[] z10, int zOff, int zPos) {
        long c4 = (z10[zOff + zPos] & 4294967295L) + (x10 & 4294967295L);
        z10[zOff + zPos] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[zOff + zPos + 1]) + (x10 >>> 32);
        z10[zOff + zPos + 1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zOff, zPos + 2);
    }

    public static int addDWordTo(int len, long x10, int[] z10) {
        long c4 = (z10[0] & 4294967295L) + (x10 & 4294967295L);
        z10[0] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[1]) + (x10 >>> 32);
        z10[1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, 2);
    }

    public static int addDWordTo(int len, long x10, int[] z10, int zOff) {
        long c4 = (z10[zOff + 0] & 4294967295L) + (x10 & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >>> 32) + (4294967295L & z10[zOff + 1]) + (x10 >>> 32);
        z10[zOff + 1] = (int) c10;
        if ((c10 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zOff, 2);
    }

    public static int addTo(int len, int[] x10, int[] z10) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (x10[i10] & 4294967295L) + (4294967295L & z10[i10]);
            z10[i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int addTo(int len, int[] x10, int xOff, int[] z10, int zOff) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (x10[xOff + i10] & 4294967295L) + (4294967295L & z10[zOff + i10]);
            z10[zOff + i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int addTo(int len, int[] x10, int xOff, int[] z10, int zOff, int cIn) {
        long c4 = cIn & 4294967295L;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (x10[xOff + i10] & 4294967295L) + (z10[zOff + i10] & 4294967295L);
            z10[zOff + i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        return (int) c4;
    }

    public static int addToEachOther(int len, int[] u10, int uOff, int[] v2, int vOff) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (u10[uOff + i10] & 4294967295L) + (4294967295L & v2[vOff + i10]);
            u10[uOff + i10] = (int) c10;
            v2[vOff + i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int addWordAt(int len, int x10, int[] z10, int zPos) {
        long c4 = (x10 & 4294967295L) + (4294967295L & z10[zPos]);
        z10[zPos] = (int) c4;
        if ((c4 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zPos + 1);
    }

    public static int addWordAt(int len, int x10, int[] z10, int zOff, int zPos) {
        long c4 = (x10 & 4294967295L) + (4294967295L & z10[zOff + zPos]);
        z10[zOff + zPos] = (int) c4;
        if ((c4 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zOff, zPos + 1);
    }

    public static int addWordTo(int len, int x10, int[] z10) {
        long c4 = (x10 & 4294967295L) + (4294967295L & z10[0]);
        z10[0] = (int) c4;
        if ((c4 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, 1);
    }

    public static int addWordTo(int len, int x10, int[] z10, int zOff) {
        long c4 = (x10 & 4294967295L) + (4294967295L & z10[zOff]);
        z10[zOff] = (int) c4;
        if ((c4 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zOff, 1);
    }

    public static int cadd(int len, int mask, int[] x10, int[] y10, int[] z10) {
        long MASK = (-(mask & 1)) & 4294967295L;
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (x10[i10] & 4294967295L) + (y10[i10] & MASK);
            z10[i10] = (int) c10;
            c4 = c10 >>> 32;
        }
        return (int) c4;
    }

    public static void cmov(int len, int mask, int[] x10, int xOff, int[] z10, int zOff) {
        int mask2 = -(mask & 1);
        for (int i10 = 0; i10 < len; i10++) {
            int z_i = z10[zOff + i10];
            int diff = x10[xOff + i10] ^ z_i;
            z10[zOff + i10] = z_i ^ (diff & mask2);
        }
    }

    public static int compare(int len, int[] x10, int[] y10) {
        for (int i10 = len - 1; i10 >= 0; i10--) {
            int x_i = x10[i10] ^ Integer.MIN_VALUE;
            int y_i = Integer.MIN_VALUE ^ y10[i10];
            if (x_i < y_i) {
                return -1;
            }
            if (x_i > y_i) {
                return 1;
            }
        }
        return 0;
    }

    public static int compare(int len, int[] x10, int xOff, int[] y10, int yOff) {
        for (int i10 = len - 1; i10 >= 0; i10--) {
            int x_i = x10[xOff + i10] ^ Integer.MIN_VALUE;
            int y_i = Integer.MIN_VALUE ^ y10[yOff + i10];
            if (x_i < y_i) {
                return -1;
            }
            if (x_i > y_i) {
                return 1;
            }
        }
        return 0;
    }

    public static int[] copy(int len, int[] x10) {
        int[] z10 = new int[len];
        System.arraycopy((Object) x10, 0, (Object) z10, 0, len);
        return z10;
    }

    public static void copy(int len, int[] x10, int[] z10) {
        System.arraycopy((Object) x10, 0, (Object) z10, 0, len);
    }

    public static void copy(int len, int[] x10, int xOff, int[] z10, int zOff) {
        System.arraycopy((Object) x10, xOff, (Object) z10, zOff, len);
    }

    public static long[] copy64(int len, long[] x10) {
        long[] z10 = new long[len];
        System.arraycopy((Object) x10, 0, (Object) z10, 0, len);
        return z10;
    }

    public static void copy64(int len, long[] x10, long[] z10) {
        System.arraycopy((Object) x10, 0, (Object) z10, 0, len);
    }

    public static void copy64(int len, long[] x10, int xOff, long[] z10, int zOff) {
        System.arraycopy((Object) x10, xOff, (Object) z10, zOff, len);
    }

    public static int[] create(int len) {
        return new int[len];
    }

    public static long[] create64(int len) {
        return new long[len];
    }

    public static int csub(int len, int mask, int[] x10, int[] y10, int[] z10) {
        long MASK = (-(mask & 1)) & 4294967295L;
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + ((x10[i10] & 4294967295L) - (y10[i10] & MASK));
            z10[i10] = (int) c10;
            c4 = c10 >> 32;
        }
        return (int) c4;
    }

    public static int csub(int len, int mask, int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        long MASK = (-(mask & 1)) & 4294967295L;
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + ((x10[xOff + i10] & 4294967295L) - (y10[yOff + i10] & MASK));
            z10[zOff + i10] = (int) c10;
            c4 = c10 >> 32;
        }
        return (int) c4;
    }

    public static int dec(int len, int[] z10) {
        for (int i10 = 0; i10 < len; i10++) {
            int i11 = z10[i10] - 1;
            z10[i10] = i11;
            if (i11 != -1) {
                return 0;
            }
        }
        return -1;
    }

    public static int dec(int len, int[] x10, int[] z10) {
        int i10 = 0;
        while (i10 < len) {
            int c4 = x10[i10] - 1;
            z10[i10] = c4;
            i10++;
            if (c4 != -1) {
                while (i10 < len) {
                    z10[i10] = x10[i10];
                    i10++;
                }
                return 0;
            }
        }
        return -1;
    }

    public static int decAt(int len, int[] z10, int zPos) {
        for (int i10 = zPos; i10 < len; i10++) {
            int i11 = z10[i10] - 1;
            z10[i10] = i11;
            if (i11 != -1) {
                return 0;
            }
        }
        return -1;
    }

    public static int decAt(int len, int[] z10, int zOff, int zPos) {
        for (int i10 = zPos; i10 < len; i10++) {
            int i11 = zOff + i10;
            int i12 = z10[i11] - 1;
            z10[i11] = i12;
            if (i12 != -1) {
                return 0;
            }
        }
        return -1;
    }

    public static boolean diff(int len, int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        boolean pos = gte(len, x10, xOff, y10, yOff);
        if (pos) {
            sub(len, x10, xOff, y10, yOff, z10, zOff);
        } else {
            sub(len, y10, yOff, x10, xOff, z10, zOff);
        }
        return pos;
    }

    public static boolean eq(int len, int[] x10, int[] y10) {
        for (int i10 = len - 1; i10 >= 0; i10--) {
            if (x10[i10] != y10[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int equalTo(int len, int[] x10, int y10) {
        int d10 = x10[0] ^ y10;
        for (int i10 = 1; i10 < len; i10++) {
            d10 |= x10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static int equalTo(int len, int[] x10, int xOff, int y10) {
        int d10 = x10[xOff] ^ y10;
        for (int i10 = 1; i10 < len; i10++) {
            d10 |= x10[xOff + i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static int equalTo(int len, int[] x10, int[] y10) {
        int d10 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            d10 |= x10[i10] ^ y10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static int equalTo(int len, int[] x10, int xOff, int[] y10, int yOff) {
        int d10 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            d10 |= x10[xOff + i10] ^ y10[yOff + i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static int equalToZero(int len, int[] x10) {
        int d10 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            d10 |= x10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static int equalToZero(int len, int[] x10, int xOff) {
        int d10 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            d10 |= x10[xOff + i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static int[] fromBigInteger(int bits, BigInteger x10) {
        if (x10.signum() < 0 || x10.bitLength() > bits) {
            throw new IllegalArgumentException();
        }
        int len = (bits + 31) >> 5;
        int[] z10 = create(len);
        for (int i10 = 0; i10 < len; i10++) {
            z10[i10] = x10.intValue();
            x10 = x10.shiftRight(32);
        }
        return z10;
    }

    public static long[] fromBigInteger64(int bits, BigInteger x10) {
        if (x10.signum() < 0 || x10.bitLength() > bits) {
            throw new IllegalArgumentException();
        }
        int len = (bits + 63) >> 6;
        long[] z10 = create64(len);
        for (int i10 = 0; i10 < len; i10++) {
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
        if (w3 < 0 || w3 >= x10.length) {
            return 0;
        }
        int b4 = bit & 31;
        return (x10[w3] >>> b4) & 1;
    }

    public static boolean gte(int len, int[] x10, int[] y10) {
        for (int i10 = len - 1; i10 >= 0; i10--) {
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

    public static boolean gte(int len, int[] x10, int xOff, int[] y10, int yOff) {
        for (int i10 = len - 1; i10 >= 0; i10--) {
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

    public static int inc(int len, int[] z10) {
        for (int i10 = 0; i10 < len; i10++) {
            int i11 = z10[i10] + 1;
            z10[i10] = i11;
            if (i11 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int inc(int len, int[] x10, int[] z10) {
        int i10 = 0;
        while (i10 < len) {
            int c4 = x10[i10] + 1;
            z10[i10] = c4;
            i10++;
            if (c4 != 0) {
                while (i10 < len) {
                    z10[i10] = x10[i10];
                    i10++;
                }
                return 0;
            }
        }
        return 1;
    }

    public static int incAt(int len, int[] z10, int zPos) {
        for (int i10 = zPos; i10 < len; i10++) {
            int i11 = z10[i10] + 1;
            z10[i10] = i11;
            if (i11 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int incAt(int len, int[] z10, int zOff, int zPos) {
        for (int i10 = zPos; i10 < len; i10++) {
            int i11 = zOff + i10;
            int i12 = z10[i11] + 1;
            z10[i11] = i12;
            if (i12 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static boolean isOne(int len, int[] x10) {
        if (x10[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < len; i10++) {
            if (x10[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int len, int[] x10) {
        for (int i10 = 0; i10 < len; i10++) {
            if (x10[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int lessThan(int len, int[] x10, int[] y10) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            c4 = (c4 + ((x10[i10] & 4294967295L) - (4294967295L & y10[i10]))) >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int lessThan(int len, int[] x10, int xOff, int[] y10, int yOff) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            c4 = (c4 + ((x10[xOff + i10] & 4294967295L) - (4294967295L & y10[yOff + i10]))) >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static void mul(int len, int[] x10, int[] y10, int[] zz) {
        zz[len] = mulWord(len, x10[0], y10, zz);
        for (int i10 = 1; i10 < len; i10++) {
            zz[i10 + len] = mulWordAddTo(len, x10[i10], y10, 0, zz, i10);
        }
    }

    public static void mul(int len, int[] x10, int xOff, int[] y10, int yOff, int[] zz, int zzOff) {
        zz[zzOff + len] = mulWord(len, x10[xOff], y10, yOff, zz, zzOff);
        for (int i10 = 1; i10 < len; i10++) {
            zz[zzOff + i10 + len] = mulWordAddTo(len, x10[xOff + i10], y10, yOff, zz, zzOff + i10);
        }
    }

    public static void mul(int[] x10, int xOff, int xLen, int[] y10, int yOff, int yLen, int[] zz, int zzOff) {
        zz[zzOff + yLen] = mulWord(yLen, x10[xOff], y10, yOff, zz, zzOff);
        for (int i10 = 1; i10 < xLen; i10++) {
            zz[zzOff + i10 + yLen] = mulWordAddTo(yLen, x10[xOff + i10], y10, yOff, zz, zzOff + i10);
        }
    }

    public static int mulAddTo(int len, int[] x10, int[] y10, int[] zz) {
        long zc2 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long zc3 = zc2 + (mulWordAddTo(len, x10[i10], y10, 0, zz, i10) & 4294967295L) + (zz[i10 + len] & 4294967295L);
            zz[i10 + len] = (int) zc3;
            zc2 = zc3 >>> 32;
        }
        return (int) zc2;
    }

    public static int mulAddTo(int len, int[] x10, int xOff, int[] y10, int yOff, int[] zz, int zzOff) {
        long zc2 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long zc3 = zc2 + (mulWordAddTo(len, x10[xOff + i10], y10, yOff, zz, zzOff) & 4294967295L) + (zz[zzOff + len] & 4294967295L);
            zz[zzOff + len] = (int) zc3;
            zc2 = zc3 >>> 32;
            zzOff++;
        }
        int i11 = (int) zc2;
        return i11;
    }

    public static int mul31BothAdd(int len, int a10, int[] x10, int b4, int[] y10, int[] z10, int zOff) {
        long c4 = 0;
        long aVal = a10 & 4294967295L;
        long bVal = b4 & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((x10[i10] & 4294967295L) * aVal) + ((y10[i10] & 4294967295L) * bVal) + (z10[zOff + i10] & 4294967295L);
            z10[zOff + i10] = (int) c10;
            c4 = c10 >>> 32;
            i10++;
        } while (i10 < len);
        return (int) c4;
    }

    public static int mulWord(int len, int x10, int[] y10, int[] z10) {
        long c4 = 0;
        long xVal = x10 & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((y10[i10] & 4294967295L) * xVal);
            z10[i10] = (int) c10;
            c4 = c10 >>> 32;
            i10++;
        } while (i10 < len);
        return (int) c4;
    }

    public static int mulWord(int len, int x10, int[] y10, int yOff, int[] z10, int zOff) {
        long c4 = 0;
        long xVal = x10 & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((y10[yOff + i10] & 4294967295L) * xVal);
            z10[zOff + i10] = (int) c10;
            c4 = c10 >>> 32;
            i10++;
        } while (i10 < len);
        return (int) c4;
    }

    public static int mulWordAddTo(int len, int x10, int[] y10, int yOff, int[] z10, int zOff) {
        long c4 = 0;
        long xVal = x10 & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((y10[yOff + i10] & 4294967295L) * xVal) + (z10[zOff + i10] & 4294967295L);
            z10[zOff + i10] = (int) c10;
            c4 = c10 >>> 32;
            i10++;
        } while (i10 < len);
        return (int) c4;
    }

    public static int mulWordDwordAddAt(int len, int x10, long y10, int[] z10, int zPos) {
        long xVal = x10 & 4294967295L;
        long c4 = 0 + ((y10 & 4294967295L) * xVal) + (z10[zPos + 0] & 4294967295L);
        z10[zPos + 0] = (int) c4;
        long c10 = (c4 >>> 32) + ((y10 >>> 32) * xVal) + (z10[zPos + 1] & 4294967295L);
        z10[zPos + 1] = (int) c10;
        long c11 = (c10 >>> 32) + (4294967295L & z10[zPos + 2]);
        z10[zPos + 2] = (int) c11;
        if ((c11 >>> 32) == 0) {
            return 0;
        }
        return incAt(len, z10, zPos + 3);
    }

    public static int shiftDownBit(int len, int[] z10, int c4) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = z10[i10];
                z10[i10] = (next >>> 1) | (c4 << 31);
                c4 = next;
            } else {
                return c4 << 31;
            }
        }
    }

    public static int shiftDownBit(int len, int[] z10, int zOff, int c4) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = z10[zOff + i10];
                z10[zOff + i10] = (next >>> 1) | (c4 << 31);
                c4 = next;
            } else {
                return c4 << 31;
            }
        }
    }

    public static int shiftDownBit(int len, int[] x10, int c4, int[] z10) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = x10[i10];
                z10[i10] = (next >>> 1) | (c4 << 31);
                c4 = next;
            } else {
                return c4 << 31;
            }
        }
    }

    public static int shiftDownBit(int len, int[] x10, int xOff, int c4, int[] z10, int zOff) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = x10[xOff + i10];
                z10[zOff + i10] = (next >>> 1) | (c4 << 31);
                c4 = next;
            } else {
                return c4 << 31;
            }
        }
    }

    public static int shiftDownBits(int len, int[] z10, int bits, int c4) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = z10[i10];
                z10[i10] = (next >>> bits) | (c4 << (-bits));
                c4 = next;
            } else {
                return c4 << (-bits);
            }
        }
    }

    public static int shiftDownBits(int len, int[] z10, int zOff, int bits, int c4) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = z10[zOff + i10];
                z10[zOff + i10] = (next >>> bits) | (c4 << (-bits));
                c4 = next;
            } else {
                return c4 << (-bits);
            }
        }
    }

    public static int shiftDownBits(int len, int[] x10, int bits, int c4, int[] z10) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = x10[i10];
                z10[i10] = (next >>> bits) | (c4 << (-bits));
                c4 = next;
            } else {
                return c4 << (-bits);
            }
        }
    }

    public static int shiftDownBits(int len, int[] x10, int xOff, int bits, int c4, int[] z10, int zOff) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = x10[xOff + i10];
                z10[zOff + i10] = (next >>> bits) | (c4 << (-bits));
                c4 = next;
            } else {
                return c4 << (-bits);
            }
        }
    }

    public static int shiftDownWord(int len, int[] z10, int c4) {
        int i10 = len;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int next = z10[i10];
                z10[i10] = c4;
                c4 = next;
            } else {
                return c4;
            }
        }
    }

    public static int shiftUpBit(int len, int[] z10, int c4) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = z10[i10];
            z10[i10] = (next << 1) | (c4 >>> 31);
            c4 = next;
        }
        int i11 = c4 >>> 31;
        return i11;
    }

    public static int shiftUpBit(int len, int[] z10, int zOff, int c4) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = z10[zOff + i10];
            z10[zOff + i10] = (next << 1) | (c4 >>> 31);
            c4 = next;
        }
        int i11 = c4 >>> 31;
        return i11;
    }

    public static int shiftUpBit(int len, int[] x10, int c4, int[] z10) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = x10[i10];
            z10[i10] = (next << 1) | (c4 >>> 31);
            c4 = next;
        }
        int i11 = c4 >>> 31;
        return i11;
    }

    public static int shiftUpBit(int len, int[] x10, int xOff, int c4, int[] z10, int zOff) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = x10[xOff + i10];
            z10[zOff + i10] = (next << 1) | (c4 >>> 31);
            c4 = next;
        }
        int i11 = c4 >>> 31;
        return i11;
    }

    public static long shiftUpBit64(int len, long[] x10, int xOff, long c4, long[] z10, int zOff) {
        for (int i10 = 0; i10 < len; i10++) {
            long next = x10[xOff + i10];
            z10[zOff + i10] = (next << 1) | (c4 >>> 63);
            c4 = next;
        }
        return c4 >>> 63;
    }

    public static int shiftUpBits(int len, int[] z10, int bits, int c4) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = z10[i10];
            z10[i10] = (next << bits) | (c4 >>> (-bits));
            c4 = next;
        }
        int i11 = -bits;
        return c4 >>> i11;
    }

    public static int shiftUpBits(int len, int[] z10, int zOff, int bits, int c4) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = z10[zOff + i10];
            z10[zOff + i10] = (next << bits) | (c4 >>> (-bits));
            c4 = next;
        }
        int i11 = -bits;
        return c4 >>> i11;
    }

    public static long shiftUpBits64(int len, long[] z10, int zOff, int bits, long c4) {
        for (int i10 = 0; i10 < len; i10++) {
            long next = z10[zOff + i10];
            z10[zOff + i10] = (next << bits) | (c4 >>> (-bits));
            c4 = next;
        }
        int i11 = -bits;
        return c4 >>> i11;
    }

    public static int shiftUpBits(int len, int[] x10, int bits, int c4, int[] z10) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = x10[i10];
            z10[i10] = (next << bits) | (c4 >>> (-bits));
            c4 = next;
        }
        int i11 = -bits;
        return c4 >>> i11;
    }

    public static int shiftUpBits(int len, int[] x10, int xOff, int bits, int c4, int[] z10, int zOff) {
        for (int i10 = 0; i10 < len; i10++) {
            int next = x10[xOff + i10];
            z10[zOff + i10] = (next << bits) | (c4 >>> (-bits));
            c4 = next;
        }
        int i11 = -bits;
        return c4 >>> i11;
    }

    public static long shiftUpBits64(int len, long[] x10, int xOff, int bits, long c4, long[] z10, int zOff) {
        for (int i10 = 0; i10 < len; i10++) {
            long next = x10[xOff + i10];
            z10[zOff + i10] = (next << bits) | (c4 >>> (-bits));
            c4 = next;
        }
        int i11 = -bits;
        return c4 >>> i11;
    }

    public static void square(int len, int[] x10, int[] zz) {
        int extLen = len << 1;
        int c4 = 0;
        int j10 = len;
        int k10 = extLen;
        do {
            j10--;
            long xVal = x10[j10] & 4294967295L;
            long p10 = xVal * xVal;
            int k11 = k10 - 1;
            zz[k11] = (c4 << 31) | ((int) (p10 >>> 33));
            k10 = k11 - 1;
            zz[k10] = (int) (p10 >>> 1);
            c4 = (int) p10;
        } while (j10 > 0);
        long d10 = 0;
        int zzPos = 2;
        int i10 = 1;
        while (i10 < len) {
            long d11 = d10 + (squareWordAddTo(x10, i10, zz) & 4294967295L) + (zz[zzPos] & 4294967295L);
            int zzPos2 = zzPos + 1;
            zz[zzPos] = (int) d11;
            long d12 = (d11 >>> 32) + (zz[zzPos2] & 4294967295L);
            zz[zzPos2] = (int) d12;
            d10 = d12 >>> 32;
            i10++;
            zzPos = zzPos2 + 1;
        }
        shiftUpBit(extLen, zz, x10[0] << 31);
    }

    public static void square(int len, int[] x10, int xOff, int[] zz, int zzOff) {
        int extLen = len << 1;
        int c4 = 0;
        int j10 = len;
        int k10 = extLen;
        while (true) {
            j10--;
            long xVal = x10[xOff + j10] & 4294967295L;
            long p10 = xVal * xVal;
            int k11 = k10 - 1;
            zz[zzOff + k11] = (c4 << 31) | ((int) (p10 >>> 33));
            int k12 = k11 - 1;
            zz[zzOff + k12] = (int) (p10 >>> 1);
            c4 = (int) p10;
            if (j10 <= 0) {
                break;
            } else {
                k10 = k12;
            }
        }
        long d10 = 0;
        int zzPos = zzOff + 2;
        int i10 = 1;
        while (i10 < len) {
            long d11 = d10 + (squareWordAddTo(x10, xOff, i10, zz, zzOff) & 4294967295L) + (zz[zzPos] & 4294967295L);
            int zzPos2 = zzPos + 1;
            zz[zzPos] = (int) d11;
            long d12 = (d11 >>> 32) + (zz[zzPos2] & 4294967295L);
            zz[zzPos2] = (int) d12;
            d10 = d12 >>> 32;
            i10++;
            zzPos = zzPos2 + 1;
        }
        int i11 = x10[xOff];
        shiftUpBit(extLen, zz, zzOff, i11 << 31);
    }

    public static int squareWordAdd(int[] x10, int xPos, int[] z10) {
        long c4 = 0;
        long xVal = x10[xPos] & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((x10[i10] & 4294967295L) * xVal) + (z10[xPos + i10] & 4294967295L);
            z10[xPos + i10] = (int) c10;
            c4 = c10 >>> 32;
            i10++;
        } while (i10 < xPos);
        return (int) c4;
    }

    public static int squareWordAdd(int[] x10, int xOff, int xPos, int[] z10, int zOff) {
        long c4 = 0;
        long xVal = x10[xOff + xPos] & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((x10[xOff + i10] & 4294967295L) * xVal) + (z10[xPos + zOff] & 4294967295L);
            z10[xPos + zOff] = (int) c10;
            c4 = c10 >>> 32;
            zOff++;
            i10++;
        } while (i10 < xPos);
        return (int) c4;
    }

    public static int squareWordAddTo(int[] x10, int xPos, int[] z10) {
        long c4 = 0;
        long xVal = x10[xPos] & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((x10[i10] & 4294967295L) * xVal) + (z10[xPos + i10] & 4294967295L);
            z10[xPos + i10] = (int) c10;
            c4 = c10 >>> 32;
            i10++;
        } while (i10 < xPos);
        return (int) c4;
    }

    public static int squareWordAddTo(int[] x10, int xOff, int xPos, int[] z10, int zOff) {
        long c4 = 0;
        long xVal = x10[xOff + xPos] & 4294967295L;
        int i10 = 0;
        do {
            long c10 = c4 + ((x10[xOff + i10] & 4294967295L) * xVal) + (z10[xPos + zOff] & 4294967295L);
            z10[xPos + zOff] = (int) c10;
            c4 = c10 >>> 32;
            zOff++;
            i10++;
        } while (i10 < xPos);
        return (int) c4;
    }

    public static int sub(int len, int[] x10, int[] y10, int[] z10) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + ((x10[i10] & 4294967295L) - (4294967295L & y10[i10]));
            z10[i10] = (int) c10;
            c4 = c10 >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int sub(int len, int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + ((x10[xOff + i10] & 4294967295L) - (4294967295L & y10[yOff + i10]));
            z10[zOff + i10] = (int) c10;
            c4 = c10 >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int sub33At(int len, int x10, int[] z10, int zPos) {
        long c4 = (z10[zPos + 0] & 4294967295L) - (x10 & 4294967295L);
        z10[zPos + 0] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[zPos + 1]) - 1);
        z10[zPos + 1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zPos + 2);
    }

    public static int sub33At(int len, int x10, int[] z10, int zOff, int zPos) {
        long c4 = (z10[zOff + zPos] & 4294967295L) - (x10 & 4294967295L);
        z10[zOff + zPos] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[(zOff + zPos) + 1]) - 1);
        z10[zOff + zPos + 1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zOff, zPos + 2);
    }

    public static int sub33From(int len, int x10, int[] z10) {
        long c4 = (z10[0] & 4294967295L) - (x10 & 4294967295L);
        z10[0] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[1]) - 1);
        z10[1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, 2);
    }

    public static int sub33From(int len, int x10, int[] z10, int zOff) {
        long c4 = (z10[zOff + 0] & 4294967295L) - (x10 & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[zOff + 1]) - 1);
        z10[zOff + 1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zOff, 2);
    }

    public static int subBothFrom(int len, int[] x10, int[] y10, int[] z10) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (((z10[i10] & 4294967295L) - (x10[i10] & 4294967295L)) - (4294967295L & y10[i10]));
            z10[i10] = (int) c10;
            c4 = c10 >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int subBothFrom(int len, int[] x10, int xOff, int[] y10, int yOff, int[] z10, int zOff) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + (((z10[zOff + i10] & 4294967295L) - (x10[xOff + i10] & 4294967295L)) - (4294967295L & y10[yOff + i10]));
            z10[zOff + i10] = (int) c10;
            c4 = c10 >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int subDWordAt(int len, long x10, int[] z10, int zPos) {
        long c4 = (z10[zPos + 0] & 4294967295L) - (x10 & 4294967295L);
        z10[zPos + 0] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[zPos + 1]) - (x10 >>> 32));
        z10[zPos + 1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zPos + 2);
    }

    public static int subDWordAt(int len, long x10, int[] z10, int zOff, int zPos) {
        long c4 = (z10[zOff + zPos] & 4294967295L) - (x10 & 4294967295L);
        z10[zOff + zPos] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[(zOff + zPos) + 1]) - (x10 >>> 32));
        z10[zOff + zPos + 1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zOff, zPos + 2);
    }

    public static int subDWordFrom(int len, long x10, int[] z10) {
        long c4 = (z10[0] & 4294967295L) - (x10 & 4294967295L);
        z10[0] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[1]) - (x10 >>> 32));
        z10[1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, 2);
    }

    public static int subDWordFrom(int len, long x10, int[] z10, int zOff) {
        long c4 = (z10[zOff + 0] & 4294967295L) - (x10 & 4294967295L);
        z10[zOff + 0] = (int) c4;
        long c10 = (c4 >> 32) + ((4294967295L & z10[zOff + 1]) - (x10 >>> 32));
        z10[zOff + 1] = (int) c10;
        if ((c10 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zOff, 2);
    }

    public static int subFrom(int len, int[] x10, int[] z10) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + ((z10[i10] & 4294967295L) - (4294967295L & x10[i10]));
            z10[i10] = (int) c10;
            c4 = c10 >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int subFrom(int len, int[] x10, int xOff, int[] z10, int zOff) {
        long c4 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            long c10 = c4 + ((z10[zOff + i10] & 4294967295L) - (4294967295L & x10[xOff + i10]));
            z10[zOff + i10] = (int) c10;
            c4 = c10 >> 32;
        }
        int i11 = (int) c4;
        return i11;
    }

    public static int subWordAt(int len, int x10, int[] z10, int zPos) {
        long c4 = (z10[zPos] & 4294967295L) - (4294967295L & x10);
        z10[zPos] = (int) c4;
        if ((c4 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zPos + 1);
    }

    public static int subWordAt(int len, int x10, int[] z10, int zOff, int zPos) {
        long c4 = (z10[zOff + zPos] & 4294967295L) - (4294967295L & x10);
        z10[zOff + zPos] = (int) c4;
        if ((c4 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zOff, zPos + 1);
    }

    public static int subWordFrom(int len, int x10, int[] z10) {
        long c4 = (z10[0] & 4294967295L) - (4294967295L & x10);
        z10[0] = (int) c4;
        if ((c4 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, 1);
    }

    public static int subWordFrom(int len, int x10, int[] z10, int zOff) {
        long c4 = (z10[zOff + 0] & 4294967295L) - (4294967295L & x10);
        z10[zOff + 0] = (int) c4;
        if ((c4 >> 32) == 0) {
            return 0;
        }
        return decAt(len, z10, zOff, 1);
    }

    public static BigInteger toBigInteger(int len, int[] x10) {
        byte[] bs = new byte[len << 2];
        for (int i10 = 0; i10 < len; i10++) {
            int x_i = x10[i10];
            if (x_i != 0) {
                Pack.intToBigEndian(x_i, bs, ((len - 1) - i10) << 2);
            }
        }
        return new BigInteger(1, bs);
    }

    public static void zero(int len, int[] z10) {
        for (int i10 = 0; i10 < len; i10++) {
            z10[i10] = 0;
        }
    }

    public static void zero(int len, int[] z10, int zOff) {
        for (int i10 = 0; i10 < len; i10++) {
            z10[zOff + i10] = 0;
        }
    }

    public static void zero64(int len, long[] z10) {
        for (int i10 = 0; i10 < len; i10++) {
            z10[i10] = 0;
        }
    }
}
