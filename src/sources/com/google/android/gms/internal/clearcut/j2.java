package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j2 {

    /* renamed from: a, reason: collision with root package name */
    public static final h2 f23922a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final h2 f23923b = new i2();

    public static h2 a() {
        return f23922a;
    }

    public static h2 b() {
        return f23923b;
    }

    public static h2 c() {
        try {
            return (h2) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
