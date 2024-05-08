package java.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Future<V> {
    boolean cancel(boolean z10);

    V get() throws InterruptedException, ExecutionException;

    V get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException;

    boolean isCancelled();

    boolean isDone();
}
