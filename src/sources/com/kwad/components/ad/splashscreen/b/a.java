package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static k CM = new k("splashTimeOutMilliSecond", 5000);
    public static p CN = new p("splashTimerTips", "");
    public static p CO = new p("splashBtnText", "点击跳转详情页或第三方应用");
    public static d CP = new d("splashCropNewSwitch", true);
    public static d CQ = new d("splashAdLoadProcessChange", false);
    public static k CR = new k("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
