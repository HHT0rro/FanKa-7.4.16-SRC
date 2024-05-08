package appa.appa.appa;

import android.view.ViewGroup;
import appa.appa.appa.appb;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AbstractBaseProcessorBean.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public abstract class appb<T extends appb> {
    protected ViewGroup adsParent;
    protected String appId;
    protected String appKey;
    protected int closeRand;
    protected int demandPlatformId;
    protected int materialCollectRand;
    protected String mediaAdSlotId;
    protected String requestId;
    protected String slotId;
    protected int dowlandDialogType = 1;
    protected int sdkInvokeFailRetry = 0;

    public ViewGroup getAdsParent() {
        return this.adsParent;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public int getCloseRand() {
        return this.closeRand;
    }

    public int getDemandPlatformId() {
        return this.demandPlatformId;
    }

    public int getDowlandDialogType() {
        return this.dowlandDialogType;
    }

    public int getMaterialCollectRand() {
        return this.materialCollectRand;
    }

    public String getMediaAdSlotId() {
        return this.mediaAdSlotId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getSdkInvokeFailRetry() {
        return this.sdkInvokeFailRetry;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public T setAdsParent(ViewGroup viewGroup) {
        this.adsParent = viewGroup;
        return this;
    }

    public T setAppId(String str) {
        this.appId = str;
        return this;
    }

    public T setAppKey(String str) {
        this.appKey = str;
        return this;
    }

    public T setCloseRand(int i10) {
        this.closeRand = i10;
        return this;
    }

    public T setDemandPlatformId(int i10) {
        this.demandPlatformId = i10;
        return this;
    }

    public T setDowlandDialogType(int i10) {
        this.dowlandDialogType = i10;
        return this;
    }

    public T setMaterialCollectRand(int i10) {
        this.materialCollectRand = i10;
        return this;
    }

    public T setMediaAdSlotId(String str) {
        this.mediaAdSlotId = str;
        return this;
    }

    public T setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public T setSdkInvokeFailRetry(int i10) {
        this.sdkInvokeFailRetry = i10;
        return this;
    }

    public T setSlotId(String str) {
        this.slotId = str;
        return this;
    }
}
