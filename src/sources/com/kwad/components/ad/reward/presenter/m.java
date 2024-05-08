package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m extends b {
    private long hj;

    @NonNull
    private com.kwad.components.ad.reward.e.b oI;
    private com.kwad.components.core.video.l su;
    private com.kwad.components.core.video.l sv = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qo;
            if (gVar.oY && gVar.f36546pd) {
                mVar.oI.onVideoSkipToEnd(m.this.hj);
            } else {
                gVar.pw = true;
                mVar.oI.onVideoPlayEnd();
            }
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(m.this.qo.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(dQ) && com.kwad.sdk.core.response.b.a.aN(dQ) == 1) {
                return;
            }
            f.s(m.this.qo);
            com.kwad.components.ad.reward.g gVar2 = m.this.qo;
            if (gVar2.pw) {
                com.kwad.components.ad.reward.k.h(gVar2);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qo;
            gVar.pv = j11;
            if (gVar.f36546pd) {
                return;
            }
            mVar.hj = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.oI.onVideoPlayStart();
            m.this.qo.pw = false;
        }
    };
    private final com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.qo.f36546pd) {
                mVar.oI.onVideoSkipToEnd(m.this.hj);
            } else {
                mVar.oI.onVideoPlayEnd();
            }
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(m.this.qo.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(dQ) && com.kwad.sdk.core.response.b.a.aN(dQ) == 1) {
                return;
            }
            f.s(m.this.qo);
            com.kwad.components.ad.reward.g gVar = m.this.qo;
            if (gVar.pw) {
                com.kwad.components.ad.reward.k.h(gVar);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            m.this.oI.onVideoPlayError(i10, i11);
            m.this.hp();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qo;
            gVar.pv = j11;
            gVar.pw = j10 - j11 < 800;
            if (gVar.f36546pd) {
                return;
            }
            mVar.hj = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            m.this.oI.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qo;
        gVar.pv = 0L;
        gVar.pw = false;
        this.oI = gVar.oI;
        if (gVar.oJ.jM()) {
            this.su = this.sv;
        } else {
            this.su = this.gO;
        }
        this.qo.oJ.a(this.su);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.su);
    }
}
