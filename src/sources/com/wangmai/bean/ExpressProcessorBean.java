package com.wangmai.bean;

import appa.appa.appa.appb;
import appa.appa.appd.appc;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class ExpressProcessorBean extends appb<ExpressProcessorBean> {
    private appc adListener;
    private int slideProbability;

    public appc getAdListener() {
        return this.adListener;
    }

    public int getSlideProbability() {
        return this.slideProbability;
    }

    public ExpressProcessorBean setAdListener(appc appcVar) {
        this.adListener = appcVar;
        return this;
    }

    public ExpressProcessorBean setSlideProbability(int i10) {
        this.slideProbability = i10;
        return this;
    }

    public String toString() {
        return "ExpressProcessorBean{slideProbability=" + this.slideProbability + ", adListener=" + ((Object) this.adListener) + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', closeRand='" + this.closeRand + "', requestId='" + this.requestId + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
