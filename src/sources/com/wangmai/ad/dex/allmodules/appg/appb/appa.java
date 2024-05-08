package com.wangmai.ad.dex.allmodules.appg.appb;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.ad.dex.allmodules.utils.NativeExpotBgView;
import com.wangmai.bean.ExpressProcessorBean;
import com.wangmai.common.Iinterface.INativeExpressInterface;
import com.wangmai.common.Ilistener.XAdNativeExpressListener;
import com.wangmai.common.Ilistener.XAdSplashListener;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMNativeExpressAdDexNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<INativeExpressInterface> implements INativeExpressInterface {
    private static List<String> appw = new ArrayList();
    private DemandEntityHandle appv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMNativeExpressAdDexNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.appb.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class RunnableC0686appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ appa.appa.appe.appc f46787appa;
        final /* synthetic */ ExpressProcessorBean appb;

        RunnableC0686appa(appa appaVar, appa.appa.appe.appc appcVar, ExpressProcessorBean expressProcessorBean) {
            this.f46787appa = appcVar;
            this.appb = expressProcessorBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46787appa.nativeExpressAd(this.appb);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMNativeExpressAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ DemandEntityHandle f46788appa;

        appb(DemandEntityHandle demandEntityHandle) {
            this.f46788appa = demandEntityHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
                ((XAdNativeExpressListener) ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc).onADIsVideo(this.f46788appa.isAdIsVideo());
                if (this.f46788appa.getNativeExpressView() != null && this.f46788appa.getNativeExpressView().getParent() != null) {
                    appa.appa.appf.appb.appb(this.f46788appa.getNativeExpressView());
                }
                ((XAdNativeExpressListener) ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc).onRenderSuccess(this.f46788appa.getNativeExpressView(), this.f46788appa.getNativeExpressWidth(), this.f46788appa.getNativeExpressHeight());
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayReq, this.f46788appa.getDemandPlatformId(), this.f46788appa.getDemandAdSlotId(), (String) null, "媒体展示请求(AdSdkDisplayReq)");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMNativeExpressAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    static class appd implements View.OnTouchListener {

        /* renamed from: appa, reason: collision with root package name */
        private DemandEntityHandle f46790appa;

        public appd(DemandEntityHandle demandEntityHandle) {
            this.f46790appa = demandEntityHandle;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                try {
                    appa.appa.appf.appd.appe("WMNativeExpress", "NativeExpressTouchListener onTouch performTouch");
                    if (this.f46790appa != null && this.f46790appa.getSdkProcesser() != null && (this.f46790appa.getSdkProcesser() instanceof appa.appa.appc.appa) && ((Boolean) view.getTag()).booleanValue()) {
                        ((appa.appa.appc.appa) this.f46790appa.getSdkProcesser()).appb(motionEvent);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return false;
        }
    }

    public appa(Activity activity, String str, XAdNativeExpressListener xAdNativeExpressListener) {
        super(activity, str, null, xAdNativeExpressListener, "WMNativeExpress");
        appb();
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    @Override // com.wangmai.common.Iinterface.INativeExpressInterface
    public void destroy() {
        try {
            appa.appa.appf.appd.appa("WMNativeExpress", "NativeExpress destroy", this.appv, Thread.currentThread().getName());
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
            appa.appa.appf.appd.appe("WMNativeExpress", "NativeExpress destroy:" + th.toString());
        }
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

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMNativeExpressAdDexNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appc implements appa.appa.appd.appc {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46789appa;
        SdkThirdPlatform appb;
        appa.appa.appe.appc appc;
        appa.appc appd;

        appc(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appa.appa.appe.appc appcVar, appa.appc appcVar2) {
            this.f46789appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = appcVar;
            this.appd = appcVar2;
        }

        @Override // appa.appa.appd.appc
        public void appa(String str) {
            appa.appa.appf.appd.appa("WMNativeExpress", "onExposureFailed:", appa.this.appj, this.f46789appa.getLastRequestId());
            if (this.f46789appa.getListener() != null) {
                appa.appa.appf.appb.appb(this.f46789appa.getViewSplashBg());
                ((XAdSplashListener) this.f46789appa.getListener()).onAdDismissed();
            }
            appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayRespFailure, this.f46789appa.getDemandPlatformId(), this.f46789appa.getDemandAdSlotId(), str, this.f46789appa.getLastRequestId(), "曝光失败打点(AdSdkDisplayRespFailure)");
        }

        @Override // com.wangmai.common.Ilistener.XAdNativeExpressListener
        public void onADIsVideo(boolean z10) {
            this.f46789appa.setAdIsVideo(z10);
        }

        @Override // com.wangmai.common.Ilistener.XAdNativeExpressListener
        public void onAdClose() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appd && this.f46789appa.getListener() != null) {
                ((XAdNativeExpressListener) this.f46789appa.getListener()).onAdClose();
            }
            appa.this.appv = this.f46789appa;
            appa.this.destroy();
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.this.appa(this.f46789appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46789appa.getListener() != null) {
                this.f46789appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46789appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46789appa.getListener() != null) {
                this.f46789appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46789appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appa.appa.appf.appd.appe("WMNativeExpress", appa.this.appa("WMNativeExpress", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46789appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }

        @Override // com.wangmai.common.Ilistener.XAdNativeExpressListener
        public void onRenderSuccess(View view, int i10, int i11) {
            try {
                this.f46789appa.setNativeExpressView((NativeExpotBgView) view);
                this.f46789appa.setNativeExpressWidth(i10);
                this.f46789appa.setNativeExpressHeight(i11);
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("WMNativeExpress", "NativeExpress onRenderSuccess error:" + th.toString());
            }
        }

        @Override // appa.appa.appd.appc
        public void appa() {
            try {
                if (this.f46789appa == null || this.f46789appa.getSdkProcesser() == null) {
                    return;
                }
                appa.appw.add(String.valueOf(this.f46789appa.getDemandProcesserKey()));
                appa.this.appa(this.f46789appa.getSdkProcesser().hashCode());
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMNativeExpress", "缓存移除失败[NativeExpress]:" + th);
            }
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        String classType;
        String appb2;
        String appc2;
        String appe;
        appa.appa.appe.appc appcVar2;
        this.appr = sdkThirdPlatform;
        NativeExpotBgView nativeExpotBgView = new NativeExpotBgView(appd());
        nativeExpotBgView.setOnTouchListener(new appd(this.appv));
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
                String appa2 = appa("WMNativeExpress", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appa.appa.appf.appd.appe("WMNativeExpress", appa2);
                appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa2, appcVar);
                return;
            }
            String name = sdkThirdPlatform.getName();
            classType = sdkThirdPlatform.getClassType();
            appb2 = appb(sdkThirdPlatform);
            appc2 = appc(sdkThirdPlatform);
            appe = appe(sdkThirdPlatform);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("@@@@@@@@ 当前开始执行的需求方[");
            stringBuffer.append("WMNativeExpress");
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
            appa.appa.appf.appd.appd("WMNativeExpress", stringBuffer.toString());
            appcVar2 = (appa.appa.appe.appc) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, "nativeExpress");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (appa(appcVar2, appb2, appe)) {
                appb(sdkThirdPlatform, classType);
                demandEntityHandle.setSdkProcesser(appcVar2);
                appa(appcVar2, new ExpressProcessorBean().setAdsParent(nativeExpotBgView).setAppId(appb2).setAppKey(appc2).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setSlideProbability((appf() == null || appf().getSlideObject() == null) ? 0 : appf().getSlideObject().getSlideProbability()).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setRequestId(this.appj).setCloseRand(this.appk).setMaterialCollectRand(this.appl).setAdListener(new appc(demandEntityHandle, sdkThirdPlatform, appcVar2, appcVar)));
            } else {
                String appa3 = appa("WMNativeExpress", sdkThirdPlatform, appcVar2, (String) null);
                appa.appa.appf.appd.appe("WMNativeExpress", appa3);
                appa(demandEntityHandle, sdkThirdPlatform, appcVar2 != null ? appcVar2.getInValidCrids() : null, appa3, appcVar);
            }
        } catch (Throwable th2) {
            th = th2;
            appaVar = appcVar2;
            String appa4 = appa("WMNativeExpress", sdkThirdPlatform, appaVar, th.toString());
            appa.appa.appf.appd.appe("WMNativeExpress", appa4);
            appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa4, appcVar);
        }
    }

    private void appa(appa.appa.appe.appc appcVar, ExpressProcessorBean expressProcessorBean) {
        this.appt.post(new RunnableC0686appa(this, appcVar, expressProcessorBean));
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa, com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(DemandEntityHandle demandEntityHandle) {
        super.appa(demandEntityHandle);
        this.appd = true;
        this.appv = demandEntityHandle;
        demandEntityHandle.setListener(this.appc);
        demandEntityHandle.setLastRequestId(this.appj);
        if (demandEntityHandle.getCacheNum() > 1) {
            appa.appa.appf.appd.appc("WMNativeExpress", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new appb(demandEntityHandle));
    }
}
