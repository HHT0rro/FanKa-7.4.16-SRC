package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Memoizer<I, O> implements Computable<I, O> {
    private final ConcurrentMap<I, Future<O>> cache;
    private final Computable<I, O> computable;
    private final boolean recalculate;

    public Memoizer(Computable<I, O> computable) {
        this(computable, false);
    }

    private RuntimeException launderException(Throwable th) {
        if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new IllegalStateException("Unchecked exception", th);
    }

    @Override // org.apache.commons.lang3.concurrent.Computable
    public O compute(final I i10) throws InterruptedException {
        FutureTask futureTask;
        while (true) {
            Future<O> future = this.cache.get(i10);
            if (future == null && (future = this.cache.putIfAbsent(i10, (futureTask = new FutureTask(new Callable<O>() { // from class: org.apache.commons.lang3.concurrent.Memoizer.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public O call() throws InterruptedException {
                    return (O) Memoizer.this.computable.compute(i10);
                }
            })))) == null) {
                futureTask.run();
                future = futureTask;
            }
            try {
                continue;
                return future.get();
            } catch (CancellationException unused) {
                this.cache.remove(i10, future);
            } catch (ExecutionException e2) {
                if (this.recalculate) {
                    this.cache.remove(i10, future);
                }
                throw launderException(e2.getCause());
            }
        }
    }

    public Memoizer(Computable<I, O> computable, boolean z10) {
        this.cache = new ConcurrentHashMap();
        this.computable = computable;
        this.recalculate = z10;
    }
}
