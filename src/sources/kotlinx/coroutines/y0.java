package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventLoop.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class y0 extends z0 implements m0 {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51568e = AtomicReferenceFieldUpdater.newUpdater(y0.class, Object.class, "_queue");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51569f = AtomicReferenceFieldUpdater.newUpdater(y0.class, Object.class, "_delayed");

    @NotNull
    private volatile /* synthetic */ Object _queue = null;

    @NotNull
    private volatile /* synthetic */ Object _delayed = null;

    @NotNull
    private volatile /* synthetic */ int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class a extends c {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public final l<kotlin.p> f51570d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, @NotNull l<? super kotlin.p> lVar) {
            super(j10);
            this.f51570d = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f51570d.C(y0.this, kotlin.p.f51048a);
        }

        @Override // kotlinx.coroutines.y0.c
        @NotNull
        public String toString() {
            return super.toString() + ((Object) this.f51570d);
        }
    }

    /* compiled from: EventLoop.common.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b extends c {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public final Runnable f51572d;

        public b(long j10, @NotNull Runnable runnable) {
            super(j10);
            this.f51572d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f51572d.run();
        }

        @Override // kotlinx.coroutines.y0.c
        @NotNull
        public String toString() {
            return super.toString() + ((Object) this.f51572d);
        }
    }

    /* compiled from: EventLoop.common.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class c implements Runnable, Comparable<c>, t0, kotlinx.coroutines.internal.k0 {

        @Nullable
        private volatile Object _heap;

        /* renamed from: b, reason: collision with root package name */
        public long f51573b;

        /* renamed from: c, reason: collision with root package name */
        public int f51574c = -1;

        public c(long j10) {
            this.f51573b = j10;
        }

        @Override // kotlinx.coroutines.internal.k0
        public void a(@Nullable kotlinx.coroutines.internal.j0<?> j0Var) {
            kotlinx.coroutines.internal.f0 f0Var;
            Object obj = this._heap;
            f0Var = b1.f51132a;
            if (obj != f0Var) {
                this._heap = j0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.k0
        @Nullable
        public kotlinx.coroutines.internal.j0<?> c() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.j0) {
                return (kotlinx.coroutines.internal.j0) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.t0
        public final synchronized void dispose() {
            kotlinx.coroutines.internal.f0 f0Var;
            kotlinx.coroutines.internal.f0 f0Var2;
            Object obj = this._heap;
            f0Var = b1.f51132a;
            if (obj == f0Var) {
                return;
            }
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                dVar.g(this);
            }
            f0Var2 = b1.f51132a;
            this._heap = f0Var2;
        }

        @Override // kotlinx.coroutines.internal.k0
        public void f(int i10) {
            this.f51574c = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull c cVar) {
            long j10 = this.f51573b - cVar.f51573b;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.internal.k0
        public int getIndex() {
            return this.f51574c;
        }

        public final synchronized int h(long j10, @NotNull d dVar, @NotNull y0 y0Var) {
            kotlinx.coroutines.internal.f0 f0Var;
            Object obj = this._heap;
            f0Var = b1.f51132a;
            if (obj == f0Var) {
                return 2;
            }
            synchronized (dVar) {
                c b4 = dVar.b();
                if (y0Var.isCompleted()) {
                    return 1;
                }
                if (b4 == null) {
                    dVar.f51575b = j10;
                } else {
                    long j11 = b4.f51573b;
                    if (j11 - j10 < 0) {
                        j10 = j11;
                    }
                    if (j10 - dVar.f51575b > 0) {
                        dVar.f51575b = j10;
                    }
                }
                long j12 = this.f51573b;
                long j13 = dVar.f51575b;
                if (j12 - j13 < 0) {
                    this.f51573b = j13;
                }
                dVar.a(this);
                return 0;
            }
        }

        public final boolean i(long j10) {
            return j10 - this.f51573b >= 0;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.f51573b + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class d extends kotlinx.coroutines.internal.j0<c> {

        /* renamed from: b, reason: collision with root package name */
        public long f51575b;

        public d(long j10) {
            this.f51575b = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    @Override // kotlinx.coroutines.x0
    public long C() {
        c e2;
        kotlinx.coroutines.internal.f0 f0Var;
        if (super.C() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.t)) {
                f0Var = b1.f51133b;
                return obj == f0Var ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.t) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) this._delayed;
        if (dVar == null || (e2 = dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = e2.f51573b;
        kotlinx.coroutines.c.a();
        return ce.n.c(j10 - System.nanoTime(), 0L);
    }

    public final void N() {
        kotlinx.coroutines.internal.f0 f0Var;
        kotlinx.coroutines.internal.f0 f0Var2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51568e;
                f0Var = b1.f51133b;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, f0Var)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.t) {
                    ((kotlinx.coroutines.internal.t) obj).d();
                    return;
                }
                f0Var2 = b1.f51133b;
                if (obj == f0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.t tVar = new kotlinx.coroutines.internal.t(8, true);
                tVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f51568e, this, obj, tVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable O() {
        kotlinx.coroutines.internal.f0 f0Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.t) {
                kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) obj;
                Object j10 = tVar.j();
                if (j10 != kotlinx.coroutines.internal.t.f51413h) {
                    return (Runnable) j10;
                }
                androidx.concurrent.futures.a.a(f51568e, this, obj, tVar.i());
            } else {
                f0Var = b1.f51133b;
                if (obj == f0Var) {
                    return null;
                }
                if (androidx.concurrent.futures.a.a(f51568e, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void P(@NotNull Runnable runnable) {
        if (Q(runnable)) {
            L();
        } else {
            k0.f51428g.P(runnable);
        }
    }

    public final boolean Q(Runnable runnable) {
        kotlinx.coroutines.internal.f0 f0Var;
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f51568e, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.t) {
                kotlinx.coroutines.internal.t tVar = (kotlinx.coroutines.internal.t) obj;
                int a10 = tVar.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 == 1) {
                    androidx.concurrent.futures.a.a(f51568e, this, obj, tVar.i());
                } else if (a10 == 2) {
                    return false;
                }
            } else {
                f0Var = b1.f51133b;
                if (obj == f0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.t tVar2 = new kotlinx.coroutines.internal.t(8, true);
                tVar2.a((Runnable) obj);
                tVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(f51568e, this, obj, tVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean R() {
        kotlinx.coroutines.internal.f0 f0Var;
        if (!H()) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.t) {
                return ((kotlinx.coroutines.internal.t) obj).g();
            }
            f0Var = b1.f51133b;
            if (obj != f0Var) {
                return false;
            }
        }
        return true;
    }

    public long S() {
        c cVar;
        if (I()) {
            return 0L;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.d()) {
            kotlinx.coroutines.c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    c b4 = dVar.b();
                    if (b4 != null) {
                        c cVar2 = b4;
                        cVar = cVar2.i(nanoTime) ? Q(cVar2) : false ? dVar.h(0) : null;
                    }
                }
            } while (cVar != null);
        }
        Runnable O = O();
        if (O != null) {
            O.run();
            return 0L;
        }
        return C();
    }

    public final void T() {
        c i10;
        kotlinx.coroutines.c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar == null || (i10 = dVar.i()) == null) {
                return;
            } else {
                K(nanoTime, i10);
            }
        }
    }

    public final void U() {
        this._queue = null;
        this._delayed = null;
    }

    public final void V(long j10, @NotNull c cVar) {
        int W = W(j10, cVar);
        if (W == 0) {
            if (Z(cVar)) {
                L();
            }
        } else if (W == 1) {
            K(j10, cVar);
        } else if (W != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int W(long j10, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            androidx.concurrent.futures.a.a(f51569f, this, null, new d(j10));
            Object obj = this._delayed;
            kotlin.jvm.internal.s.f(obj);
            dVar = (d) obj;
        }
        return cVar.h(j10, dVar, this);
    }

    @NotNull
    public final t0 X(long j10, @NotNull Runnable runnable) {
        long d10 = b1.d(j10);
        if (d10 < 4611686018427387903L) {
            kotlinx.coroutines.c.a();
            long nanoTime = System.nanoTime();
            b bVar = new b(d10 + nanoTime, runnable);
            V(nanoTime, bVar);
            return bVar;
        }
        return z1.f51576b;
    }

    public final void Y(boolean z10) {
        this._isCompleted = z10 ? 1 : 0;
    }

    public final boolean Z(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar != null ? dVar.e() : null) == cVar;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        P(runnable);
    }

    @Override // kotlinx.coroutines.m0
    public void k(long j10, @NotNull l<? super kotlin.p> lVar) {
        long d10 = b1.d(j10);
        if (d10 < 4611686018427387903L) {
            kotlinx.coroutines.c.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(d10 + nanoTime, lVar);
            V(nanoTime, aVar);
            o.a(lVar, aVar);
        }
    }

    @NotNull
    public t0 l(long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return m0.a.a(this, j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.x0
    public void shutdown() {
        j2.f51426a.b();
        Y(true);
        N();
        do {
        } while (S() <= 0);
        T();
    }
}
