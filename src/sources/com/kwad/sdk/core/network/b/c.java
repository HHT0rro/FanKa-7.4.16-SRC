package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    public static b Ej() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && hVar.yJ()) {
            return new d();
        }
        return new a();
    }
}
