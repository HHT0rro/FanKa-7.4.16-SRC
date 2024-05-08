package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HandSlideView extends KSFrameLayout {
    private View Aa;
    private AnimatorSet Ab;
    private float Ac;
    private float Ad;
    private float Ae;
    private long Af;
    private long Ag;
    private int Ah;
    private int Ai;
    private ImageView fi;
    private boolean started;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void onHandSlideLoopEnd();
    }

    public HandSlideView(@NonNull Context context) {
        super(context);
        this.Af = 600L;
        this.Ag = 500L;
        this.Ah = 3;
        this.Ai = 0;
        this.started = false;
    }

    public static /* synthetic */ int b(HandSlideView handSlideView) {
        int i10 = handSlideView.Ai;
        handSlideView.Ai = i10 + 1;
        return i10;
    }

    private static ValueAnimator.AnimatorUpdateListener s(final View view) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = View.this.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    View.this.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public final void destroy() {
        this.started = false;
        AnimatorSet animatorSet = this.Ab;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.Ab.cancel();
            this.Ab = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        FrameLayout.inflate(getContext(), R.layout.ksad_hand_slide, this);
        this.fi = (ImageView) findViewById(R.id.ksad_hand_slide_hand);
        this.Aa = findViewById(R.id.ksad_hand_slide_tail);
        this.Ac = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_up);
        this.Ad = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_start);
        this.Ae = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_end);
    }

    public final boolean isStarted() {
        return this.started;
    }

    private AnimatorSet b(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, 0.0f, -this.Ac);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, 30.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, Key.ALPHA, 0.0f, 1.0f);
        ofFloat3.setDuration(10L);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(this.Ad, this.Ae);
        ofFloat4.addUpdateListener(s(view2));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.Af);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, Key.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f));
        animatorSet2.setDuration(this.Ag);
        animatorSet2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        return animatorSet3;
    }

    public final void a(@Nullable final a aVar) {
        this.started = true;
        AnimatorSet b4 = b(this.fi, this.Aa);
        this.Ab = b4;
        b4.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (HandSlideView.this.Ab == null) {
                    return;
                }
                HandSlideView.b(HandSlideView.this);
                if (HandSlideView.this.Ai < HandSlideView.this.Ah) {
                    HandSlideView.this.Ab.start();
                    return;
                }
                HandSlideView.this.Ab.removeListener(this);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onHandSlideLoopEnd();
                }
            }
        });
        this.Ab.start();
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Af = 600L;
        this.Ag = 500L;
        this.Ah = 3;
        this.Ai = 0;
        this.started = false;
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Af = 600L;
        this.Ag = 500L;
        this.Ah = 3;
        this.Ai = 0;
        this.started = false;
    }
}
