package sun.nio.ch;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class CompletedFuture<V> implements Future<V> {
    private final Throwable exc;
    private final V result;

    private CompletedFuture(V result, Throwable exc) {
        this.result = result;
        this.exc = exc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> CompletedFuture<V> withResult(V result) {
        return new CompletedFuture<>(result, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> CompletedFuture<V> withFailure(Throwable exc) {
        if (!(exc instanceof IOException) && !(exc instanceof SecurityException)) {
            exc = new IOException(exc);
        }
        return new CompletedFuture<>(null, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> CompletedFuture<V> withResult(V result, Throwable exc) {
        if (exc == null) {
            return withResult(result);
        }
        return withFailure(exc);
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException {
        Throwable th = this.exc;
        if (th != null) {
            throw new ExecutionException(th);
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public V get(long timeout, TimeUnit unit) throws ExecutionException {
        if (unit == null) {
            throw new NullPointerException();
        }
        Throwable th = this.exc;
        if (th != null) {
            throw new ExecutionException(th);
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }
}
