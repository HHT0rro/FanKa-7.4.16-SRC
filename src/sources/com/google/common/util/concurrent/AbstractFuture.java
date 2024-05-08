package com.google.common.util.concurrent;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbstractFuture<V> extends y7.a implements n<V> {
    private static final b ATOMIC_HELPER;
    public static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;
    private volatile d listeners;
    private volatile Object value;
    private volatile k waiters;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f26757b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f26758a;

        public Failure(Throwable th) {
            this.f26758a = (Throwable) com.google.common.base.o.r(th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2);

        public abstract d d(AbstractFuture<?> abstractFuture, d dVar);

        public abstract k e(AbstractFuture<?> abstractFuture, k kVar);

        public abstract void f(k kVar, k kVar2);

        public abstract void g(k kVar, Thread thread);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final c f26759c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f26760d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f26761a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f26762b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                f26760d = null;
                f26759c = null;
            } else {
                f26760d = new c(false, null);
                f26759c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f26761a = z10;
            this.f26762b = th;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<k, Thread> f26767a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<k, k> f26768b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, k> f26769c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, d> f26770d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f26771e;

        public e(AtomicReferenceFieldUpdater<k, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<k, k> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, k> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f26767a = atomicReferenceFieldUpdater;
            this.f26768b = atomicReferenceFieldUpdater2;
            this.f26769c = atomicReferenceFieldUpdater3;
            this.f26770d = atomicReferenceFieldUpdater4;
            this.f26771e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f26770d, abstractFuture, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f26771e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            return androidx.concurrent.futures.a.a(this.f26769c, abstractFuture, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            return this.f26770d.getAndSet(abstractFuture, dVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k e(AbstractFuture<?> abstractFuture, k kVar) {
            return this.f26769c.getAndSet(abstractFuture, kVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, k kVar2) {
            this.f26768b.lazySet(kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(k kVar, Thread thread) {
            this.f26767a.lazySet(kVar, thread);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class f<V> implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final AbstractFuture<V> f26772b;

        /* renamed from: c, reason: collision with root package name */
        public final n<? extends V> f26773c;

        public f(AbstractFuture<V> abstractFuture, n<? extends V> nVar) {
            this.f26772b = abstractFuture;
            this.f26773c = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.f26772b).value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.b(this.f26772b, this, AbstractFuture.getFutureValue(this.f26773c))) {
                AbstractFuture.complete(this.f26772b);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).listeners != dVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).listeners = dVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).value != obj) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).value = obj2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).waiters != kVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).waiters = kVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            synchronized (abstractFuture) {
                dVar2 = ((AbstractFuture) abstractFuture).listeners;
                if (dVar2 != dVar) {
                    ((AbstractFuture) abstractFuture).listeners = dVar;
                }
            }
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k e(AbstractFuture<?> abstractFuture, k kVar) {
            k kVar2;
            synchronized (abstractFuture) {
                kVar2 = ((AbstractFuture) abstractFuture).waiters;
                if (kVar2 != kVar) {
                    ((AbstractFuture) abstractFuture).waiters = kVar;
                }
            }
            return kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, k kVar2) {
            kVar.f26782b = kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(k kVar, Thread thread) {
            kVar.f26781a = thread;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface h<V> extends n<V> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class i<V> extends AbstractFuture<V> implements h<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.n
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z10) {
            return super.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j10, timeUnit);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class j extends b {

        /* renamed from: a, reason: collision with root package name */
        public static final Unsafe f26774a;

        /* renamed from: b, reason: collision with root package name */
        public static final long f26775b;

        /* renamed from: c, reason: collision with root package name */
        public static final long f26776c;

        /* renamed from: d, reason: collision with root package name */
        public static final long f26777d;

        /* renamed from: e, reason: collision with root package name */
        public static final long f26778e;

        /* renamed from: f, reason: collision with root package name */
        public static final long f26779f;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new a());
                }
                try {
                    f26776c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                    f26775b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                    f26777d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
                    f26778e = unsafe.objectFieldOffset(k.class.getDeclaredField("a"));
                    f26779f = unsafe.objectFieldOffset(k.class.getDeclaredField("b"));
                    f26774a = unsafe;
                } catch (Exception e2) {
                    com.google.common.base.u.f(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e10) {
                throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
            }
        }

        public j() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return com.google.common.util.concurrent.a.a(f26774a, abstractFuture, f26775b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return com.google.common.util.concurrent.a.a(f26774a, abstractFuture, f26777d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            return com.google.common.util.concurrent.a.a(f26774a, abstractFuture, f26776c, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            do {
                dVar2 = ((AbstractFuture) abstractFuture).listeners;
                if (dVar == dVar2) {
                    return dVar2;
                }
            } while (!a(abstractFuture, dVar2, dVar));
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k e(AbstractFuture<?> abstractFuture, k kVar) {
            k kVar2;
            do {
                kVar2 = ((AbstractFuture) abstractFuture).waiters;
                if (kVar == kVar2) {
                    return kVar2;
                }
            } while (!c(abstractFuture, kVar2, kVar));
            return kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, k kVar2) {
            f26774a.putObject(kVar, f26779f, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(k kVar, Thread thread) {
            f26774a.putObject(kVar, f26778e, thread);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class k {

        /* renamed from: c, reason: collision with root package name */
        public static final k f26780c = new k(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f26781a;

        /* renamed from: b, reason: collision with root package name */
        public volatile k f26782b;

        public k(boolean z10) {
        }

        public void a(k kVar) {
            AbstractFuture.ATOMIC_HELPER.f(this, kVar);
        }

        public void b() {
            Thread thread = this.f26781a;
            if (thread != null) {
                this.f26781a = null;
                LockSupport.unpark(thread);
            }
        }

        public k() {
            AbstractFuture.ATOMIC_HELPER.g(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.google.common.util.concurrent.AbstractFuture$a] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.common.util.concurrent.AbstractFuture$j] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.common.util.concurrent.AbstractFuture$e] */
    static {
        boolean z10;
        g gVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        GENERATE_CANCELLATION_CAUSES = z10;
        log = Logger.getLogger(AbstractFuture.class.getName());
        ?? r12 = 0;
        r12 = 0;
        try {
            gVar = new j();
            th = null;
        } catch (Throwable th) {
            th = th;
            try {
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, k.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            } catch (Throwable th2) {
                gVar = new g();
                r12 = th2;
            }
        }
        ATOMIC_HELPER = gVar;
        if (r12 != 0) {
            ?? r02 = log;
            Level level = Level.SEVERE;
            r02.log(level, "UnsafeAtomicHelper is broken!", th);
            r02.log(level, "SafeAtomicHelper is broken!", r12);
        }
        NULL = new Object();
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb2.append("SUCCESS, result=[");
            appendResultObject(sb2, uninterruptibly);
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append((Object) e2.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e10) {
            sb2.append("FAILURE, cause=[");
            sb2.append((Object) e10.getCause());
            sb2.append("]");
        }
    }

    private void addPendingString(StringBuilder sb2) {
        String sb3;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof f) {
            sb2.append(", setFuture=[");
            appendUserObject(sb2, ((f) obj).f26773c);
            sb2.append("]");
        } else {
            try {
                sb3 = com.google.common.base.s.a(pendingToString());
            } catch (RuntimeException | StackOverflowError e2) {
                String valueOf = String.valueOf(e2.getClass());
                StringBuilder sb4 = new StringBuilder(valueOf.length() + 38);
                sb4.append("Exception thrown from implementation: ");
                sb4.append(valueOf);
                sb3 = sb4.toString();
            }
            if (sb3 != null) {
                sb2.append(", info=[");
                sb2.append(sb3);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            addDoneString(sb2);
        }
    }

    private void appendResultObject(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else {
            if (obj == this) {
                sb2.append("this future");
                return;
            }
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void appendUserObject(StringBuilder sb2, Object obj) {
        try {
            if (obj == this) {
                sb2.append("this future");
            } else {
                sb2.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e2) {
            sb2.append("Exception thrown from implementation: ");
            sb2.append((Object) e2.getClass());
        }
    }

    private static CancellationException cancellationExceptionWithCause(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private d clearListeners(d dVar) {
        d dVar2 = dVar;
        d d10 = ATOMIC_HELPER.d(this, d.f26763d);
        while (d10 != null) {
            d dVar3 = d10.f26766c;
            d10.f26766c = dVar2;
            dVar2 = d10;
            d10 = dVar3;
        }
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void complete(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.releaseWaiters();
            abstractFuture.afterDone();
            d clearListeners = abstractFuture.clearListeners(dVar);
            while (clearListeners != null) {
                dVar = clearListeners.f26766c;
                Runnable runnable = clearListeners.f26764a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof f) {
                    f fVar = (f) runnable2;
                    abstractFuture = fVar.f26772b;
                    if (((AbstractFuture) abstractFuture).value == fVar) {
                        if (ATOMIC_HELPER.b(abstractFuture, fVar, getFutureValue(fVar.f26773c))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = clearListeners.f26765b;
                    Objects.requireNonNull(executor);
                    executeListener(runnable2, executor);
                }
                clearListeners = dVar;
            }
            return;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = log;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.log(level, sb2.toString(), (Throwable) e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (!(obj instanceof c)) {
            if (obj instanceof Failure) {
                throw new ExecutionException(((Failure) obj).f26758a);
            }
            return obj == NULL ? (V) q.b() : obj;
        }
        throw cancellationExceptionWithCause("Task was cancelled.", ((c) obj).f26762b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object getFutureValue(n<?> nVar) {
        Throwable a10;
        if (nVar instanceof h) {
            Object obj = ((AbstractFuture) nVar).value;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f26761a) {
                    obj = cVar.f26762b != null ? new c(false, cVar.f26762b) : c.f26760d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((nVar instanceof y7.a) && (a10 = y7.b.a((y7.a) nVar)) != null) {
            return new Failure(a10);
        }
        boolean isCancelled = nVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
            c cVar2 = c.f26760d;
            Objects.requireNonNull(cVar2);
            return cVar2;
        }
        try {
            Object uninterruptibly = getUninterruptibly(nVar);
            if (!isCancelled) {
                return uninterruptibly == null ? NULL : uninterruptibly;
            }
            String valueOf = String.valueOf(nVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 84);
            sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb2.append(valueOf);
            return new c(false, new IllegalArgumentException(sb2.toString()));
        } catch (CancellationException e2) {
            if (!isCancelled) {
                String valueOf2 = String.valueOf(nVar);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 77);
                sb3.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb3.append(valueOf2);
                return new Failure(new IllegalArgumentException(sb3.toString(), e2));
            }
            return new c(false, e2);
        } catch (ExecutionException e10) {
            if (isCancelled) {
                String valueOf3 = String.valueOf(nVar);
                StringBuilder sb4 = new StringBuilder(valueOf3.length() + 84);
                sb4.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb4.append(valueOf3);
                return new c(false, new IllegalArgumentException(sb4.toString(), e10));
            }
            return new Failure(e10.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v2;
        boolean z10 = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v2;
    }

    private void releaseWaiters() {
        for (k e2 = ATOMIC_HELPER.e(this, k.f26780c); e2 != null; e2 = e2.f26782b) {
            e2.b();
        }
    }

    private void removeWaiter(k kVar) {
        kVar.f26781a = null;
        while (true) {
            k kVar2 = this.waiters;
            if (kVar2 == k.f26780c) {
                return;
            }
            k kVar3 = null;
            while (kVar2 != null) {
                k kVar4 = kVar2.f26782b;
                if (kVar2.f26781a != null) {
                    kVar3 = kVar2;
                } else if (kVar3 != null) {
                    kVar3.f26782b = kVar4;
                    if (kVar3.f26781a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, kVar2, kVar4)) {
                    break;
                }
                kVar2 = kVar4;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.n
    public void addListener(Runnable runnable, Executor executor) {
        d dVar;
        com.google.common.base.o.s(runnable, "Runnable was null.");
        com.google.common.base.o.s(executor, "Executor was null.");
        if (!isDone() && (dVar = this.listeners) != d.f26763d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f26766c = dVar;
                if (ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.f26763d);
        }
        executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else {
            if (z10) {
                cVar = c.f26759c;
            } else {
                cVar = c.f26760d;
            }
            Objects.requireNonNull(cVar);
        }
        boolean z11 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, cVar)) {
                if (z10) {
                    abstractFuture.interruptTask();
                }
                complete(abstractFuture);
                if (!(obj instanceof f)) {
                    return true;
                }
                n<? extends V> nVar = ((f) obj).f26773c;
                if (nVar instanceof h) {
                    abstractFuture = (AbstractFuture) nVar;
                    obj = abstractFuture.value;
                    if (!(obj == null) && !(obj instanceof f)) {
                        return true;
                    }
                    z11 = true;
                } else {
                    nVar.cancel(z10);
                    return true;
                }
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof f)) {
                    return z11;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) & (!(obj instanceof f))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                k kVar = this.waiters;
                if (kVar != k.f26780c) {
                    k kVar2 = new k();
                    do {
                        kVar2.a(kVar);
                        if (ATOMIC_HELPER.c(this, kVar, kVar2)) {
                            do {
                                r.a(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof f))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(kVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(kVar2);
                        } else {
                            kVar = this.waiters;
                        }
                    } while (kVar != k.f26780c);
                }
                Object obj3 = this.value;
                Objects.requireNonNull(obj3);
                return getDoneValue(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) & (!(obj4 instanceof f))) {
                    return getDoneValue(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String timeUnit2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit2.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb2.append("Waited ");
            sb2.append(j10);
            sb2.append(" ");
            sb2.append(lowerCase2);
            String sb3 = sb2.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb3).concat(" (plus ");
                long j11 = -nanos;
                long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
                long nanos2 = j11 - timeUnit.toNanos(convert);
                boolean z10 = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb4 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                    sb4.append(valueOf);
                    sb4.append(convert);
                    sb4.append(" ");
                    sb4.append(lowerCase);
                    String sb5 = sb4.toString();
                    if (z10) {
                        sb5 = String.valueOf(sb5).concat(",");
                    }
                    concat = String.valueOf(sb5).concat(" ");
                }
                if (z10) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb6 = new StringBuilder(valueOf2.length() + 33);
                    sb6.append(valueOf2);
                    sb6.append(nanos2);
                    sb6.append(" nanoseconds ");
                    concat = sb6.toString();
                }
                sb3 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb3).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb7 = new StringBuilder(String.valueOf(sb3).length() + 5 + String.valueOf(abstractFuture).length());
            sb7.append(sb3);
            sb7.append(" for ");
            sb7.append(abstractFuture);
            throw new TimeoutException(sb7.toString());
        }
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof f)) & (this.value != null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }

    public boolean set(V v2) {
        if (v2 == null) {
            v2 = (V) NULL;
        }
        if (!ATOMIC_HELPER.b(this, null, v2)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, null, new Failure((Throwable) com.google.common.base.o.r(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(n<? extends V> nVar) {
        Failure failure;
        com.google.common.base.o.r(nVar);
        Object obj = this.value;
        if (obj == null) {
            if (nVar.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, getFutureValue(nVar))) {
                    return false;
                }
                complete(this);
                return true;
            }
            f fVar = new f(this, nVar);
            if (ATOMIC_HELPER.b(this, null, fVar)) {
                try {
                    nVar.addListener(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.f26757b;
                    }
                    ATOMIC_HELPER.b(this, fVar, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            nVar.cancel(((c) obj).f26761a);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb2);
        } else {
            addPendingString(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // y7.a
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof h)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).f26758a;
        }
        return null;
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f26761a;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        public static final d f26763d = new d();

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f26764a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f26765b;

        /* renamed from: c, reason: collision with root package name */
        public d f26766c;

        public d(Runnable runnable, Executor executor) {
            this.f26764a = runnable;
            this.f26765b = executor;
        }

        public d() {
            this.f26764a = null;
            this.f26765b = null;
        }
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return getDoneValue(obj2);
            }
            k kVar = this.waiters;
            if (kVar != k.f26780c) {
                k kVar2 = new k();
                do {
                    kVar2.a(kVar);
                    if (ATOMIC_HELPER.c(this, kVar, kVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(kVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return getDoneValue(obj);
                    }
                    kVar = this.waiters;
                } while (kVar != k.f26780c);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return getDoneValue(obj3);
        }
        throw new InterruptedException();
    }
}
