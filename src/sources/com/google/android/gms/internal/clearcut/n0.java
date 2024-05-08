package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;
import java.io.IOException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n0 extends m0<x0.d> {
    @Override // com.google.android.gms.internal.clearcut.m0
    public final int a(Map.Entry<?, ?> entry) {
        return ((x0.d) entry.getKey()).f24079b;
    }

    @Override // com.google.android.gms.internal.clearcut.m0
    public final q0<x0.d> b(Object obj) {
        return ((x0.c) obj).zzjv;
    }

    @Override // com.google.android.gms.internal.clearcut.m0
    public final void c(w3 w3Var, Map.Entry<?, ?> entry) throws IOException {
        x0.d dVar = (x0.d) entry.getKey();
        switch (o0.f23969a[dVar.f24080c.ordinal()]) {
            case 1:
                w3Var.k(dVar.f24079b, ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                w3Var.l(dVar.f24079b, ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                w3Var.F(dVar.f24079b, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                w3Var.j(dVar.f24079b, ((Long) entry.getValue()).longValue());
                return;
            case 5:
                w3Var.d(dVar.f24079b, ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                w3Var.e(dVar.f24079b, ((Long) entry.getValue()).longValue());
                return;
            case 7:
                w3Var.m(dVar.f24079b, ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                w3Var.D(dVar.f24079b, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                w3Var.n(dVar.f24079b, ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                w3Var.I(dVar.f24079b, ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                w3Var.E(dVar.f24079b, ((Long) entry.getValue()).longValue());
                return;
            case 12:
                w3Var.o(dVar.f24079b, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                w3Var.b(dVar.f24079b, ((Long) entry.getValue()).longValue());
                return;
            case 14:
                w3Var.d(dVar.f24079b, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                w3Var.M(dVar.f24079b, (zzbb) entry.getValue());
                return;
            case 16:
                w3Var.s(dVar.f24079b, (String) entry.getValue());
                return;
            case 17:
                w3Var.O(dVar.f24079b, entry.getValue(), m2.a().b(entry.getValue().getClass()));
                return;
            case 18:
                w3Var.N(dVar.f24079b, entry.getValue(), m2.a().b(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.m0
    public final void d(Object obj, q0<x0.d> q0Var) {
        ((x0.c) obj).zzjv = q0Var;
    }

    @Override // com.google.android.gms.internal.clearcut.m0
    public final q0<x0.d> e(Object obj) {
        q0<x0.d> b4 = b(obj);
        if (!b4.c()) {
            return b4;
        }
        q0<x0.d> q0Var = (q0) b4.clone();
        d(obj, q0Var);
        return q0Var;
    }

    @Override // com.google.android.gms.internal.clearcut.m0
    public final void f(Object obj) {
        b(obj).t();
    }

    @Override // com.google.android.gms.internal.clearcut.m0
    public final boolean g(a2 a2Var) {
        return a2Var instanceof x0.c;
    }
}
