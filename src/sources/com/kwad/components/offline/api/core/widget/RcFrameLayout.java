package com.kwad.components.offline.api.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.utils.TkViewRCHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RcFrameLayout extends FrameLayout {
    private float mRatio;
    private TkViewRCHelper mViewRCHelper;
    private boolean widthBasedRatio;

    public RcFrameLayout(@NonNull Context context) {
        super(context);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    private float[] getRadius(float f10, float f11, float f12, float f13) {
        return new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TkViewRCHelper tkViewRCHelper = new TkViewRCHelper();
        this.mViewRCHelper = tkViewRCHelper;
        tkViewRCHelper.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    public boolean enableFirstVisible() {
        return true;
    }

    public boolean isWidthBasedRatio() {
        return this.widthBasedRatio;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i11 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.mRatio), 1073741824);
            } else {
                i10 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i11) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mViewRCHelper.onSizeChanged(i10, i11);
    }

    public void setRadius(float f10) {
        this.mViewRCHelper.setRadius(f10);
        postInvalidate();
    }

    public void setRatio(float f10) {
        this.mRatio = f10;
    }

    public void setWidthBasedRatio(boolean z10) {
        this.widthBasedRatio = z10;
    }

    public void setRadius(float f10, float f11, float f12, float f13) {
        this.mViewRCHelper.setRadius(getRadius(f10, f11, f12, f13));
        postInvalidate();
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }
}
