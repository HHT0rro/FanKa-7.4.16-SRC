package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111lIl implements l11l1111I11l {
    private final Executor l1111l111111Il = new ThreadPoolExecutor(0, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.DiscardOldestPolicy());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class l1111l111111Il implements Runnable {
        private final l111l1111lI1l l1111l111111Il;
        private final Runnable l111l11111I1l;
        private final l11l1111lIIl l111l11111lIl;

        public l1111l111111Il(l111l1111lI1l l111l1111li1l, l11l1111lIIl l11l1111liil, Runnable runnable) {
            this.l1111l111111Il = l111l1111li1l;
            this.l111l11111lIl = l11l1111liil;
            this.l111l11111I1l = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.l1111l111111Il.l11l1111I11l()) {
                this.l1111l111111Il.l111l11111lIl("canceled-at-delivery");
                return;
            }
            if (this.l111l11111lIl.l1111l111111Il()) {
                this.l1111l111111Il.l1111l111111Il((l111l1111lI1l) this.l111l11111lIl.l1111l111111Il);
            } else {
                this.l1111l111111Il.l1111l111111Il(this.l111l11111lIl.l111l11111lIl);
            }
            this.l1111l111111Il.l111l11111lIl("done");
            Runnable runnable = this.l111l11111I1l;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I11l
    public final void l1111l111111Il(l111l1111lI1l<?> l111l1111li1l, l11l1111I1ll l11l1111i1ll) {
        l111l1111li1l.l1111l111111Il("post-error");
        this.l1111l111111Il.execute(new l1111l111111Il(l111l1111li1l, l11l1111lIIl.l1111l111111Il(l11l1111i1ll), null));
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I11l
    public final void l1111l111111Il(l111l1111lI1l<?> l111l1111li1l, l11l1111lIIl<?> l11l1111liil) {
        l111l1111li1l.l11l11IlIIll();
        l111l1111li1l.l1111l111111Il("post-response");
        this.l1111l111111Il.execute(new l1111l111111Il(l111l1111li1l, l11l1111liil, null));
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I11l
    public final void l1111l111111Il(l111l1111lI1l<?> l111l1111li1l, l11l1111lIIl<?> l11l1111liil, Runnable runnable) {
        l111l1111li1l.l11l11IlIIll();
        l111l1111li1l.l1111l111111Il("post-response");
        this.l1111l111111Il.execute(new l1111l111111Il(l111l1111li1l, l11l1111liil, null));
    }
}
