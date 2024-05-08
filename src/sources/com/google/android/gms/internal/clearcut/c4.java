package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class c4 {

    /* renamed from: b, reason: collision with root package name */
    public volatile int f23837b = -1;

    public static final void c(c4 c4Var, byte[] bArr, int i10, int i11) {
        try {
            x3 t2 = x3.t(bArr, 0, i11);
            c4Var.a(t2);
            t2.p();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public void a(x3 x3Var) throws IOException {
    }

    public final int d() {
        int e2 = e();
        this.f23837b = e2;
        return e2;
    }

    public int e() {
        return 0;
    }

    @Override // 
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public c4 clone() throws CloneNotSupportedException {
        return (c4) super.clone();
    }

    public String toString() {
        return d4.a(this);
    }
}
