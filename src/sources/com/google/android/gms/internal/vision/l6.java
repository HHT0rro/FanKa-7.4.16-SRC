package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l6 {

    /* renamed from: a, reason: collision with root package name */
    public static final j6 f25539a = c();

    /* renamed from: b, reason: collision with root package name */
    public static final j6 f25540b = new m6();

    public static j6 a() {
        return f25539a;
    }

    public static j6 b() {
        return f25540b;
    }

    public static j6 c() {
        try {
            return (j6) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
