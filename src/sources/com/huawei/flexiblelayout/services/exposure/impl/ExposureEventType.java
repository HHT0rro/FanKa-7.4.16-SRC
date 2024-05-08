package com.huawei.flexiblelayout.services.exposure.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface ExposureEventType {
    public static final int INVISIBLE = 2;
    public static final int UNKNOWN = 0;
    public static final int VISIBLE = 1;
}
