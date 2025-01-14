package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JinniuCouponLayout extends LinearLayout {
    private float Al;
    private Rect Am;
    private RectF An;
    private RectF Ao;
    private RectF Ap;
    private RectF Aq;
    private Path Ar;

    @ColorInt
    private int endColor;
    private Paint mPaint;
    private float mRadius;

    @ColorInt
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.Al = 4.0f;
        this.mRadius = 10.0f;
        this.Am = new Rect();
        this.An = new RectF();
        this.Ao = new RectF();
        this.Ap = new RectF();
        this.Aq = new RectF();
        this.Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i10, 0);
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.Al = obtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        obtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.Am.setEmpty();
        getDrawingRect(this.Am);
        this.An.set(this.Am);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.Ao;
            if (rectF == null) {
                this.Ao = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.Ap;
            if (rectF2 == null) {
                this.Ap = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = childAt.getMeasuredWidth();
            Rect rect = this.Am;
            float f10 = rect.left + measuredWidth;
            RectF rectF3 = this.Ao;
            int i10 = rect.top;
            float f11 = this.Al;
            rectF3.set(f10, i10 - f11, (2.0f * f11) + f10, i10 + f11);
            RectF rectF4 = this.Ap;
            RectF rectF5 = this.Ao;
            float f12 = rectF5.left;
            int i11 = this.Am.bottom;
            float f13 = this.Al;
            rectF4.set(f12, i11 - f13, rectF5.right, i11 + f13);
            a(this.Ar, this.An, this.Ao, this.Ap);
            setGradientPaint(this.An);
            canvas.drawPath(this.Ar, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        RectF rectF4 = this.An;
        path.moveTo(rectF4.left, rectF4.top + this.mRadius);
        this.Aq.set(rectF);
        RectF rectF5 = this.Aq;
        float f10 = rectF5.top;
        float f11 = this.mRadius;
        rectF5.bottom = f10 + (f11 * 2.0f);
        rectF5.right = rectF5.left + (f11 * 2.0f);
        path.arcTo(rectF5, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.Aq.set(rectF);
        RectF rectF6 = this.Aq;
        float f12 = rectF6.right;
        float f13 = this.mRadius;
        rectF6.left = f12 - (f13 * 2.0f);
        rectF6.bottom = rectF6.top + (f13 * 2.0f);
        path.arcTo(rectF6, 270.0f, 90.0f);
        this.Aq.set(rectF);
        RectF rectF7 = this.Aq;
        float f14 = rectF7.right;
        float f15 = this.mRadius;
        rectF7.left = f14 - (f15 * 2.0f);
        rectF7.top = rectF7.bottom - (f15 * 2.0f);
        path.arcTo(rectF7, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.Aq.set(rectF);
        RectF rectF8 = this.Aq;
        float f16 = rectF8.left;
        float f17 = this.mRadius;
        rectF8.right = f16 + (f17 * 2.0f);
        rectF8.top = rectF8.bottom - (f17 * 2.0f);
        path.arcTo(rectF8, 90.0f, 90.0f);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.Al = 4.0f;
        this.mRadius = 10.0f;
        this.Am = new Rect();
        this.An = new RectF();
        this.Ao = new RectF();
        this.Ap = new RectF();
        this.Aq = new RectF();
        this.Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = new Paint();
        this.Al = 4.0f;
        this.mRadius = 10.0f;
        this.Am = new Rect();
        this.An = new RectF();
        this.Ao = new RectF();
        this.Ap = new RectF();
        this.Aq = new RectF();
        this.Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i10);
    }

    @RequiresApi(api = 21)
    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mPaint = new Paint();
        this.Al = 4.0f;
        this.mRadius = 10.0f;
        this.Am = new Rect();
        this.An = new RectF();
        this.Ao = new RectF();
        this.Ap = new RectF();
        this.Aq = new RectF();
        this.Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i10);
    }
}
