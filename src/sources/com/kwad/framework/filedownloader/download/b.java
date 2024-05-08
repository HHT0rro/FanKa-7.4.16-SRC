package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c afR;
    private c.a afS;
    private c.b afT;
    private c.e afU;
    private volatile com.kwad.framework.filedownloader.b.a afV;
    private c.d afW;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final b afX = new b();
    }

    public static b vo() {
        return a.afX;
    }

    private c.a vt() {
        c.a aVar = this.afS;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.afS == null) {
                this.afS = vw().wu();
            }
        }
        return this.afS;
    }

    private c.b vu() {
        c.b bVar = this.afT;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.afT == null) {
                this.afT = vw().wt();
            }
        }
        return this.afT;
    }

    private c.e vv() {
        c.e eVar = this.afU;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.afU == null) {
                this.afU = vw().ws();
            }
        }
        return this.afU;
    }

    private com.kwad.framework.filedownloader.services.c vw() {
        com.kwad.framework.filedownloader.services.c cVar = this.afR;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.afR == null) {
                this.afR = new com.kwad.framework.filedownloader.services.c();
            }
        }
        return this.afR;
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.afR = new com.kwad.framework.filedownloader.services.c(bVar);
            this.afT = null;
            this.afU = null;
            this.afV = null;
            this.afW = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.afR = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b bh(String str) {
        try {
            return vu().be(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.afT = bVar;
            return bVar.be(str);
        }
    }

    public final c.d vp() {
        c.d dVar = this.afW;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.afW == null) {
                this.afW = vw().wv();
            }
        }
        return this.afW;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a vq() {
        if (this.afV != null) {
            return this.afV;
        }
        this.afV = vw().wr();
        a(this.afV.vf());
        return this.afV;
    }

    public final int vr() {
        return vw().vr();
    }

    public final boolean vs() {
        vv();
        return true;
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return vv().c(file);
    }

    public final int a(int i10, String str, String str2, long j10) {
        return vt().O(j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d4, code lost:
    
        if (r8.wl() > 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0051, code lost:
    
        if (r8.wl() <= 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065 A[Catch: all -> 0x0143, TryCatch #1 {all -> 0x0143, blocks: (B:73:0x0034, B:75:0x003b, B:77:0x0042, B:79:0x0049, B:10:0x0056, B:37:0x0065, B:39:0x0070, B:9:0x0053), top: B:72:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:16:0x00f1, B:28:0x00fd, B:30:0x0113, B:32:0x0117, B:33:0x012f, B:34:0x0136, B:52:0x00a3, B:53:0x00c5, B:55:0x00cc, B:58:0x00da, B:61:0x00e5), top: B:15:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0495a r26) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.b.a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}
