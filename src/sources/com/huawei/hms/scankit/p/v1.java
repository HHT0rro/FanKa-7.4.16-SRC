package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    private final p6 f31606a = new p6(o3.f31365l);

    public w1 a(s sVar, Map<l1, ?> map) throws a {
        u uVar = new u(sVar);
        try {
            return a(uVar, map);
        } catch (a e2) {
            try {
                uVar.e();
                uVar.a(true);
                uVar.d();
                uVar.c();
                uVar.a();
                w1 a10 = a(uVar, map);
                a10.a(new i6(true));
                return a10;
            } catch (a unused) {
                throw e2;
            }
        }
    }

    private w1 a(u uVar, Map<l1, ?> map) throws a {
        b8 d10 = uVar.d();
        b3 b4 = uVar.c().b();
        d1[] a10 = d1.a(uVar.b(), d10, b4);
        int i10 = 0;
        for (d1 d1Var : a10) {
            i10 += d1Var.b();
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (d1 d1Var2 : a10) {
            byte[] a11 = d1Var2.a();
            int b10 = d1Var2.b();
            a(a11, b10);
            int i12 = 0;
            while (i12 < b10) {
                bArr[i11] = a11[i12];
                i12++;
                i11++;
            }
        }
        return r1.a(bArr, d10, b4, map);
    }

    private void a(byte[] bArr, int i10) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f31606a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (a unused) {
            throw a.a();
        }
    }
}
