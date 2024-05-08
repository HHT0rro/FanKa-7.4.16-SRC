package java.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractExecutorService implements ExecutorService {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new FutureTask(runnable, value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureTask(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable task) {
        if (task == null) {
            throw new NullPointerException();
        }
        RunnableFuture<Void> ftask = newTaskFor(task, null);
        execute(ftask);
        return ftask;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable task, T result) {
        if (task == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> ftask = newTaskFor(task, result);
        execute(ftask);
        return ftask;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
        return ftask;
    }

    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks, boolean timed, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        long deadline;
        if (tasks == null) {
            throw new NullPointerException();
        }
        int ntasks = tasks.size();
        if (ntasks == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Future<T>> futures = new ArrayList<>(ntasks);
        ExecutorCompletionService<T> ecs = new ExecutorCompletionService<>(this);
        ExecutionException ee2 = null;
        if (!timed) {
            deadline = 0;
        } else {
            try {
                deadline = System.nanoTime() + nanos;
            } catch (Throwable ee3) {
                cancelAll(futures);
                throw ee3;
            }
        }
        Iterator<? extends Callable<T>> it = tasks.iterator2();
        futures.add(ecs.submit(it.next()));
        int ntasks2 = ntasks - 1;
        int active = 1;
        while (true) {
            Future<T> f10 = ecs.poll();
            if (f10 == null) {
                if (ntasks2 > 0) {
                    ntasks2--;
                    futures.add(ecs.submit(it.next()));
                    active++;
                } else if (active != 0) {
                    if (timed) {
                        f10 = ecs.poll(nanos, TimeUnit.NANOSECONDS);
                        if (f10 == null) {
                            throw new TimeoutException();
                        }
                        nanos = deadline - System.nanoTime();
                    } else {
                        f10 = ecs.take();
                    }
                } else {
                    if (ee2 != null) {
                        throw ee2;
                    }
                    ExecutionException ee4 = new ExecutionException();
                    throw ee4;
                }
            }
            if (f10 != null) {
                active--;
                try {
                    T t2 = f10.get();
                    cancelAll(futures);
                    return t2;
                } catch (RuntimeException rex) {
                    ee2 = new ExecutionException(rex);
                } catch (ExecutionException eex) {
                    ee2 = eex;
                }
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        try {
            return (T) doInvokeAny(collection, false, 0L);
        } catch (TimeoutException e2) {
            return null;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) doInvokeAny(collection, true, timeUnit.toNanos(j10));
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        if (tasks == null) {
            throw new NullPointerException();
        }
        ArrayList<Future<T>> futures = new ArrayList<>(tasks.size());
        try {
            for (Callable<T> t2 : tasks) {
                RunnableFuture<T> f10 = newTaskFor(t2);
                futures.add(f10);
                execute(f10);
            }
            int size = futures.size();
            for (int i10 = 0; i10 < size; i10++) {
                Future<T> f11 = futures.get(i10);
                if (!f11.isDone()) {
                    try {
                        f11.get();
                    } catch (CancellationException | ExecutionException e2) {
                    }
                }
            }
            return futures;
        } catch (Throwable t10) {
            cancelAll(futures);
            throw t10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        if (r10 >= r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        r0 = r0.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (r0.isDone() != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        r0.get(r7 - java.lang.System.nanoTime(), java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
    
        return r0;
     */
    @Override // java.util.concurrent.ExecutorService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> r17, long r18, java.util.concurrent.TimeUnit r20) throws java.lang.InterruptedException {
        /*
            r16 = this;
            r1 = r16
            if (r17 == 0) goto L85
            r2 = r18
            r4 = r20
            long r5 = r4.toNanos(r2)
            long r7 = java.lang.System.nanoTime()
            long r7 = r7 + r5
            java.util.ArrayList r0 = new java.util.ArrayList
            int r9 = r17.size()
            r0.<init>(r9)
            r9 = r0
            r10 = 0
            java.util.Iterator r0 = r17.iterator2()     // Catch: java.lang.Throwable -> L80
        L20:
            boolean r11 = r0.hasNext()     // Catch: java.lang.Throwable -> L80
            if (r11 == 0) goto L34
            java.lang.Object r11 = r0.next()     // Catch: java.lang.Throwable -> L80
            java.util.concurrent.Callable r11 = (java.util.concurrent.Callable) r11     // Catch: java.lang.Throwable -> L80
            java.util.concurrent.RunnableFuture r12 = r1.newTaskFor(r11)     // Catch: java.lang.Throwable -> L80
            r9.add(r12)     // Catch: java.lang.Throwable -> L80
            goto L20
        L34:
            int r0 = r9.size()     // Catch: java.lang.Throwable -> L80
            r11 = r0
            r0 = 0
        L3a:
            if (r0 >= r11) goto L59
            if (r0 != 0) goto L40
            r12 = r5
            goto L46
        L40:
            long r12 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L80
            long r12 = r7 - r12
        L46:
            r14 = 0
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 > 0) goto L4d
            goto L76
        L4d:
            java.lang.Object r12 = r9.get(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.Runnable r12 = (java.lang.Runnable) r12     // Catch: java.lang.Throwable -> L80
            r1.execute(r12)     // Catch: java.lang.Throwable -> L80
            int r0 = r0 + 1
            goto L3a
        L59:
            if (r10 >= r11) goto L7f
            java.lang.Object r0 = r9.get(r10)     // Catch: java.lang.Throwable -> L80
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0     // Catch: java.lang.Throwable -> L80
            r12 = r0
            boolean r0 = r12.isDone()     // Catch: java.lang.Throwable -> L80
            if (r0 != 0) goto L7c
            long r13 = java.lang.System.nanoTime()     // Catch: java.util.concurrent.TimeoutException -> L74 java.lang.Throwable -> L7a java.lang.Throwable -> L80
            long r13 = r7 - r13
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.util.concurrent.TimeoutException -> L74 java.lang.Throwable -> L7a java.lang.Throwable -> L80
            r12.get(r13, r0)     // Catch: java.util.concurrent.TimeoutException -> L74 java.lang.Throwable -> L7a java.lang.Throwable -> L80
            goto L7b
        L74:
            r0 = move-exception
        L76:
            cancelAll(r9, r10)
            return r9
        L7a:
            r0 = move-exception
        L7b:
        L7c:
            int r10 = r10 + 1
            goto L59
        L7f:
            return r9
        L80:
            r0 = move-exception
            cancelAll(r9)
            throw r0
        L85:
            r2 = r18
            r4 = r20
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.AbstractExecutorService.invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit):java.util.List");
    }

    private static <T> void cancelAll(ArrayList<Future<T>> futures) {
        cancelAll(futures, 0);
    }

    private static <T> void cancelAll(ArrayList<Future<T>> futures, int j10) {
        int size = futures.size();
        while (j10 < size) {
            futures.get(j10).cancel(true);
            j10++;
        }
    }
}
