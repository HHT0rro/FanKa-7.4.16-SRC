package org.apache.commons.io;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class ThreadMonitor implements Runnable {
    private final Thread thread;
    private final long timeout;

    private ThreadMonitor(Thread thread, long j10) {
        this.thread = thread;
        this.timeout = j10;
    }

    public static Thread start(long j10) {
        return start(Thread.currentThread(), j10);
    }

    public static void stop(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(this.timeout);
            this.thread.interrupt();
        } catch (InterruptedException unused) {
        }
    }

    public static Thread start(Thread thread, long j10) {
        if (j10 <= 0) {
            return null;
        }
        Thread thread2 = new Thread(new ThreadMonitor(thread, j10), ThreadMonitor.class.getSimpleName());
        thread2.setDaemon(true);
        thread2.start();
        return thread2;
    }
}
