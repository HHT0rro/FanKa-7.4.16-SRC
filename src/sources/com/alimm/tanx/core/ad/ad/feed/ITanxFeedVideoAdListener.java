package com.alimm.tanx.core.ad.ad.feed;

import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxFeedVideoAdListener<T extends ITanxFeedAd> {
    void onError(TanxError tanxError);

    void onProgressUpdate(long j10, long j11);

    void onVideoAdPaused(ITanxFeedAd iTanxFeedAd);

    void onVideoAdStartPlay(ITanxFeedAd iTanxFeedAd);

    void onVideoComplete();

    void onVideoError(TanxPlayerError tanxPlayerError);

    void onVideoLoad(ITanxFeedAd iTanxFeedAd);
}
