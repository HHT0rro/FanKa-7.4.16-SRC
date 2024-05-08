package com.alibaba.security.biometrics.build;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* compiled from: AnimationUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ad {

    /* compiled from: AnimationUtils.java */
    /* renamed from: com.alibaba.security.biometrics.build.ad$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2214a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f2215b = null;

        public AnonymousClass1(View view) {
            this.f2214a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            this.f2214a.setVisibility(0);
            this.f2214a.setAlpha(1.0f);
            this.f2214a.clearAnimation();
            Animation.AnimationListener animationListener = this.f2215b;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            this.f2214a.setVisibility(0);
        }
    }

    private static void a(View view, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(animationListener);
        view.startAnimation(alphaAnimation);
    }

    private static void a(View view) {
        try {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(view);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setAnimationListener(anonymousClass1);
            view.startAnimation(alphaAnimation);
        } catch (Throwable unused) {
        }
    }
}
