package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ScaleAnimSeekBar extends View {
    private Paint aCQ;
    private int aCR;
    private int aCS;
    private int aCT;
    private int aCU;
    private int aCV;
    private int aCW;
    private int aCX;
    private int aCY;
    private boolean aCZ;
    private float aDA;
    private float aDB;
    private float aDC;
    private float aDD;
    private int aDE;
    private boolean aDF;
    private int aDa;
    private int aDb;
    private int aDc;
    private int aDd;
    private int aDe;
    private int aDf;
    private int aDg;
    private GradientDrawable aDh;
    private GradientDrawable aDi;
    private GradientDrawable aDj;
    private Rect aDk;
    private Rect aDl;
    private Rect aDm;
    private Rect aDn;
    private Drawable aDo;
    private boolean aDp;
    private boolean aDq;
    private boolean aDr;
    private boolean aDs;
    private boolean aDt;
    private WeakReference<a> aDu;
    private boolean aDv;
    private boolean aDw;
    private ValueAnimator aDx;
    private ValueAnimator aDy;
    private ValueAnimator aDz;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z10);

        void tr();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    private void bm(Context context) {
        this.aDv = true;
        this.aDE = com.kwad.sdk.d.a.a.a(context, 10.0f);
        this.aCU = com.kwad.sdk.d.a.a.a(context, 3.0f);
        this.aDb = com.kwad.sdk.d.a.a.a(context, 20.0f);
        this.aDo = null;
        this.aDw = false;
        this.aCY = com.kwad.sdk.d.a.a.a(context, 0.5f);
        this.aCX = com.kwad.sdk.d.a.a.a(context, 1.0f);
        this.aCR = 654311423;
        this.aCS = -1;
        this.aCT = 1090519039;
        this.aCV = 0;
        this.aCW = 100;
        this.aCZ = false;
    }

    private void bp(boolean z10) {
        if (this.aDv) {
            if (z10) {
                bq(true);
                br(true);
            } else {
                bq(false);
                br(false);
            }
        }
    }

    private void bq(boolean z10) {
        float f10 = this.aDA;
        float f11 = z10 ? this.aDB : 1.0f;
        ValueAnimator valueAnimator = this.aDx;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aDx = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aDx.setInterpolator(new LinearInterpolator());
            this.aDx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aDA = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aDx.setFloatValues(f10, f11);
        this.aDx.start();
    }

    private void br(boolean z10) {
        float f10 = this.aDC;
        float f11 = z10 ? this.aDD : 1.0f;
        ValueAnimator valueAnimator = this.aDy;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aDy = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aDy.setInterpolator(new LinearInterpolator());
            this.aDy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aDC = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aDy.setFloatValues(f10, f11);
        this.aDy.start();
    }

    private boolean d(float f10, float f11) {
        int i10;
        int i11;
        Rect rect = this.aDn;
        int i12 = rect.left;
        int i13 = rect.right;
        if (i12 >= i13 || (i10 = rect.top) >= (i11 = rect.bottom)) {
            return false;
        }
        float f12 = this.aDA;
        int i14 = this.aDb;
        return f10 >= (((float) i12) * f12) - ((float) i14) && f10 <= (((float) i13) * f12) + ((float) i14) && f11 >= (((float) i10) * f12) - ((float) i14) && f11 <= (((float) i11) * f12) + ((float) i14);
    }

    private float dv(int i10) {
        int i11 = this.aDa;
        int i12 = this.aCV;
        return ((i11 * (i10 - i12)) / (this.aCW - i12)) - (i11 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dw(int i10) {
        int i11 = this.aDa;
        if (i10 > i11 / 2) {
            return this.aCW;
        }
        if (i10 < (-i11) / 2) {
            return this.aCV;
        }
        return Math.round(((i10 + (i11 / 2.0f)) * (this.aCW - this.aCV)) / i11) + this.aCV;
    }

    private boolean e(float f10, float f11) {
        int i10;
        int i11;
        Rect rect = this.aDk;
        int i12 = rect.left;
        int i13 = rect.right;
        if (i12 >= i13 || (i10 = rect.top) >= (i11 = rect.bottom)) {
            return false;
        }
        float f12 = this.aDC;
        int i14 = this.aDb;
        return f10 >= (((float) i12) * f12) - ((float) i14) && f10 <= (((float) i13) * f12) + ((float) i14) && f11 >= (((float) i10) * f12) - ((float) i14) && f11 <= (((float) i11) * f12) + ((float) i14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f10) {
        Rect rect = this.aDn;
        int i10 = this.aCU;
        rect.left = (int) (f10 - i10);
        rect.right = (int) (i10 + f10);
        this.aDl.right = (int) f10;
        invalidate();
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aDu;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private float h(float f10) {
        float f11 = this.aDa / 2;
        if (f10 > f11) {
            return f11;
        }
        float f12 = -f11;
        return f10 < f12 ? f12 : f10;
    }

    private void i(boolean z10, int i10) {
        if (z10) {
            float h10 = h(dv(this.aDc));
            float h11 = h(dv(i10));
            ValueAnimator valueAnimator = this.aDz;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.aDz = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.aDz.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f10) {
                        float f11 = f10 - 1.0f;
                        return (f11 * f11 * f11) + 1.0f;
                    }
                });
                this.aDz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.aDc = scaleAnimSeekBar.dw((int) floatValue);
                        ScaleAnimSeekBar.this.g(floatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.aDz.setFloatValues(h10, h11);
            this.aDz.start();
            return;
        }
        this.aDc = i10;
        g(h(dv(i10)));
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bm(context);
        }
        Paint paint = new Paint();
        this.aCQ = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aCQ.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aDh = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aDh.setColor(this.aCR);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aDi = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aDi.setColor(this.aCS);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aDj = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aDj.setColor(this.aCT);
        this.aDk = new Rect();
        this.aDl = new Rect();
        this.aDn = new Rect();
        this.aDm = new Rect();
        this.aDc = this.aCV;
    }

    private void x(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        if (this.aDv) {
            this.aDa = (int) (i10 - ((this.aDE * 2) * (this.aDB - this.aDA)));
        } else {
            this.aDa = i10 - (this.aDE * 2);
        }
        Rect rect = this.aDk;
        int i12 = this.aCY;
        int i13 = -i12;
        rect.top = i13;
        rect.bottom = -i13;
        boolean z10 = this.aCZ;
        rect.left = (z10 ? -i10 : -this.aDa) / 2;
        rect.right = z10 ? i10 / 2 : this.aDa / 2;
        Rect rect2 = this.aDl;
        int i14 = -i12;
        rect2.top = i14;
        rect2.bottom = -i14;
        rect2.left = (z10 ? -i10 : -this.aDa) / 2;
        int i15 = this.aDa;
        rect2.right = (-i15) / 2;
        Rect rect3 = this.aDm;
        rect3.top = -i12;
        rect3.bottom = -rect2.top;
        rect3.left = (z10 ? -i10 : -i15) / 2;
        rect3.right = (-i15) / 2;
        Rect rect4 = this.aDn;
        int i16 = this.aCU;
        rect4.top = -i16;
        rect4.bottom = i16;
        rect4.left = ((-i15) / 2) - i16;
        rect4.right = ((-i15) / 2) + i16;
        setThumbDrawable(this.aDo);
        setProgress(this.aDc);
        setSecondaryProgress(this.aDe);
    }

    public final void bo(boolean z10) {
        this.aDF = z10;
        bp(z10);
    }

    public int getMaxProgress() {
        return this.aCW;
    }

    public int getProgress() {
        return this.aDc;
    }

    public int getProgressLength() {
        return this.aDa;
    }

    public int getProgressX() {
        return (int) (getX() + (this.aCU * this.aDB));
    }

    public int getSecondaryProgress() {
        return this.aDe;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aDg / 2, this.aDf / 2);
        a(canvas, this.aDk, this.aDh);
        a(canvas, this.aDm, this.aDj);
        a(canvas, this.aDl, this.aDi);
        if (this.aDF) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == 1073741824) {
            this.aDg = size;
        } else {
            this.aDg = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aDf = size2;
        } else {
            this.aDf = getHeight();
        }
        x(this.aDg, this.aDf);
        setMeasuredDimension(this.aDg, this.aDf);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x10 = motionEvent.getX() - (this.aDg / 2);
        float y10 = motionEvent.getY() - (this.aDf / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.aDp || this.aDq)) {
                    a(dw((int) x10), false, true);
                }
            } else {
                this.aDt = false;
                if (this.aDq || this.aDp) {
                    this.aDq = false;
                    this.aDp = false;
                    a(dw((int) x10), this.aDw, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            if (!this.aDs) {
                return super.onTouchEvent(motionEvent);
            }
            if (d(x10, y10)) {
                bp(true);
                this.aDp = true;
                this.aDt = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.tr();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (e(x10, y10)) {
                bp(true);
                this.aDq = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.tr();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i10) {
        this.aCW = i10;
    }

    public void setMinProgress(int i10) {
        this.aCV = i10;
        if (this.aDc < i10) {
            this.aDc = i10;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aDu = new WeakReference<>(aVar);
    }

    public void setProgress(int i10) {
        a(i10, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i10) {
        this.aCR = i10;
        this.aDh.setColor(i10);
    }

    public void setProgressColor(@ColorInt int i10) {
        this.aCS = i10;
        this.aDi.setColor(i10);
    }

    public void setSecondaryProgress(int i10) {
        int i11 = this.aCV;
        if (i10 <= i11 || i10 >= (i11 = this.aCW)) {
            i10 = i11;
        }
        this.aDe = i10;
        this.aDm.right = (int) h(dv(i10));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i10) {
        this.aCT = i10;
        this.aDj.setColor(i10);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aDo = drawable;
    }

    public void setThumbEnable(boolean z10) {
        this.aDs = z10;
    }

    public void setThumbScale(float f10) {
        this.aDA = f10;
    }

    public void setThumbTouchOffset(int i10) {
        this.aDb = i10;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aDo;
        if (drawable != null) {
            drawable.setBounds(this.aDn);
            this.aDo.draw(canvas);
        } else {
            this.aCQ.setColor(this.aCS);
            canvas.drawCircle(this.aDn.centerX(), this.aDn.centerY(), (this.aDn.width() * this.aDA) / 2.0f, this.aCQ);
        }
        canvas.restore();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aCW = 100;
        this.aCZ = false;
        this.aDo = null;
        this.aDp = false;
        this.aDq = false;
        this.aDr = false;
        this.aDs = true;
        this.aDv = true;
        this.aDw = false;
        this.aDA = 1.0f;
        this.aDB = 1.34f;
        this.aDC = 1.0f;
        this.aDD = 2.0f;
        init(context, attributeSet);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f10 = rect.top;
        float f11 = this.aDC;
        rect2.top = (int) (f10 * f11);
        rect2.bottom = (int) (rect.bottom * f11);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aCX * this.aDC);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(int i10, boolean z10, boolean z11) {
        int i11 = this.aCV;
        if (i10 <= i11 || i10 >= (i11 = this.aCW)) {
            i10 = i11;
        }
        i(z10, i10);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aDd != this.aDc) {
            this.aDr = z11;
            onSeekBarChangedListener.a(this, z11);
            this.aDr = false;
        }
        this.aDd = this.aDc;
    }
}
