package com.huawei.flexiblelayout.css.adapter.type.factory;

import android.text.TextUtils;
import com.huawei.flexiblelayout.css.adapter.type.CSSImage;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSImageFactory implements CSSValueFactory {
    @Override // com.huawei.flexiblelayout.css.adapter.type.factory.CSSValueFactory
    public CSSValue create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new CSSImage(str);
    }
}
