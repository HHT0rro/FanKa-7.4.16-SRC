package com.kwad.components.ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {

    /* renamed from: uc, reason: collision with root package name */
    private View f36605uc;

    /* renamed from: ud, reason: collision with root package name */
    private View f36606ud;
    private View ue;
    private View uf;
    private Animator ui;
    private Animator uj;
    private Animator uk;
    private bd un;
    private bd uo;
    private final long tZ = 1600;

    /* renamed from: ua, reason: collision with root package name */
    private final long f36603ua = com.huawei.openalliance.ad.ipc.c.Code;

    /* renamed from: ub, reason: collision with root package name */
    private final long f36604ub = 5000;
    private boolean ug = false;
    private boolean uh = false;
    private Animator ul = null;
    private long um = com.huawei.openalliance.ad.ipc.c.Code;
    private Interpolator up = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
    private l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        private boolean uq = false;

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.ug = true;
            com.kwad.sdk.core.e.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            if (j11 < b.this.um || this.uq) {
                return;
            }
            this.uq = true;
            b.this.hT();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.ug = false;
            com.kwad.sdk.core.e.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.ug = false;
            com.kwad.sdk.core.e.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.ul == null || b.this.ul.isRunning()) {
                return;
            }
            b.this.ul.start();
            b.a(b.this, (Animator) null);
        }
    };

    public static /* synthetic */ View b(b bVar, View view) {
        bVar.f36606ud = null;
        return null;
    }

    private void hR() {
        this.un = new bd(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_start));
        this.uo = new bd(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    private View hS() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT() {
        this.ui = a(this.f36605uc, 1600L);
        this.uj = a(this.ue, this.uf);
        this.uk = b(this.f36605uc, 1600L);
        this.ui.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.p(b.this.f36606ud);
                b.b(b.this, (View) null);
                if (b.this.uh) {
                    return;
                }
                b bVar = b.this;
                bVar.a(bVar.uj);
            }
        });
        this.uj.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.uk);
                b.p(b.this.ue);
                b.p(b.this.uf);
                b.c(b.this, null);
                b.d(b.this, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }
        });
        this.uk.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.uk);
            }
        });
        a(this.ui);
    }

    private Animator o(View view) {
        if (this.un == null || this.uo == null) {
            hR();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, -(com.kwad.sdk.d.a.a.getScreenHeight(getContext()) + ((this.uo.getHeight() + this.un.getHeight()) / 2)));
        float MG = this.uo.MG() / this.un.MG();
        float MH = this.uo.MH() / this.un.MH();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, MG);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, MH);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, Key.ALPHA, 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(com.huawei.openalliance.ad.ipc.c.Code);
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat, ofFloat4);
        animatorSet.setInterpolator(this.up);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.oJ.a(this.gO);
        FrameLayout O = this.qo.oJ.jO().O(getContext());
        this.f36605uc = O;
        if (O.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.ksad_reward_play_layout)).addView(this.f36605uc, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.un.getHeight();
        ViewGroup viewGroup = (FrameLayout) findViewById(R.id.ksad_root_container);
        View hS = hS();
        this.f36606ud = hS;
        viewGroup.addView(hS, -1, -1);
        View a10 = a(R.drawable.ksad_image_player_sweep1, viewGroup);
        this.ue = a10;
        viewGroup.addView(a10, layoutParams);
        View a11 = a(R.drawable.ksad_image_player_sweep2, viewGroup);
        this.uf = a11;
        viewGroup.addView(a11, layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        hR();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.f36605uc = null;
        com.kwad.components.ad.reward.m.b jO = this.qo.oJ.jO();
        if (jO != null) {
            jO.release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.ug = true;
        Animator animator = this.uj;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.ui;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.uk;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.qo.oJ.b(this.gO);
    }

    public static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.ul = null;
        return null;
    }

    public static /* synthetic */ View c(b bVar, View view) {
        bVar.ue = null;
        return null;
    }

    public static /* synthetic */ View d(b bVar, View view) {
        bVar.uf = null;
        return null;
    }

    public static /* synthetic */ boolean b(b bVar, boolean z10) {
        bVar.uh = true;
        return true;
    }

    private View a(@DrawableRes int i10, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i10));
        return imageView;
    }

    private Animator b(View view, long j10) {
        Animator a10 = a(view, 1600L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.ALPHA, 1.0f);
        ofFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a10, ofFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Animator animator) {
        if (!this.ug) {
            animator.start();
        } else {
            this.ul = animator;
        }
    }

    private Animator a(View view, View view2) {
        Animator o10 = o(view);
        Animator o11 = o(view2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        ofFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, o11);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(o10, animatorSet);
        return animatorSet2;
    }

    private Animator a(View view, long j10) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.f36606ud;
        if (view2 != null) {
            animatorSet.playTogether(ofFloat, ofFloat2, ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(this.up);
        return animatorSet;
    }
}
