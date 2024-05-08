package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.ap;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class g {
    private final c aBZ;
    private final AtomicInteger aCd = new AtomicInteger(0);
    private volatile e aCe;
    private final List<b> aCf;
    private final b aCg;
    private final String url;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a extends Handler implements b {
        private final List<b> aCf;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.aCf = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i10) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i10;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> iterator2 = this.aCf.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.aCf = copyOnWriteArrayList;
        this.url = ap.gH(str);
        this.aBZ = (c) ap.checkNotNull(cVar);
        this.aCg = new a(str, copyOnWriteArrayList);
    }

    private synchronized void Gt() {
        if (this.aBZ.aBL == 1 && isOkHttpSupported()) {
            this.aCe = this.aCe == null ? Gw() : this.aCe;
        } else {
            this.aCe = this.aCe == null ? Gv() : this.aCe;
        }
    }

    private synchronized void Gu() {
        if (this.aCd.decrementAndGet() <= 0) {
            this.aCe.shutdown();
            this.aCe = null;
        }
    }

    private e Gv() {
        String str = this.url;
        c cVar = this.aBZ;
        e eVar = new e(new h(str, cVar.aBJ, cVar.aBK), new com.kwad.sdk.core.videocache.a.b(this.aBZ.ex(this.url), this.aBZ.aBI));
        eVar.a(this.aCg);
        return eVar;
    }

    private e Gw() {
        String str = this.url;
        c cVar = this.aBZ;
        e eVar = new e(new j(str, cVar.aBJ, cVar.aBK), new com.kwad.sdk.core.videocache.a.b(this.aBZ.ex(this.url), this.aBZ.aBI));
        eVar.a(this.aCg);
        return eVar;
    }

    private static boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int Gq() {
        return this.aCd.get();
    }

    public final void a(d dVar, Socket socket) {
        Gt();
        try {
            this.aCd.incrementAndGet();
            this.aCe.a(dVar, socket);
        } finally {
            Gu();
        }
    }

    public final void shutdown() {
        this.aCf.clear();
        e eVar = this.aCe;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.aCe = null;
        this.aCd.set(0);
    }
}
