package java.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CompletionService<V> {
    Future<V> poll();

    Future<V> poll(long j10, TimeUnit timeUnit) throws InterruptedException;

    Future<V> submit(Runnable runnable, V v2);

    Future<V> submit(Callable<V> callable);

    Future<V> take() throws InterruptedException;
}
