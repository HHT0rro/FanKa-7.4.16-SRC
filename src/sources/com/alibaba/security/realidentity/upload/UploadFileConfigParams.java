package com.alibaba.security.realidentity.upload;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UploadFileConfigParams implements Serializable {
    private String mBucket;
    private String mContentType;
    private String mEndPoint;
    private long mExpired;
    private String mKey;
    private String mPath;
    private String mSecret;
    private String mToken;

    public String getBucket() {
        return this.mBucket;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public String getEndPoint() {
        return this.mEndPoint;
    }

    public long getExpired() {
        return this.mExpired;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getSecret() {
        return this.mSecret;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setBucket(String str) {
        this.mBucket = str;
    }

    public void setContentType(String str) {
        this.mContentType = str;
    }

    public void setEndPoint(String str) {
        this.mEndPoint = str;
    }

    public void setExpired(long j10) {
        this.mExpired = j10;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setSecret(String str) {
        this.mSecret = str;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
