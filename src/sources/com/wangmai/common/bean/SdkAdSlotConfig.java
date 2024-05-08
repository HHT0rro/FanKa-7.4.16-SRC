package com.wangmai.common.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SdkAdSlotConfig {
    public static final int REQUEST_FAIL_RETRY = 1;
    public static final int REQUEST_TYPE_ACCELERATOR = 1;
    public static final int REQUEST_TYPE_FIXED_NUM = 2;
    public static final int REQUEST_TYPE_SAME_PRICE = 3;

    @Deprecated
    public int ackflowType;
    public int adslotIdRequestTime;
    public int bannerRft;
    public int fSdkAdPrompt;
    public int fSdkDownloadPopup;
    public Optimization optimization;
    public int queryPriceTime;
    public int requestAdNumber;
    public int requestFailRetry;
    public int requestType;
    public int sdkInvokeFailRetry;
    public int sdkStrategyCacheTime;
    public int singleRequetsTime;

    public int getAckflowType() {
        return this.ackflowType;
    }

    public int getAdslotIdRequestTime() {
        return this.adslotIdRequestTime;
    }

    public int getBannerRft() {
        return this.bannerRft;
    }

    public Optimization getOptimization() {
        return this.optimization;
    }

    public int getQueryPriceTime() {
        return this.queryPriceTime;
    }

    public int getRequestAdNumber() {
        return this.requestAdNumber;
    }

    public int getRequestFailRetry() {
        return this.requestFailRetry;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getSdkInvokeFailRetry() {
        return this.sdkInvokeFailRetry;
    }

    public int getSdkStrategyCacheTime() {
        return this.sdkStrategyCacheTime;
    }

    public int getSingleRequetsTime() {
        return this.singleRequetsTime;
    }

    public int getfSdkAdPrompt() {
        return this.fSdkAdPrompt;
    }

    public int getfSdkDownloadPopup() {
        return this.fSdkDownloadPopup;
    }

    public void setAckflowType(int i10) {
        this.ackflowType = i10;
    }

    public void setAdslotIdRequestTime(int i10) {
        this.adslotIdRequestTime = i10;
    }

    public void setBannerRft(int i10) {
        this.bannerRft = i10;
    }

    public void setOptimization(Optimization optimization) {
        this.optimization = optimization;
    }

    public void setQueryPriceTime(int i10) {
        this.queryPriceTime = i10;
    }

    public void setRequestAdNumber(int i10) {
        this.requestAdNumber = i10;
    }

    public void setRequestFailRetry(int i10) {
        this.requestFailRetry = i10;
    }

    public void setRequestType(int i10) {
        this.requestType = i10;
    }

    public void setSdkInvokeFailRetry(int i10) {
        this.sdkInvokeFailRetry = i10;
    }

    public void setSdkStrategyCacheTime(int i10) {
        this.sdkStrategyCacheTime = i10;
    }

    public void setSingleRequetsTime(int i10) {
        this.singleRequetsTime = i10;
    }

    public void setfSdkAdPrompt(int i10) {
        this.fSdkAdPrompt = i10;
    }

    public void setfSdkDownloadPopup(int i10) {
        this.fSdkDownloadPopup = i10;
    }

    public String toString() {
        return "SdkAdslotConfig{bannerRft=" + this.bannerRft + ", fSdkDownloadPopup=" + this.fSdkDownloadPopup + ", fSdkAdPrompt=" + this.fSdkAdPrompt + ", sdkStrategyCacheTime=" + this.sdkStrategyCacheTime + ", sdkInvokeFailRetry=" + this.sdkInvokeFailRetry + ", requestType=" + this.requestType + ", requestAdNumber=" + this.requestAdNumber + ", requestFailRetry=" + this.requestFailRetry + ", adslotIdRequestTime=" + this.adslotIdRequestTime + ", singleRequetsTime=" + this.singleRequetsTime + ", queryPriceTime=" + this.queryPriceTime + ", optimization=" + ((Object) this.optimization) + '}';
    }
}
