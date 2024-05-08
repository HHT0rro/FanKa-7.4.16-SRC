package com.alibaba.security.biometrics.logic.view.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.DisplayUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPDetectCoreView extends View {

    /* renamed from: i, reason: collision with root package name */
    private static final String f2457i = "RPDetectCoreView";

    /* renamed from: j, reason: collision with root package name */
    private static final int f2458j = -1;
    private int A;
    private int B;

    /* renamed from: a, reason: collision with root package name */
    public a f2459a;

    /* renamed from: b, reason: collision with root package name */
    public long f2460b;

    /* renamed from: c, reason: collision with root package name */
    public long f2461c;

    /* renamed from: d, reason: collision with root package name */
    public float f2462d;

    /* renamed from: e, reason: collision with root package name */
    public float f2463e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2464f;

    /* renamed from: g, reason: collision with root package name */
    public ValueAnimator f2465g;

    /* renamed from: h, reason: collision with root package name */
    public ValueAnimator f2466h;

    /* renamed from: k, reason: collision with root package name */
    private final float f2467k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f2468l;

    /* renamed from: m, reason: collision with root package name */
    private Path f2469m;

    /* renamed from: n, reason: collision with root package name */
    private int f2470n;

    /* renamed from: o, reason: collision with root package name */
    private int f2471o;

    /* renamed from: p, reason: collision with root package name */
    private int f2472p;

    /* renamed from: q, reason: collision with root package name */
    private int f2473q;

    /* renamed from: r, reason: collision with root package name */
    private float f2474r;

    /* renamed from: s, reason: collision with root package name */
    private int f2475s;

    /* renamed from: t, reason: collision with root package name */
    private int f2476t;

    /* renamed from: u, reason: collision with root package name */
    private Paint f2477u;

    /* renamed from: v, reason: collision with root package name */
    private int f2478v;

    /* renamed from: w, reason: collision with root package name */
    private Paint f2479w;

    /* renamed from: x, reason: collision with root package name */
    private int f2480x;

    /* renamed from: y, reason: collision with root package name */
    private RectF f2481y;

    /* renamed from: z, reason: collision with root package name */
    private Paint f2482z;

    /* renamed from: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            RPDetectCoreView.this.f2477u.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            RPDetectCoreView.this.invalidate();
        }
    }

    /* renamed from: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            RPDetectCoreView.this.f2480x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RPDetectCoreView.this.invalidate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();

        void b();
    }

    public RPDetectCoreView(Context context) {
        super(context);
        this.f2467k = 0.4f;
        this.f2470n = 0;
        this.f2471o = -1;
        this.f2472p = -1;
        this.f2460b = -1L;
        this.f2461c = -1L;
        this.f2462d = -1.0f;
        this.f2463e = -1.0f;
        this.f2464f = false;
        c();
    }

    private void c() {
        setLayerType(1, null);
        this.f2470n = DisplayUtils.getDisplayCircleRadius(getContext());
        RPLogging.d(f2457i, "mRadius:" + this.f2470n);
        this.A = DisplayUtils.getWidth(getContext());
        this.B = DisplayUtils.getHeight(getContext());
        RPLogging.d(f2457i, "width:" + this.A);
        RPLogging.d(f2457i, "height:" + this.B);
        this.f2472p = this.A / 2;
        this.f2471o = a(getContext());
        RPLogging.d(f2457i, "mCircleCenterX:" + this.f2472p);
        RPLogging.d(f2457i, "mCircleCenterY:" + this.f2471o);
        this.f2473q = -1;
        Paint paint = new Paint(1);
        this.f2468l = paint;
        paint.setColor(-1);
        this.f2469m = new Path();
        this.f2476t = DisplayUtils.dip2px(getContext(), 7.0f);
        Paint paint2 = new Paint(1);
        this.f2477u = paint2;
        paint2.setColor(-65536);
        this.f2477u.setStyle(Paint.Style.STROKE);
        this.f2477u.setStrokeWidth(DisplayUtils.dip2px(getContext(), 5.0f));
        Paint paint3 = new Paint(1);
        this.f2479w = paint3;
        paint3.setColor(-16776961);
        this.f2479w.setStyle(Paint.Style.STROKE);
        this.f2479w.setStrokeWidth(DisplayUtils.dip2px(getContext(), 5.0f));
        Paint paint4 = new Paint(1);
        this.f2482z = paint4;
        paint4.setColor(-16777216);
        this.f2482z.setAlpha(127);
        this.f2482z.setStyle(Paint.Style.FILL);
    }

    private void d() {
        if (this.f2465g == null) {
            ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
            this.f2465g = duration;
            duration.setRepeatCount(-1);
            this.f2465g.addUpdateListener(new AnonymousClass1());
            this.f2465g.start();
        }
        invalidate();
    }

    private void e() {
        if (this.f2466h == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 360).setDuration(2000L);
            this.f2466h = duration;
            duration.setRepeatCount(-1);
            this.f2466h.addUpdateListener(new AnonymousClass2());
            this.f2466h.start();
        }
    }

    private void f() {
        ValueAnimator valueAnimator = this.f2466h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f2466h = null;
            invalidate();
        }
    }

    private float getCurrentScale() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j10 = this.f2461c;
        if (j10 != -1) {
            long j11 = this.f2460b;
            if (j11 != -1) {
                float f10 = this.f2463e;
                if (f10 != -1.0f) {
                    float f11 = this.f2462d;
                    if (f11 != -1.0f && uptimeMillis - j11 <= j10) {
                        float f12 = ((float) (uptimeMillis - j11)) / ((float) j10);
                        return f12 > 0.4f ? f10 : f11 + (f12 * (f10 - f11));
                    }
                }
            }
        }
        return -1.0f;
    }

    public final void b() {
        a();
        ValueAnimator valueAnimator = this.f2466h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f2466h = null;
            invalidate();
        }
    }

    public int getCircleBottom() {
        return this.f2471o + this.f2470n;
    }

    public int getCircleCenterY() {
        return this.f2471o;
    }

    public int getRadius() {
        return this.f2470n;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        a aVar;
        super.onDraw(canvas);
        try {
            if (getWidth() != 0 && getWidth() != this.A) {
                this.f2472p = getWidth() / 2;
                int width = getWidth();
                RPLogging.d(f2457i, "mViewWidth:".concat(String.valueOf(width)));
                this.f2470n = (Math.min(DisplayUtils.getHeight(getContext()), width) / 2) - DisplayUtils.dip2px(getContext(), 50.0f);
                this.f2471o = DisplayUtils.dip2px(getContext(), 125.0f) + this.f2470n;
            }
            if (this.f2481y == null) {
                int i10 = this.f2472p;
                int i11 = this.f2470n;
                int i12 = this.f2476t;
                int i13 = this.f2471o;
                this.f2481y = new RectF((i10 - i11) - i12, (i13 - i11) - i12, i10 + i11 + i12, i13 + i11 + i12);
            }
            this.f2474r = getCurrentScale();
            this.f2469m.addCircle(this.f2472p, this.f2471o, this.f2470n, Path.Direction.CW);
            canvas.drawColor(this.f2473q);
            ValueAnimator valueAnimator = this.f2465g;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                canvas.drawCircle(this.f2472p, this.f2471o, this.f2470n + this.f2476t, this.f2477u);
            }
            this.f2468l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPath(this.f2469m, this.f2468l);
            this.f2468l.setXfermode(null);
            ValueAnimator valueAnimator2 = this.f2466h;
            if (valueAnimator2 != null && valueAnimator2.isStarted()) {
                canvas.drawArc(this.f2481y, this.f2480x - 90, 45.0f, false, this.f2479w);
                canvas.drawCircle(this.f2472p, this.f2471o, this.f2470n, this.f2482z);
            }
            if (this.f2474r != -1.0f) {
                invalidate();
                if (this.f2464f || (aVar = this.f2459a) == null) {
                    return;
                }
                aVar.a();
                this.f2464f = true;
                return;
            }
            a aVar2 = this.f2459a;
            if (aVar2 != null) {
                try {
                    aVar2.b();
                } finally {
                    this.f2459a = null;
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f2473q = i10;
        invalidate();
    }

    public void setBreatheColor(int i10) {
        this.f2475s = i10;
        this.f2477u.setColor(i10);
    }

    public void setWaitingColor(int i10) {
        this.f2478v = i10;
        this.f2479w.setColor(i10);
    }

    public final void a() {
        ValueAnimator valueAnimator = this.f2465g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f2477u.setAlpha(0);
            this.f2465g = null;
            invalidate();
        }
    }

    private int a(Context context) {
        return DisplayUtils.dip2px(context, 125.0f) + this.f2470n;
    }

    private void a(float f10, float f11, long j10, a aVar) {
        this.f2462d = f10;
        this.f2463e = f11;
        this.f2461c = j10;
        this.f2459a = aVar;
        this.f2464f = false;
        this.f2460b = SystemClock.uptimeMillis();
        invalidate();
    }

    public RPDetectCoreView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2467k = 0.4f;
        this.f2470n = 0;
        this.f2471o = -1;
        this.f2472p = -1;
        this.f2460b = -1L;
        this.f2461c = -1L;
        this.f2462d = -1.0f;
        this.f2463e = -1.0f;
        this.f2464f = false;
        c();
    }

    public RPDetectCoreView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2467k = 0.4f;
        this.f2470n = 0;
        this.f2471o = -1;
        this.f2472p = -1;
        this.f2460b = -1L;
        this.f2461c = -1L;
        this.f2462d = -1.0f;
        this.f2463e = -1.0f;
        this.f2464f = false;
        c();
    }
}
