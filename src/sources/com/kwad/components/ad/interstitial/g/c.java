package com.kwad.components.ad.interstitial.g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.ad.interstitial.e.f;
import com.kwad.components.ad.interstitial.e.g;
import com.kwad.components.ad.interstitial.g.d;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends a {
    private KsAdVideoPlayConfig dU;

    /* renamed from: ie, reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f36532ie;

    /* renamed from: io, reason: collision with root package name */
    private com.kwad.components.ad.interstitial.d f36533io;
    public com.kwad.components.ad.interstitial.e.c jK;
    private boolean jO;
    private c.a jP;
    private com.kwad.components.core.webview.tachikoma.e.e jR;
    private int jZ;

    @Nullable
    public com.kwad.components.ad.interstitial.e.b lB;
    private boolean lC;
    public ViewGroup lD;
    public AdInfo mAdInfo;

    @NonNull
    public AdResultData mAdResultData;

    @NonNull
    public AdTemplate mAdTemplate;

    public c(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.lC = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.e.c dX() {
        com.kwad.components.ad.interstitial.e.c cVar = new com.kwad.components.ad.interstitial.e.c();
        cVar.d(this.mAdResultData);
        cVar.f36522ie = this.f36532ie;
        cVar.f36523io = this.f36533io;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        cVar.dU = this.dU;
        cVar.eN = new com.kwad.sdk.core.video.videoview.a(((a) this).mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.lD.findViewById(R.id.ksad_container);
        cVar.jS = kSFrameLayout;
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b(kSFrameLayout, 100);
        cVar.f36521ib = bVar;
        bVar.tw();
        cVar.jZ = this.jZ;
        cVar.jO = this.jO;
        cVar.jP = this.jP;
        cVar.jR = this.jR;
        cVar.jL = a(((a) this).mContext, com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cr() {
        com.kwad.components.ad.interstitial.e.b bVar = this.lB;
        if (bVar != null) {
            bVar.cP();
        }
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cs() {
        com.kwad.components.ad.interstitial.e.b bVar = this.lB;
        if (bVar != null) {
            bVar.cQ();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.e.b dY() {
        com.kwad.components.ad.interstitial.e.b bVar = new com.kwad.components.ad.interstitial.e.b();
        if (this.lC) {
            bVar.a(new com.kwad.components.ad.interstitial.e.a.b());
        } else {
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                bVar.a(new f());
            }
            bVar.a(new g());
            bVar.a(new com.kwad.components.ad.interstitial.e.d());
            if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.e.a());
            }
            if (this.jK.K(getContext())) {
                bVar.a(new com.kwad.components.ad.interstitial.e.e());
            }
        }
        return bVar;
    }

    public final void dZ() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar == null || !cVar.jX) {
            return;
        }
        cVar.cR();
    }

    public final void ea() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            if (this.lC || cVar.jX) {
                cVar.cS();
            }
        }
    }

    public final void eb() {
        if (this.jK != null) {
            this.jK.a(new c.b(((a) this).mContext).k(true).A(1).m(true).z(2));
        }
    }

    public final boolean ec() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            return cVar.jY;
        }
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.e.b bVar = this.lB;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        this.jP = aVar;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jP = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f36532ie = adInteractionListener;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.f36522ie = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z10) {
        this.jO = z10;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jO = z10;
        }
    }

    public final void setAggregateShowTriggerType(int i10) {
        this.jZ = i10;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jZ = i10;
        }
    }

    private c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.jZ = -1;
        this.jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.interstitial.g.c.1
            @Override // com.kwad.components.core.webview.tachikoma.e.e
            public final void a(String str, long j10, long j11, long j12) {
                c.this.jK.jY = true;
            }

            @Override // com.kwad.components.core.webview.tachikoma.e.b
            public final void q(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.e.b bVar = c.this.lB;
                    if (bVar != null) {
                        bVar.lW();
                    }
                    c cVar = c.this;
                    cVar.lB = cVar.dY();
                    c cVar2 = c.this;
                    cVar2.lB.G(cVar2.lD);
                    c cVar3 = c.this;
                    cVar3.lB.k(cVar3.jK);
                }
            }
        };
        this.lD = (ViewGroup) l.inflate(context, getLayoutId(), this);
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.e.c cVar) {
        boolean a10 = com.kwad.components.ad.interstitial.e.c.a(((a) this).mContext, adInfo);
        d.a aVar = new d.a();
        aVar.v(a10);
        boolean z10 = true;
        aVar.w(!cVar.K(context) && com.kwad.components.ad.interstitial.b.b.cF());
        aVar.F(com.kwad.components.ad.interstitial.b.b.cG());
        if (com.kwad.sdk.core.response.b.a.aW(adInfo) && ai.LZ()) {
            z10 = false;
        }
        aVar.x(z10);
        return new d(context, aVar);
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        AdTemplate n10 = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n10;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(n10);
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.realShowType = 2;
        this.dU = ksAdVideoPlayConfig;
        this.f36533io = dVar;
        this.lC = com.kwad.sdk.core.response.b.b.cS(adTemplate);
        this.f36532ie = adInteractionListener;
        this.jK = dX();
        if (this.lB == null) {
            this.lB = dY();
        }
        this.lB.G(this.lD);
        this.lB.k(this.jK);
    }
}
