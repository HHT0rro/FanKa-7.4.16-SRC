package com.bytedance.sdk.openadsdk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public @interface TTC {
    String value() default "";
}