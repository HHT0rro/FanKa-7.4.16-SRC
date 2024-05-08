package com.wangmai.ad.dex.allmodules.appg.appf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import appa.appa.appe.appf;
import appa.appa.appf.appd;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.bean.PopupProcessorBean;
import com.wangmai.common.Iinterface.InterstitialInterface;
import com.wangmai.common.Ilistener.XAdInterstitialListener;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMInterstitialAdDexNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<InterstitialInterface> implements InterstitialInterface {
    private static List<String> appw = new ArrayList();
    private DemandEntityHandle appv;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdDexNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.appf.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0690appa implements Runnable {
        RunnableC0690appa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
            }
        }
    }

    public appa(Activity activity, String str, XAdInterstitialListener xAdInterstitialListener) {
        super(activity, str, null, xAdInterstitialListener, "WMInterstitial");
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void close() {
        try {
            if (this.appv == null || this.appv.getSdkProcesser() == null) {
                return;
            }
            ((appf) this.appv.getSdkProcesser()).closeAd();
        } catch (Throwable th) {
            appd.appe("WMInterstitial", "Interstitial close error:" + th);
        }
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void destroy() {
        try {
            appd.appa("WMInterstitial", "Interstitial destroy", this.appv, Thread.currentThread().getName());
            if (this.appv != null) {
                if (appa() && !appw.contains(String.valueOf(this.appv.getDemandProcesserKey()))) {
                    this.appv.setListener(null);
                }
                appw.remove(String.valueOf(this.appv.getDemandProcesserKey()));
                this.appv.onDestroy();
                this.appv = null;
            }
            this.appc = null;
        } catch (Throwable th) {
            appd.appe("WMInterstitial", "Interstitial destroy:" + th);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        return this.appg;
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public boolean isReady() {
        return this.appd;
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void load() {
        appb();
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        appa(bundle);
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        appb(this.appv);
    }

    @Override // com.wangmai.common.Iinterface.InterstitialInterface
    public void show(Context context) {
        try {
            appd.appa("WMInterstitial", "Interstitial show", Thread.currentThread().getName());
            if (this.appv == null || this.appv.getSdkProcesser() == null) {
                appd.appb("WMInterstitial", "Interstitial show error:", context, this.appv);
            } else {
                appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayReq, this.appv.getDemandPlatformId(), this.appv.getDemandAdSlotId(), (String) null, "媒体展示请求(AdSdkDisplayReq)");
                ((appf) this.appv.getSdkProcesser()).showAd(context);
            }
        } catch (Throwable th) {
            appd.appb("WMInterstitial", "Interstitial show error:" + th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements appa.appa.appd.appb {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46798appa;
        SdkThirdPlatform appb;
        appf appc;
        appa.appc appd;

        appb(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appf appfVar, appa.appc appcVar) {
            this.f46798appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = appfVar;
            this.appd = appcVar;
        }

        @Override // appa.appa.appd.appb
        public void appa() {
            try {
                if (this.f46798appa == null || this.f46798appa.getSdkProcesser() == null) {
                    return;
                }
                appa.appw.add(String.valueOf(this.f46798appa.getDemandProcesserKey()));
                appa.this.appa(this.f46798appa.getSdkProcesser().hashCode());
            } catch (Throwable th) {
                appd.appe("WMInterstitial", "缓存移除失败[Interstitial]:" + th);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdInterstitialListener
        public void onAdClose() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appd && this.f46798appa.getListener() != null) {
                ((XAdInterstitialListener) this.f46798appa.getListener()).onAdClose();
            }
            appa.this.appv = this.f46798appa;
            appa.this.destroy();
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.this.appa(this.f46798appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46798appa.getListener() != null) {
                this.f46798appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46798appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46798appa.getListener() != null) {
                this.f46798appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46798appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appd.appe("WMInterstitial", appa.this.appa("WMInterstitial", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46798appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }

        @Override // appa.appa.appd.appb
        public void appa(String str) {
            appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayRespFailure, this.f46798appa.getDemandPlatformId(), this.f46798appa.getDemandAdSlotId(), str, this.f46798appa.getLastRequestId(), "曝光失败打点(AdSdkDisplayRespFailure)");
        }

        @Override // appa.appa.appd.appb
        public void appa(appa.appa.appb.appa appaVar) {
            if (appaVar == appa.appa.appb.appa.READY) {
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkPrepareSuccess, this.f46798appa.getDemandPlatformId(), this.f46798appa.getDemandAdSlotId(), (String) null, this.f46798appa.getLastRequestId(), "广告准备完毕打点(AdSdkPrepareSuccess)");
            } else if (appaVar == appa.appa.appb.appa.NOT_READY) {
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkPrepareFailure, this.f46798appa.getDemandPlatformId(), this.f46798appa.getDemandAdSlotId(), "广告无效或已过期", this.f46798appa.getLastRequestId(), "广告无效或已过期打点(AdSdkPrepareFailure)");
            }
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        this.appr = sdkThirdPlatform;
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
                String appa2 = appa("WMInterstitial", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appd.appe("WMInterstitial", appa2);
                appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa2, appcVar);
                return;
            }
            String name = sdkThirdPlatform.getName();
            String classType = sdkThirdPlatform.getClassType();
            String appb2 = appb(sdkThirdPlatform);
            String appc = appc(sdkThirdPlatform);
            String appe = appe(sdkThirdPlatform);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("@@@@@@@@ 当前开始执行的需求方[");
            stringBuffer.append("WMInterstitial");
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
            stringBuffer.append(appe);
            stringBuffer.append(",biddingType=");
            stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType());
            stringBuffer.append(",sortType=");
            stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType());
            stringBuffer.append(",requestId=");
            stringBuffer.append(this.appj);
            appd.appd("WMInterstitial", stringBuffer.toString());
            appf appfVar = (appf) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, "popad");
            try {
                if (appa(appfVar, appb2, appe)) {
                    appb(sdkThirdPlatform, classType);
                    demandEntityHandle.setSdkProcesser(appfVar);
                    appfVar.topup(new PopupProcessorBean().setAppId(appb2).setAppKey(appc).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setRequestId(this.appj).setCloseRand(this.appk).setMaterialCollectRand(this.appl).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setAdListener(new appb(demandEntityHandle, sdkThirdPlatform, appfVar, appcVar)));
                    appfVar.loadAd();
                    return;
                }
                String appa3 = appa("WMInterstitial", sdkThirdPlatform, appfVar, (String) null);
                appd.appe("WMInterstitial", appa3);
                appa(demandEntityHandle, sdkThirdPlatform, appfVar != null ? appfVar.getInValidCrids() : null, appa3, appcVar);
            } catch (Throwable th) {
                th = th;
                appaVar = appfVar;
                String appa4 = appa("WMInterstitial", sdkThirdPlatform, appaVar, th.toString());
                appd.appe("WMInterstitial", appa4);
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
            appd.appc("WMInterstitial", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new RunnableC0690appa());
    }
}
