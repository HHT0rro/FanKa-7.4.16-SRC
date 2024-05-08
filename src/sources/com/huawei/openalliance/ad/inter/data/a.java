package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends c implements e {
    private static final String I = "AwardAd";
    private static final long Z = 30424300;
    private VideoInfo B;
    private boolean C;
    private RewardItem F;
    private boolean S;

    public a(AdContentData adContentData) {
        super(adContentData);
        this.C = false;
        if (adContentData.G() == null || adContentData.H() == 0) {
            return;
        }
        this.F = new RewardItem(adContentData.G(), adContentData.H());
    }

    private VideoInfo Code() {
        MetaData k10;
        if (this.B == null && (k10 = k()) != null) {
            this.B = k10.V();
        }
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public RewardItem B() {
        return this.F;
    }

    public boolean C() {
        return this.S;
    }

    public void Code(RewardItem rewardItem) {
        this.F = rewardItem;
    }

    public void Code(boolean z10) {
        this.S = z10;
    }

    public void V(boolean z10) {
        this.C = z10;
    }

    public boolean V() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.B = adContentData.p();
        }
        return this.B != null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public boolean Z() {
        return this.C;
    }
}
