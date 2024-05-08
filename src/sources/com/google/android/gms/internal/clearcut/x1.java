package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x1 {

    /* renamed from: a, reason: collision with root package name */
    public static final v1 f24095a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final v1 f24096b = new w1();

    public static v1 a() {
        return f24095a;
    }

    public static v1 b() {
        return f24096b;
    }

    public static v1 c() {
        try {
            return (v1) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
