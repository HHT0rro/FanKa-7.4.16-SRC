package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.i.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0466a, w.b {

    @Nullable
    private com.kwad.components.ad.reward.d oP;

    /* renamed from: sc, reason: collision with root package name */
    private ImageView f36611sc;

    /* renamed from: td, reason: collision with root package name */
    private View f36613td;
    private KsLogoView te;
    private DetailVideoView tf;
    private int tg;
    private View th;
    private FrameLayout ti;
    private Animator tj;
    private Animator tk;
    private Animator tl;
    private AdTemplate tm;
    private List<com.kwad.components.core.i.c> tn;
    private boolean tv;

    /* renamed from: tc, reason: collision with root package name */
    @RewardPreEndCardPresenter.PreEndPageStatus
    private int f36612tc = 1;
    private long to = 500;
    private long tp = 50;
    private float tq = 1.2254902f;
    private float tr = 0.80472106f;
    private float ts = 0.0f;
    private boolean tt = false;
    private long showTime = -1;
    private long tu = -1;
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            s.this.g(j11);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null && !com.kwad.sdk.core.response.b.e.c(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                com.kwad.components.core.i.c a10 = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.i.c>) s.this.tn, aVar.creativeId);
                if (a10 != null) {
                    s.this.qo.a(a10);
                    return;
                }
                return;
            }
            s.this.qo.oI.bJ();
        }
    };

    private boolean I(boolean z10) {
        int b4 = b(hH());
        N(b4);
        com.kwad.components.ad.reward.d dVar = this.oP;
        boolean ar2 = dVar != null ? dVar.ar() : false;
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + ar2);
        if (!ar2) {
            return false;
        }
        int a10 = a(hH());
        float f10 = -b4;
        this.ts = f10;
        Animator a11 = a(true, f10, a10, true, z10);
        this.tj = a11;
        a11.start();
        Animator hG = hG();
        this.tl = hG;
        hG.start();
        this.f36612tc = 2;
        return true;
    }

    private void J(boolean z10) {
        Animator a10 = a(false, (hH() - hI()) + this.ts, a(hI()), false, z10);
        this.tk = a10;
        a10.start();
        com.kwad.sdk.core.d.a.DF();
        com.kwad.sdk.core.d.a.bU(this.tm);
        this.f36612tc = 3;
        com.kwad.components.ad.reward.d dVar = this.oP;
        if (dVar != null) {
            dVar.fl();
        }
    }

    private void N(int i10) {
        ViewGroup.LayoutParams layoutParams = this.f36613td.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i10;
            layoutParams2.bottomMargin = -i10;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i10);
            layoutParams3.height = i10;
            layoutParams3.bottomMargin = -i10;
            this.f36613td.setLayoutParams(layoutParams3);
        }
    }

    private void f(List<AdTemplate> list) {
        com.kwad.components.ad.reward.d dVar = new com.kwad.components.ad.reward.d(list, this.qo.mReportExtData, this);
        this.oP = dVar;
        this.qo.oP = dVar;
        dVar.setShowLandingPage(com.kwad.sdk.core.response.b.b.ct(this.mAdTemplate));
        this.oP.a(this.cR);
        com.kwad.components.ad.reward.d dVar2 = this.oP;
        FrameLayout frameLayout = this.ti;
        com.kwad.components.ad.reward.g gVar = this.qo;
        dVar2.a(frameLayout, gVar.mRootContainer, this.mAdTemplate, gVar.mApkDownloadHelper, gVar.mScreenOrientation);
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.oP.a(new b.InterfaceC0424b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.k.b.InterfaceC0424b
            public final void hJ() {
                com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.qo.pp = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j10) {
        AdTemplate adTemplate = this.tm;
        if (adTemplate == null || this.tv) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cq(adTemplate);
            this.tu = com.kwad.sdk.core.response.b.b.cp(this.tm) + this.showTime;
        }
        long j11 = this.showTime;
        if (j11 > 0 && !this.tt && j10 > j11) {
            this.tv = !I(true);
            com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "showError: " + this.tv);
            if (this.tv) {
                return;
            } else {
                this.tt = true;
            }
        }
        boolean z10 = this.f36612tc == 3;
        long j12 = this.tu;
        if (j12 <= 0 || z10 || j10 <= j12) {
            return;
        }
        J(true);
    }

    private Animator hG() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.th, Key.ALPHA, 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private float hH() {
        return com.kwad.sdk.d.a.a.d(getActivity()) / this.tq;
    }

    private float hI() {
        return com.kwad.sdk.d.a.a.d(getActivity()) / this.tr;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.oJ.a(this.gO);
        this.qo.b((com.kwad.components.ad.reward.e.g) this);
        this.qo.a(this);
        this.tg = com.kwad.sdk.d.a.a.F(this.tf);
        com.kwad.sdk.d.a.a.n(this.tf, 49);
        this.te.aD(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        int i10;
        if (this.tm == null || (i10 = this.f36612tc) == 3) {
            return;
        }
        if (i10 == 1) {
            I(false);
            J(false);
        } else if (i10 == 2) {
            J(true);
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + ((Object) list));
        if (list == null || list.size() == 0) {
            return;
        }
        this.tm = list.get(0).getAdTemplate();
        this.tn = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.i.c.m(list));
        f(arrayList);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36613td = findViewById(R.id.ksad_middle_end_card);
        this.tf = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.te = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.f36611sc = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.th = findViewById(R.id.ksad_play_web_card_webView);
        this.ti = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void onError(int i10, String str) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void onRequestResult(int i10) {
        com.kwad.sdk.core.e.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i10);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.g gVar = this.qo;
        gVar.pp = false;
        gVar.oJ.b(this.gO);
        this.qo.c(this);
        this.qo.b((a.InterfaceC0466a) this);
        com.kwad.components.ad.reward.d dVar = this.oP;
        if (dVar != null) {
            dVar.lW();
        }
        Animator animator = this.tl;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.tf;
        if (detailVideoView != null) {
            com.kwad.sdk.d.a.a.n(detailVideoView, this.tg);
        }
        Animator animator2 = this.tj;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.tl = null;
        this.tj = null;
    }

    private int b(float f10) {
        return (int) (f10 + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private Animator a(boolean z10, float f10, int i10, boolean z11, boolean z12) {
        ValueAnimator ofFloat;
        com.kwad.sdk.core.e.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f10 + ", videoTargetHeight: " + i10);
        if (z10) {
            ofFloat = ObjectAnimator.ofFloat(this.f36613td, Key.TRANSLATION_Y, f10);
        } else {
            int height = this.f36613td.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.f36613td.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f10));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.f36613td.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator ofFloat2 = z11 ? ObjectAnimator.ofFloat(this.te, Key.ALPHA, 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.f36611sc.getLayoutParams();
        ValueAnimator a10 = this.tf.a(this.mAdTemplate, i10, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    s.this.f36611sc.setLayoutParams(layoutParams2);
                }
            }
        });
        long j10 = z12 ? this.to : this.tp;
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(create);
        if (ofFloat2 != null) {
            if (z12) {
                animatorSet.playTogether(ofFloat, ofFloat2, a10);
            } else {
                animatorSet.playTogether(ofFloat, ofFloat2);
            }
        } else if (z12) {
            animatorSet.playTogether(ofFloat, a10);
        } else {
            animatorSet.playTogether(ofFloat);
        }
        return animatorSet;
    }

    @Override // com.kwad.components.core.webview.jshandler.w.b
    public final void N(AdTemplate adTemplate) {
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    private int a(float f10) {
        return (int) (com.kwad.sdk.d.a.a.e(getActivity()) - f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
