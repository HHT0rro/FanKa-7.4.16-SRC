package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.n.h;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {

    @Nullable
    private ValueAnimator cV;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private RewardActionBarControl oM;
    private KsLogoView sr;

    @Nullable
    private ViewGroup uA;

    @Nullable
    private ViewGroup uB;
    private h uC;
    private boolean uD;
    private ActionBarAppLandscape uu;
    private ActionBarAppPortrait uv;
    private ActionBarH5 uw;
    private boolean uy;

    @Nullable
    private ViewGroup uz;
    private boolean ux = false;
    private final l sv = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.uD = true;
            if (!com.kwad.sdk.core.response.b.a.cL(b.this.mAdInfo) || b.this.uB == null) {
                return;
            }
            b.this.uB.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.uD = false;
            if (!com.kwad.sdk.core.response.b.a.cL(b.this.mAdInfo) || b.this.uB == null) {
                return;
            }
            b.this.uB.setVisibility(0);
        }
    };
    private RewardActionBarControl.b uE = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z10, a aVar) {
            b.this.uy = true;
            b.this.a(z10, aVar);
        }
    };
    private g uF = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            b.this.uy = false;
            b.this.L(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z10) {
        if (this.ux) {
            this.ux = false;
            this.sr.setVisibility(8);
            ViewGroup viewGroup = this.uz;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.uB;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                if (z10) {
                    g(this.uw, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
                    return;
                } else {
                    this.uw.setVisibility(8);
                    return;
                }
            }
            if (this.qo.mScreenOrientation == 1) {
                if (z10) {
                    hW();
                    return;
                } else {
                    hX();
                    return;
                }
            }
            if (z10) {
                ActionBarAppPortrait actionBarAppPortrait = this.uv;
                if (actionBarAppPortrait != null) {
                    g(actionBarAppPortrait, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
                    return;
                }
                return;
            }
            ActionBarAppPortrait actionBarAppPortrait2 = this.uv;
            if (actionBarAppPortrait2 != null) {
                actionBarAppPortrait2.setVisibility(8);
            }
        }
    }

    private void aG() {
        ValueAnimator valueAnimator = this.cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cV.cancel();
        }
    }

    private void ca() {
        if (com.kwad.sdk.core.response.b.a.cF(this.mAdInfo)) {
            this.uz = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.sr.aD(this.mAdTemplate);
        com.kwad.components.ad.reward.g gVar = this.qo;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = gVar.oM;
        this.oM = rewardActionBarControl;
        rewardActionBarControl.a(this.uE);
        this.qo.b(this.uF);
    }

    private void hU() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        if (viewStub != null) {
            this.uu = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.uu = (ActionBarAppLandscape) findViewById(R.id.ksad_video_play_bar_app_landscape);
        }
    }

    private void hV() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        if (viewStub != null) {
            this.uv = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.uv = (ActionBarAppPortrait) findViewById(R.id.ksad_video_play_bar_app_portrait);
        }
    }

    private void hW() {
        hV();
        f(this.uv, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
    }

    private void hX() {
        ActionBarAppPortrait actionBarAppPortrait = this.uv;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    public final void M(boolean z10) {
        com.kwad.sdk.core.adlog.c.b cK = new com.kwad.sdk.core.adlog.c.b().f(this.qo.mRootContainer.getTouchCoords()).cK(z10 ? 1 : 153);
        com.kwad.components.ad.reward.g gVar = this.qo;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", (String) null, cK, gVar.mReportExtData);
        this.qo.oI.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.qo.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.qo.oJ.a(this.sv);
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sr = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.uw = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.oM;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.qo.oJ.b(this.sv);
        this.qo.c(this.uF);
        aG();
    }

    private void d(boolean z10, a aVar) {
        this.uw.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void N(boolean z11) {
                b.this.M(z11);
            }
        });
        if (z10) {
            f(this.uw, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
        } else {
            this.uw.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uw, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void e(final View view, int i10) {
        aG();
        view.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator c4 = n.c(view, i10, 0);
        this.cV = c4;
        c4.setInterpolator(create);
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.cV.start();
    }

    @Deprecated
    private void f(final View view, int i10) {
        aG();
        view.setVisibility(0);
        ValueAnimator b4 = n.b(view, 0, i10);
        this.cV = b4;
        b4.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.cV.start();
    }

    private void g(final View view, int i10) {
        aG();
        view.setVisibility(0);
        ValueAnimator b4 = n.b(view, i10, 0);
        this.cV = b4;
        b4.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(300L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.cV.start();
    }

    private void b(boolean z10, a aVar) {
        hU();
        this.uu.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void N(boolean z11) {
                b.this.M(z11);
            }
        });
        if (z10) {
            f(this.uu, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
        } else {
            this.uu.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uu, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z10, a aVar) {
        hV();
        this.uv.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void N(boolean z11) {
                b.this.M(z11);
            }
        });
        if (z10) {
            f(this.uv, com.kwad.sdk.d.a.a.a(getContext(), 90.0f));
        } else {
            this.uv.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.uv, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, a aVar) {
        ViewGroup viewGroup;
        if (this.ux) {
            return;
        }
        this.ux = true;
        this.sr.setVisibility(com.kwad.sdk.core.response.b.a.cL(this.mAdInfo) ? 8 : 0);
        getContext();
        final boolean z11 = !ai.LZ();
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            if (this.uC == null) {
                h hVar = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                    @Override // com.kwad.components.ad.reward.n.h
                    public final int hY() {
                        if (z11) {
                            return R.id.ksad_common_app_card_land_stub;
                        }
                        return super.hY();
                    }
                };
                this.uC = hVar;
                hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void hZ() {
                        b.this.qo.a(1, b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ia() {
                        b.this.qo.a(1, b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ib() {
                        b.this.qo.a(1, b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ic() {
                        b.this.qo.a(1, b.this.getContext(), 32, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void id() {
                        b.this.qo.a(1, b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ie() {
                        b.this.qo.a(1, b.this.getContext(), 53, 2);
                    }
                });
                this.uC.f((ViewGroup) getRootView());
                this.uC.b(r.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.uC.show();
            RewardActionBarControl.a(aVar, this.uC.gF(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.bZ(this.mAdInfo) == 1 && (viewGroup = this.uz) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.a(aVar, this.uz, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cL(this.mAdInfo)) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_origin_live_root);
            this.uB = viewGroup2;
            if (viewGroup2 != null) {
                if (!this.uD) {
                    viewGroup2.setVisibility(0);
                }
                RewardActionBarControl.a(aVar, this.uB, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.cb(this.mAdTemplate)) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.ksad_reward_live_subscribe_root);
            this.uA = viewGroup3;
            if (viewGroup3 != null) {
                Resources resources = viewGroup3.getResources();
                e(this.uA, (int) (resources.getDimension(R.dimen.ksad_live_subscribe_card_full_height) + resources.getDimension(R.dimen.ksad_live_subscribe_card_margin)));
                RewardActionBarControl.a(aVar, this.uA, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            if (this.qo.mScreenOrientation == 1) {
                b(z10, aVar);
                return;
            } else {
                c(z10, aVar);
                return;
            }
        }
        d(z10, aVar);
    }
}
