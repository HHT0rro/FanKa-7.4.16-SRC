package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o4 {

    /* renamed from: a, reason: collision with root package name */
    public static final n4<?> f25573a = new m4();

    /* renamed from: b, reason: collision with root package name */
    public static final n4<?> f25574b = c();

    public static n4<?> a() {
        return f25573a;
    }

    public static n4<?> b() {
        n4<?> n4Var = f25574b;
        if (n4Var != null) {
            return n4Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static n4<?> c() {
        try {
            return (n4) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
