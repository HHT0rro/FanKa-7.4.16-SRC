package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Dimension.kt */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@d
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface Dimension {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DP = 0;
    public static final int PX = 1;
    public static final int SP = 2;

    /* compiled from: Dimension.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DP = 0;
        public static final int PX = 1;
        public static final int SP = 2;

        private Companion() {
        }
    }

    int unit() default 1;
}
