package com.google.android.datatransport.runtime.scheduling.persistence;

import javax.inject.Provider;

/* compiled from: SQLiteEventStore_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a0 implements com.google.android.datatransport.runtime.dagger.internal.b<z> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<u4.a> f19432a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<u4.a> f19433b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<c> f19434c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider<f0> f19435d;

    public a0(Provider<u4.a> provider, Provider<u4.a> provider2, Provider<c> provider3, Provider<f0> provider4) {
        this.f19432a = provider;
        this.f19433b = provider2;
        this.f19434c = provider3;
        this.f19435d = provider4;
    }

    public static a0 a(Provider<u4.a> provider, Provider<u4.a> provider2, Provider<c> provider3, Provider<f0> provider4) {
        return new a0(provider, provider2, provider3, provider4);
    }

    public static z c(u4.a aVar, u4.a aVar2, Object obj, Object obj2) {
        return new z(aVar, aVar2, (c) obj, (f0) obj2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z get() {
        return c(this.f19432a.get(), this.f19433b.get(), this.f19434c.get(), this.f19435d.get());
    }
}
