package com.vivo.push.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UPSNotificationMessage {
    public static final int CUSTOM = 3;
    public static final int ISMACROREPLACE = 1;
    public static final int OPENACTIVITY = 4;
    public static final int OPENAPP = 1;
    public static final int OPENURL = 2;
    public static final int UNKNOWN = 0;
    private String mAdClickCheckUrl;
    private int mCompatibleType;
    private String mContent;
    private String mCoverUrl;
    private String mIconUrl;
    private int mIsMacroReplace;
    private long mMsgId;
    private int mNotifyType;
    private Map<String, String> mParams = new HashMap();
    private String mPurePicUrl;
    private boolean mShowTime;
    private String mSkipContent;
    private int mSkipType;
    private int mTargetType;
    private String mTitle;
    private String mTragetContent;

    public void clearCoverUrl() {
        this.mIconUrl = "";
    }

    public void clearPurePicUrl() {
        this.mPurePicUrl = "";
    }

    public String getAdClickCheckUrl() {
        return this.mAdClickCheckUrl;
    }

    public int getCompatibleType() {
        return this.mCompatibleType;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getIsMacroReplace() {
        return this.mIsMacroReplace;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public int getNotifyType() {
        return this.mNotifyType;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public String getPurePicUrl() {
        return this.mPurePicUrl;
    }

    public String getSkipContent() {
        return this.mSkipContent;
    }

    public int getSkipType() {
        return this.mSkipType;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTragetContent() {
        return this.mTragetContent;
    }

    public boolean isMacroReplace() {
        return this.mIsMacroReplace == 1;
    }

    public boolean isShowTime() {
        return this.mShowTime;
    }

    public void setAdClickCheckUrl(String str) {
        this.mAdClickCheckUrl = str;
    }

    public void setCompatibleType(int i10) {
        this.mCompatibleType = i10;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setCoverUrl(String str) {
        this.mCoverUrl = str;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setIsMacroReplace(int i10) {
        this.mIsMacroReplace = i10;
    }

    public void setMsgId(long j10) {
        this.mMsgId = j10;
    }

    public void setNotifyType(int i10) {
        this.mNotifyType = i10;
    }

    public void setParams(Map<String, String> map) {
        this.mParams = map;
    }

    public void setPurePicUrl(String str) {
        this.mPurePicUrl = str;
    }

    public void setShowTime(boolean z10) {
        this.mShowTime = z10;
    }

    public void setSkipContent(String str) {
        this.mSkipContent = str;
    }

    public void setSkipType(int i10) {
        this.mSkipType = i10;
    }

    public void setTargetType(int i10) {
        this.mTargetType = i10;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTragetContext(String str) {
        this.mTragetContent = str;
    }

    public String toString() {
        return "UPSNotificationMessage{mTargetType=" + this.mTargetType + ", mTragetContent='" + this.mTragetContent + "', mTitle='" + this.mTitle + "', mContent='" + this.mContent + "', mNotifyType=" + this.mNotifyType + ", mPurePicUrl='" + this.mPurePicUrl + "', mIconUrl='" + this.mIconUrl + "', mCoverUrl='" + this.mCoverUrl + "', mSkipContent='" + this.mSkipContent + "', mSkipType=" + this.mSkipType + ", mShowTime=" + this.mShowTime + ", mMsgId=" + this.mMsgId + ", mParams=" + ((Object) this.mParams) + '}';
    }
}
