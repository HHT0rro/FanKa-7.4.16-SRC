package z7;

import java.util.Objects;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class q {
    public static void a(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T b(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static <T> T c(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    public static void d(boolean z10, String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }
}
