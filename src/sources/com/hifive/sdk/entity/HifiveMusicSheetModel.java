package com.hifive.sdk.entity;

import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicSheetModel implements Serializable {
    private HifiveMusicImageModel cover;
    private String describe;
    private int free;
    private long musicTotal;
    private int price;
    private long sheetId;
    private String sheetName;
    private List<HifiveMusicTagModel> tag;
    private int type;

    public HifiveMusicImageModel getCover() {
        return this.cover;
    }

    public String getDescribe() {
        return this.describe;
    }

    public int getFree() {
        return this.free;
    }

    public long getMusicTotal() {
        return this.musicTotal;
    }

    public int getPrice() {
        return this.price;
    }

    public long getSheetId() {
        return this.sheetId;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    public List<HifiveMusicTagModel> getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public void setCover(HifiveMusicImageModel hifiveMusicImageModel) {
        this.cover = hifiveMusicImageModel;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setFree(int i10) {
        this.free = i10;
    }

    public void setMusicTotal(long j10) {
        this.musicTotal = j10;
    }

    public void setPrice(int i10) {
        this.price = i10;
    }

    public void setSheetId(long j10) {
        this.sheetId = j10;
    }

    public void setSheetName(String str) {
        this.sheetName = str;
    }

    public void setTag(List<HifiveMusicTagModel> list) {
        this.tag = list;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
