package com.huawei.flexiblelayout.css.action.value;

import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.adapter.type.factory.CSSValueFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSActionValueFactory implements CSSValueFactory {
    @Override // com.huawei.flexiblelayout.css.adapter.type.factory.CSSValueFactory
    public CSSValue create(String str) {
        return new a(str);
    }
}
