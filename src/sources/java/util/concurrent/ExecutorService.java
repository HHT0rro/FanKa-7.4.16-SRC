package java.util.concurrent;

import java.util.Collection;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ExecutorService extends Executor {
    boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException;

    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException;

    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException;

    <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException;

    <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException;

    boolean isShutdown();

    boolean isTerminated();

    void shutdown();

    List<Runnable> shutdownNow();

    Future<?> submit(Runnable runnable);

    <T> Future<T> submit(Runnable runnable, T t2);

    <T> Future<T> submit(Callable<T> callable);
}
