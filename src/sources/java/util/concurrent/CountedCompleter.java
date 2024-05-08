package java.util.concurrent;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.ForkJoinPool;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CountedCompleter<T> extends ForkJoinTask<T> {
    private static final VarHandle PENDING;
    private static final long serialVersionUID = 5232453752276485070L;
    final CountedCompleter<?> completer;
    volatile int pending;

    public abstract void compute();

    /* JADX INFO: Access modifiers changed from: protected */
    public CountedCompleter(CountedCompleter<?> completer, int initialPendingCount) {
        this.completer = completer;
        this.pending = initialPendingCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CountedCompleter(CountedCompleter<?> completer) {
        this.completer = completer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CountedCompleter() {
        this.completer = null;
    }

    public void onCompletion(CountedCompleter<?> caller) {
    }

    public boolean onExceptionalCompletion(Throwable ex, CountedCompleter<?> caller) {
        return true;
    }

    public final CountedCompleter<?> getCompleter() {
        return this.completer;
    }

    public final int getPendingCount() {
        return this.pending;
    }

    public final void setPendingCount(int count) {
        this.pending = count;
    }

    public final void addToPendingCount(int delta) {
        (void) PENDING.getAndAdd(this, delta);
    }

    public final boolean compareAndSetPendingCount(int expected, int count) {
        return (boolean) PENDING.compareAndSet(this, expected, count);
    }

    final boolean weakCompareAndSetPendingCount(int expected, int count) {
        return (boolean) PENDING.weakCompareAndSet(this, expected, count);
    }

    public final int decrementPendingCountUnlessZero() {
        int c4;
        do {
            c4 = this.pending;
            if (c4 == 0) {
                break;
            }
        } while (!weakCompareAndSetPendingCount(c4, c4 - 1));
        return c4;
    }

    public final CountedCompleter<?> getRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter p10 = countedCompleter.completer;
            if (p10 != null) {
                countedCompleter = p10;
            } else {
                return countedCompleter;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void tryComplete() {
        CountedCompleter countedCompleter = this;
        CountedCompleter s2 = countedCompleter;
        while (true) {
            int c4 = countedCompleter.pending;
            if (c4 == 0) {
                countedCompleter.onCompletion(s2);
                s2 = countedCompleter;
                CountedCompleter countedCompleter2 = countedCompleter.completer;
                countedCompleter = countedCompleter2;
                if (countedCompleter2 == null) {
                    s2.quietlyComplete();
                    return;
                }
            } else if (countedCompleter.weakCompareAndSetPendingCount(c4, c4 - 1)) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void propagateCompletion() {
        CountedCompleter countedCompleter = this;
        while (true) {
            int c4 = countedCompleter.pending;
            if (c4 == 0) {
                CountedCompleter countedCompleter2 = countedCompleter;
                CountedCompleter countedCompleter3 = countedCompleter.completer;
                countedCompleter = countedCompleter3;
                if (countedCompleter3 == null) {
                    countedCompleter2.quietlyComplete();
                    return;
                }
            } else if (countedCompleter.weakCompareAndSetPendingCount(c4, c4 - 1)) {
                return;
            }
        }
    }

    @Override // java.util.concurrent.ForkJoinTask
    public void complete(T rawResult) {
        setRawResult(rawResult);
        onCompletion(this);
        quietlyComplete();
        CountedCompleter<?> p10 = this.completer;
        if (p10 != null) {
            p10.tryComplete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CountedCompleter<?> firstComplete() {
        int c4;
        do {
            c4 = this.pending;
            if (c4 == 0) {
                return this;
            }
        } while (!weakCompareAndSetPendingCount(c4, c4 - 1));
        return null;
    }

    public final CountedCompleter<?> nextComplete() {
        CountedCompleter<?> p10 = this.completer;
        if (p10 != null) {
            return p10.firstComplete();
        }
        quietlyComplete();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void quietlyCompleteRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter.completer;
            if (countedCompleter2 == null) {
                countedCompleter.quietlyComplete();
                return;
            }
            countedCompleter = countedCompleter2;
        }
    }

    public final void helpComplete(int maxTasks) {
        ForkJoinPool.WorkQueue q10;
        Thread t2 = Thread.currentThread();
        boolean owned = t2 instanceof ForkJoinWorkerThread;
        if (owned) {
            q10 = ((ForkJoinWorkerThread) t2).workQueue;
        } else {
            q10 = ForkJoinPool.commonQueue();
        }
        if (q10 != null && maxTasks > 0) {
            q10.helpComplete(this, owned, maxTasks);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ForkJoinTask
    final int trySetException(Throwable ex) {
        CountedCompleter countedCompleter = this;
        CountedCompleter p10 = countedCompleter;
        while (isExceptionalStatus(countedCompleter.trySetThrown(ex)) && countedCompleter.onExceptionalCompletion(ex, p10)) {
            p10 = countedCompleter;
            CountedCompleter countedCompleter2 = countedCompleter.completer;
            countedCompleter = countedCompleter2;
            if (countedCompleter2 == null || countedCompleter.status < 0) {
                break;
            }
        }
        return this.status;
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        compute();
        return false;
    }

    @Override // java.util.concurrent.ForkJoinTask
    public T getRawResult() {
        return null;
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected void setRawResult(T t2) {
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            PENDING = l10.findVarHandle(CountedCompleter.class, "pending", Integer.TYPE);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
