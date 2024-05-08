package com.kwad.components.ad.reward.e;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i extends c {
    private AdTemplate mAdTemplate;
    private String rx;

    private KsRewardVideoAd.RewardAdInteractionListener gS() {
        return f.G(getUniqueId());
    }

    private String getUniqueId() {
        return this.rx;
    }

    public final void K(String str) {
        this.rx = str;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void bJ() {
        super.bJ();
        KsRewardVideoAd.RewardAdInteractionListener gS = gS();
        if (gS != null) {
            gS.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final boolean gR() {
        KsRewardVideoAd.RewardAdInteractionListener gS = gS();
        if (gS != null) {
            gS.onRewardVerify();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        return gS != null;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void h(boolean z10) {
        super.h(z10);
        KsRewardVideoAd.RewardAdInteractionListener gS = gS();
        if (gS != null) {
            gS.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener gS = gS();
        if (gS != null) {
            gS.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i10, int i11) {
        super.onVideoPlayError(i10, i11);
        KsRewardVideoAd.RewardAdInteractionListener gS = gS();
        if (gS != null) {
            gS.onVideoPlayError(i10, i11);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener gS = gS();
        if (gS != null) {
            gS.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j10) {
        super.onVideoSkipToEnd(j10);
        try {
            KsRewardVideoAd.RewardAdInteractionListener gS = gS();
            if (gS != null) {
                gS.onVideoSkipToEnd(j10);
            }
            com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final boolean h(final int i10, final int i11) {
        KsRewardVideoAd.RewardAdInteractionListener gS = gS();
        if (gS != null) {
            gS.onRewardStepVerify(i10, i11);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, new com.kwad.sdk.g.a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i10).setTaskStep(i11);
            }
        });
        return gS != null;
    }
}
