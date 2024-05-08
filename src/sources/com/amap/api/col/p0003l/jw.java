package com.amap.api.col.p0003l;

/* compiled from: TData.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jw extends ld {
    public static int a(lc lcVar, byte b4, int i10) {
        lcVar.b(2);
        a(lcVar, i10);
        a(lcVar, b4);
        return a(lcVar);
    }

    private static void a(lc lcVar, byte b4) {
        lcVar.a(0, b4);
    }

    private static void a(lc lcVar, int i10) {
        lcVar.b(1, i10);
    }

    public static int a(lc lcVar, byte[] bArr) {
        lcVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            lcVar.a(bArr[length]);
        }
        return lcVar.a();
    }

    private static int a(lc lcVar) {
        return lcVar.b();
    }
}
