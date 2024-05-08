package com.kwad.components.ad.fullscreen.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.f.h;
import com.kwad.components.ad.reward.presenter.j;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.m;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.components.core.e.e.f;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.e.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements g, f {
    private com.kwad.components.ad.fullscreen.b gR;
    private ViewGroup gS;
    private com.kwad.components.core.l.b gT;

    @Nullable
    private r gU;
    private FrameLayout gV;
    private com.kwad.components.ad.reward.presenter.f.b gW;
    private e gX;

    @Nullable
    private com.kwad.components.ad.reward.presenter.e.a gY;
    private com.kwad.components.ad.reward.presenter.f.f gZ;

    /* renamed from: ha, reason: collision with root package name */
    private boolean f36484ha = false;

    public b(com.kwad.components.core.l.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, com.kwad.components.ad.reward.g gVar) {
        this.gT = bVar;
        this.gR = bVar2;
        this.gS = viewGroup;
        this.qo = gVar;
        bP();
    }

    private void bP() {
        if (this.gR == null) {
            return;
        }
        bU();
        AdInfo bH = this.gR.bH();
        boolean cW = com.kwad.sdk.core.response.b.a.cW(bH);
        boolean dV = com.kwad.sdk.core.response.b.b.dV(bH);
        if (cW) {
            this.qo.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.tachikoma.d.b.tc().a(bV());
            bR();
        } else if (dV) {
            com.kwad.components.core.webview.tachikoma.d.b.tc().a(bV());
            this.qo.a(RewardRenderResult.TK_IMAGE);
            bS();
        } else if (a(this.qo)) {
            this.qo.a(RewardRenderResult.FULLSCREEN_TK);
            bT();
            com.kwad.components.core.webview.tachikoma.d.b.tc().a(bV());
        } else {
            this.qo.a(RewardRenderResult.DEFAULT);
            bQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ() {
        com.kwad.components.core.webview.tachikoma.d.b.tc().b(this.gX);
        com.kwad.components.core.e.e.g.or().a(this);
        AdTemplate adTemplate = this.gR.getAdTemplate();
        AdInfo bH = this.gR.bH();
        boolean z10 = this.gR.bI() && !ai.isOrientationPortrait();
        if (this.gR.gt) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(bH)) {
            a(new d(), true);
        }
        a(new m(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        if (com.kwad.sdk.core.response.b.b.dg(bH)) {
            a(new h(), true);
        }
        if (!z10) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        if (com.kwad.sdk.core.response.b.b.dg(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.c.a.f(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(bH)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        a(new l(), true);
        if (com.kwad.sdk.core.response.b.a.cL(bH)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new k(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        }
        r rVar = new r(adTemplate, false, false);
        this.gU = rVar;
        a((Presenter) rVar, true);
        a(new c(), true);
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, false), true);
        a(new com.kwad.components.ad.reward.presenter.e(bH, this.gS), true);
        a(new j(), true);
    }

    private void bR() {
        com.kwad.components.ad.fullscreen.c.c.c cVar = new com.kwad.components.ad.fullscreen.c.c.c();
        this.gW = cVar;
        a(cVar);
    }

    private void bS() {
        com.kwad.components.ad.fullscreen.c.c.a aVar = new com.kwad.components.ad.fullscreen.c.c.a();
        this.gZ = aVar;
        a(aVar);
    }

    private void bT() {
        a((Presenter) new com.kwad.components.ad.fullscreen.c.c.b(), true);
    }

    private void bU() {
        AdInfo bH = this.gR.bH();
        if (!this.gR.gt) {
            a(this);
        }
        if (com.kwad.sdk.core.response.b.b.dS(bH) && ai.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.gY = aVar;
            a((Presenter) aVar, true);
        }
    }

    private e bV() {
        if (this.gX == null) {
            this.gX = new e() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                @Override // com.kwad.components.core.webview.tachikoma.e.e
                public final void a(String str, long j10, long j11, long j12) {
                    b.this.qo.jY = true;
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void q(String str) {
                    if (!"tk_fullscreen".equals(str) && !"tk_live_video".equals(str)) {
                        if ("tk_image_video".equals(str)) {
                            b bVar = b.this;
                            bVar.a(bVar);
                            b.this.qo.a(RewardRenderResult.DEFAULT);
                            b.this.bQ();
                            return;
                        }
                        return;
                    }
                    b bVar2 = b.this;
                    bVar2.a(bVar2);
                    com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.qo, b.this.bW());
                    b.this.bQ();
                }
            };
        }
        return this.gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout bW() {
        if (this.gV == null) {
            this.gV = (FrameLayout) this.gS.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.gV;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.b(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        this.qo.C(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.qo.D(false);
        this.qo.fu();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        r rVar = this.gU;
        if (rVar != null && rVar.onBackPressed()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.gY;
        if (aVar != null && aVar.gn() == BackPressHandleResult.HANDLED) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.gW;
        return bVar != null && bVar.gn() == BackPressHandleResult.HANDLED;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gV = (FrameLayout) this.gS.findViewById(R.id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.c(this);
        com.kwad.components.core.e.e.g.or().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.tc().b(this.gX);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.qo.fv();
        this.qo.D(true);
    }

    private static boolean a(com.kwad.components.ad.reward.g gVar) {
        if (!com.kwad.sdk.core.config.d.BV()) {
            com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        }
        if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate))) {
            return false;
        }
        AdMatrixInfo.FullScreenInfo dc2 = com.kwad.sdk.core.response.b.b.dc(gVar.mAdTemplate);
        if (dc2 != null && dc2.renderType == 1) {
            return true;
        }
        com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (this.f36484ha) {
            return;
        }
        bVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.qo), true);
        this.f36484ha = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
