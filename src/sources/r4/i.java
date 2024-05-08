package r4;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import javax.inject.Provider;
import s4.o;

/* compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements com.google.android.datatransport.runtime.dagger.internal.b<o> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<Context> f53285a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> f53286b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider<SchedulerConfig> f53287c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider<u4.a> f53288d;

    public i(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider2, Provider<SchedulerConfig> provider3, Provider<u4.a> provider4) {
        this.f53285a = provider;
        this.f53286b = provider2;
        this.f53287c = provider3;
        this.f53288d = provider4;
    }

    public static i a(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.scheduling.persistence.b> provider2, Provider<SchedulerConfig> provider3, Provider<u4.a> provider4) {
        return new i(provider, provider2, provider3, provider4);
    }

    public static o c(Context context, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, SchedulerConfig schedulerConfig, u4.a aVar) {
        return (o) com.google.android.datatransport.runtime.dagger.internal.d.c(h.a(context, bVar, schedulerConfig, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o get() {
        return c(this.f53285a.get(), this.f53286b.get(), this.f53287c.get(), this.f53288d.get());
    }
}
