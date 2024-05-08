package com.amap.api.col.s;

import android.os.Build;

/* compiled from: Rom.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum da {
    MIUI(ci.c("IeGlhb21p")),
    Flyme(ci.c("IbWVpenU")),
    RH(ci.c("IaHVhd2Vp")),
    ColorOS(ci.c("Ib3Bwbw")),
    FuntouchOS(ci.c("Idml2bw")),
    SmartisanOS(ci.c("Mc21hcnRpc2Fu")),
    AmigoOS(ci.c("IYW1pZ28")),
    EUI(ci.c("IbGV0dg")),
    Sense(ci.c("EaHRj")),
    LG(ci.c("EbGdl")),
    Google(ci.c("IZ29vZ2xl")),
    NubiaUI(ci.c("IbnViaWE")),
    Other("");


    /* renamed from: n, reason: collision with root package name */
    private String f7639n;

    /* renamed from: o, reason: collision with root package name */
    private int f7640o;

    /* renamed from: p, reason: collision with root package name */
    private String f7641p;

    /* renamed from: q, reason: collision with root package name */
    private String f7642q;

    /* renamed from: r, reason: collision with root package name */
    private String f7643r = Build.MANUFACTURER;

    da(String str) {
        this.f7639n = str;
    }

    public final String a() {
        return this.f7639n;
    }

    public final String b() {
        return this.f7641p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f7640o + ", versionName='" + this.f7642q + "',ma=" + this.f7639n + "',manufacturer=" + this.f7643r + "'}";
    }

    public final void a(int i10) {
        this.f7640o = i10;
    }

    public final void b(String str) {
        this.f7642q = str;
    }

    public final void a(String str) {
        this.f7641p = str;
    }
}
