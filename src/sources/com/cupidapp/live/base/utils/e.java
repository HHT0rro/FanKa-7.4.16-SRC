package com.cupidapp.live.base.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancelableAlphaAnimation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f12311a = new e();

    /* compiled from: CancelableAlphaAnimation.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f12312b;

        public a(View view) {
            this.f12312b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            this.f12312b.setVisibility(4);
        }
    }

    public static /* synthetic */ void c(e eVar, View view, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 4;
        }
        eVar.b(view, i10);
    }

    public final void a(@NotNull View view, long j10, long j11) {
        kotlin.jvm.internal.s.i(view, "view");
        view.clearAnimation();
        view.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(j11);
        ofFloat.setStartDelay(j10);
        ofFloat.addListener(new a(view));
        ofFloat.start();
    }

    public final void b(@Nullable View view, int i10) {
        if (view != null) {
            view.clearAnimation();
        }
        if (view == null) {
            return;
        }
        view.setVisibility(i10);
    }
}
