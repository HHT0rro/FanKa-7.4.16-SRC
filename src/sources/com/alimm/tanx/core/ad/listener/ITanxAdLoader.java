package com.alimm.tanx.core.ad.listener;

import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxAdLoader extends ITanxRequestLoader {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface BaseAdLoadListener {
        void onError(TanxError tanxError);

        void onTimeOut();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnAdLoadListener<T extends INewTanxExpressAd> extends BaseAdLoadListener {
        void onLoaded(List<T> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnRewardAdLoadListener<T extends INewTanxExpressAd> extends BaseAdLoadListener {
        void onLoaded(List<T> list);

        void onRewardVideoCached(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnSplashAdLoadListener extends BaseAdLoadListener {
        void onLoaded(ITanxFeedExpressAd iTanxFeedExpressAd);
    }

    void destroy();

    void loadFeedAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxFeedExpressAd> onAdLoadListener);

    void loadRewardAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener);

    void loadRewardAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener, long j10);

    void loadRewardVideoAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener);

    @Deprecated
    void loadRewardVideoAd(TanxAdSlot tanxAdSlot, OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener, long j10);

    void loadSplashAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxSplashExpressAd> onAdLoadListener);

    void loadSplashAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxSplashExpressAd> onAdLoadListener, long j10);

    void loadTableScreenAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener);

    void loadTableScreenAd(TanxAdSlot tanxAdSlot, OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener, long j10);

    @Deprecated
    void preloadSplashAd(TanxAdSlot tanxAdSlot);
}
