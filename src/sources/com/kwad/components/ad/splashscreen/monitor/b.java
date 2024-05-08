package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private static volatile b CU;

    private static StyleTemplate S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dr(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k10 != null) {
            styleTemplate.templateId = k10.templateId;
            styleTemplate.templateMd5 = k10.templateMd5;
            styleTemplate.templateUrl = k10.templateUrl;
            styleTemplate.templateVersionCode = (int) k10.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void Z(@NonNull AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(1).setType(com.kwad.sdk.core.response.b.a.bd(e.dQ(adTemplate)) ? 2 : 1).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, int i10, long j10, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i10).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j11).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CQ) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(e.dQ(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void aa(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(4).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setType(com.kwad.sdk.core.response.b.a.bd(dQ) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ab(@Nullable AdTemplate adTemplate) {
        String str;
        boolean z10;
        int i10;
        AdMatrixInfo.SplashPlayCardTKInfo dd2 = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        boolean z11 = true;
        if (TextUtils.isEmpty(dd2.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z10 = true;
        } else {
            str = "";
            z10 = false;
        }
        if (dd2.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i10 = dd2.renderType;
        } else {
            i10 = -1;
            z11 = z10;
        }
        if (z11) {
            com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i10).setAdTemplate(adTemplate));
        }
    }

    public static void ac(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3001).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setUrl(com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl).setAdTemplate(adTemplate));
    }

    public static void ad(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3002).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setUrl(com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl).setAdTemplate(adTemplate));
    }

    public static void ae(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3003).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setUrl(com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i10, long j10, long j11) {
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        AdInfo dQ = e.dQ(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(dQ)) {
            str = com.kwad.sdk.core.response.b.a.K(dQ);
        } else {
            str = com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl;
        }
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i10).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j11).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void c(boolean z10, int i10, String str, long j10) {
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setStatus(4).setType(z10 ? 2 : 1).setErrorCode(i10).setErrorMsg(str).setPosId(j10));
    }

    public static void d(@NonNull AdTemplate adTemplate, long j10) {
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j10).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CQ) ? 1L : 2L).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(e.dQ(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, long j10) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(5).setType(com.kwad.sdk.core.response.b.a.bd(dQ) ? 2 : 1).setCostTime(j10).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setAdTemplate(adTemplate));
    }

    public static void f(long j10, long j11) {
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j11).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CQ) ? 1L : 2L).setPosId(j10));
    }

    public static void h(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.J(e.dQ(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.b.a.aZ(e.dQ(adTemplate)));
        }
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setPosId(adResultData.getPosId()));
    }

    public static b kV() {
        if (CU == null) {
            synchronized (b.class) {
                if (CU == null) {
                    CU = new b();
                }
            }
        }
        return CU;
    }

    public static void p(long j10) {
        com.kwad.sdk.commercial.b.h(new SplashMonitorInfo().setStatus(1).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CQ) ? 1L : 2L).setPosId(j10));
    }

    public static void q(long j10) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(1).setPosId(j10));
    }

    public static void f(@NonNull AdTemplate adTemplate, long j10) {
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(2).setType(com.kwad.sdk.core.response.b.a.bd(dQ) ? 2 : 1).setCostTime(j10).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.CQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long dl;
        StyleTemplate S = S(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.b.b.df(adTemplate)).setTemplateId(S.templateId).setTemplateVersionCode(S.templateVersionCode);
        e.dQ(adTemplate);
        if (h.U(adTemplate)) {
            dl = com.kwad.sdk.core.response.b.b.de(adTemplate);
        } else {
            dl = com.kwad.sdk.core.response.b.b.dl(e.dQ(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(dl).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i10, String str) {
        String K;
        AdInfo dQ = e.dQ(adTemplate);
        boolean bd2 = com.kwad.sdk.core.response.b.a.bd(dQ);
        SplashMonitorInfo type = new SplashMonitorInfo().setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setType(bd2 ? 2 : 1);
        if (bd2) {
            K = com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl;
        } else {
            K = com.kwad.sdk.core.response.b.a.K(dQ);
        }
        com.kwad.sdk.commercial.b.k(type.setUrl(K).setErrorCode(i10).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void d(@NonNull AdTemplate adTemplate, int i10, String str) {
        String str2;
        AdInfo dQ = e.dQ(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(dQ)) {
            str2 = com.kwad.sdk.core.response.b.a.K(dQ);
        } else {
            str2 = com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl;
        }
        com.kwad.sdk.commercial.b.g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setUrl(str2).setErrorCode(i10).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.b.a.bc(dQ) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull List<AdTemplate> list, long j10, long j11) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.b.a.aZ(e.dQ(iterator2.next())));
        }
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j10).setCount(list.size()).setPosId(j11));
    }

    public static void b(int i10, String str, long j10) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(3).setErrorCode(i10).setErrorMsg(str).setPosId(j10));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dl;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.b.b.df(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dQ(adTemplate);
        if (h.U(adTemplate)) {
            dl = com.kwad.sdk.core.response.b.b.de(adTemplate);
        } else {
            dl = com.kwad.sdk.core.response.b.b.dl(e.dQ(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(dl).setAdTemplate(adTemplate));
    }

    public static void b(boolean z10, int i10, String str, long j10) {
        com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setStatus(4).setType(z10 ? 2 : 1).setErrorCode(i10).setErrorMsg(str).setPosId(j10));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j10, int i10) {
        String str;
        AdInfo dQ = e.dQ(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(dQ)) {
            str = com.kwad.sdk.core.response.b.a.K(dQ);
        } else {
            str = com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl;
        }
        File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(com.kwad.sdk.core.response.b.a.aZ(dQ));
        com.kwad.sdk.commercial.b.g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dQ)).setCostTime(j10).setCacheValidTime(dQ.adPreloadInfo.validityPeriod * 1000).setSize((bV == null || !bV.exists()) ? 0L : bV.length()).setUrl(str).setMaterialType(com.kwad.sdk.core.response.b.a.bc(dQ) ? 1 : 2).setType(i10).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long dl;
        StyleTemplate S = S(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(S.templateId).setTemplateVersionCode(S.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.df(adTemplate)).setErrorMsg(str);
        e.dQ(adTemplate);
        if (h.U(adTemplate)) {
            dl = com.kwad.sdk.core.response.b.b.de(adTemplate);
        } else {
            dl = com.kwad.sdk.core.response.b.b.dl(e.dQ(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(errorMsg.setTkDefaultTimeout(dl).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dl;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.df(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dQ(adTemplate);
        if (h.U(adTemplate)) {
            dl = com.kwad.sdk.core.response.b.b.de(adTemplate);
        } else {
            dl = com.kwad.sdk.core.response.b.b.dl(e.dQ(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(dl).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j10, boolean z10) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        AdInfo dQ = e.dQ(adTemplate);
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setViewSource(z10 ? 1 : 2).setLoadDataTime(elapsedRealtime).setType(com.kwad.sdk.core.response.b.a.bd(dQ) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, boolean z10) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z10 ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(e.dQ(adTemplate))).setErrorMsg(str).setViewSource(z10 ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dl;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.df(adTemplate));
        e.dQ(adTemplate);
        if (h.U(adTemplate)) {
            dl = com.kwad.sdk.core.response.b.b.de(adTemplate);
        } else {
            dl = com.kwad.sdk.core.response.b.b.dl(e.dQ(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(tkRenderType.setTkDefaultTimeout(dl).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i10, long j10, int i11, long j11, long j12, long j13, long j14, long j15) {
        long dl;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.df(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.dQ(adTemplate);
        if (h.U(adTemplate)) {
            dl = com.kwad.sdk.core.response.b.b.de(adTemplate);
        } else {
            dl = com.kwad.sdk.core.response.b.b.dl(e.dQ(adTemplate));
        }
        com.kwad.sdk.commercial.b.k(templateVersionCode.setTkDefaultTimeout(dl).setSoSource(i10).setSoLoadTime(j10).setOfflineSource(i11).setOfflineLoadTime(j11).setTkFileLoadTime(j12).setTkInitTime(j13).setTkRenderTime(j14).setTkTotalTime(j15).setAdTemplate(adTemplate));
    }
}
