package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.interaction.AdClickHandler;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.utils.LogUtils;

/* compiled from: RewardNewBrowseManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_for {
    public final tanxc_new tanxc_do;
    public AdClickInfo tanxc_for;
    public ITanxRewardVideoAd tanxc_if;

    public tanxc_for(tanxc_new tanxc_newVar) {
        this.tanxc_do = tanxc_newVar;
        if (tanxc_newVar != null) {
            this.tanxc_if = tanxc_newVar.tanxc_if;
        }
    }

    private boolean tanxc_if(Context context) {
        ITanxRewardVideoAd iTanxRewardVideoAd;
        if (this.tanxc_do == null || (iTanxRewardVideoAd = this.tanxc_if) == null) {
            return false;
        }
        iTanxRewardVideoAd.bindRewardVideoAdView(new TanxAdView(context), new ITanxInteractionListener<ITanxRewardVideoAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for.1
            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd2) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardNewBrowseManager", "onAdClicked");
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd2) {
                LogUtils.d("RewardNewBrowseManager", "onAdShow");
                if (tanxc_for.this.tanxc_do != null && tanxc_for.this.tanxc_do.tanxc_if() != null) {
                    tanxc_for.this.tanxc_do.tanxc_if().onAdShow(iTanxRewardVideoAd2);
                }
                tanxc_for.this.tanxc_if.clickUpload();
            }
        });
        return true;
    }

    public boolean tanxc_do(Context context) {
        if (this.tanxc_do != null && this.tanxc_if != null) {
            AdClickHandler adClickHandler = new AdClickHandler();
            AdClickInfo adClickInfo = new AdClickInfo(this.tanxc_if.getAdSlot(), this.tanxc_if.getRequestId(), this.tanxc_if.getBidInfo(), AdUtConstants.REWARD_NEW_BROWSE_NAVIGATE);
            this.tanxc_for = adClickInfo;
            if (adClickHandler.handleClickAndUt(context, adClickInfo, true, true)) {
                tanxc_if(context);
                this.tanxc_if.onResourceLoadSuccess();
                return true;
            }
        }
        return false;
    }
}
