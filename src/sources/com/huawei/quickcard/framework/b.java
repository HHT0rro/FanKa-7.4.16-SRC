package com.huawei.quickcard.framework;

import android.view.View;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.QuickMethod;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ViewUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class b {
    /* JADX WARN: Multi-variable type inference failed */
    @QuickMethod
    public static void a(IComponentFunction iComponentFunction, Object obj) {
        if (iComponentFunction instanceof View) {
            View view = (View) iComponentFunction;
            QuickCardValue wrap = QuickCardValueUtil.wrap(obj);
            if (QuickCardValueUtil.isInvalidValue(wrap)) {
                ViewUtils.doFocus(view, true);
            } else if (wrap.isWrapper()) {
                ViewUtils.doFocus(view, wrap.getDataWrapper().getBooleanValue(Attributes.Event.FOCUS, true));
            }
        }
    }
}
