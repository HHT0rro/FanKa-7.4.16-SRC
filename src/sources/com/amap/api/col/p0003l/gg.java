package com.amap.api.col.p0003l;

import com.huawei.openalliance.ad.constant.u;

/* compiled from: AMapRecallLogUpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gg extends ja {

    /* renamed from: g, reason: collision with root package name */
    private static int f6072g = 10000000;

    /* renamed from: a, reason: collision with root package name */
    public int f6073a;

    /* renamed from: b, reason: collision with root package name */
    public long f6074b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6075d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6076e;

    /* renamed from: f, reason: collision with root package name */
    private int f6077f;

    /* renamed from: h, reason: collision with root package name */
    private long f6078h;

    public gg(boolean z10, ja jaVar, long j10, int i10) {
        super(jaVar);
        this.f6076e = false;
        this.f6075d = z10;
        this.f6073a = u.Y;
        this.f6078h = j10;
        this.f6077f = i10;
    }

    @Override // com.amap.api.col.p0003l.ja
    public final int a() {
        return 320000;
    }

    public final void a(boolean z10) {
        this.f6076e = z10;
    }

    public final long b() {
        return this.f6078h;
    }

    @Override // com.amap.api.col.p0003l.ja
    public final boolean c() {
        if (this.f6076e && this.f6078h <= this.f6077f) {
            return true;
        }
        if (!this.f6075d || this.f6078h >= this.f6077f) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6074b < this.f6073a) {
            return false;
        }
        this.f6074b = currentTimeMillis;
        return true;
    }

    public final void a(int i10) {
        if (i10 <= 0) {
            return;
        }
        this.f6078h += i10;
    }
}
