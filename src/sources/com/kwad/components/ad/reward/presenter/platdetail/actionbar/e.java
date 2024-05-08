package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.n;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements RewardActionBarControl.c {
    private ViewGroup gS;
    private KsLogoView sr;
    private n uV;
    private int uW;
    private FrameLayout.LayoutParams uX;
    private n.a uY;

    public e(ViewGroup viewGroup, n.a aVar) {
        this.gS = viewGroup;
        this.uY = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.oM.a(this);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        this.uW = this.sr.getVisibility();
        this.uX = d.a(getContext(), dQ, this.sr, R.dimen.ksad_reward_order_logo_margin_bottom, !this.qo.oJ.jM());
        n nVar = new n(this.gS, new com.kwad.components.ad.reward.n.a(getContext(), this.qo) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void ih() {
                e.this.qo.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void ii() {
                e.this.qo.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.uV = nVar;
        nVar.a(this.uY);
        this.uV.b(r.R(this.qo.mAdTemplate));
        i.a(new com.kwad.components.core.widget.e(), this.uV.gF());
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.gS.setVisibility(0);
        RewardActionBarControl.a(aVar, this.gS, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sr = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.sr.setVisibility(this.uW);
        FrameLayout.LayoutParams layoutParams = this.uX;
        if (layoutParams != null) {
            this.sr.setLayoutParams(layoutParams);
        }
    }
}
