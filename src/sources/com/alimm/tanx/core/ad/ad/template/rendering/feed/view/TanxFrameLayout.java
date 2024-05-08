package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxFrameLayout extends FrameLayout implements NotConfused {
    public float radio;

    public TanxFrameLayout(Context context) {
        super(context);
        this.radio = 0.56f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.radio), 1073741824));
    }

    public void setViewSize(float f10) {
        this.radio = f10;
    }

    public TanxFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radio = 0.56f;
    }

    public TanxFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.radio = 0.56f;
    }

    public TanxFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.radio = 0.56f;
    }
}
