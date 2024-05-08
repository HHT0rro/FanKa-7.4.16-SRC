package com.kwad.components.ad.reward.presenter.f;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.i;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.k;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.h;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.a.y;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.h;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class d extends com.kwad.components.ad.reward.presenter.b implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.k.a.e, y.a {
    public com.kwad.components.ad.reward.k.a.d wk;
    private p wl;
    private o wm;
    private i wn;
    private j wo;
    private com.kwad.components.core.webview.tachikoma.b.y wp;
    private boolean wq;
    private com.kwad.components.core.webview.tachikoma.a.h wr;

    @Nullable
    public e ws;
    private be.b wt = new be.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        @Override // com.kwad.components.core.webview.jshandler.be.b
        public final void Q(int i10) {
            com.kwad.sdk.core.adlog.c.b f10 = new com.kwad.sdk.core.adlog.c.b().cK(i10).f(d.this.qo.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new a.C0461a(d.this.getContext()).aq(d.this.qo.mAdTemplate).b(d.this.qo.mApkDownloadHelper).ao(false));
            com.kwad.components.ad.reward.j.b.a(d.this.qo.mAdTemplate, d.this.iV(), (String) null, f10, (JSONObject) null);
        }
    };
    private final h.a hq = new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.wm == null || com.kwad.components.ad.reward.a.b.gs()) {
                return;
            }
            m mVar = new m();
            mVar.aao = true;
            d.this.wm.c(mVar);
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.wn != null) {
                com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
                hVar.aaj = 1;
                d.this.wn.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (d.this.wo != null) {
                bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
                        oVar.scene = 1;
                        d.this.wo.a(oVar);
                        if (d.this.wr != null) {
                            d.this.wr.aV(d.this.qo.pA);
                        }
                    }
                }, 0L);
            }
        }
    };
    private final com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.hw();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            d.this.iT();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.a(j10, j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.g(ShadowDrawableWrapper.COS_45);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            d.this.g(ShadowDrawableWrapper.COS_45);
        }
    };

    public d() {
        if (iM()) {
            this.ws = new e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        if (this.qo.f36546pd) {
            iT();
        } else {
            iS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iN() {
        com.kwad.components.ad.reward.g gVar = this.qo;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO() {
        this.qo.x(iV());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP() {
        com.kwad.components.ad.reward.j.b.a(this.qo.mAdTemplate, iV(), "endTopBar", new com.kwad.sdk.core.adlog.c.b().cK(39).f(this.qo.mRootContainer.getTouchCoords()), this.qo.mReportExtData);
        this.qo.oI.bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ() {
        com.kwad.components.ad.reward.j.b.a(this.qo.mAdTemplate, iV(), (String) null, new com.kwad.sdk.core.adlog.c.b().cK(40).f(this.qo.mRootContainer.getTouchCoords()), this.qo.mReportExtData);
        this.qo.oI.bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        com.kwad.components.ad.reward.j.b.a(this.qo.mAdTemplate, iV(), (String) null, new com.kwad.sdk.core.adlog.c.b().cK(41).f(this.qo.mRootContainer.getTouchCoords()), this.qo.mReportExtData);
        this.qo.oI.bJ();
    }

    private void iS() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wp;
        yVar.aat = true;
        yVar.aax = false;
        yVar.nE = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate));
        iU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wp;
        yVar.aax = true;
        yVar.aat = false;
        iU();
    }

    private void iU() {
        com.kwad.components.core.webview.tachikoma.b.y yVar;
        p pVar = this.wl;
        if (pVar == null || (yVar = this.wp) == null) {
            return;
        }
        pVar.a(yVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iV() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wk;
        if (dVar == null) {
            return null;
        }
        return dVar.getTkTemplateId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.qo.oI.onRewardVerify();
    }

    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.wq = true;
        this.qo.a(this);
        if (this.wk == null) {
            this.wk = new com.kwad.components.ad.reward.k.a.d(this.qo, -1L, getContext());
        }
        if (this.wp == null) {
            this.wp = new com.kwad.components.core.webview.tachikoma.b.y();
        }
        this.wk.a(this.qo.getActivity(), this.qo.mAdResultData, this);
        e eVar = this.ws;
        if (eVar != null) {
            eVar.y(this.qo);
        }
    }

    public void bF() {
        e eVar = this.ws;
        if (eVar != null) {
            eVar.bF();
        }
    }

    public void bG() {
    }

    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qo.mRootContainer;
    }

    public boolean iM() {
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.k.a.d dVar = this.wk;
        if (dVar == null || dVar.jn() == null) {
            return;
        }
        this.wk.jn().gQ();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.wq) {
            e eVar = this.ws;
            if (eVar != null) {
                eVar.z(this.qo);
            }
            this.qo.b(this);
            this.wk.jp();
            com.kwad.components.ad.reward.m.e eVar2 = this.qo.oJ;
            if (eVar2 != null) {
                eVar2.b(this.gO);
                this.qo.oJ.b(this.hq);
            }
            com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
            this.qo.c(this.mPlayEndPageListener);
        }
    }

    private void d(long j10, long j11) {
        long min = Math.min(com.kwad.sdk.core.response.b.a.ag(this.qo.mAdTemplate.adInfoList.get(0)), j10);
        if (j11 < min - 800) {
            this.qo.ps = (int) ((((float) (min - j11)) / 1000.0f) + 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(double d10) {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wp;
        yVar.aax = false;
        yVar.aat = false;
        yVar.nE = (int) ((d10 / 1000.0d) + 0.5d);
        iU();
    }

    public void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            @Override // com.kwad.components.ad.reward.k.k.a
            public final void d(com.kwad.components.core.webview.tachikoma.b.q qVar2) {
                com.kwad.components.ad.reward.c.fe().c(qVar2);
            }
        });
        qVar.c(kVar);
        long j10 = this.qo.pu;
        qVar.c(new com.kwad.components.ad.reward.k.g(j10 > 0 ? ((int) j10) / 1000 : 0));
        i iVar = new i();
        this.wn = iVar;
        qVar.c(iVar);
        j jVar = new j();
        this.wo = jVar;
        qVar.c(jVar);
        com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
        this.qo.b(this.mPlayEndPageListener);
        qVar.c(new ai(new ai.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar) {
                d.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.k.d dVar = new com.kwad.components.ad.reward.k.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11
            @Override // com.kwad.components.ad.reward.k.d.a
            public final void a(final com.kwad.components.core.webview.tachikoma.b.p pVar) {
                com.kwad.components.core.e.d.a.a(new a.C0461a(d.this.getContext()).aq(d.this.qo.mAdTemplate).b(d.this.qo.mApkDownloadHelper).an(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (pVar.aaq) {
                            d.this.iP();
                        } else {
                            d.this.iQ();
                        }
                    }
                }));
            }
        });
        qVar.c(dVar);
        com.kwad.components.ad.reward.k.e eVar = new com.kwad.components.ad.reward.k.e();
        eVar.a(new e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12
            @Override // com.kwad.components.ad.reward.k.e.a
            public final void iW() {
                com.kwad.components.core.e.d.a.a(new a.C0461a(d.this.getContext()).aq(d.this.qo.mAdTemplate).b(d.this.qo.mApkDownloadHelper).an(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        d.this.iR();
                    }
                }));
            }
        });
        qVar.c(eVar);
        qVar.c(new com.kwad.components.ad.reward.k.h(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            @Override // com.kwad.components.ad.reward.k.h.a
            public final void R(int i10) {
                if (com.kwad.components.ad.reward.g.G(d.this.qo.mAdTemplate)) {
                    if (com.kwad.components.ad.reward.g.E(d.this.qo.mAdTemplate) && d.this.qo.pq != null) {
                        if (!d.this.qo.pq.jB()) {
                            d.this.qo.pq.jA();
                        }
                    } else if (com.kwad.components.ad.reward.g.F(d.this.qo.mAdTemplate) && d.this.qo.pr != null && !d.this.qo.pr.jB()) {
                        d.this.qo.pr.jA();
                    }
                }
                if (d.this.qo.fJ() != RewardRenderResult.DEFAULT) {
                    d.this.qo.pg = i10;
                }
                d.this.notifyRewardVerify();
            }
        }));
        qVar.c(new com.kwad.components.ad.reward.k.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            @Override // com.kwad.components.ad.reward.k.c
            public final void iX() {
                super.iX();
                d.this.iO();
            }
        });
        qVar.c(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            @Override // com.kwad.components.ad.reward.k.f
            public final void U(boolean z10) {
                super.U(z10);
                com.kwad.components.ad.reward.presenter.f.t(d.this.qo);
            }
        });
        qVar.c(new com.kwad.components.ad.reward.k.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            @Override // com.kwad.components.ad.reward.k.b
            public final void iX() {
                super.iX();
                d.this.iN();
            }
        });
        qVar.c(new com.kwad.components.core.webview.tachikoma.a.q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.s.j.e(d.this.getContext(), d.this.qo.mAdTemplate);
            }
        });
        qVar.c(new com.kwad.components.ad.reward.i.b(getContext(), this.qo.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.tachikoma.a.h hVar = new com.kwad.components.core.webview.tachikoma.a.h();
        this.wr = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // com.kwad.components.core.webview.tachikoma.a.h.a
            public final void a(com.kwad.components.core.webview.tachikoma.a.h hVar2) {
                hVar2.aV(d.this.qo.pA);
            }
        });
        qVar.c(this.wr);
        qVar.c(new af());
        qVar.c(new be(bVar, this.qo.mApkDownloadHelper, this.wt));
        qVar.c(new y(this));
    }

    public void a(p pVar) {
        this.wl = pVar;
        com.kwad.components.ad.reward.m.e eVar = this.qo.oJ;
        if (eVar != null) {
            eVar.a(this.gO);
        }
    }

    public void a(t tVar) {
        com.kwad.components.ad.reward.presenter.f.a(this.qo, false);
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.ws;
        if (eVar != null) {
            eVar.iZ();
        }
    }

    public void a(aw awVar) {
        e eVar = this.ws;
        if (eVar != null) {
            eVar.b(awVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0481a c0481a) {
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (gVar == null || gVar.oI == null) {
            return;
        }
        try {
            a.c cVar = new a.c();
            cVar.parseJson(new JSONObject(c0481a.VS));
            String str = c0481a.VR;
            char c4 = 65535;
            switch (str.hashCode()) {
                case -1552949011:
                    if (str.equals("rewardVerifyCallback")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case -1228923142:
                    if (str.equals("adCloseCallback")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -402746255:
                    if (str.equals("videoPlayEndCallback")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 601135198:
                    if (str.equals("videoPlayErrorCallback")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1620545720:
                    if (str.equals("videoPlayStartCallback")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1852274314:
                    if (str.equals("adClickCallback")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 1917267918:
                    if (str.equals("adSkipWithPlayTimeCallback")) {
                        c4 = 4;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    this.qo.oI.bJ();
                    return;
                case 1:
                    this.qo.oI.onVideoPlayStart();
                    return;
                case 2:
                    this.qo.oI.onVideoPlayError(cVar.errorCode, cVar.VT);
                    return;
                case 3:
                    this.qo.oI.onVideoPlayEnd();
                    return;
                case 4:
                    this.qo.oI.onVideoSkipToEnd(cVar.VU);
                    return;
                case 5:
                    this.qo.oI.h(cVar.VV);
                    return;
                case 6:
                    this.qo.oI.onRewardVerify();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e("TKBasePresenter", "onOutCallback Error: " + th.getMessage());
        }
    }

    public void a(m mVar) {
        com.kwad.components.ad.reward.m.e eVar = this.qo.oJ;
        if (eVar != null) {
            eVar.setAudioEnabled(!mVar.aao, true);
        }
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.qo.oI.bJ();
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (gVar != null) {
            gVar.b(bVar);
        }
    }

    public void a(o oVar) {
        this.wm = oVar;
        com.kwad.components.ad.reward.m.e eVar = this.qo.oJ;
        if (eVar != null) {
            eVar.a(this.hq);
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                boolean z10 = com.kwad.components.core.s.a.ah(d.this.getContext()).qW() || !d.this.qo.mVideoPlayConfig.isVideoSoundEnable();
                m mVar = new m();
                mVar.aao = z10;
                d.this.wm.c(mVar);
                if (d.this.qo.oJ != null) {
                    d.this.qo.oJ.setAudioEnabled(!z10, false);
                }
            }
        });
    }

    public final void a(long j10, long j11) {
        d(j10, j11);
        g(j11);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.y.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.qo.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }
}
