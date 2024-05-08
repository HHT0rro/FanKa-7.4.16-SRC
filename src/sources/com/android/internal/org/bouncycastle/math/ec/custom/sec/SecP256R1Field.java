package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.raw.Mod;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat256;
import com.android.internal.org.bouncycastle.util.Pack;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP256R1Field {
    private static final long M = 4294967295L;
    private static final int P7 = -1;
    private static final int PExt15s1 = Integer.MAX_VALUE;
    static final int[] P = {-1, -1, -1, 0, 0, 0, 1, -1};
    private static final int[] PExt = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    public static void add(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat256.add(x10, y10, z10);
        if (c4 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void addExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.add(16, xx, yy, zz);
        if (c4 != 0 || ((zz[15] >>> 1) >= Integer.MAX_VALUE && Nat.gte(16, zz, PExt))) {
            Nat.subFrom(16, PExt, zz);
        }
    }

    public static void addOne(int[] x10, int[] z10) {
        int c4 = Nat.inc(8, x10, z10);
        if (c4 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static int[] fromBigInteger(BigInteger x10) {
        int[] z10 = Nat256.fromBigInteger(x10);
        if (z10[7] == -1) {
            int[] iArr = P;
            if (Nat256.gte(z10, iArr)) {
                Nat256.subFrom(iArr, z10);
            }
        }
        return z10;
    }

    public static void half(int[] x10, int[] z10) {
        if ((x10[0] & 1) == 0) {
            Nat.shiftDownBit(8, x10, 0, z10);
        } else {
            int c4 = Nat256.add(x10, P, z10);
            Nat.shiftDownBit(8, z10, c4);
        }
    }

    public static void inv(int[] x10, int[] z10) {
        Mod.checkedModOddInverse(P, x10, z10);
    }

    public static int isZero(int[] x10) {
        int d10 = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            d10 |= x10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] x10, int[] y10, int[] z10) {
        int[] tt = Nat256.createExt();
        Nat256.mul(x10, y10, tt);
        reduce(tt, z10);
    }

    public static void multiplyAddToExt(int[] x10, int[] y10, int[] zz) {
        int c4 = Nat256.mulAddTo(x10, y10, zz);
        if (c4 != 0 || ((zz[15] >>> 1) >= Integer.MAX_VALUE && Nat.gte(16, zz, PExt))) {
            Nat.subFrom(16, PExt, zz);
        }
    }

    public static void negate(int[] x10, int[] z10) {
        if (isZero(x10) != 0) {
            int[] iArr = P;
            Nat256.sub(iArr, iArr, z10);
        } else {
            Nat256.sub(P, x10, z10);
        }
    }

    public static void random(SecureRandom r10, int[] z10) {
        byte[] bb2 = new byte[32];
        do {
            r10.nextBytes(bb2);
            Pack.littleEndianToInt(bb2, 0, z10, 0, 8);
        } while (Nat.lessThan(8, z10, P) == 0);
    }

    public static void randomMult(SecureRandom r10, int[] z10) {
        do {
            random(r10, z10);
        } while (isZero(z10) != 0);
    }

    public static void reduce(int[] xx, int[] z10) {
        long xx09 = xx[9] & 4294967295L;
        long xx10 = xx[10] & 4294967295L;
        long xx11 = xx[11] & 4294967295L;
        long xx12 = xx[12] & 4294967295L;
        long xx13 = xx[13] & 4294967295L;
        long xx14 = xx[14] & 4294967295L;
        long xx15 = xx[15] & 4294967295L;
        long xx08 = (xx[8] & 4294967295L) - 6;
        long t02 = xx08 + xx09;
        long t12 = xx09 + xx10;
        long t2 = (xx10 + xx11) - xx15;
        long t32 = xx11 + xx12;
        long t42 = xx12 + xx13;
        long t52 = xx13 + xx14;
        long t62 = xx14 + xx15;
        long t72 = t52 - t02;
        long cc2 = 0 + (((xx[0] & 4294967295L) - t32) - t72);
        z10[0] = (int) cc2;
        long cc3 = (cc2 >> 32) + ((((xx[1] & 4294967295L) + t12) - t42) - t62);
        z10[1] = (int) cc3;
        long cc4 = (cc3 >> 32) + (((xx[2] & 4294967295L) + t2) - t52);
        z10[2] = (int) cc4;
        long cc5 = (cc4 >> 32) + ((((xx[3] & 4294967295L) + (t32 << 1)) + t72) - t62);
        z10[3] = (int) cc5;
        long cc6 = (cc5 >> 32) + ((((xx[4] & 4294967295L) + (t42 << 1)) + xx14) - t12);
        z10[4] = (int) cc6;
        long cc7 = (cc6 >> 32) + (((xx[5] & 4294967295L) + (t52 << 1)) - t2);
        z10[5] = (int) cc7;
        long cc8 = (cc7 >> 32) + (xx[6] & 4294967295L) + (t62 << 1) + t72;
        z10[6] = (int) cc8;
        long cc9 = (cc8 >> 32) + (((((xx[7] & 4294967295L) + (xx15 << 1)) + xx08) - t2) - t42);
        z10[7] = (int) cc9;
        reduce32((int) ((cc9 >> 32) + 6), z10);
    }

    public static void reduce32(int x10, int[] z10) {
        long cc2 = 0;
        if (x10 != 0) {
            long xx08 = x10 & 4294967295L;
            long cc3 = 0 + (z10[0] & 4294967295L) + xx08;
            z10[0] = (int) cc3;
            long cc4 = cc3 >> 32;
            if (cc4 != 0) {
                long cc5 = cc4 + (z10[1] & 4294967295L);
                z10[1] = (int) cc5;
                long cc6 = (cc5 >> 32) + (z10[2] & 4294967295L);
                z10[2] = (int) cc6;
                cc4 = cc6 >> 32;
            }
            long cc7 = cc4 + ((z10[3] & 4294967295L) - xx08);
            z10[3] = (int) cc7;
            long cc8 = cc7 >> 32;
            if (cc8 != 0) {
                long cc9 = cc8 + (z10[4] & 4294967295L);
                z10[4] = (int) cc9;
                long cc10 = (cc9 >> 32) + (z10[5] & 4294967295L);
                z10[5] = (int) cc10;
                cc8 = cc10 >> 32;
            }
            long cc11 = cc8 + ((z10[6] & 4294967295L) - xx08);
            z10[6] = (int) cc11;
            long cc12 = (cc11 >> 32) + (4294967295L & z10[7]) + xx08;
            z10[7] = (int) cc12;
            cc2 = cc12 >> 32;
        }
        if (cc2 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void square(int[] x10, int[] z10) {
        int[] tt = Nat256.createExt();
        Nat256.square(x10, tt);
        reduce(tt, z10);
    }

    public static void squareN(int[] x10, int n10, int[] z10) {
        int[] tt = Nat256.createExt();
        Nat256.square(x10, tt);
        reduce(tt, z10);
        while (true) {
            n10--;
            if (n10 > 0) {
                Nat256.square(z10, tt);
                reduce(tt, z10);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat256.sub(x10, y10, z10);
        if (c4 != 0) {
            subPInvFrom(z10);
        }
    }

    public static void subtractExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.sub(16, xx, yy, zz);
        if (c4 != 0) {
            Nat.addTo(16, PExt, zz);
        }
    }

    public static void twice(int[] x10, int[] z10) {
        int c4 = Nat.shiftUpBit(8, x10, 0, z10);
        if (c4 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    private static void addPInvTo(int[] z10) {
        long c4 = (z10[0] & 4294967295L) + 1;
        z10[0] = (int) c4;
        long c10 = c4 >> 32;
        if (c10 != 0) {
            long c11 = c10 + (z10[1] & 4294967295L);
            z10[1] = (int) c11;
            long c12 = (c11 >> 32) + (z10[2] & 4294967295L);
            z10[2] = (int) c12;
            c10 = c12 >> 32;
        }
        long c13 = c10 + ((z10[3] & 4294967295L) - 1);
        z10[3] = (int) c13;
        long c14 = c13 >> 32;
        if (c14 != 0) {
            long c15 = c14 + (z10[4] & 4294967295L);
            z10[4] = (int) c15;
            long c16 = (c15 >> 32) + (z10[5] & 4294967295L);
            z10[5] = (int) c16;
            c14 = c16 >> 32;
        }
        long c17 = c14 + ((z10[6] & 4294967295L) - 1);
        z10[6] = (int) c17;
        z10[7] = (int) ((c17 >> 32) + (4294967295L & z10[7]) + 1);
    }

    private static void subPInvFrom(int[] z10) {
        long c4 = (z10[0] & 4294967295L) - 1;
        z10[0] = (int) c4;
        long c10 = c4 >> 32;
        if (c10 != 0) {
            long c11 = c10 + (z10[1] & 4294967295L);
            z10[1] = (int) c11;
            long c12 = (c11 >> 32) + (z10[2] & 4294967295L);
            z10[2] = (int) c12;
            c10 = c12 >> 32;
        }
        long c13 = c10 + (z10[3] & 4294967295L) + 1;
        z10[3] = (int) c13;
        long c14 = c13 >> 32;
        if (c14 != 0) {
            long c15 = c14 + (z10[4] & 4294967295L);
            z10[4] = (int) c15;
            long c16 = (c15 >> 32) + (z10[5] & 4294967295L);
            z10[5] = (int) c16;
            c14 = c16 >> 32;
        }
        long c17 = c14 + (z10[6] & 4294967295L) + 1;
        z10[6] = (int) c17;
        z10[7] = (int) ((c17 >> 32) + ((4294967295L & z10[7]) - 1));
    }
}
