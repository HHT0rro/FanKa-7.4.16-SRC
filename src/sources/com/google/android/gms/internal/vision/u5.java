package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u5 implements v6 {

    /* renamed from: b, reason: collision with root package name */
    public static final d6 f25652b = new t5();

    /* renamed from: a, reason: collision with root package name */
    public final d6 f25653a;

    public u5() {
        this(new w5(y4.c(), b()));
    }

    public static d6 b() {
        try {
            return (d6) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f25652b;
        }
    }

    public static boolean c(a6 a6Var) {
        return a6Var.zza() == q6.f25613a;
    }

    @Override // com.google.android.gms.internal.vision.v6
    public final <T> t6<T> a(Class<T> cls) {
        u6.p(cls);
        a6 b4 = this.f25653a.b(cls);
        if (b4.zzb()) {
            if (x4.class.isAssignableFrom(cls)) {
                return i6.h(u6.B(), o4.a(), b4.zzc());
            }
            return i6.h(u6.f(), o4.b(), b4.zzc());
        }
        if (x4.class.isAssignableFrom(cls)) {
            if (c(b4)) {
                return g6.n(cls, b4, l6.b(), n5.c(), u6.B(), o4.a(), b6.b());
            }
            return g6.n(cls, b4, l6.b(), n5.c(), u6.B(), null, b6.b());
        }
        if (c(b4)) {
            return g6.n(cls, b4, l6.a(), n5.a(), u6.f(), o4.b(), b6.a());
        }
        return g6.n(cls, b4, l6.a(), n5.a(), u6.v(), null, b6.a());
    }

    public u5(d6 d6Var) {
        this.f25653a = (d6) b5.f(d6Var, "messageInfoFactory");
    }
}
