package com.kwad.components.ad.reward.presenter.d.a;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements aq.b {

    @Nullable
    private com.kwad.components.ad.k.b ci;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;
    private TailFrameView vC;
    private volatile boolean vD;
    private boolean vE;
    private k vF;
    private Drawable vI;
    private boolean sR = false;
    private int vG = Integer.MIN_VALUE;
    private int vH = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.iw();
            if (b.this.vC == null || !g.G(b.this.mAdTemplate)) {
                return;
            }
            b.this.vC.jQ();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if ((!e.ed(b.this.mAdTemplate) && b.this.sR && !b.this.qo.fH()) || b.this.qo.pj || b.this.qo.pp) {
                return;
            }
            b.this.vE = true;
            if (b.this.ci != null && b.this.ci.ar()) {
                b.this.vE = false;
            }
            b.this.qo.pA = true ^ b.this.vE;
            if (b.this.vE) {
                if (b.this.qo.oN != null) {
                    com.kwad.components.ad.reward.monitor.c.a(b.this.qo.mAdTemplate, b.this.qo.oY, "end_card", com.kwad.sdk.core.response.b.b.cy(b.this.mAdTemplate), System.currentTimeMillis() - b.this.qo.oN.getLoadTime(), 1);
                }
                b.this.aI();
            }
        }

        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z10) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.qo.mRootContainer.getTouchCoords()).cK(z10 ? 2 : 153), this.qo.mReportExtData);
        this.qo.oI.bJ();
    }

    private void P(int i10) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i10;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        iw();
        this.vC.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void N(boolean z10) {
                b.this.K(z10);
            }
        });
        this.vC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iw() {
        if (this.vD) {
            return;
        }
        ix();
    }

    private void ix() {
        com.kwad.sdk.core.e.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.vC.a(getContext(), this.qo.mScreenOrientation == 0, iz());
        this.vD = true;
    }

    private void iy() {
        if (this.vE) {
            iw();
            this.vC.destroy();
            this.vC.setVisibility(8);
            this.vF.hide();
        }
    }

    private boolean iz() {
        AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
        return aX.height > aX.width;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.core.playable.a aVar = this.qo.oL;
        if (aVar != null) {
            aVar.a(this);
        }
        this.mAdInfo = e.dQ(this.mAdTemplate);
        g gVar = this.qo;
        this.ci = gVar.oN;
        gVar.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
        this.vC.setCallerContext(this.qo);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.vF = new k(this.qo, viewStub);
        } else {
            this.vF = new k(this.qo, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vC = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.qo.oL;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
        iy();
        this.qo.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i10 = this.vH;
            if (i10 != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i10);
            }
            com.kwad.sdk.core.e.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.vG);
            int i11 = this.vG;
            if (i11 != Integer.MIN_VALUE) {
                P(i11);
            }
            Drawable drawable = this.vI;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        this.sR = aVar.isSuccess();
    }
}
