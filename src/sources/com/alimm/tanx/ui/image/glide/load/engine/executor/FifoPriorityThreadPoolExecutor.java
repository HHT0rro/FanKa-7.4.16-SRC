package com.alimm.tanx.ui.image.glide.load.engine.executor;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {
    public static final String TAG = "PriorityExecutor";
    public final AtomicInteger ordering;
    public final UncaughtThrowableStrategy uncaughtThrowableStrategy;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        public int threadNum = 0;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder a10 = a.a("fifo-pool-thread-");
            a10.append(this.threadNum);
            Thread thread = new Thread(runnable, a10.toString()) { // from class: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            this.threadNum++;
            return thread;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class LoadTask<T> extends FutureTask<T> implements Comparable<LoadTask<?>> {
        public final int order;
        public final int priority;

        public LoadTask(Runnable runnable, T t2, int i10) {
            super(runnable, t2);
            if (runnable instanceof Prioritized) {
                this.priority = ((Prioritized) runnable).getPriority();
                this.order = i10;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LoadTask)) {
                return false;
            }
            LoadTask loadTask = (LoadTask) obj;
            return this.order == loadTask.order && this.priority == loadTask.priority;
        }

        public int hashCode() {
            return (this.priority * 31) + this.order;
        }

        @Override // java.lang.Comparable
        public int compareTo(LoadTask<?> loadTask) {
            int i10 = this.priority - loadTask.priority;
            return i10 == 0 ? this.order - loadTask.order : i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                Log.isLoggable(FifoPriorityThreadPoolExecutor.TAG, 6);
            }
        },
        THROW { // from class: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                throw new RuntimeException(th);
            }
        };

        public void handle(Throwable th) {
        }

        /* synthetic */ UncaughtThrowableStrategy(AnonymousClass1 anonymousClass1) {
        }
    }

    public FifoPriorityThreadPoolExecutor(int i10) {
        this(i10, UncaughtThrowableStrategy.LOG);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (InterruptedException e2) {
                this.uncaughtThrowableStrategy.handle(e2);
            } catch (ExecutionException e10) {
                this.uncaughtThrowableStrategy.handle(e10);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t2) {
        return new LoadTask(runnable, t2, this.ordering.getAndIncrement());
    }

    public FifoPriorityThreadPoolExecutor(int i10, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(i10, i10, 0L, TimeUnit.MILLISECONDS, new DefaultThreadFactory(), uncaughtThrowableStrategy);
    }

    public FifoPriorityThreadPoolExecutor(int i10, int i11, long j10, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i10, i11, j10, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.ordering = new AtomicInteger();
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }
}
