package com.kwad.sdk.commercial.b;

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

    public static void b(AdTemplate adTemplate, String str, String str2, int i10, int i11) {
        try {
            a(adTemplate, b.AL().cf(2).cw(str).cx(str2).ch(i10).cg(i11));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(z10 ? 0.1d : 0.01d).a(d.aS(adTemplate)).N("ad_sdk_appstore_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i10, int i11) {
        try {
            a(adTemplate, b.AL().cf(1).cw(str).cx(str2).ch(i10).cg(i11));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i10, int i11, String str3) {
        try {
            a(adTemplate, true, b.AL().cf(4).cw(str).cx(str2).ch(i10).cg(i11).setErrorCode(100006).setErrorMsg(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
