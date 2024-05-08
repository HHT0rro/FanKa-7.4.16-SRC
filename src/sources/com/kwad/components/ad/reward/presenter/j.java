package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j extends b {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        try {
            this.qo.oJ.jI();
        } catch (Throwable th) {
            bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.presenter.j.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    ServiceProvider.reportSdkCaughtException(th);
                    j.this.hp();
                }
            });
        }
    }
}
