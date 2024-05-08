package com.android.internal.org.bouncycastle.math.raw;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Nat384 {
    public static void mul(int[] x10, int[] y10, int[] zz) {
        Nat192.mul(x10, y10, zz);
        Nat192.mul(x10, 6, y10, 6, zz, 12);
        int c18 = Nat192.addToEachOther(zz, 6, zz, 12);
        int c12 = Nat192.addTo(zz, 0, zz, 6, 0) + c18;
        int c182 = c18 + Nat192.addTo(zz, 18, zz, 12, c12);
        int[] dx = Nat192.create();
        int[] dy = Nat192.create();
        boolean neg = Nat192.diff(x10, 6, x10, 0, dx, 0) != Nat192.diff(y10, 6, y10, 0, dy, 0);
        int[] tt = Nat192.createExt();
        Nat192.mul(dx, dy, tt);
        Nat.addWordAt(24, c182 + (neg ? Nat.addTo(12, tt, 0, zz, 6) : Nat.subFrom(12, tt, 0, zz, 6)), zz, 18);
    }

    public static void square(int[] x10, int[] zz) {
        Nat192.square(x10, zz);
        Nat192.square(x10, 6, zz, 12);
        int c18 = Nat192.addToEachOther(zz, 6, zz, 12);
        int c12 = Nat192.addTo(zz, 0, zz, 6, 0) + c18;
        int c182 = c18 + Nat192.addTo(zz, 18, zz, 12, c12);
        int[] dx = Nat192.create();
        Nat192.diff(x10, 6, x10, 0, dx, 0);
        int[] tt = Nat192.createExt();
        Nat192.square(dx, tt);
        Nat.addWordAt(24, c182 + Nat.subFrom(12, tt, 0, zz, 6), zz, 18);
    }
}
