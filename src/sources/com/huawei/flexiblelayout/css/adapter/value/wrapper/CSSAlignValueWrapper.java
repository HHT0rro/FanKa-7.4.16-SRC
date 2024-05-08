package com.huawei.flexiblelayout.css.adapter.value.wrapper;

import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSAlignValueWrapper extends CSSValueWrapper<CSSAlignValue> {
    private static final String TAG = "CSSAlignValueWrapper";

    @Override // com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSValueWrapper
    public CSSAlignValue invoke(CSSAlignValue cSSAlignValue, Object... objArr) {
        if (cSSAlignValue == null) {
            try {
                cSSAlignValue = getValueClass().newInstance();
            } catch (Exception e2) {
                Log.w(TAG, "invoke, e: " + e2.getMessage());
            }
        }
        getValueClass().getMethod(getMethodName(), String.class).invoke(cSSAlignValue, objArr);
        return cSSAlignValue;
    }
}
