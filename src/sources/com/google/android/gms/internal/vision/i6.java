package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i6<T> implements t6<T> {

    /* renamed from: a, reason: collision with root package name */
    public final c6 f25514a;

    /* renamed from: b, reason: collision with root package name */
    public final k7<?, ?> f25515b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f25516c;

    /* renamed from: d, reason: collision with root package name */
    public final n4<?> f25517d;

    public i6(k7<?, ?> k7Var, n4<?> n4Var, c6 c6Var) {
        this.f25515b = k7Var;
        this.f25516c = n4Var.e(c6Var);
        this.f25517d = n4Var;
        this.f25514a = c6Var;
    }

    public static <T> i6<T> h(k7<?, ?> k7Var, n4<?> n4Var, c6 c6Var) {
        return new i6<>(k7Var, n4Var, c6Var);
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final void a(T t2) {
        this.f25515b.j(t2);
        this.f25517d.g(t2);
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final int b(T t2) {
        int hashCode = this.f25515b.f(t2).hashCode();
        return this.f25516c ? (hashCode * 53) + this.f25517d.b(t2).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final boolean c(T t2) {
        return this.f25517d.b(t2).r();
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final boolean d(T t2, T t10) {
        if (!this.f25515b.f(t2).equals(this.f25515b.f(t10))) {
            return false;
        }
        if (this.f25516c) {
            return this.f25517d.b(t2).equals(this.f25517d.b(t10));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final void e(T t2, T t10) {
        u6.o(this.f25515b, t2, t10);
        if (this.f25516c) {
            u6.m(this.f25517d, t2, t10);
        }
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final void f(T t2, z7 z7Var) throws IOException {
        Iterator<Map.Entry<?, Object>> o10 = this.f25517d.b(t2).o();
        while (o10.hasNext()) {
            Map.Entry<?, Object> next = o10.next();
            s4 s4Var = (s4) next.getKey();
            if (s4Var.zzc() == zzmo.MESSAGE && !s4Var.zzd() && !s4Var.zze()) {
                if (next instanceof k5) {
                    z7Var.f(s4Var.zza(), ((k5) next).a().d());
                } else {
                    z7Var.f(s4Var.zza(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        k7<?, ?> k7Var = this.f25515b;
        k7Var.g(k7Var.f(t2), z7Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be A[EDGE_INSN: B:24:0x00be->B:25:0x00be BREAK  A[LOOP:1: B:10:0x0067->B:18:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.vision.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(T r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.vision.s3 r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.vision.x4 r0 = (com.google.android.gms.internal.vision.x4) r0
            com.google.android.gms.internal.vision.m7 r1 = r0.zzb
            com.google.android.gms.internal.vision.m7 r2 = com.google.android.gms.internal.vision.m7.a()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.vision.m7 r1 = com.google.android.gms.internal.vision.m7.g()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.vision.x4$c r11 = (com.google.android.gms.internal.vision.x4.c) r11
            com.google.android.gms.internal.vision.r4 r11 = r11.x()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Lc9
            int r4 = com.google.android.gms.internal.vision.r3.i(r12, r13, r15)
            int r13 = r15.f25631a
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L65
            r3 = r13 & 7
            if (r3 != r5) goto L60
            com.google.android.gms.internal.vision.n4<?> r2 = r10.f25517d
            com.google.android.gms.internal.vision.l4 r3 = r15.f25634d
            com.google.android.gms.internal.vision.c6 r5 = r10.f25514a
            int r6 = r13 >>> 3
            java.lang.Object r2 = r2.c(r3, r5, r6)
            r8 = r2
            com.google.android.gms.internal.vision.x4$e r8 = (com.google.android.gms.internal.vision.x4.e) r8
            if (r8 == 0) goto L55
            com.google.android.gms.internal.vision.p6 r13 = com.google.android.gms.internal.vision.p6.a()
            com.google.android.gms.internal.vision.c6 r2 = r8.f25681c
            java.lang.Class r2 = r2.getClass()
            com.google.android.gms.internal.vision.t6 r13 = r13.b(r2)
            int r13 = com.google.android.gms.internal.vision.r3.g(r13, r12, r4, r14, r15)
            com.google.android.gms.internal.vision.x4$f r2 = r8.f25682d
            java.lang.Object r3 = r15.f25633c
            r11.g(r2, r3)
            goto L5e
        L55:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.vision.r3.c(r2, r3, r4, r5, r6, r7)
        L5e:
            r2 = r8
            goto L19
        L60:
            int r13 = com.google.android.gms.internal.vision.r3.a(r13, r12, r4, r14, r15)
            goto L19
        L65:
            r13 = 0
            r3 = r0
        L67:
            if (r4 >= r14) goto Lbe
            int r4 = com.google.android.gms.internal.vision.r3.i(r12, r4, r15)
            int r6 = r15.f25631a
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto La0
            r9 = 3
            if (r7 == r9) goto L79
            goto Lb5
        L79:
            if (r2 == 0) goto L95
            com.google.android.gms.internal.vision.p6 r6 = com.google.android.gms.internal.vision.p6.a()
            com.google.android.gms.internal.vision.c6 r7 = r2.f25681c
            java.lang.Class r7 = r7.getClass()
            com.google.android.gms.internal.vision.t6 r6 = r6.b(r7)
            int r4 = com.google.android.gms.internal.vision.r3.g(r6, r12, r4, r14, r15)
            com.google.android.gms.internal.vision.x4$f r6 = r2.f25682d
            java.lang.Object r7 = r15.f25633c
            r11.g(r6, r7)
            goto L67
        L95:
            if (r8 != r5) goto Lb5
            int r4 = com.google.android.gms.internal.vision.r3.q(r12, r4, r15)
            java.lang.Object r3 = r15.f25633c
            com.google.android.gms.internal.vision.zzht r3 = (com.google.android.gms.internal.vision.zzht) r3
            goto L67
        La0:
            if (r8 != 0) goto Lb5
            int r4 = com.google.android.gms.internal.vision.r3.i(r12, r4, r15)
            int r13 = r15.f25631a
            com.google.android.gms.internal.vision.n4<?> r2 = r10.f25517d
            com.google.android.gms.internal.vision.l4 r6 = r15.f25634d
            com.google.android.gms.internal.vision.c6 r7 = r10.f25514a
            java.lang.Object r2 = r2.c(r6, r7, r13)
            com.google.android.gms.internal.vision.x4$e r2 = (com.google.android.gms.internal.vision.x4.e) r2
            goto L67
        Lb5:
            r7 = 12
            if (r6 == r7) goto Lbe
            int r4 = com.google.android.gms.internal.vision.r3.a(r6, r12, r4, r14, r15)
            goto L67
        Lbe:
            if (r3 == 0) goto Lc6
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.c(r13, r3)
        Lc6:
            r13 = r4
            goto L19
        Lc9:
            if (r13 != r14) goto Lcc
            return
        Lcc:
            com.google.android.gms.internal.vision.zzjk r11 = com.google.android.gms.internal.vision.zzjk.zzg()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.i6.g(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.s3):void");
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final T zza() {
        return (T) this.f25514a.zzq().zze();
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final int zzb(T t2) {
        k7<?, ?> k7Var = this.f25515b;
        int k10 = k7Var.k(k7Var.f(t2)) + 0;
        return this.f25516c ? k10 + this.f25517d.b(t2).s() : k10;
    }
}
