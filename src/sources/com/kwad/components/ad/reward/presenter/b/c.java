package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.o;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl oM;
    private l sv = new l() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            c.this.hu();
        }
    };

    @Nullable
    private o tT;

    /* JADX INFO: Access modifiers changed from: private */
    public void hu() {
        this.oM.O(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        g gVar = this.qo;
        this.oM = gVar.oM;
        gVar.oJ.a(this.sv);
        AdTemplate adTemplate = this.qo.mAdTemplate;
        AdInfo dQ = e.dQ(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cL(dQ)) {
            if (this.tT == null) {
                this.tT = new o(this.qo);
            }
            this.tT.a(this.qo.mRootContainer, com.kwad.sdk.core.response.b.a.bf(dQ));
            this.tT.b(r.R(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.qo.oM.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.sv);
        this.qo.oM.b(this);
        o oVar = this.tT;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }
}
