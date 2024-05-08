package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.raw.Mod;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat192;
import com.android.internal.org.bouncycastle.util.Pack;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP192R1Field {
    private static final long M = 4294967295L;
    private static final int P5 = -1;
    private static final int PExt11 = -1;
    static final int[] P = {-1, -1, -2, -1, -1, -1};
    private static final int[] PExt = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
    private static final int[] PExtInv = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void add(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat192.add(x10, y10, z10);
        if (c4 != 0 || (z10[5] == -1 && Nat192.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void addExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.add(12, xx, yy, zz);
        if (c4 != 0 || (zz[11] == -1 && Nat.gte(12, zz, PExt))) {
            int[] iArr = PExtInv;
            if (Nat.addTo(iArr.length, iArr, zz) != 0) {
                Nat.incAt(12, zz, iArr.length);
            }
        }
    }

    public static void addOne(int[] x10, int[] z10) {
        int c4 = Nat.inc(6, x10, z10);
        if (c4 != 0 || (z10[5] == -1 && Nat192.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static int[] fromBigInteger(BigInteger x10) {
        int[] z10 = Nat192.fromBigInteger(x10);
        if (z10[5] == -1) {
            int[] iArr = P;
            if (Nat192.gte(z10, iArr)) {
                Nat192.subFrom(iArr, z10);
            }
        }
        return z10;
    }

    public static void half(int[] x10, int[] z10) {
        if ((x10[0] & 1) == 0) {
            Nat.shiftDownBit(6, x10, 0, z10);
        } else {
            int c4 = Nat192.add(x10, P, z10);
            Nat.shiftDownBit(6, z10, c4);
        }
    }

    public static void inv(int[] x10, int[] z10) {
        Mod.checkedModOddInverse(P, x10, z10);
    }

    public static int isZero(int[] x10) {
        int d10 = 0;
        for (int i10 = 0; i10 < 6; i10++) {
            d10 |= x10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] x10, int[] y10, int[] z10) {
        int[] tt = Nat192.createExt();
        Nat192.mul(x10, y10, tt);
        reduce(tt, z10);
    }

    public static void multiplyAddToExt(int[] x10, int[] y10, int[] zz) {
        int c4 = Nat192.mulAddTo(x10, y10, zz);
        if (c4 != 0 || (zz[11] == -1 && Nat.gte(12, zz, PExt))) {
            int[] iArr = PExtInv;
            if (Nat.addTo(iArr.length, iArr, zz) != 0) {
                Nat.incAt(12, zz, iArr.length);
            }
        }
    }

    public static void negate(int[] x10, int[] z10) {
        if (isZero(x10) != 0) {
            int[] iArr = P;
            Nat192.sub(iArr, iArr, z10);
        } else {
            Nat192.sub(P, x10, z10);
        }
    }

    public static void random(SecureRandom r10, int[] z10) {
        byte[] bb2 = new byte[24];
        do {
            r10.nextBytes(bb2);
            Pack.littleEndianToInt(bb2, 0, z10, 0, 6);
        } while (Nat.lessThan(6, z10, P) == 0);
    }

    public static void randomMult(SecureRandom r10, int[] z10) {
        do {
            random(r10, z10);
        } while (isZero(z10) != 0);
    }

    public static void reduce(int[] xx, int[] z10) {
        long xx06 = xx[6] & 4294967295L;
        long xx07 = xx[7] & 4294967295L;
        long xx08 = xx[8] & 4294967295L;
        long xx09 = xx[9] & 4294967295L;
        long xx10 = xx[10] & 4294967295L;
        long xx11 = xx[11] & 4294967295L;
        long t02 = xx06 + xx10;
        long t12 = xx07 + xx11;
        long xx102 = xx[0];
        long cc2 = 0 + (xx102 & 4294967295L) + t02;
        int z02 = (int) cc2;
        long cc3 = (cc2 >> 32) + (xx[1] & 4294967295L) + t12;
        z10[1] = (int) cc3;
        long t03 = t02 + xx08;
        long t13 = t12 + xx09;
        long cc4 = (cc3 >> 32) + (xx[2] & 4294967295L) + t03;
        long z22 = cc4 & 4294967295L;
        long cc5 = (cc4 >> 32) + (xx[3] & 4294967295L) + t13;
        z10[3] = (int) cc5;
        long cc6 = (cc5 >> 32) + (xx[4] & 4294967295L) + (t03 - xx06);
        z10[4] = (int) cc6;
        long cc7 = (cc6 >> 32) + (xx[5] & 4294967295L) + (t13 - xx07);
        z10[5] = (int) cc7;
        long cc8 = cc7 >> 32;
        long z23 = z22 + cc8;
        long cc9 = cc8 + (z02 & 4294967295L);
        z10[0] = (int) cc9;
        long cc10 = cc9 >> 32;
        if (cc10 != 0) {
            long cc11 = cc10 + (z10[1] & 4294967295L);
            z10[1] = (int) cc11;
            z23 += cc11 >> 32;
        }
        z10[2] = (int) z23;
        if (((z23 >> 32) != 0 && Nat.incAt(6, z10, 3) != 0) || (z10[5] == -1 && Nat192.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void reduce32(int x10, int[] z10) {
        long cc2 = 0;
        if (x10 != 0) {
            long xx06 = x10 & 4294967295L;
            long cc3 = 0 + (z10[0] & 4294967295L) + xx06;
            z10[0] = (int) cc3;
            long cc4 = cc3 >> 32;
            if (cc4 != 0) {
                long cc5 = cc4 + (z10[1] & 4294967295L);
                z10[1] = (int) cc5;
                cc4 = cc5 >> 32;
            }
            long cc6 = cc4 + (4294967295L & z10[2]) + xx06;
            z10[2] = (int) cc6;
            cc2 = cc6 >> 32;
        }
        if ((cc2 != 0 && Nat.incAt(6, z10, 3) != 0) || (z10[5] == -1 && Nat192.gte(z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void square(int[] x10, int[] z10) {
        int[] tt = Nat192.createExt();
        Nat192.square(x10, tt);
        reduce(tt, z10);
    }

    public static void squareN(int[] x10, int n10, int[] z10) {
        int[] tt = Nat192.createExt();
        Nat192.square(x10, tt);
        reduce(tt, z10);
        while (true) {
            n10--;
            if (n10 > 0) {
                Nat192.square(z10, tt);
                reduce(tt, z10);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat192.sub(x10, y10, z10);
        if (c4 != 0) {
            subPInvFrom(z10);
        }
    }

    public static void subtractExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.sub(12, xx, yy, zz);
        if (c4 != 0) {
            int[] iArr = PExtInv;
            if (Nat.subFrom(iArr.length, iArr, zz) != 0) {
                Nat.decAt(12, zz, iArr.length);
            }
        }
    }

    public static void twice(int[] x10, int[] z10) {
        int c4 = Nat.shiftUpBit(6, x10, 0, z10);
        if (c4 != 0 || (z10[5] == -1 && Nat192.gte(z10, P))) {
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
            c10 = c11 >> 32;
        }
        long c12 = c10 + (4294967295L & z10[2]) + 1;
        z10[2] = (int) c12;
        if ((c12 >> 32) != 0) {
            Nat.incAt(6, z10, 3);
        }
    }

    private static void subPInvFrom(int[] z10) {
        long c4 = (z10[0] & 4294967295L) - 1;
        z10[0] = (int) c4;
        long c10 = c4 >> 32;
        if (c10 != 0) {
            long c11 = c10 + (z10[1] & 4294967295L);
            z10[1] = (int) c11;
            c10 = c11 >> 32;
        }
        long c12 = c10 + ((4294967295L & z10[2]) - 1);
        z10[2] = (int) c12;
        if ((c12 >> 32) != 0) {
            Nat.decAt(6, z10, 3);
        }
    }
}
