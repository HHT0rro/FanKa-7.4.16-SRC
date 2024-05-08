package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicUserSheetModel implements Serializable {
    private String createTime;
    private long sheetId;
    private String sheetName;
    private String type;

    public HifiveMusicUserSheetModel(long j10, String str) {
        this.sheetId = j10;
        this.sheetName = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public long getSheetId() {
        return this.sheetId;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    public String getType() {
        return this.type;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setSheetId(long j10) {
        this.sheetId = j10;
    }

    public void setSheetName(String str) {
        this.sheetName = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public HifiveMusicUserSheetModel() {
    }
}
