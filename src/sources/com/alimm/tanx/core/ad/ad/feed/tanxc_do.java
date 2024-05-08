package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.monitor.ITanxExposureCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_if;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.TanxAdTemplateId;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TanxFeedAd.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.base.tanxc_do implements ITanxFeedAd {
    public ITanxFeedInteractionListener tanxc_do;
    public FeedVideoManager tanxc_for;
    public com.alimm.tanx.core.view.feed.tanxc_do tanxc_if;

    public tanxc_do(TanxAdSlot tanxAdSlot, BidInfo bidInfo, String str, String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindDislikeView(final List<View> list, final ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener) {
        if (list == null) {
            return;
        }
        Iterator<View> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxFeedAd$3
                @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
                public void viewClick(View view) {
                    ITanxFeedInteractionListener iTanxFeedInteractionListener;
                    ITanxFeedInteractionListener iTanxFeedInteractionListener2;
                    iTanxFeedInteractionListener = tanxc_do.this.tanxc_do;
                    if (iTanxFeedInteractionListener != null) {
                        iTanxFeedInteractionListener2 = tanxc_do.this.tanxc_do;
                        iTanxFeedInteractionListener2.onAdClose();
                        if (list.size() > 1) {
                            if (list.get(0) == view) {
                                InteractionUpload interactionUpload = InteractionUpload.getInstance();
                                List<NewTrackItem> eventTrack = tanxc_do.this.getBidInfo().getEventTrack();
                                InteractionUpload.getInstance();
                                interactionUpload.uploadInteraction(eventTrack, 4);
                                TanxFeedUt.utClose(tanxc_do.this, 0);
                            } else {
                                InteractionUpload interactionUpload2 = InteractionUpload.getInstance();
                                List<NewTrackItem> eventTrack2 = tanxc_do.this.getBidInfo().getEventTrack();
                                InteractionUpload.getInstance();
                                interactionUpload2.uploadInteraction(eventTrack2, 5);
                                TanxFeedUt.utClose(tanxc_do.this, 1);
                            }
                        }
                    }
                    ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener2 = dislikeOnClickListener;
                    if (dislikeOnClickListener2 != null) {
                        dislikeOnClickListener2.onClick(view);
                    }
                }
            });
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindFeedAdView(TanxAdView tanxAdView, View view, ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, getAdSlot().isExpressRender() ? "bindTemplateFeedAdView" : "bindFeedAdView", AdUtConstants.INTO_METHOD, null);
        tanxc_do(tanxAdView, view, iTanxFeedInteractionListener);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void click(TanxAdView tanxAdView) {
        super.doClickExposure(tanxAdView);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public AdUtConstants getAdClickUtKey() {
        if (getBidInfo().getInteractType2FeedSlide()) {
            return AdUtConstants.FLOW_VIEW_INTERACTION_CLICK;
        }
        return AdUtConstants.FLOW_VIEW_CLICK;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public int getAdType() {
        if (TextUtils.isEmpty(this.bidInfo.getTemplateId())) {
            return 0;
        }
        String templateId = this.bidInfo.getTemplateId();
        templateId.hashCode();
        if (templateId.equals(TanxAdTemplateId.FEED_9_16)) {
            return 5;
        }
        return !templateId.equals(TanxAdTemplateId.FEED_VIDEO) ? 0 : 4;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        return super.getBidInfo();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public ITanxVideoView getITanxVideoView(Context context) {
        if (this.tanxc_if == null) {
            this.tanxc_if = new com.alimm.tanx.core.view.feed.tanxc_do();
        }
        if (this.tanxc_for == null) {
            this.tanxc_for = new FeedVideoManager(this, this.tanxc_if, context);
        }
        return this.tanxc_for;
    }

    private void tanxc_do(TanxAdView tanxAdView, View view, final ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("adView:");
        sb2.append(tanxAdView == null ? "null" : "不为空");
        sb2.append("iTanxFeedInteractionListener:");
        sb2.append(iTanxFeedInteractionListener != null ? "不为空" : "null");
        LogUtils.d("bindView", sb2.toString());
        super.bindAdView(tanxAdView, iTanxFeedInteractionListener);
        this.tanxc_do = iTanxFeedInteractionListener;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.feed.tanxc_do.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (iTanxFeedInteractionListener != null) {
                        if (tanxc_do.this.getAdSlot() != null && !tanxc_do.this.getAdSlot().isFeedBackDialog()) {
                            iTanxFeedInteractionListener.onAdClose();
                            InteractionUpload interactionUpload = InteractionUpload.getInstance();
                            List<NewTrackItem> eventTrack = tanxc_do.this.getBidInfo().getEventTrack();
                            InteractionUpload.getInstance();
                            interactionUpload.uploadInteraction(eventTrack, 3);
                            TanxFeedUt.utClose(tanxc_do.this, 2);
                            return;
                        }
                        iTanxFeedInteractionListener.onAdDislike();
                    }
                }
            });
        }
        if (tanxAdView != null) {
            tanxAdView.setAdMonitor(new tanxc_if(tanxAdView, new ITanxExposureCallback() { // from class: com.alimm.tanx.core.ad.ad.feed.tanxc_do.2
                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposure() {
                    tanxc_do.this.isReadyExposure = true;
                    tanxc_do.this.doImpExposure();
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposureTime(long j10) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void onMonitor(Map<String, Object> map) {
                    TanxMonitorUt.sendFeedMonitor(tanxc_do.this.adSlot, tanxc_do.this.reqId, tanxc_do.this.bidInfo.getTemplateId(), tanxc_do.this.bidInfo.getCreativeId(), map, tanxc_do.this.bidInfo.getSessionId());
                }
            }));
        }
    }
}
