package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {
    public static <T> void a(T t2, Class<T> cls) {
        if (t2 != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T b(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static <T> T c(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }
}
