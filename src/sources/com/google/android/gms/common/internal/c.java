package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class c<T extends IInterface> extends BaseGmsClient<T> implements a.f {
    public final b E;
    public final Set<Scope> F;

    @Nullable
    public final Account G;

    public c(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i10, @RecentlyNonNull b bVar, @RecentlyNonNull com.google.android.gms.common.api.internal.f fVar, @RecentlyNonNull com.google.android.gms.common.api.internal.k kVar) {
        this(context, looper, d.b(context), com.google.android.gms.common.a.m(), i10, bVar, (com.google.android.gms.common.api.internal.f) h.h(fVar), (com.google.android.gms.common.api.internal.k) h.h(kVar));
    }

    @Nullable
    public static BaseGmsClient.a f0(@Nullable com.google.android.gms.common.api.internal.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new m(fVar);
    }

    @Nullable
    public static BaseGmsClient.b g0(@Nullable com.google.android.gms.common.api.internal.k kVar) {
        if (kVar == null) {
            return null;
        }
        return new n(kVar);
    }

    @Override // com.google.android.gms.common.api.a.f
    @NonNull
    public Set<Scope> e() {
        return c() ? this.F : Collections.emptySet();
    }

    @NonNull
    public Set<Scope> e0(@RecentlyNonNull Set<Scope> set) {
        return set;
    }

    public final Set<Scope> h0(@NonNull Set<Scope> set) {
        Set<Scope> e02 = e0(set);
        Iterator<Scope> iterator2 = e02.iterator2();
        while (iterator2.hasNext()) {
            if (!set.contains(iterator2.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return e02;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNullable
    public final Account q() {
        return this.G;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public final Set<Scope> w() {
        return this.F;
    }

    @Deprecated
    public c(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i10, @RecentlyNonNull b bVar, @RecentlyNonNull GoogleApiClient.a aVar, @RecentlyNonNull GoogleApiClient.b bVar2) {
        this(context, looper, i10, bVar, (com.google.android.gms.common.api.internal.f) aVar, (com.google.android.gms.common.api.internal.k) bVar2);
    }

    public c(Context context, Looper looper, d dVar, com.google.android.gms.common.a aVar, int i10, b bVar, @Nullable com.google.android.gms.common.api.internal.f fVar, @Nullable com.google.android.gms.common.api.internal.k kVar) {
        super(context, looper, dVar, aVar, i10, f0(fVar), g0(kVar), bVar.g());
        this.E = bVar;
        this.G = bVar.a();
        this.F = h0(bVar.c());
    }
}
