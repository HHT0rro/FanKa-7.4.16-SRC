package com.huawei.flexiblelayout.css.adapter.value.integrate.fullSpan;

import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FullSpanWrapper implements IFullSpanWrapper {
    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.fullSpan.IFullSpanWrapper
    public void setFullSpan(ViewGroup viewGroup, boolean z10) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(layoutParams2);
        }
        layoutParams.setFullSpan(z10);
        viewGroup.setLayoutParams(layoutParams);
    }
}
