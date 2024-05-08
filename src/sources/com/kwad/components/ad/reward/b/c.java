package com.kwad.components.ad.reward.b;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.b.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private AdTemplate mAdTemplate;
    private boolean re = false;

    private static boolean l(AdInfo adInfo) {
        AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(adInfo);
        return (!com.kwad.components.ad.reward.a.b.i(adInfo) || cP == null || cP.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mAdTemplate = this.qo.mAdTemplate;
    }

    @Override // com.kwad.components.ad.reward.b.b.a
    public final void gJ() {
        this.qo.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.e.c.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.re);
        if (this.re) {
            return;
        }
        AdInfo dQ = e.dQ(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.qo.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view = viewGroup;
        if (childCount > 0) {
            view = viewGroup.getChildAt(0);
        }
        final int[] E = com.kwad.sdk.d.a.a.E(view);
        if (!l(dQ) || E == null) {
            return;
        }
        view.post(new ay() { // from class: com.kwad.components.ad.reward.b.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.core.e.c.d("RewardCouponDialogPresenter", "targetView x: " + E[0] + ", y: " + E[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, E);
                c.a(c.this, true);
            }
        });
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.re = true;
        return true;
    }
}
