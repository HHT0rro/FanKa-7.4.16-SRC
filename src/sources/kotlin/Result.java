package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Result.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Result<T> implements Serializable {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final Object value;

    /* compiled from: Result.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Failure implements Serializable {

        @NotNull
        public final Throwable exception;

        public Failure(@NotNull Throwable exception) {
            s.i(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Failure) && s.d(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + ((Object) this.exception) + ')';
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m3564boximpl(Object obj) {
        return new Result(obj);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m3565constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3566equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && s.d(obj, ((Result) obj2).m3574unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3567equalsimpl0(Object obj, Object obj2) {
        return s.d(obj, obj2);
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m3568exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m3569getOrNullimpl(Object obj) {
        if (m3571isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3570hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m3571isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m3572isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3573toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m3566equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3570hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3573toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m3574unboximpl() {
        return this.value;
    }
}
