package com.wangmai.common.bean;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Optimization {
    public MediaAdCacheBean adCache;
    public CloseObj closeObj;
    public String copyContent;
    public DpLandingPageObj dpLandingPageObj;
    public List<String> replace;
    public SlideObject slideObject;
    public Tips tips;
    public int trackAdmRandom;

    public MediaAdCacheBean getAdCache() {
        return this.adCache;
    }

    public CloseObj getCloseObj() {
        return this.closeObj;
    }

    public String getCopyContent() {
        return this.copyContent;
    }

    public DpLandingPageObj getDpLandingPageObj() {
        return this.dpLandingPageObj;
    }

    public List<String> getReplace() {
        return this.replace;
    }

    public SlideObject getSlideObject() {
        return this.slideObject;
    }

    public Tips getTips() {
        return this.tips;
    }

    public int getTrackAdmRandom() {
        return this.trackAdmRandom;
    }

    public void setAdCache(MediaAdCacheBean mediaAdCacheBean) {
        this.adCache = mediaAdCacheBean;
    }

    public void setCloseObj(CloseObj closeObj) {
        this.closeObj = closeObj;
    }

    public void setCopyContent(String str) {
        this.copyContent = str;
    }

    public void setDpLandingPageObj(DpLandingPageObj dpLandingPageObj) {
        this.dpLandingPageObj = dpLandingPageObj;
    }

    public void setReplace(List<String> list) {
        this.replace = list;
    }

    public void setSlideObject(SlideObject slideObject) {
        this.slideObject = slideObject;
    }

    public void setTips(Tips tips) {
        this.tips = tips;
    }

    public void setTrackAdmRandom(int i10) {
        this.trackAdmRandom = i10;
    }

    public String toString() {
        return "Optimization{copyContent='" + this.copyContent + "', replace=" + ((Object) this.replace) + ", closeObj=" + ((Object) this.closeObj) + ", dpLandingPageObj=" + ((Object) this.dpLandingPageObj) + ", slideObject=" + ((Object) this.slideObject) + ", tips=" + ((Object) this.tips) + ", adCache=" + ((Object) this.adCache) + ", trackAdmRandom=" + this.trackAdmRandom + '}';
    }
}
