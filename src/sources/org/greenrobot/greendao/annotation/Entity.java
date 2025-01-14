package org.greenrobot.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public @interface Entity {
    boolean active() default false;

    boolean createInDb() default true;

    boolean generateConstructors() default true;

    boolean generateGettersSetters() default true;

    Index[] indexes() default {};

    String nameInDb() default "";

    Class protobuf() default void.class;

    String schema() default "default";
}
