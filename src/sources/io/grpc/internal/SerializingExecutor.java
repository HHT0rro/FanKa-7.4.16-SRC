package io.grpc.internal;

import com.google.common.base.o;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SerializingExecutor implements Executor, Runnable {
    private static final int RUNNING = -1;
    private static final int STOPPED = 0;
    private Executor executor;
    private final Queue<Runnable> runQueue = new ConcurrentLinkedQueue();
    private volatile int runState = 0;
    private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
    private static final AtomicHelper atomicHelper = getAtomicHelper();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean runStateCompareAndSet(SerializingExecutor serializingExecutor, int i10, int i11);

        public abstract void runStateSet(SerializingExecutor serializingExecutor, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class FieldUpdaterAtomicHelper extends AtomicHelper {
        private final AtomicIntegerFieldUpdater<SerializingExecutor> runStateUpdater;

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public boolean runStateCompareAndSet(SerializingExecutor serializingExecutor, int i10, int i11) {
            return this.runStateUpdater.compareAndSet(serializingExecutor, i10, i11);
        }

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public void runStateSet(SerializingExecutor serializingExecutor, int i10) {
            this.runStateUpdater.set(serializingExecutor, i10);
        }

        private FieldUpdaterAtomicHelper(AtomicIntegerFieldUpdater<SerializingExecutor> atomicIntegerFieldUpdater) {
            super();
            this.runStateUpdater = atomicIntegerFieldUpdater;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public boolean runStateCompareAndSet(SerializingExecutor serializingExecutor, int i10, int i11) {
            synchronized (serializingExecutor) {
                if (serializingExecutor.runState != i10) {
                    return false;
                }
                serializingExecutor.runState = i11;
                return true;
            }
        }

        @Override // io.grpc.internal.SerializingExecutor.AtomicHelper
        public void runStateSet(SerializingExecutor serializingExecutor, int i10) {
            synchronized (serializingExecutor) {
                serializingExecutor.runState = i10;
            }
        }
    }

    public SerializingExecutor(Executor executor) {
        o.s(executor, "'executor' must not be null.");
        this.executor = executor;
    }

    private static AtomicHelper getAtomicHelper() {
        try {
            return new FieldUpdaterAtomicHelper(AtomicIntegerFieldUpdater.newUpdater(SerializingExecutor.class, "runState"));
        } catch (Throwable th) {
            log.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new SynchronizedAtomicHelper();
        }
    }

    private void schedule(Runnable runnable) {
        if (atomicHelper.runStateCompareAndSet(this, 0, -1)) {
            try {
                this.executor.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.runQueue.remove(runnable);
                }
                atomicHelper.runStateSet(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.runQueue.add((Runnable) o.s(runnable, "'r' must not be null."));
        schedule(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable poll;
        try {
            Executor executor = this.executor;
            while (executor == this.executor && (poll = this.runQueue.poll()) != null) {
                try {
                    poll.run();
                } catch (RuntimeException e2) {
                    log.log(Level.SEVERE, "Exception while executing runnable " + ((Object) poll), (Throwable) e2);
                }
            }
            atomicHelper.runStateSet(this, 0);
            if (this.runQueue.isEmpty()) {
                return;
            }
            schedule(null);
        } catch (Throwable th) {
            atomicHelper.runStateSet(this, 0);
            throw th;
        }
    }

    public void setExecutor(Executor executor) {
        o.s(executor, "'executor' must not be null.");
        this.executor = executor;
    }
}
