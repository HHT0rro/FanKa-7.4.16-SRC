package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.org.bouncycastle.math.raw.Mod;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat512;
import com.android.internal.org.bouncycastle.util.Pack;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP521R1Field {
    static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};
    private static final int P16 = 511;

    public static void add(int[] x10, int[] y10, int[] z10) {
        int c4 = Nat.add(16, x10, y10, z10) + x10[16] + y10[16];
        if (c4 > 511 || (c4 == 511 && Nat.eq(16, z10, P))) {
            c4 = (c4 + Nat.inc(16, z10)) & 511;
        }
        z10[16] = c4;
    }

    public static void addOne(int[] x10, int[] z10) {
        int c4 = Nat.inc(16, x10, z10) + x10[16];
        if (c4 > 511 || (c4 == 511 && Nat.eq(16, z10, P))) {
            c4 = (c4 + Nat.inc(16, z10)) & 511;
        }
        z10[16] = c4;
    }

    public static int[] fromBigInteger(BigInteger x10) {
        int[] z10 = Nat.fromBigInteger(MetricsProto.MetricsEvent.PROVISIONING_ENCRYPT_DEVICE_ACTIVITY_TIME_MS, x10);
        if (Nat.eq(17, z10, P)) {
            Nat.zero(17, z10);
        }
        return z10;
    }

    public static void half(int[] x10, int[] z10) {
        int x16 = x10[16];
        int c4 = Nat.shiftDownBit(16, x10, x16, z10);
        z10[16] = (x16 >>> 1) | (c4 >>> 23);
    }

    public static void inv(int[] x10, int[] z10) {
        Mod.checkedModOddInverse(P, x10, z10);
    }

    public static int isZero(int[] x10) {
        int d10 = 0;
        for (int i10 = 0; i10 < 17; i10++) {
            d10 |= x10[i10];
        }
        int i11 = d10 >>> 1;
        return ((i11 | (d10 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] x10, int[] y10, int[] z10) {
        int[] tt = Nat.create(33);
        implMultiply(x10, y10, tt);
        reduce(tt, z10);
    }

    public static void negate(int[] x10, int[] z10) {
        if (isZero(x10) != 0) {
            int[] iArr = P;
            Nat.sub(17, iArr, iArr, z10);
        } else {
            Nat.sub(17, P, x10, z10);
        }
    }

    public static void random(SecureRandom r10, int[] z10) {
        byte[] bb2 = new byte[68];
        do {
            r10.nextBytes(bb2);
            Pack.littleEndianToInt(bb2, 0, z10, 0, 17);
            z10[16] = z10[16] & 511;
        } while (Nat.lessThan(17, z10, P) == 0);
    }

    public static void randomMult(SecureRandom r10, int[] z10) {
        do {
            random(r10, z10);
        } while (isZero(z10) != 0);
    }

    public static void reduce(int[] xx, int[] z10) {
        int xx32 = xx[32];
        int c4 = (Nat.shiftDownBits(16, xx, 16, 9, xx32, z10, 0) >>> 23) + (xx32 >>> 9) + Nat.addTo(16, xx, z10);
        if (c4 > 511 || (c4 == 511 && Nat.eq(16, z10, P))) {
            c4 = (c4 + Nat.inc(16, z10)) & 511;
        }
        z10[16] = c4;
    }

    public static void reduce23(int[] z10) {
        int z16 = z10[16];
        int c4 = Nat.addWordTo(16, z16 >>> 9, z10) + (z16 & 511);
        if (c4 > 511 || (c4 == 511 && Nat.eq(16, z10, P))) {
            c4 = (c4 + Nat.inc(16, z10)) & 511;
        }
        z10[16] = c4;
    }

    public static void square(int[] x10, int[] z10) {
        int[] tt = Nat.create(33);
        implSquare(x10, tt);
        reduce(tt, z10);
    }

    public static void squareN(int[] x10, int n10, int[] z10) {
        int[] tt = Nat.create(33);
        implSquare(x10, tt);
        reduce(tt, z10);
        while (true) {
            n10--;
            if (n10 > 0) {
                implSquare(z10, tt);
                reduce(tt, z10);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] x10, int[] y10, int[] z10) {
        int c4 = (Nat.sub(16, x10, y10, z10) + x10[16]) - y10[16];
        if (c4 < 0) {
            c4 = (c4 + Nat.dec(16, z10)) & 511;
        }
        z10[16] = c4;
    }

    public static void twice(int[] x10, int[] z10) {
        int x16 = x10[16];
        int c4 = Nat.shiftUpBit(16, x10, x16 << 23, z10) | (x16 << 1);
        z10[16] = c4 & 511;
    }

    protected static void implMultiply(int[] x10, int[] y10, int[] zz) {
        Nat512.mul(x10, y10, zz);
        int x16 = x10[16];
        int y16 = y10[16];
        zz[32] = Nat.mul31BothAdd(16, x16, y10, y16, x10, zz, 16) + (x16 * y16);
    }

    protected static void implSquare(int[] x10, int[] zz) {
        Nat512.square(x10, zz);
        int x16 = x10[16];
        zz[32] = Nat.mulWordAddTo(16, x16 << 1, x10, 0, zz, 16) + (x16 * x16);
    }
}
