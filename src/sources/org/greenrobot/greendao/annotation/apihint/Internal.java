package org.greenrobot.greendao.annotation.apihint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Internal
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public @interface Internal {
}