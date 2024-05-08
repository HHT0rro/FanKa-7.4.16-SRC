package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.k.a;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements a.b {

    /* renamed from: da, reason: collision with root package name */
    private FrameLayout f36578da;
    private l su;
    private volatile long vz = 0;
    private volatile boolean vA = false;
    private l sv = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.vA = false;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.vA = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.vz = j11;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.vA = false;
        }
    };
    private l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            a.this.vz = j11;
            a.this.vA = j10 - j11 < 800;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.4
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (a.this.qo.pp || a.this.qo.oO == null) {
                return;
            }
            a.this.qo.oO.ar();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            a.this.qo.oI.bJ();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vz = 0L;
        this.vA = false;
        com.kwad.components.ad.reward.g gVar = this.qo;
        AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.k.a aVar = gVar.oO;
        this.su = gVar.oJ.jM() ? this.sv : this.gO;
        if (aVar != null) {
            this.qo.pj = true;
            aVar.a(this);
            aVar.a(this.cR);
            aVar.a(this.f36578da, this.qo.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0422a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.3
                @Override // com.kwad.components.ad.k.a.InterfaceC0422a
                public final void R(boolean z10) {
                    a.this.qo.pj = z10;
                }
            });
            aVar.setActivity(this.qo.getActivity());
            aVar.ay();
            this.qo.b(this.mPlayEndPageListener);
            this.qo.oJ.a(this.su);
        }
    }

    @Override // com.kwad.components.ad.k.a.b
    public final void iv() {
        f.r(this.qo);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36578da = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.c(this.mPlayEndPageListener);
        this.qo.oJ.b(this.su);
    }
}
