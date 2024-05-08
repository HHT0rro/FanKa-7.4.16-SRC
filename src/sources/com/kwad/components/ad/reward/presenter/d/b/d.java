package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private static final String[] vW = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.G(d.this.qo.mAdTemplate)) {
                d.this.iH();
            }
        }
    };
    private ViewGroup vS;
    private ImageView vT;
    private ViewGroup vU;
    private TextView vV;

    private void ca() {
        com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
        this.vS.setVisibility(0);
        this.vU.setVisibility(g.G(this.qo.mAdTemplate) ? 0 : 8);
    }

    private void iG() {
        ImageView imageView = this.vT;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.vT.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.vS;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.vS.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH() {
        this.vV.setText(vW[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.b cK = new com.kwad.sdk.core.adlog.c.b().f(this.qo.mRootContainer.getTouchCoords()).cK(41);
        g gVar = this.qo;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, (String) null, (String) null, cK, gVar.mReportExtData);
        this.qo.oI.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iE() {
        g gVar = this.qo;
        if (gVar.pj) {
            if (com.kwad.sdk.core.response.b.a.as(e.dQ(gVar.mAdTemplate))) {
                this.vU.setVisibility(8);
            }
        } else if (!g.E(gVar.mAdTemplate) && !g.F(this.qo.mAdTemplate)) {
            if (this.qo.fN()) {
                iG();
            }
        } else {
            if (this.qo.fN()) {
                return;
            }
            this.vV.setText(this.qo.pe ? vW[1] : vW[0]);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vT || view == this.vS) {
            com.kwad.components.core.e.d.a.a(new a.C0461a(view.getContext()).aq(this.qo.mAdTemplate).b(this.qo.mApkDownloadHelper).ao(false).an(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vS = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.vT = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.vU = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.vV = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
        this.vS.setVisibility(8);
        this.vT.setVisibility(8);
        this.vU.setVisibility(8);
    }
}
