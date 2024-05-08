package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.instreamad.InstreamAd;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w extends InstreamAd {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.p V;

    public w(Context context, com.huawei.openalliance.ad.inter.data.h hVar) {
        this.I = context;
        if (hVar instanceof com.huawei.openalliance.ad.inter.data.p) {
            this.V = (com.huawei.openalliance.ad.inter.data.p) hVar;
        }
    }

    private boolean V() {
        return this.V == null;
    }

    public com.huawei.openalliance.ad.inter.data.h Code() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getAdSign() {
        return V() ? "2" : this.V.L();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getAdSource() {
        if (V()) {
            return null;
        }
        return this.V.c();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public List<AdvertiserInfo> getAdvertiserInfo() {
        if (V()) {
            return null;
        }
        return this.V.n();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getCallToAction() {
        if (V()) {
            return null;
        }
        return dw.Code(this.I, this.V.v(), this.V.F());
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getDspLogo() {
        if (V()) {
            return null;
        }
        return this.V.M();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getDspName() {
        if (V()) {
            return null;
        }
        return this.V.K();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public long getDuration() {
        com.huawei.openalliance.ad.inter.data.r S;
        if (V() || (S = this.V.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getWhyThisAd() {
        if (V()) {
            return null;
        }
        return this.V.g();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean hasAdvertiserInfo() {
        if (V()) {
            return false;
        }
        return this.V.k_();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isClicked() {
        if (V()) {
            return false;
        }
        return this.V.Z();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isExpired() {
        if (V()) {
            return true;
        }
        return this.V.f();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isImageAd() {
        if (V()) {
            return false;
        }
        return this.V.I();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isShown() {
        if (V()) {
            return false;
        }
        return this.V.B();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isVideoAd() {
        if (V()) {
            return false;
        }
        return this.V.V();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        if (V()) {
            return;
        }
        this.V.Code(rewardVerifyConfig);
    }
}
