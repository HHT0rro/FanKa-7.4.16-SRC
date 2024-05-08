package com.huawei.flexiblelayout.css.adapter.value.wrapper;

import com.huawei.flexiblelayout.css.adapter.value.integrate.space.CSSSpaceValue;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSSpaceValueWrapper extends CSSValueWrapper<CSSSpaceValue> {
    private static final String TAG = "CSSSpaceValueWrapper";

    @Override // com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSValueWrapper
    public CSSSpaceValue invoke(CSSSpaceValue cSSSpaceValue, Object... objArr) {
        if (cSSSpaceValue == null) {
            try {
                cSSSpaceValue = getValueClass().newInstance();
            } catch (Exception e2) {
                Log.w(TAG, "invoke, e: " + e2.getMessage());
            }
        }
        getValueClass().getMethod(getMethodName(), String.class).invoke(cSSSpaceValue, objArr);
        return cSSSpaceValue;
    }
}
