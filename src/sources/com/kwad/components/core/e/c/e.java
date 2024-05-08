package com.kwad.components.core.e.c;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e extends c implements View.OnClickListener {

    @Nullable
    public b Ke;
    public b.C0460b Kf;
    private Runnable Kn;
    private KsAdWebView cL;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private aw cQ;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean Ko = false;
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.e.c.e.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.Ko);
            e.a(e.this, true);
        }
    };
    private aj.b cS = new aj.b() { // from class: com.kwad.components.core.e.c.e.4
        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + ((Object) aVar));
            e.this.cL.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };
    private ai.b cT = new ai.b() { // from class: com.kwad.components.core.e.c.e.5
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.aF();
        }
    };
    private aq.b cU = new aq.b() { // from class: com.kwad.components.core.e.c.e.6
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            com.kwad.sdk.core.e.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + ((Object) aVar));
            if (aVar.status == 1) {
                e.this.nx();
                return;
            }
            e.this.aF();
            if (e.this.getContext() != null) {
                v.O(e.this.getContext(), w.bY(e.this.getContext()));
            }
        }
    };

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.Ko);
        if (this.cL.getVisibility() != 0) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.st();
        }
        this.cL.setVisibility(4);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.su();
        }
        if (this.Ko) {
            com.kwad.sdk.core.adlog.c.bO(this.mAdTemplate);
        }
        b bVar = this.Ke;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.Ke.aj(this.Ko);
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.Kg.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        AdBaseFrameLayout adBaseFrameLayout = this.Kg.mRootContainer;
        bVar2.aDJ = adBaseFrameLayout;
        bVar2.OE = adBaseFrameLayout;
        bVar2.NY = this.cL;
    }

    private void az() {
        com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void nv() {
        az();
        this.cL.loadUrl(this.Kf.url);
        this.cL.postDelayed(nw(), 1500L);
        this.cL.setBackgroundColor(0);
        this.cL.getBackground().setAlpha(0);
        this.cL.setVisibility(0);
    }

    private Runnable nw() {
        if (this.Kn == null) {
            this.Kn = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.aF();
                    if (e.this.getContext() != null) {
                        v.O(e.this.getContext(), w.bY(e.this.getContext()));
                    }
                }
            };
        }
        return this.Kn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx() {
        Runnable runnable = this.Kn;
        if (runnable != null) {
            this.cL.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.cL.setVisibility(8);
        this.cL.release();
        aA();
    }

    @Override // com.kwad.components.core.e.c.c, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        d dVar = this.Kg;
        this.Ke = dVar.Ke;
        this.Kf = dVar.Kf;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.Kg.mApkDownloadHelper;
        ax();
        nv();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.bO(this.mAdTemplate);
        b bVar = this.Ke;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cL = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        nx();
    }

    public static /* synthetic */ boolean a(e eVar, boolean z10) {
        eVar.Ko = true;
        return true;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, this.cR));
        aVar.a(new x(this.cO, this.mApkDownloadHelper, this.cR, 1));
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aj(this.cO, this.cS));
        aVar.a(new aq(this.cU, this.Kf.url));
        aw awVar = new aw();
        this.cQ = awVar;
        aVar.a(awVar);
        aVar.a(new az(this.cO, this.mApkDownloadHelper, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.core.e.c.e.3
            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(e.this.mAdTemplate);
                String ay = com.kwad.sdk.core.response.b.a.ay(dQ);
                if (com.kwad.sdk.core.response.b.a.aO(dQ) && com.kwad.sdk.core.response.b.a.aF(dQ) && ak.an(e.this.getContext(), ay) && com.kwad.components.core.q.a.qH().qL() && com.kwad.sdk.core.response.b.a.aN(dQ) == 1) {
                    e.this.Ke.dismiss();
                }
            }
        }));
        aVar.a(new ai(this.cT));
        aVar.a(new com.kwad.components.core.webview.jshandler.ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
    }
}
