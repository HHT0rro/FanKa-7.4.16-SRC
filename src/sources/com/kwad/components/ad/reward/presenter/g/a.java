package com.kwad.components.ad.reward.presenter.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.huawei.quickcard.CardContext;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.l.d;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.wM != null) {
                a.this.wM.jQ();
            }
            if (a.this.wN != null) {
                a.this.wN.jQ();
            }
        }
    };
    private com.kwad.components.ad.reward.l.a.a pr;

    @Nullable
    private ViewGroup wI;

    @Nullable
    private q wJ;
    private ViewGroup wK;
    private e wL;
    private c wM;

    @Nullable
    private c wN;

    private void c(View view, boolean z10) {
        int id2 = view.getId();
        if (id2 == R.id.ksad_reward_apk_info_card_native_container || id2 == R.id.ksad_activity_apk_info_area_native) {
            e(z10, 2);
        }
    }

    private void e(boolean z10, int i10) {
        this.qo.a(1, getContext(), z10 ? 1 : 153, i10);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", CardContext.ON_BIND_FUNC);
        if (g.F(this.qo.mAdTemplate)) {
            com.kwad.components.ad.reward.l.a.a jz = d.jz();
            this.pr = jz;
            this.qo.pr = jz;
            com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.wI = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.wI.setVisibility(8);
                new f(this.wI, this);
                c cVar = new c(this.wI);
                this.wN = cVar;
                cVar.a(this);
                this.wN.c(this.qo.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wI, null, this);
                this.wJ = qVar;
                qVar.a(this.qo.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z10, int i10) {
        e(z10, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", CardContext.ON_UNBIND_FUNC);
        e eVar = this.wL;
        if (eVar != null) {
            eVar.jS();
            this.wL = null;
        }
        c cVar = this.wN;
        if (cVar != null) {
            cVar.jP();
        }
        com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
        this.qo.pr = null;
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!ai.LZ()) {
            com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        if (com.kwad.sdk.core.response.b.d.dH(this.qo.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.d.a.a.m(kSFrameLayout, com.kwad.sdk.d.a.a.a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.d.a.a.m(kSFrameLayout, com.kwad.sdk.d.a.a.a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wK = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wK, this);
        c cVar = new c(this.wK);
        this.wM = cVar;
        cVar.a(this);
        this.wM.c(this.qo.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wK, null, this);
        this.wL = eVar;
        eVar.a(this.qo.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.qo.mAdTemplate)) {
            c(view, false);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }
}
