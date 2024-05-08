package com.kwad.components.ad.splashscreen.d;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.c.f;
import com.kwad.components.core.proxy.e;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends e {
    private KsSplashScreenAd.SplashScreenAdInteractionListener Ce;
    private com.kwad.sdk.core.h.b bT;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;

    private void a(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    public static b b(@NonNull AdResultData adResultData, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Bundle bundle = new Bundle();
        bundle.putInt("ad_result_cache_idx", f.mE().i(adResultData));
        b bVar2 = new b();
        bVar2.setArguments(bundle);
        bVar2.a(bVar);
        bVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return bVar2;
    }

    private void initData() {
        int i10 = getArguments().getInt("ad_result_cache_idx");
        if (i10 > 0) {
            AdResultData d10 = f.mE().d(i10, true);
            this.mAdResultData = d10;
            this.mAdTemplate = c.n(d10);
        }
    }

    private void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Ce = splashScreenAdInteractionListener;
    }

    @Override // com.kwad.components.core.proxy.e
    public final ViewGroup lN() {
        initData();
        if (this.mAdTemplate == null) {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.a((AdTemplate) null, "adTemplate null", false);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowError(0, "data parse error");
            }
            return null;
        }
        return com.kwad.components.ad.splashscreen.c.a(this.mContext, this.mAdResultData, false, this.bT, this.Ce);
    }
}
