package com.amap.api.col.p0003l;

/* compiled from: TCell.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jt extends ld {
    public static int a(lc lcVar, int i10, byte b4, int i11, int i12) {
        lcVar.b(4);
        c(lcVar, i12);
        b(lcVar, i11);
        a(lcVar, i10);
        a(lcVar, b4);
        return a(lcVar);
    }

    private static void b(lc lcVar, int i10) {
        lcVar.b(2, i10);
    }

    private static void c(lc lcVar, int i10) {
        lcVar.b(3, i10);
    }

    public static int b(lc lcVar, int[] iArr) {
        lcVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            lcVar.a(iArr[length]);
        }
        return lcVar.a();
    }

    private static void a(lc lcVar, int i10) {
        lcVar.b(0, i10);
    }

    private static void a(lc lcVar, byte b4) {
        lcVar.a(1, b4);
    }

    public static int a(lc lcVar, int[] iArr) {
        lcVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            lcVar.a(iArr[length]);
        }
        return lcVar.a();
    }

    private static int a(lc lcVar) {
        return lcVar.b();
    }
}
