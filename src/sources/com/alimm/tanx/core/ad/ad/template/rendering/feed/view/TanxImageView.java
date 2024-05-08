package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxImageView extends ImageView implements NotConfused {
    public float radio;

    public TanxImageView(Context context) {
        super(context);
        this.radio = 0.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int i12 = (int) (size * this.radio);
        LogUtils.d("TanxImageView", "width - >" + size + "  height -> " + i12);
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
    }

    public void setViewSize(float f10) {
        this.radio = f10;
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radio = 0.0f;
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.radio = 0.0f;
    }

    public TanxImageView(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.radio = 0.0f;
    }
}
