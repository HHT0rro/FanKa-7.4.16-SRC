package com.cupidapp.live.base.view.progress;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.view.progress.CircleProgressBarView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t1.b;

/* compiled from: CircleProgressBarView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CircleProgressBarView extends View {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Paint f12871b;

    /* renamed from: c, reason: collision with root package name */
    public float f12872c;

    /* renamed from: d, reason: collision with root package name */
    public float f12873d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12874e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Shader f12875f;

    /* renamed from: g, reason: collision with root package name */
    public float f12876g;

    /* renamed from: h, reason: collision with root package name */
    public float f12877h;

    /* renamed from: i, reason: collision with root package name */
    public float f12878i;

    /* renamed from: j, reason: collision with root package name */
    public final float f12879j;

    /* renamed from: k, reason: collision with root package name */
    public float f12880k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public ValueAnimator f12881l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12882m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12883n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final RectF f12884o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public b f12885p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12886q = new LinkedHashMap();

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            b bVar = CircleProgressBarView.this.f12885p;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    public CircleProgressBarView(@Nullable Context context) {
        super(context);
        this.f12873d = 270.0f;
        this.f12874e = 360;
        this.f12879j = 1.0f;
        this.f12882m = true;
        this.f12883n = true;
        this.f12884o = new RectF();
        d(this, context, null, 2, null);
    }

    public static /* synthetic */ void d(CircleProgressBarView circleProgressBarView, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        circleProgressBarView.c(context, attributeSet);
    }

    public static final void f(CircleProgressBarView this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.setProgress(floatValue);
        b bVar = this$0.f12885p;
        if (bVar != null) {
            bVar.b(floatValue);
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.CircleProgressBarView) : null;
        if (obtainStyledAttributes != null) {
            this.f12872c = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        }
        if (obtainStyledAttributes != null) {
            this.f12882m = obtainStyledAttributes.getBoolean(0, true);
        }
        if (obtainStyledAttributes != null) {
            this.f12883n = obtainStyledAttributes.getBoolean(1, true);
        }
        if (obtainStyledAttributes != null) {
            this.f12873d = obtainStyledAttributes.getFloat(2, 270.0f);
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f12872c);
        if (this.f12882m) {
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
        this.f12871b = paint;
    }

    public final void e(long j10) {
        ValueAnimator valueAnimator = this.f12881l;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        float[] fArr = new float[2];
        boolean z10 = this.f12883n;
        fArr[0] = z10 ? 0.0f : 1.0f;
        fArr[1] = z10 ? 1.0f : 0.0f;
        ValueAnimator startAnimation$lambda$8 = ValueAnimator.ofFloat(fArr);
        startAnimation$lambda$8.setDuration(j10);
        startAnimation$lambda$8.setInterpolator(new LinearInterpolator());
        startAnimation$lambda$8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: t1.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CircleProgressBarView.f(CircleProgressBarView.this, valueAnimator2);
            }
        });
        s.h(startAnimation$lambda$8, "startAnimation$lambda$8");
        startAnimation$lambda$8.addListener(new a());
        this.f12881l = startAnimation$lambda$8;
        startAnimation$lambda$8.start();
    }

    public final void g() {
        ValueAnimator valueAnimator = this.f12881l;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f12881l;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.f12881l;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        s.i(canvas, "canvas");
        super.onDraw(canvas);
        this.f12884o.set((this.f12877h - this.f12876g) + getPaddingStart(), (this.f12878i - this.f12876g) + getPaddingTop(), (this.f12877h + this.f12876g) - getPaddingEnd(), (this.f12878i + this.f12876g) - getPaddingBottom());
        float f10 = this.f12874e * (this.f12880k / this.f12879j);
        RectF rectF = this.f12884o;
        float f11 = this.f12873d;
        Paint paint = this.f12871b;
        s.f(paint);
        canvas.drawArc(rectF, f11, f10, false, paint);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f12876g = (getMeasuredWidth() - this.f12872c) / 2;
        this.f12877h = getMeasuredWidth() / 2.0f;
        this.f12878i = getMeasuredHeight() / 2.0f;
    }

    public final void setOnProgressChangeListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f12885p = listener;
    }

    public final void setProgress(float f10) {
        this.f12880k = f10;
        invalidate();
    }

    public final void setProgressColor(@NotNull List<Integer> colors) {
        s.i(colors, "colors");
        if (!colors.isEmpty()) {
            if (colors.size() > 1) {
                SweepGradient sweepGradient = new SweepGradient(this.f12877h, this.f12878i, CollectionsKt___CollectionsKt.w0(colors), (float[]) null);
                Matrix matrix = new Matrix();
                matrix.setRotate(270.0f, this.f12877h, this.f12878i);
                sweepGradient.setLocalMatrix(matrix);
                this.f12875f = sweepGradient;
                Paint paint = this.f12871b;
                if (paint == null) {
                    return;
                }
                paint.setShader(sweepGradient);
                return;
            }
            Paint paint2 = this.f12871b;
            if (paint2 == null) {
                return;
            }
            paint2.setColor(((Number) CollectionsKt___CollectionsKt.T(colors)).intValue());
        }
    }

    public CircleProgressBarView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12873d = 270.0f;
        this.f12874e = 360;
        this.f12879j = 1.0f;
        this.f12882m = true;
        this.f12883n = true;
        this.f12884o = new RectF();
        c(context, attributeSet);
    }

    public CircleProgressBarView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12873d = 270.0f;
        this.f12874e = 360;
        this.f12879j = 1.0f;
        this.f12882m = true;
        this.f12883n = true;
        this.f12884o = new RectF();
        c(context, attributeSet);
    }
}
