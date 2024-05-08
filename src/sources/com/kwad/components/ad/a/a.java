package com.kwad.components.ad.a;

import com.kwad.sdk.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.core.request.a {
    public a(com.kwad.components.core.request.model.a aVar) {
        super(aVar);
        putBody("requestTime", System.currentTimeMillis());
    }

    @Override // com.kwad.components.core.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return g.xY();
    }
}
