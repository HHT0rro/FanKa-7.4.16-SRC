package com.wangmai.bean;

import appa.appa.appa.appb;
import appa.appa.appd.appd;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class NativeProcessorBean extends appb<NativeProcessorBean> {
    private appd adListener;

    public appd getAdListener() {
        return this.adListener;
    }

    public NativeProcessorBean setAdListener(appd appdVar) {
        this.adListener = appdVar;
        return this;
    }

    public String toString() {
        return "NativeProcessorBean{adListener=" + ((Object) this.adListener) + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', closeRand='" + this.closeRand + "', requestId='" + this.requestId + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
