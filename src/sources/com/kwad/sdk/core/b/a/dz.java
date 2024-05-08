package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class dz {
    @InvokeBy(invokerClass = ft.class, methodId = "registerHolder")
    public static void Dz() {
        ft.DA().put(com.kwad.sdk.crash.a.class, new cr());
        ft.DA().put(com.kwad.sdk.crash.online.monitor.a.b.class, new dr());
        ft.DA().put(com.kwad.sdk.crash.online.monitor.block.d.class, new bt());
        ft.DA().put(com.kwad.sdk.crash.online.monitor.a.a.class, new br());
        ft.DA().put(AnrReason.class, new bb());
        ft.DA().put(com.kwad.sdk.crash.online.monitor.a.c.class, new gm());
        ft.DA().put(BlockEvent.a.class, new ke());
        ft.DA().put(BlockEvent.class, new bs());
        ft.DA().put(com.kwad.sdk.crash.model.b.class, new dn());
    }
}
