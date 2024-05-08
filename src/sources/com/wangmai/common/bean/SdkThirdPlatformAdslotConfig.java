package com.wangmai.common.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SdkThirdPlatformAdslotConfig {
    public static final int BIDDING = 2;
    public static final int SORT_TYPE_FLOOR = 1;
    public static final int SORT_TYPE_PRICE = 2;
    public static final int TARGET_PRICE = 1;
    public int biddingType;
    public int cacheTime;
    public double dspBidPrice;
    public boolean enableRotate;
    public boolean enableShake;
    public boolean enableSlide;
    public double gapRatio;
    public double mediaBidPrice;
    public double priceRatio;
    public int sortType;
    public String thirdAppId;
    public String thirdSlotAppKey;
    public String thirdSlotConfig;
    public String thirdSlotId;
    public int thirdSlotIdKey;
    public int thirdSlotType;

    /* renamed from: v, reason: collision with root package name */
    public String f46926v;

    @Deprecated
    public int weight;
    public int weightRatio;

    public int getBiddingType() {
        return this.biddingType;
    }

    public int getCacheTime() {
        return this.cacheTime;
    }

    public double getDspBidPrice() {
        return this.dspBidPrice;
    }

    public double getGapRatio() {
        return this.gapRatio;
    }

    public double getMediaBidPrice() {
        return this.mediaBidPrice;
    }

    public double getPriceRatio() {
        return this.priceRatio;
    }

    public int getSortType() {
        return this.sortType;
    }

    public String getThirdAppId() {
        return this.thirdAppId;
    }

    public String getThirdSlotAppKey() {
        return this.thirdSlotAppKey;
    }

    public String getThirdSlotConfig() {
        return this.thirdSlotConfig;
    }

    public String getThirdSlotId() {
        return this.thirdSlotId;
    }

    public int getThirdSlotIdKey() {
        return this.thirdSlotIdKey;
    }

    public int getThirdSlotType() {
        return this.thirdSlotType;
    }

    public String getV() {
        return this.f46926v;
    }

    @Deprecated
    public int getWeight() {
        return this.weight;
    }

    public int getWeightRatio() {
        return this.weightRatio;
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

    public void setBiddingType(int i10) {
        this.biddingType = i10;
    }

    public void setCacheTime(int i10) {
        this.cacheTime = i10;
    }

    public void setDspBidPrice(double d10) {
        this.dspBidPrice = d10;
    }

    public void setEnableRotate(boolean z10) {
        this.enableRotate = z10;
    }

    public void setEnableShake(boolean z10) {
        this.enableShake = z10;
    }

    public void setEnableSlide(boolean z10) {
        this.enableSlide = z10;
    }

    public void setGapRatio(double d10) {
        this.gapRatio = d10;
    }

    public void setMediaBidPrice(double d10) {
        this.mediaBidPrice = d10;
    }

    public void setPriceRatio(double d10) {
        this.priceRatio = d10;
    }

    public void setSortType(int i10) {
        this.sortType = i10;
    }

    public void setThirdAppId(String str) {
        this.thirdAppId = str;
    }

    public void setThirdSlotAppKey(String str) {
        this.thirdSlotAppKey = str;
    }

    public void setThirdSlotConfig(String str) {
        this.thirdSlotConfig = str;
    }

    public void setThirdSlotId(String str) {
        this.thirdSlotId = str;
    }

    public void setThirdSlotIdKey(int i10) {
        this.thirdSlotIdKey = i10;
    }

    public void setThirdSlotType(int i10) {
        this.thirdSlotType = i10;
    }

    public void setV(String str) {
        this.f46926v = str;
    }

    @Deprecated
    public void setWeight(int i10) {
        this.weight = i10;
    }

    public void setWeightRatio(int i10) {
        this.weightRatio = i10;
    }

    public String toString() {
        return "SdkThirdPlatformAdslotConfig{thirdSlotId='" + this.thirdSlotId + "', thirdSlotType=" + this.thirdSlotType + ", thirdSlotConfig='" + this.thirdSlotConfig + "', thirdSlotIdKey=" + this.thirdSlotIdKey + ", cacheTime=" + this.cacheTime + ", enableShake=" + this.enableShake + ", enableRotate=" + this.enableRotate + ", enableSlide=" + this.enableSlide + ", gapRatio=" + this.gapRatio + ", priceRatio=" + this.priceRatio + ", weightRatio=" + this.weightRatio + ", sortType=" + this.sortType + ", weight=" + this.weight + ", v='" + this.f46926v + "', dspBidPrice=" + this.dspBidPrice + ", mediaBidPrice=" + this.mediaBidPrice + ", biddingType=" + this.biddingType + ", thirdAppId='" + this.thirdAppId + "', thirdSlotAppKey='" + this.thirdSlotAppKey + "'}";
    }
}
