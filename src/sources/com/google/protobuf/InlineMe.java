package com.google.protobuf;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
@interface InlineMe {
    String[] imports() default {};

    String replacement();

    String[] staticImports() default {};
}