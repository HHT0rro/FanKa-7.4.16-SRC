package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h extends b implements com.kwad.sdk.b.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.b.a
    public final void N(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(dQ) && com.kwad.sdk.core.response.b.a.aN(dQ) == 1) {
                return;
            }
            com.kwad.components.ad.reward.e.b bVar = this.qo.oI;
            if (bVar != null) {
                bVar.onRewardVerify();
            }
            this.qo.oJ.pause();
            this.qo.fB();
        }
    }

    @Override // com.kwad.sdk.b.a
    public final void O(String str) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        com.kwad.sdk.b.b.Ao().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.b.b.Ao().b(this);
    }
}
