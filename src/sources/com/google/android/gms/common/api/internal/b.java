package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b<O extends a.d> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f23410a = false;

    /* renamed from: b, reason: collision with root package name */
    public final int f23411b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.a<O> f23412c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final O f23413d;

    public b(com.google.android.gms.common.api.a<O> aVar, @Nullable O o10) {
        this.f23412c = aVar;
        this.f23413d = o10;
        this.f23411b = com.google.android.gms.common.internal.g.b(aVar, o10);
    }

    @RecentlyNonNull
    public static <O extends a.d> b<O> b(@RecentlyNonNull com.google.android.gms.common.api.a<O> aVar, @Nullable O o10) {
        return new b<>(aVar, o10);
    }

    @RecentlyNonNull
    public final String a() {
        return this.f23412c.c();
    }

    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return com.google.android.gms.common.internal.g.a(this.f23412c, bVar.f23412c) && com.google.android.gms.common.internal.g.a(this.f23413d, bVar.f23413d);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.f23411b;
    }
}
