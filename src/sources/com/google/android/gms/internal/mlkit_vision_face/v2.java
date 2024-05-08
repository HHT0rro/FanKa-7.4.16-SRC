package com.google.android.gms.internal.mlkit_vision_face;

import a8.c;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v2 implements a8.d<y1> {

    /* renamed from: a, reason: collision with root package name */
    public static final v2 f25255a = new v2();

    /* renamed from: b, reason: collision with root package name */
    public static final a8.c f25256b;

    /* renamed from: c, reason: collision with root package name */
    public static final a8.c f25257c;

    /* renamed from: d, reason: collision with root package name */
    public static final a8.c f25258d;

    /* renamed from: e, reason: collision with root package name */
    public static final a8.c f25259e;

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f25260f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f25261g;

    static {
        c.b a10 = a8.c.a("errorCode");
        f1 f1Var = new f1();
        f1Var.a(1);
        f25256b = a10.b(f1Var.b()).a();
        c.b a11 = a8.c.a("isColdCall");
        f1 f1Var2 = new f1();
        f1Var2.a(2);
        f25257c = a11.b(f1Var2.b()).a();
        c.b a12 = a8.c.a("imageInfo");
        f1 f1Var3 = new f1();
        f1Var3.a(3);
        f25258d = a12.b(f1Var3.b()).a();
        c.b a13 = a8.c.a("detectorOptions");
        f1 f1Var4 = new f1();
        f1Var4.a(4);
        f25259e = a13.b(f1Var4.b()).a();
        c.b a14 = a8.c.a("contourDetectedFaces");
        f1 f1Var5 = new f1();
        f1Var5.a(5);
        f25260f = a14.b(f1Var5.b()).a();
        c.b a15 = a8.c.a("nonContourDetectedFaces");
        f1 f1Var6 = new f1();
        f1Var6.a(6);
        f25261g = a15.b(f1Var6.b()).a();
    }

    @Override // a8.b
    public final /* bridge */ /* synthetic */ void a(Object obj, a8.e eVar) throws IOException {
        y1 y1Var = (y1) obj;
        a8.e eVar2 = eVar;
        eVar2.e(f25256b, y1Var.a());
        eVar2.e(f25257c, y1Var.b());
        eVar2.e(f25258d, y1Var.c());
        eVar2.e(f25259e, y1Var.d());
        eVar2.e(f25260f, y1Var.e());
        eVar2.e(f25261g, y1Var.f());
    }
}
