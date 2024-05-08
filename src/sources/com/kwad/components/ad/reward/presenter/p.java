package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p extends b {
    private com.kwad.components.core.playable.a oL;
    private PlayableSource sI;
    private final com.kwad.components.ad.reward.e.j sJ = new com.kwad.components.ad.reward.e.k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
            p.this.sI = playableSource;
            if (p.this.oL != null && p.this.oL.qf()) {
                p.this.oL.e(playableSource);
                com.kwad.components.ad.reward.g gVar = p.this.qo;
                if (gVar != null) {
                    gVar.d(playableSource);
                    p.this.qo.B(true);
                    if (p.this.qo.oJ.jM()) {
                        p.this.qo.oJ.jN().pause();
                    }
                }
                com.kwad.components.ad.reward.a.eX().b(playableSource);
                return;
            }
            if (p.this.oL != null) {
                p.this.oL.hz();
            }
            if (nVar != null) {
                nVar.gT();
                com.kwad.sdk.core.e.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(p.this.qo.mAdTemplate))) {
                DownloadLandPageActivity.launch(p.this.getActivity(), p.this.qo.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void bY() {
            p.this.oL.hz();
            com.kwad.components.ad.reward.g gVar = p.this.qo;
            if (gVar != null) {
                gVar.d((PlayableSource) null);
                if (p.this.qo.oJ.jM()) {
                    p.this.qo.oJ.jN().resume();
                }
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qo;
        com.kwad.components.core.playable.a aVar = gVar.oL;
        this.oL = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(gVar.mAdTemplate, gVar.mRootContainer, gVar.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.c.a(this.qo.oY, "playable");
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        com.kwad.components.ad.reward.g gVar2 = this.qo;
        com.kwad.components.ad.reward.monitor.c.a(gVar2.mAdTemplate, gVar2.oY, "playable", com.kwad.sdk.core.response.b.a.bN(dQ));
        this.oL.qe();
        this.oL.a(new aq.b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                if (aVar2.isSuccess()) {
                    return;
                }
                AdInfo dQ2 = com.kwad.sdk.core.response.b.e.dQ(p.this.qo.mAdTemplate);
                long loadTime = p.this.qo.oL.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.g gVar3 = p.this.qo;
                com.kwad.components.ad.reward.monitor.c.a(gVar3.mAdTemplate, gVar3.oY, "playable", com.kwad.sdk.core.response.b.a.bN(dQ2), System.currentTimeMillis() - loadTime, 3);
            }
        });
        this.oL.a(new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                AdInfo dQ2 = com.kwad.sdk.core.response.b.e.dQ(p.this.qo.mAdTemplate);
                long loadTime = p.this.qo.oL.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.a(p.this.qo.oY, "playable", com.kwad.sdk.core.response.b.a.bN(dQ2), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i10, String str, String str2) {
                com.kwad.components.ad.reward.g gVar3 = p.this.qo;
                AdTemplate adTemplate = gVar3.mAdTemplate;
                com.kwad.components.ad.reward.monitor.c.a(adTemplate, gVar3.oY, "playable", com.kwad.sdk.core.response.b.a.bN(com.kwad.sdk.core.response.b.e.dQ(adTemplate)), System.currentTimeMillis() - p.this.qo.oL.getLoadTime(), 2);
            }
        });
        com.kwad.components.ad.reward.a.eX().a(this.sJ);
    }

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.oL;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.sI);
            }
        }
    }

    public final void hz() {
        com.kwad.components.core.playable.a aVar = this.oL;
        if (aVar != null) {
            aVar.hz();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.oL;
        if (aVar == null) {
            return;
        }
        aVar.qd();
        this.oL.hz();
        com.kwad.components.ad.reward.a.eX().b(this.sJ);
    }
}
