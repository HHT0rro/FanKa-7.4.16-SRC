package com.xiaomi.push;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class t2 {
    public abstract int a();

    public abstract t2 b(g0 g0Var);

    public t2 c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    public t2 d(byte[] bArr, int i10, int i11) {
        try {
            g0 g3 = g0.g(bArr, i10, i11);
            b(g3);
            g3.j(0);
            return this;
        } catch (d e2) {
            throw e2;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void e(c cVar);

    public void f(byte[] bArr, int i10, int i11) {
        try {
            c p10 = c.p(bArr, i10, i11);
            e(p10);
            p10.K();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public boolean g(g0 g0Var, int i10) {
        return g0Var.m(i10);
    }

    public byte[] h() {
        int i10 = i();
        byte[] bArr = new byte[i10];
        f(bArr, 0, i10);
        return bArr;
    }

    public abstract int i();
}
