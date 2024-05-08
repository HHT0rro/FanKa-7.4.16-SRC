package com.google.common.primitives;

import com.google.common.base.o;

/* compiled from: UnsignedBytes.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {
    public static byte a(long j10) {
        o.j((j10 >> 8) == 0, "out of range: %s", j10);
        return (byte) j10;
    }

    public static int b(byte b4, byte b10) {
        return c(b4) - c(b10);
    }

    public static int c(byte b4) {
        return b4 & 255;
    }
}
