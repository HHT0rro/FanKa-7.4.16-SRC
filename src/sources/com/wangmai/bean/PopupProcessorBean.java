package com.wangmai.bean;

import appa.appa.appa.appb;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class PopupProcessorBean extends appb<PopupProcessorBean> {
    private appa.appa.appd.appb adListener;

    public appa.appa.appd.appb getAdListener() {
        return this.adListener;
    }

    public PopupProcessorBean setAdListener(appa.appa.appd.appb appbVar) {
        this.adListener = appbVar;
        return this;
    }

    public String toString() {
        return "PopupProcessorBean{closeRand=" + this.closeRand + ", adListener=" + ((Object) this.adListener) + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', closeRand='" + this.closeRand + "', requestId='" + this.requestId + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
