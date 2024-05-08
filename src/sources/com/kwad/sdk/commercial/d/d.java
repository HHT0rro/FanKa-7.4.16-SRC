package com.kwad.sdk.commercial.d;

import com.huawei.flexiblelayout.card.IndicatorCard;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    private static void a(SceneImpl sceneImpl, com.kwad.sdk.commercial.c.a aVar) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.d.ca(sceneImpl.getAdStyle())).N("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void b(SceneImpl sceneImpl) {
        try {
            a(sceneImpl, b.AM().cy("loadRequest").ci(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(SceneImpl sceneImpl, String str) {
        try {
            a(sceneImpl, b.AM().cy(IndicatorCard.f27798j).ci(sceneImpl.getAdNum()).cz(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, String str, String str2) {
        try {
            a(sceneImpl, b.AM().cy("requestFinish").ci(sceneImpl.getAdNum()).cz(str).cA(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, int i10) {
        try {
            a(sceneImpl, b.AM().cy("dataReady").ci(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(int i10, int i11, String str, String str2) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).i(1.0d).a(com.kwad.sdk.commercial.d.ca(i10)).N("ad_convert_method_call", "method_name").u(b.AM().cy("requestError").cz(str2).setErrorCode(com.kwad.sdk.commercial.d.cb(i11)).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
