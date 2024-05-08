package com.cupidapp.live.login.helper;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKCountTimerWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f16153a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Animator f16154b;

    public b(int i10) {
        this.f16153a = i10;
    }

    public static final void c(Function1 function1, b this$0, Function0 function0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this$0.f16153a - intValue));
        }
        if (this$0.f16153a != intValue || function0 == null) {
            return;
        }
        function0.invoke();
    }

    public final void b(@Nullable final Function1<? super Integer, p> function1, @Nullable final Function0<p> function0) {
        Animator animator = this.f16154b;
        if (animator != null) {
            animator.cancel();
        }
        ValueAnimator ofInt = ObjectAnimator.ofInt(this.f16153a);
        ofInt.setDuration(this.f16153a * 1000);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.login.helper.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.c(Function1.this, this, function0, valueAnimator);
            }
        });
        this.f16154b = ofInt;
        ofInt.start();
    }

    public final void d() {
        Animator animator = this.f16154b;
        if (animator != null) {
            animator.cancel();
        }
    }
}
