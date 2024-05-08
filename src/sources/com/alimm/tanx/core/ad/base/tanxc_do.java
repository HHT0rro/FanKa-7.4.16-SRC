package com.alimm.tanx.core.ad.base;

import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import com.alimm.tanx.core.ad.base.tanxc_do;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeCallback;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.event.track.expose.tanxc_if;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.loader.NewTanxAdLoader;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdLoadType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseTanxAd.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class tanxc_do implements ITanxAd {
    public AdClickInfo adClickInfo;
    public TanxAdSlot adSlot;
    public BidInfo bidInfo;
    public ExposeCallback clickExposeCallback;
    public List<tanxc_if> clickList;
    public boolean hasExposure;
    public ExposeCallback impExposeCallback;
    public List<tanxc_if> impList;
    public boolean isReadyExposure;
    public boolean isResourceLoadSuccess;
    public Boolean lastIsReadyExposure = null;
    public Boolean lastIsResourceLoadSuccess = null;
    public TanxBiddingInfo mBiddingInfo;
    public String reqId;
    public String scene;
    public ITanxInteractionListener tanxInteractionListener;

    public tanxc_do(final TanxAdSlot tanxAdSlot, BidInfo bidInfo, final String str, String str2) {
        this.isResourceLoadSuccess = true;
        this.scene = str2;
        this.adSlot = tanxAdSlot;
        this.bidInfo = bidInfo;
        this.reqId = str;
        if (tanxAdSlot.isExpressRender()) {
            this.isResourceLoadSuccess = false;
        }
        this.impExposeCallback = new ExposeCallback() { // from class: com.alimm.tanx.core.ad.base.tanxc_do.1
            @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
            public void onFail(int i10, String str3, String str4) {
                TanxCommonUt.sendExposureFail(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str4, i10, str3);
            }

            @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
            public void onSucceed(int i10, String str3) {
                TanxCommonUt.sendExposureSuc(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str3);
            }

            @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
            public void send(String str3) {
            }
        };
        this.clickExposeCallback = new ExposeCallback() { // from class: com.alimm.tanx.core.ad.base.tanxc_do.2
            @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
            public void onFail(int i10, String str3, String str4) {
                TanxCommonUt.sendClickExposureFail(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str4, i10, str3);
            }

            @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
            public void onSucceed(int i10, String str3) {
                TanxCommonUt.sendClickExposureSuc(tanxAdSlot.getPid(), str, tanxc_do.this.bidInfo, str3);
            }

            @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
            public void send(String str3) {
            }
        };
    }

    private void adExposeDeleteAndPreLoad() {
        if (this.adSlot != null) {
            com.alimm.tanx.core.common.tanxc_do.tanxc_do(new Runnable() { // from class: t.a
                @Override // java.lang.Runnable
                public final void run() {
                    tanxc_do.this.dexa();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa() {
        try {
            if (this.adSlot.getAdType() == 1 && !TextUtils.isEmpty(this.adSlot.getPid())) {
                FileUtils.delete(SplashAdCacheManager.getSplashAdResponseFile(TanxCoreSdk.getApplication(), this.adSlot.getPid()));
            }
            if (this.adSlot.getLoadType() != null && this.adSlot.getLoadType().equals(TanxAdLoadType.PRELOAD) && this.adSlot.getAdType() == 1) {
                new NewTanxAdLoader(TanxCoreSdk.getApplication()).preloadSplashAd(this.adSlot);
            }
        } catch (Exception e2) {
            LogUtils.e(e2);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), e2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(TanxAdView tanxAdView) {
        bindAdView(tanxAdView, null);
    }

    public void doClickExposure(TanxAdView tanxAdView) {
        if (this.adClickInfo == null) {
            this.adClickInfo = new AdClickInfo(this.adSlot, this.reqId, this.bidInfo, getAdClickUtKey());
        }
        com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(tanxAdView.getContext(), this.adClickInfo, true);
        if (this.tanxInteractionListener != null) {
            LogUtils.d("TanxSDK-DoClick", "媒体侧点击回调 reqId:" + this.reqId);
            this.tanxInteractionListener.onAdClicked(tanxAdView, this);
        }
        ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.CLICK, getMonitorList("click"), this.clickExposeCallback);
    }

    public void doImpExposure() {
        int adType = getAdSlot().getAdType();
        LogUtils.d("doImpExposure", "fromType:" + TanxAdType.getAdTypeStr(adType) + " isReadyExposure:" + this.isReadyExposure + " isResourceLoadSuccess:" + this.isResourceLoadSuccess);
        if (!this.hasExposure) {
            Boolean bool = this.lastIsReadyExposure;
            if (bool != null && this.lastIsResourceLoadSuccess != null && bool.booleanValue() == this.isReadyExposure && this.lastIsResourceLoadSuccess.booleanValue() == this.isResourceLoadSuccess) {
                LogUtils.d("doImpExposure", "防止重复埋点");
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("isReadyExposure", this.isReadyExposure + "");
                hashMap.put("isResourceLoadSuccess", this.isResourceLoadSuccess + "");
                TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, TanxAdType.getAdTypeStr(adType) + " - doImpExposure", AdUtConstants.INTO_METHOD, hashMap);
                this.lastIsReadyExposure = Boolean.valueOf(this.isReadyExposure);
                this.lastIsResourceLoadSuccess = Boolean.valueOf(this.isResourceLoadSuccess);
            }
        }
        if (this.isReadyExposure && this.isResourceLoadSuccess) {
            if (!this.hasExposure) {
                LogUtils.d("TanxSDK-DoImpExposure", "达到曝光条件埋点..  reqId：" + getRequestId());
                TanxCommonUt.sendStartImp(this.adSlot, this.reqId, this.bidInfo, adType);
            }
            if (this.tanxInteractionListener != null && !this.hasExposure) {
                LogUtils.d("TanxSDK-DoImpExposure", "媒体侧曝光回调  reqId：" + getRequestId());
                this.tanxInteractionListener.onAdShow(this);
                adExposeDeleteAndPreLoad();
            }
            if (this.hasExposure) {
                return;
            }
            ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.EXPOSE, getMonitorList("imp"), this.impExposeCallback);
            this.hasExposure = true;
        }
    }

    public abstract AdUtConstants getAdClickUtKey();

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public TanxAdSlot getAdSlot() {
        return this.adSlot;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        return this.bidInfo;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public TanxBiddingInfo getBiddingInfo() {
        if (this.mBiddingInfo == null) {
            TanxBiddingInfo tanxBiddingInfo = new TanxBiddingInfo();
            this.mBiddingInfo = tanxBiddingInfo;
            tanxBiddingInfo.setAdPrice(this.bidInfo.getBidPrice());
        }
        return this.mBiddingInfo;
    }

    public List<tanxc_if> getMonitorList(String str) {
        if ("click".equals(str)) {
            if (this.clickList == null) {
                this.clickList = new ArrayList();
                BidInfo bidInfo = this.bidInfo;
                if (bidInfo != null && bidInfo.getMonitorBean() != null && this.bidInfo.getMonitorBean().getClickTrackUrl() != null) {
                    Iterator<String> iterator2 = this.bidInfo.getMonitorBean().getClickTrackUrl().iterator2();
                    while (iterator2.hasNext()) {
                        this.clickList.add(new tanxc_if(iterator2.next(), str, false));
                    }
                }
            }
            return this.clickList;
        }
        if (!"imp".equals(str)) {
            return null;
        }
        if (this.impList == null) {
            this.impList = new ArrayList();
            BidInfo bidInfo2 = this.bidInfo;
            if (bidInfo2 != null && bidInfo2.getMonitorBean() != null && this.bidInfo.getMonitorBean().getImpTrackUrl() != null) {
                Iterator<String> iterator22 = this.bidInfo.getMonitorBean().getImpTrackUrl().iterator2();
                while (iterator22.hasNext()) {
                    this.impList.add(new tanxc_if(iterator22.next(), str, true));
                }
            }
        }
        return this.impList;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public String getRequestId() {
        return this.reqId;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return this.scene;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void onResourceLoadSuccess() {
        this.isResourceLoadSuccess = true;
        doImpExposure();
    }

    public void setBidInfo(BidInfo bidInfo) {
        this.bidInfo = bidInfo;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAdBidding
    public void setBiddingResult(TanxBiddingInfo tanxBiddingInfo) {
        this.mBiddingInfo = tanxBiddingInfo;
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    public void bindAdView(final TanxAdView tanxAdView, ITanxInteractionListener iTanxInteractionListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bindAdView->adView:");
        sb2.append(tanxAdView == null ? "null" : "不为空");
        sb2.append("interactionListener:");
        sb2.append(iTanxInteractionListener != null ? "不为空" : "null");
        LogUtils.d("bindView", sb2.toString());
        if (tanxAdView != null) {
            this.tanxInteractionListener = iTanxInteractionListener;
            tanxAdView.setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.base.BaseTanxAd$3
                @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
                public void viewClick(View view) {
                    tanxc_do.this.doClickExposure(tanxAdView);
                }
            });
        }
    }
}
