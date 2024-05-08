package com.huawei.flexiblelayout.css.adapter.value.wrapper;

import com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.CSSDimensValue;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSDimensValueWrapper extends CSSValueWrapper<CSSDimensValue> {
    private static final String TAG = "CSSDimensValueWrapper";

    @Override // com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSValueWrapper
    public CSSDimensValue invoke(CSSDimensValue cSSDimensValue, Object... objArr) {
        if (cSSDimensValue == null) {
            try {
                cSSDimensValue = getValueClass().newInstance();
            } catch (Exception e2) {
                Log.w(TAG, "invoke, e: " + e2.getMessage());
            }
        }
        getValueClass().getMethod(getMethodName(), String.class).invoke(cSSDimensValue, objArr);
        return cSSDimensValue;
    }
}
