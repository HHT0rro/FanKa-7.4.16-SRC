package com.kwad.components.ad.reward;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.e.g, com.kwad.components.core.e.e.f {
    private ViewGroup gS;
    private com.kwad.components.core.l.b gT;

    @Nullable
    private r gU;
    private FrameLayout gV;
    private com.kwad.components.ad.reward.presenter.f.b gW;

    @Nullable
    private com.kwad.components.ad.reward.presenter.e.a gY;
    private com.kwad.components.ad.reward.presenter.f.f gZ;

    /* renamed from: ha, reason: collision with root package name */
    private boolean f36558ha = false;
    private com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.reward.m.1
        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void a(String str, long j10, long j11, long j12) {
            m.this.qo.jY = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            if (!"tk_reward".equals(str) && !"tk_live_video".equals(str)) {
                if ("tk_image_video".equals(str)) {
                    m mVar = m.this;
                    mVar.a(mVar);
                    m.this.qo.a(RewardRenderResult.DEFAULT);
                    m mVar2 = m.this;
                    mVar2.a(mVar2.gT, m.this.mModel);
                    return;
                }
                return;
            }
            m mVar3 = m.this;
            mVar3.a(mVar3);
            g.a(m.this.getContext(), m.this.qo, m.this.bW());
            m.this.qo.a(RewardRenderResult.DEFAULT);
            m mVar4 = m.this;
            mVar4.a(mVar4.gT, m.this.mModel);
        }
    };
    private Context mContext;
    private com.kwad.components.ad.reward.model.c mModel;
    private g qo;

    @Nullable
    private a qp;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void onUnbind();
    }

    public m(com.kwad.components.core.l.b bVar, Context context, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, g gVar) {
        boolean z10 = false;
        this.mContext = context;
        this.gS = viewGroup;
        this.mModel = cVar;
        this.qo = gVar;
        this.gT = bVar;
        a(cVar);
        AdInfo bH = cVar.bH();
        boolean dV = com.kwad.sdk.core.response.b.b.dV(bH);
        boolean z11 = (com.kwad.sdk.core.response.b.a.cL(bH) && a(this.qo.mAdResultData.adGlobalConfigInfo)) || com.kwad.sdk.core.response.b.a.bd(bH) || g.G(cVar.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.cW(bH) && a(this.qo.mAdResultData.adGlobalConfigInfo)) {
            z10 = true;
        }
        com.kwad.sdk.core.e.c.d("RewardPresenter", "notFullTk: " + z11 + ", mLoadStrategy: " + ((Object) this.qo.pB));
        if (z10) {
            com.kwad.components.core.webview.tachikoma.d.b.tc().a(this.jR);
            gVar.a(RewardRenderResult.LIVE_TK);
            bR();
        } else if (dV) {
            com.kwad.components.core.webview.tachikoma.d.b.tc().a(this.jR);
            gVar.a(RewardRenderResult.TK_IMAGE);
            bS();
        } else if (!z11 && this.qo.pB.equals(LoadStrategy.FULL_TK)) {
            com.kwad.components.core.webview.tachikoma.d.b.tc().a(this.jR);
            gVar.a(RewardRenderResult.NEO_TK);
            gm();
        } else {
            gVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        }
    }

    private void bR() {
        com.kwad.components.ad.reward.presenter.f.b bVar = new com.kwad.components.ad.reward.presenter.f.b();
        this.gW = bVar;
        a(bVar);
    }

    private void bS() {
        com.kwad.components.ad.reward.presenter.f.c cVar = new com.kwad.components.ad.reward.presenter.f.c();
        this.gZ = cVar;
        a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout bW() {
        if (this.gV == null) {
            this.gV = (FrameLayout) this.gS.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.gV;
    }

    private void gm() {
        com.kwad.components.ad.reward.presenter.f.f fVar = new com.kwad.components.ad.reward.presenter.f.f();
        this.gZ = fVar;
        a(fVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.b(this);
        com.kwad.components.ad.reward.c.a.gL().setCallerContext(this.qo);
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

    public final BackPressHandleResult gn() {
        r rVar = this.gU;
        if (rVar != null && rVar.onBackPressed()) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.gY;
        if (aVar != null) {
            BackPressHandleResult gn = aVar.gn();
            BackPressHandleResult backPressHandleResult = BackPressHandleResult.HANDLED;
            if (gn == backPressHandleResult) {
                return backPressHandleResult;
            }
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.gW;
        if (bVar != null) {
            return bVar.gn();
        }
        com.kwad.components.ad.reward.presenter.f.f fVar = this.gZ;
        if (fVar != null) {
            return fVar.gn();
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gV = (FrameLayout) this.gS.findViewById(R.id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.gT = null;
        com.kwad.components.core.webview.tachikoma.d.b.tc().b(this.jR);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.c(this);
        a aVar = this.qp;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.core.e.e.g.or().b(this);
        com.kwad.components.ad.reward.c.a.gL().reset();
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.qo.fv();
        this.qo.D(true);
    }

    private static boolean a(AdGlobalConfigInfo adGlobalConfigInfo) {
        return adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (this.f36558ha) {
            return;
        }
        mVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.qo), true);
        this.f36558ha = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.l.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        if (this.mModel == null) {
            return;
        }
        com.kwad.components.core.e.e.g.or().a(this);
        AdInfo bH = this.mModel.bH();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        if (cVar.gt) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(bH)) {
            a(new com.kwad.components.ad.reward.presenter.d(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.m(), true);
        a(new com.kwad.components.ad.reward.presenter.h(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.a.e(), true);
        boolean hi = cVar.hi();
        boolean hj = cVar.hj();
        boolean z10 = cVar.bI() && !ai.isOrientationPortrait();
        if (!hi && !hj && !z10) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.n(), true);
        a(new com.kwad.components.ad.reward.presenter.c(bH), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, true), true);
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        a(new u(), true);
        a(new com.kwad.components.ad.reward.presenter.e(bH, this.gS), true);
        r rVar = new r(adTemplate);
        this.gU = rVar;
        a((Presenter) rVar, true);
        a(new com.kwad.components.ad.reward.presenter.l(), true);
        g gVar = this.qo;
        if (gVar.oY && com.kwad.components.ad.reward.d.a.b(gVar.mContext, com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        }
        if (com.kwad.sdk.core.response.b.b.dh(adTemplate)) {
            a(new t(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(bH)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        if (com.kwad.sdk.core.response.b.a.cL(bH)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new com.kwad.components.ad.reward.presenter.k(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.j(), true);
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdInfo bH = cVar.bH();
        if (!cVar.gt) {
            a(this);
        }
        if (g.g(bH)) {
            a(new com.kwad.components.ad.reward.presenter.g());
        }
        if (com.kwad.sdk.core.response.b.a.aO(bH) && ai.LZ()) {
            a(new com.kwad.components.ad.reward.presenter.h.a());
        }
        if (com.kwad.sdk.core.response.b.b.dg(bH)) {
            a(new com.kwad.components.ad.reward.presenter.f.h());
        }
        if (com.kwad.sdk.core.response.b.b.dS(bH) && ai.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.gY = aVar;
            a(aVar);
        }
    }

    public final void a(@Nullable a aVar) {
        this.qp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
