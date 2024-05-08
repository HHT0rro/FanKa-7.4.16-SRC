package com.wangmai.ad.dex.allmodules.bean;

import java.util.Calendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class VirtualClickAdSlotInfo {
    String adSlotId;
    long lastOperationTime;
    long lastSimulatedClickTime;
    long lastSlideClickTime;
    int simulatedClickedCount;
    int slideClickedCount;

    public String getAdSlotId() {
        return this.adSlotId;
    }

    public long getLastOperationTime() {
        return this.lastOperationTime;
    }

    public long getLastSimulatedClickTime() {
        return this.lastSimulatedClickTime;
    }

    public long getLastSlideClickTime() {
        return this.lastSlideClickTime;
    }

    public int getSimulatedClickedCount() {
        return this.simulatedClickedCount;
    }

    public int getSlideClickedCount() {
        return this.slideClickedCount;
    }

    public boolean isExpired() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(5);
        calendar.setTimeInMillis(this.lastOperationTime);
        return i10 != calendar.get(5);
    }

    public void setAdSlotId(String str) {
        this.adSlotId = str;
    }

    public void setLastOperationTime(long j10) {
        this.lastOperationTime = j10;
    }

    public void setLastSimulatedClickTime(long j10) {
        this.lastSimulatedClickTime = j10;
    }

    public void setLastSlideClickTime(long j10) {
        this.lastSlideClickTime = j10;
    }

    public void setSimulatedClickedCount(int i10) {
        this.simulatedClickedCount = i10;
    }

    public void setSlideClickedCount(int i10) {
        this.slideClickedCount = i10;
    }

    public String toString() {
        return "VirtualClickAdSlotInfo{adSlotId='" + this.adSlotId + "', lastSimulatedClickTime=" + this.lastSimulatedClickTime + ", lastSlideClickTime=" + this.lastSlideClickTime + ", simulatedClickedCount=" + this.simulatedClickedCount + ", slideClickedCount=" + this.slideClickedCount + '}';
    }
}
