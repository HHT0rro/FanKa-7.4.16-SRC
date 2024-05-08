package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.d;

/* compiled from: IntDef.kt */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface IntDef {
    boolean flag() default false;

    boolean open() default false;

    int[] value() default {};
}
