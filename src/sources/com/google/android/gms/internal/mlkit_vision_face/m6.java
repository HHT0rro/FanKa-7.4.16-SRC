package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m6 {

    /* renamed from: a, reason: collision with root package name */
    public final zzhz f25073a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhx f25074b;

    /* renamed from: c, reason: collision with root package name */
    public final zzia f25075c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhy f25076d;

    /* renamed from: e, reason: collision with root package name */
    public final Boolean f25077e;

    /* renamed from: f, reason: collision with root package name */
    public final Float f25078f;

    public /* synthetic */ m6(k6 k6Var, j6 j6Var) {
        this.f25073a = k6.h(k6Var);
        this.f25074b = k6.i(k6Var);
        this.f25075c = k6.j(k6Var);
        this.f25076d = k6.k(k6Var);
        this.f25077e = k6.l(k6Var);
        this.f25078f = k6.m(k6Var);
    }

    @Nullable
    @i1(zza = 1)
    public final zzhz a() {
        return this.f25073a;
    }

    @Nullable
    @i1(zza = 2)
    public final zzhx b() {
        return this.f25074b;
    }

    @Nullable
    @i1(zza = 3)
    public final zzia c() {
        return this.f25075c;
    }

    @Nullable
    @i1(zza = 4)
    public final zzhy d() {
        return this.f25076d;
    }

    @Nullable
    @i1(zza = 5)
    public final Boolean e() {
        return this.f25077e;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m6)) {
            return false;
        }
        m6 m6Var = (m6) obj;
        return com.google.android.gms.common.internal.g.a(this.f25073a, m6Var.f25073a) && com.google.android.gms.common.internal.g.a(this.f25074b, m6Var.f25074b) && com.google.android.gms.common.internal.g.a(this.f25075c, m6Var.f25075c) && com.google.android.gms.common.internal.g.a(this.f25076d, m6Var.f25076d) && com.google.android.gms.common.internal.g.a(this.f25077e, m6Var.f25077e) && com.google.android.gms.common.internal.g.a(this.f25078f, m6Var.f25078f);
    }

    @Nullable
    @i1(zza = 6)
    public final Float f() {
        return this.f25078f;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.g.b(this.f25073a, this.f25074b, this.f25075c, this.f25076d, this.f25077e, this.f25078f);
    }
}
