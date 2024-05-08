package com.alimm.tanx.core.ad;

import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxAd extends ITanxAdBidding {
    void bindAdView(TanxAdView tanxAdView);

    void bindAdView(TanxAdView tanxAdView, ITanxInteractionListener iTanxInteractionListener);

    TanxAdSlot getAdSlot();

    BidInfo getBidInfo();

    String getRequestId();

    String getScene();

    void onResourceLoadSuccess();
}
