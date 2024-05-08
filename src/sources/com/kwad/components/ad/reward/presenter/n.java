package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class n extends b {
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.hw();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.m gP = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.b.q qVar) {
            if (qVar == null || qVar.type != 1) {
                return;
            }
            n.this.qo.oJ.release();
            n.this.qo.fB();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (com.kwad.components.core.s.j.d(gVar.mAdTemplate, gVar.f36546pd)) {
            com.kwad.components.ad.reward.g gVar2 = this.qo;
            com.kwad.components.core.s.j.e(gVar2.mContext, gVar2.mAdTemplate);
        }
        if (!i.x(this.qo)) {
            com.kwad.components.ad.reward.g gVar3 = this.qo;
            if (!com.kwad.components.core.s.j.d(gVar3.mAdTemplate, gVar3.f36546pd)) {
                this.qo.fB();
                return;
            }
        }
        bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.qo.fB();
            }
        }, 200L);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.oJ.a(this.gO);
        com.kwad.components.ad.reward.c.fe().a(this.gP);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.gO);
        com.kwad.components.ad.reward.c.fe().b(this.gP);
    }
}
