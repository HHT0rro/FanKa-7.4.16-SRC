package com.huawei.flexiblelayout.css.annotation;

import com.huawei.flexiblelayout.css.adapter.type.factory.CSSValueFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface ValueFactory {
    Class<? extends CSSValueFactory> value();
}
