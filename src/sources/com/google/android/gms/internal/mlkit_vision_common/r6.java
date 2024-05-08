package com.google.android.gms.internal.mlkit_vision_common;

import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r6 {

    /* renamed from: a, reason: collision with root package name */
    public final t4 f24608a;

    /* renamed from: b, reason: collision with root package name */
    public z5 f24609b = new z5();

    public r6(t4 t4Var) {
        this.f24608a = t4Var;
    }

    public static r6 c(t4 t4Var) {
        return new r6(t4Var);
    }

    public final byte[] a(int i10, boolean z10) {
        this.f24609b.i(Boolean.valueOf(i10 == 0));
        this.f24609b.g(Boolean.valueOf(z10));
        this.f24608a.a(this.f24609b.k());
        try {
            f7.a();
            if (i10 == 0) {
                return new c8.d().g(q3.f24582a).h(true).f().b(this.f24608a.d()).getBytes("utf-8");
            }
            u4 d10 = this.f24608a.d();
            o oVar = new o();
            q3.f24582a.a(oVar);
            return oVar.b().a(d10);
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e2);
        }
    }

    public final String b() {
        a6 a10 = this.f24608a.d().a();
        return (a10 == null || c5.a(a10.d())) ? "NA" : (String) com.google.android.gms.common.internal.h.h(a10.d());
    }

    public final r6 d(z5 z5Var) {
        this.f24609b = z5Var;
        return this;
    }

    public final r6 e(zzfp zzfpVar) {
        this.f24608a.b(zzfpVar);
        return this;
    }
}
