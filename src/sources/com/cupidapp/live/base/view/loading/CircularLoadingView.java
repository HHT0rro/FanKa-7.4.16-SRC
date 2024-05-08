package com.cupidapp.live.base.view.loading;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.view.loading.CircularLoadingView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: CircularLoadingView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CircularLoadingView extends View {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f12838l = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public boolean f12839b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ValueAnimator f12840c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final RectF f12841d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Paint f12842e;

    /* renamed from: f, reason: collision with root package name */
    public float f12843f;

    /* renamed from: g, reason: collision with root package name */
    public int f12844g;

    /* renamed from: h, reason: collision with root package name */
    public int f12845h;

    /* renamed from: i, reason: collision with root package name */
    public float f12846i;

    /* renamed from: j, reason: collision with root package name */
    public float f12847j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12848k;

    /* compiled from: CircularLoadingView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
            CircularLoadingView.this.f12839b = !r2.f12839b;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularLoadingView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12848k = new LinkedHashMap();
        this.f12839b = true;
        this.f12841d = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f12842e = paint;
        this.f12843f = h.c(this, 5.0f);
        this.f12844g = -49088;
        this.f12845h = 600;
        g(context, null);
    }

    public static final void e(CircularLoadingView this$0, ValueAnimator animation) {
        s.i(this$0, "this$0");
        s.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Float f10 = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f10 != null) {
            float floatValue = f10.floatValue();
            this$0.f12846i = floatValue;
            if (!this$0.f12839b) {
                floatValue = -(360 - floatValue);
            }
            this$0.f12847j = floatValue;
            this$0.invalidate();
        }
    }

    public final void d() {
        f();
        ValueAnimator circularPlayLoadingAnimation$lambda$4 = ValueAnimator.ofFloat(0.0f, 360.0f);
        circularPlayLoadingAnimation$lambda$4.setDuration(this.f12845h);
        circularPlayLoadingAnimation$lambda$4.setInterpolator(new LinearInterpolator());
        circularPlayLoadingAnimation$lambda$4.setRepeatCount(-1);
        circularPlayLoadingAnimation$lambda$4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: s1.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularLoadingView.e(CircularLoadingView.this, valueAnimator);
            }
        });
        s.h(circularPlayLoadingAnimation$lambda$4, "circularPlayLoadingAnimation$lambda$4");
        circularPlayLoadingAnimation$lambda$4.addListener(new b());
        circularPlayLoadingAnimation$lambda$4.start();
        this.f12840c = circularPlayLoadingAnimation$lambda$4;
    }

    public final void f() {
        ValueAnimator valueAnimator = this.f12840c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f12840c = null;
    }

    public final void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircularLoadingView);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…able.CircularLoadingView)");
        setMLoadingStrokeWidth(obtainStyledAttributes.getDimension(2, this.f12843f));
        setMLoadingColor(obtainStyledAttributes.getColor(0, this.f12844g));
        this.f12845h = obtainStyledAttributes.getInteger(1, this.f12845h);
        obtainStyledAttributes.recycle();
    }

    public final int getMLoadingColor() {
        return this.f12844g;
    }

    public final float getMLoadingStrokeWidth() {
        return this.f12843f;
    }

    public final void h() {
        d();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawArc(this.f12841d, this.f12846i, this.f12847j, false, this.f12842e);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int min = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i10), View.getDefaultSize(getSuggestedMinimumHeight(), i11));
        setMeasuredDimension(min, min);
        float f10 = this.f12843f / 2;
        float f11 = 0 + f10;
        float f12 = min - f10;
        this.f12841d.set(f11, f11, f12, f12);
    }

    public final void setMLoadingColor(int i10) {
        this.f12844g = i10;
        this.f12842e.setColor(i10);
        invalidate();
    }

    public final void setMLoadingStrokeWidth(float f10) {
        this.f12843f = f10;
        this.f12842e.setStrokeWidth(f10);
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12848k = new LinkedHashMap();
        this.f12839b = true;
        this.f12841d = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f12842e = paint;
        this.f12843f = h.c(this, 5.0f);
        this.f12844g = -49088;
        this.f12845h = 600;
        g(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12848k = new LinkedHashMap();
        this.f12839b = true;
        this.f12841d = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f12842e = paint;
        this.f12843f = h.c(this, 5.0f);
        this.f12844g = -49088;
        this.f12845h = 600;
        g(context, attributeSet);
    }
}
