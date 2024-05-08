package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicLyricDetailModel implements Serializable {
    private String content;
    private long startTime;

    public String getContent() {
        return this.content;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }
}
