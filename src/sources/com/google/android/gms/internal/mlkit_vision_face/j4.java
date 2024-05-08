package com.google.android.gms.internal.mlkit_vision_face;

import a8.c;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j4 implements a8.d<z6> {
    public static final a8.c A;
    public static final a8.c B;
    public static final a8.c C;
    public static final a8.c D;
    public static final a8.c E;
    public static final a8.c F;
    public static final a8.c G;
    public static final a8.c H;
    public static final a8.c I;
    public static final a8.c J;
    public static final a8.c K;
    public static final a8.c L;
    public static final a8.c M;
    public static final a8.c N;
    public static final a8.c O;
    public static final a8.c P;
    public static final a8.c Q;
    public static final a8.c R;
    public static final a8.c S;
    public static final a8.c T;
    public static final a8.c U;
    public static final a8.c V;
    public static final a8.c W;

    /* renamed from: a, reason: collision with root package name */
    public static final j4 f24957a = new j4();

    /* renamed from: b, reason: collision with root package name */
    public static final a8.c f24958b;

    /* renamed from: c, reason: collision with root package name */
    public static final a8.c f24959c;

    /* renamed from: d, reason: collision with root package name */
    public static final a8.c f24960d;

    /* renamed from: e, reason: collision with root package name */
    public static final a8.c f24961e;

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f24962f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f24963g;

    /* renamed from: h, reason: collision with root package name */
    public static final a8.c f24964h;

    /* renamed from: i, reason: collision with root package name */
    public static final a8.c f24965i;

    /* renamed from: j, reason: collision with root package name */
    public static final a8.c f24966j;

    /* renamed from: k, reason: collision with root package name */
    public static final a8.c f24967k;

    /* renamed from: l, reason: collision with root package name */
    public static final a8.c f24968l;

    /* renamed from: m, reason: collision with root package name */
    public static final a8.c f24969m;

    /* renamed from: n, reason: collision with root package name */
    public static final a8.c f24970n;

    /* renamed from: o, reason: collision with root package name */
    public static final a8.c f24971o;

    /* renamed from: p, reason: collision with root package name */
    public static final a8.c f24972p;

    /* renamed from: q, reason: collision with root package name */
    public static final a8.c f24973q;

    /* renamed from: r, reason: collision with root package name */
    public static final a8.c f24974r;

    /* renamed from: s, reason: collision with root package name */
    public static final a8.c f24975s;

    /* renamed from: t, reason: collision with root package name */
    public static final a8.c f24976t;

    /* renamed from: u, reason: collision with root package name */
    public static final a8.c f24977u;

    /* renamed from: v, reason: collision with root package name */
    public static final a8.c f24978v;

    /* renamed from: w, reason: collision with root package name */
    public static final a8.c f24979w;

    /* renamed from: x, reason: collision with root package name */
    public static final a8.c f24980x;

    /* renamed from: y, reason: collision with root package name */
    public static final a8.c f24981y;

    /* renamed from: z, reason: collision with root package name */
    public static final a8.c f24982z;

    static {
        c.b a10 = a8.c.a("systemInfo");
        f1 f1Var = new f1();
        f1Var.a(1);
        f24958b = a10.b(f1Var.b()).a();
        c.b a11 = a8.c.a("eventName");
        f1 f1Var2 = new f1();
        f1Var2.a(2);
        f24959c = a11.b(f1Var2.b()).a();
        c.b a12 = a8.c.a("isThickClient");
        f1 f1Var3 = new f1();
        f1Var3.a(37);
        f24960d = a12.b(f1Var3.b()).a();
        c.b a13 = a8.c.a("modelDownloadLogEvent");
        f1 f1Var4 = new f1();
        f1Var4.a(3);
        f24961e = a13.b(f1Var4.b()).a();
        c.b a14 = a8.c.a("customModelLoadLogEvent");
        f1 f1Var5 = new f1();
        f1Var5.a(20);
        f24962f = a14.b(f1Var5.b()).a();
        c.b a15 = a8.c.a("customModelInferenceLogEvent");
        f1 f1Var6 = new f1();
        f1Var6.a(4);
        f24963g = a15.b(f1Var6.b()).a();
        c.b a16 = a8.c.a("customModelCreateLogEvent");
        f1 f1Var7 = new f1();
        f1Var7.a(29);
        f24964h = a16.b(f1Var7.b()).a();
        c.b a17 = a8.c.a("onDeviceFaceDetectionLogEvent");
        f1 f1Var8 = new f1();
        f1Var8.a(5);
        f24965i = a17.b(f1Var8.b()).a();
        c.b a18 = a8.c.a("onDeviceTextDetectionLogEvent");
        f1 f1Var9 = new f1();
        f1Var9.a(6);
        f24966j = a18.b(f1Var9.b()).a();
        c.b a19 = a8.c.a("onDeviceBarcodeDetectionLogEvent");
        f1 f1Var10 = new f1();
        f1Var10.a(7);
        f24967k = a19.b(f1Var10.b()).a();
        c.b a20 = a8.c.a("onDeviceImageLabelCreateLogEvent");
        f1 f1Var11 = new f1();
        f1Var11.a(48);
        f24968l = a20.b(f1Var11.b()).a();
        c.b a21 = a8.c.a("onDeviceImageLabelLoadLogEvent");
        f1 f1Var12 = new f1();
        f1Var12.a(49);
        f24969m = a21.b(f1Var12.b()).a();
        c.b a22 = a8.c.a("onDeviceImageLabelDetectionLogEvent");
        f1 f1Var13 = new f1();
        f1Var13.a(18);
        f24970n = a22.b(f1Var13.b()).a();
        c.b a23 = a8.c.a("onDeviceObjectCreateLogEvent");
        f1 f1Var14 = new f1();
        f1Var14.a(26);
        f24971o = a23.b(f1Var14.b()).a();
        c.b a24 = a8.c.a("onDeviceObjectLoadLogEvent");
        f1 f1Var15 = new f1();
        f1Var15.a(27);
        f24972p = a24.b(f1Var15.b()).a();
        c.b a25 = a8.c.a("onDeviceObjectInferenceLogEvent");
        f1 f1Var16 = new f1();
        f1Var16.a(28);
        f24973q = a25.b(f1Var16.b()).a();
        c.b a26 = a8.c.a("onDevicePoseDetectionLogEvent");
        f1 f1Var17 = new f1();
        f1Var17.a(44);
        f24974r = a26.b(f1Var17.b()).a();
        c.b a27 = a8.c.a("onDeviceSegmentationLogEvent");
        f1 f1Var18 = new f1();
        f1Var18.a(45);
        f24975s = a27.b(f1Var18.b()).a();
        c.b a28 = a8.c.a("onDeviceSmartReplyLogEvent");
        f1 f1Var19 = new f1();
        f1Var19.a(19);
        f24976t = a28.b(f1Var19.b()).a();
        c.b a29 = a8.c.a("onDeviceLanguageIdentificationLogEvent");
        f1 f1Var20 = new f1();
        f1Var20.a(21);
        f24977u = a29.b(f1Var20.b()).a();
        c.b a30 = a8.c.a("onDeviceTranslationLogEvent");
        f1 f1Var21 = new f1();
        f1Var21.a(22);
        f24978v = a30.b(f1Var21.b()).a();
        c.b a31 = a8.c.a("cloudFaceDetectionLogEvent");
        f1 f1Var22 = new f1();
        f1Var22.a(8);
        f24979w = a31.b(f1Var22.b()).a();
        c.b a32 = a8.c.a("cloudCropHintDetectionLogEvent");
        f1 f1Var23 = new f1();
        f1Var23.a(9);
        f24980x = a32.b(f1Var23.b()).a();
        c.b a33 = a8.c.a("cloudDocumentTextDetectionLogEvent");
        f1 f1Var24 = new f1();
        f1Var24.a(10);
        f24981y = a33.b(f1Var24.b()).a();
        c.b a34 = a8.c.a("cloudImagePropertiesDetectionLogEvent");
        f1 f1Var25 = new f1();
        f1Var25.a(11);
        f24982z = a34.b(f1Var25.b()).a();
        c.b a35 = a8.c.a("cloudImageLabelDetectionLogEvent");
        f1 f1Var26 = new f1();
        f1Var26.a(12);
        A = a35.b(f1Var26.b()).a();
        c.b a36 = a8.c.a("cloudLandmarkDetectionLogEvent");
        f1 f1Var27 = new f1();
        f1Var27.a(13);
        B = a36.b(f1Var27.b()).a();
        c.b a37 = a8.c.a("cloudLogoDetectionLogEvent");
        f1 f1Var28 = new f1();
        f1Var28.a(14);
        C = a37.b(f1Var28.b()).a();
        c.b a38 = a8.c.a("cloudSafeSearchDetectionLogEvent");
        f1 f1Var29 = new f1();
        f1Var29.a(15);
        D = a38.b(f1Var29.b()).a();
        c.b a39 = a8.c.a("cloudTextDetectionLogEvent");
        f1 f1Var30 = new f1();
        f1Var30.a(16);
        E = a39.b(f1Var30.b()).a();
        c.b a40 = a8.c.a("cloudWebSearchDetectionLogEvent");
        f1 f1Var31 = new f1();
        f1Var31.a(17);
        F = a40.b(f1Var31.b()).a();
        c.b a41 = a8.c.a("automlImageLabelingCreateLogEvent");
        f1 f1Var32 = new f1();
        f1Var32.a(23);
        G = a41.b(f1Var32.b()).a();
        c.b a42 = a8.c.a("automlImageLabelingLoadLogEvent");
        f1 f1Var33 = new f1();
        f1Var33.a(24);
        H = a42.b(f1Var33.b()).a();
        c.b a43 = a8.c.a("automlImageLabelingInferenceLogEvent");
        f1 f1Var34 = new f1();
        f1Var34.a(25);
        I = a43.b(f1Var34.b()).a();
        c.b a44 = a8.c.a("isModelDownloadedLogEvent");
        f1 f1Var35 = new f1();
        f1Var35.a(39);
        J = a44.b(f1Var35.b()).a();
        c.b a45 = a8.c.a("deleteModelLogEvent");
        f1 f1Var36 = new f1();
        f1Var36.a(40);
        K = a45.b(f1Var36.b()).a();
        c.b a46 = a8.c.a("aggregatedAutomlImageLabelingInferenceLogEvent");
        f1 f1Var37 = new f1();
        f1Var37.a(30);
        L = a46.b(f1Var37.b()).a();
        c.b a47 = a8.c.a("aggregatedCustomModelInferenceLogEvent");
        f1 f1Var38 = new f1();
        f1Var38.a(31);
        M = a47.b(f1Var38.b()).a();
        c.b a48 = a8.c.a("aggregatedOnDeviceFaceDetectionLogEvent");
        f1 f1Var39 = new f1();
        f1Var39.a(32);
        N = a48.b(f1Var39.b()).a();
        c.b a49 = a8.c.a("aggregatedOnDeviceBarcodeDetectionLogEvent");
        f1 f1Var40 = new f1();
        f1Var40.a(33);
        O = a49.b(f1Var40.b()).a();
        c.b a50 = a8.c.a("aggregatedOnDeviceImageLabelDetectionLogEvent");
        f1 f1Var41 = new f1();
        f1Var41.a(34);
        P = a50.b(f1Var41.b()).a();
        c.b a51 = a8.c.a("aggregatedOnDeviceObjectInferenceLogEvent");
        f1 f1Var42 = new f1();
        f1Var42.a(35);
        Q = a51.b(f1Var42.b()).a();
        c.b a52 = a8.c.a("aggregatedOnDeviceTextDetectionLogEvent");
        f1 f1Var43 = new f1();
        f1Var43.a(36);
        R = a52.b(f1Var43.b()).a();
        c.b a53 = a8.c.a("aggregatedOnDevicePoseDetectionLogEvent");
        f1 f1Var44 = new f1();
        f1Var44.a(46);
        S = a53.b(f1Var44.b()).a();
        c.b a54 = a8.c.a("aggregatedOnDeviceSegmentationLogEvent");
        f1 f1Var45 = new f1();
        f1Var45.a(47);
        T = a54.b(f1Var45.b()).a();
        c.b a55 = a8.c.a("remoteConfigLogEvent");
        f1 f1Var46 = new f1();
        f1Var46.a(42);
        U = a55.b(f1Var46.b()).a();
        c.b a56 = a8.c.a("inputImageConstructionLogEvent");
        f1 f1Var47 = new f1();
        f1Var47.a(50);
        V = a56.b(f1Var47.b()).a();
        c.b a57 = a8.c.a("leakedHandleEvent");
        f1 f1Var48 = new f1();
        f1Var48.a(51);
        W = a57.b(f1Var48.b()).a();
    }

    @Override // a8.b
    public final /* bridge */ /* synthetic */ void a(Object obj, a8.e eVar) throws IOException {
        z6 z6Var = (z6) obj;
        a8.e eVar2 = eVar;
        eVar2.e(f24958b, z6Var.a());
        eVar2.e(f24959c, z6Var.b());
        eVar2.e(f24960d, z6Var.c());
        eVar2.e(f24961e, null);
        eVar2.e(f24962f, null);
        eVar2.e(f24963g, null);
        eVar2.e(f24964h, null);
        eVar2.e(f24965i, z6Var.d());
        eVar2.e(f24966j, null);
        eVar2.e(f24967k, null);
        eVar2.e(f24968l, null);
        eVar2.e(f24969m, null);
        eVar2.e(f24970n, null);
        eVar2.e(f24971o, null);
        eVar2.e(f24972p, null);
        eVar2.e(f24973q, null);
        eVar2.e(f24974r, null);
        eVar2.e(f24975s, null);
        eVar2.e(f24976t, null);
        eVar2.e(f24977u, null);
        eVar2.e(f24978v, null);
        eVar2.e(f24979w, null);
        eVar2.e(f24980x, null);
        eVar2.e(f24981y, null);
        eVar2.e(f24982z, null);
        eVar2.e(A, null);
        eVar2.e(B, null);
        eVar2.e(C, null);
        eVar2.e(D, null);
        eVar2.e(E, null);
        eVar2.e(F, null);
        eVar2.e(G, null);
        eVar2.e(H, null);
        eVar2.e(I, null);
        eVar2.e(J, null);
        eVar2.e(K, null);
        eVar2.e(L, null);
        eVar2.e(M, null);
        eVar2.e(N, z6Var.e());
        eVar2.e(O, null);
        eVar2.e(P, null);
        eVar2.e(Q, null);
        eVar2.e(R, null);
        eVar2.e(S, null);
        eVar2.e(T, null);
        eVar2.e(U, null);
        eVar2.e(V, null);
        eVar2.e(W, null);
    }
}
