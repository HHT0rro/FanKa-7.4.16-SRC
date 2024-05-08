package com.huawei.quickcard.utils;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardValueUtil {
    public static boolean isInvalidValue(QuickCardValue quickCardValue) {
        return quickCardValue == null || QuickCardValue.EMPTY.equals(quickCardValue);
    }

    public static boolean isNotNumber(QuickCardValue quickCardValue) {
        return isInvalidValue(quickCardValue) || !quickCardValue.isNumber();
    }

    @NonNull
    public static QuickCardValue wrap(Object obj) {
        QuickCardValue wrap = QuickCardValue.wrap(obj);
        if (!wrap.isObject()) {
            return wrap;
        }
        Object wrap2 = WrapDataUtils.wrap(obj);
        return wrap2 instanceof CardDataObject ? new QuickCardValue.DataWrapperValue((CardDataObject) wrap2) : wrap;
    }
}
