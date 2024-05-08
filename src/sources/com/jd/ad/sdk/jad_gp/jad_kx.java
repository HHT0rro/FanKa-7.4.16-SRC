package com.jd.ad.sdk.jad_gp;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_kx {
    @NonNull
    public static <T> T jad_an(@Nullable T t2) {
        Objects.requireNonNull(t2, "Argument must not be null");
        return t2;
    }

    @NonNull
    public static <T> T jad_an(@Nullable T t2, @NonNull String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    @NonNull
    public static String jad_an(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T jad_an(@NonNull T t2) {
        if (t2.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t2;
    }

    public static void jad_an(boolean z10, @NonNull String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }
}
