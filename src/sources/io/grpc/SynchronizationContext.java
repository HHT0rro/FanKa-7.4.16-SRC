package io.grpc;

import com.google.common.base.o;
import com.huawei.flexiblelayout.parser.cardmanager.d;
import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4984")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SynchronizationContext implements Executor {
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final Queue<Runnable> queue = new ConcurrentLinkedQueue();
    private final AtomicReference<Thread> drainingThread = new AtomicReference<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ManagedRunnable implements Runnable {
        public boolean hasStarted;
        public boolean isCancelled;
        public final Runnable task;

        public ManagedRunnable(Runnable runnable) {
            this.task = (Runnable) o.s(runnable, d.a.f28343b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isCancelled) {
                return;
            }
            this.hasStarted = true;
            this.task.run();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ScheduledHandle {
        private final ScheduledFuture<?> future;
        private final ManagedRunnable runnable;

        public void cancel() {
            this.runnable.isCancelled = true;
            this.future.cancel(false);
        }

        public boolean isPending() {
            ManagedRunnable managedRunnable = this.runnable;
            return (managedRunnable.hasStarted || managedRunnable.isCancelled) ? false : true;
        }

        private ScheduledHandle(ManagedRunnable managedRunnable, ScheduledFuture<?> scheduledFuture) {
            this.runnable = (ManagedRunnable) o.s(managedRunnable, "runnable");
            this.future = (ScheduledFuture) o.s(scheduledFuture, "future");
        }
    }

    public SynchronizationContext(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) o.s(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void drain() {
        while (this.drainingThread.compareAndSet(null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable poll = this.queue.poll();
                    if (poll == null) {
                        break;
                    }
                    try {
                        poll.run();
                    } catch (Throwable th) {
                        this.uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.drainingThread.set(null);
                    throw th2;
                }
            }
            this.drainingThread.set(null);
            if (this.queue.isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        executeLater(runnable);
        drain();
    }

    public final void executeLater(Runnable runnable) {
        this.queue.add((Runnable) o.s(runnable, "runnable is null"));
    }

    public final ScheduledHandle schedule(final Runnable runnable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final ManagedRunnable managedRunnable = new ManagedRunnable(runnable);
        return new ScheduledHandle(managedRunnable, scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.SynchronizationContext.1
            @Override // java.lang.Runnable
            public void run() {
                SynchronizationContext.this.execute(managedRunnable);
            }

            public String toString() {
                return runnable.toString() + "(scheduled in SynchronizationContext)";
            }
        }, j10, timeUnit));
    }

    public final ScheduledHandle scheduleWithFixedDelay(final Runnable runnable, long j10, final long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final ManagedRunnable managedRunnable = new ManagedRunnable(runnable);
        return new ScheduledHandle(managedRunnable, scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: io.grpc.SynchronizationContext.2
            @Override // java.lang.Runnable
            public void run() {
                SynchronizationContext.this.execute(managedRunnable);
            }

            public String toString() {
                return runnable.toString() + "(scheduled in SynchronizationContext with delay of " + j11 + ")";
            }
        }, j10, j11, timeUnit));
    }

    public void throwIfNotInThisSynchronizationContext() {
        o.y(Thread.currentThread() == this.drainingThread.get(), "Not called from the SynchronizationContext");
    }
}
