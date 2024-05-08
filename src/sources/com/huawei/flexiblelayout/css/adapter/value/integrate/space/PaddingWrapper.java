package com.huawei.flexiblelayout.css.adapter.value.integrate.space;

import android.view.View;
import androidx.core.text.TextUtilsCompat;
import com.huawei.flexiblelayout.css.util.a;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PaddingWrapper implements ISpaceWrapper {
    private boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.space.ISpaceWrapper
    public void setSpace(View view, CSSSpaceValue cSSSpaceValue) {
        if (view == null || cSSSpaceValue == null) {
            return;
        }
        int a10 = a.a(view.getContext(), cSSSpaceValue.getLeftSpace());
        int a11 = a.a(view.getContext(), cSSSpaceValue.getRightSpace());
        int a12 = a.a(view.getContext(), cSSSpaceValue.getTopSpace());
        int a13 = a.a(view.getContext(), cSSSpaceValue.getBottomSpace());
        boolean isRTL = isRTL();
        int i10 = isRTL ? a11 : a10;
        if (!isRTL) {
            a10 = a11;
        }
        view.setPadding(i10, a12, a10, a13);
    }
}
