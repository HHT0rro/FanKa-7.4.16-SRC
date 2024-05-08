package androidx.core.util;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ObjectsCompat {

    @RequiresApi(19)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static boolean equals(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        @DoNotInline
        public static int hash(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return Api19Impl.equals(obj, obj2);
    }

    public static int hash(@Nullable Object... objArr) {
        return Api19Impl.hash(objArr);
    }

    public static int hashCode(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    @Nullable
    public static String toString(@Nullable Object obj, @Nullable String str) {
        return obj != null ? obj.toString() : str;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t2, @NonNull String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }
}
