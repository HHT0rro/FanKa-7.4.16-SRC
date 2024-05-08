package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i4 implements z7 {

    /* renamed from: a, reason: collision with root package name */
    public final zzii f25513a;

    public i4(zzii zziiVar) {
        zzii zziiVar2 = (zzii) b5.f(zziiVar, "output");
        this.f25513a = zziiVar2;
        zziiVar2.f25771a = this;
    }

    public static i4 N(zzii zziiVar) {
        i4 i4Var = zziiVar.f25771a;
        return i4Var != null ? i4Var : new i4(zziiVar);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void A(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.s0(list.get(i13).intValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.W(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.f0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void B(int i10, List<zzht> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f25513a.o(i10, list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void C(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (list instanceof o5) {
            o5 o5Var = (o5) list;
            while (i11 < list.size()) {
                Object a10 = o5Var.a(i11);
                if (a10 instanceof String) {
                    this.f25513a.r(i10, (String) a10);
                } else {
                    this.f25513a.o(i10, (zzht) a10);
                }
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.r(i10, list.get(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void D(int i10, boolean z10) throws IOException {
        this.f25513a.s(i10, z10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void E(int i10, int i11) throws IOException {
        this.f25513a.P(i10, i11);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void F(int i10, long j10) throws IOException {
        this.f25513a.Y(i10, j10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void G(int i10, long j10) throws IOException {
        this.f25513a.Q(i10, j10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void H(int i10, zzht zzhtVar) throws IOException {
        this.f25513a.o(i10, zzhtVar);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final <K, V> void I(int i10, x5<K, V> x5Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f25513a.m(i10, 2);
            this.f25513a.O(v5.a(x5Var, entry.getKey(), entry.getValue()));
            v5.b(this.f25513a, x5Var, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void J(int i10, Object obj, t6 t6Var) throws IOException {
        this.f25513a.q(i10, (c6) obj, t6Var);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void K(int i10, Object obj, t6 t6Var) throws IOException {
        zzii zziiVar = this.f25513a;
        zziiVar.m(i10, 3);
        t6Var.f((c6) obj, zziiVar.f25771a);
        zziiVar.m(i10, 4);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void L(int i10, List<?> list, t6 t6Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            K(i10, list.get(i11), t6Var);
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void M(int i10, List<?> list, t6 t6Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            J(i10, list.get(i11), t6Var);
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void a(int i10) throws IOException {
        this.f25513a.m(i10, 4);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void b(int i10, long j10) throws IOException {
        this.f25513a.Y(i10, j10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void c(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.k0(list.get(i13).intValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.j(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.P(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void d(int i10, int i11) throws IOException {
        this.f25513a.P(i10, i11);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void e(int i10, long j10) throws IOException {
        this.f25513a.n(i10, j10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void f(int i10, Object obj) throws IOException {
        if (obj instanceof zzht) {
            this.f25513a.R(i10, (zzht) obj);
        } else {
            this.f25513a.p(i10, (c6) obj);
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void g(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.d0(list.get(i13).longValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.t(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.n(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void h(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.w0(list.get(i13).intValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.e0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.j0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void i(int i10, int i11) throws IOException {
        this.f25513a.j0(i10, i11);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void j(int i10, long j10) throws IOException {
        this.f25513a.n(i10, j10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void k(int i10, double d10) throws IOException {
        this.f25513a.k(i10, d10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void l(int i10, float f10) throws IOException {
        this.f25513a.l(i10, f10);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void m(int i10, int i11) throws IOException {
        this.f25513a.f0(i10, i11);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void n(int i10, int i11) throws IOException {
        this.f25513a.j0(i10, i11);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void o(int i10, int i11) throws IOException {
        this.f25513a.X(i10, i11);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void p(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.L(list.get(i13).booleanValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.y(list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.s(i10, list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void q(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.B0(list.get(i13).intValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.j(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.P(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void r(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.v0(list.get(i13).longValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.Z(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.Y(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void s(int i10, String str) throws IOException {
        this.f25513a.r(i10, str);
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void t(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.o0(list.get(i13).intValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.O(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.X(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void u(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.z0(list.get(i13).intValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.e0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.j0(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void v(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.r0(list.get(i13).longValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.Z(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.Y(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void w(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.i0(list.get(i13).longValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.t(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.n(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void x(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.z(list.get(i13).doubleValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.h(list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.k(i10, list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void y(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.A(list.get(i13).floatValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.i(list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.l(i10, list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void z(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.f25513a.m(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzii.n0(list.get(i13).longValue());
            }
            this.f25513a.O(i12);
            while (i11 < list.size()) {
                this.f25513a.S(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f25513a.Q(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final int zza() {
        return y7.f25707a;
    }

    @Override // com.google.android.gms.internal.vision.z7
    public final void zza(int i10) throws IOException {
        this.f25513a.m(i10, 3);
    }
}
