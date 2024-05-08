package com.kwad.components.ad.interstitial.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.g.a.a.b;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.s.j;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.g;
import com.kwad.components.core.webview.tachikoma.a.n;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.webview.tachikoma.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends a {

    /* renamed from: le, reason: collision with root package name */
    private static long f36518le = 400;
    private d eg;
    private Vibrator eh;
    private aw fD;

    /* renamed from: lc, reason: collision with root package name */
    @Nullable
    private com.kwad.components.ad.g.a.a.b f36519lc;

    /* renamed from: ld, reason: collision with root package name */
    private FrameLayout f36520ld;
    private boolean lg;
    private e lh;
    private boolean lf = false;
    private final c.a jP = new c.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.1
        @Override // com.kwad.components.ad.interstitial.e.c.a
        public final void b(long j10, long j11) {
            com.kwad.components.ad.interstitial.report.a.dM().b(b.this.jK.mAdTemplate, j10, j11);
            if (b.this.lh != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aae = b.this.jK.jM ? 1 : 0;
                b.this.lh.b(aVar);
            }
        }
    };
    private com.kwad.sdk.core.h.c df = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.e.a.b.9
        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aM() {
            if (b.this.fD != null && !b.this.lf) {
                b.a(b.this, true);
                b.this.fD.sr();
                b.this.fD.ss();
            }
            if (b.this.fD != null) {
                b.this.fD.sv();
            }
            if (b.this.f36519lc != null) {
                b.this.f36519lc.eH();
            }
            if (!b.this.lg) {
                b.this.jK.f36523io.getTimerHelper().startTiming();
            }
            if (b.this.lg || b.this.jK.jO || b.this.jK.f36522ie == null) {
                return;
            }
            b.this.jK.f36522ie.onAdShow();
            com.kwad.components.ad.interstitial.report.c.dQ().a(b.this.jK.mAdTemplate, 3);
            b.b(b.this, true);
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aN() {
            if (b.this.fD != null) {
                b.this.fD.sw();
            }
            if (b.this.f36519lc != null) {
                b.this.f36519lc.eG();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        if (getContext() != null) {
            this.eh = (Vibrator) getContext().getSystemService("vibrator");
        }
        float cR = com.kwad.sdk.core.response.b.b.cR(this.jK.mAdTemplate);
        if (this.eg == null) {
            d dVar = new d(cR);
            this.eg = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.e.a.b.7
                @Override // com.kwad.sdk.core.g.b
                public final void a(double d10) {
                    if (bq.o(b.this.getTKContainer(), 100)) {
                        b.this.d(d10);
                    }
                    bn.a(new ay() { // from class: com.kwad.components.ad.interstitial.e.a.b.7.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            b.this.eg.Fu();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.g.b
                public final void aV() {
                }
            });
        }
        this.eg.e(cR);
        this.eg.bi(getContext());
    }

    private com.kwad.components.core.webview.tachikoma.c dB() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.interstitial.e.a.b.14
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.aag = com.kwad.components.ad.interstitial.d.a.cO();
                cVar.a(cVar2);
            }
        };
    }

    private e dC() {
        return new e() { // from class: com.kwad.components.ad.interstitial.e.a.b.15
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aae = b.this.jK.jM ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private g dD() {
        k kVar = new k();
        kVar.aal = this.jK.jZ;
        return new g(kVar);
    }

    private com.kwad.components.ad.g.a.a.a dE() {
        final com.kwad.components.ad.g.a.a.a aVar = new com.kwad.components.ad.g.a.a.a();
        this.jK.jU.add(new c.InterfaceC0419c() { // from class: com.kwad.components.ad.interstitial.e.a.b.16
            @Override // com.kwad.components.ad.interstitial.e.c.InterfaceC0419c
            public final void cZ() {
                aVar.eE();
            }
        });
        return aVar;
    }

    private bf dF() {
        bf bfVar = new bf(getContext(), this.jK.mAdTemplate);
        bfVar.a(new bf.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.3
            @Override // com.kwad.components.core.webview.jshandler.bf.a
            public final boolean dK() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.jK.mAdTemplate);
                b.this.jK.a(true, -1, null);
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.dt();
                    }
                }, 0L);
                return false;
            }
        });
        return bfVar;
    }

    @NonNull
    private n dG() {
        return new n() { // from class: com.kwad.components.ad.interstitial.e.a.b.4
            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.ad.interstitial.e.a.b.4.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                        dVar.aah = ag.isWifiConnected(b.this.getContext()) || b.this.jK.dU.isDataFlowAutoStart() || b.k(b.this.jK.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    @NonNull
    private ai dH() {
        return new ai(new ai.b() { // from class: com.kwad.components.ad.interstitial.e.a.b.5
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(final ai.a aVar) {
                if (b.this.jK.f36523io != null) {
                    b.this.jK.jS.post(new ay() { // from class: com.kwad.components.ad.interstitial.e.a.b.5.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            if (aVar.type == 0 && !b.this.jK.jM && !b.this.jK.jN && com.kwad.components.ad.interstitial.f.a.d(b.this.jK)) {
                                b.this.jK.jN = true;
                                com.kwad.components.ad.interstitial.c.b.I(b.this.getContext());
                                return;
                            }
                            b.this.dJ();
                            c cVar = b.this.jK;
                            ai.a aVar2 = aVar;
                            cVar.a(aVar2.type == 3, aVar2.Xn, null);
                            b.this.dt();
                        }
                    });
                }
            }
        });
    }

    private v dI() {
        return new v() { // from class: com.kwad.components.ad.interstitial.e.a.b.6
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                if (b.this.jK.jO || b.this.jK.f36522ie == null) {
                    return;
                }
                b.this.jK.f36522ie.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                if (b.this.jK.jO || b.this.jK.f36522ie == null) {
                    return;
                }
                b.this.jK.f36522ie.onVideoPlayEnd();
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                b.this.jK.mAdTemplate.setmCurPlayTime(xVar.nE);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ() {
        aw awVar = this.fD;
        if (awVar != null) {
            awVar.st();
            this.fD.su();
        }
        com.kwad.components.ad.g.a.a.b bVar = this.f36519lc;
        if (bVar != null) {
            bVar.eG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt() {
        c cVar = this.jK;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.f36523io;
        if (dVar != null && a(dVar)) {
            this.jK.f36523io.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.jK.f36522ie;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.8
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0472a().as(bVar.title).at(bVar.url).aC(true).m(b.this.jK.mAdResultData).pl());
            }
        };
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        com.kwad.components.ad.interstitial.report.c.dQ().s(this.jK.mAdTemplate);
        com.kwad.components.core.webview.tachikoma.e.e eVar = this.jK.jR;
        if (eVar != null) {
            eVar.a(getTkTemplateId(), 0L, 0L, 0L);
        }
        if (this.fD != null && this.jK.f36521ib.dW()) {
            this.lf = true;
            this.fD.sr();
            this.fD.ss();
        }
        this.jK.f36521ib.a(this.df);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.f36520ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dt(this.jK.mAdTemplate);
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.f36520ld = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.lf = false;
        this.lg = false;
        bn.b(getContext(), this.eh);
        d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.jK.f36521ib;
        if (bVar != null) {
            bVar.b(this.df);
        }
        this.jK.b(this.jP);
    }

    public static /* synthetic */ boolean b(b bVar, boolean z10) {
        bVar.lg = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d10) {
        this.jK.a(new c.b(getContext()).l(true).c(d10).z(2).a(this.jK.jS.getTouchCoords()).A(157));
        bn.vibrate(getContext(), this.eh, f36518le);
    }

    public static boolean k(@NonNull AdTemplate adTemplate) {
        File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
        return bV != null && bV.exists();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z10) {
        bVar.lf = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        this.f36520ld.setVisibility(8);
        com.kwad.components.core.webview.tachikoma.e.e eVar = this.jK.jR;
        if (eVar != null) {
            getTkTemplateId();
            eVar.q(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        com.kwad.components.ad.g.a.a.b z10 = com.kwad.components.ad.g.a.a.b.z(this.jK.mAdTemplate);
        this.f36519lc = z10;
        if (z10 != null) {
            z10.a(new b.InterfaceC0410b() { // from class: com.kwad.components.ad.interstitial.e.a.b.10
                @Override // com.kwad.components.ad.g.a.a.b.InterfaceC0410b
                public final void E(int i10) {
                    if (i10 == com.kwad.components.ad.g.a.a.b.nu) {
                        b.this.jK.b(b.this.getContext(), b.this.jK.mAdTemplate);
                        b.this.jK.a(true, -1, null);
                    }
                    b.this.dt();
                }
            });
            qVar.c(this.f36519lc);
            this.f36519lc.eF();
        }
        qVar.c(dH());
        qVar.c(new ao(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.b.b.m2865do(com.kwad.sdk.core.response.b.e.dQ(this.jK.mAdTemplate))) {
            qVar.c(new com.kwad.components.core.webview.jshandler.ay(new ay.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.11
                @Override // com.kwad.components.core.webview.jshandler.ay.a
                public final void bB() {
                    b.this.bu();
                }
            }));
        }
        qVar.c(dG());
        qVar.c(dF());
        qVar.c(dD());
        qVar.c(a(bVar));
        qVar.c(dI());
        qVar.c(dE());
        qVar.c(new com.kwad.components.core.webview.tachikoma.a.q() { // from class: com.kwad.components.ad.interstitial.e.a.b.12
            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                j.e(b.this.getContext(), b.this.jK.mAdTemplate);
            }
        });
        this.lh = dC();
        this.jK.a(this.jP);
        qVar.c(this.lh);
        qVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.13
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dL() {
                com.kwad.components.ad.interstitial.d.a.J(b.this.getContext());
            }
        }));
        qVar.c(dB());
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.fD = awVar;
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.x a(com.kwad.sdk.core.webview.b bVar) {
        return new com.kwad.components.core.webview.jshandler.x(bVar, this.jK.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    com.kwad.components.ad.interstitial.report.a.dM().a(b.this.jK.mAdTemplate, aVar.aEM, aVar.kl);
                    b.this.jK.jM = true;
                    if (!b.this.jK.jO) {
                        b.this.jK.b(aVar.aEM, aVar.kl);
                    }
                    if (b.this.jK.f36523io == null || !com.kwad.components.ad.interstitial.b.b.cK()) {
                        return;
                    }
                    b.this.jK.a(false, -1, b.this.jK.eN);
                    b.this.jK.f36523io.dismiss();
                }
            }
        });
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.jK.f36522ie;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.jK.a(webCloseStatus.closeType == 2, -1, null);
        dt();
    }
}
