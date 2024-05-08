package com.alibaba.security.tools.flexible.component;

import android.view.View;
import com.alibaba.security.tools.flexible.FlexibleComponent;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PaddingComp implements IFlexibleComp {
    private static final String TAG = "PaddingComp";

    @Override // com.alibaba.security.tools.flexible.component.IFlexibleComp
    public void adaptive(View view, BigDecimal bigDecimal) {
        int i10;
        int i11;
        int i12;
        int i13 = 1;
        if (view.getPaddingLeft() > 0) {
            i10 = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingLeft());
        } else {
            i10 = view.getPaddingLeft() == -10 ? 1 : 0;
        }
        if (view.getPaddingTop() > 0) {
            i11 = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingTop());
        } else {
            i11 = view.getPaddingTop() == -10 ? 1 : 0;
        }
        if (view.getPaddingRight() > 0) {
            i12 = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingRight());
        } else {
            i12 = view.getPaddingRight() == -10 ? 1 : 0;
        }
        if (view.getPaddingBottom() > 0) {
            i13 = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingBottom());
        } else if (view.getPaddingBottom() != -10) {
            i13 = 0;
        }
        view.setPadding(i10, i11, i12, i13);
    }
}
