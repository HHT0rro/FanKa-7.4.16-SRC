package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f24050a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f24051b;

    static {
        f24051b = a("org.robolectric.Robolectric") != null;
    }

    public static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b() {
        return (f24050a == null || f24051b) ? false : true;
    }

    public static Class<?> c() {
        return f24050a;
    }
}
