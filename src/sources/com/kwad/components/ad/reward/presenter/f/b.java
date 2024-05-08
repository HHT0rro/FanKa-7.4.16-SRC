package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.sdk.R;
import com.kwad.sdk.components.q;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends d {
    private FrameLayout wg;
    private boolean wh = false;

    private void T(boolean z10) {
        this.wg.setVisibility(z10 ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c dB() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.aag = com.kwad.components.ad.reward.model.b.cO();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.wh) {
            return;
        }
        T(true);
    }

    @IdRes
    public int ci() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.wg;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dn(this.qo.mAdTemplate);
    }

    public final BackPressHandleResult gn() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wk;
        if (dVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return dVar.gn();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean iM() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wg = (FrameLayout) findViewById(ci());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        qVar.c(dB());
        qVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dL() {
                com.kwad.components.ad.reward.model.b.J(b.this.qo.mContext);
            }
        }));
        qVar.c(new v() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                b.this.qo.oI.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(b.this.qo.oY, b.this.qo.mAdTemplate, b.this.qo.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void b(x xVar) {
                super.b(xVar);
                long sU = xVar.sU();
                b.this.qo.oI.onVideoPlayError(xVar.errorCode, (int) sU);
                com.kwad.components.ad.reward.monitor.c.a(b.this.qo.oY, b.this.qo.mAdTemplate, b.this.qo.pv, xVar.errorCode, sU);
                com.kwad.components.ad.reward.monitor.b.c(b.this.qo.oY, b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                b.this.qo.oI.onVideoPlayEnd();
                b.this.qo.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.s(b.this.qo);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                b.this.qo.mAdTemplate.setmCurPlayTime(xVar.nE);
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        float screenHeight = com.kwad.sdk.d.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.d.a.a.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((screenHeight / aJ) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(final t tVar) {
        com.kwad.sdk.core.e.c.d("TKLivePresenter", "onSkipClick: " + tVar.VU);
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (b.this.qo != null && b.this.qo.oI != null) {
                    b.this.qo.oI.onVideoSkipToEnd(tVar.VU * 1000);
                }
                com.kwad.components.ad.reward.presenter.f.s(b.this.qo);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.wh = true;
        T(false);
    }
}
