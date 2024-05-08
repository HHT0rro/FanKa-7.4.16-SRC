package com.amap.api.col.p0003l;

import android.os.Build;

/* compiled from: Rom.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum gt {
    MIUI(fv.c("IeGlhb21p")),
    Flyme(fv.c("IbWVpenU")),
    RH(fv.c("IaHVhd2Vp")),
    ColorOS(fv.c("Ib3Bwbw")),
    FuntouchOS(fv.c("Idml2bw")),
    SmartisanOS(fv.c("Mc21hcnRpc2Fu")),
    AmigoOS(fv.c("IYW1pZ28")),
    EUI(fv.c("IbGV0dg")),
    Sense(fv.c("EaHRj")),
    LG(fv.c("EbGdl")),
    Google(fv.c("IZ29vZ2xl")),
    NubiaUI(fv.c("IbnViaWE")),
    Other("");


    /* renamed from: n, reason: collision with root package name */
    private String f6152n;

    /* renamed from: o, reason: collision with root package name */
    private int f6153o;

    /* renamed from: p, reason: collision with root package name */
    private String f6154p;

    /* renamed from: q, reason: collision with root package name */
    private String f6155q;

    /* renamed from: r, reason: collision with root package name */
    private String f6156r = Build.MANUFACTURER;

    gt(String str) {
        this.f6152n = str;
    }

    public final String a() {
        return this.f6152n;
    }

    public final String b() {
        return this.f6154p;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f6153o + ", versionName='" + this.f6155q + "',ma=" + this.f6152n + "',manufacturer=" + this.f6156r + "'}";
    }

    public final void a(int i10) {
        this.f6153o = i10;
    }

    public final void b(String str) {
        this.f6155q = str;
    }

    public final void a(String str) {
        this.f6154p = str;
    }
}
