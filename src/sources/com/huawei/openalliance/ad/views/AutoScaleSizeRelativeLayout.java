package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.base.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AutoScaleSizeRelativeLayout extends RelativeLayout {
    private Path B;
    private boolean C;
    private Float Code;
    private float I;
    private final RectF V;

    public AutoScaleSizeRelativeLayout(Context context) {
        super(context);
        this.V = new RectF();
        this.I = 0.0f;
        this.C = true;
        Code(context, (AttributeSet) null);
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = new RectF();
        this.I = 0.0f;
        this.C = true;
        Code(context, attributeSet);
    }

    public AutoScaleSizeRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.V = new RectF();
        this.I = 0.0f;
        this.C = true;
        Code(context, attributeSet);
    }

    private int Code(int i10, float f10) {
        if (f10 <= 0.0f) {
            return 0;
        }
        float f11 = (i10 * 1.0f) / f10;
        return Z() ? (int) Math.ceil(f11) : (int) f11;
    }

    private void Code() {
        this.B.reset();
        Path path = this.B;
        RectF rectF = this.V;
        float f10 = this.I;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PPSRoundCornerLayout)) != null) {
            try {
                this.I = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PPSRoundCornerLayout_hiad_roundCorner, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.B = new Path();
    }

    private int V(int i10, float f10) {
        float f11 = f10 * i10;
        return Z() ? (int) Math.ceil(f11) : (int) f11;
    }

    public boolean Z() {
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.I > 0.01f) {
            canvas.clipPath(this.B);
        }
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.V.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Code();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.C && layoutParams != null && layoutParams.width == -1 && layoutParams.height == -1) {
            super.onMeasure(i10, i11);
            return;
        }
        Float f10 = this.Code;
        if (f10 != null && f10.floatValue() > 0.01f) {
            int size = View.MeasureSpec.getSize(i10);
            int size2 = View.MeasureSpec.getSize(i11);
            if (View.MeasureSpec.getMode(i11) == 1073741824 || (size > 0 && size2 > 0)) {
                if ((size * 1.0f) / size2 > this.Code.floatValue()) {
                    size = V(size2, this.Code.floatValue());
                } else {
                    size2 = Code(size, this.Code.floatValue());
                }
                i12 = size2;
            } else {
                i12 = Code(size, this.Code.floatValue());
            }
            i10 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            i11 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setRatio(Float f10) {
        this.Code = f10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setRectCornerRadius(float f10) {
        this.I = f10;
        Code();
        postInvalidate();
    }

    public void setUseRatioInMatchParentMode(boolean z10) {
        this.C = z10;
    }
}
