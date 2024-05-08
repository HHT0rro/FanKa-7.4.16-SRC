package com.wangmai.bean;

import appa.appa.appa.appb;
import appa.appa.appd.appg;
import com.wangmai.common.bean.SplashBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class SplashProcessorBean extends appb<SplashProcessorBean> {
    private appg adListener;
    private SplashBean bean;
    private int clickRegionType = 0;
    private boolean enableRotate;
    private boolean enableShake;
    private boolean enableSlide;

    public appg getAdListener() {
        return this.adListener;
    }

    public SplashBean getBean() {
        return this.bean;
    }

    public int getClickRegionType() {
        return this.clickRegionType;
    }

    public boolean isEnableRotate() {
        return this.enableRotate;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public boolean isEnableSlide() {
        return this.enableSlide;
    }

    public SplashProcessorBean setAdListener(appg appgVar) {
        this.adListener = appgVar;
        return this;
    }

    public SplashProcessorBean setBean(SplashBean splashBean) {
        this.bean = splashBean;
        return this;
    }

    public SplashProcessorBean setClickRegionType(int i10) {
        this.clickRegionType = i10;
        return this;
    }

    public SplashProcessorBean setEnableRotate(boolean z10) {
        this.enableRotate = z10;
        return this;
    }

    public SplashProcessorBean setEnableShake(boolean z10) {
        this.enableShake = z10;
        return this;
    }

    public SplashProcessorBean setEnableSlide(boolean z10) {
        this.enableSlide = z10;
        return this;
    }

    public String toString() {
        return "SplashProcessorBean2{closeRand=" + this.closeRand + ", bean=" + ((Object) this.bean) + ", requestId='" + this.requestId + "', adListener=" + ((Object) this.adListener) + ", clickRegionType=" + this.clickRegionType + ", adsParent=" + ((Object) this.adsParent) + ", appId='" + this.appId + "', slotId='" + this.slotId + "', requestId='" + this.requestId + "', dowlandDialogType=" + this.dowlandDialogType + '}';
    }
}
