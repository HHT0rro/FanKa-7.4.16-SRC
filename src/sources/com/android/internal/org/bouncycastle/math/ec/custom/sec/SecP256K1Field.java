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
public class SecP256K1Field {
    private static final int P7 = -1;
    private static final int PExt15 = -1;
    private static final int PInv33 = 977;
    static final int[] P = {-977, -2, -1, -1, -1, -1, -1, -1};
    private static final int[] PExt = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};
    private static final int[] PExtInv = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    public static void add(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat256.add(x10, y10, z10);
        if (c4 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            Nat.add33To(8, PInv33, z10);
        }
    }

    public static void addExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.add(16, xx, yy, zz);
        if (c4 != 0 || (zz[15] == -1 && Nat.gte(16, zz, PExt))) {
            int[] iArr = PExtInv;
            if (Nat.addTo(iArr.length, iArr, zz) != 0) {
                Nat.incAt(16, zz, iArr.length);
            }
        }
    }

    public static void addOne(int[] x10, int[] z10) {
        int c4 = Nat.inc(8, x10, z10);
        if (c4 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            Nat.add33To(8, PInv33, z10);
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
        if (c4 != 0 || (zz[15] == -1 && Nat.gte(16, zz, PExt))) {
            int[] iArr = PExtInv;
            if (Nat.addTo(iArr.length, iArr, zz) != 0) {
                Nat.incAt(16, zz, iArr.length);
            }
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
        long cc2 = Nat256.mul33Add(PInv33, xx, 8, xx, 0, z10, 0);
        int c4 = Nat256.mul33DWordAdd(PInv33, cc2, z10, 0);
        if (c4 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            Nat.add33To(8, PInv33, z10);
        }
    }

    public static void reduce32(int x10, int[] z10) {
        if ((x10 != 0 && Nat256.mul33WordAdd(PInv33, x10, z10, 0) != 0) || (z10[7] == -1 && Nat256.gte(z10, P))) {
            Nat.add33To(8, PInv33, z10);
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
            Nat.sub33From(8, PInv33, z10);
        }
    }

    public static void subtractExt(int[] xx, int[] yy, int[] zz) {
        int c4 = Nat.sub(16, xx, yy, zz);
        if (c4 != 0) {
            int[] iArr = PExtInv;
            if (Nat.subFrom(iArr.length, iArr, zz) != 0) {
                Nat.decAt(16, zz, iArr.length);
            }
        }
    }

    public static void twice(int[] x10, int[] z10) {
        int c4 = Nat.shiftUpBit(8, x10, 0, z10);
        if (c4 != 0 || (z10[7] == -1 && Nat256.gte(z10, P))) {
            Nat.add33To(8, PInv33, z10);
        }
    }
}
