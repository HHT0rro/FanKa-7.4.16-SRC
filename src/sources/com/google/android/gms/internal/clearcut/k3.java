package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k3 extends i3<j3, j3> {
    public static void m(Object obj, j3 j3Var) {
        ((x0) obj).zzjp = j3Var;
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ void a(j3 j3Var, int i10, long j10) {
        j3Var.e(i10 << 3, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ void b(j3 j3Var, int i10, zzbb zzbbVar) {
        j3Var.e((i10 << 3) | 2, zzbbVar);
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ void c(j3 j3Var, w3 w3Var) throws IOException {
        j3Var.g(w3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final void d(Object obj) {
        ((x0) obj).zzjp.k();
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ void e(j3 j3Var, w3 w3Var) throws IOException {
        j3Var.b(w3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ j3 f() {
        return j3.i();
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ void g(Object obj, j3 j3Var) {
        m(obj, j3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ void h(Object obj, j3 j3Var) {
        m(obj, j3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ j3 i(j3 j3Var, j3 j3Var2) {
        j3 j3Var3 = j3Var;
        j3 j3Var4 = j3Var2;
        return j3Var4.equals(j3.h()) ? j3Var3 : j3.a(j3Var3, j3Var4);
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ int j(j3 j3Var) {
        return j3Var.d();
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ j3 k(Object obj) {
        return ((x0) obj).zzjp;
    }

    @Override // com.google.android.gms.internal.clearcut.i3
    public final /* synthetic */ int l(j3 j3Var) {
        return j3Var.j();
    }
}
