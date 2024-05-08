package com.huawei.flexiblelayout.css.adapter.value.integrate.space;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.css.util.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MarginWrapper implements ISpaceWrapper {
    private void fillMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        } else if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.setMargins(i10, i11, i12, i13);
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.space.ISpaceWrapper
    public void setSpace(View view, CSSSpaceValue cSSSpaceValue) {
        if (view == null || cSSSpaceValue == null) {
            return;
        }
        fillMargins(view, a.a(view.getContext(), cSSSpaceValue.getLeftSpace()), a.a(view.getContext(), cSSSpaceValue.getTopSpace()), a.a(view.getContext(), cSSSpaceValue.getRightSpace()), a.a(view.getContext(), cSSSpaceValue.getBottomSpace()));
    }
}
