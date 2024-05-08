package com.alimm.tanx.core.ad.ad.table.screen;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxTableScreenAd extends ITanxAd {
    void bindTableScreenAdView(TanxAdView tanxAdView, ITanxInteractionListener iTanxInteractionListener);

    void click(String str, String str2);

    void shake();
}
