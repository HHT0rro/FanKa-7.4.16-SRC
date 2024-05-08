package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface InverseBindingAdapter {
    String attribute();

    String event() default "";
}
