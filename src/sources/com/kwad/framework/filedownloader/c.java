package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.d;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.util.ArrayList;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements com.kwad.framework.filedownloader.a, a.InterfaceC0494a, d.a {
    private final x adO;
    private final x.a adP;
    private int adQ;
    private ArrayList<Object> adR;
    private String adS;
    private String adT;
    private boolean adU;
    private com.kwad.framework.filedownloader.d.b adV;
    private i adW;
    private Object adX;
    private final Object aeg;
    private final String mUrl;
    private int adY = 0;
    private boolean adZ = false;
    private boolean aea = false;
    private int aeb = 100;
    private int aec = 10;
    private boolean aed = false;
    public volatile int aee = 0;
    private boolean aef = false;
    private final Object aeh = new Object();
    private volatile boolean aei = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements a.b {
        private final c aej;

        public /* synthetic */ a(c cVar, byte b4) {
            this(cVar);
        }

        @Override // com.kwad.framework.filedownloader.a.b
        public final int ul() {
            int id2 = this.aej.getId();
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(id2));
            }
            h.uB().c(this.aej);
            return id2;
        }

        private a(c cVar) {
            this.aej = cVar;
            c.a(cVar, true);
        }
    }

    public c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.aeg = obj;
        d dVar = new d(this, obj);
        this.adO = dVar;
        this.adP = dVar;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.aef = true;
        return true;
    }

    private boolean un() {
        return this.adO.tV() != 0;
    }

    private int uo() {
        if (un()) {
            if (isRunning()) {
                throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.adO.toString());
        }
        if (!tO()) {
            ug();
        }
        this.adO.uu();
        return getId();
    }

    private void up() {
        if (this.adV == null) {
            synchronized (this.aeh) {
                if (this.adV == null) {
                    this.adV = new com.kwad.framework.filedownloader.d.b();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aX(int i10) {
        this.adY = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final boolean aY(int i10) {
        return getId() == i10;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a aZ(String str) {
        return c(str, false);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a ba(boolean z10) {
        this.aed = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bb(boolean z10) {
        this.adZ = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bc(boolean z10) {
        this.aea = z10;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a c(String str, boolean z10) {
        this.adS = str;
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.adU = z10;
        if (z10) {
            this.adT = null;
        } else {
            this.adT = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a e(Object obj) {
        this.adX = obj;
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final void free() {
        this.adO.free();
        if (h.uB().a(this)) {
            this.aei = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getFilename() {
        return this.adT;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getId() {
        int i10 = this.adQ;
        if (i10 != 0) {
            return i10;
        }
        if (TextUtils.isEmpty(this.adS) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int g3 = com.kwad.framework.filedownloader.f.f.g(this.mUrl, this.adS, this.adU);
        this.adQ = g3;
        return g3;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getPath() {
        return this.adS;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.adO.uv() > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return Integer.MAX_VALUE;
        }
        return (int) this.adO.uv();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.adO.getTotalBytes() > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return Integer.MAX_VALUE;
        }
        return (int) this.adO.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSpeed() {
        return this.adO.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.adO.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Object getTag() {
        return this.adX;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), tR(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final boolean isOver() {
        return com.kwad.framework.filedownloader.d.d.bF(tV());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean isRunning() {
        if (r.uU().uY().d(this)) {
            return true;
        }
        return com.kwad.framework.filedownloader.d.d.bG(tV());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean pause() {
        boolean pause;
        synchronized (this.aeg) {
            pause = this.adO.pause();
        }
        return pause;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int start() {
        if (!this.aef) {
            return uo();
        }
        throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a t(String str, String str2) {
        up();
        this.adV.x(str, str2);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final a.b tM() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tN() {
        if (isRunning()) {
            com.kwad.framework.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.aee = 0;
        this.aef = false;
        this.aei = false;
        this.adO.reset();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tO() {
        return this.aee != 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tP() {
        return this.aeb;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tQ() {
        return this.aec;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tR() {
        return this.adU;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final i tS() {
        return this.adW;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long tT() {
        return this.adO.uv();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long tU() {
        return this.adO.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final byte tV() {
        return this.adO.tV();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean tW() {
        return this.aed;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Throwable tX() {
        return this.adO.tX();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tY() {
        return this.adY;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int tZ() {
        return this.adO.tZ();
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean ua() {
        return this.adZ;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean ub() {
        return this.adO.ub();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean uc() {
        return this.aea;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final com.kwad.framework.filedownloader.a ud() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final x.a ue() {
        return this.adP;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final int uf() {
        return this.aee;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final void ug() {
        int hashCode;
        if (tS() != null) {
            hashCode = tS().hashCode();
        } else {
            hashCode = hashCode();
        }
        this.aee = hashCode;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final boolean uh() {
        return this.aei;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final void ui() {
        this.aei = true;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final void uj() {
        uo();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0494a
    public final boolean uk() {
        ArrayList<Object> arrayList = this.adR;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.d.b uq() {
        return this.adV;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final a.InterfaceC0494a ur() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final ArrayList<Object> us() {
        return this.adR;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a a(i iVar) {
        this.adW = iVar;
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a ba(String str) {
        if (this.adV == null) {
            synchronized (this.aeh) {
                if (this.adV == null) {
                    return this;
                }
            }
        }
        this.adV.bm(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final void bb(String str) {
        this.adT = str;
    }
}
