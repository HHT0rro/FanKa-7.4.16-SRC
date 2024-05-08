package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.view.feed.ITanxFeedCacheContext;

/* compiled from: TanxFeedExpressAd.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<ITanxFeedAd> implements ITanxFeedExpressAd, ITanxFeedCacheContext {
    public ITanxFeedExpressAd.OnFeedAdListener tanxc_do;
    public tanxc_for tanxc_if;
    public final Context tanxc_int;
    public TanxFeedAdView tanxc_new;

    public tanxc_if(Context context, ITanxFeedAd iTanxFeedAd, tanxc_for tanxc_forVar) {
        super(iTanxFeedAd);
        this.tanxc_int = context;
        this.tanxc_if = tanxc_forVar;
    }

    private boolean tanxc_int() {
        T t2 = this.tanxc_for;
        return (t2 == 0 || ((ITanxFeedAd) t2).getBidInfo() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getWebType2Int() != 2) ? false : true;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return TanxAdType.FEED_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        if (tanxFeedAdView != null) {
            tanxFeedAdView.loadAdStyle();
        }
    }

    @Override // com.alimm.tanx.core.view.feed.ITanxFeedCacheContext
    public View remove() {
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        this.tanxc_new = null;
        return tanxFeedAdView;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd
    public void setOnFeedAdListener(ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        this.tanxc_do = onFeedAdListener;
    }

    private boolean tanxc_for() {
        T t2 = this.tanxc_for;
        if (t2 == 0 || ((ITanxFeedAd) t2).getBidInfo() == null || ((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf() == null || TextUtils.isEmpty(((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId())) {
            return false;
        }
        return AdConstants.PID_STYLE_FEED_NATIVE_WEB_ID.equals(((ITanxFeedAd) this.tanxc_for).getBidInfo().getTemplateConf().getPidStyleId());
    }

    private boolean tanxc_if() {
        T t2 = this.tanxc_for;
        if (t2 == 0 || ((ITanxFeedAd) t2).getBidInfo() == null) {
            return false;
        }
        return ((ITanxFeedAd) this.tanxc_for).getBidInfo().getInteractType2FeedSlide();
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView() {
        if (tanxc_for() && tanxc_int()) {
            this.tanxc_new = this.tanxc_if.tanxc_for(this, this.tanxc_int);
        } else if (tanxc_if()) {
            this.tanxc_new = this.tanxc_if.tanxc_if(this, this.tanxc_int);
        } else {
            this.tanxc_new = this.tanxc_if.tanxc_do(this, this.tanxc_int);
        }
        this.tanxc_new.setTanxFeedAd((ITanxFeedAd) this.tanxc_for, this.tanxc_do);
        ITanxFeedAd iTanxFeedAd = (ITanxFeedAd) this.tanxc_for;
        TanxFeedAdView tanxFeedAdView = this.tanxc_new;
        iTanxFeedAd.bindFeedAdView(tanxFeedAdView, tanxFeedAdView.getCloseView(), new ITanxFeedInteractionListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_if.1
            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxFeedAd iTanxFeedAd2) {
                tanxc_do(iTanxFeedAd2);
            }

            @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
            public void onAdClose() {
                tanxc_if tanxc_ifVar = tanxc_if.this;
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_ifVar.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onAdClose(tanxc_ifVar.tanxc_for);
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
            public void onAdDislike() {
                tanxc_if.this.tanxc_new.showDislikeView(tanxc_if.this.tanxc_int, tanxc_if.this.tanxc_do);
            }

            public void tanxc_do(ITanxFeedAd iTanxFeedAd2) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_if.this.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onClick(iTanxFeedAd2);
                }
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_if, reason: merged with bridge method [inline-methods] */
            public void onAdShow(ITanxFeedAd iTanxFeedAd2) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = tanxc_if.this.tanxc_do;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onAdShow(iTanxFeedAd2);
                }
            }
        });
        return this.tanxc_new;
    }
}
