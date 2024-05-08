package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: SchemaManager_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g0 implements com.google.android.datatransport.runtime.dagger.internal.b<f0> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<Context> f19452a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<String> f19453b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<Integer> f19454c;

    public g0(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f19452a = provider;
        this.f19453b = provider2;
        this.f19454c = provider3;
    }

    public static g0 a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new g0(provider, provider2, provider3);
    }

    public static f0 c(Context context, String str, int i10) {
        return new f0(context, str, i10);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f0 get() {
        return c(this.f19452a.get(), this.f19453b.get(), this.f19454c.get().intValue());
    }
}
