package com.squareup.wire;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkNotNull(Object obj, String str) {
        Objects.requireNonNull(obj, str);
    }
}
