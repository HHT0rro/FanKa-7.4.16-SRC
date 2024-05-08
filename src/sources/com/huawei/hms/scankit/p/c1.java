package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.a8;

/* compiled from: DataBlock.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class c1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f30780a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f30781b;

    private c1(int i10, byte[] bArr) {
        this.f30780a = i10;
        this.f30781b = bArr;
    }

    public static c1[] a(byte[] bArr, a8 a8Var, c3 c3Var) {
        if (bArr.length == a8Var.l()) {
            a8.b a10 = a8Var.a(c3Var);
            a8.a[] a11 = a10.a();
            int i10 = 0;
            for (a8.a aVar : a11) {
                i10 += aVar.a();
            }
            c1[] c1VarArr = new c1[i10];
            int i11 = 0;
            for (a8.a aVar2 : a11) {
                int i12 = 0;
                while (i12 < aVar2.a()) {
                    int b4 = aVar2.b();
                    c1VarArr[i11] = new c1(b4, new byte[a10.b() + b4]);
                    i12++;
                    i11++;
                }
            }
            int length = c1VarArr[0].f30781b.length;
            int i13 = i10 - 1;
            while (i13 >= 0 && c1VarArr[i13].f30781b.length != length) {
                i13--;
            }
            int i14 = i13 + 1;
            int b10 = length - a10.b();
            int i15 = 0;
            for (int i16 = 0; i16 < b10; i16++) {
                int i17 = 0;
                while (i17 < i11) {
                    c1VarArr[i17].f30781b[i16] = bArr[i15];
                    i17++;
                    i15++;
                }
            }
            int i18 = i14;
            while (i18 < i11) {
                c1VarArr[i18].f30781b[b10] = bArr[i15];
                i18++;
                i15++;
            }
            int length2 = c1VarArr[0].f30781b.length;
            while (b10 < length2) {
                int i19 = 0;
                while (i19 < i11) {
                    c1VarArr[i19].f30781b[i19 < i14 ? b10 : b10 + 1] = bArr[i15];
                    i19++;
                    i15++;
                }
                b10++;
            }
            return c1VarArr;
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.f30780a;
    }

    public byte[] a() {
        return this.f30781b;
    }
}
