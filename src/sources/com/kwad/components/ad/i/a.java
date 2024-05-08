package com.kwad.components.ad.i;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    private View Hh;
    private Runnable Hi;
    private boolean Hj = false;

    @Nullable
    private Animator hG;

    /* renamed from: ya, reason: collision with root package name */
    private View f36496ya;

    /* renamed from: yb, reason: collision with root package name */
    private Button f36497yb;

    /* renamed from: yc, reason: collision with root package name */
    private Button f36498yc;

    public a(View view) {
        this.Hh = view;
        initView();
    }

    private static Animator d(View view, long j10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.f36497yb = (Button) this.Hh.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.f36498yc = (Button) this.Hh.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.f36496ya = this.Hh.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void hT() {
        c.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.f36496ya.getHeight();
        int width = this.f36496ya.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.hG == null) {
            Animator a10 = a(this.f36498yc, this.f36497yb, width, height, 1600L, 200L);
            this.hG = a10;
            a10.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.i.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.Hj) {
                        return;
                    }
                    if (a.this.Hi == null) {
                        a.this.Hi = new Runnable() { // from class: com.kwad.components.ad.i.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bn.a(a.this.Hi, null, 1600L);
                }
            });
        }
        c.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.hG.isStarted());
        if (!this.hG.isStarted()) {
            c.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.hG.start();
        }
        this.Hj = false;
    }

    public final void jP() {
        mb();
    }

    public final void mb() {
        Animator animator = this.hG;
        if (animator != null) {
            animator.cancel();
            this.hG.removeAllListeners();
            this.Hj = true;
        }
        Runnable runnable = this.Hi;
        if (runnable != null) {
            bn.c(runnable);
            this.Hi = null;
        }
    }

    public final void mc() {
        this.Hj = true;
    }

    private static Animator a(final View view, View view2, int i10, int i11, long j10, long j11) {
        Animator d10 = d(view, 200L);
        float f10 = i10;
        float f11 = i11;
        Animator a10 = a(view2, f10, f11, 200L);
        a10.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.i.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View.this.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = View.this.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    View.this.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator d11 = d(view2, 200L);
        Animator a11 = a(view, f10, f11, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(d10, a10, ofFloat, d11, a11);
        return animatorSet;
    }

    private static Animator a(final View view, float f10, final float f11, long j10) {
        final float f12 = f10 / f11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f11);
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.i.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f13 = f12 * floatValue;
                float f14 = f11;
                if (f14 != 0.0f) {
                    float f15 = (floatValue / f14) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f15);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f13;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }
}
