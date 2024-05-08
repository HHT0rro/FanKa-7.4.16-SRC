package com.wangmai.ad.dex.allmodules.api.reward;

import android.content.Context;
import android.os.Bundle;
import appa.appa.appd.appf;
import appa.appa.appe.appg;
import com.wangmai.bean.RewardVideoProcessorBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiWMRewardVideoProcesser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends appg {

    /* renamed from: appa, reason: collision with root package name */
    private appb f46641appa;
    private RewardVideoProcessorBean appb;

    public appa(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        RewardVideoProcessorBean rewardVideoProcessorBean = this.appb;
        return (rewardVideoProcessorBean == null || rewardVideoProcessorBean.getAdListener() == null) ? false : true;
    }

    @Override // appa.appa.appe.appg
    public void absReward(RewardVideoProcessorBean rewardVideoProcessorBean) {
        this.appb = rewardVideoProcessorBean;
        this.f46641appa = new appb(getApplicationContext(), rewardVideoProcessorBean.getMediaAdSlotId(), rewardVideoProcessorBean.getSlotId(), rewardVideoProcessorBean.getRequestId(), rewardVideoProcessorBean.getCloseRand(), rewardVideoProcessorBean.getDowlandDialogType(), rewardVideoProcessorBean.getSdkInvokeFailRetry(), new C0666appa());
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

    @Override // appa.appa.appe.appg
    public void show(Context context) {
        try {
            if (this.f46641appa != null) {
                this.f46641appa.appa(context);
            } else if (checkProcessorBean()) {
                this.appb.getAdListener().appa("展示失败(ApiRewardVideo为空)");
            }
        } catch (Throwable th) {
            if (checkProcessorBean()) {
                this.appb.getAdListener().appa("展示失败:" + th.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMRewardVideoProcesser.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.reward.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0666appa implements appf {
        C0666appa() {
        }

        @Override // appa.appa.appd.appf
        public void appa() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().appa();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onAdClose() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onAdClose();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onAdLoad() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onAdLoad();
            }
        }

        @Override // com.wangmai.common.Ibase.XAdBaseListener
        public void onAdRequest() {
            if (appa.this.checkProcessorBean()) {
                appa appaVar = appa.this;
                appaVar.setDspPrice(appaVar.f46641appa.appd());
                appa appaVar2 = appa.this;
                appaVar2.setMediaBidPrice(appaVar2.f46641appa.appf());
                appa appaVar3 = appa.this;
                appaVar3.setAdCacheTime(appaVar3.f46641appa.appa());
                appa appaVar4 = appa.this;
                appaVar4.setExpireTime(appaVar4.f46641appa.appb());
                appa appaVar5 = appa.this;
                appaVar5.setCrid(appaVar5.f46641appa.appc());
                appa appaVar6 = appa.this;
                appaVar6.setInValidCrids(appaVar6.f46641appa.appe());
                appa appaVar7 = appa.this;
                appaVar7.setThirdSlotIdKey(appaVar7.f46641appa.appg());
                appa appaVar8 = appa.this;
                appaVar8.setWinReportUrl(appaVar8.f46641appa.apph());
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

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onRewarded(boolean z10, Bundle bundle) {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onRewarded(z10, bundle);
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onVideoComplete() {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onVideoComplete();
            }
        }

        @Override // com.wangmai.common.Ilistener.XAdRewardVideoListener
        public void onVideoError(String str) {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().onVideoError(str);
            }
        }

        @Override // appa.appa.appd.appf
        public void appa(String str) {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().appa(str);
            }
        }

        @Override // appa.appa.appd.appf
        public void appa(appa.appa.appb.appa appaVar) {
            if (appa.this.checkProcessorBean()) {
                appa.this.appb.getAdListener().appa(appaVar);
            }
        }
    }
}
