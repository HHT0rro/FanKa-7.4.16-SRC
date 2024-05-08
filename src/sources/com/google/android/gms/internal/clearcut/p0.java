package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final m0<?> f23975a = new n0();

    /* renamed from: b, reason: collision with root package name */
    public static final m0<?> f23976b = a();

    public static m0<?> a() {
        try {
            return (m0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static m0<?> b() {
        return f23975a;
    }

    public static m0<?> c() {
        m0<?> m0Var = f23976b;
        if (m0Var != null) {
            return m0Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
