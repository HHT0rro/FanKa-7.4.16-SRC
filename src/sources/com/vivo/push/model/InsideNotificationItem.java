package com.vivo.push.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    private int mAppType;
    private int mDisplayStyle;
    private int mInnerPriority;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageType;
    private int mNotifyDisplayStatus;
    private String mReactPackage;
    private String mSuitReactVersion;

    private int parsingNotifyStyle() {
        int i10 = this.mDisplayStyle;
        return ((i10 & 32) == 0 && (i10 & 16) != 0) ? 1 : 0;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public int getDisplayStyle() {
        return this.mDisplayStyle;
    }

    public int getInnerPriority() {
        return this.mInnerPriority;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public int getNotifyDisplayStatus() {
        return this.mNotifyDisplayStatus;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void setAppType(int i10) {
        this.mAppType = i10;
    }

    public void setDisplayStyle(int i10) {
        this.mDisplayStyle = i10;
        this.mNotifyDisplayStatus = parsingNotifyStyle();
    }

    public void setInnerPriority(int i10) {
        this.mInnerPriority = i10;
    }

    public void setIsShowBigPicOnMobileNet(boolean z10) {
        this.mIsShowBigPicOnMobileNet = z10;
    }

    public void setMessageType(int i10) {
        this.mMessageType = i10;
    }

    public void setReactPackage(String str) {
        this.mReactPackage = str;
    }

    public void setSuitReactVersion(String str) {
        this.mSuitReactVersion = str;
    }
}
