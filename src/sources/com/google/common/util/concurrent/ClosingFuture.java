package com.google.common.util.concurrent;

import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ClosingFuture<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f26785d = Logger.getLogger(ClosingFuture.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference<State> f26786a;

    /* renamed from: b, reason: collision with root package name */
    public final CloseableList f26787b;

    /* renamed from: c, reason: collision with root package name */
    public final h<V> f26788c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Closeable f26789b;

        public a(Closeable closeable) {
            this.f26789b = closeable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f26789b.close();
            } catch (IOException | RuntimeException e2) {
                ClosingFuture.f26785d.log(Level.WARNING, "thrown by close()", e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26790a;

        static {
            int[] iArr = new int[State.values().length];
            f26790a = iArr;
            try {
                iArr[State.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26790a[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26790a[State.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26790a[State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26790a[State.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26790a[State.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture closingFuture = ClosingFuture.this;
            State state = State.WILL_CLOSE;
            State state2 = State.CLOSING;
            closingFuture.h(state, state2);
            ClosingFuture.this.i();
            ClosingFuture.this.h(state2, State.CLOSED);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface d<T, U> {
        ClosingFuture<U> a(f fVar, T t2) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface e<T, U> {
        U a(f fVar, T t2) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final CloseableList f26792a;

        public f(CloseableList closeableList) {
            this.f26792a = closeableList;
        }
    }

    public static void j(Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new a(closeable));
        } catch (RejectedExecutionException e2) {
            Logger logger = f26785d;
            Level level = Level.WARNING;
            if (logger.isLoggable(level)) {
                logger.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e2);
            }
            j(closeable, p.a());
        }
    }

    public void finalize() {
        if (this.f26786a.get().equals(State.OPEN)) {
            f26785d.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            l();
        }
    }

    public final void g(CloseableList closeableList) {
        h(State.OPEN, State.SUBSUMED);
        closeableList.add(this.f26787b, p.a());
    }

    public final void h(State state, State state2) {
        com.google.common.base.o.C(k(state, state2), "Expected state to be %s, but it was %s", state, state2);
    }

    public final void i() {
        f26785d.log(Level.FINER, "closing {0}", this);
        this.f26787b.close();
    }

    public final boolean k(State state, State state2) {
        return this.f26786a.compareAndSet(state, state2);
    }

    public h<V> l() {
        if (k(State.OPEN, State.WILL_CLOSE)) {
            f26785d.log(Level.FINER, "will close {0}", this);
            this.f26788c.addListener(new c(), p.a());
        } else {
            switch (b.f26790a[this.f26786a.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        return this.f26788c;
    }

    public String toString() {
        return com.google.common.base.j.c(this).d("state", this.f26786a.get()).k(this.f26788c).toString();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean closed;
        private final f closer;
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new f(this);
        }

        public void add(Closeable closeable, Executor executor) {
            com.google.common.base.o.r(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                if (!this.closed) {
                    put(closeable, executor);
                } else {
                    ClosingFuture.j(closeable, executor);
                }
            }
        }

        public <V, U> h<U> applyAsyncClosingFunction(d<V, U> dVar, V v2) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> a10 = dVar.a(closeableList.closer, v2);
                a10.g(closeableList);
                return a10.f26788c;
            } finally {
                add(closeableList, p.a());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <V, U> n<U> applyClosingFunction(e<? super V, U> eVar, V v2) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return i.c(eVar.a(closeableList.closer, v2));
            } finally {
                add(closeableList, p.a());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                    ClosingFuture.j(entry.getKey(), entry.getValue());
                }
                clear();
                if (this.whenClosed != null) {
                    this.whenClosed.countDown();
                }
            }
        }

        public CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                if (this.closed) {
                    return new CountDownLatch(0);
                }
                com.google.common.base.o.x(this.whenClosed == null);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.whenClosed = countDownLatch;
                return countDownLatch;
            }
        }

        public /* synthetic */ CloseableList(com.google.common.util.concurrent.e eVar) {
            this();
        }
    }
}
