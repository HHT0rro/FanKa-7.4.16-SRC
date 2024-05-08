package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.z7;

/* compiled from: DataBlock.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class e1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f30919a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f30920b;

    private e1(int i10, byte[] bArr) {
        this.f30919a = i10;
        this.f30920b = bArr;
    }

    public static e1[] a(byte[] bArr, z7 z7Var) {
        z7.c d10 = z7Var.d();
        z7.b[] a10 = d10.a();
        int i10 = 0;
        for (z7.b bVar : a10) {
            i10 += bVar.a();
        }
        e1[] e1VarArr = new e1[i10];
        int i11 = 0;
        for (z7.b bVar2 : a10) {
            int i12 = 0;
            while (i12 < bVar2.a()) {
                int b4 = bVar2.b();
                e1VarArr[i11] = new e1(b4, new byte[d10.b() + b4]);
                i12++;
                i11++;
            }
        }
        int length = e1VarArr[0].f30920b.length - d10.b();
        int i13 = length - 1;
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            int i16 = 0;
            while (i16 < i11) {
                e1VarArr[i16].f30920b[i15] = bArr[i14];
                i16++;
                i14++;
            }
        }
        boolean z10 = z7Var.h() == 24;
        int i17 = z10 ? 8 : i11;
        int i18 = 0;
        while (i18 < i17) {
            e1VarArr[i18].f30920b[i13] = bArr[i14];
            i18++;
            i14++;
        }
        int length2 = e1VarArr[0].f30920b.length;
        while (length < length2) {
            int i19 = 0;
            while (i19 < i11) {
                int i20 = z10 ? (i19 + 8) % i11 : i19;
                e1VarArr[i20].f30920b[(!z10 || i20 <= 7) ? length : length - 1] = bArr[i14];
                i19++;
                i14++;
            }
            length++;
        }
        if (i14 == bArr.length) {
            return e1VarArr;
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.f30919a;
    }

    public byte[] a() {
        return this.f30920b;
    }
}
