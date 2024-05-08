package com.kwad.components.ad.feed.monitor;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    public static void a(AdTemplate adTemplate, int i10, int i11, String str, String str2, long j10) {
        if (i11 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i11 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        a(new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i10).setResourceLoadDuration(j10).setMaterialType(i11).setMaterialUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate), i10 == 2);
    }

    public static void aY() {
        a("ad_sdk_feed_adnum_monitor", new FeedErrorInfo(), 1.0E-4d);
    }

    public static void aZ() {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed"));
    }

    private static void b(com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.AJ().cu(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_feed_callback", "callback_type").a(BusinessType.AD_FEED).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("reportFeedCallback", e2.toString());
        }
    }

    private static List<FeedPageInfo.a> c(List<KsFeedAd> list) {
        ArrayList arrayList = new ArrayList();
        for (KsFeedAd ksFeedAd : list) {
            if (ksFeedAd instanceof com.kwad.components.ad.feed.c) {
                AdInfo dQ = e.dQ(((com.kwad.components.ad.feed.c) ksFeedAd).getAdTemplate());
                arrayList.add(new FeedPageInfo.a().d(com.kwad.sdk.core.response.b.a.J(dQ)).u(com.kwad.sdk.core.response.b.a.be(dQ)).o(com.kwad.sdk.core.response.b.a.bb(dQ)));
            }
        }
        return arrayList;
    }

    public static void d(int i10, String str) {
        a((com.kwad.sdk.commercial.c.a) new FeedPageInfo().setStatus(9).setErrorCode(i10).setErrorMsg(str), true);
    }

    public static void e(int i10, String str) {
        a(new FeedPageInfo().setStatus(10).setLoadStatus(i10).setErrorMsg(str), i10 == 2);
    }

    public static void f(int i10, String str) {
        a("ad_sdk_feed_request_monitor", (FeedErrorInfo) new FeedErrorInfo().setErrorCode(i10).setErrorMsg(str), 1.0d);
    }

    public static void s(int i10) {
        a(new FeedPageInfo().setStatus(1).setAdNum(i10));
    }

    public static void t(int i10) {
        a(new FeedPageInfo().setStatus(2).setAdNum(i10));
    }

    public static void f(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate) {
        a(new FeedPageInfo().setStatus(11).setAdTemplate(adTemplate));
    }

    public static void b(int i10, int i11, AdTemplate adTemplate) {
        a("ad_sdk_feed_h5_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i11).setErrorCode(i10).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(AdTemplate adTemplate, int i10, int i11, long j10, String str) {
        a(new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setRenderType(i10).setLoadType(adTemplate.loadType).setExpectedRenderType(i11).setErrorMsg(str).setRenderDuration(j10).setAdTemplate(adTemplate), i10 != 2);
    }

    public static void a(int i10, long j10) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "feedLoadOptimizeType", d.Bw());
        t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.Bz());
        t.putValue(jSONObject, "isExternal", k.zd().yp());
        a(new FeedPageInfo().setStatus(6).setAdNum(i10).setLoadDataDuration(j10).setAbParams(jSONObject.toString()));
    }

    public static void a(AdTemplate adTemplate, int i10, int i11) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "feedLoadOptimizeType", d.Bw());
        t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.Bz());
        t.putValue(jSONObject, "isExternal", k.zd().yp());
        a(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setLoadType(adTemplate.loadType).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setRenderType(i10).setExpectedRenderType(i11).setAbParams(jSONObject.toString()).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i10, long j10) {
        a(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setRenderType(i10).setConvertDuration(j10).setAdTemplate(adTemplate));
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar) {
        a(aVar, false);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z10) {
        try {
            com.kwad.sdk.commercial.b.d(c.AJ().cu(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.001d).N("ad_sdk_feed_load", "status").a(BusinessType.AD_FEED).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("reportFeedPageLineLog", e2.toString());
        }
    }

    public static void a(int i10, AdTemplate adTemplate, String str, int i11) {
        b(new FeedPageInfo().setCallbackType(i10).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setMaterialUrl(str).setRenderType(i11).setAdTemplate(adTemplate));
    }

    public static void a(long j10, List<KsFeedAd> list) {
        if (list == null || list.size() == 0 || !(list.get(0) instanceof com.kwad.components.ad.feed.c)) {
            return;
        }
        b(new FeedPageInfo().setCallbackType(1).setPosId(j10).setMaterialInfoList(c(list)).setAdTemplate(((com.kwad.components.ad.feed.c) list.get(0)).getAdTemplate()));
    }

    private static void a(String str, FeedErrorInfo feedErrorInfo, double d10) {
        try {
            com.kwad.sdk.commercial.b.d(c.AJ().cu(ILoggerReporter.Category.ERROR_LOG).a(BusinessType.AD_FEED).N(str, "default").cv(str).a(com.kwai.adclient.kscommerciallogger.model.a.aTL).u(feedErrorInfo).i(d10));
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.d("reportFeedError", e2.toString());
        }
    }

    public static void a(int i10, int i11, AdTemplate adTemplate) {
        a("ad_sdk_feed_showType_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i10).setFeedType(i11).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(long j10, int i10, int i11, AdTemplate adTemplate) {
        a("ad_sdk_feed_width_monitor", (FeedErrorInfo) new FeedErrorInfo().setWidth(j10).setMaterialType(i10).setFeedType(i11).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j10, int i10) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i10).setDurationMs(j10).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j10) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j10).setUrl(str).setAdTemplate(adTemplate));
    }
}
