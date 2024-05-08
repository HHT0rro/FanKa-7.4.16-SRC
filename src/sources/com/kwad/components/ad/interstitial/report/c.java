package com.kwad.components.ad.interstitial.report;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static final c ls = new c();
    }

    private static void a(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        if (k.zd().ys()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.01d).N("ad_sdk_interstitial_load", "status").a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        }
    }

    public static c dQ() {
        return a.ls;
    }

    public final void b(@NonNull AdTemplate adTemplate, boolean z10) {
        adTemplate.notNetworkRequest = z10;
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setAdTemplate(adTemplate));
    }

    public final void i(long j10) {
        a(false, new InterstitialReportInfo().setStatus(1).setPosId(j10));
    }

    public final void p(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(6).setAdTemplate(adTemplate));
    }

    public final void q(AdTemplate adTemplate) {
        try {
            a(false, new InterstitialReportInfo(adTemplate).setStatus(8).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void r(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(10).setAdTemplate(adTemplate));
    }

    public final void s(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(7).setAdTemplate(adTemplate));
    }

    public final void t(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(12).setRenderType(com.kwad.sdk.core.response.b.b.cS(adTemplate) ? 3 : 1).setAdTemplate(adTemplate));
    }

    public final void u(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(11).setRenderType(1).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, int i10, String str) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(9).setErrorCode(i10).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, boolean z10) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(2).setType(z10 ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, int i10) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setRenderDuration(SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp).setRenderType(i10).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(int i10, String str, long j10) {
        a(true, new InterstitialReportInfo().setStatus(5).setErrorCode(i10).setErrorMsg(str).setPosId(j10));
    }
}
