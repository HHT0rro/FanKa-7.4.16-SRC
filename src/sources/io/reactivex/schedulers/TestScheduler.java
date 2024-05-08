package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TestScheduler extends Scheduler {
    public long counter;
    public final Queue<TimedRunnable> queue = new PriorityBlockingQueue(11);
    public volatile long time;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        public final long count;
        public final Runnable run;
        public final TestWorker scheduler;
        public final long time;

        public TimedRunnable(TestWorker testWorker, long j10, Runnable runnable, long j11) {
            this.time = j10;
            this.run = runnable;
            this.scheduler = testWorker;
            this.count = j11;
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.time), this.run.toString());
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable timedRunnable) {
            long j10 = this.time;
            long j11 = timedRunnable.time;
            if (j10 == j11) {
                return ObjectHelper.compare(this.count, timedRunnable.count);
            }
            return ObjectHelper.compare(j10, j11);
        }
    }

    public TestScheduler() {
    }

    public void advanceTimeBy(long j10, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j10), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j10, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j10));
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    @Override // io.reactivex.Scheduler
    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j10) {
        while (true) {
            TimedRunnable peek = this.queue.peek();
            if (peek == null) {
                break;
            }
            long j11 = peek.time;
            if (j11 > j10) {
                break;
            }
            if (j11 == 0) {
                j11 = this.time;
            }
            this.time = j11;
            this.queue.remove(peek);
            if (!peek.scheduler.disposed) {
                peek.run.run();
            }
        }
        this.time = j10;
    }

    public TestScheduler(long j10, TimeUnit timeUnit) {
        this.time = timeUnit.toNanos(j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class TestWorker extends Scheduler.Worker {
        public volatile boolean disposed;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class QueueRemove implements Runnable {
            public final TimedRunnable timedAction;

            public QueueRemove(TimedRunnable timedRunnable) {
                this.timedAction = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestScheduler.this.queue.remove(this.timedAction);
            }
        }

        public TestWorker() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(@NonNull TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j10, @NonNull TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.time + timeUnit.toNanos(j10);
            TestScheduler testScheduler = TestScheduler.this;
            long j11 = testScheduler.counter;
            testScheduler.counter = 1 + j11;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j11);
            TestScheduler.this.queue.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j10 = testScheduler.counter;
            testScheduler.counter = 1 + j10;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0L, runnable, j10);
            TestScheduler.this.queue.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }
    }
}
