package com.alimm.tanx.ui.image.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RequestFutureTarget<T, R> implements FutureTarget<R>, Runnable {
    public static final Waiter DEFAULT_WAITER = new Waiter();
    public final boolean assertBackgroundThread;
    public Exception exception;
    public boolean exceptionReceived;
    public final int height;
    public boolean isCancelled;
    public final Handler mainHandler;
    public Request request;
    public R resource;
    public boolean resultReceived;
    public final Waiter waiter;
    public final int width;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Waiter {
        public void notifyAll(Object obj) {
            obj.notifyAll();
        }

        public void waitForTimeout(Object obj, long j10) throws InterruptedException {
            obj.wait(j10);
        }
    }

    public RequestFutureTarget(Handler handler, int i10, int i11) {
        this(handler, i10, i11, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long l10) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.assertBackgroundThread) {
            Util.assertBackgroundThread();
        }
        if (!this.isCancelled) {
            if (!this.exceptionReceived) {
                if (this.resultReceived) {
                    return this.resource;
                }
                if (l10 == null) {
                    this.waiter.waitForTimeout(this, 0L);
                } else if (l10.longValue() > 0) {
                    this.waiter.waitForTimeout(this, l10.longValue());
                }
                if (!Thread.interrupted()) {
                    if (!this.exceptionReceived) {
                        if (!this.isCancelled) {
                            if (this.resultReceived) {
                                return this.resource;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.exception);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.exception);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z10) {
        if (this.isCancelled) {
            return true;
        }
        boolean z11 = !isDone();
        if (z11) {
            this.isCancelled = true;
            if (z10) {
                clear();
            }
            this.waiter.notifyAll(this);
        }
        return z11;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.FutureTarget
    public void clear() {
        this.mainHandler.post(this);
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z10;
        if (!this.isCancelled) {
            z10 = this.resultReceived;
        }
        return z10;
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public synchronized void onLoadFailed(Exception exc, Drawable drawable) {
        this.exceptionReceived = true;
        this.exception = exc;
        this.waiter.notifyAll(this);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public synchronized void onResourceReady(R r10, GlideAnimation<? super R> glideAnimation) {
        this.resultReceived = true;
        this.resource = r10;
        this.waiter.notifyAll(this);
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Request request = this.request;
        if (request != null) {
            request.clear();
            cancel(false);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(Request request) {
        this.request = request;
    }

    public RequestFutureTarget(Handler handler, int i10, int i11, boolean z10, Waiter waiter) {
        this.mainHandler = handler;
        this.width = i10;
        this.height = i11;
        this.assertBackgroundThread = z10;
        this.waiter = waiter;
    }

    @Override // java.util.concurrent.Future
    public R get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j10)));
    }
}
