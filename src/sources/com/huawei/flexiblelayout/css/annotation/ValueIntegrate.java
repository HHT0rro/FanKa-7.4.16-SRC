package com.huawei.flexiblelayout.css.annotation;

import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSValueWrapper;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface ValueIntegrate {
    String methodName();

    String propertyTag();

    Class<? extends CSSValue> valueClass();

    Class<? extends CSSValueWrapper> valueWrapper();
}
