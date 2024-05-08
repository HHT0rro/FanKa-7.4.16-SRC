package java.util.concurrent;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SubmissionPublisher<T> implements Flow.Publisher<T>, AutoCloseable {
    private static final Executor ASYNC_POOL;
    static final int BUFFER_CAPACITY_LIMIT = 1073741824;
    static final int INITIAL_CAPACITY = 32;
    BufferedSubscription<T> clients;
    volatile boolean closed;
    volatile Throwable closedException;
    final Executor executor;
    final ReentrantLock lock;
    final int maxBufferCapacity;
    final BiConsumer<? super Flow.Subscriber<? super T>, ? super Throwable> onNextHandler;
    Thread owner;
    boolean subscribed;

    static final int roundCapacity(int cap) {
        int n10 = cap - 1;
        int n11 = n10 | (n10 >>> 1);
        int n12 = n11 | (n11 >>> 2);
        int n13 = n12 | (n12 >>> 4);
        int n14 = n13 | (n13 >>> 8);
        int n15 = n14 | (n14 >>> 16);
        if (n15 <= 0) {
            return 1;
        }
        if (n15 >= 1073741824) {
            return 1073741824;
        }
        return n15 + 1;
    }

    static {
        ASYNC_POOL = ForkJoinPool.getCommonPoolParallelism() > 1 ? ForkJoinPool.commonPool() : new ThreadPerTaskExecutor();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            new Thread(r10).start();
        }
    }

    public SubmissionPublisher(Executor executor, int maxBufferCapacity, BiConsumer<? super Flow.Subscriber<? super T>, ? super Throwable> handler) {
        if (executor == null) {
            throw new NullPointerException();
        }
        if (maxBufferCapacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.lock = new ReentrantLock();
        this.executor = executor;
        this.onNextHandler = handler;
        this.maxBufferCapacity = roundCapacity(maxBufferCapacity);
    }

    public SubmissionPublisher(Executor executor, int maxBufferCapacity) {
        this(executor, maxBufferCapacity, null);
    }

    public SubmissionPublisher() {
        this(ASYNC_POOL, Flow.defaultBufferSize(), null);
    }

    @Override // java.util.concurrent.Flow.Publisher
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new NullPointerException();
        }
        ReentrantLock lock = this.lock;
        int max = this.maxBufferCapacity;
        int i10 = 32;
        if (max < 32) {
            i10 = max;
        }
        Object[] array = new Object[i10];
        BufferedSubscription<T> subscription = new BufferedSubscription<>(subscriber, this.executor, this.onNextHandler, array, max);
        lock.lock();
        try {
            if (!this.subscribed) {
                this.subscribed = true;
                this.owner = Thread.currentThread();
            }
            BufferedSubscription<T> b4 = this.clients;
            BufferedSubscription<T> pred = null;
            while (true) {
                if (b4 == null) {
                    subscription.onSubscribe();
                    Throwable ex = this.closedException;
                    if (ex != null) {
                        subscription.onError(ex);
                    } else if (this.closed) {
                        subscription.onComplete();
                    } else if (pred == null) {
                        this.clients = subscription;
                    } else {
                        pred.next = subscription;
                    }
                } else {
                    BufferedSubscription<T> next = b4.next;
                    if (b4.isClosed()) {
                        b4.next = null;
                        if (pred == null) {
                            this.clients = next;
                        } else {
                            pred.next = next;
                        }
                    } else {
                        if (subscriber.equals(b4.subscriber)) {
                            b4.onError(new IllegalStateException("Duplicate subscribe"));
                            break;
                        }
                        pred = b4;
                    }
                    b4 = next;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private int doOffer(T item, long nanos, BiPredicate<Flow.Subscriber<? super T>, ? super T> onDrop) {
        int lag;
        boolean cleanMe;
        BufferedSubscription<T> retries;
        BufferedSubscription<T> rtail;
        boolean complete;
        if (item == null) {
            throw new NullPointerException();
        }
        int lag2 = 0;
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Thread t2 = Thread.currentThread();
            BufferedSubscription<T> b4 = this.clients;
            Thread o10 = this.owner;
            boolean z10 = o10 != t2;
            boolean unowned = z10;
            if (z10 && o10 != null) {
                this.owner = null;
            }
            if (b4 == null) {
                complete = this.closed;
            } else {
                boolean cleanMe2 = false;
                BufferedSubscription<T> retries2 = null;
                BufferedSubscription<T> rtail2 = null;
                while (true) {
                    BufferedSubscription<T> next = b4.next;
                    int stat = b4.offer(item, unowned);
                    if (stat == 0) {
                        b4.nextRetry = null;
                        if (rtail2 == null) {
                            retries2 = b4;
                        } else {
                            rtail2.nextRetry = b4;
                        }
                        BufferedSubscription<T> rtail3 = b4;
                        lag = lag2;
                        cleanMe = cleanMe2;
                        retries = retries2;
                        rtail = rtail3;
                    } else if (stat < 0) {
                        lag = lag2;
                        cleanMe = true;
                        retries = retries2;
                        rtail = rtail2;
                    } else if (stat <= lag2) {
                        lag = lag2;
                        cleanMe = cleanMe2;
                        retries = retries2;
                        rtail = rtail2;
                    } else {
                        lag = stat;
                        cleanMe = cleanMe2;
                        retries = retries2;
                        rtail = rtail2;
                    }
                    if (next == null) {
                        break;
                    }
                    lag2 = lag;
                    cleanMe2 = cleanMe;
                    retries2 = retries;
                    rtail2 = rtail;
                    b4 = next;
                }
                if (retries == null && !cleanMe) {
                    complete = false;
                    lag2 = lag;
                } else {
                    try {
                        lag2 = retryOffer(item, nanos, onDrop, retries, lag, cleanMe);
                        complete = false;
                    } catch (Throwable th) {
                        th = th;
                        lock.unlock();
                        throw th;
                    }
                }
            }
            lock.unlock();
            if (complete) {
                throw new IllegalStateException("Closed");
            }
            return lag2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int retryOffer(T item, long nanos, BiPredicate<Flow.Subscriber<? super T>, ? super T> onDrop, BufferedSubscription<T> retries, int lag, boolean cleanMe) {
        BufferedSubscription<T> r10 = retries;
        while (r10 != null) {
            BufferedSubscription<T> nextRetry = r10.nextRetry;
            r10.nextRetry = null;
            if (nanos > 0) {
                r10.awaitSpace(nanos);
            }
            int stat = r10.retryOffer(item);
            if (stat == 0 && onDrop != null && onDrop.test(r10.subscriber, item)) {
                stat = r10.retryOffer(item);
            }
            if (stat == 0) {
                lag = lag >= 0 ? -1 : lag - 1;
            } else if (stat < 0) {
                cleanMe = true;
            } else if (lag >= 0 && stat > lag) {
                lag = stat;
            }
            r10 = nextRetry;
        }
        if (cleanMe) {
            cleanAndCount();
        }
        return lag;
    }

    private int cleanAndCount() {
        int count = 0;
        BufferedSubscription<T> pred = null;
        BufferedSubscription<T> b4 = this.clients;
        while (b4 != null) {
            BufferedSubscription<T> next = b4.next;
            if (b4.isClosed()) {
                b4.next = null;
                if (pred == null) {
                    this.clients = next;
                } else {
                    pred.next = next;
                }
            } else {
                pred = b4;
                count++;
            }
            b4 = next;
        }
        return count;
    }

    public int submit(T item) {
        return doOffer(item, Long.MAX_VALUE, null);
    }

    public int offer(T item, BiPredicate<Flow.Subscriber<? super T>, ? super T> onDrop) {
        return doOffer(item, 0L, onDrop);
    }

    public int offer(T item, long timeout, TimeUnit unit, BiPredicate<Flow.Subscriber<? super T>, ? super T> onDrop) {
        long nanos = unit.toNanos(timeout);
        if (nanos == Long.MAX_VALUE) {
            nanos--;
        }
        return doOffer(item, nanos, onDrop);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        ReentrantLock lock = this.lock;
        if (!this.closed) {
            lock.lock();
            try {
                BufferedSubscription<T> b4 = this.clients;
                this.clients = null;
                this.owner = null;
                this.closed = true;
                while (b4 != null) {
                    BufferedSubscription<T> next = b4.next;
                    b4.next = null;
                    b4.onComplete();
                    b4 = next;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void closeExceptionally(Throwable error) {
        if (error == null) {
            throw new NullPointerException();
        }
        ReentrantLock lock = this.lock;
        if (!this.closed) {
            lock.lock();
            try {
                BufferedSubscription<T> b4 = this.clients;
                if (!this.closed) {
                    this.closedException = error;
                    this.clients = null;
                    this.owner = null;
                    this.closed = true;
                }
                while (b4 != null) {
                    BufferedSubscription<T> next = b4.next;
                    b4.next = null;
                    b4.onError(error);
                    b4 = next;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public Throwable getClosedException() {
        return this.closedException;
    }

    public boolean hasSubscribers() {
        boolean nonEmpty = false;
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            BufferedSubscription<T> b4 = this.clients;
            while (true) {
                if (b4 == null) {
                    break;
                }
                BufferedSubscription<T> next = b4.next;
                if (b4.isClosed()) {
                    b4.next = null;
                    this.clients = next;
                    b4 = next;
                } else {
                    nonEmpty = true;
                    break;
                }
            }
            return nonEmpty;
        } finally {
            lock.unlock();
        }
    }

    public int getNumberOfSubscribers() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n10 = cleanAndCount();
            return n10;
        } finally {
            lock.unlock();
        }
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public int getMaxBufferCapacity() {
        return this.maxBufferCapacity;
    }

    public List<Flow.Subscriber<? super T>> getSubscribers() {
        ArrayList<Flow.Subscriber<? super T>> subs = new ArrayList<>();
        ReentrantLock lock = this.lock;
        lock.lock();
        BufferedSubscription<T> pred = null;
        try {
            BufferedSubscription<T> b4 = this.clients;
            while (b4 != null) {
                BufferedSubscription<T> next = b4.next;
                if (b4.isClosed()) {
                    b4.next = null;
                    if (pred == null) {
                        this.clients = next;
                    } else {
                        pred.next = next;
                    }
                } else {
                    subs.add(b4.subscriber);
                    pred = b4;
                }
                b4 = next;
            }
            return subs;
        } finally {
            lock.unlock();
        }
    }

    public boolean isSubscribed(Flow.Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new NullPointerException();
        }
        boolean subscribed = false;
        ReentrantLock lock = this.lock;
        if (!this.closed) {
            lock.lock();
            BufferedSubscription<T> pred = null;
            try {
                BufferedSubscription<T> b4 = this.clients;
                while (b4 != null) {
                    BufferedSubscription<T> next = b4.next;
                    if (b4.isClosed()) {
                        b4.next = null;
                        if (pred == null) {
                            this.clients = next;
                        } else {
                            pred.next = next;
                        }
                    } else {
                        boolean equals = subscriber.equals(b4.subscriber);
                        subscribed = equals;
                        if (equals) {
                            break;
                        }
                        pred = b4;
                    }
                    b4 = next;
                }
            } finally {
                lock.unlock();
            }
        }
        return subscribed;
    }

    public long estimateMinimumDemand() {
        long min = Long.MAX_VALUE;
        boolean nonEmpty = false;
        ReentrantLock lock = this.lock;
        lock.lock();
        BufferedSubscription<T> pred = null;
        try {
            BufferedSubscription<T> b4 = this.clients;
            while (b4 != null) {
                BufferedSubscription<T> next = b4.next;
                int n10 = b4.estimateLag();
                if (n10 < 0) {
                    b4.next = null;
                    if (pred == null) {
                        this.clients = next;
                    } else {
                        pred.next = next;
                    }
                } else {
                    long d10 = b4.demand - n10;
                    if (d10 < min) {
                        min = d10;
                    }
                    nonEmpty = true;
                    pred = b4;
                }
                b4 = next;
            }
            if (nonEmpty) {
                return min;
            }
            return 0L;
        } finally {
            lock.unlock();
        }
    }

    public int estimateMaximumLag() {
        int max = 0;
        ReentrantLock lock = this.lock;
        lock.lock();
        BufferedSubscription<T> pred = null;
        try {
            BufferedSubscription<T> b4 = this.clients;
            while (b4 != null) {
                BufferedSubscription<T> next = b4.next;
                int n10 = b4.estimateLag();
                if (n10 < 0) {
                    b4.next = null;
                    if (pred == null) {
                        this.clients = next;
                    } else {
                        pred.next = next;
                    }
                } else {
                    if (n10 > max) {
                        max = n10;
                    }
                    pred = b4;
                }
                b4 = next;
            }
            return max;
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Void> consume(Consumer<? super T> consumer) {
        if (consumer == null) {
            throw new NullPointerException();
        }
        CompletableFuture<Void> status = new CompletableFuture<>();
        subscribe(new ConsumerSubscriber(status, consumer));
        return status;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ConsumerSubscriber<T> implements Flow.Subscriber<T> {
        final Consumer<? super T> consumer;
        final CompletableFuture<Void> status;
        Flow.Subscription subscription;

        ConsumerSubscriber(CompletableFuture<Void> status, Consumer<? super T> consumer) {
            this.status = status;
            this.consumer = consumer;
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onSubscribe(final Flow.Subscription subscription) {
            this.subscription = subscription;
            this.status.whenComplete(new BiConsumer() { // from class: java.util.concurrent.SubmissionPublisher$ConsumerSubscriber$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Flow.Subscription.this.cancel();
                }
            });
            if (!this.status.isDone()) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onError(Throwable ex) {
            this.status.completeExceptionally(ex);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onComplete() {
            this.status.complete(null);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public final void onNext(T item) {
            try {
                this.consumer.accept(item);
            } catch (Throwable ex) {
                this.subscription.cancel();
                this.status.completeExceptionally(ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ConsumerTask<T> extends ForkJoinTask<Void> implements Runnable, CompletableFuture.AsynchronousCompletionTask {
        final BufferedSubscription<T> consumer;

        ConsumerTask(BufferedSubscription<T> consumer) {
            this.consumer = consumer;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void v2) {
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.consumer.consume();
            return false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.consumer.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class BufferedSubscription<T> implements Flow.Subscription, ForkJoinPool.ManagedBlocker {
        static final int ACTIVE = 2;
        static final int CLOSED = 1;
        static final int COMPLETE = 16;
        static final VarHandle CTL;
        static final VarHandle DEMAND;
        static final int ERROR = 8;
        static final long INTERRUPTED = -1;
        static final int OPEN = 64;
        static final VarHandle QA;
        static final int REQS = 4;
        static final int RUN = 32;
        Object[] array;
        volatile int ctl;
        volatile long demand;
        Executor executor;
        int head;
        final int maxCapacity;
        BufferedSubscription<T> next;
        BufferedSubscription<T> nextRetry;
        final BiConsumer<? super Flow.Subscriber<? super T>, ? super Throwable> onNextHandler;
        Throwable pendingError;
        final Flow.Subscriber<? super T> subscriber;
        int tail;
        long timeout;
        Thread waiter;
        volatile int waiting;

        BufferedSubscription(Flow.Subscriber<? super T> subscriber, Executor executor, BiConsumer<? super Flow.Subscriber<? super T>, ? super Throwable> onNextHandler, Object[] array, int maxBufferCapacity) {
            this.subscriber = subscriber;
            this.executor = executor;
            this.onNextHandler = onNextHandler;
            this.array = array;
            this.maxCapacity = maxBufferCapacity;
        }

        final boolean weakCasCtl(int cmp, int val) {
            return (boolean) CTL.weakCompareAndSet(this, cmp, val);
        }

        final int getAndBitwiseOrCtl(int bits) {
            return (int) CTL.getAndBitwiseOr(this, bits);
        }

        final long subtractDemand(int k10) {
            long n10 = -k10;
            return (long) DEMAND.getAndAdd(this, n10) + n10;
        }

        final boolean casDemand(long cmp, long val) {
            return (boolean) DEMAND.compareAndSet(this, cmp, val);
        }

        final boolean isClosed() {
            return (this.ctl & 1) != 0;
        }

        final int estimateLag() {
            int c4 = this.ctl;
            int n10 = this.tail - this.head;
            if ((c4 & 1) != 0) {
                return -1;
            }
            if (n10 < 0) {
                return 0;
            }
            return n10;
        }

        final int offer(T item, boolean unowned) {
            boolean added;
            int stat = 0;
            Object[] a10 = this.array;
            int cap = a10 == null ? 0 : a10.length;
            int t2 = this.tail;
            int i10 = (cap - 1) & t2;
            int n10 = (t2 + 1) - this.head;
            if (cap > 0) {
                if (n10 >= cap && cap < this.maxCapacity) {
                    added = growAndOffer(item, a10, t2);
                } else if (n10 >= cap || unowned) {
                    added = (boolean) QA.compareAndSet(a10, i10, null, item);
                } else {
                    (void) QA.setRelease(a10, i10, item);
                    added = true;
                }
                if (added) {
                    this.tail = t2 + 1;
                    stat = n10;
                }
            }
            return startOnOffer(stat);
        }

        final boolean growAndOffer(T item, Object[] a10, int t2) {
            int cap = 0;
            int newCap = 0;
            Object[] newArray = null;
            if (a10 != null) {
                int length = a10.length;
                cap = length;
                if (length > 0) {
                    int i10 = cap << 1;
                    newCap = i10;
                    if (i10 > 0) {
                        try {
                            newArray = new Object[newCap];
                        } catch (OutOfMemoryError e2) {
                        }
                    }
                }
            }
            if (newArray == null) {
                return false;
            }
            int newMask = newCap - 1;
            int t10 = t2 - 1;
            newArray[t2 & newMask] = item;
            int mask = cap - 1;
            int k10 = mask;
            while (k10 >= 0) {
                Object x10 = (Object) QA.getAndSet(a10, t10 & mask, null);
                if (x10 == null) {
                    break;
                }
                newArray[t10 & newMask] = x10;
                k10--;
                t10--;
            }
            this.array = newArray;
            VarHandle.releaseFence();
            return true;
        }

        final int retryOffer(T item) {
            int cap;
            int stat = 0;
            int t2 = this.tail;
            int h10 = this.head;
            Object[] a10 = this.array;
            if (a10 != null && (cap = a10.length) > 0 && (boolean) QA.compareAndSet(a10, (cap - 1) & t2, null, item)) {
                int i10 = t2 + 1;
                this.tail = i10;
                stat = i10 - h10;
            }
            return startOnOffer(stat);
        }

        final int startOnOffer(int stat) {
            int i10 = this.ctl;
            int c4 = i10;
            if ((i10 & 6) == 4) {
                int andBitwiseOrCtl = getAndBitwiseOrCtl(34);
                c4 = andBitwiseOrCtl;
                if ((andBitwiseOrCtl & 33) == 0) {
                    tryStart();
                    return stat;
                }
            }
            if ((c4 & 1) != 0) {
                return -1;
            }
            return stat;
        }

        final void tryStart() {
            try {
                ConsumerTask<T> task = new ConsumerTask<>(this);
                Executor e2 = this.executor;
                if (e2 != null) {
                    e2.execute(task);
                }
            } catch (Error | RuntimeException ex) {
                getAndBitwiseOrCtl(9);
                throw ex;
            }
        }

        final void startOnSignal(int bits) {
            if ((this.ctl & bits) != bits && (getAndBitwiseOrCtl(bits) & 33) == 0) {
                tryStart();
            }
        }

        final void onSubscribe() {
            startOnSignal(34);
        }

        final void onComplete() {
            startOnSignal(50);
        }

        final void onError(Throwable ex) {
            if (ex != null) {
                this.pendingError = ex;
            }
            int c4 = getAndBitwiseOrCtl(42);
            if ((c4 & 1) == 0) {
                if ((c4 & 32) == 0) {
                    tryStart();
                    return;
                }
                Object[] a10 = this.array;
                if (a10 != null) {
                    Arrays.fill(a10, (Object) null);
                }
            }
        }

        @Override // java.util.concurrent.Flow.Subscription
        public final void cancel() {
            onError(null);
        }

        @Override // java.util.concurrent.Flow.Subscription
        public final void request(long n10) {
            long p10;
            long d10;
            if (n10 <= 0) {
                onError(new IllegalArgumentException("non-positive subscription request"));
                return;
            }
            do {
                p10 = this.demand;
                d10 = p10 + n10;
            } while (!casDemand(p10, d10 < p10 ? Long.MAX_VALUE : d10));
            startOnSignal(38);
        }

        final void consume() {
            Flow.Subscriber<? super T> s2 = this.subscriber;
            if (s2 != null) {
                subscribeOnOpen(s2);
                long d10 = this.demand;
                int h10 = this.head;
                int bit = this.tail;
                while (true) {
                    int c4 = this.ctl;
                    if ((c4 & 8) != 0) {
                        closeOnError(s2, null);
                        return;
                    }
                    int taken = takeItems(s2, d10, h10);
                    if (taken > 0) {
                        int i10 = h10 + taken;
                        h10 = i10;
                        this.head = i10;
                        d10 = subtractDemand(taken);
                    } else {
                        long j10 = this.demand;
                        d10 = j10;
                        if (j10 == 0 && (c4 & 4) != 0) {
                            weakCasCtl(c4, c4 & (-5));
                        } else if (d10 != 0 && (c4 & 4) == 0) {
                            weakCasCtl(c4, c4 | 4);
                        } else {
                            int t2 = this.tail;
                            if (bit == t2) {
                                boolean z10 = t2 == h10;
                                boolean empty = z10;
                                if (z10 && (c4 & 16) != 0) {
                                    closeOnComplete(s2);
                                    return;
                                } else if (empty || d10 == 0) {
                                    int bit2 = (c4 & 2) != 0 ? 2 : 32;
                                    if (weakCasCtl(c4, (~bit2) & c4) && bit2 == 32) {
                                        return;
                                    }
                                }
                            }
                            bit = t2;
                        }
                    }
                }
            }
        }

        final int takeItems(Flow.Subscriber<? super T> s2, long d10, int h10) {
            int cap;
            int k10 = 0;
            Object[] a10 = this.array;
            if (a10 != null && (cap = a10.length) > 0) {
                int m10 = cap - 1;
                int b4 = (m10 >>> 3) + 1;
                int n10 = d10 < ((long) b4) ? (int) d10 : b4;
                while (k10 < n10) {
                    Object x10 = (Object) QA.getAndSet(a10, h10 & m10, null);
                    if (this.waiting != 0) {
                        signalWaiter();
                    }
                    if (x10 == null || !consumeNext(s2, x10)) {
                        break;
                    }
                    h10++;
                    k10++;
                }
            }
            return k10;
        }

        final boolean consumeNext(Flow.Subscriber<? super T> s2, Object x10) {
            if (s2 != null) {
                try {
                    s2.onNext(x10);
                    return true;
                } catch (Throwable ex) {
                    handleOnNext(s2, ex);
                    return false;
                }
            }
            return true;
        }

        final void handleOnNext(Flow.Subscriber<? super T> s2, Throwable ex) {
            try {
                BiConsumer<? super Flow.Subscriber<? super T>, ? super Throwable> h10 = this.onNextHandler;
                if (h10 != null) {
                    h10.accept(s2, ex);
                }
            } catch (Throwable th) {
            }
            closeOnError(s2, ex);
        }

        final void subscribeOnOpen(Flow.Subscriber<? super T> s2) {
            if ((this.ctl & 64) == 0 && (getAndBitwiseOrCtl(64) & 64) == 0) {
                consumeSubscribe(s2);
            }
        }

        final void consumeSubscribe(Flow.Subscriber<? super T> s2) {
            if (s2 != null) {
                try {
                    s2.onSubscribe(this);
                } catch (Throwable ex) {
                    closeOnError(s2, ex);
                }
            }
        }

        final void closeOnComplete(Flow.Subscriber<? super T> s2) {
            if ((1 & getAndBitwiseOrCtl(1)) == 0) {
                consumeComplete(s2);
            }
        }

        final void consumeComplete(Flow.Subscriber<? super T> s2) {
            if (s2 != null) {
                try {
                    s2.onComplete();
                } catch (Throwable th) {
                }
            }
        }

        final void closeOnError(Flow.Subscriber<? super T> s2, Throwable ex) {
            if ((getAndBitwiseOrCtl(9) & 1) == 0) {
                if (ex == null) {
                    ex = this.pendingError;
                }
                this.pendingError = null;
                this.executor = null;
                signalWaiter();
                consumeError(s2, ex);
            }
        }

        final void consumeError(Flow.Subscriber<? super T> s2, Throwable ex) {
            if (ex != null && s2 != null) {
                try {
                    s2.onError(ex);
                } catch (Throwable th) {
                }
            }
        }

        final void signalWaiter() {
            this.waiting = 0;
            Thread w3 = this.waiter;
            if (w3 != null) {
                LockSupport.unpark(w3);
            }
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public final boolean isReleasable() {
            int cap;
            if ((this.ctl & 1) != 0) {
                return true;
            }
            Object[] a10 = this.array;
            return a10 != null && (cap = a10.length) > 0 && (Object) QA.getAcquire(a10, (cap + (-1)) & this.tail) == null;
        }

        final void awaitSpace(long nanos) {
            if (!isReleasable()) {
                ForkJoinPool.helpAsyncBlocker(this.executor, this);
                if (!isReleasable()) {
                    this.timeout = nanos;
                    try {
                        ForkJoinPool.managedBlock(this);
                    } catch (InterruptedException e2) {
                        this.timeout = -1L;
                    }
                    if (this.timeout == -1) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public final boolean block() {
            long nanos = this.timeout;
            boolean timed = nanos < Long.MAX_VALUE;
            long deadline = timed ? System.nanoTime() + nanos : 0L;
            while (!isReleasable()) {
                if (Thread.interrupted()) {
                    this.timeout = -1L;
                    if (timed) {
                        break;
                    }
                } else {
                    if (timed) {
                        long nanoTime = deadline - System.nanoTime();
                        nanos = nanoTime;
                        if (nanoTime <= 0) {
                            break;
                        }
                    }
                    if (this.waiter == null) {
                        this.waiter = Thread.currentThread();
                    } else if (this.waiting == 0) {
                        this.waiting = 1;
                    } else if (timed) {
                        LockSupport.parkNanos(this, nanos);
                    } else {
                        LockSupport.park(this);
                    }
                }
            }
            this.waiter = null;
            this.waiting = 0;
            return true;
        }

        static {
            try {
                MethodHandles.Lookup l10 = MethodHandles.lookup();
                CTL = l10.findVarHandle(BufferedSubscription.class, "ctl", Integer.TYPE);
                DEMAND = l10.findVarHandle(BufferedSubscription.class, "demand", Long.TYPE);
                QA = MethodHandles.arrayElementVarHandle(Object[].class);
            } catch (ReflectiveOperationException e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }
    }
}
