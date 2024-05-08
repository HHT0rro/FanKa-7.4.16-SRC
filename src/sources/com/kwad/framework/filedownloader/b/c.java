package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements a {
    private volatile Thread afv;
    private Handler handler;
    private volatile List<Integer> aft = new CopyOnWriteArrayList();
    private AtomicInteger afu = new AtomicInteger();
    private final b afq = new b();
    private final d afr = new d();
    private final long afs = com.kwad.framework.filedownloader.f.e.wN().ain;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.bx("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 0) {
                    if (c.this.afv != null) {
                        LockSupport.unpark(c.this.afv);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.afu.set(i10);
                    c.this.bp(i10);
                    c.this.aft.add(Integer.valueOf(i10));
                    return false;
                } finally {
                    c.this.afu.set(0);
                    if (c.this.afv != null) {
                        LockSupport.unpark(c.this.afv);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i10) {
        this.afr.b(this.afq.bk(i10));
        List<com.kwad.framework.filedownloader.d.a> bl = this.afq.bl(i10);
        this.afr.bm(i10);
        Iterator<com.kwad.framework.filedownloader.d.a> iterator2 = bl.iterator2();
        while (iterator2.hasNext()) {
            this.afr.a(iterator2.next());
        }
    }

    private boolean bq(int i10) {
        return !this.aft.contains(Integer.valueOf(i10));
    }

    private void br(int i10) {
        this.handler.removeMessages(i10);
        if (this.afu.get() == i10) {
            this.afv = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        bp(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i10) {
        this.handler.sendEmptyMessageDelayed(i10, this.afs);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i10) {
        return this.afq.bk(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i10) {
        return this.afq.bl(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i10) {
        this.afq.bm(i10);
        if (bq(i10)) {
            return;
        }
        this.afr.bm(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i10) {
        this.afr.bn(i10);
        return this.afq.bn(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i10) {
        this.afq.bo(i10);
        if (bq(i10)) {
            return;
        }
        this.afr.bo(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.afq.clear();
        this.afr.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i10, long j10) {
        this.afq.d(i10, j10);
        if (bq(i10)) {
            br(i10);
        }
        this.afr.d(i10, j10);
        this.aft.remove(Integer.valueOf(i10));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i10, int i11) {
        this.afq.s(i10, i11);
        if (bq(i10)) {
            return;
        }
        this.afr.s(i10, i11);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0495a vf() {
        d dVar = this.afr;
        b bVar = this.afq;
        return dVar.a(bVar.afn, bVar.afo);
    }

    public static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.afv = null;
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i10, long j10) {
        this.afq.b(i10, j10);
        if (bq(i10)) {
            return;
        }
        this.afr.b(i10, j10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i10, long j10) {
        this.afq.c(i10, j10);
        if (bq(i10)) {
            this.handler.removeMessages(i10);
            if (this.afu.get() == i10) {
                this.afv = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.aft.remove(Integer.valueOf(i10));
        }
        this.afr.c(i10, j10);
        this.aft.remove(Integer.valueOf(i10));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.afq.a(aVar);
        if (bq(aVar.getId())) {
            return;
        }
        this.afr.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.afq.b(cVar);
        if (bq(cVar.getId())) {
            return;
        }
        this.afr.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, int i11, long j10) {
        this.afq.a(i10, i11, j10);
        if (bq(i10)) {
            return;
        }
        this.afr.a(i10, i11, j10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, String str, long j10, long j11, int i11) {
        this.afq.a(i10, str, j10, j11, i11);
        if (bq(i10)) {
            return;
        }
        this.afr.a(i10, str, j10, j11, i11);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, long j10, String str, String str2) {
        this.afq.a(i10, j10, str, str2);
        if (bq(i10)) {
            return;
        }
        this.afr.a(i10, j10, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th) {
        this.afq.a(i10, th);
        if (bq(i10)) {
            return;
        }
        this.afr.a(i10, th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th, long j10) {
        this.afq.a(i10, th, j10);
        if (bq(i10)) {
            br(i10);
        }
        this.afr.a(i10, th, j10);
        this.aft.remove(Integer.valueOf(i10));
    }
}
