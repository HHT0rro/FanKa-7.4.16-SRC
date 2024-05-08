package com.kwad.components.ad.splashscreen.c;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j extends e {
    /* JADX INFO: Access modifiers changed from: private */
    public void bQ() {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bc(dQ)) {
            a(new d(), true);
            a(new q(), true);
        } else {
            a(new h(), true);
        }
        if (this.Dg.Cy) {
            a(new p(), true);
        } else {
            boolean du = com.kwad.sdk.core.response.b.b.du(dQ);
            boolean dy = com.kwad.sdk.core.response.b.b.dy(dQ);
            boolean dD = com.kwad.sdk.core.response.b.b.dD(dQ);
            if (com.kwad.sdk.core.response.b.b.dA(dQ)) {
                a(new n(), true);
            } else if (du) {
                a(new m(), true);
            } else if (dy) {
                a(new l(), true);
            } else if (dD) {
                a(new p(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aP(dQ)) {
            a(new f(), true);
        }
        if (!this.Dg.Cz) {
            a(new com.kwad.components.ad.splashscreen.c.b.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.c.j.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                j.this.bQ();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }
}
