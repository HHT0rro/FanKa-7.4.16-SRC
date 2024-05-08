package com.huawei.openalliance.ad.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSCircleProgressBar extends View {
    private static final int B = 2;
    private static final int C = 100;
    private static final String Code = "PPSCircleProgressBar";
    private static final String F = "...";
    private static final int I = 18;
    private static final int S = 1000;
    private static final int V = 10;
    private final byte[] D;
    private int L;

    /* renamed from: a, reason: collision with root package name */
    private float f32762a;

    /* renamed from: b, reason: collision with root package name */
    private int f32763b;

    /* renamed from: c, reason: collision with root package name */
    private int f32764c;

    /* renamed from: d, reason: collision with root package name */
    private int f32765d;

    /* renamed from: e, reason: collision with root package name */
    private float f32766e;

    /* renamed from: f, reason: collision with root package name */
    private float f32767f;

    /* renamed from: g, reason: collision with root package name */
    private int f32768g;

    /* renamed from: h, reason: collision with root package name */
    private float f32769h;

    /* renamed from: i, reason: collision with root package name */
    private int f32770i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f32771j;

    /* renamed from: k, reason: collision with root package name */
    private String f32772k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f32773l;

    /* renamed from: m, reason: collision with root package name */
    private int f32774m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f32775n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        LEFT(0, 180.0f),
        TOP(1, 270.0f),
        RIGHT(2, 0.0f),
        BOTTOM(3, 90.0f);

        private final int B;
        private final float C;

        a(int i10, float f10) {
            this.B = i10;
            this.C = f10;
        }

        public static float I(int i10) {
            a V = V(i10);
            if (V == null) {
                return 0.0f;
            }
            return V.V();
        }

        public static a V(int i10) {
            for (a aVar : values()) {
                if (aVar.Code(i10)) {
                    return aVar;
                }
            }
            return RIGHT;
        }

        public int Code() {
            return this.B;
        }

        public boolean Code(int i10) {
            return this.B == i10;
        }

        public float V() {
            return this.C;
        }
    }

    public PPSCircleProgressBar(Context context) {
        this(context, null);
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new byte[0];
        Code(context, attributeSet);
        Code();
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet);
        Code(context, attributeSet);
        Code();
    }

    public PPSCircleProgressBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet);
        Code(context, attributeSet);
        Code();
    }

    private float Code(CharSequence charSequence, float f10) {
        int paddingSize = getPaddingSize();
        int progressBarSize = getProgressBarSize();
        int Code2 = v.Code(getContext(), f10);
        while (Code2 > 10 && !Code(charSequence, Code2, paddingSize, progressBarSize)) {
            Code2--;
        }
        if (Code2 <= 10 && !Code(charSequence, Code2, paddingSize, progressBarSize)) {
            this.f32772k = (String) Code(this.f32772k, this.f32773l.width() + getPaddingSize(), getProgressBarSize());
            this.f32771j.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.f32773l);
        }
        float Z = v.Z(getContext(), Code2);
        Code(Z);
        return Z;
    }

    private CharSequence Code(CharSequence charSequence, int i10, int i11) {
        int length = getCurrentText().length();
        int ceil = (int) Math.ceil(((i10 - i11) / this.f32773l.width()) * length);
        int ceil2 = (int) Math.ceil((this.f32774m * length) / this.f32773l.width());
        int i12 = length - ceil;
        if (i12 - ceil2 <= 0) {
            return i12 > 0 ? charSequence.toString().substring(0, i12) : charSequence;
        }
        return charSequence.toString().substring(0, length - (ceil + ceil2)) + F;
    }

    private void Code() {
        Code(this.f32766e);
    }

    private void Code(float f10) {
        Paint paint = new Paint();
        paint.setTextSize(f10);
        Rect rect = new Rect();
        paint.getTextBounds(F, 0, 3, rect);
        this.f32774m = rect.width();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.content.res.TypedArray] */
    private void Code(Context context, AttributeSet attributeSet) {
        Resources resources;
        synchronized (this.D) {
            if (attributeSet != 0) {
                try {
                    attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.hiad_circle);
                    try {
                        try {
                            resources = getResources();
                        } catch (RuntimeException unused) {
                            gl.I(Code, "initButtonAttr RuntimeException");
                        } catch (Throwable th) {
                            gl.I(Code, "initButtonAttr error: " + th.getClass().getSimpleName());
                        }
                    } catch (UnsupportedOperationException unused2) {
                        gl.I(Code, "initButtonAttr UnsupportedOperationException");
                    }
                    if (resources == null) {
                        gl.I(Code, "init attr, resource is null");
                        return;
                    }
                    this.L = attributeSet.getColor(R.styleable.hiad_circle_progress_outerColor, resources.getColor(R.color.hiad_circle_outer));
                    this.f32762a = attributeSet.getDimension(R.styleable.hiad_circle_progress_outerRadius, resources.getDimension(R.dimen.hiad_24_dp));
                    this.f32763b = attributeSet.getColor(R.styleable.hiad_circle_progress_innerColor, resources.getColor(R.color.hiad_circle_inner));
                    this.f32765d = attributeSet.getColor(R.styleable.hiad_circle_progress_textColor, resources.getColor(R.color.hiad_circle_text));
                    this.f32764c = attributeSet.getColor(R.styleable.hiad_circle_progress_fillColor, resources.getColor(R.color.hiad_circle_fill));
                    this.f32766e = attributeSet.getDimension(R.styleable.hiad_circle_progress_textSize, v.Z(context, 18.0f));
                    this.f32767f = attributeSet.getDimension(R.styleable.hiad_circle_progress_progressWidth, v.V(context, 2.0f));
                    this.f32769h = attributeSet.getFloat(R.styleable.hiad_circle_progress_progress, 0.0f);
                    this.f32768g = attributeSet.getInt(R.styleable.hiad_circle_progress_maxProgress, 100);
                    this.f32770i = attributeSet.getInt(R.styleable.hiad_circle_progress_startPoint, a.BOTTOM.Code());
                    this.f32771j = new Paint();
                } finally {
                    attributeSet.recycle();
                }
            }
        }
    }

    private boolean Code(CharSequence charSequence, int i10, int i11, int i12) {
        float Z = v.Z(getContext(), i10);
        if (i12 < 0) {
            return true;
        }
        this.f32771j.setTextSize(Z);
        this.f32771j.getTextBounds(charSequence.toString(), 0, charSequence.length(), this.f32773l);
        return this.f32773l.width() + i11 <= i12;
    }

    private void I(float f10) {
        synchronized (this.D) {
            ValueAnimator ofFloat = ObjectAnimator.ofFloat(this.f32769h, f10);
            this.f32775n = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSCircleProgressBar.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PPSCircleProgressBar.this.f32769h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PPSCircleProgressBar.this.postInvalidate();
                }
            });
            this.f32775n.setDuration(1000L);
            this.f32775n.setInterpolator(new LinearInterpolator());
            this.f32775n.start();
        }
    }

    private void V(float f10) {
        synchronized (this.D) {
            I(f10);
        }
    }

    private int getPaddingSize() {
        int paddingStart = getPaddingStart();
        if (paddingStart <= 0) {
            paddingStart = getPaddingLeft();
        }
        int paddingEnd = getPaddingEnd();
        if (paddingEnd <= 0) {
            paddingEnd = getPaddingRight();
        }
        return paddingStart + paddingEnd;
    }

    private int getProgressBarSize() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int width = getWidth();
        return width <= 0 ? layoutParams.width : width;
    }

    public void Code(float f10, String str) {
        setCurrentText(str);
        setProgress(f10);
    }

    public String getCurrentText() {
        String str;
        synchronized (this.D) {
            str = TextUtils.isEmpty(this.f32772k) ? "" : this.f32772k;
        }
        return str;
    }

    public int getInnerColor() {
        int i10;
        synchronized (this.D) {
            i10 = this.f32763b;
        }
        return i10;
    }

    public int getMaxProgress() {
        int i10;
        synchronized (this.D) {
            i10 = this.f32768g;
        }
        return i10;
    }

    public int getOuterColor() {
        int i10;
        synchronized (this.D) {
            i10 = this.L;
        }
        return i10;
    }

    public float getOuterRadius() {
        float f10;
        synchronized (this.D) {
            f10 = this.f32762a;
        }
        return f10;
    }

    public float getProgress() {
        float f10;
        synchronized (this.D) {
            f10 = this.f32769h;
        }
        return f10;
    }

    public float getProgressWidth() {
        float f10;
        synchronized (this.D) {
            f10 = this.f32767f;
        }
        return f10;
    }

    public int getStartPoint() {
        int i10;
        synchronized (this.D) {
            i10 = this.f32770i;
        }
        return i10;
    }

    public int getTextColor() {
        int i10;
        synchronized (this.D) {
            i10 = this.f32765d;
        }
        return i10;
    }

    public float getTextSize() {
        float f10;
        synchronized (this.D) {
            f10 = this.f32766e;
        }
        return f10;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.D) {
            try {
                super.onDraw(canvas);
                int width = getWidth() / 2;
                this.f32771j.setColor(this.f32764c);
                this.f32771j.setStyle(Paint.Style.FILL);
                this.f32771j.setAntiAlias(true);
                float f10 = width;
                canvas.drawCircle(f10, f10, this.f32762a, this.f32771j);
                this.f32771j.setColor(this.f32763b);
                this.f32771j.setStyle(Paint.Style.STROKE);
                this.f32771j.setStrokeWidth(this.f32767f);
                this.f32771j.setAntiAlias(true);
                canvas.drawCircle(f10, f10, this.f32762a, this.f32771j);
                this.f32771j.setColor(this.L);
                float f11 = this.f32762a;
                canvas.drawArc(new RectF(f10 - f11, f10 - f11, f10 + f11, f10 + f11), a.I(this.f32770i), (this.f32769h / this.f32768g) * 360.0f, false, this.f32771j);
                this.f32773l = new Rect();
                this.f32771j.setColor(this.f32765d);
                this.f32771j.setStyle(Paint.Style.FILL);
                this.f32771j.setTextSize(Code(this.f32772k, this.f32766e));
                this.f32771j.setStrokeWidth(0.0f);
                String currentText = getCurrentText();
                this.f32772k = currentText;
                this.f32771j.getTextBounds(currentText, 0, currentText.length(), this.f32773l);
                this.f32771j.setTextAlign(Paint.Align.LEFT);
                Paint.FontMetricsInt fontMetricsInt = this.f32771j.getFontMetricsInt();
                int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
                int i10 = fontMetricsInt.top;
                canvas.drawText(this.f32772k, (getMeasuredWidth() / 2) - (this.f32773l.width() / 2), ((measuredHeight + i10) / 2) - i10, this.f32771j);
            } catch (Throwable unused) {
                gl.I(Code, "onDraw error.");
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        synchronized (this.D) {
            try {
                int size = View.MeasureSpec.getSize(i10);
                if (View.MeasureSpec.getMode(i10) != 1073741824) {
                    size = (int) ((this.f32762a * 2.0f) + this.f32767f);
                }
                int size2 = View.MeasureSpec.getSize(i11);
                if (View.MeasureSpec.getMode(i11) != 1073741824) {
                    size2 = (int) ((this.f32762a * 2.0f) + this.f32767f);
                }
                setMeasuredDimension(size, size2);
            } catch (Throwable unused) {
                gl.I(Code, "onMeasure error.");
            }
        }
    }

    public void setCurrentText(String str) {
        synchronized (this.D) {
            this.f32772k = str;
        }
    }

    public void setInnerColor(int i10) {
        synchronized (this.D) {
            this.f32763b = i10;
        }
    }

    public void setMaxProgress(int i10) {
        synchronized (this.D) {
            this.f32768g = i10;
        }
    }

    public void setOuterColor(int i10) {
        synchronized (this.D) {
            this.L = i10;
        }
    }

    public void setOuterRadius(float f10) {
        synchronized (this.D) {
            this.f32762a = f10;
        }
    }

    public void setProgress(float f10) {
        synchronized (this.D) {
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            int i10 = this.f32768g;
            if (f10 > i10) {
                f10 = i10;
            }
            V(f10);
        }
    }

    public void setProgressWidth(float f10) {
        synchronized (this.D) {
            this.f32767f = f10;
        }
    }

    public void setStartPoint(int i10) {
        synchronized (this.D) {
            this.f32770i = i10;
        }
    }

    public void setTextColor(int i10) {
        synchronized (this.D) {
            this.f32765d = i10;
        }
    }

    public void setTextSize(float f10) {
        synchronized (this.D) {
            this.f32766e = f10;
        }
    }
}
