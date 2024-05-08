package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g qo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) Jx();
        this.qo = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    public final void hp() {
        this.qo.hp();
    }

    public final boolean hq() {
        return com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate));
    }
}
