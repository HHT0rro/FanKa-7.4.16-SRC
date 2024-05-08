package com.kwad.components.ad.fullscreen.c;

import com.kwad.components.ad.reward.e.m;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.tachikoma.b.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.qo.fB();
        }
    };
    private final m gP = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.2
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(q qVar) {
            if (qVar == null || qVar.type != 1) {
                return;
            }
            a.this.qo.oJ.release();
            a.this.qo.fB();
        }
    };

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
