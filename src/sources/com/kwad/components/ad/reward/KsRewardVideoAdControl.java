package com.kwad.components.ad.reward;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.constant.TanxAdType;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class KsRewardVideoAdControl implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    private final AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;
    private final AdGlobalConfigInfo ow;
    private com.kwad.components.ad.reward.e.h ox;
    private com.kwad.components.core.i.d oy;
    private com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    public KsRewardVideoAdControl(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate n10 = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n10;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(n10);
        this.ow = adResultData.adGlobalConfigInfo;
        fh();
    }

    private void fh() {
        com.kwad.components.ad.h.b.eI().a(this);
        AdGlobalConfigInfo adGlobalConfigInfo = this.ow;
        boolean z10 = adGlobalConfigInfo != null && adGlobalConfigInfo.isNeoScan();
        this.mAdTemplate.isNativeRewardPreview = com.kwad.sdk.core.response.b.a.bX(this.mAdInfo) && !z10;
    }

    private void fi() {
        AdInfo adInfo;
        if (com.kwad.components.ad.reward.c.c.a(this.ox) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
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

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public List<KSAdInfoData> getKSAdInfoDatas() {
        AdResultData adResultData;
        ArrayList arrayList = new ArrayList();
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asX) && (adResultData = this.mAdResultData) != null && adResultData.getAdTemplateList().size() > 0) {
            Iterator<AdTemplate> iterator2 = this.mAdResultData.getAdTemplateList().iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(com.kwad.sdk.core.response.b.a.db(com.kwad.sdk.core.response.b.e.dQ(iterator2.next())));
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.eg(this.mAdTemplate) >= 0) {
            return true;
        }
        return com.kwad.components.core.video.j.ax(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.oy = new com.kwad.components.core.i.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.ox == null) {
            this.ox = new com.kwad.components.ad.reward.e.h() { // from class: com.kwad.components.ad.reward.KsRewardVideoAdControl.1
                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    KsRewardVideoAdControl.this.bZ.i(KsRewardVideoAdControl.this);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    KsRewardVideoAdControl.this.bZ.h(KsRewardVideoAdControl.this);
                }
            };
        }
        this.ox.b(rewardAdInteractionListener);
    }

    @Keep
    public void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity != null && !activity.isFinishing()) {
            com.kwad.sdk.j.a.ak(TanxAdType.REWARD_STRING, "show");
            com.kwad.components.ad.reward.monitor.c.h(true, this.mAdTemplate);
            com.kwad.sdk.commercial.d.c.by(this.mAdTemplate);
            if (!com.kwad.sdk.core.config.d.CF() && !isAdEnable()) {
                com.kwad.sdk.core.e.c.i("KsRewardVideoAdControl", "isAdEnable is false");
                com.kwad.sdk.j.a.al(TanxAdType.REWARD_STRING, "show");
                com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "cache_not_ready");
                return;
            } else {
                if (ksVideoPlayConfig == null) {
                    ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
                }
                a(activity, ksVideoPlayConfig);
                return;
            }
        }
        com.kwad.sdk.core.e.c.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
        com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "illegal_activity");
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(long j10, long j11) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j10;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j11);
    }

    private void a(Activity activity, @NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        fi();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.isNativeRewardPreview) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdResultData, adTemplate, com.kwad.sdk.core.response.b.a.aS(this.mAdInfo), this.ox);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.ox, this.oy, this.rewardType);
        }
    }
}
