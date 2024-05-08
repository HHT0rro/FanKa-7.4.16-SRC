package com.huawei.flexiblelayout.css.adapter.type.factory;

import com.huawei.flexiblelayout.css.adapter.type.CSSPrimitive;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSPrimitiveFactory implements CSSValueFactory {
    @Override // com.huawei.flexiblelayout.css.adapter.type.factory.CSSValueFactory
    public CSSValue create(String str) {
        return new CSSPrimitive(str);
    }
}
