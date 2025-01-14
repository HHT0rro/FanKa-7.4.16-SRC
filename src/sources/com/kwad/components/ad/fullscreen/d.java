package com.kwad.components.ad.fullscreen;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d extends com.kwad.components.ad.reward.e.c {
    private AdTemplate mAdTemplate;
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;

    public final void b(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.mInteractionListener = fullScreenVideoAdInteractionListener;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void bJ() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void h(boolean z10) {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i10, int i11) {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayError(i10, i11);
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j10) {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onSkippedVideo();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
