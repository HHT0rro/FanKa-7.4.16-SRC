package com.kwad.components.ad.interstitial;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements KsInterstitialAd.AdInteractionListener {

    @Nullable
    private KsInterstitialAd.AdInteractionListener hY;

    public final void a(@Nullable KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hY = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClicked() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClosed() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdShow() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onPageDismiss() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onSkippedAd() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayEnd() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayError(int i10, int i11) {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayError(i10, i11);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayStart() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hY;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayStart();
        }
    }
}
