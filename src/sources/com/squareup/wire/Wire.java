package com.squareup.wire;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Wire {
    private Wire() {
    }

    public static <T> T get(T t2, T t10) {
        return t2 != null ? t2 : t10;
    }
}
