package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y1 {

    /* renamed from: a, reason: collision with root package name */
    public final zzin f25318a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f25319b;

    /* renamed from: c, reason: collision with root package name */
    public final p6 f25320c;

    /* renamed from: d, reason: collision with root package name */
    public final m6 f25321d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f25322e;

    /* renamed from: f, reason: collision with root package name */
    public final Integer f25323f;

    public /* synthetic */ y1(x1 x1Var, v1 v1Var) {
        this.f25318a = x1.h(x1Var);
        this.f25319b = x1.i(x1Var);
        this.f25320c = x1.j(x1Var);
        this.f25321d = x1.k(x1Var);
        this.f25322e = x1.l(x1Var);
        this.f25323f = x1.m(x1Var);
    }

    @Nullable
    @i1(zza = 1)
    public final zzin a() {
        return this.f25318a;
    }

    @Nullable
    @i1(zza = 2)
    public final Boolean b() {
        return this.f25319b;
    }

    @Nullable
    @i1(zza = 3)
    public final p6 c() {
        return this.f25320c;
    }

    @Nullable
    @i1(zza = 4)
    public final m6 d() {
        return this.f25321d;
    }

    @Nullable
    @i1(zza = 5)
    public final Integer e() {
        return this.f25322e;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        return com.google.android.gms.common.internal.g.a(this.f25318a, y1Var.f25318a) && com.google.android.gms.common.internal.g.a(this.f25319b, y1Var.f25319b) && com.google.android.gms.common.internal.g.a(this.f25320c, y1Var.f25320c) && com.google.android.gms.common.internal.g.a(this.f25321d, y1Var.f25321d) && com.google.android.gms.common.internal.g.a(this.f25322e, y1Var.f25322e) && com.google.android.gms.common.internal.g.a(this.f25323f, y1Var.f25323f);
    }

    @Nullable
    @i1(zza = 6)
    public final Integer f() {
        return this.f25323f;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.g.b(this.f25318a, this.f25319b, this.f25320c, this.f25321d, this.f25322e, this.f25323f);
    }
}
