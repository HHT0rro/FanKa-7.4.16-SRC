package com.huawei.quickcard.cardmanager.bean;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardBean implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    private static final long f33505i = 4294272345028970369L;

    /* renamed from: a, reason: collision with root package name */
    private String f33506a;

    /* renamed from: b, reason: collision with root package name */
    private int f33507b;

    /* renamed from: c, reason: collision with root package name */
    private int f33508c;

    /* renamed from: d, reason: collision with root package name */
    private String f33509d;

    /* renamed from: e, reason: collision with root package name */
    private String f33510e;

    /* renamed from: f, reason: collision with root package name */
    private String f33511f;

    /* renamed from: g, reason: collision with root package name */
    private long f33512g;

    /* renamed from: h, reason: collision with root package name */
    private String f33513h;

    public String getCardId() {
        return this.f33506a;
    }

    public String getContent() {
        return this.f33510e;
    }

    public String getDependencies() {
        return this.f33511f;
    }

    public int getMinPlatformVersion() {
        return this.f33507b;
    }

    public String getSign() {
        return this.f33513h;
    }

    public long getTs() {
        return this.f33512g;
    }

    public String getType() {
        return this.f33509d;
    }

    public int getVer() {
        return this.f33508c;
    }

    public void setCardId(String str) {
        this.f33506a = str;
    }

    public void setContent(String str) {
        this.f33510e = str;
    }

    public void setDependencies(String str) {
        this.f33511f = str;
    }

    public void setMinPlatformVersion(int i10) {
        this.f33507b = i10;
    }

    public void setSign(String str) {
        this.f33513h = str;
    }

    public void setTs(long j10) {
        this.f33512g = j10;
    }

    public void setType(String str) {
        this.f33509d = str;
    }

    public void setVer(int i10) {
        this.f33508c = i10;
    }

    public String toString() {
        return "CardBean{cardId='" + this.f33506a + "', minPlatformVersion=" + this.f33507b + ", ver=" + this.f33508c + ", type='" + this.f33509d + "', content='***', dependencies='" + this.f33511f + "', ts=" + this.f33512g + ", sign='" + this.f33513h + "'}";
    }
}
