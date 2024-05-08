package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class q {
    private final b aeV = new b();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final q aeW = new q();

        static {
            com.kwad.framework.filedownloader.message.e.wf().a(new aa());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        private ThreadPoolExecutor aeX;
        private LinkedBlockingQueue<Runnable> aeY;

        public b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aeY = linkedBlockingQueue;
            this.aeX = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aeY.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aeX.execute(new c(bVar));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c implements Runnable {
        private final x.b aeZ;
        private boolean afa = false;

        public c(x.b bVar) {
            this.aeZ = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aeZ;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.afa) {
                return;
            }
            this.aeZ.start();
        }
    }

    public static q uS() {
        return a.aeW;
    }

    public final synchronized void a(x.b bVar) {
        this.aeV.c(bVar);
    }

    public final synchronized void b(x.b bVar) {
        this.aeV.b(bVar);
    }
}
