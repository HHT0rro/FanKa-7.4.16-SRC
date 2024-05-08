package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicChannelModel implements Serializable {
    private String channelId;
    private String channelName;
    private String coverUrl;

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }
}
