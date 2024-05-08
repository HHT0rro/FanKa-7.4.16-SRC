package com.tencent.liteav.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public @interface UsedByReflection {
    String value();
}
