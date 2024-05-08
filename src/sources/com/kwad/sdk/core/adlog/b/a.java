package com.kwad.sdk.core.adlog.b;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, b bVar) {
        a(aVar, cVar, false, bVar);
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, b.Bp().cs(2).cx(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, true, b.Bp().cs(3).cx(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, b.Bp().cs(4).cx(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, true, b.Bp().cs(7).cx(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, boolean z10, b bVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = aVar.apr;
        AdTemplate adTemplate = aVar2.adTemplate;
        bVar.ct(aVar2.aoM).cu(aVar.retryCount).cv(aVar.apt).cZ(aVar.apu).cw(cVar.apC).setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.1d).a(com.kwad.sdk.commercial.d.aS(adTemplate)).N("ad_sdk_adlog_retry", "status").u(bVar));
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10, long j10) {
        try {
            a(aVar, cVar, true, b.Bp().cs(6).cx(i10).ae(j10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, b.Bp().cs(1).cx(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10, long j10) {
        try {
            a(aVar, cVar, b.Bp().cs(5).cx(i10).ae(j10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
