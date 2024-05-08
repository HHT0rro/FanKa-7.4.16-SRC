package com.wangmai.bean;

import appa.appa.appa.appb;
import appa.appa.appd.appf;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class RewardVideoProcessorBean extends appb<RewardVideoProcessorBean> {
    private appf adListener;
    private int orientation;

    public appf getAdListener() {
        return this.adListener;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public RewardVideoProcessorBean setAdListener(appf appfVar) {
        this.adListener = appfVar;
        return this;
    }

    public RewardVideoProcessorBean setOrientation(int i10) {
        this.orientation = i10;
        return this;
    }

    public String toString() {
        return "RewardVideoProcessorBean{orientation=" + this.orientation + ", adListener=" + ((Object) this.adListener) + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', closeRand='" + this.closeRand + "', requestId='" + this.requestId + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
