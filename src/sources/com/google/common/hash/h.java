package com.google.common.hash;

import java.nio.Buffer;

/* compiled from: Java8Compatibility.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class h {
    public static void a(Buffer buffer) {
        buffer.clear();
    }

    public static void b(Buffer buffer) {
        buffer.flip();
    }

    public static void c(Buffer buffer, int i10) {
        buffer.position(i10);
    }
}
