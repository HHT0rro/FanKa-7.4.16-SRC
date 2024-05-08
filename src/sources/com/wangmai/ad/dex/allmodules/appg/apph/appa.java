package com.wangmai.ad.dex.allmodules.appg.apph;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import appa.appa.appd.appg;
import appa.appa.appe.apph;
import appa.appa.appf.appd;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashBgView;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.bean.SplashProcessorBean;
import com.wangmai.common.Iinterface.ISplashInterface;
import com.wangmai.common.Ilistener.XAdSplashListener;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.bean.SplashBean;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.ThreadUtils;
import com.wangmai.common.utils.WMResources;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMSplashAdDex.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends com.wangmai.ad.dex.allmodules.appg.appa<ISplashInterface> implements ISplashInterface {

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f46801b = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private View f46802a;
    private DemandEntityHandle appv;
    private final SplashBean appw;
    private ApiWMSplashBgView appx;
    private ViewGroup appy;
    private View appz;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMSplashAdDex.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.apph.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0692appa implements Runnable {
        RunnableC0692appa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc != null) {
                ((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appc.onAdRequest();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMSplashAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ apph f46804appa;
        final /* synthetic */ SplashProcessorBean appb;

        appb(appa appaVar, apph apphVar, SplashProcessorBean splashProcessorBean) {
            this.f46804appa = apphVar;
            this.appb = splashProcessorBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46804appa.load(this.appb);
        }
    }

    public appa(Activity activity, String str, SplashBean splashBean, XAdSplashListener xAdSplashListener) {
        super(activity, str, null, xAdSplashListener, "WMSplash");
        this.appw = splashBean;
        if (this.apps) {
            appb();
        }
    }

    private void appn() {
        View inflate;
        try {
            if (this.appr.getClassType().equals(ConstantInfo.THIRD_PARTY_QM)) {
                this.appx = new ApiWMSplashBgView(WMDexAdHelper.getTopActivity().get());
                inflate = LayoutInflater.from(appa.appa.appf.appa.appa(WMDexAdHelper.getTopActivity().get(), WMResources.resources)).inflate(R$layout.wm_bottom_area_splash, (ViewGroup) null);
            } else {
                this.appx = new ApiWMSplashBgView(appd());
                inflate = LayoutInflater.from(appa.appa.appf.appa.appa(appd(), WMResources.resources)).inflate(R$layout.wm_bottom_area_splash, (ViewGroup) null);
            }
            this.appy = (ViewGroup) inflate.findViewById(R$id.wm_splash);
            this.appz = inflate.findViewById(R$id.wm_layout_bottom_area);
            this.f46802a = inflate.findViewById(R$id.wm_click_region);
            this.appx.addView(inflate);
        } catch (Throwable th) {
            appd.appe("WMSplash", "createSplashBaseView error:" + th.toString());
        }
    }

    private void appo() {
        try {
            if (this.appv.getExtraBean() != null && !TextUtils.isEmpty(this.appv.getExtraBean().getWmDesc()) && !TextUtils.isEmpty(this.appv.getExtraBean().getWmTitle())) {
                ImageView imageView = (ImageView) this.appv.getWmLayoutBottomArea().findViewById(R$id.wm_image_area);
                TextView textView = (TextView) this.appv.getWmLayoutBottomArea().findViewById(R$id.wm_title_area);
                TextView textView2 = (TextView) this.appv.getWmLayoutBottomArea().findViewById(R$id.wm_desc_area);
                this.appv.getWmLayoutBottomArea().setVisibility(0);
                imageView.setImageDrawable(com.wangmai.ad.dex.allmodules.utils.appd.appa(appd()));
                textView.setText(this.appv.getExtraBean().getWmTitle());
                textView2.setText(this.appv.getExtraBean().getWmDesc());
            } else {
                this.appv.getWmLayoutBottomArea().setVisibility(8);
            }
        } catch (Throwable th) {
            appd.appe("WMSplash", "setCommonView error:" + th);
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appg.appa
    public void appj() {
        appc();
    }

    @Override // com.wangmai.common.Iinterface.ISplashInterface
    public void destroy() {
        try {
            appd.appa("WMSplash", "Splash destroy", this.appv, Thread.currentThread().getName());
            if (this.appv != null) {
                if (appa() && !f46801b.contains(String.valueOf(this.appv.getDemandProcesserKey()))) {
                    this.appv.setListener(null);
                }
                f46801b.remove(String.valueOf(this.appv.getDemandProcesserKey()));
                this.appv.onDestroy();
                this.appv = null;
            }
            this.appc = null;
        } catch (Throwable th) {
            appd.appe("WMSplash", "Splash destroy:" + th);
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

    @Override // com.wangmai.common.Iinterface.ISplashInterface
    public void show(ViewGroup viewGroup) {
        try {
            appd.appa("WMSplash", "Splash show", Thread.currentThread().getName());
            if (viewGroup == null || this.appv == null || this.appv.getSdkProcesser() == null) {
                appd.appb("WMSplash", "splash show error:", viewGroup, this.appv);
            } else {
                appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayReq, this.appv.getDemandPlatformId(), this.appv.getDemandAdSlotId(), (String) null, "媒体展示请求(AdSdkDisplayReq)");
                appa.appa.appf.appb.appb(this.appv.getViewSplashBg());
                viewGroup.addView(this.appv.getViewSplashBg());
                ((apph) this.appv.getSdkProcesser()).show(this.appv.getWmSplashView());
                appo();
            }
        } catch (Exception e2) {
            appd.appb("WMSplash", "splash show error:" + ((Object) e2));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMSplashAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appc implements appg {

        /* renamed from: appa, reason: collision with root package name */
        DemandEntityHandle f46805appa;
        SdkThirdPlatform appb;
        apph appc;
        appa.appc appd;

        appc(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, apph apphVar, appa.appc appcVar) {
            this.f46805appa = demandEntityHandle;
            this.appb = sdkThirdPlatform;
            this.appc = apphVar;
            this.appd = appcVar;
        }

        @Override // appa.appa.appd.appg
        public void appa(boolean z10) {
            if (z10 && appa.this.appg() != 0) {
                this.f46805appa.getWmClickRegionArea().setVisibility(0);
            } else {
                this.f46805appa.getWmClickRegionArea().setVisibility(8);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdDismissed() {
            if (!((com.wangmai.ad.dex.allmodules.appg.appa) appa.this).appd || this.f46805appa.getListener() == null) {
                return;
            }
            ((XAdSplashListener) this.f46805appa.getListener()).onAdDismissed();
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa.this.appa(this.f46805appa, this.appb, this.appc, this.appd);
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdZoomOut() {
            if (this.f46805appa.getListener() != null) {
                ((XAdSplashListener) this.f46805appa.getListener()).onAdZoomOut();
            }
            this.f46805appa.getWmClickRegionArea().setVisibility(8);
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdZoomOutClick() {
            if (this.f46805appa.getListener() != null) {
                ((XAdSplashListener) this.f46805appa.getListener()).onAdZoomOutClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46805appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ilistener.XAdSplashListener
        public void onAdZoomOutDismissed() {
            if (this.f46805appa.getListener() != null) {
                ((XAdSplashListener) this.f46805appa.getListener()).onAdZoomOutDismissed();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46805appa.getListener() != null) {
                this.f46805appa.getListener().onClick();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appa(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46805appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46805appa.getListener() != null) {
                this.f46805appa.getListener().onExposure();
            }
            appa appaVar = appa.this;
            SdkThirdPlatform sdkThirdPlatform = this.appb;
            appaVar.appb(sdkThirdPlatform, sdkThirdPlatform.getClassType(), this.f46805appa.getLastRequestId());
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appd.appe("WMSplash", appa.this.appa("WMSplash", this.appb, (appa.appa.appa.appa) null, str));
            appa.this.appa(this.f46805appa, this.appb, this.appc.getInValidCrids(), str, this.appd);
        }

        @Override // appa.appa.appd.appg
        public void appa(String str) {
            if (this.f46805appa.getListener() != null) {
                appa.appa.appf.appb.appb(this.f46805appa.getViewSplashBg());
                ((XAdSplashListener) this.f46805appa.getListener()).onAdDismissed();
            }
            appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayRespFailure, this.f46805appa.getDemandPlatformId(), this.f46805appa.getDemandAdSlotId(), str, this.f46805appa.getLastRequestId(), "曝光失败打点(AdSdkDisplayRespFailure)");
        }

        @Override // appa.appa.appd.appg
        public void appa() {
            try {
                if (this.f46805appa == null || this.f46805appa.getSdkProcesser() == null) {
                    return;
                }
                appa.f46801b.add(String.valueOf(this.f46805appa.getDemandProcesserKey()));
                appa.this.appa(this.f46805appa.getDemandProcesserKey());
            } catch (Throwable th) {
                appd.appe("WMSplash", "缓存移除失败[Splash]:" + th);
            }
        }

        @Override // appa.appa.appd.appg
        public void appa(appa.appa.appb.appa appaVar) {
            if (appaVar == appa.appa.appb.appa.READY) {
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkPrepareSuccess, this.f46805appa.getDemandPlatformId(), this.f46805appa.getDemandAdSlotId(), (String) null, this.f46805appa.getLastRequestId(), "广告准备完毕打点(AdSdkPrepareSuccess)");
            } else if (appaVar == appa.appa.appb.appa.NOT_READY) {
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkPrepareFailure, this.f46805appa.getDemandPlatformId(), this.f46805appa.getDemandAdSlotId(), "广告无效或已过期", this.f46805appa.getLastRequestId(), "广告无效或已过期打点(AdSdkPrepareFailure)");
            }
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(appa.appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle) {
        String classType;
        String appb2;
        String appc2;
        String appe;
        apph apphVar;
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
                String appa2 = appa("WMSplash", sdkThirdPlatform, (appa.appa.appa.appa) null, "需求方出价或媒体结算价无效");
                appd.appe("WMSplash", appa2);
                appa(demandEntityHandle, sdkThirdPlatform, (List<String>) null, appa2, appcVar);
                return;
            }
            appn();
            demandEntityHandle.setViewSplashBg(this.appx);
            demandEntityHandle.setWmSplashView(this.appy);
            demandEntityHandle.setWmLayoutBottomArea(this.appz);
            demandEntityHandle.setWmClickRegionArea(this.f46802a);
            demandEntityHandle.setExtraBean(this.appw);
            String name = sdkThirdPlatform.getName();
            classType = sdkThirdPlatform.getClassType();
            appb2 = appb(sdkThirdPlatform);
            appc2 = appc(sdkThirdPlatform);
            appe = appe(sdkThirdPlatform);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("@@@@@@@@ 当前开始执行的需求方[");
            stringBuffer.append("WMSplash");
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
            appd.appd("WMSplash", stringBuffer.toString());
            apphVar = (apph) com.wangmai.ad.dex.allmodules.appe.appa.appa(appd(), classType, "splash");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (appa(apphVar, appb2, appe)) {
                appb(sdkThirdPlatform, classType);
                demandEntityHandle.setSdkProcesser(apphVar);
                appa(apphVar, new SplashProcessorBean().setAdsParent(this.appy).setAppId(appb2).setAppKey(appc2).setMediaAdSlotId(this.appb).setDemandPlatformId(sdkThirdPlatform.getId()).setSlotId(appa(sdkThirdPlatform, classType)).setRequestId(this.appj).setCloseRand(this.appk).setMaterialCollectRand(this.appl).setClickRegionType(appg()).setDowlandDialogType(apph()).setSdkInvokeFailRetry(appi()).setBean(this.appw).setEnableShake(sdkThirdPlatform.getSdkThirdAdslotConfig().isEnableShake()).setEnableRotate(sdkThirdPlatform.getSdkThirdAdslotConfig().isEnableRotate()).setEnableSlide(sdkThirdPlatform.getSdkThirdAdslotConfig().isEnableSlide()).setAdListener(new appc(demandEntityHandle, sdkThirdPlatform, apphVar, appcVar)));
            } else {
                String appa3 = appa("WMSplash", sdkThirdPlatform, apphVar, (String) null);
                appd.appe("WMSplash", appa3);
                appa(demandEntityHandle, sdkThirdPlatform, apphVar != null ? apphVar.getInValidCrids() : null, appa3, appcVar);
            }
        } catch (Throwable th2) {
            th = th2;
            appaVar = apphVar;
            String appa4 = appa("WMSplash", sdkThirdPlatform, appaVar, th.toString());
            appd.appe("WMSplash", appa4);
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
            appd.appc("WMSplash", "命中缓存:" + ((Object) demandEntityHandle));
        }
        this.appe = demandEntityHandle.getDspBidPrice();
        this.appf = demandEntityHandle.getMediaBidPrice();
        this.appg = (int) Math.round(this.appf * demandEntityHandle.getGapRatio());
        ThreadUtils.runOnUIThread(new RunnableC0692appa());
    }

    private void appa(apph apphVar, SplashProcessorBean splashProcessorBean) {
        this.appt.post(new appb(this, apphVar, splashProcessorBean));
    }
}
