package n4;

import javax.inject.Provider;

/* compiled from: TransportRuntime_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m implements com.google.android.datatransport.runtime.dagger.internal.b<com.google.android.datatransport.runtime.d> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<u4.a> f52122a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<u4.a> f52123b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<r4.e> f52124c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider<s4.i> f52125d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider<s4.m> f52126e;

    public m(Provider<u4.a> provider, Provider<u4.a> provider2, Provider<r4.e> provider3, Provider<s4.i> provider4, Provider<s4.m> provider5) {
        this.f52122a = provider;
        this.f52123b = provider2;
        this.f52124c = provider3;
        this.f52125d = provider4;
        this.f52126e = provider5;
    }

    public static m a(Provider<u4.a> provider, Provider<u4.a> provider2, Provider<r4.e> provider3, Provider<s4.i> provider4, Provider<s4.m> provider5) {
        return new m(provider, provider2, provider3, provider4, provider5);
    }

    public static com.google.android.datatransport.runtime.d c(u4.a aVar, u4.a aVar2, r4.e eVar, s4.i iVar, s4.m mVar) {
        return new com.google.android.datatransport.runtime.d(aVar, aVar2, eVar, iVar, mVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.android.datatransport.runtime.d get() {
        return c(this.f52122a.get(), this.f52123b.get(), this.f52124c.get(), this.f52125d.get(), this.f52126e.get());
    }
}
