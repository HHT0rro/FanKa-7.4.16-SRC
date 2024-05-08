package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends Presenter {
    public c Lq;
    public AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        c cVar = (c) Jx();
        this.Lq = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(cVar.Lp.getAdTemplate());
    }
}
