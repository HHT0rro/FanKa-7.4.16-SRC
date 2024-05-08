package java.util.concurrent;

import com.tencent.connect.common.Constants;
import dalvik.annotation.optimization.ReachabilitySensitive;
import java.lang.ref.Reference;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Executors {
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newWorkStealingPool(int parallelism) {
        return new ForkJoinPool(parallelism, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }

    public static ExecutorService newWorkStealingPool() {
        return new ForkJoinPool(Runtime.getRuntime().availableProcessors(), ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }

    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory);
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()));
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory));
    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    public static ExecutorService unconfigurableExecutorService(ExecutorService executor) {
        if (executor == null) {
            throw new NullPointerException();
        }
        return new DelegatedExecutorService(executor);
    }

    public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService executor) {
        if (executor == null) {
            throw new NullPointerException();
        }
        return new DelegatedScheduledExecutorService(executor);
    }

    public static ThreadFactory defaultThreadFactory() {
        return new DefaultThreadFactory();
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_START_GROUP)
    public static ThreadFactory privilegedThreadFactory() {
        return new PrivilegedThreadFactory();
    }

    public static <T> Callable<T> callable(Runnable task, T result) {
        if (task == null) {
            throw new NullPointerException();
        }
        return new RunnableAdapter(task, result);
    }

    public static Callable<Object> callable(Runnable task) {
        if (task == null) {
            throw new NullPointerException();
        }
        return new RunnableAdapter(task, null);
    }

    public static Callable<Object> callable(final PrivilegedAction<?> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        return new Callable<Object>() { // from class: java.util.concurrent.Executors.1
            @Override // java.util.concurrent.Callable
            public Object call() {
                return PrivilegedAction.this.run();
            }
        };
    }

    public static Callable<Object> callable(final PrivilegedExceptionAction<?> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        return new Callable<Object>() { // from class: java.util.concurrent.Executors.2
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                return PrivilegedExceptionAction.this.run();
            }
        };
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_START_GROUP)
    public static <T> Callable<T> privilegedCallable(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new PrivilegedCallable(callable);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_START_GROUP)
    public static <T> Callable<T> privilegedCallableUsingCurrentClassLoader(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new PrivilegedCallableUsingCurrentClassLoader(callable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class RunnableAdapter<T> implements Callable<T> {
        private final T result;
        private final Runnable task;

        RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            this.task.run();
            return this.result;
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + ((Object) this.task) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class PrivilegedCallable<T> implements Callable<T> {
        final AccessControlContext acc = AccessController.getContext();
        final Callable<T> task;

        PrivilegedCallable(Callable<T> task) {
            this.task = task;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) AccessController.doPrivileged(new PrivilegedExceptionAction<T>() { // from class: java.util.concurrent.Executors.PrivilegedCallable.1
                    @Override // java.security.PrivilegedExceptionAction
                    public T run() throws Exception {
                        return PrivilegedCallable.this.task.call();
                    }
                }, this.acc);
            } catch (PrivilegedActionException e2) {
                throw e2.getException();
            }
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + ((Object) this.task) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class PrivilegedCallableUsingCurrentClassLoader<T> implements Callable<T> {
        final AccessControlContext acc = AccessController.getContext();
        final ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        final Callable<T> task;

        PrivilegedCallableUsingCurrentClassLoader(Callable<T> task) {
            this.task = task;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) AccessController.doPrivileged(new PrivilegedExceptionAction<T>() { // from class: java.util.concurrent.Executors.PrivilegedCallableUsingCurrentClassLoader.1
                    @Override // java.security.PrivilegedExceptionAction
                    public T run() throws Exception {
                        Thread t2 = Thread.currentThread();
                        ClassLoader cl = t2.getContextClassLoader();
                        if (PrivilegedCallableUsingCurrentClassLoader.this.ccl == cl) {
                            return PrivilegedCallableUsingCurrentClassLoader.this.task.call();
                        }
                        t2.setContextClassLoader(PrivilegedCallableUsingCurrentClassLoader.this.ccl);
                        try {
                            return PrivilegedCallableUsingCurrentClassLoader.this.task.call();
                        } finally {
                            t2.setContextClassLoader(cl);
                        }
                    }
                }, this.acc);
            } catch (PrivilegedActionException e2) {
                throw e2.getException();
            }
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + ((Object) this.task) + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        DefaultThreadFactory() {
            SecurityManager s2 = System.getSecurityManager();
            this.group = s2 != null ? s2.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread t2 = new Thread(this.group, r10, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (t2.isDaemon()) {
                t2.setDaemon(false);
            }
            if (t2.getPriority() != 5) {
                t2.setPriority(5);
            }
            return t2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PrivilegedThreadFactory extends DefaultThreadFactory {
        final AccessControlContext acc = AccessController.getContext();
        final ClassLoader ccl = Thread.currentThread().getContextClassLoader();

        PrivilegedThreadFactory() {
        }

        @Override // java.util.concurrent.Executors.DefaultThreadFactory, java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r10) {
            return super.newThread(new Runnable() { // from class: java.util.concurrent.Executors.PrivilegedThreadFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: java.util.concurrent.Executors.PrivilegedThreadFactory.1.1
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            Thread.currentThread().setContextClassLoader(PrivilegedThreadFactory.this.ccl);
                            r10.run();
                            return null;
                        }
                    }, PrivilegedThreadFactory.this.acc);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class DelegatedExecutorService implements ExecutorService {

        /* renamed from: e, reason: collision with root package name */
        @ReachabilitySensitive
        private final ExecutorService f50499e;

        DelegatedExecutorService(ExecutorService executor) {
            this.f50499e = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            try {
                this.f50499e.execute(command);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.f50499e.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            try {
                return this.f50499e.shutdownNow();
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            try {
                return this.f50499e.isShutdown();
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            try {
                return this.f50499e.isTerminated();
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            try {
                return this.f50499e.awaitTermination(timeout, unit);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable task) {
            try {
                return this.f50499e.submit(task);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> task) {
            try {
                return this.f50499e.submit(task);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable task, T result) {
            try {
                return this.f50499e.submit(task, result);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            try {
                return this.f50499e.invokeAll(tasks);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
            try {
                return this.f50499e.invokeAll(tasks, timeout, unit);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            try {
                return (T) this.f50499e.invokeAny(collection);
            } finally {
                Reference.reachabilityFence(this);
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            try {
                return (T) this.f50499e.invokeAny(collection, j10, timeUnit);
            } finally {
                Reference.reachabilityFence(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
        }

        protected void finalize() {
            super.shutdown();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {

        /* renamed from: e, reason: collision with root package name */
        private final ScheduledExecutorService f50500e;

        DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            this.f50500e = executor;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            return this.f50500e.schedule(command, delay, unit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            return this.f50500e.schedule(callable, delay, unit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            return this.f50500e.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            return this.f50500e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }
    }

    private Executors() {
    }
}
