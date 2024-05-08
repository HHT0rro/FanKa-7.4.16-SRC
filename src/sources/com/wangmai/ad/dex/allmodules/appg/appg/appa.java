package com.wangmai.ad.dex.allmodules.appg.appg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import appa.appa.appd.appf;
import appa.appa.appe.appg;
import appa.appa.appf.appd;
import com.alimm.tanx.core.constant.TanxAdType;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.bean.RewardVideoProcessorBean;
import com.wangmai.common.Iinterface.IRewordInterface;
import com.wangmai.common.Ilistener.XAdRewardVideoListener;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMRewardVideoAdDexNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<IRewordInterface> implements IRewordInterface {
    private static List<String> appx = new ArrayList();
    private DemandEntityHandle appv;
    private int appw;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMRewardVideoAdDexNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.appg.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0691appa implements Runnable {
        RunnableC0691appa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
                ((XAdRewardVideoListener) ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc).onAdLoad();
            }
        }
    }

    public appa(Activity activity, String str, int i10, XAdRewardVideoListener xAdRewardVideoListener) {
        super(activity, str, null, xAdRewardVideoListener, "WMReward");
        this.appw = i10;
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    @Override // com.wangmai.common.Iinterface.IRewordInterface
    public void destroy() {
        try {
            appd.appa("WMReward", "Reward destroy", this.appv, Thread.currentThread().getName());
            if (this.appv != null) {
                if (appa() && !appx.contains(String.valueOf(this.appv.getDemandProcesserKey()))) {
                    this.appv.setListener(null);
                }
                appx.remove(String.valueOf(this.appv.getDemandProcesserKey()));
                this.appv.onDestroy();
                this.appv = null;
            }
            this.appc = null;
        } catch (Throwable th) {
            appd.appe("WMReward", "Reward destroy:" + th.toString());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        return this.appg;
    }

    @Override // com.wangmai.common.Iinterface.IRewordInterface
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

    @Override // com.wangmai.common.Iinterface.IRewordInterface
    public void show(Context context) {
        try {
            appd.appa("WMReward", "RewardVideo show", Thread.currentThread().getName());
            if (this.appv == null || this.appv.getSdkProcesser() == null) {
                appd.appb("WMReward", "Reward show error:", context, this.appv);
            } else {
                appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayReq, this.appv.getDemandPlatformId(), this.appv.getDemandAdSlotId(), (String) null, "媒体展示请求(AdSdkDisplayReq)");
                ((appg) this.appv.getSdkProcesser()).show(context);
            }
        } catch (Exception e2) {
            appd.appb("WMReward", "Reward show error:" + e2.toString());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMRewardVideoAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements appf {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46800appa;
        SdkThirdPlatform appb;
        appg appc;
        appa.appc appd;

        appb(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appg appgVar, appa.appc appcVar) {
            this.f46800appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = appgVar;
            this.appd = appcVar;
        }

        @Override // appa.appa.appd.appf
        public void appa(String str) {
            appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayRespFailure, this.f46800appa.getDemandPlatformId(), this.f46800appa.getDemandAdSlotId(), str, this.f46800appa.getLastRequestId(), "曝光失败打点(AdSdkDisplayRespFailure)");
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onAdClose() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appd && this.f46800appa.getListener() != null) {
                ((XAdRewardVideoListener) this.f46800appa.getListener()).onAdClose();
            }
            appa.this.appv = this.f46800appa;
            appa.this.destroy();
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onAdLoad() {
            appd.appa("WMReward", "onAdLoad:", appa.this.appj, this.f46800appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.this.appa(this.f46800appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46800appa.getListener() != null) {
                this.f46800appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46800appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46800appa.getListener() != null) {
                this.f46800appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46800appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appd.appe("WMReward", appa.this.appa("WMReward", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46800appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onRewarded(boolean z10, Bundle bundle) {
            if (this.f46800appa.getListener() != null) {
                ((XAdRewardVideoListener) this.f46800appa.getListener()).onRewarded(z10, bundle);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onVideoComplete() {
            if (this.f46800appa.getListener() != null) {
                ((XAdRewardVideoListener) this.f46800appa.getListener()).onVideoComplete();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onVideoError(String str) {
            if (this.f46800appa.getListener() != null) {
                ((XAdRewardVideoListener) this.f46800appa.getListener()).onVideoError(str);
            }
        }

        @Override // appa.appa.appd.appf
        public void appa() {
            try {
                if (this.f46800appa == null || this.f46800appa.getSdkProcesser() == null) {
                    return;
                }
                appa.appx.add(String.valueOf(this.f46800appa.getDemandProcesserKey()));
                appa.this.appa(this.f46800appa.getDemandProcesserKey());
            } catch (Throwable th) {
                appd.appe("WMReward", "缓存移除失败[Reward]:" + th);
            }
        }

        @Override // appa.appa.appd.appf
        public void appa(appa.appa.appb.appa appaVar) {
            if (appaVar == appa.appa.appb.appa.READY) {
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkPrepareSuccess, this.f46800appa.getDemandPlatformId(), this.f46800appa.getDemandAdSlotId(), (String) null, this.f46800appa.getLastRequestId(), "广告准备完毕打点(AdSdkPrepareSuccess)");
            } else if (appaVar == appa.appa.appb.appa.NOT_READY) {
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkPrepareFailure, this.f46800appa.getDemandPlatformId(), this.f46800appa.getDemandAdSlotId(), "广告无效或已过期", this.f46800appa.getLastRequestId(), "广告无效或已过期打点(AdSdkPrepareFailure)");
            }
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        String classType;
        String appb2;
        String appc;
        String appe;
        appg appgVar;
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
                String appa2 = appa("WMReward", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appd.appe("WMReward", appa2);
                appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa2, appcVar);
                return;
            }
            String name = sdkThirdPlatform.getName();
            classType = sdkThirdPlatform.getClassType();
            appb2 = appb(sdkThirdPlatform);
            appc = appc(sdkThirdPlatform);
            appe = appe(sdkThirdPlatform);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("@@@@@@@@ 当前开始执行的需求方[");
            stringBuffer.append("WMReward");
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
            appd.appd("WMReward", stringBuffer.toString());
            appgVar = (appg) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, TanxAdType.REWARD_STRING);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (appa(appgVar, appb2, appe)) {
                appb(sdkThirdPlatform, classType);
                demandEntityHandle.setSdkProcesser(appgVar);
                appgVar.absReward(new RewardVideoProcessorBean().setAppId(appb2).setAppKey(appc).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setOrientation(this.appw).setRequestId(this.appj).setCloseRand(this.appk).setMaterialCollectRand(this.appl).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setAdListener(new appb(demandEntityHandle, sdkThirdPlatform, appgVar, appcVar)));
            } else {
                String appa3 = appa("WMReward", sdkThirdPlatform, appgVar, (String) null);
                appd.appe("WMReward", appa3);
                appa(demandEntityHandle, sdkThirdPlatform, appgVar != null ? appgVar.getInValidCrids() : null, appa3, appcVar);
            }
        } catch (Throwable th2) {
            th = th2;
            appaVar = appgVar;
            String appa4 = appa("WMReward", sdkThirdPlatform, appaVar, th.toString());
            appd.appe("WMReward", appa4);
            appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa4, appcVar);
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
            appd.appc("WMReward", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new RunnableC0691appa());
    }
}
