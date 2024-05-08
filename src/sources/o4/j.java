package o4;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: MetadataBackendRegistry_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j implements com.google.android.datatransport.runtime.dagger.internal.b<i> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<Context> f52285a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<g> f52286b;

    public j(Provider<Context> provider, Provider<g> provider2) {
        this.f52285a = provider;
        this.f52286b = provider2;
    }

    public static j a(Provider<Context> provider, Provider<g> provider2) {
        return new j(provider, provider2);
    }

    public static i c(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.f52285a.get(), this.f52286b.get());
    }
}
