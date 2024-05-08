package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.listener.model.IModel;

/* compiled from: FeedExpressPresenter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<IModel, ITanxFeedAd, ITanxFeedExpressAd> {
    public final tanxc_for tanxc_for;

    public tanxc_do(Context context, IModel iModel) {
        super(context, iModel);
        this.tanxc_for = new tanxc_for();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public ITanxFeedExpressAd tanxc_do(ITanxFeedAd iTanxFeedAd) {
        return new tanxc_if(this.tanxc_do, iTanxFeedAd, this.tanxc_for);
    }
}
