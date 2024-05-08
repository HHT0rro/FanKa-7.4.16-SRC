package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SeatInfo extends BaseBean {

    @JSONField(serialize = false)
    public List<BidInfo> bidList;

    /* renamed from: id, reason: collision with root package name */
    @JSONField(name = "id")
    public int f4179id;

    @JSONField(name = "ad")
    public List<String> rawBidList;

    public List<BidInfo> getBidList() {
        return Collections.synchronizedList(this.bidList);
    }

    public int getId() {
        return this.f4179id;
    }

    public List<String> getRawBidList() {
        return this.rawBidList;
    }

    public SeatInfo setBidList(List<BidInfo> list) {
        this.bidList = list;
        return this;
    }

    public void setId(int i10) {
        this.f4179id = i10;
    }

    public void setRawBidList(List<String> list) {
        this.rawBidList = list;
    }
}
