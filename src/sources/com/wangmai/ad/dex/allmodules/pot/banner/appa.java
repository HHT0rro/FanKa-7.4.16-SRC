package com.wangmai.ad.dex.allmodules.pot.banner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.appsdkdex.utils.VisibilityUtils;
import com.wangmai.bean.BannerProcessorBean;
import com.wangmai.common.Iinterface.IBannerInterface;
import com.wangmai.common.Ilistener.XAdBannerListener;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMBannerAdDexNew.java */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<IBannerInterface> implements IBannerInterface {

    /* renamed from: b, reason: collision with root package name */
    private static List<String> f46812b = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private Runnable f46813a;
    private DemandEntityHandle appv;
    private int appw;
    private boolean appx;
    private boolean appy;
    private Runnable appz;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMBannerAdDexNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.pot.banner.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0693appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ DemandEntityHandle f46814appa;

        RunnableC0693appa(DemandEntityHandle demandEntityHandle) {
            this.f46814appa = demandEntityHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
                ((XAdBannerListener) ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc).onRenderSuccess(this.f46814appa.getBannerView(), this.f46814appa.getBannerWidth(), this.f46814appa.getBannerHeight());
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayReq, this.f46814appa.getDemandPlatformId(), this.f46814appa.getDemandAdSlotId(), "媒体展示请求", "媒体展示请求(AdSdkDisplayReq)");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMBannerAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements VisibilityUtils.ViewVisibilityChangeListener {
        appb() {
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void invisible() {
            appa.appa.appf.appd.appa("WMBanner", "bannerDestoryView不可见，停止动画、停止内部刷新");
            appa.this.appq();
            appa.this.appr();
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void visible() {
            appa.appa.appf.appd.appa("WMBanner", "bannerDestoryView可见开启动画，是否开启内部刷新=" + appa.this.appx);
            appa.this.appp();
            appa.this.appb(0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMBannerAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appc implements Runnable {
        appc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.appa.appf.appd.appa("WMBanner", "refreshRunnable");
            try {
                if (((PowerManager) appa.this.appd().getSystemService("power")).isScreenOn()) {
                    appa.appa.appf.appd.appa("WMBanner", "定时刷新任务执行");
                    appa.this.appb();
                } else {
                    appa.appa.appf.appd.appa("WMBanner", "设备屏幕熄灭，停止刷新");
                    appa.this.appr();
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMBanner", "Banner refreshRunnable error:" + th.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMBannerAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appd implements Runnable {
        appd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (appa.this.appv != null && appa.this.appv.getBannerView() != null) {
                    com.wangmai.ad.dex.allmodules.appb.appa.appa(appa.this.appv.getBannerView(), new Random().nextInt(5) + 1);
                    appa.this.appp();
                } else {
                    appa.appa.appf.appd.appe("WMBanner", "开启动画失败，当前bannerView不可用");
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMBanner", "Banner animationRunnable error: " + th.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMBannerAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appe implements appa.appa.appd.appa {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46818appa;
        SdkThirdPlatform appb;
        appa.appa.appe.appa appc;
        appa.appc appd;

        appe(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appa.appa.appe.appa appaVar, appa.appc appcVar) {
            this.f46818appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = appaVar;
            this.appd = appcVar;
        }

        @Override // appa.appa.appd.appa
        public void appa() {
            try {
                if (this.f46818appa == null || this.f46818appa.getSdkProcesser() == null) {
                    return;
                }
                appa.f46812b.add(String.valueOf(this.f46818appa.getDemandProcesserKey()));
                appa.this.appa(this.f46818appa.getDemandProcesserKey());
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMBanner", "缓存移除失败[Banner]:" + th);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdBannerListener
        public void onAdClose() {
            if (!((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appd || this.f46818appa.getListener() == null) {
                return;
            }
            ((XAdBannerListener) this.f46818appa.getListener()).onAdClose();
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.this.appa(this.f46818appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46818appa.getListener() != null) {
                this.f46818appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46818appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46818appa.getListener() != null) {
                this.f46818appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46818appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appa.appa.appf.appd.appe("WMBanner", appa.this.appa("WMBanner", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46818appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }

        @Override // com.wangmai.common.Ilistener.XAdBannerListener
        public void onRenderSuccess(View view, int i10, int i11) {
            this.f46818appa.setBannerView((ViewGroup) view);
            this.f46818appa.setBannerWidth(i10);
            this.f46818appa.setBannerHeight(i11);
        }
    }

    public appa(Activity activity, String str, XAdBannerListener xAdBannerListener) {
        super(activity, str, null, xAdBannerListener, "WMBanner");
        this.appx = false;
        this.appy = false;
        this.appz = new appc();
        this.f46813a = new appd();
        appb();
    }

    private boolean appo() {
        appa.appa.appf.appd.appa("WMBanner", "来自标准SDK请求");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appp() {
        try {
            appa.appa.appf.appd.appa("WMBanner", "startAnimationRunnable:mHandler" + ((Object) this.appt), "isStop=" + this.appy);
            if (this.appt == null || this.appy) {
                return;
            }
            this.appt.removeCallbacks(this.f46813a);
            this.appt.postDelayed(this.f46813a, 8000L);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMBanner", "startAnimationRunnable:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appq() {
        try {
            if (this.appt != null) {
                appa.appa.appf.appd.appa("WMBanner", "stopAnimationRunnable");
                this.appt.removeCallbacks(this.f46813a);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMBanner", "stopAnimationRunnable:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appr() {
        try {
            if (this.appt != null) {
                appa.appa.appf.appd.appa("WMBanner", "stopRefreshInternal");
                this.appt.removeCallbacks(this.appz);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMBanner", "stopRefreshInternal:" + th.toString());
        }
    }

    ViewGroup appm() {
        try {
            if (this.appv != null && this.appv.getBannerView() != null) {
                appa.appa.appf.appd.appe("WMBanner", "定时刷新逻辑触发，清空当前竞胜需求方Banner广告容器");
                appq();
                appr();
                appa.appa.appf.appb.appa(this.appv.getBannerView());
                appa.appa.appf.appb.appb(this.appv.getBannerView());
            }
            appa.appa.appf.appd.appa("WMBanner", "创建并设置可见监听");
            BannerDestoryView bannerDestoryView = new BannerDestoryView(appd());
            bannerDestoryView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            bannerDestoryView.setGravity(17);
            VisibilityUtils.getInstance().addVisibleChangedListener(bannerDestoryView, new appb());
            return bannerDestoryView;
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMBanner", "createBannerDestroyView:" + th.toString());
            return null;
        }
    }

    @Override // com.wangmai.common.Iinterface.IBannerInterface
    public void destroy() {
        try {
            appa.appa.appf.appd.appc("WMBanner", "Banner destroy", this.appv, Thread.currentThread().getName());
            if (this.appv != null) {
                if (appa() && !f46812b.contains(String.valueOf(this.appv.getDemandProcesserKey()))) {
                    this.appv.setListener(null);
                }
                f46812b.remove(String.valueOf(this.appv.getDemandProcesserKey()));
                this.appv.onDestroy();
                this.appv = null;
            }
            this.appc = null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMBanner", "Banner destroy:" + th.toString());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        return this.appg;
    }

    @Override // com.wangmai.common.Iinterface.IBannerInterface
    public void reset() {
        try {
            appa.appa.appf.appd.appc("WMBanner", "Banner reset", Thread.currentThread().getName());
            this.appy = false;
            appp();
            appb(500);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMBanner", "reset error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        appa(bundle);
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        appb(this.appv);
    }

    @Override // com.wangmai.common.Iinterface.IBannerInterface
    public void stop() {
        try {
            appa.appa.appf.appd.appc("WMBanner", "Banner stop", Thread.currentThread().getName());
            this.appy = true;
            appq();
            appr();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMBanner", "stop error:" + th.toString());
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appb(int i10) {
        try {
            appa.appa.appf.appd.appa("WMBanner", "startRefreshInternal：" + ((Object) this.appt), "isOpenRefresh:" + this.appx, "isStop:" + this.appy);
            if (this.appt == null || !this.appx || this.appy) {
                return;
            }
            this.appt.removeCallbacks(this.appz);
            Handler handler = this.appt;
            Runnable runnable = this.appz;
            if (i10 <= 0) {
                i10 = this.appw * 1000;
            }
            handler.postDelayed(runnable, i10);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMBanner", "startRefreshInternal:" + th.toString());
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        this.appr = sdkThirdPlatform;
        this.appw = appe();
        appa.appa.appf.appd.appa("WMBanner", "后台返回的刷新间隔时间：" + this.appw);
        if (this.appw > 0 && !appo()) {
            this.appx = true;
        }
        appa.appa.appa.appa appaVar = null;
        try {
            if (sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() != 2) {
                double dspBidPrice = sdkThirdPlatform.getSdkThirdAdslotConfig().getDspBidPrice();
                double mediaBidPrice = sdkThirdPlatform.getSdkThirdAdslotConfig().getMediaBidPrice();
                if (dspBidPrice > ShadowDrawableWrapper.COS_45 && mediaBidPrice > ShadowDrawableWrapper.COS_45) {
                    double gapRatio = sdkThirdPlatform.getSdkThirdAdslotConfig().getGapRatio();
                    double priceRatio = sdkThirdPlatform.getSdkThirdAdslotConfig().getPriceRatio();
                    demandEntityHandle.setDspBidPrice((int) Math.round(dspBidPrice * 100.0d));
                    demandEntityHandle.setMediaBidPrice((int) Math.round(mediaBidPrice * 100.0d));
                    demandEntityHandle.setClientBidPrice((int) Math.round(dspBidPrice * gapRatio * priceRatio * 100.0d));
                }
                String appa2 = appa("WMBanner", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appa.appa.appf.appd.appe("WMBanner", appa2);
                appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa2, appcVar);
                return;
            }
            ViewGroup viewGroup = (BannerDestoryView) appm();
            demandEntityHandle.setBannerView(viewGroup);
            demandEntityHandle.setBannerWidth(-1);
            demandEntityHandle.setBannerWidth(-1);
            String name = sdkThirdPlatform.getName();
            String classType = sdkThirdPlatform.getClassType();
            String appb2 = appb(sdkThirdPlatform);
            String appc2 = appc(sdkThirdPlatform);
            String appe2 = appe(sdkThirdPlatform);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("@@@@@@@@ 当前开始执行的需求方[");
            stringBuffer.append("WMBanner");
            stringBuffer.append("]:");
            stringBuffer.append("requestIndex=");
            stringBuffer.append(sdkThirdPlatform.getRequestIndex());
            stringBuffer.append(",demandName=");
            stringBuffer.append(name);
            stringBuffer.append(",demandClassType=");
            stringBuffer.append(classType);
            stringBuffer.append(",demandAppId=");
            stringBuffer.append(appb2);
            stringBuffer.append(",demandAdSlotId=");
            stringBuffer.append(appe2);
            stringBuffer.append(",biddingType=");
            stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType());
            stringBuffer.append(",sortType=");
            stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType());
            stringBuffer.append(",requestId=");
            stringBuffer.append(this.appj);
            appa.appa.appf.appd.appd("WMBanner", stringBuffer.toString());
            appa.appa.appe.appa appaVar2 = (appa.appa.appe.appa) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, IAdInterListener.AdProdType.PRODUCT_BANNER);
            try {
                if (appa(appaVar2, appb2, appe2)) {
                    appb(sdkThirdPlatform, classType);
                    demandEntityHandle.setSdkProcesser(appaVar2);
                    appaVar2.appa(new BannerProcessorBean().setAdsParent(viewGroup).setAppId(appb2).setAppKey(appc2).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setAdslotType(sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotType()).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setRequestId(this.appj).setCloseRand(this.appk).setMaterialCollectRand(this.appl).setAdListener(new appe(demandEntityHandle, sdkThirdPlatform, appaVar2, appcVar)));
                } else {
                    String appa3 = appa("WMBanner", sdkThirdPlatform, appaVar2, (String) null);
                    appa.appa.appf.appd.appe("WMBanner", appa3);
                    appa(demandEntityHandle, sdkThirdPlatform, appaVar2 != null ? appaVar2.getInValidCrids() : null, appa3, appcVar);
                }
            } catch (Throwable th) {
                th = th;
                appaVar = appaVar2;
                String appa4 = appa("WMBanner", sdkThirdPlatform, appaVar, th.toString());
                appa.appa.appf.appd.appe("WMBanner", appa4);
                appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa4, appcVar);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa, com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(DemandEntityHandle demandEntityHandle) {
        super.appa(demandEntityHandle);
        this.appd = true;
        this.appv = demandEntityHandle;
        demandEntityHandle.setListener(this.appc);
        demandEntityHandle.setLastRequestId(this.appj);
        if (demandEntityHandle.getCacheNum() > 1) {
            appa.appa.appf.appd.appc("WMBanner", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new RunnableC0693appa(demandEntityHandle));
    }
}
