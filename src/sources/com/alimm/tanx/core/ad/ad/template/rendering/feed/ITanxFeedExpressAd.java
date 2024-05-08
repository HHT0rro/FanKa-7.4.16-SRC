package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxFeedExpressAd extends INewTanxExpressAd {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnFeedAdListener {
        void onAdClose(ITanxAd iTanxAd);

        void onAdShow(ITanxAd iTanxAd);

        void onClick(ITanxAd iTanxAd);

        void onError(String str);
    }

    void setOnFeedAdListener(OnFeedAdListener onFeedAdListener);
}
