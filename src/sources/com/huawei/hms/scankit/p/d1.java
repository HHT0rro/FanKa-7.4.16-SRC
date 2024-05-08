package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.b8;

/* compiled from: DataBlock.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class d1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f30832a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f30833b;

    private d1(int i10, byte[] bArr) {
        this.f30832a = i10;
        this.f30833b = bArr;
    }

    public static d1[] a(byte[] bArr, b8 b8Var, b3 b3Var) {
        if (bArr.length == b8Var.e()) {
            b8.b a10 = b8Var.a(b3Var);
            b8.a[] a11 = a10.a();
            int i10 = 0;
            for (b8.a aVar : a11) {
                i10 += aVar.a();
            }
            d1[] d1VarArr = new d1[i10];
            int i11 = 0;
            for (b8.a aVar2 : a11) {
                int i12 = 0;
                while (i12 < aVar2.a()) {
                    int b4 = aVar2.b();
                    d1VarArr[i11] = new d1(b4, new byte[a10.b() + b4]);
                    i12++;
                    i11++;
                }
            }
            int length = d1VarArr[0].f30833b.length;
            int i13 = i10 - 1;
            while (i13 >= 0 && d1VarArr[i13].f30833b.length != length) {
                i13--;
            }
            return a(d1VarArr, bArr, length, a10, i11, i13 + 1);
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int b() {
        return this.f30832a;
    }

    private static d1[] a(d1[] d1VarArr, byte[] bArr, int i10, b8.b bVar, int i11, int i12) {
        int b4 = i10 - bVar.b();
        int i13 = 0;
        for (int i14 = 0; i14 < b4; i14++) {
            int i15 = 0;
            while (i15 < i11) {
                d1VarArr[i15].f30833b[i14] = bArr[i13];
                i15++;
                i13++;
            }
        }
        int i16 = i12;
        while (i16 < i11) {
            d1VarArr[i16].f30833b[b4] = bArr[i13];
            i16++;
            i13++;
        }
        int length = d1VarArr[0].f30833b.length;
        while (b4 < length) {
            int i17 = 0;
            while (i17 < i11) {
                int i18 = i17 < i12 ? b4 : b4 + 1;
                if (i17 >= 0) {
                    try {
                        if (i17 < d1VarArr.length && w7.a(d1VarArr[i17].f30833b, i18) && w7.a(bArr, i13)) {
                            d1VarArr[i17].f30833b[i18] = bArr[i13];
                            i17++;
                            i13++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        throw e2;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            b4++;
        }
        return d1VarArr;
    }

    public byte[] a() {
        return this.f30833b;
    }
}
