package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private com.kwad.components.ad.k.b ci;

    /* renamed from: da, reason: collision with root package name */
    private FrameLayout f36579da;
    private DetailVideoView mDetailVideoView;
    private int tg = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (c.this.ci == null || !g.G(c.this.qo.mAdTemplate)) {
                return;
            }
            c.this.ci.ag(true);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.2
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            c.this.qo.oI.bJ();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        g gVar = this.qo;
        AdTemplate adTemplate = gVar.mAdTemplate;
        j jVar = gVar.oN;
        this.ci = jVar;
        if (jVar == null) {
            return;
        }
        com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
        this.ci.a(this.cR);
        com.kwad.components.ad.k.b bVar = this.ci;
        FrameLayout frameLayout = this.f36579da;
        g gVar2 = this.qo;
        bVar.a(frameLayout, gVar2.mRootContainer, adTemplate, gVar2.mApkDownloadHelper, gVar2.mScreenOrientation);
        this.ci.a((b.InterfaceC0424b) null);
        com.kwad.components.ad.k.b bVar2 = this.ci;
        if (bVar2 != null) {
            bVar2.a(this);
        }
    }

    @Override // com.kwad.components.ad.k.b.a
    public final void iA() {
        hp();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36579da = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i10;
        super.onUnbind();
        com.kwad.components.ad.k.b bVar = this.ci;
        if (bVar != null) {
            bVar.mj();
            this.ci.lW();
        }
        com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i10 = this.tg) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.d.a.a.n(detailVideoView, i10);
    }
}
