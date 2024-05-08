package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    private final p6 f31557a = new p6(o3.f31365l);

    public w1 a(s sVar, Map<l1, ?> map) throws a {
        t tVar = new t(sVar);
        try {
            try {
                return a(tVar, map);
            } catch (a unused) {
                tVar.e();
                tVar.a(true);
                tVar.d();
                tVar.c();
                tVar.a();
                w1 a10 = a(tVar, map);
                a10.a(new l6(true));
                return a10;
            }
        } catch (a unused2) {
            throw a.a();
        }
    }

    private w1 a(t tVar, Map<l1, ?> map) throws a {
        a8 d10 = tVar.d();
        c3 a10 = tVar.c().a();
        c1[] a11 = c1.a(tVar.b(), d10, a10);
        int i10 = 0;
        for (c1 c1Var : a11) {
            i10 += c1Var.b();
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (c1 c1Var2 : a11) {
            byte[] a12 = c1Var2.a();
            int b4 = c1Var2.b();
            a(a12, b4);
            int i12 = 0;
            while (i12 < b4) {
                bArr[i11] = a12[i12];
                i12++;
                i11++;
            }
        }
        return p1.a(bArr, d10, a10, map);
    }

    private void a(byte[] bArr, int i10) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f31557a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (a unused) {
            throw a.a();
        }
    }
}
