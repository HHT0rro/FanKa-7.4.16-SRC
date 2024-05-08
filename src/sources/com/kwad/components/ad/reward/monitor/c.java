package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c {
    public static void K(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setAdTemplate(adTemplate));
    }

    public static void L(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(8).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setAdTemplate(adTemplate));
    }

    public static void a(boolean z10, long j10) {
        com.kwad.sdk.commercial.b.a(z10, new RewardMonitorInfo().setLoadStatus(1).setPosId(j10), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void b(boolean z10, long j10) {
        com.kwad.sdk.commercial.b.a(z10, new RewardMonitorInfo().setLoadStatus(5).setPosId(j10), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void c(boolean z10, long j10) {
        com.kwad.sdk.commercial.b.a(z10, new RewardMonitorInfo().setLoadStatus(6).setPosId(j10), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void d(boolean z10, @NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.a(z10, new RewardMonitorInfo().setLoadStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void e(boolean z10, AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(6).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void f(boolean z10, AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(5).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void g(boolean z10, AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z10 ? "ad_reward" : "ad_fullscreen").setAdTemplate(adTemplate));
    }

    public static void h(boolean z10, AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void i(boolean z10, @Nullable AdTemplate adTemplate) {
        String str;
        if (adTemplate != null) {
            if (f.az(adTemplate.mDataCacheTraceElement)) {
                str = "data_cache";
            } else if (f.az(adTemplate.mDataLoadTraceElement)) {
                str = "data_load";
            }
            com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
        }
        str = "unknown";
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
    }

    private static boolean k(long j10) {
        return j10 == -1;
    }

    public static void a(boolean z10, @NonNull AdTemplate adTemplate, int i10, long j10) {
        long loadDataTime = (j10 <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j10;
        long j11 = a(loadDataTime) ? -1L : loadDataTime;
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.a(z10, new RewardMonitorInfo().setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i10).setLoadDataDuration(j11).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void b(boolean z10, AdTemplate adTemplate, int i10, long j10) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo dQ = e.dQ(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j10;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j10;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        com.kwad.sdk.commercial.b.a(z10, new RewardMonitorInfo().setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i10).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aTL);
    }

    public static void c(AdTemplate adTemplate, int i10, String str) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(9).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setErrorMsg(str).setErrorCode(i10).setAdTemplate(adTemplate));
    }

    public static void c(boolean z10, @Nullable AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z10, int i10, String str, long j10) {
        com.kwad.sdk.commercial.b.a(z10, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i10).setErrorMsg(str).setPosId(j10), com.kwai.adclient.kscommerciallogger.model.a.aTH);
    }

    public static void b(boolean z10, AdTemplate adTemplate, long j10) {
        long j11 = -1;
        if (!k(j10)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
            if (!a(elapsedRealtime)) {
                j11 = elapsedRealtime;
            }
        }
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j11).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void a(boolean z10, AdTemplate adTemplate, String str) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.b(z10, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z10, AdTemplate adTemplate, long j10) {
        a(z10, adTemplate, j10, (AdGlobalConfigInfo) null);
    }

    public static void a(boolean z10, AdTemplate adTemplate, long j10, AdGlobalConfigInfo adGlobalConfigInfo) {
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j11 = loadDataTime > 0 ? j10 - loadDataTime : 0L;
        long j12 = downloadFinishTime > 0 ? j10 - downloadFinishTime : 0L;
        int i10 = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 0;
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdSceneType(i10).setDataLoadInterval(j11).setDataDownloadInterval(j12).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    public static void b(boolean z10, AdTemplate adTemplate, String str) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(4).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setInterceptReason(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z10, String str) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z10 ? "ad_reward" : "ad_fullscreen"));
    }

    public static void a(AdTemplate adTemplate, boolean z10, String str, String str2) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z10 ? "ad_reward" : "ad_fullscreen").setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z10, String str, String str2, long j10, int i10) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z10 ? "ad_reward" : "ad_fullscreen").setDurationMs(j10).setTimeType(i10).setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(boolean z10, String str, String str2, long j10) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z10 ? "ad_reward" : "ad_fullscreen").setDurationMs(j10).setUrl(str2));
    }

    public static void a(boolean z10, @Nullable AdTemplate adTemplate, a aVar, long j10, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        com.kwad.sdk.commercial.b.e(z10, new RewardMonitorInfo().setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate).setPosId(j10));
    }

    public static void a(boolean z10, a aVar, AdTemplate adTemplate, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate);
        if (aVar2 != null) {
            aVar2.accept(adTemplate2);
        }
        com.kwad.sdk.commercial.b.d(z10, adTemplate2);
    }

    public static void a(boolean z10, AdTemplate adTemplate, long j10, int i10, long j11) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.f(z10, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j10).setErrorCode(i10).setErrorMsg(String.valueOf(j11)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(dQ)).setAdTemplate(adTemplate));
    }

    public static void a(boolean z10, @Nullable AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.c(z10, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i10, int i11, boolean z10) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.g(new RewardMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setRewardType(!z10 ? 1 : 0).setTaskType(i10).setTaskStep(i11).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setAdTemplate(adTemplate));
    }

    private static boolean a(long... jArr) {
        for (long j10 : jArr) {
            if (j10 >= 60000) {
                return true;
            }
        }
        return false;
    }
}
