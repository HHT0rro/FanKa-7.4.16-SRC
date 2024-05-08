package com.wangmai.restrictionbypass.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public @interface RequiresApi {
    @IntRange(from = 1)
    int api() default 1;

    @IntRange(from = 1)
    int value() default 1;
}
