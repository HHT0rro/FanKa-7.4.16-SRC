package com.google.android.gms.internal.mlkit_vision_face;

import a8.c;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b4 implements a8.d<m6> {

    /* renamed from: a, reason: collision with root package name */
    public static final b4 f24764a = new b4();

    /* renamed from: b, reason: collision with root package name */
    public static final a8.c f24765b;

    /* renamed from: c, reason: collision with root package name */
    public static final a8.c f24766c;

    /* renamed from: d, reason: collision with root package name */
    public static final a8.c f24767d;

    /* renamed from: e, reason: collision with root package name */
    public static final a8.c f24768e;

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f24769f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f24770g;

    static {
        c.b a10 = a8.c.a("landmarkMode");
        f1 f1Var = new f1();
        f1Var.a(1);
        f24765b = a10.b(f1Var.b()).a();
        c.b a11 = a8.c.a("classificationMode");
        f1 f1Var2 = new f1();
        f1Var2.a(2);
        f24766c = a11.b(f1Var2.b()).a();
        c.b a12 = a8.c.a("performanceMode");
        f1 f1Var3 = new f1();
        f1Var3.a(3);
        f24767d = a12.b(f1Var3.b()).a();
        c.b a13 = a8.c.a("contourMode");
        f1 f1Var4 = new f1();
        f1Var4.a(4);
        f24768e = a13.b(f1Var4.b()).a();
        c.b a14 = a8.c.a("isTrackingEnabled");
        f1 f1Var5 = new f1();
        f1Var5.a(5);
        f24769f = a14.b(f1Var5.b()).a();
        c.b a15 = a8.c.a("minFaceSize");
        f1 f1Var6 = new f1();
        f1Var6.a(6);
        f24770g = a15.b(f1Var6.b()).a();
    }

    @Override // a8.b
    public final /* bridge */ /* synthetic */ void a(Object obj, a8.e eVar) throws IOException {
        m6 m6Var = (m6) obj;
        a8.e eVar2 = eVar;
        eVar2.e(f24765b, m6Var.a());
        eVar2.e(f24766c, m6Var.b());
        eVar2.e(f24767d, m6Var.c());
        eVar2.e(f24768e, m6Var.d());
        eVar2.e(f24769f, m6Var.e());
        eVar2.e(f24770g, m6Var.f());
    }
}
