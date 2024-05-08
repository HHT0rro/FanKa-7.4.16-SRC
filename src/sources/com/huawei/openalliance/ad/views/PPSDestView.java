package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.ads.hy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSDestView extends FrameLayout implements hy {
    public PPSDestView(Context context) {
        super(context);
    }

    public PPSDestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSDestView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }
}
