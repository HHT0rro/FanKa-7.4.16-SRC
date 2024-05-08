package com.google.common.collect;

/* compiled from: Hashing.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f0 {
    public static int a(int i10, double d10) {
        int max = Math.max(i10, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d10 * highestOneBit))) {
            return highestOneBit;
        }
        int i11 = highestOneBit << 1;
        if (i11 > 0) {
            return i11;
        }
        return 1073741824;
    }

    public static boolean b(int i10, int i11, double d10) {
        return ((double) i10) > d10 * ((double) i11) && i11 < 1073741824;
    }

    public static int c(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * (-862048943)), 15) * 461845907);
    }

    public static int d(Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
