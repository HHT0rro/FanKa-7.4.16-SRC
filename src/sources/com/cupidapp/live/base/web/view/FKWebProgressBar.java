package com.cupidapp.live.base.web.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKWebProgressBar.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKWebProgressBar extends BaseHorizontalProgressBar {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ValueAnimator f13107d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13108e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13109f = new LinkedHashMap();

    /* compiled from: FKWebProgressBar.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f13110b;

        public a(Function0<p> function0) {
            this.f13110b = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            s.i(animation, "animation");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            Function0<p> function0 = this.f13110b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public FKWebProgressBar(@Nullable Context context) {
        super(context);
    }

    public static /* synthetic */ void f(FKWebProgressBar fKWebProgressBar, int i10, int i11, long j10, Function0 function0, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            function0 = null;
        }
        fKWebProgressBar.e(i10, i11, j10, function0);
    }

    public static final void g(FKWebProgressBar this$0, ValueAnimator animation) {
        s.i(this$0, "this$0");
        s.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.setProgress(((Integer) animatedValue).intValue());
    }

    public final void d() {
        ValueAnimator valueAnimator = this.f13107d;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.f13107d;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.f13108e = false;
        setProgress(0);
    }

    public final void e(int i10, int i11, long j10, Function0<p> function0) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i10, i11);
        ofInt.setDuration(j10);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.base.web.view.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FKWebProgressBar.g(FKWebProgressBar.this, valueAnimator);
            }
        });
        ofInt.addListener(new a(function0));
        this.f13107d = ofInt;
        ofInt.start();
    }

    public final void h() {
        final int max = (getMax() * 60) / 100;
        final int max2 = (getMax() * 85) / 100;
        final int max3 = (getMax() * 95) / 100;
        e(0, max, HwCubicBezierInterpolator.f34870a, new Function0<p>() { // from class: com.cupidapp.live.base.web.view.FKWebProgressBar$startLoad$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final FKWebProgressBar fKWebProgressBar = FKWebProgressBar.this;
                int i10 = max;
                final int i11 = max2;
                final int i12 = max3;
                fKWebProgressBar.e(i10, i11, 5500L, new Function0<p>() { // from class: com.cupidapp.live.base.web.view.FKWebProgressBar$startLoad$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ p invoke() {
                        invoke2();
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FKWebProgressBar.f(FKWebProgressBar.this, i11, i12, 10000L, null, 8, null);
                    }
                });
            }
        });
    }

    public final void i(int i10, @Nullable Function0<p> function0) {
        if (i10 >= 0 && i10 < 100) {
            if (this.f13108e) {
                return;
            }
            h();
            this.f13108e = true;
            return;
        }
        if (i10 == 100) {
            NetworkStateConstants g3 = h.g(getContext());
            if (g3 == NetworkStateConstants.WIFI || g3 == NetworkStateConstants.MOBILE) {
                this.f13108e = false;
                ValueAnimator valueAnimator = this.f13107d;
                if (valueAnimator != null) {
                    valueAnimator.removeAllListeners();
                }
                ValueAnimator valueAnimator2 = this.f13107d;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                e(getProgress(), getMax(), 300L, function0);
            }
        }
    }

    public FKWebProgressBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FKWebProgressBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
