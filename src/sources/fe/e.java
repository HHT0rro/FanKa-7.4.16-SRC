package fe;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

/* compiled from: Dispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e extends ExecutorCoroutineDispatcher {

    /* renamed from: c, reason: collision with root package name */
    public final int f49328c;

    /* renamed from: d, reason: collision with root package name */
    public final int f49329d;

    /* renamed from: e, reason: collision with root package name */
    public final long f49330e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final String f49331f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public CoroutineScheduler f49332g = x();

    public e(int i10, int i11, long j10, @NotNull String str) {
        this.f49328c = i10;
        this.f49329d = i11;
        this.f49330e = j10;
        this.f49331f = str;
    }

    public final void A(@NotNull Runnable runnable, @NotNull h hVar, boolean z10) {
        this.f49332g.f(runnable, hVar, z10);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        CoroutineScheduler.g(this.f49332g, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        CoroutineScheduler.g(this.f49332g, runnable, null, true, 2, null);
    }

    public final CoroutineScheduler x() {
        return new CoroutineScheduler(this.f49328c, this.f49329d, this.f49330e, this.f49331f);
    }
}
