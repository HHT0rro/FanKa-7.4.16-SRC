package com.alibaba.security.realidentity.http.annotation;

import com.alibaba.security.realidentity.http.model.ContentType;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface Api {
    ContentType contentType() default ContentType.JSON;

    HttpMethod method();

    String name();
}
