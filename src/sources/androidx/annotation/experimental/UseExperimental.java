package androidx.annotation.experimental;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.d;

/* compiled from: UseExperimental.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.CLASS)
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface UseExperimental {
    Class<? extends Annotation>[] markerClass();
}
