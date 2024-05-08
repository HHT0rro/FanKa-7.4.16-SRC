package com.kwad.components.ad.interstitial.e;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e extends b implements a.c {
    private static long kD = 1000;
    private c jK;

    @Nullable
    private a kE;
    private int kF;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i10) {
        c cVar = this.jK;
        com.kwad.components.ad.interstitial.g.d dVar = cVar.jL;
        if (dVar == null) {
            return;
        }
        if (i10 == 0) {
            if (cVar.cT()) {
                return;
            }
            this.jK.b(getContext(), this.mAdTemplate);
            dt();
            c cVar2 = this.jK;
            cVar2.a(true, -1, cVar2.eN);
            return;
        }
        dVar.b(true, i10);
    }

    private void dt() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.video.videoview.a aVar = this.jK.eN;
        if (aVar != null) {
            aVar.release();
        }
        this.jK.f36523io.dismiss();
        c cVar = this.jK;
        if (cVar.jO || (adInteractionListener = cVar.f36522ie) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("InterstitialPlayablePresenter", ((Object) this) + " onBind");
        c cVar = (c) Jx();
        this.jK = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        long j10 = dQ.adInsertScreenInfo.autoCloseTime;
        if (j10 > 0) {
            this.kF = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(dQ), j10);
        } else {
            this.kF = com.kwad.components.ad.interstitial.b.b.b(dQ);
        }
        com.kwad.components.ad.interstitial.g.d dVar = this.jK.jL;
        if (dVar != null) {
            dVar.b(true, this.kF);
        }
        if (com.kwad.sdk.core.response.b.a.bc(dQ)) {
            this.kE = null;
            this.jK.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.kE = aVar;
            bn.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void bl() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void bm() {
        if (this.jK.cT()) {
            return;
        }
        this.jK.b(getContext(), this.mAdTemplate);
        dt();
    }

    @Override // com.kwad.components.ad.interstitial.e.b
    public final void cP() {
        super.cP();
        a aVar = this.kE;
        if (aVar != null) {
            aVar.r(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.b
    public final void cQ() {
        super.cQ();
        a aVar = this.kE;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void e(long j10) {
        D(this.kF - ((int) (j10 / 1000)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("InterstitialPlayablePresenter", ((Object) this) + " onUnbind");
        this.jK.b(this);
        a aVar = this.kE;
        if (aVar != null) {
            aVar.q(true);
            bn.c(this.kE);
            this.kE = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {
        private int kG;
        private boolean kH;
        private boolean kI;

        private a() {
            this.kG = Integer.MIN_VALUE;
            this.kH = false;
            this.kI = false;
        }

        public final void q(boolean z10) {
            this.kI = true;
        }

        public final void r(boolean z10) {
            this.kH = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.kI) {
                return;
            }
            if (this.kH) {
                bn.a(this, null, e.kD);
                return;
            }
            if (this.kG == Integer.MIN_VALUE) {
                this.kG = e.this.kF;
            }
            if (this.kG < 0) {
                return;
            }
            com.kwad.sdk.core.e.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.kG);
            e.this.D(this.kG);
            this.kG = this.kG + (-1);
            bn.a(this, null, e.kD);
        }

        public /* synthetic */ a(e eVar, byte b4) {
            this();
        }
    }
}
