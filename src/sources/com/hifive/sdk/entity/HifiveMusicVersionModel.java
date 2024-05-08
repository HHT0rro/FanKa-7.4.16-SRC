package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicVersionModel implements Serializable {
    private int duration;
    private int free;
    private int majorVersion;
    private String musicId;
    private String name;
    private int price;

    public long getDuration() {
        return this.duration;
    }

    public int getFree() {
        return this.free;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public String getMusicId() {
        return this.musicId;
    }

    public String getName() {
        return this.name;
    }

    public long getPrice() {
        return this.price;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setFree(int i10) {
        this.free = i10;
    }

    public void setMajorVersion(int i10) {
        this.majorVersion = i10;
    }

    public void setMusicId(String str) {
        this.musicId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(int i10) {
        this.price = i10;
    }
}
