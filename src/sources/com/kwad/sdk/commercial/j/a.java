package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.t;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static C0514a aoK;

    @KsJson
    /* renamed from: com.kwad.sdk.commercial.j.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0514a extends com.kwad.sdk.core.response.a.a {
        public List<String> aoL;
    }

    private static C0514a AU() {
        String yW = ((h) ServiceProvider.get(h.class)).yW();
        if (!TextUtils.isEmpty(yW)) {
            aoK = (C0514a) t.b(yW, new c<C0514a>() { // from class: com.kwad.sdk.commercial.j.a.1
                private static C0514a AV() {
                    return new C0514a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ C0514a AW() {
                    return AV();
                }
            });
        }
        return aoK;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static boolean cL(String str) {
        List<String> list;
        C0514a AU = AU();
        if (AU == null || (list = AU.aoL) == null) {
            return false;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    public static void n(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.AX().cn(4).co(i10).cM(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.AX().cn(1).co(i10).cM(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, b bVar) {
        if (cL(bVar.aoN)) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.001d).a(d.aS(adTemplate)).N("ad_sdk_track_performance", "status").u(bVar));
    }

    public static void a(AdTemplate adTemplate, int i10, String str, int i11, int i12) {
        try {
            a(adTemplate, b.AX().cn(2).co(i10).cM(str).cp(i12).setErrorCode(i11).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, String str, String str2, int i11, String str3, int i12) {
        try {
            a(adTemplate, true, b.AX().cn(3).co(i10).cM(str).cN(str2).setErrorCode(i11).setErrorMsg(str3).cp(i12).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
