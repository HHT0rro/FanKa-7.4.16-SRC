package com.tencent.rtmp;

import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TXLivePlayConfig implements Serializable {
    private static final long serialVersionUID = 1;
    public Map<String, String> mHeaders;
    public float mCacheTime = 5.0f;
    public float mMaxAutoAdjustCacheTime = 5.0f;
    public float mMinAutoAdjustCacheTime = 1.0f;
    public int mVideoBlockThreshold = 800;
    public int mConnectRetryCount = 3;
    public int mConnectRetryInterval = 3;
    public boolean mAutoAdjustCacheTime = true;
    public boolean mEnableAec = false;
    public boolean mEnableMessage = false;
    public boolean mEnableMetaData = false;
    public String mFlvSessionKey = "";
    public boolean mEnableNearestIP = true;
    public int mRtmpChannelType = 0;

    public float getCacheTime() {
        return this.mCacheTime;
    }

    public int getConnectRetryCount() {
        return this.mConnectRetryCount;
    }

    public int getConnectRetryInterval() {
        return this.mConnectRetryInterval;
    }

    public String getFlvSessionKey() {
        return this.mFlvSessionKey;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public float getMaxAutoAdjustCacheTime() {
        return this.mMaxAutoAdjustCacheTime;
    }

    public float getMinAutoAdjustCacheTime() {
        return this.mMinAutoAdjustCacheTime;
    }

    public int getRtmpChannelType() {
        return this.mRtmpChannelType;
    }

    public int getVideoBlockThreshold() {
        return this.mVideoBlockThreshold;
    }

    public boolean isAutoAdjustCacheTime() {
        return this.mAutoAdjustCacheTime;
    }

    public boolean isEnableAec() {
        return this.mEnableAec;
    }

    public boolean isEnableMessage() {
        return this.mEnableMessage;
    }

    public boolean isEnableMetaData() {
        return this.mEnableMetaData;
    }

    public boolean isEnableNearestIP() {
        return this.mEnableNearestIP;
    }

    public void setAutoAdjustCacheTime(boolean z10) {
        this.mAutoAdjustCacheTime = z10;
    }

    public void setCacheTime(float f10) {
        this.mCacheTime = f10;
    }

    public void setConnectRetryCount(int i10) {
        this.mConnectRetryCount = i10;
    }

    public void setConnectRetryInterval(int i10) {
        this.mConnectRetryInterval = i10;
    }

    @Deprecated
    public void setEnableAEC(boolean z10) {
        this.mEnableAec = z10;
    }

    public void setEnableMessage(boolean z10) {
        this.mEnableMessage = z10;
    }

    public void setEnableMetaData(boolean z10) {
        this.mEnableMetaData = z10;
    }

    @Deprecated
    public void setEnableNearestIP(boolean z10) {
        this.mEnableNearestIP = z10;
    }

    public void setFlvSessionKey(String str) {
        this.mFlvSessionKey = str;
    }

    @Deprecated
    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setMaxAutoAdjustCacheTime(float f10) {
        this.mMaxAutoAdjustCacheTime = f10;
    }

    public void setMinAutoAdjustCacheTime(float f10) {
        this.mMinAutoAdjustCacheTime = f10;
    }

    @Deprecated
    public void setRtmpChannelType(int i10) {
        this.mRtmpChannelType = i10;
    }

    public void setVideoBlockThreshold(int i10) {
        this.mVideoBlockThreshold = i10;
    }

    public String toString() {
        return "{mCacheTime=" + this.mCacheTime + ", mMaxAutoAdjustCacheTime=" + this.mMaxAutoAdjustCacheTime + ", mMinAutoAdjustCacheTime=" + this.mMinAutoAdjustCacheTime + ", mAutoAdjustCacheTime=" + this.mAutoAdjustCacheTime + ", mVideoBlockThreshold=" + this.mVideoBlockThreshold + ", mConnectRetryCount=" + this.mConnectRetryCount + ", mConnectRetryInterval=" + this.mConnectRetryInterval + ", mEnableAec=" + this.mEnableAec + ", mEnableMessage=" + this.mEnableMessage + ", mEnableMetaData=" + this.mEnableMetaData + '}';
    }
}
