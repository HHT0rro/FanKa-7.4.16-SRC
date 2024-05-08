package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.g.a.a.b;
import com.kwad.components.ad.interstitial.report.InterstitialReportInfo;
import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ci {
    @InvokeBy(invokerClass = ft.class, methodId = "registerHolder")
    public static void Dz() {
        ft.DA().put(com.kwad.components.ad.interstitial.d.a.class, new fj());
        ft.DA().put(com.kwad.components.ad.interstitial.c.a.class, new fi());
        ft.DA().put(InterstitialReportInfo.class, new fn());
        ft.DA().put(InterstitialRealTimeInfo.class, new fm());
        ft.DA().put(com.kwad.components.ad.interstitial.c.b.class, new fl());
        ft.DA().put(b.a.class, new kd());
    }
}
