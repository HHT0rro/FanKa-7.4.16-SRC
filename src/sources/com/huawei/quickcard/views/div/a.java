package com.huawei.quickcard.views.div;

import android.view.View;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements YogaMeasureFunction {
    private int a(YogaMeasureMode yogaMeasureMode) {
        if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
            return Integer.MIN_VALUE;
        }
        return yogaMeasureMode == YogaMeasureMode.EXACTLY ? 1073741824 : 0;
    }

    @Override // com.facebook.yoga.YogaMeasureFunction
    public long measure(YogaNode yogaNode, float f10, YogaMeasureMode yogaMeasureMode, float f11, YogaMeasureMode yogaMeasureMode2) {
        Object g3 = yogaNode.g();
        View view = g3 instanceof View ? (View) g3 : null;
        if (view != null && !(view instanceof CardYogaLayout)) {
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(f10), a(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec(Math.round(f11), a(yogaMeasureMode2)));
            return YogaMeasureOutput.b(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        return YogaMeasureOutput.b(0, 0);
    }
}
