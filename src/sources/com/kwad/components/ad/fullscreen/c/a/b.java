package com.kwad.components.ad.fullscreen.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            b.this.g(j11);
        }
    };
    private TextView hl;
    private String hm;
    private long hn;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    private void ca() {
        this.hn = com.kwad.sdk.core.response.b.d.dC(this.mAdTemplate);
        String dD = com.kwad.sdk.core.response.b.d.dD(this.mAdTemplate);
        this.hm = dD;
        if (TextUtils.isEmpty(dD)) {
            return;
        }
        g gVar = this.qo;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        gVar.oJ.a(this.gO);
    }

    private void cb() {
        if (this.hl.getVisibility() == 0) {
            return;
        }
        this.hl.setText(com.kwad.sdk.core.response.b.d.dD(this.mAdTemplate));
        this.hl.setVisibility(0);
        this.hl.setOnClickListener(this);
        cc();
    }

    private void cc() {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 18, this.qo.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j10) {
        if (j10 >= this.hn) {
            cb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.qo.mRootContainer.getTouchCoords()).cK(40), this.qo.mReportExtData);
        this.qo.oI.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.hl) {
            com.kwad.components.core.e.d.a.a(new a.C0461a(view.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).am(40).al(1).ao(false).af(this.qo.fz()).an(1).a(new a.b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hl = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.hl = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (TextUtils.isEmpty(this.hm)) {
            return;
        }
        this.qo.oJ.b(this.gO);
    }
}
