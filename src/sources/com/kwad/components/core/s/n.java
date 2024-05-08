package com.kwad.components.core.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n {
    public static Animator a(View view, @Nullable Interpolator interpolator, long j10, float f10) {
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = interpolator == null ? PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f) : interpolator;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(300L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, f10).setDuration(j10);
        float f11 = -f10;
        long j11 = j10 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Key.ROTATION, f10, f11).setDuration(j11);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, Key.ROTATION, f11, f10).setDuration(j11);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, Key.ROTATION, f10, f11).setDuration(j11);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, Key.ROTATION, f11, 0.0f).setDuration(j10));
        return animatorSet;
    }

    public static ValueAnimator b(final View view, int i10, final int i11) {
        k(view, i10);
        ValueAnimator ofInt = ValueAnimator.ofInt(i10, i11);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.s.n.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                n.k(View.this, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.s.n.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                n.k(View.this, i11);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                n.k(View.this, i11);
            }
        });
        return ofInt;
    }

    public static ValueAnimator c(final View view, int i10, int i11) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(i10, i11);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.s.n.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View.this.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        return ofInt;
    }

    public static ValueAnimator h(final View view, final boolean z10) {
        float[] fArr = new float[2];
        fArr[0] = z10 ? 0.0f : 1.0f;
        fArr[1] = z10 ? 1.0f : 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.45f, 0.0f, 0.6f, 1.0f));
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.s.n.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.s.n.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z10) {
                    return;
                }
                view.setAlpha(0.0f);
                view.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z10) {
                    view.setAlpha(0.0f);
                    view.setVisibility(0);
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public static Animator a(View view, @Nullable Interpolator interpolator, float f10, float f11) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, f10, f11);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(create);
        return ofFloat;
    }
}
