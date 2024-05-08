package com.kwad.components.ad.fullscreen;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.j;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g implements com.kwad.components.core.internal.api.a, KsFullScreenVideoAd {
    private com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    private c gG;
    private AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;

    public g(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate n10 = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n10;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(n10);
        com.kwad.components.ad.h.b.eI().a(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.eg(this.mAdTemplate) >= 0) {
            return true;
        }
        return j.ax(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        if (this.gG == null) {
            this.gG = new c() { // from class: com.kwad.components.ad.fullscreen.g.1
                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    g.this.bZ.i(g.this);
                }

                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    g.this.bZ.h(g.this);
                }
            };
        }
        this.gG.a(fullScreenVideoAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity != null && !activity.isFinishing()) {
            com.kwad.sdk.j.a.ak("fullscreen", "show");
            com.kwad.components.ad.reward.monitor.c.h(false, this.mAdTemplate);
            com.kwad.sdk.commercial.d.c.by(this.mAdTemplate);
            if (!com.kwad.sdk.core.config.d.CF() && !isAdEnable()) {
                com.kwad.sdk.core.e.c.i("KsFullScreenVideoAdControl", "isAdEnable is false");
                com.kwad.sdk.j.a.al("fullscreen", "show");
                com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "cache_not_ready");
                return;
            } else {
                if (ksVideoPlayConfig == null) {
                    ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
                }
                KsFullScreenVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.gG);
                return;
            }
        }
        com.kwad.sdk.core.e.c.e("KsFullScreenVideoAdControl", "showFullScreenVideoAd error, activity is null or finished");
        com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "illegal_activity");
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(long j10, long j11) {
        com.kwad.sdk.core.adlog.c.l(this.mAdTemplate, j11);
    }
}
