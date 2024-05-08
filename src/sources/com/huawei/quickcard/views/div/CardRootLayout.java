package com.huawei.quickcard.views.div;

import android.content.Context;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardRootLayout extends DivLayout {
    public CardRootLayout(Context context) {
        super(context);
    }

    @Override // com.huawei.quickcard.views.div.CardYogaLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        calculateYogaLayout(View.MeasureSpec.makeMeasureSpec(i12 - i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i13 - i11, 0));
        applyLayoutToView(getYogaNode(), 0.0f, 0.0f);
    }
}
