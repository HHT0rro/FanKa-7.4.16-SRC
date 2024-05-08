package com.huawei.quickcard.framework;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.text.utils.SpannableUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class d {
    @NonNull
    public static QuickCardValue a(IVirtualView iVirtualView, String str, Object obj) {
        QuickCardValue wrap = QuickCardValue.wrap(obj);
        return wrap.isExpression() ? wrap : SpannableUtils.wrapQuickcardValue(str, obj);
    }
}
