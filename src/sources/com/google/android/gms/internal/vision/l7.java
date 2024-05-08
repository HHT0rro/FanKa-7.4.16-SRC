package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l7 extends k7<m7, m7> {
    public static void m(Object obj, m7 m7Var) {
        ((x4) obj).zzb = m7Var;
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ m7 a() {
        return m7.g();
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ void b(m7 m7Var, int i10, long j10) {
        m7Var.c(i10 << 3, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ void c(m7 m7Var, int i10, zzht zzhtVar) {
        m7Var.c((i10 << 3) | 2, zzhtVar);
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ void d(m7 m7Var, z7 z7Var) throws IOException {
        m7Var.h(z7Var);
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* bridge */ /* synthetic */ void e(Object obj, m7 m7Var) {
        m(obj, m7Var);
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ m7 f(Object obj) {
        return ((x4) obj).zzb;
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ void g(m7 m7Var, z7 z7Var) throws IOException {
        m7Var.e(z7Var);
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ void h(Object obj, m7 m7Var) {
        m(obj, m7Var);
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ m7 i(m7 m7Var, m7 m7Var2) {
        m7 m7Var3 = m7Var;
        m7 m7Var4 = m7Var2;
        return m7Var4.equals(m7.a()) ? m7Var3 : m7.b(m7Var3, m7Var4);
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final void j(Object obj) {
        ((x4) obj).zzb.i();
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ int k(m7 m7Var) {
        return m7Var.j();
    }

    @Override // com.google.android.gms.internal.vision.k7
    public final /* synthetic */ int l(m7 m7Var) {
        return m7Var.k();
    }
}
