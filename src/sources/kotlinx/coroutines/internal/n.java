package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: LimitedDispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n extends CoroutineDispatcher implements Runnable, m0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final CoroutineDispatcher f51401b;

    /* renamed from: c, reason: collision with root package name */
    public final int f51402c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m0 f51403d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final s<Runnable> f51404e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Object f51405f;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public n(@NotNull CoroutineDispatcher coroutineDispatcher, int i10) {
        this.f51401b = coroutineDispatcher;
        this.f51402c = i10;
        m0 m0Var = coroutineDispatcher instanceof m0 ? (m0) coroutineDispatcher : null;
        this.f51403d = m0Var == null ? kotlinx.coroutines.l0.a() : m0Var;
        this.f51404e = new s<>(false);
        this.f51405f = new Object();
    }

    public final boolean A() {
        synchronized (this.f51405f) {
            if (this.runningWorkers >= this.f51402c) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (x(runnable) || !A()) {
            return;
        }
        this.f51401b.dispatch(this, this);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (x(runnable) || !A()) {
            return;
        }
        this.f51401b.dispatchYield(this, this);
    }

    @Override // kotlinx.coroutines.m0
    public void k(long j10, @NotNull kotlinx.coroutines.l<? super kotlin.p> lVar) {
        this.f51403d.k(j10, lVar);
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public t0 l(long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return this.f51403d.l(j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int i10) {
        o.a(i10);
        return i10 >= this.f51402c ? this : super.limitedParallelism(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r1 = r4.f51405f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r4.f51404e.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = kotlin.p.f51048a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.s<java.lang.Runnable> r2 = r4.f51404e
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.e0.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            kotlinx.coroutines.CoroutineDispatcher r2 = r4.f51401b
            boolean r2 = r2.isDispatchNeeded(r4)
            if (r2 == 0) goto L2
            kotlinx.coroutines.CoroutineDispatcher r0 = r4.f51401b
            r0.dispatch(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.f51405f
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.s<java.lang.Runnable> r2 = r4.f51404e     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlin.p r2 = kotlin.p.f51048a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.run():void");
    }

    public final boolean x(Runnable runnable) {
        this.f51404e.a(runnable);
        return this.runningWorkers >= this.f51402c;
    }
}
