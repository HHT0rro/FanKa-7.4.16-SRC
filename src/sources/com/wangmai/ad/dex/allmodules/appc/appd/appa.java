package com.wangmai.ad.dex.allmodules.appc.appd;

import android.app.Activity;
import android.content.Context;
import appa.appa.appe.appf;
import appa.appa.appf.appd;
import com.wangmai.bean.PopupProcessorBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiWMInterstitialProcesser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends appf {

    /* renamed from: appa, reason: collision with root package name */
    private appc f46735appa;
    private PopupProcessorBean appb;

    public appa(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        PopupProcessorBean popupProcessorBean = this.appb;
        return (popupProcessorBean == null || popupProcessorBean.getAdListener() == null) ? false : true;
    }

    @Override // appa.appa.appe.appf
    public void closeAd() {
        onDestroy();
    }

    @Override // appa.appa.appe.appf
    public void loadAd() {
        try {
            if (this.f46735appa != null) {
                this.f46735appa.appj();
            } else {
                appd.appb("ApiWMInterstitialProc", "IPA.MW Popup p load error:InterstitialAd is null");
                if (checkProcessorBean()) {
                    this.appb.getAdListener().onNoAd("暂无广告");
                }
            }
        } catch (Throwable th) {
            appd.appb("ApiWMInterstitialProc", "IPA.MW Popup p load error:" + th.toString());
            if (checkProcessorBean()) {
                this.appb.getAdListener().onNoAd("暂无广告");
            }
        }
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        appc appcVar = this.f46735appa;
        if (appcVar != null) {
            appcVar.appa();
        }
        PopupProcessorBean popupProcessorBean = this.appb;
        if (popupProcessorBean != null) {
            popupProcessorBean.setAdListener(null);
            this.appb = null;
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }

    @Override // appa.appa.appe.appf
    public void showAd(Context context) {
        try {
            if (this.f46735appa != null) {
                if (context != null && (context instanceof Activity)) {
                    this.f46735appa.appa((Activity) context);
                } else if (getTaskTopActivity() != null) {
                    this.f46735appa.appa(getTaskTopActivity().get());
                } else if (checkProcessorBean()) {
                    this.appb.getAdListener().appa("展示失败(Context为空或不是Activity实例)");
                }
            } else {
                appd.appb("ApiWMInterstitialProc", "IPA.MW Interstitial show error: InterstitialAd is null");
                if (checkProcessorBean()) {
                    this.appb.getAdListener().appa("展示失败(InterstitialAd为空)");
                }
            }
        } catch (Throwable th) {
            appd.appb("ApiWMInterstitialProc", "IPA.MW Interstitial show error:" + th.toString());
            if (checkProcessorBean()) {
                this.appb.getAdListener().appa("展示失败:" + th.toString());
            }
        }
    }

    @Override // appa.appa.appe.appf
    public void topup(PopupProcessorBean popupProcessorBean) {
        try {
            this.appb = popupProcessorBean;
            this.f46735appa = new appc(getApplicationContext(), popupProcessorBean.getMediaAdSlotId(), popupProcessorBean.getSlotId(), popupProcessorBean.getRequestId(), popupProcessorBean.getCloseRand(), popupProcessorBean.getDowlandDialogType(), popupProcessorBean.getSdkInvokeFailRetry(), new C0683appa());
        } catch (Throwable th) {
            appd.appb("ApiWMInterstitialProc", "IPA.MW Popup p error:" + th.toString());
            if (checkProcessorBean()) {
                this.appb.getAdListener().onNoAd("暂无广告");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMInterstitialProcesser.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appc.appd.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0683appa implements appa.appa.appd.appb {
        C0683appa() {
        }

        @Override // appa.appa.appd.appb
        public void appa() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().appa();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdInterstitialListener
        public void onAdClose() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onAdClose();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            if (appa.this.checkProcessorBean()) {
                appa appaVar = appa.this;
                appaVar.setDspPrice(appaVar.f46735appa.appe());
                appa appaVar2 = appa.this;
                appaVar2.setMediaBidPrice(appaVar2.f46735appa.appg());
                appa appaVar3 = appa.this;
                appaVar3.setAdCacheTime(appaVar3.f46735appa.appb());
                appa appaVar4 = appa.this;
                appaVar4.setExpireTime(appaVar4.f46735appa.appc());
                appa appaVar5 = appa.this;
                appaVar5.setCrid(appaVar5.f46735appa.appd());
                appa appaVar6 = appa.this;
                appaVar6.setInValidCrids(appaVar6.f46735appa.appf());
                appa appaVar7 = appa.this;
                appaVar7.setThirdSlotIdKey(appaVar7.f46735appa.apph());
                appa appaVar8 = appa.this;
                appaVar8.setWinReportUrl(appaVar8.f46735appa.appi());
                appa.this.appb.getAdListener().onAdRequest();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onClick();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onExposure();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onNoAd(str);
            }
        }

        @Override // appa.appa.appd.appb
        public void appa(String str) {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().appa(str);
            }
        }

        @Override // appa.appa.appd.appb
        public void appa(appa.appa.appb.appa appaVar) {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().appa(appaVar);
            }
        }
    }
}
