package r4;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import javax.inject.Provider;

/* compiled from: SchedulingConfigModule_ConfigFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements com.google.android.datatransport.runtime.dagger.internal.b<SchedulerConfig> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider<u4.a> f53284a;

    public g(Provider<u4.a> provider) {
        this.f53284a = provider;
    }

    public static SchedulerConfig a(u4.a aVar) {
        return (SchedulerConfig) com.google.android.datatransport.runtime.dagger.internal.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(Provider<u4.a> provider) {
        return new g(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a(this.f53284a.get());
    }
}
