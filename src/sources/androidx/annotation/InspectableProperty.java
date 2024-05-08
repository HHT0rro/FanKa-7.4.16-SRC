package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.d;

/* compiled from: InspectableProperty.kt */
@Target({ElementType.METHOD})
@d
@Retention(RetentionPolicy.SOURCE)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public @interface InspectableProperty {

    /* compiled from: InspectableProperty.kt */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @d
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public @interface EnumEntry {
        String name();

        int value();
    }

    /* compiled from: InspectableProperty.kt */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @d
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    /* compiled from: InspectableProperty.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum ValueType {
        NONE,
        INFERRED,
        INT_ENUM,
        INT_FLAG,
        COLOR,
        GRAVITY,
        RESOURCE_ID
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
