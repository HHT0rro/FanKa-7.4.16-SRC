package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d implements Handler.Callback {
    private volatile Thread afv;
    private final a agI;
    private final int agJ;
    private final int agK;
    private final int agL;
    private long agM;
    private HandlerThread agN;
    private volatile boolean agQ;
    private final com.kwad.framework.filedownloader.d.c aga;
    private Handler handler;
    private volatile boolean agO = false;
    private volatile long agu = 0;
    private final AtomicLong agP = new AtomicLong();
    private boolean agR = true;
    private final com.kwad.framework.filedownloader.b.a afV = b.vo().vq();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private boolean agS;
        private Exception agT;
        private int agU;

        public final void be(boolean z10) {
            this.agS = z10;
        }

        public final void bu(int i10) {
            this.agU = i10;
        }

        public final void f(Exception exc) {
            this.agT = exc;
        }

        public final Exception getException() {
            return this.agT;
        }

        public final int tZ() {
            return this.agU;
        }

        public final boolean vQ() {
            return this.agS;
        }
    }

    public d(com.kwad.framework.filedownloader.d.c cVar, int i10, int i11, int i12) {
        this.aga = cVar;
        this.agK = i11 < 5 ? 5 : i11;
        this.agL = i12;
        this.agI = new a();
        this.agJ = i10;
    }

    private boolean P(long j10) {
        if (!this.agR) {
            return this.agM != -1 && this.agP.get() >= this.agM && j10 - this.agu >= ((long) this.agK);
        }
        this.agR = false;
        return true;
    }

    private synchronized void b(Message message) {
        if (!this.agN.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e2) {
            if (!this.agN.isAlive()) {
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    return;
                }
                return;
            }
            throw e2;
        }
    }

    private Exception d(Exception exc) {
        long length;
        String vD = this.aga.vD();
        if ((!this.aga.isChunked() && !com.kwad.framework.filedownloader.f.e.wN().air) || !(exc instanceof IOException) || !new File(vD).exists()) {
            return exc;
        }
        long availableBytes = h.getAvailableBytes(vD);
        if (availableBytes > 4096) {
            return exc;
        }
        File file = new File(vD);
        if (!file.exists()) {
            com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        } else {
            length = file.length();
        }
        return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception d10 = d(exc);
        if (d10 instanceof SQLiteFullException) {
            a((SQLiteFullException) d10);
            exc2 = d10;
        } else {
            try {
                this.aga.d((byte) -1);
                this.aga.bo(exc.toString());
                this.afV.a(this.aga.getId(), d10, this.aga.wl());
                exc2 = d10;
            } catch (SQLiteFullException e2) {
                SQLiteFullException sQLiteFullException = e2;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.agI.f(exc2);
        c((byte) -1);
    }

    private static long h(long j10, long j11) {
        if (j11 <= 0) {
            return -1L;
        }
        if (j10 == -1) {
            return 1L;
        }
        long j12 = j10 / (j11 + 1);
        if (j12 <= 0) {
            return 1L;
        }
        return j12;
    }

    private void vM() {
        String vD = this.aga.vD();
        String targetFilePath = this.aga.getTargetFilePath();
        File file = new File(vD);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
            }
            if (file.renameTo(file2)) {
                if (!file.exists() || file.delete()) {
                    return;
                }
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", vD);
                return;
            }
            throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't rename the  temp downloaded file(%s) to the target file(%s)", vD, targetFilePath));
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", vD);
            }
            throw th;
        }
    }

    private void vN() {
        vM();
        this.aga.d((byte) -3);
        this.afV.c(this.aga.getId(), this.aga.getTotal());
        this.afV.bm(this.aga.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.wN().ais) {
            com.kwad.framework.filedownloader.services.f.f(this.aga);
        }
    }

    private boolean vO() {
        if (this.aga.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.aga;
            cVar.U(cVar.wl());
        } else if (this.aga.wl() != this.aga.getTotal()) {
            c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("sofar[%d] not equal total[%d]", Long.valueOf(this.aga.wl()), Long.valueOf(this.aga.getTotal()))));
            return true;
        }
        return false;
    }

    private void vP() {
        this.aga.d((byte) -2);
        this.afV.d(this.aga.getId(), this.aga.wl());
        c((byte) -2);
    }

    public final void a(boolean z10, long j10, String str, String str2) {
        String wm = this.aga.wm();
        if (wm != null && !wm.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, wm));
        }
        this.agI.be(z10);
        this.aga.d((byte) 2);
        this.aga.U(j10);
        this.aga.bn(str);
        this.aga.bp(str2);
        this.afV.a(this.aga.getId(), j10, str, str2);
        c((byte) 2);
        this.agM = h(j10, this.agL);
        this.agQ = true;
    }

    public final void c(Exception exc) {
        e(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.agO = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L17
            r2 = 5
            if (r1 == r2) goto Ld
            goto L1e
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L2a
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L2a
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L2a
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L2a
            goto L1e
        L17:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L2a
            r4.b(r1, r0)     // Catch: java.lang.Throwable -> L2a
        L1e:
            r4.agO = r3
            java.lang.Thread r5 = r4.afv
            if (r5 == 0) goto L29
            java.lang.Thread r5 = r4.afv
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L29:
            return r0
        L2a:
            r5 = move-exception
            r4.agO = r3
            java.lang.Thread r0 = r4.afv
            if (r0 == 0) goto L36
            java.lang.Thread r0 = r4.afv
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L36:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.agN;
        return handlerThread != null && handlerThread.isAlive();
    }

    public final void onProgress(long j10) {
        this.agP.addAndGet(j10);
        this.aga.T(j10);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean P = P(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(elapsedRealtime, P);
        } else if (P) {
            b(handler.obtainMessage(3));
        }
    }

    public final void vG() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.agN.quit();
            this.afv = Thread.currentThread();
            while (this.agO) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.afv = null;
        }
    }

    public final void vH() {
        this.aga.d((byte) 1);
        this.afV.bo(this.aga.getId());
        c((byte) 1);
    }

    public final void vI() {
        this.aga.d((byte) 6);
        c((byte) 6);
        this.afV.bj(this.aga.getId());
    }

    public final void vJ() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.agN = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.agN.getLooper(), this);
    }

    public final void vK() {
        vP();
    }

    public final void vL() {
        if (vO()) {
            return;
        }
        vN();
    }

    private void c(byte b4) {
        if (b4 == -2) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.aga.getId()));
                return;
            }
            return;
        }
        com.kwad.framework.filedownloader.message.e.wf().s(com.kwad.framework.filedownloader.message.f.a(b4, this.aga, this.agI));
    }

    private void b(long j10, boolean z10) {
        if (this.aga.wl() == this.aga.getTotal()) {
            this.afV.b(this.aga.getId(), this.aga.wl());
            return;
        }
        if (this.agQ) {
            this.agQ = false;
            this.aga.d((byte) 3);
        }
        if (z10) {
            this.agu = j10;
            c((byte) 3);
            this.agP.set(0L);
        }
    }

    public final void a(Exception exc, int i10, long j10) {
        this.agP.set(0L);
        this.aga.T(-j10);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i10);
        } else {
            b(handler.obtainMessage(5, i10, 0, exc));
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id2 = this.aga.getId();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id2), sQLiteFullException.toString());
        }
        this.aga.bo(sQLiteFullException.toString());
        this.aga.d((byte) -1);
        this.afV.bn(id2);
        this.afV.bm(id2);
    }

    private void a(Exception exc, int i10) {
        Exception d10 = d(exc);
        this.agI.f(d10);
        this.agI.bu(this.agJ - i10);
        this.aga.d((byte) 5);
        this.aga.bo(d10.toString());
        this.afV.a(this.aga.getId(), d10);
        c((byte) 5);
    }
}
