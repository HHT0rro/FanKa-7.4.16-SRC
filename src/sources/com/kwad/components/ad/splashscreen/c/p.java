package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.h.c {
    private com.kwad.components.ad.splashscreen.f.b DV;
    private boolean DW;
    private long DY;
    private aw DZ;
    private ViewGroup Eb;

    @Nullable
    private KsAdWebView cL;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private com.kwad.sdk.core.g.d eg;
    private Vibrator eh;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean DX = false;
    private boolean Ea = false;
    private final Runnable Ec = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.1
        @Override // java.lang.Runnable
        public final void run() {
            p.a(p.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, com.kwad.sdk.core.response.b.b.ci(p.this.mAdTemplate), SystemClock.elapsedRealtime() - p.this.DY, 1, "");
            p.this.lw();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator D(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.Dg.mRootContainer;
        bVar2.aDJ = adBaseFrameLayout;
        bVar2.OE = adBaseFrameLayout;
        bVar2.NY = this.cL;
        bVar2.mReportExtData = null;
        bVar2.aDL = false;
        bVar2.aDM = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        if (this.eg != null || this.DX) {
            return;
        }
        com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(com.kwad.sdk.core.response.b.b.cT(this.Dg.mAdTemplate));
        this.eg = dVar;
        dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.c.p.8
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d10) {
                boolean nr = com.kwad.components.core.e.c.b.nr();
                if (!p.this.Dg.Cs.tz() || nr) {
                    return;
                }
                p.this.h(d10);
                if (p.this.eh == null) {
                    p pVar = p.this;
                    pVar.eh = pVar.D(pVar.getContext());
                }
                bn.a(p.this.getContext(), p.this.eh);
                p.this.eg.bj(p.this.getContext());
            }

            @Override // com.kwad.sdk.core.g.b
            public final void aV() {
            }
        });
        this.eg.bi(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw() {
        this.DX = true;
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.Eb;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (com.kwad.sdk.core.response.b.b.dx(this.mAdInfo)) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.10
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a((Presenter) new m(), true);
                }
            });
            return;
        }
        if (com.kwad.sdk.core.response.b.b.dz(this.mAdInfo)) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.11
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a((Presenter) new l(), true);
                }
            });
        } else if (com.kwad.sdk.core.response.b.b.dC(this.mAdInfo)) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.12
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a((Presenter) new n(), true);
                }
            });
        } else {
            lx();
        }
    }

    private void lx() {
        lv();
        com.kwad.components.ad.splashscreen.f.b bVar = new com.kwad.components.ad.splashscreen.f.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate), this.Dg.mApkDownloadHelper);
        this.DV = bVar;
        bVar.ah(this.mAdTemplate);
        this.DV.a(this);
        this.DV.lw();
    }

    private x ly() {
        return new x(this.cO, this.Dg.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.p.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (com.kwad.sdk.d.a.a.Au()) {
                    return;
                }
                if (aVar.Hb() || com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    p.this.a(false, aVar.XC, aVar.kl, aVar.XD.KG);
                }
            }
        });
    }

    private aa lz() {
        return new aa(this.cO, this.Dg.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.p.3
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar.XA || !com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    p.this.a(false, aVar.XA ? 1 : 3, aVar.kl, "");
                }
            }
        }, (byte) 0);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i10) {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bi(getContext());
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.Dg.Cs.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.Eb = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.cL = new KsAdWebView(getContext());
            this.cL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.Eb.addView(this.cL);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.Dg.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.DW = false;
        this.DX = false;
        String ci = com.kwad.sdk.core.response.b.b.ci(this.mAdTemplate);
        if (this.cL != null && !TextUtils.isEmpty(ci) && !this.Dg.Cx) {
            this.DY = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.ag(this.mAdTemplate);
            a(this.cL, ci);
            bn.a(this.Ec, null, com.kwad.sdk.core.response.b.b.dG(this.mAdInfo));
        } else {
            lw();
        }
        this.Dg.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kA() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    public final void lv() {
        if (this.DW) {
            return;
        }
        this.DW = true;
        a.C0516a c0516a = new a.C0516a();
        c0516a.apc = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.Dg.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(123).b(c0516a));
        com.kwad.components.core.webview.tachikoma.d.a.sY().aW(123);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.f.b bVar = this.DV;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        aw awVar = this.DZ;
        if (awVar != null) {
            awVar.st();
            this.DZ.su();
        }
        this.Dg.Cs.b(this);
        aA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d10) {
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar != null) {
            hVar.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.p.9
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.l(d10);
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void h(boolean z10, boolean z11) {
        com.kwad.sdk.core.e.c.d("SplashWebViewPresenter", "isClick: " + z10 + ", isActionBar: " + z11);
        a(!z10, z11 ? 1 : 2, 132, null);
    }

    public static /* synthetic */ boolean a(p pVar, boolean z10) {
        pVar.Ea = true;
        return true;
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        ax();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ei(this.Dg.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.c.p.5
            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.DY);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i10, String str2, String str3) {
                super.onReceivedHttpError(i10, str2, str3);
                bn.c(p.this.Ec);
                p.this.lw();
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.DY, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            lw();
        }
    }

    private void a(WebView webView, String str) {
        aA();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.cN = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new az(this.cO, this.Dg.mApkDownloadHelper));
        aVar.a(lz());
        aVar.a(ly());
        aVar.a(new ad(this.cO));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new aq(new aq.b() { // from class: com.kwad.components.ad.splashscreen.c.p.6
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                com.kwad.sdk.core.e.c.d("SplashWebViewPresenter", "updatePageStatus: " + ((Object) aVar2));
                bn.c(p.this.Ec);
                if (aVar2.status == 1) {
                    p.this.Dg.CJ = SystemClock.elapsedRealtime() - p.this.mStartTime;
                    if (!p.this.Ea) {
                        if (p.this.DZ != null) {
                            p.this.DZ.sr();
                            p.this.DZ.ss();
                        }
                    } else {
                        p.this.Dg.isWebTimeout = true;
                    }
                    if (com.kwad.sdk.core.response.b.b.dE(p.this.mAdInfo)) {
                        p.this.lv();
                        return;
                    }
                    return;
                }
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.DY, 3, "");
                p.this.lw();
            }
        }, str));
        aVar.a(new ay(new ay.a() { // from class: com.kwad.components.ad.splashscreen.c.p.7
            @Override // com.kwad.components.core.webview.jshandler.ay.a
            public final void bB() {
                p.this.bu();
            }
        }));
        aVar.a(new ak(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aw awVar = new aw();
        this.DZ = awVar;
        aVar.a(awVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r10, int r11, int r12, java.lang.String r13) {
        /*
            r9 = this;
            com.kwad.components.ad.splashscreen.h r0 = r9.Dg
            r0.kB()
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r11 != r1) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = 0
        L11:
            if (r0 != 0) goto L4b
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            com.kwad.components.ad.splashscreen.h r5 = r9.Dg     // Catch: org.json.JSONException -> L45
            if (r5 == 0) goto L4b
            com.kwad.components.ad.splashscreen.e.a r5 = r5.Cq     // Catch: org.json.JSONException -> L45
            if (r5 == 0) goto L29
            java.lang.String r6 = "duration"
            long r7 = r5.getCurrentPosition()     // Catch: org.json.JSONException -> L45
            r4.put(r6, r7)     // Catch: org.json.JSONException -> L45
        L29:
            if (r10 == 0) goto L2e
            r2 = 153(0x99, float:2.14E-43)
            goto L32
        L2e:
            if (r3 == 0) goto L32
            r2 = 132(0x84, float:1.85E-43)
        L32:
            com.kwad.sdk.core.adlog.c.b r10 = new com.kwad.sdk.core.adlog.c.b     // Catch: org.json.JSONException -> L43
            r10.<init>()     // Catch: org.json.JSONException -> L43
            com.kwad.sdk.core.adlog.c.b r10 = r10.cK(r2)     // Catch: org.json.JSONException -> L43
            com.kwad.components.ad.splashscreen.h r5 = r9.Dg     // Catch: org.json.JSONException -> L43
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.mAdTemplate     // Catch: org.json.JSONException -> L43
            com.kwad.sdk.core.adlog.c.a(r5, r10, r4)     // Catch: org.json.JSONException -> L43
            goto L4c
        L43:
            r10 = move-exception
            goto L47
        L45:
            r10 = move-exception
            r2 = r12
        L47:
            com.kwad.sdk.core.e.c.printStackTrace(r10)
            goto L4c
        L4b:
            r2 = r12
        L4c:
            com.kwad.components.core.e.d.a$a r10 = new com.kwad.components.core.e.d.a$a
            com.kwad.components.ad.splashscreen.h r4 = r9.Dg
            com.kwad.sdk.core.view.AdBaseFrameLayout r4 = r4.mRootContainer
            android.content.Context r4 = r4.getContext()
            r10.<init>(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.Dg
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate
            com.kwad.components.core.e.d.a$a r10 = r10.aq(r4)
            com.kwad.components.ad.splashscreen.h r4 = r9.Dg
            com.kwad.components.core.e.d.c r4 = r4.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r10 = r10.b(r4)
            com.kwad.components.core.e.d.a$a r10 = r10.ao(r3)
            com.kwad.components.core.e.d.a$a r10 = r10.an(r11)
            if (r0 == 0) goto L74
            goto L75
        L74:
            r12 = r2
        L75:
            com.kwad.components.core.e.d.a$a r10 = r10.am(r12)
            com.kwad.components.core.e.d.a$a r10 = r10.ag(r13)
            com.kwad.components.core.e.d.a$a r10 = r10.al(r1)
            com.kwad.components.core.e.d.a$a r10 = r10.aq(r0)
            com.kwad.components.ad.splashscreen.c.p$4 r11 = new com.kwad.components.ad.splashscreen.c.p$4
            r11.<init>()
            com.kwad.components.core.e.d.a$a r10 = r10.a(r11)
            com.kwad.components.core.e.d.a.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.c.p.a(boolean, int, int, java.lang.String):void");
    }
}
