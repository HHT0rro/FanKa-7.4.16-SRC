package io.flutter.util;

import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static void checkState(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z10, @Nullable Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
