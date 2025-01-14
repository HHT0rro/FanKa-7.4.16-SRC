package com.bytedance.android.live.base.api.push.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PushData {
    public String anchorOpenId;
    public String avatar;
    public String infoText;
    public String logPb;
    public String nickName;
    public String openRoomId;
    public String requestId;
    public Long roomId;

    public String getAnchorOpenId() {
        return this.anchorOpenId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getInfoText() {
        return this.infoText;
    }

    public String getLogPb() {
        return this.logPb;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public void setAnchorOpenId(String str) {
        this.anchorOpenId = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setInfoText(String str) {
        this.infoText = str;
    }

    public void setLogPb(String str) {
        this.logPb = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setRoomId(Long l10) {
        this.roomId = l10;
    }
}
