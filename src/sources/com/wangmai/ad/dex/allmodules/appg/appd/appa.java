package com.wangmai.ad.dex.allmodules.appg.appd;

import android.app.Activity;
import android.os.Bundle;
import appa.appa.appd.appd;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.bean.NativeProcessorBean;
import com.wangmai.common.Iinterface.INativePotInterface;
import com.wangmai.common.Ilistener.XAdNativePotListener;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.nativepot.NativeWMResponse;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMNativePotAdDex.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<INativePotInterface> implements INativePotInterface {
    private static List<String> appw = new ArrayList();
    private DemandEntityHandle appv;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMNativePotAdDex.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.appd.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0688appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ DemandEntityHandle f46793appa;

        RunnableC0688appa(DemandEntityHandle demandEntityHandle) {
            this.f46793appa = demandEntityHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
                ((XAdNativePotListener) ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc).onNativePresent(this.f46793appa.getNativeWMResponse());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMNativePotAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements appd {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46794appa;
        SdkThirdPlatform appb;
        appa.appa.appe.appd appc;
        appa.appc appd;

        appb(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appa.appa.appe.appd appdVar, appa.appc appcVar) {
            this.f46794appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = appdVar;
            this.appd = appcVar;
        }

        @Override // appa.appa.appd.appd
        public void appa() {
            try {
                if (this.f46794appa == null || this.f46794appa.getSdkProcesser() == null) {
                    return;
                }
                appa.appw.add(String.valueOf(this.f46794appa.getDemandProcesserKey()));
                appa.this.appa(this.f46794appa.getSdkProcesser().hashCode());
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMNativePot", "缓存移除失败[NativePot]:" + th);
            }
        }

        @Override // appa.appa.appd.appd
        public void appb() {
            appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayReq, this.f46794appa.getDemandPlatformId(), this.f46794appa.getDemandAdSlotId(), (String) null, this.f46794appa.getLastRequestId(), "媒体展示请求(AdSdkDisplayReq)");
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.appa.appf.appd.appa("WMNativePot", "onAdRequest:", appa.this.appj, this.f46794appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46794appa.getListener() != null) {
                this.f46794appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46794appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46794appa.getListener() != null) {
                this.f46794appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46794appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ilistener.XAdNativePotListener
        public void onNativePresent(NativeWMResponse nativeWMResponse) {
            this.f46794appa.setNativeWMResponse(nativeWMResponse);
            appa.this.appa(this.f46794appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appa.appa.appf.appd.appe("WMNativePot", appa.this.appa("WMNativePot", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46794appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }
    }

    public appa(Activity activity, String str, XAdNativePotListener xAdNativePotListener) {
        super(activity, str, null, xAdNativePotListener, "WMNativePot");
        appb();
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    @Override // com.wangmai.common.Iinterface.INativePotInterface
    public void destroy() {
        try {
            appa.appa.appf.appd.appc("WMNativePot", "NativePot destroy", Thread.currentThread().getName());
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
            appa.appa.appf.appd.appe("WMNativePot", "NativePot destroy:" + th.toString());
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        return this.appg;
    }

    @Override // com.wangmai.common.Iinterface.INativePotInterface
    public boolean isReady() {
        return this.appd;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        appa(bundle);
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        appb(this.appv);
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        String classType;
        String appb2;
        String appc;
        String appe;
        appa.appa.appe.appd appdVar;
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
                String appa2 = appa("WMNativePot", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appa.appa.appf.appd.appe("WMNativePot", appa2);
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
            stringBuffer.append("WMNativePot");
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
            appa.appa.appf.appd.appd("WMNativePot", stringBuffer.toString());
            appdVar = (appa.appa.appe.appd) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, "nativead");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (appa(appdVar, appb2, appe)) {
                appb(sdkThirdPlatform, classType);
                demandEntityHandle.setSdkProcesser(appdVar);
                appdVar.nativeAd(new NativeProcessorBean().setAppId(appb2).setAppKey(appc).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setRequestId(this.appj).setCloseRand(this.appk).setMaterialCollectRand(this.appl).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setAdListener(new appb(demandEntityHandle, sdkThirdPlatform, appdVar, appcVar)));
            } else {
                String appa3 = appa("WMNativePot", sdkThirdPlatform, appdVar, (String) null);
                appa.appa.appf.appd.appe("WMNativePot", appa3);
                appa(demandEntityHandle, sdkThirdPlatform, appdVar != null ? appdVar.getInValidCrids() : null, appa3, appcVar);
            }
        } catch (Throwable th2) {
            th = th2;
            appaVar = appdVar;
            String appa4 = appa("WMNativePot", sdkThirdPlatform, appaVar, th.toString());
            appa.appa.appf.appd.appe("WMNativePot", appa4);
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
            appa.appa.appf.appd.appc("WMNativePot", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new RunnableC0688appa(demandEntityHandle));
    }
}
