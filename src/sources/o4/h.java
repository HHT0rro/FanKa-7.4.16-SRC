package o4;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: CreationContextFactory_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements com.google.android.datatransport.runtime.dagger.internal.b<g> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<Context> f52277a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<u4.a> f52278b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<u4.a> f52279c;

    public h(Provider<Context> provider, Provider<u4.a> provider2, Provider<u4.a> provider3) {
        this.f52277a = provider;
        this.f52278b = provider2;
        this.f52279c = provider3;
    }

    public static h a(Provider<Context> provider, Provider<u4.a> provider2, Provider<u4.a> provider3) {
        return new h(provider, provider2, provider3);
    }

    public static g c(Context context, u4.a aVar, u4.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c(this.f52277a.get(), this.f52278b.get(), this.f52279c.get());
    }
}
