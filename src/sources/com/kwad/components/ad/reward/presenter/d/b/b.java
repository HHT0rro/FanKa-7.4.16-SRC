package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private View vO;
    private boolean vP;
    private final Runnable vQ = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.iF();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iF() {
        com.kwad.sdk.core.e.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.qo.pA + ", needHideCloseButton: " + this.vP);
        if (this.qo.pA && this.vP) {
            return;
        }
        this.vO.setVisibility(0);
        this.vO.setAlpha(0.0f);
        this.vO.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vP = com.kwad.sdk.core.response.b.b.dQ(e.dQ(this.qo.mAdTemplate));
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iE() {
        g gVar = this.qo;
        if (gVar.pj) {
            return;
        }
        long j10 = gVar.pu;
        if (j10 == 0) {
            this.vQ.run();
        } else {
            bn.runOnUiThreadDelay(this.vQ, j10);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vO) {
            PlayableSource fG = this.qo.fG();
            if (fG != null && (fG.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || fG.equals(PlayableSource.PENDANT_CLICK_AUTO) || fG.equals(PlayableSource.PENDANT_AUTO) || fG.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.a.eX().eY();
            } else {
                f.t(this.qo);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View findViewById = findViewById(R.id.ksad_end_close_btn);
        this.vO = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vO.setVisibility(8);
        bn.c(this.vQ);
    }
}
