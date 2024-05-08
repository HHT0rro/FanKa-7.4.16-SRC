package com.kwad.sdk.commercial.i;

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

    public static void b(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            a(adTemplate, b.AT().cm(2).cK(str).cJ(str2).cI(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            a(adTemplate, b.AT().cm(3).cK(str).cJ(str2).cI(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(z10 ? 0.1d : 0.01d).a(d.aS(adTemplate)).N("ad_sdk_small_app_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            a(adTemplate, b.AT().cm(1).cK(str).cJ(str2).cI(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            a(adTemplate, true, b.AT().cm(4).cK(str).cJ(str2).cI(str3).setErrorCode(100008).setErrorMsg(str4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
