package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {
    public static int aeG = 10;
    public static int aeH = 5;
    private final Executor aeC;
    private final LinkedBlockingQueue<t> aeD;
    private final Object aeE;
    private final ArrayList<t> aeF;
    private final Handler handler;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final j aeK = new j(0);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b implements Handler.Callback {
        private b() {
        }

        public /* synthetic */ b(byte b4) {
            this();
        }

        private static void a(ArrayList<t> arrayList) {
            Iterator<t> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().uH();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                ((t) message.obj).uH();
            } else if (i10 == 2) {
                a((ArrayList) message.obj);
                j.uD().push();
            }
            return true;
        }
    }

    public /* synthetic */ j(byte b4) {
        this();
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.aeE) {
            this.aeD.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.aeE) {
            if (this.aeF.isEmpty()) {
                if (this.aeD.isEmpty()) {
                    return;
                }
                int i10 = 0;
                if (!uE()) {
                    this.aeD.drainTo(this.aeF);
                } else {
                    int i11 = aeG;
                    int min = Math.min(this.aeD.size(), aeH);
                    while (i10 < min) {
                        this.aeF.add(this.aeD.remove());
                        i10++;
                    }
                    i10 = i11;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.aeF), i10);
            }
        }
    }

    public static j uD() {
        return a.aeK;
    }

    private static boolean uE() {
        return aeG > 0;
    }

    private j() {
        this.aeC = com.kwad.framework.filedownloader.f.b.o(5, "BlockCompleted");
        this.aeE = new Object();
        this.aeF = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aeD = new LinkedBlockingQueue<>();
    }

    public final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z10) {
        if (tVar.uI()) {
            tVar.uH();
            return;
        }
        if (tVar.uJ()) {
            this.aeC.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.uH();
                }
            });
            return;
        }
        if (!uE() && !this.aeD.isEmpty()) {
            synchronized (this.aeE) {
                if (!this.aeD.isEmpty()) {
                    Iterator<t> iterator2 = this.aeD.iterator2();
                    while (iterator2.hasNext()) {
                        b(iterator2.next());
                    }
                }
                this.aeD.clear();
            }
        }
        if (!uE()) {
            b(tVar);
        } else {
            c(tVar);
        }
    }
}
