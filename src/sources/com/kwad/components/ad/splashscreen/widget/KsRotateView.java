package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class KsRotateView extends b {
    private static int FV = 50;
    private static int FW = -12;
    private static int FX = -25;
    private static int FY = 12;
    private static int FZ = 25;
    private ImageView FU;

    @DrawableRes
    private int Ga;
    private ImageView fq;

    public KsRotateView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i10, 0);
        this.Ga = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_rotate_phone);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.FU = imageView;
        imageView.setImageResource(R.drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.FU, layoutParams);
        this.fq = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.d.a.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.fq, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public View getInteractionView() {
        return this.fq;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void lR() {
        this.fq.setImageResource(this.Ga);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final Animator lS() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, FX).setDuration(500L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, FX, 0.0f).setDuration(FV);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, FY).setDuration(FV);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, FY, 0.0f).setDuration(FV);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, FW).setDuration(FV);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, FW, 0.0f).setDuration(FV);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, FZ).setDuration(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, Key.ROTATION, FZ, 0.0f).setDuration(FV), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, FW).setDuration(FV), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, FW, 0.0f).setDuration(FV), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, FY).setDuration(FV), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, FY, 0.0f).setDuration(FV));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void lT() {
        getInteractionView().setRotation(0.0f);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
