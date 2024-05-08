package com.kwad.sdk.commercial.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void j(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.AQ().ck(1).cG(str).cl(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.AQ().ck(2).cG(str).cl(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.AQ().ck(4).cG(str).cl(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.AQ().ck(5).cG(str).cl(i10));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(z10 ? 0.1d : 0.01d).a(d.aS(adTemplate)).N("ad_sdk_landing_page_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, int i10, String str, String str2) {
        try {
            a(adTemplate, true, b.AQ().ck(3).cG(str).cl(i10).setErrorCode(100009).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, String str, int i11, String str2) {
        try {
            a(adTemplate, true, b.AQ().ck(6).cG(str).cl(i10).setErrorCode(i11).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
