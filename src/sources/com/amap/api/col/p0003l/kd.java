package com.amap.api.col.p0003l;

/* compiled from: TWifi.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class kd extends ld {
    public static int a(lc lcVar, int i10) {
        lcVar.b(1);
        b(lcVar, i10);
        return a(lcVar);
    }

    private static void b(lc lcVar, int i10) {
        lcVar.b(0, i10);
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
