package sun.nio.fs;

import java.util.concurrent.ExecutionException;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
abstract class Cancellable implements Runnable {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private boolean completed;
    private Throwable exception;
    private final Object lock = new Object();
    private final long pollingAddress;

    abstract void implRun() throws Throwable;

    /* JADX INFO: Access modifiers changed from: protected */
    public Cancellable() {
        Unsafe unsafe2 = unsafe;
        long allocateMemory = unsafe2.allocateMemory(4L);
        this.pollingAddress = allocateMemory;
        unsafe2.putIntVolatile(null, allocateMemory, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long addressToPollForCancel() {
        return this.pollingAddress;
    }

    protected int cancelValue() {
        return Integer.MAX_VALUE;
    }

    final void cancel() {
        synchronized (this.lock) {
            if (!this.completed) {
                unsafe.putIntVolatile(null, this.pollingAddress, cancelValue());
            }
        }
    }

    private Throwable exception() {
        Throwable th;
        synchronized (this.lock) {
            th = this.exception;
        }
        return th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            implRun();
            synchronized (this.lock) {
                this.completed = true;
                unsafe.freeMemory(this.pollingAddress);
            }
        } catch (Throwable t2) {
            try {
                synchronized (this.lock) {
                    this.exception = t2;
                    synchronized (this.lock) {
                        this.completed = true;
                        unsafe.freeMemory(this.pollingAddress);
                    }
                }
            } catch (Throwable t10) {
                synchronized (this.lock) {
                    this.completed = true;
                    unsafe.freeMemory(this.pollingAddress);
                    throw t10;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runInterruptibly(Cancellable task) throws ExecutionException {
        Thread t2 = new Thread(task);
        t2.start();
        boolean cancelledByInterrupt = false;
        while (t2.isAlive()) {
            try {
                t2.join();
            } catch (InterruptedException e2) {
                cancelledByInterrupt = true;
                task.cancel();
            }
        }
        if (cancelledByInterrupt) {
            Thread.currentThread().interrupt();
        }
        Throwable exc = task.exception();
        if (exc != null) {
            throw new ExecutionException(exc);
        }
    }
}
