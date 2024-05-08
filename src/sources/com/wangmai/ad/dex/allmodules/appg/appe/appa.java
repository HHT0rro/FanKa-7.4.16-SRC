package com.wangmai.ad.dex.allmodules.appg.appe;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import appa.appa.appd.appe;
import appa.appa.appf.appd;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.bean.PatchProcessorBean;
import com.wangmai.common.Iinterface.IPatchInterface;
import com.wangmai.common.Ilistener.XAdPatchListener;
import com.wangmai.common.bean.PatchBean;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.enums.EnumPatchType;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMPatchAdDexNew.java */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<IPatchInterface> implements IPatchInterface {
    private static final List<String> appx = new ArrayList();
    private DemandEntityHandle appv;
    private PatchBean appw;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMPatchAdDexNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.appe.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0689appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ DemandEntityHandle f46795appa;

        RunnableC0689appa(DemandEntityHandle demandEntityHandle) {
            this.f46795appa = demandEntityHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
                ((XAdPatchListener) ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc).onAdLoad(this.f46795appa.getMaterialType());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMPatchAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    private class appb implements appe {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46796appa;
        SdkThirdPlatform appb;
        appa.appa.appe.appe appc;
        appa.appc appd;

        appb(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appa.appa.appe.appe appeVar, appa.appc appcVar) {
            this.f46796appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = appeVar;
            this.appd = appcVar;
        }

        @Override // com.wangmai.common.Ilistener.XAdPatchListener
        public void onAdClose() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appd && this.f46796appa.getListener() != null) {
                ((XAdPatchListener) this.f46796appa.getListener()).onAdClose();
            }
            appa.this.appv = this.f46796appa;
            appa.this.destroy();
        }

        @Override // com.wangmai.common.Ilistener.XAdPatchListener
        public void onAdLoad(EnumPatchType enumPatchType) {
            this.f46796appa.setMaterialType(enumPatchType);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.this.appa(this.f46796appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46796appa.getListener() != null) {
                this.f46796appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46796appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46796appa.getListener() != null) {
                this.f46796appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46796appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appd.appe("WMPatch", appa.this.appa("WMPatch", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46796appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }

        @Override // com.wangmai.common.Ilistener.XAdPatchListener
        public void onVideoComplete() {
            if (this.f46796appa.getListener() != null) {
                ((XAdPatchListener) this.f46796appa.getListener()).onVideoComplete();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdPatchListener
        public void onVideoError(String str) {
            if (this.f46796appa.getListener() != null) {
                ((XAdPatchListener) this.f46796appa.getListener()).onVideoError(str);
            }
        }
    }

    public appa(Activity activity, String str, PatchBean patchBean, XAdPatchListener xAdPatchListener) {
        super(activity, str, null, xAdPatchListener, "WMPatch");
        this.appw = patchBean;
        appb();
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public void destroy() {
        try {
            appd.appa("WMPatch", "Patch destroy", this.appv, Thread.currentThread().getName());
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
            appd.appe("WMPatch", "Patch destroy:" + th);
        }
    }

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public long getCurrentPosition() {
        DemandEntityHandle demandEntityHandle = this.appv;
        if (demandEntityHandle == null || demandEntityHandle.getSdkProcesser() == null) {
            return 0L;
        }
        return ((appa.appa.appe.appe) this.appv.getSdkProcesser()).appa();
    }

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public long getDuration() {
        DemandEntityHandle demandEntityHandle = this.appv;
        if (demandEntityHandle == null || demandEntityHandle.getSdkProcesser() == null) {
            return 0L;
        }
        return ((appa.appa.appe.appe) this.appv.getSdkProcesser()).appb();
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public int getECPM() {
        return this.appg;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendLossNotificationWithInfo(Bundle bundle) {
        appa(bundle);
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void sendWinNotificationWithInfo(Bundle bundle) {
        appb(this.appv);
    }

    @Override // com.wangmai.common.Iinterface.IPatchInterface
    public void show(ViewGroup viewGroup) {
        appd.appa("WMPatch", "Patch show", Thread.currentThread().getName());
        try {
            if (this.appv == null || this.appv.getSdkProcesser() == null) {
                return;
            }
            ((appa.appa.appe.appe) this.appv.getSdkProcesser()).show(viewGroup);
            appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayReq, this.appv.getDemandPlatformId(), this.appv.getDemandAdSlotId(), (String) null, "媒体展示请求(AdSdkDisplayReq)");
        } catch (Throwable unused) {
            appd.appa("WMPatch", "Patch show error:", Thread.currentThread().getName());
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        String classType;
        String appb2;
        String appc;
        String appe;
        appa.appa.appe.appe appeVar;
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
                String appa2 = appa("WMPatch", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appd.appe("WMPatch", appa2);
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
            stringBuffer.append("WMPatch");
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
            appd.appd("WMPatch", stringBuffer.toString());
            appeVar = (appa.appa.appe.appe) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, "reward_ordinary");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (appa(appeVar, appb2, appe)) {
                appb(sdkThirdPlatform, classType);
                demandEntityHandle.setSdkProcesser(appeVar);
                appeVar.appa(new PatchProcessorBean().setPatchBean(this.appw).setAppId(appb2).setAppKey(appc).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setRequestId(this.appj).setMaterialCollectRand(this.appl).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setAdListener(new appb(demandEntityHandle, sdkThirdPlatform, appeVar, appcVar)));
            } else {
                String appa3 = appa("WMPatch", sdkThirdPlatform, appeVar, (String) null);
                appd.appe("WMPatch", appa3);
                appa(demandEntityHandle, sdkThirdPlatform, appeVar != null ? appeVar.getInValidCrids() : null, appa3, appcVar);
            }
        } catch (Throwable th2) {
            th = th2;
            appaVar = appeVar;
            String appa4 = appa("WMPatch", sdkThirdPlatform, appaVar, th.toString());
            appd.appe("WMPatch", appa4);
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
            appd.appc("WMPatch", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new RunnableC0689appa(demandEntityHandle));
    }
}
