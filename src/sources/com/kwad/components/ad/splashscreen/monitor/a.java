package com.kwad.components.ad.splashscreen.monitor;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0447a {
        private static final a CS = new a();
    }

    private static SplashMonitorInfo V(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        return new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setMaterialType(com.kwad.sdk.core.response.b.a.bc(dQ) ? 1 : 2).setAdTemplate(adTemplate);
    }

    private static void c(com.kwad.sdk.commercial.c.a aVar) {
        if (k.zd().ys()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_callback", "callback_type").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        }
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (k.zd().ys()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_action", "action_type").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        }
    }

    public static a kT() {
        return C0447a.CS;
    }

    public final void W(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(2));
    }

    public final void X(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(5));
    }

    public final void Y(@NonNull AdTemplate adTemplate) {
        d(V(adTemplate).setActionType(1));
    }

    public final void l(@NonNull AdTemplate adTemplate) {
        d(V(adTemplate).setActionType(2));
    }

    public final void m(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(1));
    }

    public final void n(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(3));
    }

    public final void o(long j10) {
        c(new SplashMonitorInfo().setCallbackType(4).setPosId(j10));
    }
}
