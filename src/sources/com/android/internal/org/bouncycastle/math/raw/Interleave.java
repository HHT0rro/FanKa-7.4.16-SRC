package com.android.internal.org.bouncycastle.math.raw;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Interleave {
    private static final long M32 = 1431655765;
    private static final long M64 = 6148914691236517205L;
    private static final long M64R = -6148914691236517206L;

    public static int expand8to16(int x10) {
        int x11 = x10 & 255;
        int x12 = ((x11 << 4) | x11) & 3855;
        int x13 = ((x12 << 2) | x12) & 13107;
        return ((x13 << 1) | x13) & 21845;
    }

    public static int expand16to32(int x10) {
        int x11 = x10 & 65535;
        int x12 = ((x11 << 8) | x11) & 16711935;
        int x13 = ((x12 << 4) | x12) & 252645135;
        int x14 = ((x13 << 2) | x13) & 858993459;
        return ((x14 << 1) | x14) & 1431655765;
    }

    public static long expand32to64(int x10) {
        return (((r6 >>> 1) & M32) << 32) | (M32 & Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1));
    }

    public static void expand64To128(long x10, long[] z10, int zOff) {
        long x11 = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        z10[zOff] = x11 & M64;
        z10[zOff + 1] = M64 & (x11 >>> 1);
    }

    public static void expand64To128(long[] xs, int xsOff, int xsLen, long[] zs, int zsOff) {
        for (int i10 = 0; i10 < xsLen; i10++) {
            expand64To128(xs[xsOff + i10], zs, zsOff);
            zsOff += 2;
        }
    }

    public static void expand64To128Rev(long x10, long[] z10, int zOff) {
        long x11 = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        z10[zOff] = x11 & M64R;
        z10[zOff + 1] = M64R & (x11 << 1);
    }

    public static int shuffle(int x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
    }

    public static long shuffle(long x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
    }

    public static int shuffle2(int x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
    }

    public static long shuffle2(long x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 4278255360L, 24), 57421771435671756L, 6), 264913582878960L, 12), 723401728380766730L, 3);
    }

    public static long shuffle3(long x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 47851476196393130L, 7), 225176545447116L, 14), 4042322160L, 28);
    }

    public static int unshuffle(int x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 572662306, 1), 202116108, 2), 15728880, 4), 65280, 8);
    }

    public static long unshuffle(long x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 2459565876494606882L, 1), 868082074056920076L, 2), 67555025218437360L, 4), 280375465148160L, 8), 4294901760L, 16);
    }

    public static int unshuffle2(int x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 65280, 8), 15728880, 4), 52428, 14), 11141290, 7);
    }

    public static long unshuffle2(long x10) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(x10, 723401728380766730L, 3), 264913582878960L, 12), 57421771435671756L, 6), 4278255360L, 24);
    }

    public static long unshuffle3(long x10) {
        return shuffle3(x10);
    }
}
