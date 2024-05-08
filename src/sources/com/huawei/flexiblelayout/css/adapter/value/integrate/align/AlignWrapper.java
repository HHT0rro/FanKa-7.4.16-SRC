package com.huawei.flexiblelayout.css.adapter.value.integrate.align;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.huawei.flexiblelayout.card.layout.BoxLayout;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AlignWrapper implements IAlignWrapper {
    /* JADX INFO: Access modifiers changed from: private */
    public void align(CSSAlignValue.CSSAlign cSSAlign, View view) {
        int gravity;
        if (cSSAlign == null || !cSSAlign.isValid()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof BoxLayout.LayoutParams) || (gravity = getGravity(cSSAlign)) == -1) {
            return;
        }
        BoxLayout.LayoutParams layoutParams2 = (BoxLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = gravity;
        view.setLayoutParams(layoutParams2);
    }

    private int getGravity(CSSAlignValue.CSSAlign cSSAlign) {
        if (cSSAlign.isHorizontalValid()) {
            int intValue = cSSAlign.getHorizontalAlign().intValue();
            return cSSAlign.isVerticalValid() ? intValue | cSSAlign.getVerticalAlign().intValue() : intValue;
        }
        if (cSSAlign.isVerticalValid()) {
            return cSSAlign.getVerticalAlign().intValue();
        }
        return -1;
    }

    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.align.IAlignWrapper
    public void setAlign(final View view, final CSSAlignValue.CSSAlign cSSAlign) {
        if (view.isAttachedToWindow()) {
            align(cSSAlign, view);
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.flexiblelayout.css.adapter.value.integrate.align.AlignWrapper.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    AlignWrapper.this.align(cSSAlign, view);
                }
            });
        }
    }
}
