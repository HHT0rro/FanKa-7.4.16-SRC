package s4;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: Uploader_Factory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j implements com.google.android.datatransport.runtime.dagger.internal.b<i> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<Context> f53605a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<o4.d> f53606b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> f53607c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider<o> f53608d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider<Executor> f53609e;

    /* renamed from: f, reason: collision with root package name */
    public final Provider<t4.a> f53610f;

    /* renamed from: g, reason: collision with root package name */
    public final Provider<u4.a> f53611g;

    public j(Provider<Context> provider, Provider<o4.d> provider2, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider3, Provider<o> provider4, Provider<Executor> provider5, Provider<t4.a> provider6, Provider<u4.a> provider7) {
        this.f53605a = provider;
        this.f53606b = provider2;
        this.f53607c = provider3;
        this.f53608d = provider4;
        this.f53609e = provider5;
        this.f53610f = provider6;
        this.f53611g = provider7;
    }

    public static j a(Provider<Context> provider, Provider<o4.d> provider2, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider3, Provider<o> provider4, Provider<Executor> provider5, Provider<t4.a> provider6, Provider<u4.a> provider7) {
        return new j(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static i c(Context context, o4.d dVar, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, o oVar, Executor executor, t4.a aVar, u4.a aVar2) {
        return new i(context, dVar, bVar, oVar, executor, aVar, aVar2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.f53605a.get(), this.f53606b.get(), this.f53607c.get(), this.f53608d.get(), this.f53609e.get(), this.f53610f.get(), this.f53611g.get());
    }
}
