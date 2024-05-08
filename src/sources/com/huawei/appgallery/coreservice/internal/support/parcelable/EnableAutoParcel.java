package com.huawei.appgallery.coreservice.internal.support.parcelable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface EnableAutoParcel {
    boolean mayNull() default false;

    Class subClass() default EnableAutoParcel.class;

    boolean useClassLoader() default false;

    int value();
}
