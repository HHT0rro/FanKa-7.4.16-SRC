package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.Channel;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import sun.security.action.GetIntegerAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AsynchronousChannelGroupImpl extends AsynchronousChannelGroup implements Executor {
    private static final int internalThreadCount = ((Integer) AccessController.doPrivileged(new GetIntegerAction("sun.nio.ch.internalThreadPoolSize", 1))).intValue();
    private final ThreadPool pool;
    private final AtomicBoolean shutdown;
    private final Object shutdownNowLock;
    private final Queue<Runnable> taskQueue;
    private volatile boolean terminateInitiated;
    private final AtomicInteger threadCount;
    private ScheduledThreadPoolExecutor timeoutExecutor;

    abstract Object attachForeignChannel(Channel channel, FileDescriptor fileDescriptor) throws IOException;

    abstract void closeAllChannels() throws IOException;

    abstract void detachForeignChannel(Object obj);

    abstract void executeOnHandlerTask(Runnable runnable);

    abstract boolean isEmpty();

    abstract void shutdownHandlerTasks();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsynchronousChannelGroupImpl(AsynchronousChannelProvider provider, ThreadPool pool) {
        super(provider);
        this.threadCount = new AtomicInteger();
        this.shutdown = new AtomicBoolean();
        this.shutdownNowLock = new Object();
        this.pool = pool;
        if (pool.isFixedThreadPool()) {
            this.taskQueue = new ConcurrentLinkedQueue();
        } else {
            this.taskQueue = null;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1, ThreadPool.defaultThreadFactory());
        this.timeoutExecutor = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
    }

    final ExecutorService executor() {
        return this.pool.executor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isFixedThreadPool() {
        return this.pool.isFixedThreadPool();
    }

    final int fixedThreadCount() {
        if (isFixedThreadPool()) {
            return this.pool.poolSize();
        }
        return this.pool.poolSize() + internalThreadCount;
    }

    private Runnable bindToGroup(final Runnable task) {
        return new Runnable() { // from class: sun.nio.ch.AsynchronousChannelGroupImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Invoker.bindToGroup(thisGroup);
                task.run();
            }
        };
    }

    private void startInternalThread(final Runnable task) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: sun.nio.ch.AsynchronousChannelGroupImpl.2
            @Override // java.security.PrivilegedAction
            public Void run() {
                ThreadPool.defaultThreadFactory().newThread(task).start();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void startThreads(Runnable task) {
        if (!isFixedThreadPool()) {
            for (int i10 = 0; i10 < internalThreadCount; i10++) {
                startInternalThread(task);
                this.threadCount.incrementAndGet();
            }
        }
        if (this.pool.poolSize() > 0) {
            Runnable task2 = bindToGroup(task);
            for (int i11 = 0; i11 < this.pool.poolSize(); i11++) {
                try {
                    this.pool.executor().execute(task2);
                    this.threadCount.incrementAndGet();
                } catch (RejectedExecutionException e2) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int threadCount() {
        return this.threadCount.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int threadExit(Runnable task, boolean replaceMe) {
        if (replaceMe) {
            try {
                if (Invoker.isBoundToAnyGroup()) {
                    this.pool.executor().execute(bindToGroup(task));
                } else {
                    startInternalThread(task);
                }
                return this.threadCount.get();
            } catch (RejectedExecutionException e2) {
            }
        }
        return this.threadCount.decrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void executeOnPooledThread(Runnable task) {
        if (isFixedThreadPool()) {
            executeOnHandlerTask(task);
        } else {
            this.pool.executor().execute(bindToGroup(task));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void offerTask(Runnable task) {
        this.taskQueue.offer(task);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Runnable pollTask() {
        Queue<Runnable> queue = this.taskQueue;
        if (queue == null) {
            return null;
        }
        return queue.poll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<?> schedule(Runnable task, long timeout, TimeUnit unit) {
        try {
            return this.timeoutExecutor.schedule(task, timeout, unit);
        } catch (RejectedExecutionException rej) {
            if (this.terminateInitiated) {
                return null;
            }
            throw new AssertionError(rej);
        }
    }

    @Override // java.nio.channels.AsynchronousChannelGroup
    public final boolean isShutdown() {
        return this.shutdown.get();
    }

    @Override // java.nio.channels.AsynchronousChannelGroup
    public final boolean isTerminated() {
        return this.pool.executor().isTerminated();
    }

    private void shutdownExecutors() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: sun.nio.ch.AsynchronousChannelGroupImpl.3
            @Override // java.security.PrivilegedAction
            public Void run() {
                AsynchronousChannelGroupImpl.this.pool.executor().shutdown();
                AsynchronousChannelGroupImpl.this.timeoutExecutor.shutdown();
                return null;
            }
        });
    }

    @Override // java.nio.channels.AsynchronousChannelGroup
    public final void shutdown() {
        if (this.shutdown.getAndSet(true) || !isEmpty()) {
            return;
        }
        synchronized (this.shutdownNowLock) {
            if (!this.terminateInitiated) {
                this.terminateInitiated = true;
                shutdownHandlerTasks();
                shutdownExecutors();
            }
        }
    }

    @Override // java.nio.channels.AsynchronousChannelGroup
    public final void shutdownNow() throws IOException {
        this.shutdown.set(true);
        synchronized (this.shutdownNowLock) {
            if (!this.terminateInitiated) {
                this.terminateInitiated = true;
                closeAllChannels();
                shutdownHandlerTasks();
                shutdownExecutors();
            }
        }
    }

    final void detachFromThreadPool() {
        if (this.shutdown.getAndSet(true)) {
            throw new AssertionError((Object) "Already shutdown");
        }
        if (!isEmpty()) {
            throw new AssertionError((Object) "Group not empty");
        }
        shutdownHandlerTasks();
    }

    @Override // java.nio.channels.AsynchronousChannelGroup
    public final boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.pool.executor().awaitTermination(timeout, unit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable task) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            final AccessControlContext acc = AccessController.getContext();
            task = new Runnable() { // from class: sun.nio.ch.AsynchronousChannelGroupImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: sun.nio.ch.AsynchronousChannelGroupImpl.4.1
                        @Override // java.security.PrivilegedAction
                        public Void run() {
                            task.run();
                            return null;
                        }
                    }, acc);
                }
            };
        }
        executeOnPooledThread(task);
    }
}
