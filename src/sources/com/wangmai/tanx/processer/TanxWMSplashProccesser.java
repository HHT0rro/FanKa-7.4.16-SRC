package com.wangmai.tanx.processer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import appa.appa.appb.appa;
import appa.appa.appe.apph;
import appa.appa.appf.appb;
import appa.appa.appf.appd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdLoadType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import com.huawei.openalliance.ad.constant.u;
import com.wangmai.bean.SplashProcessorBean;
import com.wangmai.common.Ilistener.IWMCommonListener;
import com.wangmai.tanx.TanxSdkHelper;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class TanxWMSplashProccesser extends apph {
    private static final String TAG = "TanxWMSplashProccesser";
    List<ITanxSplashExpressAd> adList;
    ITanxAdLoader iTanxAdLoader;
    ITanxSplashExpressAd splashExpressAd;
    SplashProcessorBean splashProcessorBean;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* renamed from: com.wangmai.tanx.processer.TanxWMSplashProccesser$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class AnonymousClass1 implements IWMCommonListener {
        final /* synthetic */ SplashProcessorBean val$bean;

        AnonymousClass1(SplashProcessorBean splashProcessorBean) {
            this.val$bean = splashProcessorBean;
        }

        @Override // com.wangmai.common.Ilistener.IWMCommonListener
        public void fail(String str) {
            if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd("[xt.mw splash] SDK初始化失败:" + str);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.wangmai.common.Ilistener.IWMCommonListener
        public void success() {
            TanxAdSlot build = new TanxAdSlot.Builder().adCount(1).setFeedBackDialog(true).pid(this.val$bean.getSlotId()).setLoadType(TanxAdLoadType.LOAD).build();
            TanxWMSplashProccesser.this.iTanxAdLoader = TanxSdk.getSDKManager().createAdLoader((Context) TanxWMSplashProccesser.this.getTaskTopActivity().get());
            TanxWMSplashProccesser.this.iTanxAdLoader.loadSplashAd(build, new ITanxAdLoader.OnAdLoadListener<ITanxSplashExpressAd>() { // from class: com.wangmai.tanx.processer.TanxWMSplashProccesser.1.1
                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onError(TanxError tanxError) {
                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("[xt.mw splash] 广告请求失败(onError)");
                        if (tanxError != null) {
                            sb2.append(u.bD);
                            sb2.append(tanxError.getCode());
                            sb2.append(",");
                            sb2.append(tanxError.getMessage());
                        }
                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd(sb2.toString());
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
                public void onLoaded(List<ITanxSplashExpressAd> list) {
                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                        if (list != null && !list.isEmpty()) {
                            TanxWMSplashProccesser tanxWMSplashProccesser = TanxWMSplashProccesser.this;
                            tanxWMSplashProccesser.adList = list;
                            tanxWMSplashProccesser.splashExpressAd = tanxWMSplashProccesser.adList.get(0);
                            long adPrice = TanxWMSplashProccesser.this.splashExpressAd.getBiddingInfo().getAdPrice();
                            appd.appe(TanxWMSplashProccesser.TAG, "[xt.mw splash] 响应成功 ecpm:" + adPrice);
                            TanxWMSplashProccesser.this.setDspPrice((int) adPrice);
                            TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onAdRequest();
                            TanxWMSplashProccesser.this.splashExpressAd.setOnSplashAdListener(new ITanxSplashExpressAd.OnSplashAdListener() { // from class: com.wangmai.tanx.processer.TanxWMSplashProccesser.1.1.1
                                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
                                public void onAdClicked() {
                                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onClick();
                                    }
                                }

                                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
                                public void onAdClosed() {
                                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onAdDismissed();
                                    }
                                }

                                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
                                public void onAdFinish() {
                                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onAdDismissed();
                                    }
                                }

                                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
                                public void onAdRender(ITanxSplashExpressAd iTanxSplashExpressAd) {
                                }

                                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
                                public void onAdShake() {
                                }

                                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
                                public void onAdShow() {
                                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onExposure();
                                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().appa();
                                    }
                                }

                                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
                                public void onShowError(TanxError tanxError) {
                                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("[xt.mw splash] 展示失败");
                                        if (tanxError != null) {
                                            sb2.append(u.bD);
                                            sb2.append(tanxError.getCode());
                                            sb2.append(",");
                                            sb2.append(tanxError.getMessage());
                                        }
                                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().appa(sb2.toString());
                                    }
                                }
                            });
                            return;
                        }
                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd("[xt.mw splash] 暂无填充");
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onTimeOut() {
                    if (TanxWMSplashProccesser.this.checkProcessorBean()) {
                        TanxWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd("[xt.mw splash] 广告请求超时(onTimeOut)");
                    }
                }
            });
        }
    }

    public TanxWMSplashProccesser(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        SplashProcessorBean splashProcessorBean = this.splashProcessorBean;
        return (splashProcessorBean == null || splashProcessorBean.getAdListener() == null) ? false : true;
    }

    @Override // appa.appa.appe.apph
    public void load(SplashProcessorBean splashProcessorBean) {
        try {
            appd.appa(TAG, "[xt.mw splash] load appId:" + splashProcessorBean.getAppId(), "appKey:" + splashProcessorBean.getAppKey(), "slotId:" + splashProcessorBean.getSlotId());
            this.splashProcessorBean = splashProcessorBean;
            TanxSdkHelper.getInstance().init(getApplication(), splashProcessorBean.getAppId(), splashProcessorBean.getAppKey(), new AnonymousClass1(splashProcessorBean));
        } catch (Throwable th) {
            if (checkProcessorBean()) {
                this.splashProcessorBean.getAdListener().onNoAd("[xt.mw splash] 广告加载错误:" + th);
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
            if (this.splashExpressAd != null) {
                this.splashExpressAd = null;
            }
            if (this.splashProcessorBean != null) {
                this.splashProcessorBean.setAdListener(null);
                this.splashProcessorBean = null;
            }
        } catch (Throwable th) {
            appd.appe(TAG, "[[xt.mw splash] onDestroy error:" + th);
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, final String str2, String str3) {
        try {
            if (this.iTanxAdLoader == null || this.splashExpressAd == null) {
                return;
            }
            TanxBiddingInfo biddingInfo = this.splashExpressAd.getBiddingInfo();
            biddingInfo.setBidResult(false);
            biddingInfo.setWinPrice(Double.parseDouble(str2));
            this.splashExpressAd.setBiddingResult(biddingInfo);
            this.iTanxAdLoader.biddingResult(this.adList, new ITanxRequestLoader.OnBiddingListener<ITanxSplashExpressAd>() { // from class: com.wangmai.tanx.processer.TanxWMSplashProccesser.3
                @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
                public void onResult(List<ITanxSplashExpressAd> list) {
                    appd.appa(TanxWMSplashProccesser.TAG, "[xt.mw splash] sendLossNotification completed!", "winPrice=" + str2);
                }
            });
        } catch (Throwable th) {
            appd.appe(TAG, "[xt.mw splash] sendLossNotification fail:" + th);
        }
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(final String str, final String str2) {
        try {
            if (this.iTanxAdLoader == null || this.splashExpressAd == null) {
                return;
            }
            TanxBiddingInfo biddingInfo = this.splashExpressAd.getBiddingInfo();
            biddingInfo.setBidResult(true);
            biddingInfo.setWinPrice(Double.parseDouble(str));
            this.splashExpressAd.setBiddingResult(biddingInfo);
            this.iTanxAdLoader.biddingResult(this.adList, new ITanxRequestLoader.OnBiddingListener<ITanxSplashExpressAd>() { // from class: com.wangmai.tanx.processer.TanxWMSplashProccesser.2
                @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
                public void onResult(List<ITanxSplashExpressAd> list) {
                    appd.appa(TanxWMSplashProccesser.TAG, "[xt.mw splash] sendWinNotification completed!", "winPrice=" + str, "lossPrice=" + str2);
                }
            });
        } catch (Throwable th) {
            appd.appe(TAG, "[xt.mw splash] sendWinNotification fail:" + th);
        }
    }

    @Override // appa.appa.appe.apph
    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.splashExpressAd != null && checkProcessorBean()) {
                    this.splashProcessorBean.getAdListener().appa(appa.NOT_SUPPORT);
                    View adView = this.splashExpressAd.getAdView();
                    appb.appb(adView);
                    viewGroup.addView(adView, new RelativeLayout.LayoutParams(-1, -1));
                }
            } catch (Throwable th) {
                appd.appe(TAG, "[xt.mw splash] 展示失败：" + ((Object) th));
                if (checkProcessorBean()) {
                    this.splashProcessorBean.getAdListener().appa("[xt.mw splash] 展示失败:" + th.getMessage());
                    return;
                }
                return;
            }
        }
        if (checkProcessorBean()) {
            this.splashProcessorBean.getAdListener().appa("[xt.mw splash] 展示失败(SplashExpressAd或者splashContainer为空)");
        }
    }
}
