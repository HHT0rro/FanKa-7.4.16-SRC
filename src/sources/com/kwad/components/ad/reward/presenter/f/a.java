package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.sdk.components.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a extends d {

    /* renamed from: wd, reason: collision with root package name */
    private o f36584wd;

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean iM() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.f36584wd = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            @Override // com.kwad.components.core.webview.tachikoma.a.o.a
            public final boolean isMuted() {
                return !a.this.qo.mVideoPlayConfig.isVideoSoundEnable() || (!com.kwad.sdk.core.config.d.gs() && com.kwad.components.core.s.a.ah(a.this.getContext()).qW());
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
    public void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        qVar.c(new v() { // from class: com.kwad.components.ad.reward.presenter.f.a.2
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                a.this.qo.oI.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(a.this.qo.oY, a.this.qo.mAdTemplate, a.this.qo.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void b(x xVar) {
                super.b(xVar);
                long sU = xVar.sU();
                a.this.qo.oI.onVideoPlayError(xVar.errorCode, (int) sU);
                com.kwad.components.ad.reward.monitor.c.a(a.this.qo.oY, a.this.qo.mAdTemplate, a.this.qo.pv, xVar.errorCode, sU);
                com.kwad.components.ad.reward.monitor.b.c(a.this.qo.oY, a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                a.this.qo.oI.onVideoPlayEnd();
                a.this.qo.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.s(a.this.qo);
                if (xVar.sS()) {
                    com.kwad.components.ad.reward.g unused = a.this.qo;
                    com.kwad.components.ad.reward.g.a(a.this.qo.oR, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.g.a
                        /* renamed from: c, reason: merged with bridge method [inline-methods] */
                        public void accept(com.kwad.components.ad.reward.k.a aVar) {
                            com.kwad.components.ad.reward.g unused2 = a.this.qo;
                            aVar.iK();
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                a.this.qo.mAdTemplate.setmCurPlayTime(xVar.nE);
            }
        });
    }
}
