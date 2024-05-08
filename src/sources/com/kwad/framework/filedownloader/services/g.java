package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g implements y {
    private final h aia = new h(com.kwad.framework.filedownloader.download.b.vo().vr());

    private boolean bI(int i10) {
        return a(wD().bk(i10));
    }

    private static com.kwad.framework.filedownloader.b.a wD() {
        return com.kwad.framework.filedownloader.download.b.vo().vq();
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean bK = this.aia.bK(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.bF(cVar.tV())) {
            if (!bK) {
                return false;
            }
        } else if (!bK) {
            com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.tV()));
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0178 A[Catch: all -> 0x01c1, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0033, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:19:0x0070, B:21:0x0076, B:23:0x007a, B:28:0x008b, B:29:0x0094, B:31:0x009d, B:33:0x00a1, B:38:0x00b4, B:40:0x00bd, B:41:0x00c6, B:43:0x00d5, B:45:0x00d9, B:47:0x00ea, B:51:0x00f4, B:53:0x00fb, B:55:0x0102, B:57:0x0108, B:59:0x010f, B:61:0x0115, B:63:0x011b, B:65:0x0131, B:66:0x0135, B:68:0x013b, B:72:0x0178, B:73:0x017b, B:76:0x0148, B:78:0x0152, B:80:0x0158, B:81:0x015e, B:82:0x00c2, B:84:0x0090), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void b(java.lang.String r20, java.lang.String r21, boolean r22, int r23, int r24, int r25, boolean r26, com.kwad.framework.filedownloader.d.b r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.services.g.b(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwad.framework.filedownloader.d.b, boolean):void");
    }

    public final long bJ(int i10) {
        com.kwad.framework.filedownloader.b.a wD = wD();
        com.kwad.framework.filedownloader.d.c bk = wD.bk(i10);
        if (bk == null) {
            return 0L;
        }
        int wo = bk.wo();
        if (wo <= 1) {
            return bk.wl();
        }
        List<com.kwad.framework.filedownloader.d.a> bl = wD.bl(i10);
        if (bl == null || bl.size() != wo) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.r(bl);
    }

    public final boolean bd(int i10) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i10));
        }
        com.kwad.framework.filedownloader.d.c bk = wD().bk(i10);
        if (bk == null) {
            return false;
        }
        bk.d((byte) -2);
        this.aia.cancel(i10);
        return true;
    }

    public final byte be(int i10) {
        com.kwad.framework.filedownloader.d.c bk = wD().bk(i10);
        if (bk == null) {
            return (byte) 0;
        }
        return bk.tV();
    }

    public final boolean bf(int i10) {
        if (i10 == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i10));
            return false;
        }
        if (bI(i10)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i10));
            return false;
        }
        com.kwad.framework.filedownloader.b.a wD = wD();
        wD.bn(i10);
        wD.bm(i10);
        return true;
    }

    public final synchronized boolean bx(int i10) {
        return this.aia.bx(i10);
    }

    public final long bz(int i10) {
        com.kwad.framework.filedownloader.d.c bk = wD().bk(i10);
        if (bk == null) {
            return 0L;
        }
        return bk.getTotal();
    }

    public final boolean isIdle() {
        return this.aia.wG() <= 0;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int p(String str, int i10) {
        return this.aia.p(str, i10);
    }

    public final void vV() {
        wD().clear();
    }

    public final void wE() {
        List<Integer> wH = this.aia.wH();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(wH.size()));
        }
        Iterator<Integer> iterator2 = wH.iterator2();
        while (iterator2.hasNext()) {
            bd(iterator2.next().intValue());
        }
    }

    public final boolean y(String str, String str2) {
        return bI(com.kwad.framework.filedownloader.f.f.A(str, str2));
    }
}
