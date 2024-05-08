package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener;
import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxRewardExpressAd extends INewTanxExpressAd {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnRewardAdListener extends ITanxRewardVideoInteractionListener {
    }

    void setOnRewardAdListener(OnRewardAdListener onRewardAdListener);

    void showAd(Activity activity);

    void showAd(Activity activity, VideoParam videoParam);
}
