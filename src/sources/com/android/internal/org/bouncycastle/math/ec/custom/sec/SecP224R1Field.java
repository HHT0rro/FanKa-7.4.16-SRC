package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.raw.Mod;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat224;
import com.android.internal.org.bouncycastle.util.Pack;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP224R1Field {
    private static final long M = 4294967295L;
    private static final int P6 = -1;
    private static final int PExt13 = -1;
    static final int[] P = {1, 0, 0, -1, -1, -1, -1};
    private static final int[] PExt = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
    private static final int[] PExtInv = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void add(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat224.add(x10, y10, z10);
        if (c4 != 0 || (z10[6] == -1 && Nat224.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void addExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.add(14, xx, yy, zz);
        if (c4 != 0 || (zz[13] == -1 && Nat.gte(14, zz, PExt))) {
            int[] iArr = PExtInv;
            if (Nat.addTo(iArr.length, iArr, zz) != 0) {
                Nat.incAt(14, zz, iArr.length);
            }
        }
    }

    public static void addOne(int[] x10, int[] z10) {
        int c4 = Nat.inc(7, x10, z10);
        if (c4 != 0 || (z10[6] == -1 && Nat224.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static int[] fromBigInteger(BigInteger x10) {
        int[] z10 = Nat224.fromBigInteger(x10);
        if (z10[6] == -1) {
            int[] iArr = P;
            if (Nat224.gte(z10, iArr)) {
                Nat224.subFrom(iArr, z10);
            }
        }
        return z10;
    }

    public static void half(int[] x10, int[] z10) {
        if ((x10[0] & 1) == 0) {
            Nat.shiftDownBit(7, x10, 0, z10);
        } else {
            int c4 = Nat224.add(x10, P, z10);
            Nat.shiftDownBit(7, z10, c4);
        }
    }

    public static void inv(int[] x10, int[] z10) {
        Mod.checkedModOddInverse(P, x10, z10);
    }

    public static int isZero(int[] x10) {
        int d10 = 0;
        for (int i10 = 0; i10 < 7; i10++) {
            d10 |= x10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] x10, int[] y10, int[] z10) {
        int[] tt = Nat224.createExt();
        Nat224.mul(x10, y10, tt);
        reduce(tt, z10);
    }

    public static void multiplyAddToExt(int[] x10, int[] y10, int[] zz) {
        int c4 = Nat224.mulAddTo(x10, y10, zz);
        if (c4 != 0 || (zz[13] == -1 && Nat.gte(14, zz, PExt))) {
            int[] iArr = PExtInv;
            if (Nat.addTo(iArr.length, iArr, zz) != 0) {
                Nat.incAt(14, zz, iArr.length);
            }
        }
    }

    public static void negate(int[] x10, int[] z10) {
        if (isZero(x10) != 0) {
            int[] iArr = P;
            Nat224.sub(iArr, iArr, z10);
        } else {
            Nat224.sub(P, x10, z10);
        }
    }

    public static void random(SecureRandom r10, int[] z10) {
        byte[] bb2 = new byte[28];
        do {
            r10.nextBytes(bb2);
            Pack.littleEndianToInt(bb2, 0, z10, 0, 7);
        } while (Nat.lessThan(7, z10, P) == 0);
    }

    public static void randomMult(SecureRandom r10, int[] z10) {
        do {
            random(r10, z10);
        } while (isZero(z10) != 0);
    }

    public static void reduce(int[] xx, int[] z10) {
        long xx10 = xx[10] & 4294967295L;
        long xx11 = xx[11] & 4294967295L;
        long xx12 = xx[12] & 4294967295L;
        long xx13 = xx[13] & 4294967295L;
        long t02 = ((xx[7] & 4294967295L) + xx11) - 1;
        long n10 = xx[8];
        long t12 = (n10 & 4294967295L) + xx12;
        long t2 = (xx[9] & 4294967295L) + xx13;
        long cc2 = 0 + ((xx[0] & 4294967295L) - t02);
        long z02 = cc2 & 4294967295L;
        long z03 = xx[1];
        long cc3 = (cc2 >> 32) + ((z03 & 4294967295L) - t12);
        z10[1] = (int) cc3;
        long cc4 = (cc3 >> 32) + ((xx[2] & 4294967295L) - t2);
        z10[2] = (int) cc4;
        long cc5 = (cc4 >> 32) + (((xx[3] & 4294967295L) + t02) - xx10);
        long z32 = cc5 & 4294967295L;
        long cc6 = (cc5 >> 32) + (((xx[4] & 4294967295L) + t12) - xx11);
        z10[4] = (int) cc6;
        long cc7 = (cc6 >> 32) + (((xx[5] & 4294967295L) + t2) - xx12);
        z10[5] = (int) cc7;
        long cc8 = (cc7 >> 32) + (((xx[6] & 4294967295L) + xx10) - xx13);
        z10[6] = (int) cc8;
        long cc9 = (cc8 >> 32) + 1;
        long z33 = z32 + cc9;
        long z04 = z02 - cc9;
        z10[0] = (int) z04;
        long cc10 = z04 >> 32;
        if (cc10 != 0) {
            long cc11 = cc10 + (z10[1] & 4294967295L);
            z10[1] = (int) cc11;
            long cc12 = (cc11 >> 32) + (4294967295L & z10[2]);
            z10[2] = (int) cc12;
            z33 += cc12 >> 32;
        }
        z10[3] = (int) z33;
        if (((z33 >> 32) != 0 && Nat.incAt(7, z10, 4) != 0) || (z10[6] == -1 && Nat224.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void reduce32(int x10, int[] z10) {
        long cc2 = 0;
        if (x10 != 0) {
            long xx07 = x10 & 4294967295L;
            long cc3 = 0 + ((z10[0] & 4294967295L) - xx07);
            z10[0] = (int) cc3;
            long cc4 = cc3 >> 32;
            if (cc4 != 0) {
                long cc5 = cc4 + (z10[1] & 4294967295L);
                z10[1] = (int) cc5;
                long cc6 = (cc5 >> 32) + (z10[2] & 4294967295L);
                z10[2] = (int) cc6;
                cc4 = cc6 >> 32;
            }
            long cc7 = cc4 + (4294967295L & z10[3]) + xx07;
            z10[3] = (int) cc7;
            cc2 = cc7 >> 32;
        }
        if ((cc2 != 0 && Nat.incAt(7, z10, 4) != 0) || (z10[6] == -1 && Nat224.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void square(int[] x10, int[] z10) {
        int[] tt = Nat224.createExt();
        Nat224.square(x10, tt);
        reduce(tt, z10);
    }

    public static void squareN(int[] x10, int n10, int[] z10) {
        int[] tt = Nat224.createExt();
        Nat224.square(x10, tt);
        reduce(tt, z10);
        while (true) {
            n10--;
            if (n10 > 0) {
                Nat224.square(z10, tt);
                reduce(tt, z10);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat224.sub(x10, y10, z10);
        if (c4 != 0) {
            subPInvFrom(z10);
        }
    }

    public static void subtractExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.sub(14, xx, yy, zz);
        if (c4 != 0) {
            int[] iArr = PExtInv;
            if (Nat.subFrom(iArr.length, iArr, zz) != 0) {
                Nat.decAt(14, zz, iArr.length);
            }
        }
    }

    public static void twice(int[] x10, int[] z10) {
        int c4 = Nat.shiftUpBit(7, x10, 0, z10);
        if (c4 != 0 || (z10[6] == -1 && Nat224.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    private static void addPInvTo(int[] z10) {
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
        long c13 = c10 + (4294967295L & z10[3]) + 1;
        z10[3] = (int) c13;
        if ((c13 >> 32) != 0) {
            Nat.incAt(7, z10, 4);
        }
    }

    private static void subPInvFrom(int[] z10) {
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
        long c13 = c10 + ((4294967295L & z10[3]) - 1);
        z10[3] = (int) c13;
        if ((c13 >> 32) != 0) {
            Nat.decAt(7, z10, 4);
        }
    }
}
