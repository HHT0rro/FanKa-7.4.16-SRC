package com.huawei.quickcard;

import com.huawei.quickcard.exposure.IExposureCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private IExposureCallback f33572a;

    /* renamed from: b, reason: collision with root package name */
    private int f33573b;

    /* renamed from: c, reason: collision with root package name */
    private int f33574c;

    /* renamed from: d, reason: collision with root package name */
    private int f33575d;

    /* renamed from: e, reason: collision with root package name */
    private int f33576e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33577f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33578g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33579h;

    /* renamed from: i, reason: collision with root package name */
    private long f33580i;

    public void a(IExposureCallback iExposureCallback) {
        this.f33572a = iExposureCallback;
    }

    public void b(int i10) {
        this.f33574c = i10;
    }

    public IExposureCallback c() {
        return this.f33572a;
    }

    public int d() {
        return this.f33573b;
    }

    public int e() {
        return this.f33574c;
    }

    public int f() {
        return this.f33575d;
    }

    public int g() {
        return this.f33576e;
    }

    public boolean h() {
        return this.f33578g;
    }

    public boolean i() {
        return this.f33579h;
    }

    public boolean j() {
        return this.f33577f;
    }

    public void a(int i10) {
        this.f33573b = i10;
    }

    public void b(boolean z10) {
        this.f33579h = z10;
    }

    public void c(int i10) {
        this.f33575d = i10;
    }

    public void d(int i10) {
        this.f33576e = i10;
    }

    public void a(boolean z10) {
        this.f33578g = z10;
    }

    public long b() {
        return this.f33580i;
    }

    public void c(boolean z10) {
        this.f33577f = z10;
    }

    public void a(long j10) {
        this.f33580i = j10;
    }

    public boolean a() {
        return this.f33577f && this.f33576e == 0 && this.f33575d == 1 && this.f33578g;
    }
}
