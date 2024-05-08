package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p6 {

    /* renamed from: a, reason: collision with root package name */
    public final zzie f25143a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f25144b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f25145c;

    public /* synthetic */ p6(o6 o6Var, n6 n6Var) {
        zzie zzieVar;
        Integer num;
        zzieVar = o6Var.f25124a;
        this.f25143a = zzieVar;
        num = o6Var.f25125b;
        this.f25144b = num;
        this.f25145c = null;
    }

    @Nullable
    @i1(zza = 1)
    public final zzie a() {
        return this.f25143a;
    }

    @Nullable
    @i1(zza = 2)
    public final Integer b() {
        return this.f25144b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p6)) {
            return false;
        }
        p6 p6Var = (p6) obj;
        return com.google.android.gms.common.internal.g.a(this.f25143a, p6Var.f25143a) && com.google.android.gms.common.internal.g.a(this.f25144b, p6Var.f25144b) && com.google.android.gms.common.internal.g.a(null, null);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.g.b(this.f25143a, this.f25144b, null);
    }
}
