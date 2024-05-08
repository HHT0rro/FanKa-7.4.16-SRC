package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f2<T> implements r2<T> {

    /* renamed from: a, reason: collision with root package name */
    public final a2 f23893a;

    /* renamed from: b, reason: collision with root package name */
    public final i3<?, ?> f23894b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23895c;

    /* renamed from: d, reason: collision with root package name */
    public final m0<?> f23896d;

    public f2(i3<?, ?> i3Var, m0<?> m0Var, a2 a2Var) {
        this.f23894b = i3Var;
        this.f23895c = m0Var.g(a2Var);
        this.f23896d = m0Var;
        this.f23893a = a2Var;
    }

    public static <T> f2<T> g(i3<?, ?> i3Var, m0<?> m0Var, a2 a2Var) {
        return new f2<>(i3Var, m0Var, a2Var);
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final void a(T t2) {
        this.f23894b.d(t2);
        this.f23896d.f(t2);
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final void b(T t2, w3 w3Var) throws IOException {
        Iterator<Map.Entry<?, Object>> e2 = this.f23896d.b(t2).e();
        while (e2.hasNext()) {
            Map.Entry<?, Object> next = e2.next();
            t0 t0Var = (t0) next.getKey();
            if (t0Var.b0() != zzfq.MESSAGE || t0Var.c0() || t0Var.a0()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            w3Var.f(t0Var.zzc(), next instanceof f1 ? ((f1) next).a().d() : next.getValue());
        }
        i3<?, ?> i3Var = this.f23894b;
        i3Var.e(i3Var.k(t2), w3Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[EDGE_INSN: B:24:0x0061->B:25:0x0061 BREAK  A[LOOP:1: B:10:0x0032->B:18:0x0032], SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(T r8, byte[] r9, int r10, int r11, com.google.android.gms.internal.clearcut.w r12) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.clearcut.x0 r8 = (com.google.android.gms.internal.clearcut.x0) r8
            com.google.android.gms.internal.clearcut.j3 r0 = r8.zzjp
            com.google.android.gms.internal.clearcut.j3 r1 = com.google.android.gms.internal.clearcut.j3.h()
            if (r0 != r1) goto L10
            com.google.android.gms.internal.clearcut.j3 r0 = com.google.android.gms.internal.clearcut.j3.i()
            r8.zzjp = r0
        L10:
            r8 = r0
        L11:
            if (r10 >= r11) goto L6b
            int r2 = com.google.android.gms.internal.clearcut.v.e(r9, r10, r12)
            int r0 = r12.f24064a
            r10 = 11
            r1 = 2
            if (r0 == r10) goto L30
            r10 = r0 & 7
            if (r10 != r1) goto L2b
            r1 = r9
            r3 = r11
            r4 = r8
            r5 = r12
            int r10 = com.google.android.gms.internal.clearcut.v.c(r0, r1, r2, r3, r4, r5)
            goto L11
        L2b:
            int r10 = com.google.android.gms.internal.clearcut.v.a(r0, r9, r2, r11, r12)
            goto L11
        L30:
            r10 = 0
            r0 = 0
        L32:
            if (r2 >= r11) goto L61
            int r2 = com.google.android.gms.internal.clearcut.v.e(r9, r2, r12)
            int r3 = r12.f24064a
            int r4 = r3 >>> 3
            r5 = r3 & 7
            if (r4 == r1) goto L4f
            r6 = 3
            if (r4 == r6) goto L44
            goto L58
        L44:
            if (r5 != r1) goto L58
            int r2 = com.google.android.gms.internal.clearcut.v.m(r9, r2, r12)
            java.lang.Object r0 = r12.f24066c
            com.google.android.gms.internal.clearcut.zzbb r0 = (com.google.android.gms.internal.clearcut.zzbb) r0
            goto L32
        L4f:
            if (r5 != 0) goto L58
            int r2 = com.google.android.gms.internal.clearcut.v.e(r9, r2, r12)
            int r10 = r12.f24064a
            goto L32
        L58:
            r4 = 12
            if (r3 == r4) goto L61
            int r2 = com.google.android.gms.internal.clearcut.v.a(r3, r9, r2, r11, r12)
            goto L32
        L61:
            if (r0 == 0) goto L69
            int r10 = r10 << 3
            r10 = r10 | r1
            r8.e(r10, r0)
        L69:
            r10 = r2
            goto L11
        L6b:
            if (r10 != r11) goto L6e
            return
        L6e:
            com.google.android.gms.internal.clearcut.zzco r8 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.f2.c(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.w):void");
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final boolean d(T t2) {
        return this.f23896d.b(t2).d();
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final void e(T t2, T t10) {
        t2.i(this.f23894b, t2, t10);
        if (this.f23895c) {
            t2.g(this.f23896d, t2, t10);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final boolean equals(T t2, T t10) {
        if (!this.f23894b.k(t2).equals(this.f23894b.k(t10))) {
            return false;
        }
        if (this.f23895c) {
            return this.f23896d.b(t2).equals(this.f23896d.b(t10));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final int f(T t2) {
        i3<?, ?> i3Var = this.f23894b;
        int l10 = i3Var.l(i3Var.k(t2)) + 0;
        return this.f23895c ? l10 + this.f23896d.b(t2).m() : l10;
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final int hashCode(T t2) {
        int hashCode = this.f23894b.k(t2).hashCode();
        return this.f23895c ? (hashCode * 53) + this.f23896d.b(t2).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.clearcut.r2
    public final T newInstance() {
        return (T) this.f23893a.c().G();
    }
}
