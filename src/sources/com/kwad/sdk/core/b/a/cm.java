package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class cm {
    @InvokeBy(invokerClass = ft.class, methodId = "registerHolder")
    public static void Dz() {
        ft.DA().put(ImpInfo.class, new fb());
        ft.DA().put(b.a.class, new bi());
    }
}
