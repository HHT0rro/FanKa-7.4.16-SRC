package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class TimerTask implements Runnable {
    static final int CANCELLED = 3;
    static final int EXECUTED = 2;
    static final int SCHEDULED = 1;
    static final int VIRGIN = 0;
    long nextExecutionTime;
    final Object lock = new Object();
    int state = 0;
    long period = 0;

    @Override // java.lang.Runnable
    public abstract void run();

    public boolean cancel() {
        boolean result;
        synchronized (this.lock) {
            boolean z10 = true;
            if (this.state != 1) {
                z10 = false;
            }
            result = z10;
            this.state = 3;
        }
        return result;
    }

    public long scheduledExecutionTime() {
        long j10;
        synchronized (this.lock) {
            long j11 = this.period;
            j10 = j11 < 0 ? this.nextExecutionTime + j11 : this.nextExecutionTime - j11;
        }
        return j10;
    }
}
