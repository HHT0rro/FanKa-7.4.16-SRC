package com.wangmai.ad.dex.allmodules.appg.appc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import appa.appa.appf.appd;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.bean.FullScreenVideoProcessorBean;
import com.wangmai.common.Iinterface.IFullScreenInterface;
import com.wangmai.common.Ilistener.XAdFullScreenVideoListener;
import com.wangmai.common.bean.FullScreenBean;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMFullScreenVideoAdDexNew.java */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<IFullScreenInterface> implements IFullScreenInterface {
    private static final List<String> appw = new ArrayList();
    private DemandEntityHandle appv;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMFullScreenVideoAdDexNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.appc.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0687appa implements Runnable {
        RunnableC0687appa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
                ((XAdFullScreenVideoListener) ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc).onAdLoad();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMFullScreenVideoAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements XAdFullScreenVideoListener {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46792appa;
        SdkThirdPlatform appb;
        appa.appa.appe.appb appc;
        appa.appc appd;

        appb(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appa.appa.appe.appb appbVar, appa.appc appcVar) {
            this.f46792appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = appbVar;
            this.appd = appcVar;
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onAdClose() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appd && this.f46792appa.getListener() != null) {
                ((XAdFullScreenVideoListener) this.f46792appa.getListener()).onAdClose();
            }
            appa.this.appv = this.f46792appa;
            appa.this.destroy();
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onAdLoad() {
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.this.appa(this.f46792appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46792appa.getListener() != null) {
                this.f46792appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46792appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46792appa.getListener() != null) {
                this.f46792appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46792appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appd.appe("WMFullScreen", appa.this.appa("WMFullScreen", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46792appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onSkippedVideo() {
            if (this.f46792appa.getListener() != null) {
                ((XAdFullScreenVideoListener) this.f46792appa.getListener()).onSkippedVideo();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onVideoComplete() {
            if (this.f46792appa.getListener() != null) {
                ((XAdFullScreenVideoListener) this.f46792appa.getListener()).onVideoComplete();
            }
        }
    }

    public appa(Activity activity, String str, FullScreenBean fullScreenBean, XAdFullScreenVideoListener xAdFullScreenVideoListener) {
        super(activity, str, null, xAdFullScreenVideoListener, "WMFullScreen");
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    @Override // com.wangmai.common.Iinterface.IFullScreenInterface
    public void destroy() {
        try {
            appd.appa("WMFullScreen", "FullScreen destroy", this.appv, Thread.currentThread().getName());
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
            appd.appe("WMFullScreen", "FullScreen destroy:" + th);
        }
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        return this.appg;
    }

    @Override // com.wangmai.common.Iinterface.IFullScreenInterface
    public void load() {
        appb();
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        appa(bundle);
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        appb((DemandEntityHandle) null);
    }

    @Override // com.wangmai.common.Iinterface.IFullScreenInterface
    public void show(Context context) {
        try {
            if (this.appv == null || this.appv.getSdkProcesser() == null) {
                appd.appb("WMFullScreen", "FullScreen show error:", context, this.appv);
            } else {
                ((appa.appa.appe.appb) this.appv.getSdkProcesser()).appa();
            }
        } catch (Throwable th) {
            appd.appb("WMFullScreen", "FullScreen show error:" + th);
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        String classType;
        String appb2;
        String appc;
        String appe;
        appa.appa.appe.appb appbVar;
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
                String appa2 = appa("WMFullScreen", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appd.appe("WMFullScreen", appa2);
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
            stringBuffer.append("WMFullScreen");
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
            appd.appd("WMFullScreen", stringBuffer.toString());
            appbVar = (appa.appa.appe.appb) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, "fullscreen");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (appa(appbVar, appb2, appe)) {
                appb(sdkThirdPlatform, classType);
                demandEntityHandle.setSdkProcesser(appbVar);
                appbVar.appa(new FullScreenVideoProcessorBean().setAppId(appb2).setAppKey(appc).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setRequestId(this.appj).setCloseRand(this.appk).setMaterialCollectRand(this.appl).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setAdListener(new appb(demandEntityHandle, sdkThirdPlatform, appbVar, appcVar)));
            } else {
                String appa3 = appa("WMFullScreen", sdkThirdPlatform, appbVar, (String) null);
                appd.appe("WMFullScreen", appa3);
                appa(demandEntityHandle, sdkThirdPlatform, appbVar != null ? appbVar.getInValidCrids() : null, appa3, appcVar);
            }
        } catch (Throwable th2) {
            th = th2;
            appaVar = appbVar;
            String appa4 = appa("WMFullScreen", sdkThirdPlatform, appaVar, th.toString());
            appd.appe("WMFullScreen", appa4);
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
            appd.appc("WMFullScreen", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new RunnableC0687appa());
    }
}
