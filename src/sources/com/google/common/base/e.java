package com.google.common.base;

/* compiled from: CommonPattern.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class e {
    public static e compile(String str) {
        return n.a(str);
    }

    public static boolean isPcreLike() {
        return n.f();
    }

    public abstract int flags();

    public abstract d matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();
}
