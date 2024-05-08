package com.kwad.components.ad.reward.monitor;

import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    public static void a(boolean z10, AdTemplate adTemplate) {
        a(z10, z10 ? "ad_sdk_neo_video_cache_monitor" : "ad_sdk_fullscreen_video_cache_monitor", adTemplate, z10 ? 102001 : 103001);
    }

    public static void b(boolean z10, AdTemplate adTemplate) {
        a(z10, z10 ? "ad_sdk_neo_page_enter_monitor" : "ad_sdk_fullscreen_page_enter_monitor", adTemplate, z10 ? 102002 : 103002);
    }

    public static void c(boolean z10, int i10) {
        a(z10, z10 ? "ad_sdk_neo_request_monitor" : "ad_sdk_fullscreen_request_monitor", null, i10);
    }

    public static void a(AdTemplate adTemplate, TKRenderFailReason tKRenderFailReason) {
        int i10;
        boolean z10 = e.dK(adTemplate) == 2;
        String str = z10 ? "ad_sdk_neo_page_native_monitor" : "ad_sdk_fullscreen_page_native_monitor";
        if (TKRenderFailReason.SWITCH_CLOSE.equals(tKRenderFailReason)) {
            i10 = z10 ? 102003 : 103003;
        } else {
            i10 = TKRenderFailReason.TK_FILE_LOAD_ERROR.equals(tKRenderFailReason) ? z10 ? 102004 : 103004 : 102005;
        }
        a(z10, str, adTemplate, i10);
    }

    public static void c(boolean z10, AdTemplate adTemplate) {
        a(z10, z10 ? "ad_sdk_neo_video_play_monitor" : "ad_sdk_fullscreen_video_play_monitor", adTemplate, z10 ? 102007 : 103007);
    }

    private static void a(boolean z10, String str, AdTemplate adTemplate, int i10) {
        AdInfo dQ;
        com.kwad.sdk.commercial.b.a(z10, str, new RewardMonitorInfo().setErrorCode(i10).setCreativeId((adTemplate == null || (dQ = e.dQ(adTemplate)) == null) ? 0L : com.kwad.sdk.core.response.b.a.J(dQ)).setAdTemplate(adTemplate));
    }
}
