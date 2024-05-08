package com.cupidapp.live.mediapicker.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CustomAnimationLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class CustomAnimationLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17386b;

    /* compiled from: CustomAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            CustomAnimationLayout.this.setVisibility(8);
        }
    }

    /* compiled from: CustomAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            CustomAnimationLayout.this.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAnimationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17386b = new LinkedHashMap();
    }

    private final float getTargetY() {
        measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        return (z0.s.f54824a.a() - getMeasuredHeight()) - z0.h.f(getContext());
    }

    public void a() {
    }

    public final void b(@NotNull Property<View, Float> property) {
        float f10;
        s.i(property, "property");
        float f11 = 0.0f;
        if (s.d(property, View.ALPHA)) {
            f10 = 0.0f;
            f11 = 1.0f;
        } else if (s.d(property, View.Y)) {
            f11 = getTargetY();
            f10 = z0.s.f54824a.a();
        } else {
            f10 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<CustomAnimationLayout, Float>) property, f11, f10);
        ofFloat.setDuration(200L);
        ofFloat.addListener(new a());
        ofFloat.start();
    }

    public final boolean c() {
        return getVisibility() == 0;
    }

    public final boolean d() {
        if (!c()) {
            return false;
        }
        a();
        return true;
    }

    public final void e(@NotNull Property<View, Float> property) {
        float f10;
        s.i(property, "property");
        float f11 = 0.0f;
        if (s.d(property, View.ALPHA)) {
            f10 = 1.0f;
        } else if (s.d(property, View.Y)) {
            f11 = z0.s.f54824a.a();
            f10 = getTargetY();
        } else {
            f10 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<CustomAnimationLayout, Float>) property, f11, f10);
        ofFloat.setDuration(200L);
        ofFloat.addListener(new b());
        ofFloat.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17386b = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17386b = new LinkedHashMap();
    }
}
