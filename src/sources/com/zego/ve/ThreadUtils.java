package com.zego.ve;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ThreadUtils {

    /* renamed from: com.zego.ve.ThreadUtils$1Result, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class C1Result {
        public V value;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ThreadChecker {
        private Thread thread = Thread.currentThread();

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = Thread.currentThread();
            }
            if (Thread.currentThread() != this.thread) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void detachThread() {
            this.thread = null;
        }
    }

    public static void awaitUninterruptibly(final CountDownLatch countDownLatch) {
        executeUninterruptibly(new BlockingOperation() { // from class: com.zego.ve.ThreadUtils.2
            @Override // com.zego.ve.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                CountDownLatch.this.await();
            }
        });
    }

    public static void executeUninterruptibly(BlockingOperation blockingOperation) {
        boolean z10 = false;
        while (true) {
            try {
                blockingOperation.run();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public static <V> V invokeUninterruptibly(Handler handler, final Callable<V> callable) {
        final C1Result c1Result = new C1Result();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() { // from class: com.zego.ve.ThreadUtils.3
            /* JADX WARN: Type inference failed for: r1v2, types: [V, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1Result.this.value = callable.call();
                    countDownLatch.countDown();
                } catch (Exception e2) {
                    RuntimeException runtimeException = new RuntimeException("Callable threw exception: " + ((Object) e2));
                    runtimeException.setStackTrace(e2.getStackTrace());
                    throw runtimeException;
                }
            }
        });
        awaitUninterruptibly(countDownLatch);
        return c1Result.value;
    }

    public static boolean joinUninterruptibly(Thread thread, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z10 = false;
        long j11 = j10;
        while (j11 > 0) {
            try {
                thread.join(j11);
                break;
            } catch (InterruptedException unused) {
                j11 = j10 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z10 = false;
        long j11 = j10;
        boolean z11 = false;
        do {
            try {
                z10 = countDownLatch.await(j11, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException unused) {
                z11 = true;
                j11 = j10 - (SystemClock.elapsedRealtime() - elapsedRealtime);
            }
        } while (j11 > 0);
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return z10;
    }

    public static void invokeUninterruptibly(Handler handler, final Runnable runnable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() { // from class: com.zego.ve.ThreadUtils.4
            @Override // java.lang.Runnable
            public void run() {
                Runnable.this.run();
                countDownLatch.countDown();
            }
        });
        awaitUninterruptibly(countDownLatch);
    }

    public static void joinUninterruptibly(final Thread thread) {
        executeUninterruptibly(new BlockingOperation() { // from class: com.zego.ve.ThreadUtils.1
            @Override // com.zego.ve.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                Thread.this.join();
            }
        });
    }
}
