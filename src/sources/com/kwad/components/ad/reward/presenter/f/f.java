package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f extends a implements j, a.InterfaceC0466a {
    private com.kwad.components.core.webview.tachikoma.e lh;
    private List<com.kwad.components.core.i.c> tn;
    public FrameLayout wg;
    private boolean wh = false;
    private final com.kwad.components.core.webview.tachikoma.e.a oV = new com.kwad.components.core.webview.tachikoma.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.webview.tachikoma.e.a
        public final void ja() {
            if (f.this.lh != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aae = f.this.qo.fP ? 1 : 0;
                f.this.lh.b(aVar);
            }
        }
    };

    private void V(boolean z10) {
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "fullTK: " + z10);
        FrameLayout frameLayout = this.wg;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z10 ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c dB() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.aag = com.kwad.components.ad.reward.model.b.cO();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.e dC() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.aae = f.this.qo.fP ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (!this.wh) {
            V(true);
        }
        com.kwad.components.ad.reward.g gVar = this.qo;
        gVar.oZ = true ^ this.wh;
        gVar.a((a.InterfaceC0466a) this);
        com.kwad.components.ad.reward.a.eX().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        FrameLayout frameLayout;
        if (this.wh || (frameLayout = this.wg) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
    }

    @IdRes
    public int ci() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.wg;
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dm(this.qo.mAdTemplate);
    }

    public final BackPressHandleResult gn() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wk;
        if (dVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return dVar.gn();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wg = (FrameLayout) findViewById(ci());
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void onError(int i10, String str) {
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void onRequestResult(int i10) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.b((a.InterfaceC0466a) this);
        com.kwad.components.ad.reward.a.eX().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar != null && !com.kwad.sdk.core.response.b.e.b(this.qo.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            if (aVar.adTemplate != null && !aVar.aEO) {
                this.qo.oI.bJ();
                return;
            }
            com.kwad.components.core.i.c a10 = com.kwad.components.ad.reward.g.a(this.tn, aVar.creativeId);
            if (a10 != null) {
                this.qo.a(a10);
                return;
            }
            return;
        }
        this.qo.oI.bJ();
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list == null || list.size() == 0 || this.wk == null) {
            return;
        }
        this.tn = list;
        List<AdTemplate> a10 = a(list, this.qo.mAdTemplate);
        com.kwad.sdk.core.webview.b sD = this.wk.sD();
        if (sD != null) {
            sD.setAdTemplateList(a10);
        }
        l jo = this.wk.jo();
        if (jo != null) {
            jo.g(a10);
        } else {
            this.wk.h(a10);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.wh = true;
        this.qo.oZ = false;
        V(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        qVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.gO());
                f.this.a(bVar2);
            }
        }));
        this.lh = dC();
        this.qo.a(this.oV);
        qVar.c(this.lh);
        qVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dL() {
                com.kwad.components.ad.reward.model.b.J(f.this.qo.mContext);
            }
        }));
        qVar.c(dB());
        qVar.c(new com.kwad.components.core.webview.jshandler.h(new n() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(com.kwad.components.core.webview.jshandler.h hVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    hVar.aT(com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.dQ(f.this.qo.mAdTemplate)) && com.kwad.sdk.core.d.a.DG() && f.this.qo.mScreenOrientation == 0);
                }
            }
        }));
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.i.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.i.c.m(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        FrameLayout frameLayout;
        if (this.wh || (frameLayout = this.wg) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        com.kwad.components.ad.reward.e.b bVar;
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onSkipClick: " + tVar.VU);
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (gVar != null && (bVar = gVar.oI) != null) {
            bVar.onVideoSkipToEnd(tVar.VU * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.s(this.qo);
        com.kwad.components.ad.reward.g.a(this.qo.oR, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            private static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.iL();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }
}
