package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class i {
    public static boolean x(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bH(dQ) && (aVar = gVar.oL) != null && aVar.qf()) || com.kwad.components.ad.reward.a.b.k(dQ) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.gB()) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.aF(dQ) && com.kwad.sdk.core.response.b.a.at(dQ);
    }
}
