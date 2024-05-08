package r4;

import java.util.concurrent.Executor;
import javax.inject.Provider;
import s4.o;

/* compiled from: DefaultScheduler_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements com.google.android.datatransport.runtime.dagger.internal.b<c> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<Executor> f53279a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<o4.d> f53280b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<o> f53281c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> f53282d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider<t4.a> f53283e;

    public d(Provider<Executor> provider, Provider<o4.d> provider2, Provider<o> provider3, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider4, Provider<t4.a> provider5) {
        this.f53279a = provider;
        this.f53280b = provider2;
        this.f53281c = provider3;
        this.f53282d = provider4;
        this.f53283e = provider5;
    }

    public static d a(Provider<Executor> provider, Provider<o4.d> provider2, Provider<o> provider3, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider4, Provider<t4.a> provider5) {
        return new d(provider, provider2, provider3, provider4, provider5);
    }

    public static c c(Executor executor, o4.d dVar, o oVar, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, t4.a aVar) {
        return new c(executor, dVar, oVar, bVar, aVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f53279a.get(), this.f53280b.get(), this.f53281c.get(), this.f53282d.get(), this.f53283e.get());
    }
}
