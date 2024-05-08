package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    private static AdHttpProxy akE;

    @NonNull
    public static AdHttpProxy xT() {
        AdHttpProxy adHttpProxy = akE;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
            return xU();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.DS() != null) {
                akE = new com.kwad.sdk.core.network.c.b();
            } else {
                akE = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            akE = new com.kwad.sdk.core.network.c.a();
        }
        return akE;
    }

    private static AdHttpProxy xU() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.c.b() : new com.kwad.sdk.core.network.c.a();
    }
}
