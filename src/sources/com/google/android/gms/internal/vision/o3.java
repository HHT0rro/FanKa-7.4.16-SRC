package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f25571a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f25572b;

    static {
        f25572b = a("org.robolectric.Robolectric") != null;
    }

    public static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b() {
        return (f25571a == null || f25572b) ? false : true;
    }

    public static Class<?> c() {
        return f25571a;
    }
}
