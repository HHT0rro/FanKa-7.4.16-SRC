package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f {
    public static String c(@NonNull AdTemplate adTemplate) {
        String au = com.kwad.sdk.core.response.b.a.au(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        if (!com.kwad.components.core.c.b.mw()) {
            return au;
        }
        return (adTemplate.fromCache ? "【cache】" : "") + au;
    }
}
