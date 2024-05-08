package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g extends a {
    public AdWebViewActivityProxy.a Os;
    private aw Pk;
    private at Pl;
    private com.kwad.components.core.webview.b fX;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean Pi = false;
    private boolean Pj = false;
    private final com.kwad.sdk.core.c.c wT = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.g.1
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }
    };
    private at.b OM = new at.b() { // from class: com.kwad.components.core.page.c.a.g.2
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void pF() {
            if (g.this.Pl != null) {
                g.this.Pl.sq();
            }
        }
    };
    private com.kwad.components.core.webview.c fY = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.c.a.g.3
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bc(new bc.b() { // from class: com.kwad.components.core.page.c.a.g.3.1
                @Override // com.kwad.components.core.webview.jshandler.bc.b
                public final void a(bc.a aVar2) {
                    f.a aVar3 = g.this.OH.OL;
                    if (aVar3 == null || aVar2 == null) {
                        return;
                    }
                    aVar3.aB(aVar2.visibility);
                }
            }));
            g.this.Pl = new at(new at.c() { // from class: com.kwad.components.core.page.c.a.g.3.2
                @Override // com.kwad.components.core.webview.jshandler.at.c
                public final void pI() {
                    g gVar = g.this;
                    gVar.OH.a(gVar.OM);
                }
            });
            aVar.a(g.this.Pl);
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.b(bVar, g.this.OH.mAdTemplate));
            k kVar = new k();
            kVar.aam = g.this.OH.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.g(kVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i10, String str) {
            g.this.Pi = false;
            g gVar = g.this;
            com.kwad.sdk.commercial.g.a.a(gVar.mAdTemplate, gVar.Os.ph(), g.this.Os.pg(), i10, str);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Pi = true;
            if (!g.this.Pj) {
                g.b(g.this, true);
                g gVar = g.this;
                com.kwad.sdk.commercial.g.a.m(gVar.mAdTemplate, gVar.Os.ph(), g.this.Os.pg());
            }
            if (g.this.OH.pu()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean pG() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean pH() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            g.this.Pk = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            g.this.OH.ON = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.d.a.b bVar = g.this.OH.mWebCardCloseListener;
            if (bVar != null) {
                bVar.b(webCloseStatus);
            }
        }
    };

    private void es() {
        this.fX = new com.kwad.components.core.webview.b();
        this.fX.a(new b.a().az(this.OH.mAdTemplate).aF(this.OH.mPageUrl).d(this.mAdWebView).k(this.OH.gS).a(this.fY).b(this.OH.OJ));
        pE();
        com.kwad.sdk.commercial.g.a.l(this.mAdTemplate, this.Os.ph(), this.Os.pg());
        this.mAdWebView.loadUrl(this.OH.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    private void pE() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().bw(true).ei(this.OH.mAdTemplate).bu(false));
        if (com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dQ(this.OH.mAdTemplate)) > 0) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.g.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bu(true);
                    }
                }
            }, com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dQ(this.OH.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dQ(this.OH.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bu(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.c.a.g.5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                g.this.mAdWebView.getClientConfig().bu(true);
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = this.OH;
        this.Os = bVar.Os;
        this.mAdTemplate = bVar.mAdTemplate;
        es();
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(this.wT);
    }

    public final void hide() {
        aw awVar = this.Pk;
        if (awVar != null) {
            awVar.st();
        }
        KsAdWebView ksAdWebView = this.OH.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        aw awVar2 = this.Pk;
        if (awVar2 != null) {
            awVar2.su();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fX.jp();
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.b(this.wT);
    }

    public final void show() {
        if (this.Pi) {
            aw awVar = this.Pk;
            if (awVar != null) {
                awVar.sr();
            }
            try {
                KsAdWebView ksAdWebView = this.OH.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(0);
                }
            } catch (Exception e2) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e2);
            }
            aw awVar2 = this.Pk;
            if (awVar2 != null) {
                awVar2.ss();
            }
        }
    }

    public static /* synthetic */ boolean b(g gVar, boolean z10) {
        gVar.Pj = true;
        return true;
    }

    public static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }
}
