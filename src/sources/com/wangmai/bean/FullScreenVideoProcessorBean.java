package com.wangmai.bean;

import appa.appa.appa.appb;
import com.wangmai.common.Ilistener.XAdFullScreenVideoListener;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class FullScreenVideoProcessorBean extends appb<FullScreenVideoProcessorBean> {
    private XAdFullScreenVideoListener adListener;

    public XAdFullScreenVideoListener getAdListener() {
        return this.adListener;
    }

    public FullScreenVideoProcessorBean setAdListener(XAdFullScreenVideoListener xAdFullScreenVideoListener) {
        this.adListener = xAdFullScreenVideoListener;
        return this;
    }

    public String toString() {
        return "FullScreenVideoProcessorBean{adListener=" + ((Object) this.adListener) + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', requestId='" + this.requestId + "', closeRand='" + this.closeRand + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
