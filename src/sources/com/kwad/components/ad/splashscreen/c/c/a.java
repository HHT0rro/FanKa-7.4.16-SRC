package com.kwad.components.ad.splashscreen.c.c;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.components.core.webview.tachikoma.a.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.q;
import com.kwad.sdk.utils.ay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends c implements com.kwad.sdk.core.h.c {
    private m Fc;

    /* renamed from: ld, reason: collision with root package name */
    private FrameLayout f36619ld;
    private aw wz;
    private boolean Ff = false;
    public f ER = new f() { // from class: com.kwad.components.ad.splashscreen.c.c.a.3
        @Override // com.kwad.components.ad.splashscreen.f
        public final void kw() {
            a.this.f36619ld.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.f36619ld.setVisibility(8);
                }
            }, 500L);
            if (a.this.wz != null) {
                a.this.wz.st();
                a.this.wz.su();
            }
        }
    };

    @NonNull
    private m lK() {
        m mVar = new m();
        this.Fc = mVar;
        return mVar;
    }

    private void lL() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.lO();
        }
    }

    @NonNull
    private u lM() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2
            @Override // com.kwad.components.core.webview.tachikoma.a.u.a
            public final void a(final u.b bVar) {
                int i10 = bVar.status;
                if (i10 == 1) {
                    a.this.Dg.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            if (com.kwad.components.core.e.c.b.nr()) {
                                a.this.Dg.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                a.this.Dg.kM();
                            }
                        }
                    });
                    return;
                }
                if (i10 == 2) {
                    a.this.Dg.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.2
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            com.kwad.components.ad.splashscreen.monitor.a.kT().l(a.this.Dg.mAdTemplate);
                            a.this.Dg.kO();
                        }
                    });
                } else if (i10 == 3) {
                    a.this.Dg.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.3
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            a.this.Dg.kD();
                        }
                    });
                } else if (i10 == 4) {
                    a.this.Dg.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.4
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            h hVar = a.this.Dg;
                            u.b bVar2 = bVar;
                            hVar.i(bVar2.errorCode, bVar2.errorMsg);
                        }
                    });
                }
            }
        });
        return uVar;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (this.Dg.Cz) {
            return;
        }
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.sv();
        } else {
            this.Ff = true;
        }
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
        this.Dg.a(this.ER);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        aw awVar;
        if (this.Dg.Cz) {
            return;
        }
        aw awVar2 = this.wz;
        if (awVar2 != null) {
            awVar2.sr();
            this.wz.ss();
        }
        if (this.Ff && (awVar = this.wz) != null) {
            awVar.sv();
        }
        this.f36619ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.f36619ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ce(this.Dg.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c
    public final int lJ() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Dg;
        return (int) (com.kwad.sdk.core.response.b.b.de(hVar.mAdTemplate) - (elapsedRealtime - hVar.CA));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36619ld = (FrameLayout) findViewById(R.id.splash_full_tk_play_card_view);
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
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        this.f36619ld.setVisibility(8);
        lL();
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
        qVar.c(lM());
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Dg.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.c.a.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.Dg.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.a.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            a.this.Dg.kB();
                        }
                    });
                }
            }
        });
    }
}
