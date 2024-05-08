package com.kwad.components.ad.splashscreen.c.b;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.sdk.R;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.response.b.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.splashscreen.c.c.c implements g, com.kwad.sdk.core.h.c {
    public f ER = new f() { // from class: com.kwad.components.ad.splashscreen.c.b.c.2
        @Override // com.kwad.components.ad.splashscreen.f
        public final void kw() {
            c.this.f36617ld.setVisibility(8);
            if (c.this.wz != null) {
                c.this.wz.st();
                c.this.wz.su();
            }
        }
    };
    private m Fc;

    /* renamed from: ld, reason: collision with root package name */
    private FrameLayout f36617ld;
    private aw wz;

    @NonNull
    private m lK() {
        m mVar = new m();
        this.Fc = mVar;
        return mVar;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i10) {
        m mVar = this.Fc;
        if (mVar != null) {
            mVar.aT(i10);
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        aw awVar;
        if (this.Dg.Cz || (awVar = this.wz) == null) {
            return;
        }
        awVar.sv();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        aw awVar;
        if (this.Dg.Cz || (awVar = this.wz) == null) {
            return;
        }
        awVar.sw();
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        h hVar = this.Dg;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.Cr);
        this.Dg.Cs.a(this);
        this.Dg.a(this);
        this.Dg.a(this.ER);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        if (this.Dg.Cz) {
            return;
        }
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.sr();
            this.wz.ss();
        }
        this.f36617ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.f36617ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dr(this.Dg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kA() {
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c
    public final int lJ() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Dg;
        return (int) (com.kwad.sdk.core.response.b.b.dl(e.dQ(hVar.mAdTemplate)) - (elapsedRealtime - hVar.CA));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36617ld = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        super.onUnbind();
        this.Dg.Cs.b(this);
        this.Dg.b(this.ER);
        this.Dg.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        this.f36617ld.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        aVar.width = com.kwad.sdk.d.a.a.px2dip(getContext(), this.Dg.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.d.a.a.px2dip(getContext(), this.Dg.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wz = awVar;
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        qVar.c(a(bVar));
        qVar.c(lK());
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Dg.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.b.c.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    c.this.Dg.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.Dg.kB();
                        }
                    });
                }
            }
        });
    }
}
