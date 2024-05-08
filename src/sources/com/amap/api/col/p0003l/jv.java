package com.amap.api.col.p0003l;

/* compiled from: TCellInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jv extends ld {
    public static int a(lc lcVar, byte b4, byte b10, short s2, byte b11, int i10) {
        lcVar.b(5);
        a(lcVar, i10);
        a(lcVar, s2);
        c(lcVar, b11);
        b(lcVar, b10);
        a(lcVar, b4);
        return a(lcVar);
    }

    private static void b(lc lcVar, byte b4) {
        lcVar.a(1, b4);
    }

    private static void c(lc lcVar, byte b4) {
        lcVar.a(3, b4);
    }

    private static void a(lc lcVar, byte b4) {
        lcVar.a(0, b4);
    }

    private static void a(lc lcVar, short s2) {
        lcVar.a(2, s2);
    }

    private static void a(lc lcVar, int i10) {
        lcVar.b(4, i10);
    }

    private static int a(lc lcVar) {
        return lcVar.b();
    }
}
