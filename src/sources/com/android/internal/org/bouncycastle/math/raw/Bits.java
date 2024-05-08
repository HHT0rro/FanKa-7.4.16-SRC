package com.android.internal.org.bouncycastle.math.raw;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Bits {
    public static int bitPermuteStep(int x10, int m10, int s2) {
        int t2 = ((x10 >>> s2) ^ x10) & m10;
        return ((t2 << s2) ^ t2) ^ x10;
    }

    public static long bitPermuteStep(long x10, long m10, int s2) {
        long t2 = ((x10 >>> s2) ^ x10) & m10;
        return ((t2 << s2) ^ t2) ^ x10;
    }

    public static int bitPermuteStepSimple(int x10, int m10, int s2) {
        return ((x10 & m10) << s2) | ((x10 >>> s2) & m10);
    }

    public static long bitPermuteStepSimple(long x10, long m10, int s2) {
        return ((x10 & m10) << s2) | ((x10 >>> s2) & m10);
    }
}
