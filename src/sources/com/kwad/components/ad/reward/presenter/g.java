package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g extends b implements a.InterfaceC0466a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        boolean DG = com.kwad.sdk.core.d.a.DG();
        com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + DG);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !DG) {
            return;
        }
        com.kwad.components.core.i.a.a(sceneImpl, this);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean cu = com.kwad.sdk.core.response.b.b.cu(adTemplate);
        List<a.InterfaceC0466a> fI = this.qo.fI();
        if (cu) {
            com.kwad.sdk.core.d.a.e(com.kwad.sdk.core.response.b.b.cr(adTemplate), com.kwad.sdk.core.response.b.b.cs(adTemplate));
            if (fI != null) {
                Iterator<a.InterfaceC0466a> iterator2 = fI.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().e(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void onError(int i10, String str) {
        List<a.InterfaceC0466a> fI = this.qo.fI();
        if (fI != null) {
            Iterator<a.InterfaceC0466a> iterator2 = fI.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onError(i10, str);
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0466a
    public final void onRequestResult(int i10) {
        List<a.InterfaceC0466a> fI = this.qo.fI();
        if (fI != null) {
            Iterator<a.InterfaceC0466a> iterator2 = fI.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onRequestResult(i10);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
