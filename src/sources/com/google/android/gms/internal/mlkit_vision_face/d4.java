package com.google.android.gms.internal.mlkit_vision_face;

import a8.c;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d4 implements a8.d<p6> {

    /* renamed from: a, reason: collision with root package name */
    public static final d4 f24807a = new d4();

    /* renamed from: b, reason: collision with root package name */
    public static final a8.c f24808b;

    /* renamed from: c, reason: collision with root package name */
    public static final a8.c f24809c;

    /* renamed from: d, reason: collision with root package name */
    public static final a8.c f24810d;

    static {
        c.b a10 = a8.c.a("imageFormat");
        f1 f1Var = new f1();
        f1Var.a(1);
        f24808b = a10.b(f1Var.b()).a();
        c.b a11 = a8.c.a("originalImageSize");
        f1 f1Var2 = new f1();
        f1Var2.a(2);
        f24809c = a11.b(f1Var2.b()).a();
        c.b a12 = a8.c.a("compressedImageSize");
        f1 f1Var3 = new f1();
        f1Var3.a(3);
        f24810d = a12.b(f1Var3.b()).a();
    }

    @Override // a8.b
    public final /* bridge */ /* synthetic */ void a(Object obj, a8.e eVar) throws IOException {
        p6 p6Var = (p6) obj;
        a8.e eVar2 = eVar;
        eVar2.e(f24808b, p6Var.a());
        eVar2.e(f24809c, p6Var.b());
        eVar2.e(f24810d, null);
    }
}
