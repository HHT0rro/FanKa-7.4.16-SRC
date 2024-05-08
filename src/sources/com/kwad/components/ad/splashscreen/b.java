package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    private static final Handler fS = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private volatile boolean Ca;

        private a() {
            this.Ca = false;
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0438b {
        private volatile boolean Cb;

        private C0438b() {
            this.Cb = false;
        }

        public static /* synthetic */ boolean a(C0438b c0438b, boolean z10) {
            c0438b.Cb = true;
            return true;
        }

        public /* synthetic */ C0438b(byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0438b c0438b, AdTemplate adTemplate, long j10, long j11, Runnable runnable) {
        if (c0438b.Cb) {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j10, j11);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        fS.removeCallbacks(runnable);
        return false;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.p(covert.getPosId());
        boolean a10 = m.re().a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b4 = 0;
        final a aVar = new a(b4);
        aVar.Ca = false;
        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(covert);
        final C0438b c0438b = new C0438b(b4);
        com.kwad.components.core.o.a.qi().qk();
        Handler handler = fS;
        handler.postDelayed(new ay() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.a(ImpInfo.this);
            }
        }, 15000L);
        final ay ayVar = new ay() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                C0438b.a(C0438b.this, true);
                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.avA;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.kV();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.avA;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
                com.kwad.components.core.o.a.qi().aD(4);
            }
        };
        int a11 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CM);
        if (a11 < 0) {
            a11 = 5000;
        }
        handler.postDelayed(ayVar, a11);
        final long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.f(covert.getPosId(), elapsedRealtime3);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0478a().e(impInfo).aI(true).aJ(a10).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i10, final String str, boolean z10) {
                if (C0438b.this.Cb) {
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    return;
                }
                b.fS.removeCallbacks(ayVar);
                if (!aVar.Ca && i10 != com.kwad.sdk.core.network.e.avy.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z10, i10, str, covert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z10, i10, str, covert.getPosId());
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        splashScreenAdListener.onError(i10, str);
                        if (i10 == com.kwad.sdk.core.network.e.avB.errorCode) {
                            com.kwad.components.core.o.a.qi().aD(0);
                        } else {
                            com.kwad.components.core.o.a.qi().aD(3);
                        }
                    }
                });
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v8, types: [com.kwad.sdk.api.KsSplashScreenAd, com.kwad.components.ad.splashscreen.KsSplashScreenAdControl] */
            /* JADX WARN: Type inference failed for: r2v9 */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull final AdResultData adResultData, boolean z10) {
                boolean z11;
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.kT().o(covert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (b.a(adResultData, aVar, this, z10, covert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    adTemplate.notNetworkRequest = z10;
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, elapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(covert, 1);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    z11 = new KsSplashScreenAdControl(covert, adResultData);
                    if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ)) {
                        try {
                            SplashPreloadManager.ky();
                            if (SplashPreloadManager.f(adResultData)) {
                                if (b.a(C0438b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, z11, adTemplate);
                                if (SplashPreloadManager.ky().e(adResultData)) {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    com.kwad.components.core.o.a.qi().aD(1);
                                    return;
                                }
                                if (SplashPreloadManager.ky().b(adResultData, true) > 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.components.core.o.a.qi().aD(2);
                                    return;
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            z11 = z10;
                            ServiceProvider.reportSdkCaughtException(th);
                            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.avD;
                            a(eVar.errorCode, eVar.msg, z11);
                        }
                    }
                    SplashPreloadManager.ky();
                    if (!SplashPreloadManager.f(adResultData)) {
                        SplashPreloadManager.ky();
                        if (!SplashPreloadManager.g(adResultData)) {
                            if (b.a(C0438b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, z11, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.o.a.qi().aD(5);
                            return;
                        }
                    }
                    boolean e2 = SplashPreloadManager.ky().e(adResultData);
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + e2);
                    if (e2) {
                        if (b.a(C0438b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, z11, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.o.a.qi().aD(1);
                        return;
                    }
                    SplashPreloadManager.ky();
                    try {
                        if (!SplashPreloadManager.f(adResultData)) {
                            if (C0438b.this.Cb) {
                                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                return;
                            }
                            b.fS.removeCallbacks(ayVar);
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                            aVar.Ca = true;
                            a(com.kwad.sdk.core.network.e.avz.errorCode, "请求成功，但缓存未命中", z10);
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                            com.kwad.components.core.o.a.qi().aD(3);
                            return;
                        }
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                        int b10 = SplashPreloadManager.ky().b(adResultData, true);
                        if (b.a(C0438b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                            return;
                        }
                        if (b10 > 0) {
                            b.a(splashScreenAdListener, z11, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.components.core.o.a.qi().aD(2);
                            return;
                        }
                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                        aVar.Ca = true;
                        com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.avB;
                        a(eVar2.errorCode, eVar2.msg, z10);
                    } catch (Throwable th2) {
                        th = th2;
                        ServiceProvider.reportSdkCaughtException(th);
                        com.kwad.sdk.core.network.e eVar3 = com.kwad.sdk.core.network.e.avD;
                        a(eVar3.errorCode, eVar3.msg, z11);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z11 = z10;
                }
            }
        }).qy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    com.kwad.components.ad.splashscreen.monitor.a.kT().X(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z10, long j10) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.c(z10, com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg, j10);
        aVar.Ca = true;
        dVar.a(com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg, z10);
        com.kwad.components.core.o.a.qi().aD(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.o.a.qi().ql();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.q(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M();
            KsAdLoadManager.a(new a.C0478a().e(impInfo2).aJ(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void a(@NonNull AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.ky().b(adResultData, false));
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                            com.kwad.components.core.o.a.qi().aE(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void onError(int i10, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i10, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                }
            }).qy());
        }
    }
}
