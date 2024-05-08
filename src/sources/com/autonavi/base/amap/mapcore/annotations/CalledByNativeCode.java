package com.autonavi.base.amap.mapcore.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public @interface CalledByNativeCode {
    String value() default "";
}