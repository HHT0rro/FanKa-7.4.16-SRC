package com.kwad.sdk.commercial.a;

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

    public static void aU(AdTemplate adTemplate) {
        a(adTemplate, b.AK().cc(3).setAdTemplate(adTemplate));
    }

    public static void aV(AdTemplate adTemplate) {
        a(adTemplate, b.AK().cc(4).setAdTemplate(adTemplate));
    }

    public static void aW(AdTemplate adTemplate) {
        a(adTemplate, b.AK().cc(5).setAdTemplate(adTemplate));
    }

    public static void aX(AdTemplate adTemplate) {
        h(adTemplate, 100002, "");
    }

    public static void aY(AdTemplate adTemplate) {
        a(adTemplate, b.AK().cc(7).cd(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate));
    }

    public static void aZ(AdTemplate adTemplate) {
        a(adTemplate, b.AK().cc(8).cd(adTemplate.mInstallApkFormUser ? 1 : 2).ce(adTemplate.mInstallApkFromSDK ? 1 : adTemplate.mClickOpenAppStore ? 2 : 0).setAdTemplate(adTemplate));
    }

    public static void ba(AdTemplate adTemplate) {
        a(adTemplate, b.AK().cc(10).ce(adTemplate.mInstallApkFromSDK ? 1 : adTemplate.mClickOpenAppStore ? 2 : 0).setAdTemplate(adTemplate));
    }

    public static void h(AdTemplate adTemplate, int i10, String str) {
        a(adTemplate, true, b.AK().cc(6).setAdTemplate(adTemplate).setErrorCode(i10).setErrorMsg(str));
    }

    public static void i(AdTemplate adTemplate, int i10, String str) {
        a(adTemplate, true, b.AK().cc(9).cd(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }

    public static void j(AdTemplate adTemplate, long j10) {
        a(adTemplate, b.AK().cc(2).ac(j10).setAdTemplate(adTemplate));
    }

    public static void o(AdTemplate adTemplate) {
        a(adTemplate, b.AK().cc(1).setAdTemplate(adTemplate));
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.AJ().cu(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.1d).a(d.aS(adTemplate)).N("ad_sdk_download_performance", "status").u(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
