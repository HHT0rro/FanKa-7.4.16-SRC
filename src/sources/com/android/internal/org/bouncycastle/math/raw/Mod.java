package com.android.internal.org.bouncycastle.math.raw;

import com.android.internal.org.bouncycastle.util.Integers;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Mod {
    private static final int M30 = 1073741823;
    private static final long M32L = 4294967295L;

    public static void add(int[] p10, int[] x10, int[] y10, int[] z10) {
        int len = p10.length;
        int c4 = Nat.add(len, x10, y10, z10);
        if (c4 != 0) {
            Nat.subFrom(len, p10, z10);
        }
    }

    public static void checkedModOddInverse(int[] m10, int[] x10, int[] z10) {
        if (modOddInverse(m10, x10, z10) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void checkedModOddInverseVar(int[] m10, int[] x10, int[] z10) {
        if (!modOddInverseVar(m10, x10, z10)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static int inverse32(int d10) {
        int x10 = d10 * (2 - (d10 * d10));
        int x11 = x10 * (2 - (d10 * x10));
        int x12 = x11 * (2 - (d10 * x11));
        return x12 * (2 - (d10 * x12));
    }

    public static void invert(int[] m10, int[] x10, int[] z10) {
        checkedModOddInverseVar(m10, x10, z10);
    }

    public static int modOddInverse(int[] m10, int[] x10, int[] z10) {
        int len32 = m10.length;
        int bits = (len32 << 5) - Integers.numberOfLeadingZeros(m10[len32 - 1]);
        int len30 = (bits + 29) / 30;
        int[] t2 = new int[4];
        int[] D = new int[len30];
        int[] E = new int[len30];
        int[] F = new int[len30];
        int[] G = new int[len30];
        int[] M = new int[len30];
        int i10 = 0;
        E[0] = 1;
        encode30(bits, x10, 0, G, 0);
        encode30(bits, m10, 0, M, 0);
        System.arraycopy((Object) M, 0, (Object) F, 0, len30);
        int eta = -1;
        int m0Inv32 = inverse32(M[0]);
        int maxDivsteps = getMaximumDivsteps(bits);
        int divSteps = 0;
        while (divSteps < maxDivsteps) {
            int eta2 = divsteps30(eta, F[i10], G[i10], t2);
            updateDE30(len30, D, E, t2, m0Inv32, M);
            updateFG30(len30, F, G, t2);
            divSteps += 30;
            i10 = i10;
            maxDivsteps = maxDivsteps;
            eta = eta2;
        }
        int i11 = i10;
        int divSteps2 = len30 - 1;
        int signF = F[divSteps2] >> 31;
        cnegate30(len30, signF, F);
        cnormalize30(len30, signF, D, M);
        decode30(bits, D, i11, z10, i11);
        return Nat.equalTo(len30, F, 1) & Nat.equalToZero(len30, G);
    }

    public static boolean modOddInverseVar(int[] m10, int[] x10, int[] z10) {
        int len32 = m10.length;
        int bits = (len32 << 5) - Integers.numberOfLeadingZeros(m10[len32 - 1]);
        int len30 = (bits + 29) / 30;
        int[] t2 = new int[4];
        int[] D = new int[len30];
        int[] E = new int[len30];
        int[] F = new int[len30];
        int[] G = new int[len30];
        int[] M = new int[len30];
        E[0] = 1;
        encode30(bits, x10, 0, G, 0);
        encode30(bits, m10, 0, M, 0);
        System.arraycopy((Object) M, 0, (Object) F, 0, len30);
        int clzG = Integers.numberOfLeadingZeros(G[len30 - 1] | 1) - (((len30 * 30) + 2) - bits);
        int eta = (-1) - clzG;
        int lenDE = len30;
        int gn = len30;
        int m0Inv32 = inverse32(M[0]);
        int maxDivsteps = getMaximumDivsteps(bits);
        int divsteps = 0;
        while (!Nat.isZero(gn, G)) {
            if (divsteps >= maxDivsteps) {
                return false;
            }
            int divsteps2 = divsteps + 30;
            int divsteps3 = F[0];
            int eta2 = divsteps30Var(eta, divsteps3, G[0], t2);
            int eta3 = lenDE;
            int lenFG = gn;
            int maxDivsteps2 = maxDivsteps;
            int eta4 = lenDE;
            int len322 = len32;
            int lenFG2 = lenFG;
            int len302 = len30;
            updateDE30(eta3, D, E, t2, m0Inv32, M);
            updateFG30(lenFG2, F, G, t2);
            int fn = F[lenFG2 - 1];
            int gn2 = G[lenFG2 - 1];
            int cond = (lenFG2 - 2) >> 31;
            if ((cond | ((fn >> 31) ^ fn) | ((gn2 >> 31) ^ gn2)) == 0) {
                int i10 = lenFG2 - 2;
                F[i10] = F[i10] | (fn << 30);
                int i11 = lenFG2 - 2;
                G[i11] = G[i11] | (gn2 << 30);
                lenFG2--;
            }
            gn = lenFG2;
            lenDE = eta4;
            len30 = len302;
            divsteps = divsteps2;
            maxDivsteps = maxDivsteps2;
            eta = eta2;
            len32 = len322;
        }
        int len323 = gn;
        int lenDE2 = lenDE;
        int lenFG3 = len323 - 1;
        int signF = F[lenFG3] >> 31;
        int signD = D[lenDE2 - 1] >> 31;
        if (signD < 0) {
            signD = add30(lenDE2, D, M);
        }
        if (signF < 0) {
            signD = negate30(lenDE2, D);
            negate30(len323, F);
        }
        if (!Nat.isOne(len323, F)) {
            return false;
        }
        if (signD < 0) {
            add30(lenDE2, D, M);
        }
        decode30(bits, D, 0, z10, 0);
        return true;
    }

    public static int[] random(int[] p10) {
        int len = p10.length;
        Random rand = new Random();
        int[] s2 = Nat.create(len);
        int m10 = p10[len - 1];
        int m11 = m10 | (m10 >>> 1);
        int m12 = m11 | (m11 >>> 2);
        int m13 = m12 | (m12 >>> 4);
        int m14 = m13 | (m13 >>> 8);
        int m15 = m14 | (m14 >>> 16);
        do {
            for (int i10 = 0; i10 != len; i10++) {
                s2[i10] = rand.nextInt();
            }
            int i11 = len - 1;
            s2[i11] = s2[i11] & m15;
        } while (Nat.gte(len, s2, p10));
        return s2;
    }

    public static void subtract(int[] p10, int[] x10, int[] y10, int[] z10) {
        int len = p10.length;
        int c4 = Nat.sub(len, x10, y10, z10);
        if (c4 != 0) {
            Nat.addTo(len, p10, z10);
        }
    }

    private static int add30(int len30, int[] D, int[] M) {
        int c4 = 0;
        int last = len30 - 1;
        for (int i10 = 0; i10 < last; i10++) {
            int c10 = c4 + D[i10] + M[i10];
            D[i10] = 1073741823 & c10;
            c4 = c10 >> 30;
        }
        int i11 = D[last];
        int c11 = c4 + i11 + M[last];
        D[last] = c11;
        return c11 >> 30;
    }

    private static void cnegate30(int len30, int cond, int[] D) {
        int c4 = 0;
        int last = len30 - 1;
        for (int i10 = 0; i10 < last; i10++) {
            int c10 = c4 + ((D[i10] ^ cond) - cond);
            D[i10] = 1073741823 & c10;
            c4 = c10 >> 30;
        }
        int i11 = D[last];
        D[last] = c4 + ((i11 ^ cond) - cond);
    }

    private static void cnormalize30(int len30, int condNegate, int[] D, int[] M) {
        int last = len30 - 1;
        int c4 = 0;
        int condAdd = D[last] >> 31;
        for (int i10 = 0; i10 < last; i10++) {
            int di = D[i10] + (M[i10] & condAdd);
            int c10 = c4 + ((di ^ condNegate) - condNegate);
            D[i10] = 1073741823 & c10;
            c4 = c10 >> 30;
        }
        int i11 = D[last];
        int di2 = i11 + (M[last] & condAdd);
        D[last] = c4 + ((di2 ^ condNegate) - condNegate);
        int c11 = 0;
        int condAdd2 = D[last] >> 31;
        for (int i12 = 0; i12 < last; i12++) {
            int di3 = D[i12] + (M[i12] & condAdd2);
            int c12 = c11 + di3;
            D[i12] = c12 & 1073741823;
            c11 = c12 >> 30;
        }
        int i13 = D[last];
        int di4 = i13 + (M[last] & condAdd2);
        D[last] = c11 + di4;
    }

    private static void decode30(int bits, int[] x10, int xOff, int[] z10, int zOff) {
        int avail = 0;
        long data = 0;
        while (bits > 0) {
            while (avail < Math.min(32, bits)) {
                data |= x10[xOff] << avail;
                avail += 30;
                xOff++;
            }
            z10[zOff] = (int) data;
            data >>>= 32;
            avail -= 32;
            bits -= 32;
            zOff++;
        }
    }

    private static int divsteps30(int eta, int f02, int g02, int[] t2) {
        int g3 = g02;
        int g10 = f02;
        int r10 = 1;
        int q10 = 0;
        int q11 = 0;
        int v2 = 1;
        int eta2 = eta;
        for (int i10 = 0; i10 < 30; i10++) {
            int c12 = eta2 >> 31;
            int c22 = -(g3 & 1);
            int x10 = (g10 ^ c12) - c12;
            int y10 = (v2 ^ c12) - c12;
            int z10 = (q11 ^ c12) - c12;
            int g11 = g3 + (x10 & c22);
            q10 += y10 & c22;
            r10 += z10 & c22;
            int c13 = c12 & c22;
            eta2 = (eta2 ^ c13) - (c13 + 1);
            g10 += g11 & c13;
            int u10 = v2 + (q10 & c13);
            int v10 = q11 + (r10 & c13);
            g3 = g11 >> 1;
            v2 = u10 << 1;
            q11 = v10 << 1;
        }
        t2[0] = v2;
        t2[1] = q11;
        t2[2] = q10;
        t2[3] = r10;
        return eta2;
    }

    private static int divsteps30Var(int eta, int f02, int g02, int[] t2) {
        int w3;
        int i10 = 30;
        int g3 = g02;
        int f10 = f02;
        int r10 = 1;
        int q10 = 0;
        int v2 = 0;
        int u10 = 1;
        int eta2 = eta;
        while (true) {
            int zeros = Integers.numberOfTrailingZeros(((-1) << i10) | g3);
            int g10 = g3 >> zeros;
            u10 <<= zeros;
            v2 <<= zeros;
            eta2 -= zeros;
            i10 -= zeros;
            if (i10 > 0) {
                if (eta2 < 0) {
                    eta2 = -eta2;
                    int x10 = f10;
                    f10 = g10;
                    g10 = -x10;
                    u10 = q10;
                    q10 = -u10;
                    v2 = r10;
                    r10 = -v2;
                    int limit = eta2 + 1 > i10 ? i10 : eta2 + 1;
                    int m10 = ((-1) >>> (32 - limit)) & 63;
                    w3 = (f10 * g10 * ((f10 * f10) - 2)) & m10;
                } else {
                    int w10 = eta2 + 1;
                    int limit2 = w10 > i10 ? i10 : eta2 + 1;
                    int m11 = ((-1) >>> (32 - limit2)) & 15;
                    int w11 = (((f10 + 1) & 4) << 1) + f10;
                    w3 = ((-w11) * g10) & m11;
                }
                g3 = g10 + (f10 * w3);
                q10 += u10 * w3;
                r10 += v2 * w3;
            } else {
                t2[0] = u10;
                t2[1] = v2;
                t2[2] = q10;
                t2[3] = r10;
                return eta2;
            }
        }
    }

    private static void encode30(int bits, int[] x10, int xOff, int[] z10, int zOff) {
        int avail = 0;
        long data = 0;
        while (bits > 0) {
            if (avail < Math.min(30, bits)) {
                data |= (x10[xOff] & 4294967295L) << avail;
                avail += 32;
                xOff++;
            }
            int xOff2 = zOff + 1;
            z10[zOff] = ((int) data) & 1073741823;
            data >>>= 30;
            avail -= 30;
            bits -= 30;
            zOff = xOff2;
        }
    }

    private static int getMaximumDivsteps(int bits) {
        return ((bits * 49) + (bits < 46 ? 80 : 47)) / 17;
    }

    private static int negate30(int len30, int[] D) {
        int c4 = 0;
        int last = len30 - 1;
        for (int i10 = 0; i10 < last; i10++) {
            int c10 = c4 - D[i10];
            D[i10] = 1073741823 & c10;
            c4 = c10 >> 30;
        }
        int i11 = D[last];
        int c11 = c4 - i11;
        D[last] = c11;
        return c11 >> 30;
    }

    private static void updateDE30(int len30, int[] D, int[] E, int[] t2, int m0Inv32, int[] M) {
        int q10 = t2[0];
        int v2 = t2[1];
        int q11 = t2[2];
        int r10 = t2[3];
        int sd2 = D[len30 - 1] >> 31;
        int se = E[len30 - 1] >> 31;
        int md2 = (q10 & sd2) + (v2 & se);
        int me2 = (q11 & sd2) + (r10 & se);
        int mi = M[0];
        int di = D[0];
        int ei = E[0];
        long cd2 = (q10 * di) + (v2 * ei);
        int di2 = q11;
        long ce2 = (q11 * di) + (r10 * ei);
        int md3 = md2 - (((((int) cd2) * m0Inv32) + md2) & 1073741823);
        int me3 = me2 - (((((int) ce2) * m0Inv32) + me2) & 1073741823);
        long cd3 = (cd2 + (mi * md3)) >> 30;
        long ce3 = (ce2 + (mi * me3)) >> 30;
        int i10 = 1;
        while (i10 < len30) {
            int mi2 = M[i10];
            int di3 = D[i10];
            int ei2 = E[i10];
            int i11 = i10;
            int u10 = q10;
            long cd4 = cd3 + (q10 * di3) + (v2 * ei2) + (mi2 * md3);
            int q12 = di2;
            long ce4 = ce3 + (q12 * di3) + (r10 * ei2) + (mi2 * me3);
            D[i11 - 1] = ((int) cd4) & 1073741823;
            cd3 = cd4 >> 30;
            E[i11 - 1] = ((int) ce4) & 1073741823;
            ce3 = ce4 >> 30;
            i10 = i11 + 1;
            di2 = q12;
            q10 = u10;
            v2 = v2;
        }
        D[len30 - 1] = (int) cd3;
        E[len30 - 1] = (int) ce3;
    }

    private static void updateFG30(int len30, int[] F, int[] G, int[] t2) {
        int u10 = t2[0];
        int v2 = t2[1];
        int q10 = t2[2];
        int r10 = t2[3];
        int fi = F[0];
        int gi = G[0];
        long cf = (u10 * fi) + (v2 * gi);
        long cg = (q10 * fi) + (r10 * gi);
        long cf2 = cf >> 30;
        long cg2 = cg >> 30;
        int i10 = 1;
        while (i10 < len30) {
            int fi2 = F[i10];
            int gi2 = G[i10];
            int i11 = i10;
            long cf3 = cf2 + (u10 * fi2) + (v2 * gi2);
            long cg3 = cg2 + (q10 * fi2) + (r10 * gi2);
            F[i11 - 1] = ((int) cf3) & 1073741823;
            cf2 = cf3 >> 30;
            G[i11 - 1] = 1073741823 & ((int) cg3);
            cg2 = cg3 >> 30;
            i10 = i11 + 1;
            u10 = u10;
            v2 = v2;
        }
        F[len30 - 1] = (int) cf2;
        G[len30 - 1] = (int) cg2;
    }
}
