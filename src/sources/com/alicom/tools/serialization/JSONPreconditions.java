package com.alicom.tools.serialization;

import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class JSONPreconditions {
    private JSONPreconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }
}
