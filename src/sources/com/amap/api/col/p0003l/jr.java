package com.amap.api.col.p0003l;

/* compiled from: RootTUploadData.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jr extends ld {
    public static int a(lc lcVar, int i10, int i11, int i12) {
        lcVar.b(3);
        c(lcVar, i12);
        b(lcVar, i11);
        a(lcVar, i10);
        return a(lcVar);
    }

    private static void b(lc lcVar, int i10) {
        lcVar.b(1, i10);
    }

    private static void c(lc lcVar, int i10) {
        lcVar.b(2, i10);
    }

    public static int b(lc lcVar, byte[] bArr) {
        lcVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            lcVar.a(bArr[length]);
        }
        return lcVar.a();
    }

    private static void a(lc lcVar, int i10) {
        lcVar.b(0, i10);
    }

    public static int a(lc lcVar, byte[] bArr) {
        lcVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            lcVar.a(bArr[length]);
        }
        return lcVar.a();
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
