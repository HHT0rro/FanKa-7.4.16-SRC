package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d {
    public static int Ci;
    private String Cj;
    private int Ck = 2;

    private void S(String str) {
        this.Cj = str;
    }

    private void V(int i10) {
        this.Ck = i10;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i10) {
        d dVar = new d();
        Ci = i10;
        if (adInfo != null && cVar != null) {
            if (i10 != 1 && i10 != 4) {
                if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                    dVar.S("或点击" + a(adTemplate, adInfo, cVar.nW(), 0));
                } else {
                    String a10 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CO);
                    if (TextUtils.isEmpty(a10)) {
                        a10 = "点击跳转详情页或第三方应用";
                    }
                    dVar.S("或" + a10);
                }
            } else {
                dVar.S(a(adTemplate, adInfo, cVar));
            }
        }
        dVar.V(com.kwad.sdk.core.response.b.b.ds(adInfo));
        return dVar;
    }

    public final String ku() {
        return this.Cj;
    }

    public final int kv() {
        return this.Ck;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i10, int i11) {
        String aE = com.kwad.sdk.core.response.b.a.aE(adInfo);
        if (i10 == 2) {
            return i11 + "%";
        }
        if (i10 == 4) {
            return "继续下载";
        }
        if (i10 != 8) {
            return i10 != 12 ? aE : com.kwad.sdk.core.response.b.a.ac(adInfo);
        }
        return com.kwad.sdk.core.response.b.a.bY(adTemplate);
    }

    private static String a(AdInfo adInfo, int i10) {
        return i10 == 1 ? com.kwad.sdk.core.response.b.b.dm(adInfo) != null ? com.kwad.sdk.core.response.b.b.dm(adInfo) : "" : (i10 != 4 || com.kwad.sdk.core.response.b.b.dn(adInfo) == null) ? "" : com.kwad.sdk.core.response.b.b.dn(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            return a(adTemplate, adInfo, cVar.nW(), 0);
        }
        String a10 = a(adInfo, Ci);
        return TextUtils.isEmpty(a10) ? "点击跳转详情页或第三方应用" : a10;
    }
}
