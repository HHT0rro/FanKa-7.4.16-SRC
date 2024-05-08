package com.google.android.gms.internal.mlkit_vision_common;

import a8.c;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k2 implements a8.d<u4> {
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
    public static final k2 f24393a = new k2();

    /* renamed from: b, reason: collision with root package name */
    public static final a8.c f24394b;

    /* renamed from: c, reason: collision with root package name */
    public static final a8.c f24395c;

    /* renamed from: d, reason: collision with root package name */
    public static final a8.c f24396d;

    /* renamed from: e, reason: collision with root package name */
    public static final a8.c f24397e;

    /* renamed from: f, reason: collision with root package name */
    public static final a8.c f24398f;

    /* renamed from: g, reason: collision with root package name */
    public static final a8.c f24399g;

    /* renamed from: h, reason: collision with root package name */
    public static final a8.c f24400h;

    /* renamed from: i, reason: collision with root package name */
    public static final a8.c f24401i;

    /* renamed from: j, reason: collision with root package name */
    public static final a8.c f24402j;

    /* renamed from: k, reason: collision with root package name */
    public static final a8.c f24403k;

    /* renamed from: l, reason: collision with root package name */
    public static final a8.c f24404l;

    /* renamed from: m, reason: collision with root package name */
    public static final a8.c f24405m;

    /* renamed from: n, reason: collision with root package name */
    public static final a8.c f24406n;

    /* renamed from: o, reason: collision with root package name */
    public static final a8.c f24407o;

    /* renamed from: p, reason: collision with root package name */
    public static final a8.c f24408p;

    /* renamed from: q, reason: collision with root package name */
    public static final a8.c f24409q;

    /* renamed from: r, reason: collision with root package name */
    public static final a8.c f24410r;

    /* renamed from: s, reason: collision with root package name */
    public static final a8.c f24411s;

    /* renamed from: t, reason: collision with root package name */
    public static final a8.c f24412t;

    /* renamed from: u, reason: collision with root package name */
    public static final a8.c f24413u;

    /* renamed from: v, reason: collision with root package name */
    public static final a8.c f24414v;

    /* renamed from: w, reason: collision with root package name */
    public static final a8.c f24415w;

    /* renamed from: x, reason: collision with root package name */
    public static final a8.c f24416x;

    /* renamed from: y, reason: collision with root package name */
    public static final a8.c f24417y;

    /* renamed from: z, reason: collision with root package name */
    public static final a8.c f24418z;

    static {
        c.b a10 = a8.c.a("systemInfo");
        h hVar = new h();
        hVar.a(1);
        f24394b = a10.b(hVar.b()).a();
        c.b a11 = a8.c.a("eventName");
        h hVar2 = new h();
        hVar2.a(2);
        f24395c = a11.b(hVar2.b()).a();
        c.b a12 = a8.c.a("isThickClient");
        h hVar3 = new h();
        hVar3.a(37);
        f24396d = a12.b(hVar3.b()).a();
        c.b a13 = a8.c.a("modelDownloadLogEvent");
        h hVar4 = new h();
        hVar4.a(3);
        f24397e = a13.b(hVar4.b()).a();
        c.b a14 = a8.c.a("customModelLoadLogEvent");
        h hVar5 = new h();
        hVar5.a(20);
        f24398f = a14.b(hVar5.b()).a();
        c.b a15 = a8.c.a("customModelInferenceLogEvent");
        h hVar6 = new h();
        hVar6.a(4);
        f24399g = a15.b(hVar6.b()).a();
        c.b a16 = a8.c.a("customModelCreateLogEvent");
        h hVar7 = new h();
        hVar7.a(29);
        f24400h = a16.b(hVar7.b()).a();
        c.b a17 = a8.c.a("onDeviceFaceDetectionLogEvent");
        h hVar8 = new h();
        hVar8.a(5);
        f24401i = a17.b(hVar8.b()).a();
        c.b a18 = a8.c.a("onDeviceTextDetectionLogEvent");
        h hVar9 = new h();
        hVar9.a(6);
        f24402j = a18.b(hVar9.b()).a();
        c.b a19 = a8.c.a("onDeviceBarcodeDetectionLogEvent");
        h hVar10 = new h();
        hVar10.a(7);
        f24403k = a19.b(hVar10.b()).a();
        c.b a20 = a8.c.a("onDeviceImageLabelCreateLogEvent");
        h hVar11 = new h();
        hVar11.a(48);
        f24404l = a20.b(hVar11.b()).a();
        c.b a21 = a8.c.a("onDeviceImageLabelLoadLogEvent");
        h hVar12 = new h();
        hVar12.a(49);
        f24405m = a21.b(hVar12.b()).a();
        c.b a22 = a8.c.a("onDeviceImageLabelDetectionLogEvent");
        h hVar13 = new h();
        hVar13.a(18);
        f24406n = a22.b(hVar13.b()).a();
        c.b a23 = a8.c.a("onDeviceObjectCreateLogEvent");
        h hVar14 = new h();
        hVar14.a(26);
        f24407o = a23.b(hVar14.b()).a();
        c.b a24 = a8.c.a("onDeviceObjectLoadLogEvent");
        h hVar15 = new h();
        hVar15.a(27);
        f24408p = a24.b(hVar15.b()).a();
        c.b a25 = a8.c.a("onDeviceObjectInferenceLogEvent");
        h hVar16 = new h();
        hVar16.a(28);
        f24409q = a25.b(hVar16.b()).a();
        c.b a26 = a8.c.a("onDevicePoseDetectionLogEvent");
        h hVar17 = new h();
        hVar17.a(44);
        f24410r = a26.b(hVar17.b()).a();
        c.b a27 = a8.c.a("onDeviceSegmentationLogEvent");
        h hVar18 = new h();
        hVar18.a(45);
        f24411s = a27.b(hVar18.b()).a();
        c.b a28 = a8.c.a("onDeviceSmartReplyLogEvent");
        h hVar19 = new h();
        hVar19.a(19);
        f24412t = a28.b(hVar19.b()).a();
        c.b a29 = a8.c.a("onDeviceLanguageIdentificationLogEvent");
        h hVar20 = new h();
        hVar20.a(21);
        f24413u = a29.b(hVar20.b()).a();
        c.b a30 = a8.c.a("onDeviceTranslationLogEvent");
        h hVar21 = new h();
        hVar21.a(22);
        f24414v = a30.b(hVar21.b()).a();
        c.b a31 = a8.c.a("cloudFaceDetectionLogEvent");
        h hVar22 = new h();
        hVar22.a(8);
        f24415w = a31.b(hVar22.b()).a();
        c.b a32 = a8.c.a("cloudCropHintDetectionLogEvent");
        h hVar23 = new h();
        hVar23.a(9);
        f24416x = a32.b(hVar23.b()).a();
        c.b a33 = a8.c.a("cloudDocumentTextDetectionLogEvent");
        h hVar24 = new h();
        hVar24.a(10);
        f24417y = a33.b(hVar24.b()).a();
        c.b a34 = a8.c.a("cloudImagePropertiesDetectionLogEvent");
        h hVar25 = new h();
        hVar25.a(11);
        f24418z = a34.b(hVar25.b()).a();
        c.b a35 = a8.c.a("cloudImageLabelDetectionLogEvent");
        h hVar26 = new h();
        hVar26.a(12);
        A = a35.b(hVar26.b()).a();
        c.b a36 = a8.c.a("cloudLandmarkDetectionLogEvent");
        h hVar27 = new h();
        hVar27.a(13);
        B = a36.b(hVar27.b()).a();
        c.b a37 = a8.c.a("cloudLogoDetectionLogEvent");
        h hVar28 = new h();
        hVar28.a(14);
        C = a37.b(hVar28.b()).a();
        c.b a38 = a8.c.a("cloudSafeSearchDetectionLogEvent");
        h hVar29 = new h();
        hVar29.a(15);
        D = a38.b(hVar29.b()).a();
        c.b a39 = a8.c.a("cloudTextDetectionLogEvent");
        h hVar30 = new h();
        hVar30.a(16);
        E = a39.b(hVar30.b()).a();
        c.b a40 = a8.c.a("cloudWebSearchDetectionLogEvent");
        h hVar31 = new h();
        hVar31.a(17);
        F = a40.b(hVar31.b()).a();
        c.b a41 = a8.c.a("automlImageLabelingCreateLogEvent");
        h hVar32 = new h();
        hVar32.a(23);
        G = a41.b(hVar32.b()).a();
        c.b a42 = a8.c.a("automlImageLabelingLoadLogEvent");
        h hVar33 = new h();
        hVar33.a(24);
        H = a42.b(hVar33.b()).a();
        c.b a43 = a8.c.a("automlImageLabelingInferenceLogEvent");
        h hVar34 = new h();
        hVar34.a(25);
        I = a43.b(hVar34.b()).a();
        c.b a44 = a8.c.a("isModelDownloadedLogEvent");
        h hVar35 = new h();
        hVar35.a(39);
        J = a44.b(hVar35.b()).a();
        c.b a45 = a8.c.a("deleteModelLogEvent");
        h hVar36 = new h();
        hVar36.a(40);
        K = a45.b(hVar36.b()).a();
        c.b a46 = a8.c.a("aggregatedAutomlImageLabelingInferenceLogEvent");
        h hVar37 = new h();
        hVar37.a(30);
        L = a46.b(hVar37.b()).a();
        c.b a47 = a8.c.a("aggregatedCustomModelInferenceLogEvent");
        h hVar38 = new h();
        hVar38.a(31);
        M = a47.b(hVar38.b()).a();
        c.b a48 = a8.c.a("aggregatedOnDeviceFaceDetectionLogEvent");
        h hVar39 = new h();
        hVar39.a(32);
        N = a48.b(hVar39.b()).a();
        c.b a49 = a8.c.a("aggregatedOnDeviceBarcodeDetectionLogEvent");
        h hVar40 = new h();
        hVar40.a(33);
        O = a49.b(hVar40.b()).a();
        c.b a50 = a8.c.a("aggregatedOnDeviceImageLabelDetectionLogEvent");
        h hVar41 = new h();
        hVar41.a(34);
        P = a50.b(hVar41.b()).a();
        c.b a51 = a8.c.a("aggregatedOnDeviceObjectInferenceLogEvent");
        h hVar42 = new h();
        hVar42.a(35);
        Q = a51.b(hVar42.b()).a();
        c.b a52 = a8.c.a("aggregatedOnDeviceTextDetectionLogEvent");
        h hVar43 = new h();
        hVar43.a(36);
        R = a52.b(hVar43.b()).a();
        c.b a53 = a8.c.a("aggregatedOnDevicePoseDetectionLogEvent");
        h hVar44 = new h();
        hVar44.a(46);
        S = a53.b(hVar44.b()).a();
        c.b a54 = a8.c.a("aggregatedOnDeviceSegmentationLogEvent");
        h hVar45 = new h();
        hVar45.a(47);
        T = a54.b(hVar45.b()).a();
        c.b a55 = a8.c.a("remoteConfigLogEvent");
        h hVar46 = new h();
        hVar46.a(42);
        U = a55.b(hVar46.b()).a();
        c.b a56 = a8.c.a("inputImageConstructionLogEvent");
        h hVar47 = new h();
        hVar47.a(50);
        V = a56.b(hVar47.b()).a();
        c.b a57 = a8.c.a("leakedHandleEvent");
        h hVar48 = new h();
        hVar48.a(51);
        W = a57.b(hVar48.b()).a();
    }

    @Override // a8.b
    public final /* bridge */ /* synthetic */ void a(Object obj, a8.e eVar) throws IOException {
        u4 u4Var = (u4) obj;
        a8.e eVar2 = eVar;
        eVar2.e(f24394b, u4Var.a());
        eVar2.e(f24395c, u4Var.b());
        eVar2.e(f24396d, null);
        eVar2.e(f24397e, null);
        eVar2.e(f24398f, null);
        eVar2.e(f24399g, null);
        eVar2.e(f24400h, null);
        eVar2.e(f24401i, null);
        eVar2.e(f24402j, null);
        eVar2.e(f24403k, null);
        eVar2.e(f24404l, null);
        eVar2.e(f24405m, null);
        eVar2.e(f24406n, null);
        eVar2.e(f24407o, null);
        eVar2.e(f24408p, null);
        eVar2.e(f24409q, null);
        eVar2.e(f24410r, null);
        eVar2.e(f24411s, null);
        eVar2.e(f24412t, null);
        eVar2.e(f24413u, null);
        eVar2.e(f24414v, null);
        eVar2.e(f24415w, null);
        eVar2.e(f24416x, null);
        eVar2.e(f24417y, null);
        eVar2.e(f24418z, null);
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
        eVar2.e(N, null);
        eVar2.e(O, null);
        eVar2.e(P, null);
        eVar2.e(Q, null);
        eVar2.e(R, null);
        eVar2.e(S, null);
        eVar2.e(T, null);
        eVar2.e(U, null);
        eVar2.e(V, u4Var.c());
        eVar2.e(W, null);
    }
}
