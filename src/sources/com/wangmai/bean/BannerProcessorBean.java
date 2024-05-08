package com.wangmai.bean;

import appa.appa.appa.appb;
import appa.appa.appd.appa;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class BannerProcessorBean extends appb<BannerProcessorBean> {
    private appa adListener;
    private int adslotType;

    public appa getAdListener() {
        return this.adListener;
    }

    public int getAdslotType() {
        return this.adslotType;
    }

    public BannerProcessorBean setAdListener(appa appaVar) {
        this.adListener = appaVar;
        return this;
    }

    public BannerProcessorBean setAdslotType(int i10) {
        this.adslotType = i10;
        return this;
    }

    public String toString() {
        return "BannerProcessorBean{adslotType=" + this.adslotType + ", closeRand=" + this.closeRand + ", adListener=" + ((Object) this.adListener) + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', requestId='" + this.requestId + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
