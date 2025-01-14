package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends FrameLayout {
    private int count;
    private ImageView fg;
    private ImageView fh;
    private ImageView fi;
    private Animator fj;
    private Animator fk;
    private Animation fl;
    private Animation fm;

    public d(@NonNull Context context) {
        this(context, null);
    }

    private void B(Context context) {
        com.kwad.sdk.n.l.inflate(context, R.layout.ksad_promote_ad_click, this);
        this.fg = (ImageView) findViewById(R.id.ksad_inside_circle);
        this.fh = (ImageView) findViewById(R.id.ksad_outside_circle);
        this.fi = (ImageView) findViewById(R.id.ksad_hand);
    }

    private void bp() {
        this.fj = d(this.fi);
        this.fk = e(this.fi);
        this.fl = a(this.fg, 0.45f, com.kwad.sdk.d.a.a.a(getContext(), 34.0f));
        this.fm = a(this.fh, 0.5f, com.kwad.sdk.d.a.a.a(getContext(), 50.0f));
        this.fj.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.fg.startAnimation(d.this.fl);
                d.this.fh.startAnimation(d.this.fm);
                d.this.fk.start();
            }
        });
        this.fk.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.fj.start();
            }
        });
    }

    public static /* synthetic */ int f(d dVar) {
        int i10 = dVar.count;
        dVar.count = i10 + 1;
        return i10;
    }

    public final void bn() {
        bp();
        this.fj.start();
    }

    public final void bo() {
        Animator animator = this.fj;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.fk;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.fl;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.fm;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animation a(final View view, float f10, int i10) {
        float a10 = com.kwad.sdk.d.a.a.a(getContext(), 10.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f10, 0.0f);
        float f11 = i10 / a10;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f11, 1.0f, f11, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.b.d.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return animationSet;
    }

    private Animator d(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, -10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, Key.TRANSLATION_X, 0.0f, -com.kwad.sdk.d.a.a.a(getContext(), 9.5f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, 0.0f, -com.kwad.sdk.d.a.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private Animator e(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, -10.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, Key.TRANSLATION_X, -com.kwad.sdk.d.a.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, -com.kwad.sdk.d.a.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        this.count = 0;
        B(context);
    }
}
