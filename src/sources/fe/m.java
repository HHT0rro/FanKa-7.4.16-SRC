package fe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WorkQueue.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f49345b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f49346c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f49347d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f49348e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final AtomicReferenceArray<g> f49349a = new AtomicReferenceArray<>(128);

    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;

    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ g b(m mVar, g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return mVar.a(gVar, z10);
    }

    @Nullable
    public final g a(@NotNull g gVar, boolean z10) {
        if (z10) {
            return c(gVar);
        }
        g gVar2 = (g) f49345b.getAndSet(this, gVar);
        if (gVar2 == null) {
            return null;
        }
        return c(gVar2);
    }

    public final g c(g gVar) {
        if (gVar.f49334c.b() == 1) {
            f49348e.incrementAndGet(this);
        }
        if (e() == 127) {
            return gVar;
        }
        int i10 = this.producerIndex & 127;
        while (this.f49349a.get(i10) != null) {
            Thread.yield();
        }
        this.f49349a.lazySet(i10, gVar);
        f49346c.incrementAndGet(this);
        return null;
    }

    public final void d(g gVar) {
        if (gVar != null) {
            if (gVar.f49334c.b() == 1) {
                f49348e.decrementAndGet(this);
            }
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@NotNull c cVar) {
        g gVar = (g) f49345b.getAndSet(this, null);
        if (gVar != null) {
            cVar.a(gVar);
        }
        do {
        } while (j(cVar));
    }

    @Nullable
    public final g h() {
        g gVar = (g) f49345b.getAndSet(this, null);
        return gVar == null ? i() : gVar;
    }

    public final g i() {
        g andSet;
        while (true) {
            int i10 = this.consumerIndex;
            if (i10 - this.producerIndex == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f49347d.compareAndSet(this, i10, i10 + 1) && (andSet = this.f49349a.getAndSet(i11, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    public final boolean j(c cVar) {
        g i10 = i();
        if (i10 == null) {
            return false;
        }
        cVar.a(i10);
        return true;
    }

    public final long k(@NotNull m mVar) {
        int i10 = mVar.consumerIndex;
        int i11 = mVar.producerIndex;
        AtomicReferenceArray<g> atomicReferenceArray = mVar.f49349a;
        while (true) {
            if (i10 == i11) {
                break;
            }
            int i12 = i10 & 127;
            if (mVar.blockingTasksInBuffer == 0) {
                break;
            }
            g gVar = atomicReferenceArray.get(i12);
            if (gVar != null) {
                if ((gVar.f49334c.b() == 1) && atomicReferenceArray.compareAndSet(i12, gVar, null)) {
                    f49348e.decrementAndGet(mVar);
                    b(this, gVar, false, 2, null);
                    return -1L;
                }
            }
            i10++;
        }
        return m(mVar, true);
    }

    public final long l(@NotNull m mVar) {
        g i10 = mVar.i();
        if (i10 != null) {
            b(this, i10, false, 2, null);
            return -1L;
        }
        return m(mVar, false);
    }

    public final long m(m mVar, boolean z10) {
        g gVar;
        do {
            gVar = (g) mVar.lastScheduledTask;
            if (gVar == null) {
                return -2L;
            }
            if (z10) {
                if (!(gVar.f49334c.b() == 1)) {
                    return -2L;
                }
            }
            long a10 = k.f49341e.a() - gVar.f49333b;
            long j10 = k.f49337a;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!androidx.concurrent.futures.a.a(f49345b, mVar, gVar, null));
        b(this, gVar, false, 2, null);
        return -1L;
    }
}
