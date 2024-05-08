package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bg;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e extends com.kwad.sdk.core.download.a.a implements aj.b, aq.b {
    private KsAdWebView cL;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private com.kwad.sdk.core.webview.d.a.a cR;

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.n.e.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.yt != null) {
                e.this.yt.ag(true);
            }
        }
    };
    private View ys;
    private bb yt;
    private f yu;

    public e(KsAdWebView ksAdWebView, View view, @Nullable com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this.ys = view;
        this.cL = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.cR = aVar;
    }

    private void R(String str) {
        if (bg.isNullString(str)) {
            jT();
            return;
        }
        aA();
        this.cL.setClientConfig(this.cL.getClientConfig().ei(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar, str);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
        this.cL.loadUrl(str);
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void ac(boolean z10) {
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "switchWebView: " + z10);
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z10 ? 0 : 8);
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.n.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i10, String str, String str2) {
                com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i10 + ", " + str);
                e.this.jT();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT() {
        View view = this.ys;
        if (view != null) {
            view.setVisibility(0);
        }
        ac(false);
    }

    private void l(String str, int i10) {
        f fVar = this.yu;
        if (fVar != null) {
            fVar.j(str, i10);
        }
    }

    public final void jS() {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        l(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        l(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.bY(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        l(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        l(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i10) {
        l(com.kwad.sdk.core.response.b.a.dn(i10), i10);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i10) {
        if (i10 != 0) {
            l(com.kwad.sdk.core.response.b.a.dm(i10), i10);
        }
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(adTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        bVar2.aDJ = null;
        bVar2.OE = viewGroup;
        bVar2.NY = this.cL;
        bVar2.mReportExtData = null;
        bVar2.aDL = true;
    }

    public final void a(f fVar) {
        this.yu = fVar;
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.cL.getBackground() != null) {
                this.cL.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        R(com.kwad.sdk.core.response.b.b.ck(this.mAdTemplate));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new x(this.cO, this.mApkDownloadHelper, this.cR));
        aVar.a(new ad(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aq(this, str));
        bb bbVar = new bb();
        this.yt = bbVar;
        aVar.a(bbVar);
        aVar.a(new ak(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new aj(this.cO, this));
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.i.b(this.cL.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + ((Object) aVar));
        if (aVar.status == 1) {
            ac(true);
        } else {
            jT();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aj.b
    public final void a(@NonNull aj.a aVar) {
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "onAdFrameValid : " + ((Object) aVar.toJson()));
    }
}
