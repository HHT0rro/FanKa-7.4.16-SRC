package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class PendingFuture<V, A> implements Future<V> {
    private static final CancellationException CANCELLED = new CancellationException();
    private final A attachment;
    private final AsynchronousChannel channel;
    private volatile Object context;
    private volatile Throwable exc;
    private final CompletionHandler<V, ? super A> handler;
    private volatile boolean haveResult;
    private CountDownLatch latch;
    private volatile V result;
    private Future<?> timeoutTask;

    PendingFuture(AsynchronousChannel channel, CompletionHandler<V, ? super A> handler, A attachment, Object context) {
        this.channel = channel;
        this.handler = handler;
        this.attachment = attachment;
        this.context = context;
    }

    PendingFuture(AsynchronousChannel channel, CompletionHandler<V, ? super A> handler, A attachment) {
        this.channel = channel;
        this.handler = handler;
        this.attachment = attachment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingFuture(AsynchronousChannel channel) {
        this(channel, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingFuture(AsynchronousChannel channel, Object context) {
        this(channel, null, null, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsynchronousChannel channel() {
        return this.channel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompletionHandler<V, ? super A> handler() {
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public A attachment() {
        return this.attachment;
    }

    void setContext(Object context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getContext() {
        return this.context;
    }

    void setTimeoutTask(Future<?> task) {
        synchronized (this) {
            if (this.haveResult) {
                task.cancel(false);
            } else {
                this.timeoutTask = task;
            }
        }
    }

    private boolean prepareForWait() {
        synchronized (this) {
            if (this.haveResult) {
                return false;
            }
            if (this.latch == null) {
                this.latch = new CountDownLatch(1);
            }
            return true;
        }
    }

    void setResult(V res) {
        synchronized (this) {
            if (this.haveResult) {
                return;
            }
            this.result = res;
            this.haveResult = true;
            Future<?> future = this.timeoutTask;
            if (future != null) {
                future.cancel(false);
            }
            CountDownLatch countDownLatch = this.latch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFailure(Throwable x10) {
        if (!(x10 instanceof IOException) && !(x10 instanceof SecurityException)) {
            x10 = new IOException(x10);
        }
        synchronized (this) {
            if (this.haveResult) {
                return;
            }
            this.exc = x10;
            this.haveResult = true;
            Future<?> future = this.timeoutTask;
            if (future != null) {
                future.cancel(false);
            }
            CountDownLatch countDownLatch = this.latch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setResult(V res, Throwable x10) {
        if (x10 == null) {
            setResult(res);
        } else {
            setFailure(x10);
        }
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        if (!this.haveResult) {
            boolean needToWait = prepareForWait();
            if (needToWait) {
                this.latch.await();
            }
        }
        if (this.exc != null) {
            if (this.exc == CANCELLED) {
                throw new CancellationException();
            }
            throw new ExecutionException(this.exc);
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public V get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!this.haveResult) {
            boolean needToWait = prepareForWait();
            if (needToWait && !this.latch.await(timeout, unit)) {
                throw new TimeoutException();
            }
        }
        if (this.exc != null) {
            if (this.exc == CANCELLED) {
                throw new CancellationException();
            }
            throw new ExecutionException(this.exc);
        }
        return this.result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Throwable exception() {
        if (this.exc != CANCELLED) {
            return this.exc;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V value() {
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.exc == CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.haveResult;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        synchronized (this) {
            if (this.haveResult) {
                return false;
            }
            if (channel() instanceof Cancellable) {
                ((Cancellable) channel()).onCancel(this);
            }
            this.exc = CANCELLED;
            this.haveResult = true;
            Future<?> future = this.timeoutTask;
            if (future != null) {
                future.cancel(false);
            }
            if (mayInterruptIfRunning) {
                try {
                    channel().close();
                } catch (IOException e2) {
                }
            }
            CountDownLatch countDownLatch = this.latch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            return true;
        }
    }
}
