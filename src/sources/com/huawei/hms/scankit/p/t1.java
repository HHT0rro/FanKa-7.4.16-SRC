package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class t1 {

    /* renamed from: b, reason: collision with root package name */
    private z7 f31540b = null;

    /* renamed from: a, reason: collision with root package name */
    private final p6 f31539a = new p6(o3.f31366m);

    public w1 a(s sVar, Map<l1, ?> map) throws a {
        v vVar = new v(sVar);
        z7 a10 = vVar.a();
        this.f31540b = a10;
        e1[] a11 = e1.a(vVar.b(), a10);
        int i10 = 0;
        for (e1 e1Var : a11) {
            i10 += e1Var.b();
        }
        byte[] bArr = new byte[i10];
        int length = a11.length;
        for (int i11 = 0; i11 < length; i11++) {
            e1 e1Var2 = a11[i11];
            byte[] a12 = e1Var2.a();
            int b4 = e1Var2.b();
            a(a12, b4);
            for (int i12 = 0; i12 < b4; i12++) {
                bArr[(i12 * length) + i11] = a12[i12];
            }
        }
        return o1.a(bArr, map);
    }

    private void a(byte[] bArr, int i10) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f31539a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (a unused) {
            throw a.a();
        }
    }

    public z7 a() {
        return this.f31540b;
    }
}
