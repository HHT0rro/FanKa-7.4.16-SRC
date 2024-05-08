package com.alibaba.security.tools.flexible.component;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.security.tools.flexible.FlexibleComponent;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ParameterComp implements IFlexibleComp {
    private static final String TAG = "ParameterComp";

    @Override // com.alibaba.security.tools.flexible.component.IFlexibleComp
    public void adaptive(View view, BigDecimal bigDecimal) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("adaptive start ... view: ");
        sb2.append((Object) view);
        sb2.append(" zoomRate: ");
        sb2.append((Object) bigDecimal);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            view.setLayoutParams(autoLayoutParameters(layoutParams, bigDecimal, view));
        }
    }

    public ViewGroup.LayoutParams autoLayoutParameters(ViewGroup.LayoutParams layoutParams, BigDecimal bigDecimal, View view) {
        int i10 = layoutParams.width;
        if (i10 > 0) {
            layoutParams.width = FlexibleComponent.INSTANCE.calculate(bigDecimal, i10);
        } else if (i10 == -10) {
            layoutParams.width = 1;
        }
        int i11 = layoutParams.height;
        if (i11 > 0) {
            layoutParams.height = FlexibleComponent.INSTANCE.calculate(bigDecimal, i11);
        } else if (i11 == -10) {
            layoutParams.height = 1;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i12 = marginLayoutParams.leftMargin;
            if (i12 > 0) {
                marginLayoutParams.leftMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i12);
            } else if (i12 == -10) {
                marginLayoutParams.leftMargin = 1;
            }
            int i13 = marginLayoutParams.rightMargin;
            if (i13 > 0) {
                marginLayoutParams.rightMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i13);
            } else if (i13 == -10) {
                marginLayoutParams.rightMargin = 1;
            }
            int i14 = marginLayoutParams.topMargin;
            if (i14 > 0) {
                marginLayoutParams.topMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i14);
            } else if (i14 == -10) {
                marginLayoutParams.topMargin = 1;
            }
            int i15 = marginLayoutParams.bottomMargin;
            if (i15 > 0) {
                marginLayoutParams.bottomMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i15);
            } else if (i15 == -10) {
                marginLayoutParams.bottomMargin = 1;
            }
        }
        return layoutParams;
    }
}
