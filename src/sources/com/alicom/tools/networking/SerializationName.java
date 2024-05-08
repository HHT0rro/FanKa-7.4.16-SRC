package com.alicom.tools.networking;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface SerializationName {
    String[] alternate() default {};

    String value();
}
