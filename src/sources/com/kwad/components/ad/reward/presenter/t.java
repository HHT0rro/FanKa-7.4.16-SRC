package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class t extends b implements View.OnClickListener, com.kwad.components.ad.reward.e.o, com.kwad.sdk.core.g.b {
    private com.kwad.sdk.core.g.d eg;
    private Vibrator eh;
    private TextView hA;
    private ImageView hB;
    private FrameLayout hC;
    private ImageView hD;
    private FrameLayout hE;
    private TextView hF;

    @Nullable
    private Animator hG;
    private ViewGroup hy;
    private TextView hz;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.t.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (t.this.hy != null) {
                t.this.hy.setVisibility(8);
            }
            if (t.this.hE != null) {
                t.this.hE.setVisibility(8);
            }
            if (t.this.eg != null) {
                t.this.eg.bj(t.this.getContext());
            }
            if (t.this.hG != null) {
                t.this.hG.cancel();
                t.this.hG = null;
            }
        }
    };

    private void cg() {
        final int dimensionPixelSize;
        int dimensionPixelSize2;
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) com.kwad.sdk.n.l.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.hy = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.hy.getResources();
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginLeft);
        if (this.qo.mScreenOrientation == 1) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom) + com.kwad.sdk.d.a.a.a(getContext(), 50.0f);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom);
        }
        if (this.qo.mScreenOrientation == 1) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.d.a.a.a(getContext(), 50.0f);
        } else {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom);
        }
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) com.kwad.sdk.n.l.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.hE = frameLayout;
        this.hF = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.hE.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize3;
        layoutParams.bottomMargin = dimensionPixelSize2;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.hE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.hy, layoutParams2);
        com.kwad.sdk.core.adlog.c.b(this.qo.mAdTemplate, 185, (JSONObject) null);
        this.hy.post(new ay() { // from class: com.kwad.components.ad.reward.presenter.t.6
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                t tVar = t.this;
                tVar.hG = tVar.a(dimensionPixelSize3, height - dimensionPixelSize);
                if (t.this.hG != null) {
                    t.this.hG.start();
                }
            }
        });
    }

    private void initView() {
        this.hz = (TextView) this.hy.findViewById(R.id.ksad_shake_center_title);
        this.hA = (TextView) this.hy.findViewById(R.id.ksad_shake_center_sub_title);
        this.hB = (ImageView) this.hy.findViewById(R.id.ksad_shake_center_icon);
        this.hC = (FrameLayout) this.hy.findViewById(R.id.ksad_shake_center_circle_area);
        this.hD = (ImageView) this.hy.findViewById(R.id.ksad_shake_center_circle_area_bg);
        this.hz.setOnClickListener(this);
        this.hA.setOnClickListener(this);
        this.hC.setOnClickListener(this);
        this.hF.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void aV() {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        this.qo.a(this);
        this.qo.b(this.mPlayEndPageListener);
        cg();
        initView();
        a(dQ);
        float dJ = com.kwad.sdk.core.response.b.b.dJ(dQ);
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(dJ);
            this.eg = dVar2;
            dVar2.a(this);
        } else {
            dVar.e(dJ);
        }
        this.eg.bi(getContext());
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int cf() {
        return com.kwad.sdk.d.a.a.g(getContext(), R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.d.a.a.g(getContext(), R.dimen.ksad_reward_shake_tips_height);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.core.response.b.b.dH(com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate))) {
            this.qo.a(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.hy;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.hy.getParent()).removeView(this.hy);
            }
            this.hy = null;
        }
        bn.b(getContext(), this.eh);
        this.eh = null;
        Animator animator = this.hG;
        if (animator != null) {
            animator.cancel();
            this.hG = null;
        }
        this.qo.c(this.mPlayEndPageListener);
    }

    private void a(AdInfo adInfo) {
        String dL = com.kwad.sdk.core.response.b.b.dL(adInfo);
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(dL);
        }
        TextView textView2 = this.hF;
        if (textView2 != null) {
            textView2.setText(dL);
        }
        String a10 = a(this.qo, adInfo);
        TextView textView3 = this.hA;
        if (textView3 != null) {
            textView3.setText("或点击" + a10);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String dN = com.kwad.sdk.core.response.b.b.dN(adInfo);
        com.kwad.components.core.e.d.c cVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo) || cVar == null) {
            return dN;
        }
        int nW = cVar.nW();
        AdMatrixInfo.DownloadTexts dP = com.kwad.sdk.core.response.b.b.dP(adInfo);
        if (nW == 8) {
            return dP.installAppLabel;
        }
        if (nW != 12) {
            return dP.adActionDescription;
        }
        return dP.openAppLabel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(float f10, float f11) {
        if (this.hy == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.hy.getResources();
        Animator a10 = com.kwad.components.core.s.n.a((View) this.hB, (Interpolator) null, 100L, 16.0f);
        a10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.hB.setPivotX(t.this.hB.getWidth());
                t.this.hB.setPivotY(t.this.hB.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hy, Key.TRANSLATION_X, f10 - (this.hy.getLeft() + (this.hy.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hy, Key.TRANSLATION_Y, f11 - (this.hy.getTop() + (this.hy.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_reward_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_reward_shake_tips_icon_size);
        float width = this.hC.getWidth();
        float width2 = this.hB.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.hD) { // from class: com.kwad.components.ad.reward.presenter.t.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i10 = (int) floatValue;
                    layoutParams.height = i10;
                    layoutParams.width = i10;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.hB) { // from class: com.kwad.components.ad.reward.presenter.t.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i10 = (int) floatValue;
                    layoutParams.height = i10;
                    layoutParams.width = i10;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) t.this.hD.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    t.this.hD.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.hz.setAlpha(floatValue);
                    t.this.hA.setAlpha(floatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.hz.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.hz) { // from class: com.kwad.components.ad.reward.presenter.t.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.hA.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.hA) { // from class: com.kwad.components.ad.reward.presenter.t.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator clone = a10.clone();
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.2
            private boolean hI = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hI = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.hI) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.hB.setPivotX(dimension2);
                t.this.hB.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.hE.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_reward_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    t.this.hE.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.hE.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.hF, Key.ALPHA, 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a10, a10.clone(), a10.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d10) {
        com.kwad.sdk.core.c.b.DD();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z10 = activity != null && activity.equals(currentActivity);
        if (!com.kwad.components.core.e.c.b.nr() && z10) {
            com.kwad.components.ad.reward.g gVar = this.qo;
            if (gVar != null && !gVar.fM()) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.l(d10);
                this.qo.a(1, getContext(), 157, 1, 0L, false, bVar);
            }
            bn.a(new ay() { // from class: com.kwad.components.ad.reward.presenter.t.5
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.sdk.core.e.c.d("RewardShakePresenter", "onShakeEvent openGate2");
                    t.this.eg.Fu();
                }
            }, null, 500L);
            com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
            if (this.qo.fM()) {
                return;
            }
            bn.a(getContext(), this.eh);
            return;
        }
        bn.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.4
            @Override // java.lang.Runnable
            public final void run() {
                t.this.eg.Fu();
            }
        }, null, 500L);
    }
}
