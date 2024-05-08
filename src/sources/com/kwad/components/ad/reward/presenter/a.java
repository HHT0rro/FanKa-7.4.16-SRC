package com.kwad.components.ad.reward.presenter;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends b {
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.qo.pm = j11;
        }
    };
    private DetailVideoView mDetailVideoView;

    public a(com.kwad.components.ad.reward.g gVar) {
        this.qo = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    private boolean hi() {
        return com.kwad.sdk.core.response.b.e.i(this.mAdTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate)));
    }

    private boolean hj() {
        return com.kwad.sdk.core.response.b.e.F(this.mAdTemplate);
    }

    private void l(com.kwad.components.ad.reward.g gVar) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        com.kwad.components.ad.reward.m.e eVar = gVar.oJ;
        if (com.kwad.sdk.core.response.b.a.bd(dQ)) {
            com.kwad.components.ad.reward.m.b bVar = new com.kwad.components.ad.reward.m.b(this.mAdTemplate);
            eVar.a(3, bVar);
            gVar.a(bVar);
        } else {
            com.kwad.components.ad.reward.m.d dVar = new com.kwad.components.ad.reward.m.d(gVar, this.mDetailVideoView);
            eVar.a(1, dVar);
            gVar.a(dVar);
        }
        eVar.a(this.gO);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getContext();
        boolean z10 = !ai.LZ();
        if ((hi() || hj()) && z10) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.g(true, com.kwad.sdk.core.config.d.CC());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_native_container_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        l(this.qo);
        if (RewardRenderResult.DEFAULT.equals(this.qo.fJ())) {
            com.kwad.components.ad.reward.g.a(getContext(), this.qo, (FrameLayout) findViewById(R.id.ksad_reward_play_layout));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.ad.reward.m.e eVar = this.qo.oJ;
        if (eVar != null) {
            eVar.b(this.gO);
        }
    }
}
