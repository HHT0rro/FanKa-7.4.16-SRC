package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RatioFrameLayout extends FrameLayout {
    private double aor;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public double getRatio() {
        return this.aor;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.aor != ShadowDrawableWrapper.COS_45) {
            int size = View.MeasureSpec.getSize(i10);
            new StringBuilder("widthSize:").append(size);
            i11 = View.MeasureSpec.makeMeasureSpec((int) (size * this.aor), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    public void setRatio(double d10) {
        this.aor = d10;
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aor = ShadowDrawableWrapper.COS_45;
    }
}
