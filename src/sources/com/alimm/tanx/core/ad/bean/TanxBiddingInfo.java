package com.alimm.tanx.core.ad.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxBiddingInfo extends BaseBean {
    public long adPrice;
    public boolean bidResult;
    public double winPrice;

    public long getAdPrice() {
        return this.adPrice;
    }

    public double getWinPrice() {
        return this.winPrice;
    }

    public boolean isBidResult() {
        return this.bidResult;
    }

    public void setAdPrice(long j10) {
        this.adPrice = j10;
    }

    public void setBidResult(boolean z10) {
        this.bidResult = z10;
    }

    public void setWinPrice(double d10) {
        this.winPrice = d10;
    }
}
