package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ap;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class k {
    private final m aCp;
    private final com.kwad.sdk.core.videocache.a aCq;
    private volatile Thread aCu;
    private volatile boolean kI;
    private final Object aCr = new Object();
    private final Object aCs = new Object();
    private volatile int aCv = -1;
    private final AtomicInteger aCt = new AtomicInteger();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.GD();
        }

        public /* synthetic */ a(k kVar, byte b4) {
            this();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aCp = (m) ap.checkNotNull(mVar);
        this.aCq = (com.kwad.sdk.core.videocache.a) ap.checkNotNull(aVar);
    }

    private void GA() {
        int i10 = this.aCt.get();
        if (i10 <= 0) {
            return;
        }
        this.aCt.set(0);
        throw new ProxyCacheException("Error reading source " + i10 + " times");
    }

    private synchronized void GB() {
        byte b4 = 0;
        boolean z10 = (this.aCu == null || this.aCu.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.kI && !this.aCq.isCompleted() && !z10) {
            this.aCu = new Thread(new a(this, b4), "Source reader for " + ((Object) this.aCp));
            this.aCu.start();
        }
    }

    private void GC() {
        synchronized (this.aCr) {
            try {
                try {
                    this.aCr.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void GD() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aCq     // Catch: java.lang.Throwable -> L49
            long r2 = r4.Go()     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.aCp     // Catch: java.lang.Throwable -> L49
            r4.at(r2)     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.aCp     // Catch: java.lang.Throwable -> L49
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L49
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L49
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.aCp     // Catch: java.lang.Throwable -> L49
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L49
            r6 = -1
            if (r5 == r6) goto L42
            java.lang.Object r6 = r8.aCs     // Catch: java.lang.Throwable -> L49
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L49
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
        L2c:
            r8.GF()
            r8.j(r2, r0)
            return
        L33:
            com.kwad.sdk.core.videocache.a r7 = r8.aCq     // Catch: java.lang.Throwable -> L3f
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.j(r2, r0)     // Catch: java.lang.Throwable -> L49
            goto L19
        L3f:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r4     // Catch: java.lang.Throwable -> L49
        L42:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L49
            r8.GE()     // Catch: java.lang.Throwable -> L49
            goto L2c
        L49:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aCt     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            onError(r4)     // Catch: java.lang.Throwable -> L53
            goto L2c
        L53:
            r4 = move-exception
            r8.GF()
            r8.j(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.GD():void");
    }

    private void GE() {
        this.aCv = 100;
        dr(this.aCv);
    }

    private void GF() {
        try {
            this.aCp.close();
        } catch (ProxyCacheException e2) {
            onError(new ProxyCacheException("Error closing source " + ((Object) this.aCp), e2));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.kI;
    }

    private void j(long j10, long j11) {
        k(j10, j11);
        synchronized (this.aCr) {
            this.aCr.notifyAll();
        }
    }

    private void k(long j10, long j11) {
        int i10 = (j11 > 0L ? 1 : (j11 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j10) / ((float) j11)) * 100.0f);
        boolean z10 = i10 != this.aCv;
        if ((j11 >= 0) && z10) {
            dr(i10);
        }
        this.aCv = i10;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.e.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.e.c.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aCs) {
            if (!isStopped() && this.aCq.Go() == this.aCp.length()) {
                this.aCq.complete();
            }
        }
    }

    public void dr(int i10) {
    }

    public final void shutdown() {
        synchronized (this.aCs) {
            com.kwad.sdk.core.e.c.d("ProxyCache", "Shutdown proxy for " + ((Object) this.aCp));
            try {
                this.kI = true;
                if (this.aCu != null) {
                    this.aCu.interrupt();
                }
                this.aCq.close();
            } catch (ProxyCacheException e2) {
                onError(e2);
            }
        }
    }

    public final int a(byte[] bArr, long j10, int i10) {
        l.b(bArr, j10, 1024);
        while (!this.aCq.isCompleted() && this.aCq.Go() < 1024 + j10 && !this.kI) {
            GB();
            GC();
            GA();
        }
        int a10 = this.aCq.a(bArr, j10, 1024);
        if (this.aCq.isCompleted() && this.aCv != 100) {
            this.aCv = 100;
            dr(100);
        }
        return a10;
    }
}
