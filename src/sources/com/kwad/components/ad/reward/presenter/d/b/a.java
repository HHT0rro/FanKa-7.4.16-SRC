package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private TextView vL;
    private TextView vM;

    private void cc() {
        g gVar = this.qo;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    private void iB() {
        String dE = com.kwad.sdk.core.response.b.d.dE(this.qo.mAdTemplate);
        if (this.qo.mScreenOrientation == 1) {
            this.vM.setVisibility(8);
            this.vL.setText(dE);
            this.vL.setVisibility(0);
            this.vL.setOnClickListener(this);
        } else {
            this.vL.setVisibility(8);
            this.vM.setText(dE);
            this.vM.setVisibility(0);
            this.vM.setOnClickListener(this);
        }
        cc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC() {
        com.kwad.sdk.core.adlog.c.b cK = new com.kwad.sdk.core.adlog.c.b().f(this.qo.mRootContainer.getTouchCoords()).cK(39);
        g gVar = this.qo;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", "endTopBar", cK, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.qo.oI.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iE() {
        if (this.qo.pj) {
            return;
        }
        iB();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vL || view == this.vM) {
            com.kwad.components.core.e.d.a.a(new a.C0461a(view.getContext()).aq(this.qo.mAdTemplate).b(this.qo.mApkDownloadHelper).ao(false).an(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.iC();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vL = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.vM = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vL.setVisibility(8);
        this.vM.setVisibility(8);
    }
}
