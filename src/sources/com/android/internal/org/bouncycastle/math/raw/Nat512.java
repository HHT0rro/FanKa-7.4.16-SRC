package com.android.internal.org.bouncycastle.math.raw;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Nat512 {
    public static void mul(int[] x10, int[] y10, int[] zz) {
        Nat256.mul(x10, y10, zz);
        Nat256.mul(x10, 8, y10, 8, zz, 16);
        int c24 = Nat256.addToEachOther(zz, 8, zz, 16);
        int c16 = Nat256.addTo(zz, 0, zz, 8, 0) + c24;
        int c242 = c24 + Nat256.addTo(zz, 24, zz, 16, c16);
        int[] dx = Nat256.create();
        int[] dy = Nat256.create();
        boolean neg = Nat256.diff(x10, 8, x10, 0, dx, 0) != Nat256.diff(y10, 8, y10, 0, dy, 0);
        int[] tt = Nat256.createExt();
        Nat256.mul(dx, dy, tt);
        Nat.addWordAt(32, c242 + (neg ? Nat.addTo(16, tt, 0, zz, 8) : Nat.subFrom(16, tt, 0, zz, 8)), zz, 24);
    }

    public static void square(int[] x10, int[] zz) {
        Nat256.square(x10, zz);
        Nat256.square(x10, 8, zz, 16);
        int c24 = Nat256.addToEachOther(zz, 8, zz, 16);
        int c16 = Nat256.addTo(zz, 0, zz, 8, 0) + c24;
        int c242 = c24 + Nat256.addTo(zz, 24, zz, 16, c16);
        int[] dx = Nat256.create();
        Nat256.diff(x10, 8, x10, 0, dx, 0);
        int[] tt = Nat256.createExt();
        Nat256.square(dx, tt);
        Nat.addWordAt(32, c242 + Nat.subFrom(16, tt, 0, zz, 8), zz, 24);
    }
}
