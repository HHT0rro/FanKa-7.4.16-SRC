package com.alimm.tanx.core.ad.listener;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.view.TanxAdView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxInteractionListener<T extends ITanxAd> {
    void onAdClicked(TanxAdView tanxAdView, T t2);

    void onAdShow(T t2);
}
