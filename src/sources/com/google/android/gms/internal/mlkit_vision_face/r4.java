package com.google.android.gms.internal.mlkit_vision_face;

import a8.c;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r4 implements a8.d<i7> {

    /* renamed from: a, reason: collision with root package name */
    public static final r4 f25174a = new r4();

    /* renamed from: b, reason: collision with root package name */
    public static final a8.c f25175b;

    /* renamed from: c, reason: collision with root package name */
    public static final a8.c f25176c;

    /* renamed from: d, reason: collision with root package name */
    public static final a8.c f25177d;

    /* renamed from: e, reason: collision with root package name */
    public static final a8.c f25178e;

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f25179f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f25180g;

    static {
        c.b a10 = a8.c.a("inferenceCommonLogEvent");
        f1 f1Var = new f1();
        f1Var.a(1);
        f25175b = a10.b(f1Var.b()).a();
        c.b a11 = a8.c.a(QuickCardBean.Field.OPTIONS);
        f1 f1Var2 = new f1();
        f1Var2.a(2);
        f25176c = a11.b(f1Var2.b()).a();
        c.b a12 = a8.c.a("imageInfo");
        f1 f1Var3 = new f1();
        f1Var3.a(3);
        f25177d = a12.b(f1Var3.b()).a();
        c.b a13 = a8.c.a("detectorOptions");
        f1 f1Var4 = new f1();
        f1Var4.a(4);
        f25178e = a13.b(f1Var4.b()).a();
        c.b a14 = a8.c.a("contourDetectedFaces");
        f1 f1Var5 = new f1();
        f1Var5.a(5);
        f25179f = a14.b(f1Var5.b()).a();
        c.b a15 = a8.c.a("nonContourDetectedFaces");
        f1 f1Var6 = new f1();
        f1Var6.a(6);
        f25180g = a15.b(f1Var6.b()).a();
    }

    @Override // a8.b
    public final /* bridge */ /* synthetic */ void a(Object obj, a8.e eVar) throws IOException {
        i7 i7Var = (i7) obj;
        a8.e eVar2 = eVar;
        eVar2.e(f25175b, i7Var.a());
        eVar2.e(f25176c, null);
        eVar2.e(f25177d, i7Var.b());
        eVar2.e(f25178e, i7Var.c());
        eVar2.e(f25179f, i7Var.d());
        eVar2.e(f25180g, i7Var.e());
    }
}
