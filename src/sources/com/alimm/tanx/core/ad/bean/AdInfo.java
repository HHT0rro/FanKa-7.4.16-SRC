package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdInfo extends BaseBean {
    public String decrypt;

    @JSONField(name = "id")
    public String requestId;

    @JSONField(name = "seat")
    public List<SeatInfo> seatList;

    @JSONField(name = "status")
    public int status;

    public int getAdCount() {
        List<SeatInfo> list = this.seatList;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i10 = 0;
        for (SeatInfo seatInfo : this.seatList) {
            i10 += seatInfo.getBidList() == null ? 0 : seatInfo.getBidList().size();
        }
        return i10;
    }

    public List<BidInfo> getBidInfoList() {
        List<SeatInfo> list = this.seatList;
        if (list == null || list.size() <= 0 || this.seatList.get(0).getBidList() == null) {
            return null;
        }
        return this.seatList.get(0).getBidList();
    }

    public String getDecrypt() {
        return this.decrypt;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public List<SeatInfo> getSeatList() {
        return this.seatList;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDecrypt(String str) {
        this.decrypt = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSeatList(List<SeatInfo> list) {
        this.seatList = list;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
