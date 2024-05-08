package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.hms.ads.splash.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RoundLinearLayout extends LinearLayout {
    private final RectF Code;
    private Path I;
    private float V;

    public RoundLinearLayout(Context context) {
        super(context);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, null);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, attributeSet);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, attributeSet);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.Code = new RectF();
        this.V = 0.0f;
        Code(context, attributeSet);
    }

    private void Code() {
        this.I.reset();
        Path path = this.I;
        RectF rectF = this.Code;
        float f10 = this.V;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PPSRoundCornerLayout)) != null) {
            try {
                this.V = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PPSRoundCornerLayout_hiad_roundCorner, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.I = new Path();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.V > 0.01f) {
            canvas.clipPath(this.I);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.Code.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Code();
    }

    public void setRectCornerRadius(float f10) {
        this.V = f10;
        Code();
        postInvalidate();
    }
}
