package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.raw.Mod;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat384;
import com.android.internal.org.bouncycastle.util.Pack;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP384R1Field {
    private static final long M = 4294967295L;
    private static final int P11 = -1;
    private static final int PExt23 = -1;
    static final int[] P = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] PExt = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] PExtInv = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void add(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat.add(12, x10, y10, z10);
        if (c4 != 0 || (z10[11] == -1 && Nat.gte(12, z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void addExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.add(24, xx, yy, zz);
        if (c4 != 0 || (zz[23] == -1 && Nat.gte(24, zz, PExt))) {
            int[] iArr = PExtInv;
            if (Nat.addTo(iArr.length, iArr, zz) != 0) {
                Nat.incAt(24, zz, iArr.length);
            }
        }
    }

    public static void addOne(int[] x10, int[] z10) {
        int c4 = Nat.inc(12, x10, z10);
        if (c4 != 0 || (z10[11] == -1 && Nat.gte(12, z10, P))) {
            addPInvTo(z10);
        }
    }

    public static int[] fromBigInteger(BigInteger x10) {
        int[] z10 = Nat.fromBigInteger(384, x10);
        if (z10[11] == -1) {
            int[] iArr = P;
            if (Nat.gte(12, z10, iArr)) {
                Nat.subFrom(12, iArr, z10);
            }
        }
        return z10;
    }

    public static void half(int[] x10, int[] z10) {
        if ((x10[0] & 1) == 0) {
            Nat.shiftDownBit(12, x10, 0, z10);
        } else {
            int c4 = Nat.add(12, x10, P, z10);
            Nat.shiftDownBit(12, z10, c4);
        }
    }

    public static void inv(int[] x10, int[] z10) {
        Mod.checkedModOddInverse(P, x10, z10);
    }

    public static int isZero(int[] x10) {
        int d10 = 0;
        for (int i10 = 0; i10 < 12; i10++) {
            d10 |= x10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] x10, int[] y10, int[] z10) {
        int[] tt = Nat.create(24);
        Nat384.mul(x10, y10, tt);
        reduce(tt, z10);
    }

    public static void negate(int[] x10, int[] z10) {
        if (isZero(x10) != 0) {
            int[] iArr = P;
            Nat.sub(12, iArr, iArr, z10);
        } else {
            Nat.sub(12, P, x10, z10);
        }
    }

    public static void random(SecureRandom r10, int[] z10) {
        byte[] bb2 = new byte[48];
        do {
            r10.nextBytes(bb2);
            Pack.littleEndianToInt(bb2, 0, z10, 0, 12);
        } while (Nat.lessThan(12, z10, P) == 0);
    }

    public static void randomMult(SecureRandom r10, int[] z10) {
        do {
            random(r10, z10);
        } while (isZero(z10) != 0);
    }

    public static void reduce(int[] xx, int[] z10) {
        long xx16 = xx[16] & 4294967295L;
        long xx17 = xx[17] & 4294967295L;
        long xx18 = xx[18] & 4294967295L;
        long xx19 = xx[19] & 4294967295L;
        long xx20 = xx[20] & 4294967295L;
        long xx21 = xx[21] & 4294967295L;
        long xx22 = xx[22] & 4294967295L;
        long xx23 = xx[23] & 4294967295L;
        long t02 = ((xx[12] & 4294967295L) + xx20) - 1;
        long t12 = (xx[13] & 4294967295L) + xx22;
        long t2 = (xx[14] & 4294967295L) + xx22 + xx23;
        long t32 = (xx[15] & 4294967295L) + xx23;
        long t42 = xx17 + xx21;
        long t52 = xx21 - xx23;
        long t62 = xx22 - xx23;
        long t72 = t02 + t52;
        long cc2 = 0 + (xx[0] & 4294967295L) + t72;
        z10[0] = (int) cc2;
        long cc3 = (cc2 >> 32) + (((xx[1] & 4294967295L) + xx23) - t02) + t12;
        z10[1] = (int) cc3;
        long cc4 = (cc3 >> 32) + (((xx[2] & 4294967295L) - xx21) - t12) + t2;
        z10[2] = (int) cc4;
        long cc5 = (cc4 >> 32) + ((xx[3] & 4294967295L) - t2) + t32 + t72;
        z10[3] = (int) cc5;
        long cc6 = (cc5 >> 32) + (((((xx[4] & 4294967295L) + xx16) + xx21) + t12) - t32) + t72;
        z10[4] = (int) cc6;
        long cc7 = (cc6 >> 32) + ((xx[5] & 4294967295L) - xx16) + t12 + t2 + t42;
        z10[5] = (int) cc7;
        long cc8 = (cc7 >> 32) + (((xx[6] & 4294967295L) + xx18) - xx17) + t2 + t32;
        z10[6] = (int) cc8;
        long cc9 = (cc8 >> 32) + ((((xx[7] & 4294967295L) + xx16) + xx19) - xx18) + t32;
        z10[7] = (int) cc9;
        long cc10 = (cc9 >> 32) + (((((xx[8] & 4294967295L) + xx16) + xx17) + xx20) - xx19);
        z10[8] = (int) cc10;
        long cc11 = (cc10 >> 32) + (((xx[9] & 4294967295L) + xx18) - xx20) + t42;
        z10[9] = (int) cc11;
        long cc12 = (cc11 >> 32) + ((((xx[10] & 4294967295L) + xx18) + xx19) - t52) + t62;
        z10[10] = (int) cc12;
        long cc13 = (cc12 >> 32) + ((((xx[11] & 4294967295L) + xx19) + xx20) - t62);
        z10[11] = (int) cc13;
        reduce32((int) ((cc13 >> 32) + 1), z10);
    }

    public static void reduce32(int x10, int[] z10) {
        long cc2 = 0;
        if (x10 != 0) {
            long xx12 = x10 & 4294967295L;
            long cc3 = 0 + (z10[0] & 4294967295L) + xx12;
            z10[0] = (int) cc3;
            long cc4 = (cc3 >> 32) + ((z10[1] & 4294967295L) - xx12);
            z10[1] = (int) cc4;
            long cc5 = cc4 >> 32;
            if (cc5 != 0) {
                long cc6 = cc5 + (z10[2] & 4294967295L);
                z10[2] = (int) cc6;
                cc5 = cc6 >> 32;
            }
            long cc7 = cc5 + (z10[3] & 4294967295L) + xx12;
            z10[3] = (int) cc7;
            long cc8 = (cc7 >> 32) + (4294967295L & z10[4]) + xx12;
            z10[4] = (int) cc8;
            cc2 = cc8 >> 32;
        }
        if ((cc2 != 0 && Nat.incAt(12, z10, 5) != 0) || (z10[11] == -1 && Nat.gte(12, z10, P))) {
            addPInvTo(z10);
        }
    }

    public static void square(int[] x10, int[] z10) {
        int[] tt = Nat.create(24);
        Nat384.square(x10, tt);
        reduce(tt, z10);
    }

    public static void squareN(int[] x10, int n10, int[] z10) {
        int[] tt = Nat.create(24);
        Nat384.square(x10, tt);
        reduce(tt, z10);
        while (true) {
            n10--;
            if (n10 > 0) {
                Nat384.square(z10, tt);
                reduce(tt, z10);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat.sub(12, x10, y10, z10);
        if (c4 != 0) {
            subPInvFrom(z10);
        }
    }

    public static void subtractExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.sub(24, xx, yy, zz);
        if (c4 != 0) {
            int[] iArr = PExtInv;
            if (Nat.subFrom(iArr.length, iArr, zz) != 0) {
                Nat.decAt(24, zz, iArr.length);
            }
        }
    }

    public static void twice(int[] x10, int[] z10) {
        int c4 = Nat.shiftUpBit(12, x10, 0, z10);
        if (c4 != 0 || (z10[11] == -1 && Nat.gte(12, z10, P))) {
            addPInvTo(z10);
        }
    }

    private static void addPInvTo(int[] z10) {
        long c4 = (z10[0] & 4294967295L) + 1;
        z10[0] = (int) c4;
        long c10 = (c4 >> 32) + ((z10[1] & 4294967295L) - 1);
        z10[1] = (int) c10;
        long c11 = c10 >> 32;
        if (c11 != 0) {
            long c12 = c11 + (z10[2] & 4294967295L);
            z10[2] = (int) c12;
            c11 = c12 >> 32;
        }
        long c13 = c11 + (z10[3] & 4294967295L) + 1;
        z10[3] = (int) c13;
        long c14 = (c13 >> 32) + (4294967295L & z10[4]) + 1;
        z10[4] = (int) c14;
        if ((c14 >> 32) != 0) {
            Nat.incAt(12, z10, 5);
        }
    }

    private static void subPInvFrom(int[] z10) {
        long c4 = (z10[0] & 4294967295L) - 1;
        z10[0] = (int) c4;
        long c10 = (c4 >> 32) + (z10[1] & 4294967295L) + 1;
        z10[1] = (int) c10;
        long c11 = c10 >> 32;
        if (c11 != 0) {
            long c12 = c11 + (z10[2] & 4294967295L);
            z10[2] = (int) c12;
            c11 = c12 >> 32;
        }
        long c13 = c11 + ((z10[3] & 4294967295L) - 1);
        z10[3] = (int) c13;
        long c14 = (c13 >> 32) + ((4294967295L & z10[4]) - 1);
        z10[4] = (int) c14;
        if ((c14 >> 32) != 0) {
            Nat.decAt(12, z10, 5);
        }
    }
}
