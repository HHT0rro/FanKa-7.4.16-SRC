package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: ListenableFutureTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class o<V> extends FutureTask<V> implements n<V> {

    /* renamed from: b, reason: collision with root package name */
    public final f f26822b;

    public o(Callable<V> callable) {
        super(callable);
        this.f26822b = new f();
    }

    public static <V> o<V> a(Callable<V> callable) {
        return new o<>(callable);
    }

    @Override // com.google.common.util.concurrent.n
    public void addListener(Runnable runnable, Executor executor) {
        this.f26822b.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.f26822b.b();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        long nanos = timeUnit.toNanos(j10);
        if (nanos <= 2147483647999999999L) {
            return (V) super.get(j10, timeUnit);
        }
        return (V) super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }
}
