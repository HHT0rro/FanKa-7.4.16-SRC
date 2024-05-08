package com.wangmai.tanx.processer;

import android.content.Context;
import android.view.ViewGroup;
import appa.appa.appe.appc;
import appa.appa.appf.appd;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import com.huawei.openalliance.ad.constant.u;
import com.wangmai.bean.ExpressProcessorBean;
import com.wangmai.common.Ilistener.IWMCommonListener;
import com.wangmai.tanx.TanxSdkHelper;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class TanxWMNativeExpressProcesser extends appc {
    private static final String TAG = "TanxWMExpressProcesser";
    List<ITanxFeedExpressAd> adList;
    private ExpressProcessorBean expressProcessorBean;
    ITanxAdLoader iTanxAdLoader;
    ITanxFeedExpressAd tanxFeedExpressAd;

    public TanxWMNativeExpressProcesser(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        ExpressProcessorBean expressProcessorBean = this.expressProcessorBean;
        return (expressProcessorBean == null || expressProcessorBean.getAdListener() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnFeedAdListener() {
        ITanxFeedExpressAd iTanxFeedExpressAd = this.tanxFeedExpressAd;
        if (iTanxFeedExpressAd != null) {
            iTanxFeedExpressAd.setOnFeedAdListener(new ITanxFeedExpressAd.OnFeedAdListener() { // from class: com.wangmai.tanx.processer.TanxWMNativeExpressProcesser.2
                @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
                public void onAdClose(ITanxAd iTanxAd) {
                    if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                        TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onAdClose();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
                public void onAdShow(ITanxAd iTanxAd) {
                    if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                        TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onExposure();
                        TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().appa();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
                public void onClick(ITanxAd iTanxAd) {
                    if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                        TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onClick();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
                public void onError(String str) {
                    if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                        TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd("[xt.mw native express] 链路异常:" + str);
                    }
                }
            });
        }
    }

    @Override // appa.appa.appe.appc
    public void nativeExpressAd(final ExpressProcessorBean expressProcessorBean) {
        try {
            this.expressProcessorBean = expressProcessorBean;
            appd.appa(TAG, "[xt.mw native express] load appId:" + expressProcessorBean.getAppId(), "appKey:" + expressProcessorBean.getAppKey(), "slotId:" + expressProcessorBean.getSlotId());
            TanxSdkHelper.getInstance().init(getApplication(), expressProcessorBean.getAppId(), expressProcessorBean.getAppKey(), new IWMCommonListener() { // from class: com.wangmai.tanx.processer.TanxWMNativeExpressProcesser.1
                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void fail(String str) {
                    if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                        TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd(str);
                    }
                }

                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void success() {
                    TanxAdSlot build = new TanxAdSlot.Builder().adCount(1).pid(expressProcessorBean.getSlotId()).setExpressViewAcceptedSize(0).build();
                    TanxWMNativeExpressProcesser.this.iTanxAdLoader = TanxSdk.getSDKManager().createAdLoader(TanxWMNativeExpressProcesser.this.getApplicationContext());
                    TanxWMNativeExpressProcesser.this.iTanxAdLoader.loadFeedAd(build, new ITanxAdLoader.OnAdLoadListener<ITanxFeedExpressAd>() { // from class: com.wangmai.tanx.processer.TanxWMNativeExpressProcesser.1.1
                        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                        public void onError(TanxError tanxError) {
                            if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("[xt.mw native express] 广告请求失败(onError)");
                                if (tanxError != null) {
                                    sb2.append(u.bD);
                                    sb2.append(tanxError.getCode());
                                    sb2.append(",");
                                    sb2.append(tanxError.getMessage());
                                }
                                TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd(sb2.toString());
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
                        public void onLoaded(List<ITanxFeedExpressAd> list) {
                            if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                                if (list == null || list.isEmpty()) {
                                    TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd("[xt.mw native express] 暂无填充");
                                    return;
                                }
                                TanxWMNativeExpressProcesser tanxWMNativeExpressProcesser = TanxWMNativeExpressProcesser.this;
                                tanxWMNativeExpressProcesser.adList = list;
                                tanxWMNativeExpressProcesser.tanxFeedExpressAd = tanxWMNativeExpressProcesser.adList.get(0);
                                TanxWMNativeExpressProcesser.this.setOnFeedAdListener();
                                long adPrice = TanxWMNativeExpressProcesser.this.tanxFeedExpressAd.getBiddingInfo().getAdPrice();
                                appd.appa(TanxWMNativeExpressProcesser.TAG, "[xt.mw native express] 响应成功 ecpm:" + adPrice);
                                TanxWMNativeExpressProcesser.this.setDspPrice((int) adPrice);
                                ViewGroup adsParent = TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdsParent();
                                adsParent.addView(TanxWMNativeExpressProcesser.this.tanxFeedExpressAd.getAdView());
                                TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onRenderSuccess(adsParent, 0, 0);
                                TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onAdRequest();
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                        public void onTimeOut() {
                            if (TanxWMNativeExpressProcesser.this.checkProcessorBean()) {
                                TanxWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd("[xt.mw native express] 请求超时(onTimeOut)");
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
            if (checkProcessorBean()) {
                this.expressProcessorBean.getAdListener().onNoAd("[xt.mw native express] 加载失败:" + th.getMessage());
            }
        }
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        try {
            if (this.iTanxAdLoader != null) {
                this.iTanxAdLoader.destroy();
                this.iTanxAdLoader = null;
            }
            if (this.tanxFeedExpressAd != null) {
                this.tanxFeedExpressAd = null;
            }
            if (this.expressProcessorBean != null) {
                this.expressProcessorBean.setAdListener(null);
                this.expressProcessorBean = null;
            }
            if (this.adList != null) {
                this.adList.clear();
            }
        } catch (Throwable th) {
            appd.appe(TAG, "[[xt.mw native express] onDestroy error:" + th);
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, final String str2, String str3) {
        try {
            if (this.iTanxAdLoader == null || this.tanxFeedExpressAd == null) {
                return;
            }
            TanxBiddingInfo biddingInfo = this.tanxFeedExpressAd.getBiddingInfo();
            biddingInfo.setBidResult(false);
            biddingInfo.setWinPrice(Double.parseDouble(str2));
            this.tanxFeedExpressAd.setBiddingResult(biddingInfo);
            this.iTanxAdLoader.biddingResult(this.adList, new ITanxRequestLoader.OnBiddingListener<ITanxFeedExpressAd>() { // from class: com.wangmai.tanx.processer.TanxWMNativeExpressProcesser.4
                @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
                public void onResult(List<ITanxFeedExpressAd> list) {
                    appd.appa(TanxWMNativeExpressProcesser.TAG, "[[xt.mw native express] sendLossNotification completed!", "winPrice=" + str2);
                }
            });
        } catch (Throwable th) {
            appd.appe(TAG, "[[xt.mw native express] sendLossNotification fail:" + th);
        }
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(final String str, final String str2) {
        try {
            if (this.iTanxAdLoader == null || this.tanxFeedExpressAd == null) {
                return;
            }
            TanxBiddingInfo biddingInfo = this.tanxFeedExpressAd.getBiddingInfo();
            biddingInfo.setBidResult(true);
            biddingInfo.setWinPrice(Double.parseDouble(str));
            this.tanxFeedExpressAd.setBiddingResult(biddingInfo);
            this.iTanxAdLoader.biddingResult(this.adList, new ITanxRequestLoader.OnBiddingListener<ITanxFeedExpressAd>() { // from class: com.wangmai.tanx.processer.TanxWMNativeExpressProcesser.3
                @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
                public void onResult(List<ITanxFeedExpressAd> list) {
                    appd.appa(TanxWMNativeExpressProcesser.TAG, "[[xt.mw native express] sendWinNotification completed!", "winPrice=" + str, "lossPrice=" + str2);
                }
            });
        } catch (Throwable th) {
            appd.appe(TAG, "[[xt.mw native express] sendWinNotification fail:" + th);
        }
    }
}
