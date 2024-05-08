package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicSearchrModel implements Serializable {
    private String createTime;
    private String keyword;
    private int searchId;

    public String getCreateTime() {
        return this.createTime;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setSearchId(int i10) {
        this.searchId = i10;
    }
}
