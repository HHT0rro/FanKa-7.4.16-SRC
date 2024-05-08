package com.bytedance.android.live.base.api.outer.data;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AnchorInfo {
    public String avatar;
    public long fansCount;
    public String nickname;
    public String openId;

    public AnchorInfo(String str, String str2, String str3, long j10) {
        this.openId = str;
        this.nickname = str2;
        this.avatar = str3;
        this.fansCount = j10;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getFansCount() {
        return this.fansCount;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFansCount(long j10) {
        this.fansCount = j10;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }
}
