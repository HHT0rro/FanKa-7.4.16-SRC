package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.e;
import com.kwad.sdk.R;
import com.kwad.sdk.components.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h extends g implements j, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private boolean wA;
    private boolean wB;

    @Nullable
    private View wE;
    private aw wz;
    private boolean wF = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            h.this.wD.setVisibility(8);
        }
    };
    private g.a wG = new g.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.ad.reward.g.a
        public final void fU() {
            h.this.wB = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fV() {
            h.this.wB = true;
            h.this.iY();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fW() {
            h.this.wB = false;
            if (h.this.wz != null) {
                h.this.wz.sw();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fX() {
            h.this.wB = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iY() {
        aw awVar = this.wz;
        if (awVar == null || !this.wB) {
            return;
        }
        if (!this.wA) {
            awVar.sr();
            this.wz.ss();
            this.wA = true;
            return;
        }
        awVar.sv();
    }

    private e.b jb() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.tachikoma.a.e.b
            public final int jc() {
                if (h.this.qo.po != null) {
                    return com.kwad.sdk.d.a.a.px2dip(h.this.getContext(), r0.cf());
                }
                if (h.this.wE == null) {
                    return 0;
                }
                if (h.this.wE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    return com.kwad.sdk.d.a.a.px2dip(h.this.getContext(), h.this.wE.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
                }
                return com.kwad.sdk.d.a.a.px2dip(h.this.getContext(), h.this.wE.getHeight());
            }
        };
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.a(this.wG);
        this.qo.oM.a(this);
        this.qo.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        super.bF();
        iY();
        this.wF = true;
        this.wD.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        if (this.wF) {
            this.wD.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        if (this.wF) {
            this.wD.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dl(this.qo.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hM() {
        return R.id.ksad_js_topfloor;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        super.onUnbind();
        this.qo.b(this.wG);
        this.qo.oM.b(this);
        this.qo.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().b(this);
        this.qo.a((com.kwad.components.core.webview.tachikoma.e.a) null);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        float screenHeight = com.kwad.sdk.d.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.d.a.a.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((screenHeight / aJ) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        this.wF = false;
        this.wD.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        qVar.c(new com.kwad.components.core.webview.tachikoma.a.e(jb()));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wz = awVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.wE = view;
    }
}
