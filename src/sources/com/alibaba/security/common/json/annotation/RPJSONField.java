package com.alibaba.security.common.json.annotation;

import com.alibaba.security.common.json.parser.Feature;
import com.alibaba.security.common.json.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface RPJSONField {
    String[] alternateNames() default {};

    boolean deserialize() default true;

    String format() default "";

    String name() default "";

    int ordinal() default 0;

    Feature[] parseFeatures() default {};

    boolean serialize() default true;

    SerializerFeature[] serialzeFeatures() default {};
}
