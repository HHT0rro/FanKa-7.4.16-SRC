package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import ce.n;
import fe.g;
import fe.h;
import fe.j;
import fe.k;
import fe.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.random.Random;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineScheduler.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    @NotNull
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: b */
    public final int f51470b;

    /* renamed from: c */
    public final int f51471c;

    @NotNull
    public volatile /* synthetic */ long controlState;

    /* renamed from: d */
    public final long f51472d;

    /* renamed from: e */
    @NotNull
    public final String f51473e;

    /* renamed from: f */
    @NotNull
    public final fe.c f51474f;

    /* renamed from: g */
    @NotNull
    public final fe.c f51475g;

    /* renamed from: h */
    @NotNull
    public final a0<c> f51476h;

    @NotNull
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: i */
    @NotNull
    public static final a f51465i = new a(null);

    /* renamed from: m */
    @NotNull
    public static final f0 f51469m = new f0("NOT_IN_STACK");

    /* renamed from: j */
    public static final /* synthetic */ AtomicLongFieldUpdater f51466j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: k */
    public static final /* synthetic */ AtomicLongFieldUpdater f51467k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: l */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51468l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f51477a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            f51477a = iArr;
        }
    }

    public CoroutineScheduler(int i10, int i11, long j10, @NotNull String str) {
        this.f51470b = i10;
        this.f51471c = i11;
        this.f51472d = j10;
        this.f51473e = str;
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (!(i11 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j10 > 0) {
            this.f51474f = new fe.c();
            this.f51475g = new fe.c();
            this.parkedWorkersStack = 0L;
            this.f51476h = new a0<>(i10 + 1);
            this.controlState = i10 << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
    }

    public static /* synthetic */ void g(CoroutineScheduler coroutineScheduler, Runnable runnable, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hVar = k.f49342f;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        coroutineScheduler.f(runnable, hVar, z10);
    }

    public static /* synthetic */ boolean z(CoroutineScheduler coroutineScheduler, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.y(j10);
    }

    public final boolean A() {
        c j10;
        do {
            j10 = j();
            if (j10 == null) {
                return false;
            }
        } while (!c.f51478i.compareAndSet(j10, -1, 0));
        LockSupport.unpark(j10);
        return true;
    }

    public final boolean a(g gVar) {
        if (gVar.f49334c.b() == 1) {
            return this.f51475g.a(gVar);
        }
        return this.f51474f.a(gVar);
    }

    public final int b() {
        synchronized (this.f51476h) {
            if (isTerminated()) {
                return -1;
            }
            long j10 = this.controlState;
            int i10 = (int) (j10 & 2097151);
            int b4 = n.b(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (b4 >= this.f51470b) {
                return 0;
            }
            if (i10 >= this.f51471c) {
                return 0;
            }
            int i11 = ((int) (this.controlState & 2097151)) + 1;
            if (i11 > 0 && this.f51476h.b(i11) == null) {
                c cVar = new c(this, i11);
                this.f51476h.c(i11, cVar);
                if (i11 == ((int) (2097151 & f51467k.incrementAndGet(this)))) {
                    cVar.start();
                    return b4 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        r(10000L);
    }

    @NotNull
    public final g d(@NotNull Runnable runnable, @NotNull h hVar) {
        long a10 = k.f49341e.a();
        if (runnable instanceof g) {
            g gVar = (g) runnable;
            gVar.f49333b = a10;
            gVar.f49334c = hVar;
            return gVar;
        }
        return new j(runnable, a10, hVar);
    }

    public final c e() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !s.d(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        g(this, runnable, null, false, 6, null);
    }

    public final void f(@NotNull Runnable runnable, @NotNull h hVar, boolean z10) {
        kotlinx.coroutines.c.a();
        g d10 = d(runnable, hVar);
        c e2 = e();
        g x10 = x(e2, d10, z10);
        if (x10 != null && !a(x10)) {
            throw new RejectedExecutionException(this.f51473e + " was terminated");
        }
        boolean z11 = z10 && e2 != null;
        if (d10.f49334c.b() != 0) {
            u(z11);
        } else {
            if (z11) {
                return;
            }
            w();
        }
    }

    public final int i(c cVar) {
        Object h10 = cVar.h();
        while (h10 != f51469m) {
            if (h10 == null) {
                return 0;
            }
            c cVar2 = (c) h10;
            int g3 = cVar2.g();
            if (g3 != 0) {
                return g3;
            }
            h10 = cVar2.h();
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final c j() {
        while (true) {
            long j10 = this.parkedWorkersStack;
            c b4 = this.f51476h.b((int) (2097151 & j10));
            if (b4 == null) {
                return null;
            }
            long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            int i10 = i(b4);
            if (i10 >= 0 && f51466j.compareAndSet(this, j10, i10 | j11)) {
                b4.p(f51469m);
                return b4;
            }
        }
    }

    public final boolean k(@NotNull c cVar) {
        long j10;
        long j11;
        int g3;
        if (cVar.h() != f51469m) {
            return false;
        }
        do {
            j10 = this.parkedWorkersStack;
            j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            g3 = cVar.g();
            cVar.p(this.f51476h.b((int) (2097151 & j10)));
        } while (!f51466j.compareAndSet(this, j10, j11 | g3));
        return true;
    }

    public final void l(@NotNull c cVar, int i10, int i11) {
        while (true) {
            long j10 = this.parkedWorkersStack;
            int i12 = (int) (2097151 & j10);
            long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            if (i12 == i10) {
                i12 = i11 == 0 ? i(cVar) : i11;
            }
            if (i12 >= 0 && f51466j.compareAndSet(this, j10, j11 | i12)) {
                return;
            }
        }
    }

    public final void m(@NotNull g gVar) {
        try {
            gVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void r(long j10) {
        int i10;
        g d10;
        if (f51468l.compareAndSet(this, 0, 1)) {
            c e2 = e();
            synchronized (this.f51476h) {
                i10 = (int) (this.controlState & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    c b4 = this.f51476h.b(i11);
                    s.f(b4);
                    c cVar = b4;
                    if (cVar != e2) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f51479b.g(this.f51475g);
                    }
                    if (i11 == i10) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            this.f51475g.b();
            this.f51474f.b();
            while (true) {
                if (e2 != null) {
                    d10 = e2.f(true);
                    if (d10 != null) {
                        continue;
                        m(d10);
                    }
                }
                d10 = this.f51474f.d();
                if (d10 == null && (d10 = this.f51475g.d()) == null) {
                    break;
                }
                m(d10);
            }
            if (e2 != null) {
                e2.s(WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a10 = this.f51476h.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < a10; i15++) {
            c b4 = this.f51476h.b(i15);
            if (b4 != null) {
                int f10 = b4.f51479b.f();
                int i16 = b.f51477a[b4.f51480c.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(f10);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(f10);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (f10 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(f10);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = this.controlState;
        return this.f51473e + '@' + j0.b(this) + "[Pool Size {core = " + this.f51470b + ", max = " + this.f51471c + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + ((Object) arrayList) + ", global CPU queue size = " + this.f51474f.c() + ", global blocking queue size = " + this.f51475g.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f51470b - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final void u(boolean z10) {
        long addAndGet = f51467k.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (z10 || A() || y(addAndGet)) {
            return;
        }
        A();
    }

    public final void w() {
        if (A() || z(this, 0L, 1, null)) {
            return;
        }
        A();
    }

    public final g x(c cVar, g gVar, boolean z10) {
        if (cVar == null || cVar.f51480c == WorkerState.TERMINATED) {
            return gVar;
        }
        if (gVar.f49334c.b() == 0 && cVar.f51480c == WorkerState.BLOCKING) {
            return gVar;
        }
        cVar.f51484g = true;
        return cVar.f51479b.a(gVar, z10);
    }

    public final boolean y(long j10) {
        if (n.b(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f51470b) {
            int b4 = b();
            if (b4 == 1 && this.f51470b > 1) {
                b();
            }
            if (b4 > 0) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: CoroutineScheduler.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class c extends Thread {

        /* renamed from: i */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f51478i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: b */
        @NotNull
        public final m f51479b;

        /* renamed from: c */
        @NotNull
        public WorkerState f51480c;

        /* renamed from: d */
        public long f51481d;

        /* renamed from: e */
        public long f51482e;

        /* renamed from: f */
        public int f51483f;

        /* renamed from: g */
        public boolean f51484g;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;

        @NotNull
        public volatile /* synthetic */ int workerCtl;

        public c() {
            setDaemon(true);
            this.f51479b = new m();
            this.f51480c = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f51469m;
            this.f51483f = Random.Default.nextInt();
        }

        public final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            CoroutineScheduler.f51467k.addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.f51480c != WorkerState.TERMINATED) {
                this.f51480c = WorkerState.DORMANT;
            }
        }

        public final void c(int i10) {
            if (i10 != 0 && s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.w();
            }
        }

        public final void d(g gVar) {
            int b4 = gVar.f49334c.b();
            i(b4);
            c(b4);
            CoroutineScheduler.this.m(gVar);
            b(b4);
        }

        public final g e(boolean z10) {
            g m10;
            g m11;
            if (z10) {
                boolean z11 = k(CoroutineScheduler.this.f51470b * 2) == 0;
                if (z11 && (m11 = m()) != null) {
                    return m11;
                }
                g h10 = this.f51479b.h();
                if (h10 != null) {
                    return h10;
                }
                if (!z11 && (m10 = m()) != null) {
                    return m10;
                }
            } else {
                g m12 = m();
                if (m12 != null) {
                    return m12;
                }
            }
            return t(false);
        }

        @Nullable
        public final g f(boolean z10) {
            g d10;
            if (q()) {
                return e(z10);
            }
            if (z10) {
                d10 = this.f51479b.h();
                if (d10 == null) {
                    d10 = CoroutineScheduler.this.f51475g.d();
                }
            } else {
                d10 = CoroutineScheduler.this.f51475g.d();
            }
            return d10 == null ? t(true) : d10;
        }

        public final int g() {
            return this.indexInArray;
        }

        @Nullable
        public final Object h() {
            return this.nextParkedWorker;
        }

        public final void i(int i10) {
            this.f51481d = 0L;
            if (this.f51480c == WorkerState.PARKING) {
                this.f51480c = WorkerState.BLOCKING;
            }
        }

        public final boolean j() {
            return this.nextParkedWorker != CoroutineScheduler.f51469m;
        }

        public final int k(int i10) {
            int i11 = this.f51483f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f51483f = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void l() {
            if (this.f51481d == 0) {
                this.f51481d = System.nanoTime() + CoroutineScheduler.this.f51472d;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f51472d);
            if (System.nanoTime() - this.f51481d >= 0) {
                this.f51481d = 0L;
                u();
            }
        }

        public final g m() {
            if (k(2) == 0) {
                g d10 = CoroutineScheduler.this.f51474f.d();
                return d10 != null ? d10 : CoroutineScheduler.this.f51475g.d();
            }
            g d11 = CoroutineScheduler.this.f51475g.d();
            return d11 != null ? d11 : CoroutineScheduler.this.f51474f.d();
        }

        public final void n() {
            loop0: while (true) {
                boolean z10 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f51480c != WorkerState.TERMINATED) {
                    g f10 = f(this.f51484g);
                    if (f10 != null) {
                        this.f51482e = 0L;
                        d(f10);
                    } else {
                        this.f51484g = false;
                        if (this.f51482e == 0) {
                            r();
                        } else if (z10) {
                            s(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f51482e);
                            this.f51482e = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
            }
            s(WorkerState.TERMINATED);
        }

        public final void o(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f51473e);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void p(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean q() {
            boolean z10;
            if (this.f51480c != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j10 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                        z10 = false;
                        break;
                    }
                    if (CoroutineScheduler.f51467k.compareAndSet(coroutineScheduler, j10, j10 - 4398046511104L)) {
                        z10 = true;
                        break;
                    }
                }
                if (!z10) {
                    return false;
                }
                this.f51480c = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        public final void r() {
            if (!j()) {
                CoroutineScheduler.this.k(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.f51480c != WorkerState.TERMINATED) {
                s(WorkerState.PARKING);
                Thread.interrupted();
                l();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.f51480c;
            boolean z10 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z10) {
                CoroutineScheduler.f51467k.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f51480c = workerState;
            }
            return z10;
        }

        public final g t(boolean z10) {
            long l10;
            int i10 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i10 < 2) {
                return null;
            }
            int k10 = k(i10);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j10 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                k10++;
                if (k10 > i10) {
                    k10 = 1;
                }
                c b4 = coroutineScheduler.f51476h.b(k10);
                if (b4 != null && b4 != this) {
                    if (z10) {
                        l10 = this.f51479b.k(b4.f51479b);
                    } else {
                        l10 = this.f51479b.l(b4.f51479b);
                    }
                    if (l10 == -1) {
                        return this.f51479b.h();
                    }
                    if (l10 > 0) {
                        j10 = Math.min(j10, l10);
                    }
                }
            }
            if (j10 == Long.MAX_VALUE) {
                j10 = 0;
            }
            this.f51482e = j10;
            return null;
        }

        public final void u() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f51476h) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.f51470b) {
                    return;
                }
                if (f51478i.compareAndSet(this, -1, 1)) {
                    int i10 = this.indexInArray;
                    o(0);
                    coroutineScheduler.l(this, i10, 0);
                    int andDecrement = (int) (CoroutineScheduler.f51467k.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != i10) {
                        c b4 = coroutineScheduler.f51476h.b(andDecrement);
                        s.f(b4);
                        c cVar = b4;
                        coroutineScheduler.f51476h.c(i10, cVar);
                        cVar.o(i10);
                        coroutineScheduler.l(cVar, andDecrement, i10);
                    }
                    coroutineScheduler.f51476h.c(andDecrement, null);
                    p pVar = p.f51048a;
                    this.f51480c = WorkerState.TERMINATED;
                }
            }
        }

        public c(CoroutineScheduler coroutineScheduler, int i10) {
            this();
            o(i10);
        }
    }
}
