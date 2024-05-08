package com.wangmai.bean;

import appa.appa.appa.appb;
import appa.appa.appd.appe;
import com.wangmai.common.bean.PatchBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class PatchProcessorBean extends appb<PatchProcessorBean> {
    private appe adListener;
    private PatchBean patchBean;

    public appe getAdListener() {
        return this.adListener;
    }

    public PatchBean getPatchBean() {
        return this.patchBean;
    }

    public PatchProcessorBean setAdListener(appe appeVar) {
        this.adListener = appeVar;
        return this;
    }

    public PatchProcessorBean setPatchBean(PatchBean patchBean) {
        this.patchBean = patchBean;
        return this;
    }

    public String toString() {
        return "PatchProcessorBean{adListener=" + ((Object) this.adListener) + ", patchBean=" + ((Object) this.patchBean) + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', closeRand='" + this.closeRand + "', requestId='" + this.requestId + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
