package com.wangmai.ad.dex.allmodules.api.express;

import android.content.Context;
import android.view.View;
import appa.appa.appf.appd;
import com.wangmai.bean.ExpressProcessorBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiWMNativeExpressProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb extends appa.appa.appe.appc {

    /* renamed from: appa, reason: collision with root package name */
    private appc f46531appa;
    private ExpressProcessorBean appb;

    public appb(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        ExpressProcessorBean expressProcessorBean = this.appb;
        return (expressProcessorBean == null || expressProcessorBean.getAdListener() == null) ? false : true;
    }

    @Override // appa.appa.appe.appc
    public void nativeExpressAd(ExpressProcessorBean expressProcessorBean) {
        try {
            this.appb = expressProcessorBean;
            this.f46531appa = new appc(getApplicationContext(), expressProcessorBean.getSlotId(), expressProcessorBean.getRequestId(), expressProcessorBean.getSlideProbability(), expressProcessorBean.getDowlandDialogType(), expressProcessorBean.getSdkInvokeFailRetry(), new appa());
            this.f46531appa.appa(expressProcessorBean.getAdsParent());
        } catch (Throwable th) {
            appd.appb("ApiNativeExpressProc", "IAP.MW  p NativeExpress:" + th.toString());
            if (checkProcessorBean()) {
                this.appb.getAdListener().onNoAd("暂无广告");
            }
        }
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        try {
            if (this.f46531appa != null) {
                this.f46531appa.appj();
                this.f46531appa = null;
            }
            if (this.appb != null) {
                this.appb.setAdListener(null);
                this.appb = null;
            }
        } catch (Throwable th) {
            appd.appe("ApiNativeExpressProc", "IAP.MW p NativeExpress destroy:" + th.toString());
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativeExpressProcessor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa implements appa.appa.appd.appc {
        appa() {
        }

        @Override // appa.appa.appd.appc
        public void appa(String str) {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().appa(str);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdNativeExpressListener
        public void onADIsVideo(boolean z10) {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().onADIsVideo(z10);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdNativeExpressListener
        public void onAdClose() {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().onAdClose();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            if (appb.this.f46531appa != null) {
                appb appbVar = appb.this;
                appbVar.setDspPrice(appbVar.f46531appa.appe());
                appb appbVar2 = appb.this;
                appbVar2.setMediaBidPrice(appbVar2.f46531appa.appg());
                appb appbVar3 = appb.this;
                appbVar3.setCrid(appbVar3.f46531appa.appd());
                appb appbVar4 = appb.this;
                appbVar4.setAdCacheTime(appbVar4.f46531appa.appb());
                appb appbVar5 = appb.this;
                appbVar5.setExpireTime(appbVar5.f46531appa.appc());
                appb appbVar6 = appb.this;
                appbVar6.setInValidCrids(appbVar6.f46531appa.appf());
                appb appbVar7 = appb.this;
                appbVar7.setThirdSlotIdKey(appbVar7.f46531appa.apph());
                appb appbVar8 = appb.this;
                appbVar8.setWinReportUrl(appbVar8.f46531appa.appi());
                if (appb.this.checkProcessorBean()) {
                    appb.this.appb.getAdListener().onAdRequest();
                }
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().onClick();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().onExposure();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().onNoAd(str);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdNativeExpressListener
        public void onRenderSuccess(View view, int i10, int i11) {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().onRenderSuccess(view, i10, i11);
            }
        }

        @Override // appa.appa.appd.appc
        public void appa() {
            if (appb.this.checkProcessorBean()) {
                appb.this.appb.getAdListener().appa();
            }
        }
    }
}
