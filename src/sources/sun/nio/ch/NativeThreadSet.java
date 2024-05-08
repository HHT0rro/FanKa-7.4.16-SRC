package sun.nio.ch;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NativeThreadSet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long[] elts;
    private int used = 0;
    private boolean waitingToEmpty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeThreadSet(int n10) {
        this.elts = new long[n10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int add() {
        long th = NativeThread.current();
        if (th == 0) {
            th = -1;
        }
        synchronized (this) {
            int start = 0;
            int i10 = this.used;
            long[] jArr = this.elts;
            if (i10 >= jArr.length) {
                int on = jArr.length;
                int nn = on * 2;
                long[] nelts = new long[nn];
                System.arraycopy((Object) jArr, 0, (Object) nelts, 0, on);
                this.elts = nelts;
                start = on;
            }
            int i11 = start;
            while (true) {
                long[] jArr2 = this.elts;
                if (i11 >= jArr2.length) {
                    return -1;
                }
                if (jArr2[i11] != 0) {
                    i11++;
                } else {
                    jArr2[i11] = th;
                    this.used++;
                    return i11;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(int i10) {
        synchronized (this) {
            this.elts[i10] = 0;
            int i11 = this.used - 1;
            this.used = i11;
            if (i11 == 0 && this.waitingToEmpty) {
                notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void signalAndWait() {
        boolean interrupted = false;
        while (true) {
            int u10 = this.used;
            if (u10 <= 0) {
                break;
            }
            int n10 = this.elts.length;
            for (int i10 = 0; i10 < n10; i10++) {
                long th = this.elts[i10];
                if (th != 0) {
                    if (th != -1) {
                        NativeThread.signal(th);
                    }
                    u10--;
                    if (u10 == 0) {
                        break;
                    }
                }
            }
            this.waitingToEmpty = true;
            try {
                wait(50L);
            } catch (InterruptedException e2) {
                interrupted = true;
            } catch (Throwable th2) {
                this.waitingToEmpty = false;
                throw th2;
            }
            this.waitingToEmpty = false;
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }
}
