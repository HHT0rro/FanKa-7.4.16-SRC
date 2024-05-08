package com.wangmai.ad.dex.allmodules.api.fullscreen;

import android.content.Context;
import com.wangmai.bean.FullScreenVideoProcessorBean;
import com.wangmai.common.Ilistener.XAdFullScreenVideoListener;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiWMFullScreenVideoProcesser.java */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends appa.appa.appe.appb {

    /* renamed from: appa, reason: collision with root package name */
    private appc f46588appa;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMFullScreenVideoProcesser.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.fullscreen.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0665appa implements XAdFullScreenVideoListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ FullScreenVideoProcessorBean f46589appa;

        C0665appa(FullScreenVideoProcessorBean fullScreenVideoProcessorBean) {
            this.f46589appa = fullScreenVideoProcessorBean;
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onAdClose() {
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onAdClose();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onAdLoad() {
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onAdLoad();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            appa appaVar = appa.this;
            appaVar.setDspPrice(appaVar.f46588appa.appa());
            appa appaVar2 = appa.this;
            appaVar2.setMediaBidPrice(appaVar2.f46588appa.appb());
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onAdRequest();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onClick() {
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onClick();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onExposure() {
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onExposure();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onNoAd(String str) {
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onNoAd(str);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onSkippedVideo() {
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onSkippedVideo();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdFullScreenVideoListener
        public void onVideoComplete() {
            if (this.f46589appa.getAdListener() != null) {
                this.f46589appa.getAdListener().onVideoComplete();
            }
        }
    }

    public appa(Context context) {
        super(context);
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }

    @Override // appa.appa.appe.appb
    public void appa(FullScreenVideoProcessorBean fullScreenVideoProcessorBean) {
        this.f46588appa = new appc(getApplicationContext(), fullScreenVideoProcessorBean.getSlotId(), fullScreenVideoProcessorBean.getRequestId(), fullScreenVideoProcessorBean.getCloseRand(), fullScreenVideoProcessorBean.getDowlandDialogType(), fullScreenVideoProcessorBean.getSdkInvokeFailRetry(), new C0665appa(fullScreenVideoProcessorBean));
    }

    @Override // appa.appa.appe.appb
    public void appa() {
        appc appcVar = this.f46588appa;
        if (appcVar != null) {
            appcVar.appa(getApplicationContext());
        }
    }
}
