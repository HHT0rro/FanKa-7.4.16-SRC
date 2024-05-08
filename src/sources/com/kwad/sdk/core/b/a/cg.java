package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class cg {
    @InvokeBy(invokerClass = ft.class, methodId = "registerHolder")
    public static void Dz() {
        ft.DA().put(FeedPageInfo.class, new dv());
        ft.DA().put(FeedPageInfo.a.class, new gg());
        ft.DA().put(FeedWebViewInfo.class, new dx());
        ft.DA().put(FeedErrorInfo.class, new dt());
    }
}
