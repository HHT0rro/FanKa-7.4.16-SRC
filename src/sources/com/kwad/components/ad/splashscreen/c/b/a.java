package com.kwad.components.ad.splashscreen.c.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.c.e;
import com.kwad.components.ad.splashscreen.c.j;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends e {
    private com.kwad.components.core.n.a.d.b EV;
    private long EW;
    private volatile boolean EX = false;
    private com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.splashscreen.c.b.a.1
        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void a(String str, long j10, long j11, long j12) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dr(a.this.Dg.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.a(a.this.Dg.mAdTemplate, a.this.Dg.Cr, a.this.Dg.CB, a.this.Dg.CD, a.this.Dg.CC, a.this.Dg.CE, j10, j11, j12, SystemClock.elapsedRealtime() - a.this.EW);
            a.this.Dg.CF = j10;
            a.this.Dg.CG = j11;
            a.this.Dg.CH = j12;
            bn.c(a.this.EY);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            a.this.Dg.Cz = true;
            if ("tk_splash".equals(str)) {
                a.this.aq();
            }
        }
    };
    private final Runnable EY = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.EX) {
                a.this.Dg.Cz = true;
                a.this.aq();
                com.kwad.components.ad.splashscreen.monitor.b.kV();
                com.kwad.components.ad.splashscreen.monitor.b.c(a.this.Dg.mAdTemplate, a.this.Dg.Cr);
                return;
            }
            a.this.lG();
        }
    };
    private com.kwad.components.core.n.a.d.a EZ = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.c.b.a.3
        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i10, int i11, long j10, long j11) {
            a.this.Dg.CB = i10;
            a.this.Dg.CC = i11;
            a.this.Dg.CD = j10;
            a.this.Dg.CE = j11;
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.e(a.this.Dg.mAdTemplate, SystemClock.elapsedRealtime() - a.this.EW);
            a.this.lG();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        h hVar = this.Dg;
        if (hVar.Cy) {
            return;
        }
        hVar.Cy = true;
        hVar.Cx = true;
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.c.b.a.5
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.a(new j(), true);
            }
        });
    }

    private void lF() {
        com.kwad.components.core.n.a.d.b bVar = (com.kwad.components.core.n.a.d.b) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.b.class);
        this.EV = bVar;
        if (bVar != null) {
            bVar.a(this.EZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG() {
        if (this.EX) {
            return;
        }
        this.EX = true;
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.c.b.a.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.a(new com.kwad.components.ad.splashscreen.c.c.a(), true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EW = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        h hVar = this.Dg;
        com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Cr);
        h hVar2 = this.Dg;
        hVar2.CA = this.EW;
        bn.runOnUiThreadDelay(this.EY, com.kwad.sdk.core.response.b.b.de(hVar2.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.d.b.tc().a(this.jR);
        lF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.n.a.d.b bVar = this.EV;
        if (bVar != null) {
            bVar.b(this.EZ);
        }
        bn.c(this.EY);
        com.kwad.components.core.webview.tachikoma.d.b.tc().b(this.jR);
    }
}
