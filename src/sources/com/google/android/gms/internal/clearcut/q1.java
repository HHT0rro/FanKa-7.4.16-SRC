package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q1 implements s2 {

    /* renamed from: b, reason: collision with root package name */
    public static final z1 f24035b = new r1();

    /* renamed from: a, reason: collision with root package name */
    public final z1 f24036a;

    public q1() {
        this(new s1(w0.c(), c()));
    }

    public q1(z1 z1Var) {
        this.f24036a = (z1) z0.e(z1Var, "messageInfoFactory");
    }

    public static boolean b(y1 y1Var) {
        return y1Var.a() == x0.e.f24089i;
    }

    public static z1 c() {
        try {
            return (z1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f24035b;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.s2
    public final <T> r2<T> a(Class<T> cls) {
        t2.I(cls);
        y1 b4 = this.f24036a.b(cls);
        if (b4.b()) {
            return x0.class.isAssignableFrom(cls) ? f2.g(t2.B(), p0.b(), b4.c()) : f2.g(t2.z(), p0.c(), b4.c());
        }
        if (!x0.class.isAssignableFrom(cls)) {
            boolean b10 = b(b4);
            h2 a10 = j2.a();
            k1 c4 = k1.c();
            return b10 ? e2.p(cls, b4, a10, c4, t2.z(), p0.c(), x1.a()) : e2.p(cls, b4, a10, c4, t2.A(), null, x1.a());
        }
        boolean b11 = b(b4);
        h2 b12 = j2.b();
        k1 d10 = k1.d();
        i3<?, ?> B = t2.B();
        return b11 ? e2.p(cls, b4, b12, d10, B, p0.b(), x1.b()) : e2.p(cls, b4, b12, d10, B, null, x1.b());
    }
}
