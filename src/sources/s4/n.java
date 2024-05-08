package s4;

import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: WorkInitializer_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n implements com.google.android.datatransport.runtime.dagger.internal.b<m> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<Executor> f53618a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> f53619b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<o> f53620c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider<t4.a> f53621d;

    public n(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider2, Provider<o> provider3, Provider<t4.a> provider4) {
        this.f53618a = provider;
        this.f53619b = provider2;
        this.f53620c = provider3;
        this.f53621d = provider4;
    }

    public static n a(Provider<Executor> provider, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider2, Provider<o> provider3, Provider<t4.a> provider4) {
        return new n(provider, provider2, provider3, provider4);
    }

    public static m c(Executor executor, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, o oVar, t4.a aVar) {
        return new m(executor, bVar, oVar, aVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m get() {
        return c(this.f53618a.get(), this.f53619b.get(), this.f53620c.get(), this.f53621d.get());
    }
}
