package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class q extends b {
    private float sC;
    private r sE;
    private KsToastView sL;
    private Runnable sO;
    private boolean sM = false;
    private boolean sN = false;
    private boolean sP = false;
    private boolean sF = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            q.this.sL.setVisibility(8);
        }
    };

    public q(r rVar) {
        this.sE = rVar;
    }

    private void hC() {
        this.sO = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.sP) {
                    return;
                }
                if (q.this.sL != null) {
                    q.this.sL.setVisibility(8);
                }
                com.kwad.components.ad.reward.a.eX().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void hD() {
        bn.c(this.sO);
        this.sO = null;
    }

    private synchronized void hx() {
        if (this.sF) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.qo.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(192).ah(this.qo.oJ.getPlayDuration()));
        this.sF = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.sL == null) {
            KsToastView ksToastView = (KsToastView) findViewById(R.id.ksad_toast_view);
            this.sL = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.a(q.this, true);
                    q.this.sL.setVisibility(8);
                    com.kwad.components.ad.reward.a.eX().a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.qo.b(this.mPlayEndPageListener);
    }

    public final void hA() {
        if (this.sN) {
            return;
        }
        hx();
        this.sN = true;
        this.sL.setVisibility(0);
        this.sL.U(3);
        hC();
        bn.a(this.sO, null, com.huawei.openalliance.ad.ipc.c.Code);
    }

    public final void hB() {
        this.sN = false;
        this.sL.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sC = com.kwad.components.ad.reward.a.b.gv();
        this.sM = com.kwad.components.ad.reward.a.b.gw() && com.kwad.components.ad.reward.a.b.gx();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        hD();
        this.qo.c(this.mPlayEndPageListener);
    }

    public static /* synthetic */ boolean a(q qVar, boolean z10) {
        qVar.sP = true;
        return true;
    }
}
