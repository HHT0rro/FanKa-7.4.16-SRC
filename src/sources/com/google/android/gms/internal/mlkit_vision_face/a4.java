package com.google.android.gms.internal.mlkit_vision_face;

import a8.c;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a4 implements a8.d<i6> {

    /* renamed from: a, reason: collision with root package name */
    public static final a4 f24748a = new a4();

    /* renamed from: b, reason: collision with root package name */
    public static final a8.c f24749b;

    /* renamed from: c, reason: collision with root package name */
    public static final a8.c f24750c;

    /* renamed from: d, reason: collision with root package name */
    public static final a8.c f24751d;

    /* renamed from: e, reason: collision with root package name */
    public static final a8.c f24752e;

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f24753f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f24754g;

    static {
        c.b a10 = a8.c.a("maxMs");
        f1 f1Var = new f1();
        f1Var.a(1);
        f24749b = a10.b(f1Var.b()).a();
        c.b a11 = a8.c.a("minMs");
        f1 f1Var2 = new f1();
        f1Var2.a(2);
        f24750c = a11.b(f1Var2.b()).a();
        c.b a12 = a8.c.a("avgMs");
        f1 f1Var3 = new f1();
        f1Var3.a(3);
        f24751d = a12.b(f1Var3.b()).a();
        c.b a13 = a8.c.a("firstQuartileMs");
        f1 f1Var4 = new f1();
        f1Var4.a(4);
        f24752e = a13.b(f1Var4.b()).a();
        c.b a14 = a8.c.a("medianMs");
        f1 f1Var5 = new f1();
        f1Var5.a(5);
        f24753f = a14.b(f1Var5.b()).a();
        c.b a15 = a8.c.a("thirdQuartileMs");
        f1 f1Var6 = new f1();
        f1Var6.a(6);
        f24754g = a15.b(f1Var6.b()).a();
    }

    @Override // a8.b
    public final /* bridge */ /* synthetic */ void a(Object obj, a8.e eVar) throws IOException {
        i6 i6Var = (i6) obj;
        a8.e eVar2 = eVar;
        eVar2.e(f24749b, i6Var.a());
        eVar2.e(f24750c, i6Var.b());
        eVar2.e(f24751d, i6Var.c());
        eVar2.e(f24752e, i6Var.d());
        eVar2.e(f24753f, i6Var.e());
        eVar2.e(f24754g, i6Var.f());
    }
}
