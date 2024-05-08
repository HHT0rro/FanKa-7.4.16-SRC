package com.koushikdutta.quack;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface QuackProperty {
    String name() default "";
}
