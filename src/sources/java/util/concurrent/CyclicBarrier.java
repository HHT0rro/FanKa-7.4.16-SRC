package java.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CyclicBarrier {
    private final Runnable barrierCommand;
    private int count;
    private Generation generation;
    private final ReentrantLock lock;
    private final int parties;
    private final Condition trip;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Generation {
        boolean broken;

        Generation() {
        }
    }

    private void nextGeneration() {
        this.trip.signalAll();
        this.count = this.parties;
        this.generation = new Generation();
    }

    private void breakBarrier() {
        this.generation.broken = true;
        this.count = this.parties;
        this.trip.signalAll();
    }

    private int dowait(boolean timed, long nanos) throws InterruptedException, BrokenBarrierException, TimeoutException {
        Generation g3;
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            g3 = this.generation;
        } finally {
        }
        if (g3.broken) {
            throw new BrokenBarrierException();
        }
        if (Thread.interrupted()) {
            breakBarrier();
            throw new InterruptedException();
        }
        int index = this.count - 1;
        this.count = index;
        if (index == 0) {
            Runnable command = this.barrierCommand;
            if (command != null) {
                try {
                    command.run();
                } finally {
                    breakBarrier();
                }
            }
            nextGeneration();
            lock.unlock();
            return 0;
        }
        while (true) {
            if (!timed) {
                try {
                    this.trip.await();
                } catch (InterruptedException ie2) {
                    if (g3 == this.generation && !g3.broken) {
                        throw ie2;
                    }
                    Thread.currentThread().interrupt();
                }
            } else if (nanos > 0) {
                nanos = this.trip.awaitNanos(nanos);
            }
            if (g3.broken) {
                throw new BrokenBarrierException();
            }
            if (g3 != this.generation) {
                return index;
            }
            if (timed && nanos <= 0) {
                breakBarrier();
                throw new TimeoutException();
            }
        }
        lock.unlock();
    }

    public CyclicBarrier(int parties, Runnable barrierAction) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.trip = reentrantLock.newCondition();
        this.generation = new Generation();
        if (parties <= 0) {
            throw new IllegalArgumentException();
        }
        this.parties = parties;
        this.count = parties;
        this.barrierCommand = barrierAction;
    }

    public CyclicBarrier(int parties) {
        this(parties, null);
    }

    public int getParties() {
        return this.parties;
    }

    public int await() throws InterruptedException, BrokenBarrierException {
        try {
            return dowait(false, 0L);
        } catch (TimeoutException toe) {
            throw new Error(toe);
        }
    }

    public int await(long timeout, TimeUnit unit) throws InterruptedException, BrokenBarrierException, TimeoutException {
        return dowait(true, unit.toNanos(timeout));
    }

    public boolean isBroken() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.generation.broken;
        } finally {
            lock.unlock();
        }
    }

    public void reset() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            breakBarrier();
            nextGeneration();
        } finally {
            lock.unlock();
        }
    }

    public int getNumberWaiting() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.parties - this.count;
        } finally {
            lock.unlock();
        }
    }
}
