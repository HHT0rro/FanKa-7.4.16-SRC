package com.google.android.gms.internal.mlkit_vision_face;

import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x8 {

    /* renamed from: a, reason: collision with root package name */
    public final y6 f25315a;

    /* renamed from: b, reason: collision with root package name */
    public f8 f25316b = new f8();

    public x8(y6 y6Var) {
        this.f25315a = y6Var;
    }

    public static x8 c(y6 y6Var) {
        return new x8(y6Var);
    }

    public final byte[] a(int i10, boolean z10) {
        this.f25316b.i(Boolean.valueOf(i10 == 0));
        this.f25316b.g(Boolean.valueOf(z10));
        this.f25315a.a(this.f25316b.k());
        try {
            j9.a();
            if (i10 == 0) {
                return new c8.d().g(p5.f25142a).h(true).f().b(this.f25315a.f()).getBytes("utf-8");
            }
            z6 f10 = this.f25315a.f();
            m1 m1Var = new m1();
            p5.f25142a.a(m1Var);
            return m1Var.b().a(f10);
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e2);
        }
    }

    public final String b() {
        g8 a10 = this.f25315a.f().a();
        return (a10 == null || b.a(a10.d())) ? "NA" : (String) com.google.android.gms.common.internal.h.h(a10.d());
    }

    public final x8 d(f8 f8Var) {
        this.f25316b = f8Var;
        return this;
    }

    public final x8 e(zzio zzioVar) {
        this.f25315a.b(zzioVar);
        return this;
    }
}
