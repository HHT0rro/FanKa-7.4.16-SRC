package com.qq.e.ads.hybrid;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: f, reason: collision with root package name */
    private String f38159f;

    /* renamed from: g, reason: collision with root package name */
    private String f38160g;

    /* renamed from: h, reason: collision with root package name */
    private String f38161h;

    /* renamed from: a, reason: collision with root package name */
    private int f38154a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f38155b = 44;

    /* renamed from: c, reason: collision with root package name */
    private int f38156c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f38157d = -14013133;

    /* renamed from: e, reason: collision with root package name */
    private int f38158e = 16;

    /* renamed from: i, reason: collision with root package name */
    private int f38162i = -1776153;

    /* renamed from: j, reason: collision with root package name */
    private int f38163j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f38160g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i10) {
        this.f38163j = i10;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f38161h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f38160g;
    }

    public int getBackSeparatorLength() {
        return this.f38163j;
    }

    public String getCloseButtonImage() {
        return this.f38161h;
    }

    public int getSeparatorColor() {
        return this.f38162i;
    }

    public String getTitle() {
        return this.f38159f;
    }

    public int getTitleBarColor() {
        return this.f38156c;
    }

    public int getTitleBarHeight() {
        return this.f38155b;
    }

    public int getTitleColor() {
        return this.f38157d;
    }

    public int getTitleSize() {
        return this.f38158e;
    }

    public int getType() {
        return this.f38154a;
    }

    public HybridADSetting separatorColor(int i10) {
        this.f38162i = i10;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f38159f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i10) {
        this.f38156c = i10;
        return this;
    }

    public HybridADSetting titleBarHeight(int i10) {
        this.f38155b = i10;
        return this;
    }

    public HybridADSetting titleColor(int i10) {
        this.f38157d = i10;
        return this;
    }

    public HybridADSetting titleSize(int i10) {
        this.f38158e = i10;
        return this;
    }

    public HybridADSetting type(int i10) {
        this.f38154a = i10;
        return this;
    }
}
