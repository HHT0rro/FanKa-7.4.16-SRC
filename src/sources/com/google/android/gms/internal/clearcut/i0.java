package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i0 implements w3 {

    /* renamed from: a, reason: collision with root package name */
    public final zzbn f23915a;

    public i0(zzbn zzbnVar) {
        zzbn zzbnVar2 = (zzbn) z0.e(zzbnVar, "output");
        this.f23915a = zzbnVar2;
        zzbnVar2.f24132a = this;
    }

    public static i0 a(zzbn zzbnVar) {
        i0 i0Var = zzbnVar.f24132a;
        return i0Var != null ? i0Var : new i0(zzbnVar);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void A(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.f0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.E0(list.get(i13).intValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.z0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void B(int i10, List<zzbb> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f23915a.m(i10, list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void C(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (!(list instanceof j1)) {
            while (i11 < list.size()) {
                this.f23915a.p(i10, list.get(i11));
                i11++;
            }
            return;
        }
        j1 j1Var = (j1) list;
        while (i11 < list.size()) {
            Object raw = j1Var.getRaw(i11);
            if (raw instanceof String) {
                this.f23915a.p(i10, (String) raw);
            } else {
                this.f23915a.m(i10, (zzbb) raw);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void D(int i10, boolean z10) throws IOException {
        this.f23915a.K(i10, z10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void E(int i10, long j10) throws IOException {
        this.f23915a.U(i10, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void F(int i10, long j10) throws IOException {
        this.f23915a.l(i10, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void G(int i10, int i11) throws IOException {
        this.f23915a.T(i10, i11);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void H(int i10) throws IOException {
        this.f23915a.G(i10, 3);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void I(int i10, int i11) throws IOException {
        this.f23915a.i0(i10, i11);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void J(int i10, List<?> list, r2 r2Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            O(i10, list.get(i11), r2Var);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void K(int i10, List<?> list, r2 r2Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            N(i10, list.get(i11), r2Var);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void L(int i10) throws IOException {
        this.f23915a.G(i10, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void M(int i10, zzbb zzbbVar) throws IOException {
        this.f23915a.m(i10, zzbbVar);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void N(int i10, Object obj, r2 r2Var) throws IOException {
        this.f23915a.o(i10, (a2) obj, r2Var);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void O(int i10, Object obj, r2 r2Var) throws IOException {
        zzbn zzbnVar = this.f23915a;
        zzbnVar.G(i10, 3);
        r2Var.b((a2) obj, zzbnVar.f24132a);
        zzbnVar.G(i10, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final int P() {
        return x0.e.f24092l;
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final <K, V> void Q(int i10, u1<K, V> u1Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f23915a.G(i10, 2);
            this.f23915a.y0(t1.a(u1Var, entry.getKey(), entry.getValue()));
            t1.b(this.f23915a, u1Var, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void b(int i10, long j10) throws IOException {
        this.f23915a.H(i10, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void c(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.T(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.C0(list.get(i13).intValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.x0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void d(int i10, int i11) throws IOException {
        this.f23915a.T(i10, i11);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void e(int i10, long j10) throws IOException {
        this.f23915a.U(i10, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void f(int i10, Object obj) throws IOException {
        if (obj instanceof zzbb) {
            this.f23915a.I(i10, (zzbb) obj);
        } else {
            this.f23915a.J(i10, (a2) obj);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void g(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.l(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.e0(list.get(i13).longValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.L(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void h(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.i0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.F0(list.get(i13).intValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.A0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void j(int i10, long j10) throws IOException {
        this.f23915a.l(i10, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void k(int i10, double d10) throws IOException {
        this.f23915a.j(i10, d10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void l(int i10, float f10) throws IOException {
        this.f23915a.k(i10, f10);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void m(int i10, int i11) throws IOException {
        this.f23915a.i0(i10, i11);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void n(int i10, int i11) throws IOException {
        this.f23915a.b0(i10, i11);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void o(int i10, int i11) throws IOException {
        this.f23915a.f0(i10, i11);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void p(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.K(i10, list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.F(list.get(i13).booleanValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.t(list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void q(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.T(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.H0(list.get(i13).intValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.x0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void r(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.U(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.s0(list.get(i13).longValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.c0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void s(int i10, String str) throws IOException {
        this.f23915a.p(i10, str);
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void t(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.b0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.D0(list.get(i13).intValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.y0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void u(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.i0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.G0(list.get(i13).intValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.A0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void v(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.U(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.p0(list.get(i13).longValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.c0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void w(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.l(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.h0(list.get(i13).longValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.L(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void x(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.j(i10, list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.w(list.get(i13).doubleValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.h(list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void y(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.k(i10, list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.x(list.get(i13).floatValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.i(list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.w3
    public final void z(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f23915a.H(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f23915a.G(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += zzbn.l0(list.get(i13).longValue());
        }
        this.f23915a.y0(i12);
        while (i11 < list.size()) {
            this.f23915a.V(list.get(i11).longValue());
            i11++;
        }
    }
}
