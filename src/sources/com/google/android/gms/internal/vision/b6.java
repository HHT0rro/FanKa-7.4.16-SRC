package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b6 {

    /* renamed from: a, reason: collision with root package name */
    public static final z5 f25441a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final z5 f25442b = new y5();

    public static z5 a() {
        return f25441a;
    }

    public static z5 b() {
        return f25442b;
    }

    public static z5 c() {
        try {
            return (z5) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
