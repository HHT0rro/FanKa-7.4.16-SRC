package com.amap.api.services.core;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SuggestionCity {

    /* renamed from: a, reason: collision with root package name */
    private String f8486a;

    /* renamed from: b, reason: collision with root package name */
    private String f8487b;

    /* renamed from: c, reason: collision with root package name */
    private String f8488c;

    /* renamed from: d, reason: collision with root package name */
    private int f8489d;

    public SuggestionCity() {
    }

    public String getAdCode() {
        return this.f8488c;
    }

    public String getCityCode() {
        return this.f8487b;
    }

    public String getCityName() {
        return this.f8486a;
    }

    public int getSuggestionNum() {
        return this.f8489d;
    }

    public void setAdCode(String str) {
        this.f8488c = str;
    }

    public void setCityCode(String str) {
        this.f8487b = str;
    }

    public void setCityName(String str) {
        this.f8486a = str;
    }

    public void setSuggestionNum(int i10) {
        this.f8489d = i10;
    }

    public SuggestionCity(String str, String str2, String str3, int i10) {
        this.f8486a = str;
        this.f8487b = str2;
        this.f8488c = str3;
        this.f8489d = i10;
    }
}
