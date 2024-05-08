package com.cupidapp.live.base.view.progress;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.progress.ProgressBarDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ProgressBarDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ProgressBarDialog extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12888b;

    /* compiled from: ProgressBarDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f12889b;

        public a(Function0<p> function0) {
            this.f12889b = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            Function0<p> function0 = this.f12889b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarDialog(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12888b = new LinkedHashMap();
        e();
    }

    public static final void d(boolean z10, ProgressBarDialog this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        if (z10) {
            Object animatedValue = it.getAnimatedValue();
            s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            this$0.setProgress(((Integer) animatedValue).intValue());
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f12888b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void c(final boolean z10, @Nullable Function0<p> function0) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: t1.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressBarDialog.d(z10, this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, 100);
        ofInt2.setStartDelay(300L);
        ofInt2.setDuration(80L);
        ofInt2.addListener(new a(function0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofInt).before(ofInt2);
        animatorSet.start();
    }

    public final void e() {
        z.a(this, R$layout.layout_progress_bar_dialog, true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        return true;
    }

    public final void setProgress(int i10) {
        ((TextView) b(R$id.progressTextView)).setText(getContext().getString(R$string.progress_percentage, Integer.valueOf(i10), "%"));
    }

    public final void setProgress(@NotNull String progressStr) {
        s.i(progressStr, "progressStr");
        ((TextView) b(R$id.progressTextView)).setText(progressStr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarDialog(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12888b = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarDialog(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12888b = new LinkedHashMap();
        e();
    }
}
