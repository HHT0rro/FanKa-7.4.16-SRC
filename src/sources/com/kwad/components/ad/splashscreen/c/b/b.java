package com.kwad.components.ad.splashscreen.c.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.c.e;
import com.kwad.components.ad.splashscreen.c.p;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends e {
    private com.kwad.components.core.n.a.d.b EV;
    private long EW;
    private volatile boolean EX = false;
    private com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.splashscreen.c.b.b.1
        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void a(String str, long j10, long j11, long j12) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dr(b.this.Dg.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.a(b.this.Dg.mAdTemplate, b.this.Dg.Cr, b.this.Dg.CB, b.this.Dg.CD, b.this.Dg.CC, b.this.Dg.CE, j10, j11, j12, SystemClock.elapsedRealtime() - b.this.EW);
            b.this.Dg.CF = j10;
            b.this.Dg.CG = j11;
            b.this.Dg.CH = j12;
            bn.c(b.this.EY);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            b.this.Dg.Cz = true;
            if ("tk_splash".equals(str)) {
                b.this.lH();
            }
        }
    };
    private final Runnable EY = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.EX) {
                b.this.Dg.Cz = true;
                b.this.lH();
                com.kwad.components.ad.splashscreen.monitor.b.kV();
                com.kwad.components.ad.splashscreen.monitor.b.c(b.this.Dg.mAdTemplate, b.this.Dg.Cr);
                return;
            }
            b.this.lG();
        }
    };
    private com.kwad.components.core.n.a.d.a EZ = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.c.b.b.3
        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i10, int i11, long j10, long j11) {
            b.this.Dg.CB = i10;
            b.this.Dg.CC = i11;
            b.this.Dg.CD = j10;
            b.this.Dg.CE = j11;
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.e(b.this.Dg.mAdTemplate, SystemClock.elapsedRealtime() - b.this.EW);
            b.this.lG();
        }
    };

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
        if (lI()) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new c(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH() {
        if (com.kwad.sdk.core.response.b.b.dB(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate))) {
            h hVar = this.Dg;
            if (hVar.Cx) {
                return;
            }
            hVar.Cx = true;
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new p(), true);
                }
            });
        }
    }

    private boolean lI() {
        if (d.BV()) {
            return com.kwad.sdk.core.response.b.b.dh(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate));
        }
        return false;
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EW = SystemClock.elapsedRealtime();
        if (lI()) {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            h hVar = this.Dg;
            com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Cr);
            h hVar2 = this.Dg;
            hVar2.CA = this.EW;
            bn.runOnUiThreadDelay(this.EY, com.kwad.sdk.core.response.b.b.dl(com.kwad.sdk.core.response.b.e.dQ(hVar2.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.d.b.tc().a(this.jR);
        }
        if (d.BV()) {
            lF();
        } else {
            lH();
        }
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
        if (lI()) {
            bn.c(this.EY);
            com.kwad.components.core.webview.tachikoma.d.b.tc().b(this.jR);
        }
    }
}
