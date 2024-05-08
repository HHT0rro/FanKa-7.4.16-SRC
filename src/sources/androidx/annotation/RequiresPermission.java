package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.d;

/* compiled from: RequiresPermission.kt */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@d
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface RequiresPermission {

    /* compiled from: RequiresPermission.kt */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @d
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public @interface Read {
        RequiresPermission value() default @RequiresPermission;
    }

    /* compiled from: RequiresPermission.kt */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @d
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public @interface Write {
        RequiresPermission value() default @RequiresPermission;
    }

    String[] allOf() default {};

    String[] anyOf() default {};

    boolean conditional() default false;

    String value() default "";
}
