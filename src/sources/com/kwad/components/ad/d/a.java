package com.kwad.components.ad.d;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static p bJ = new p("kwaiLogoUrl", null);
    public static p bK = new p("attentionTips", "去关注TA");
    public static p bL = new p("viewHomeTips", "查看TA的主页");
    public static p bM = new p("buyNowTips", "立即抢购");

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
