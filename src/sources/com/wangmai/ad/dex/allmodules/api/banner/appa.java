package com.wangmai.ad.dex.allmodules.api.banner;

import android.content.Context;
import android.view.View;
import appa.appa.appf.appd;
import com.wangmai.bean.BannerProcessorBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiWMBannerProcesser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends appa.appa.appe.appa {

    /* renamed from: appa, reason: collision with root package name */
    private ApiWMBannerView f46487appa;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMBannerProcesser.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.banner.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0659appa implements appa.appa.appd.appa {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ BannerProcessorBean f46488appa;

        C0659appa(BannerProcessorBean bannerProcessorBean) {
            this.f46488appa = bannerProcessorBean;
        }

        @Override // appa.appa.appd.appa
        public void appa() {
            appd.appa("ApiWMBannerProcesser", "Api Banner p onRemoveCache");
            if (this.f46488appa.getAdListener() != null) {
                this.f46488appa.getAdListener().appa();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdBannerListener
        public void onAdClose() {
            appd.appa("ApiWMBannerProcesser", "Api Banner p onAdClose");
            if (this.f46488appa.getAdListener() != null) {
                this.f46488appa.getAdListener().onAdClose();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appd.appa("ApiWMBannerProcesser", "Api Banner p onAdRequest");
            if (this.f46488appa.getAdListener() != null) {
                appa appaVar = appa.this;
                appaVar.setDspPrice(appaVar.f46487appa.getDspBidPrice());
                appa appaVar2 = appa.this;
                appaVar2.setMediaBidPrice(appaVar2.f46487appa.getMediaBidPrice());
                appa appaVar3 = appa.this;
                appaVar3.setAdCacheTime(appaVar3.f46487appa.getAdCacheTime());
                appa appaVar4 = appa.this;
                appaVar4.setExpireTime(appaVar4.f46487appa.getAdExpireTime());
                appa appaVar5 = appa.this;
                appaVar5.setCrid(appaVar5.f46487appa.getCrid());
                appa appaVar6 = appa.this;
                appaVar6.setInValidCrids(appaVar6.f46487appa.getInvalidCrids());
                appa appaVar7 = appa.this;
                appaVar7.setThirdSlotIdKey(appaVar7.f46487appa.getThirdSlotIdKey());
                appa appaVar8 = appa.this;
                appaVar8.setWinReportUrl(appaVar8.f46487appa.getWinReportUrl());
                this.f46488appa.getAdListener().onAdRequest();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            appd.appa("ApiWMBannerProcesser", "Api Banner p onClick");
            if (this.f46488appa.getAdListener() != null) {
                this.f46488appa.getAdListener().onClick();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            appd.appa("ApiWMBannerProcesser", "Api Banner p onExposure");
            if (this.f46488appa.getAdListener() != null) {
                this.f46488appa.getAdListener().onExposure();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            appd.appb("ApiWMBannerProcesser", "Api Banner p onNoAd:" + str);
            if (this.f46488appa.getAdListener() != null) {
                this.f46488appa.getAdListener().onNoAd(str);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdBannerListener
        public void onRenderSuccess(View view, int i10, int i11) {
            appd.appa("ApiWMBannerProcesser", "Api Banner onRenderSuccess");
            if (this.f46488appa.getAdListener() != null) {
                this.f46488appa.getAdListener().onRenderSuccess(view, i10, i11);
            }
        }
    }

    public appa(Context context) {
        super(context);
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        try {
            if (this.f46487appa != null) {
                this.f46487appa.appa();
            }
        } catch (Throwable th) {
            appd.appe("ApiWMBannerProcesser", "Api.MW Banner p destroy error:" + th.toString());
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }

    @Override // appa.appa.appe.appa
    public void appa(BannerProcessorBean bannerProcessorBean) {
        this.f46487appa = new ApiWMBannerView(getApplicationContext(), bannerProcessorBean.getSlotId(), bannerProcessorBean.getAdsParent(), bannerProcessorBean.getRequestId(), bannerProcessorBean.getCloseRand(), bannerProcessorBean.getDowlandDialogType(), bannerProcessorBean.getSdkInvokeFailRetry(), new C0659appa(bannerProcessorBean));
    }
}
