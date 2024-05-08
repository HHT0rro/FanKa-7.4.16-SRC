package com.amap.api.col.p0003l;

import com.autonavi.amap.mapcore.DPoint;

/* compiled from: Bounds.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dg {

    /* renamed from: a, reason: collision with root package name */
    public final double f5338a;

    /* renamed from: b, reason: collision with root package name */
    public final double f5339b;

    /* renamed from: c, reason: collision with root package name */
    public final double f5340c;

    /* renamed from: d, reason: collision with root package name */
    public final double f5341d;

    /* renamed from: e, reason: collision with root package name */
    public final double f5342e;

    /* renamed from: f, reason: collision with root package name */
    public final double f5343f;

    public dg(double d10, double d11, double d12, double d13) {
        this.f5338a = d10;
        this.f5339b = d12;
        this.f5340c = d11;
        this.f5341d = d13;
        this.f5342e = (d10 + d11) / 2.0d;
        this.f5343f = (d12 + d13) / 2.0d;
    }

    public final boolean a(double d10, double d11) {
        return this.f5338a <= d10 && d10 <= this.f5340c && this.f5339b <= d11 && d11 <= this.f5341d;
    }

    public final boolean b(dg dgVar) {
        return dgVar.f5338a >= this.f5338a && dgVar.f5340c <= this.f5340c && dgVar.f5339b >= this.f5339b && dgVar.f5341d <= this.f5341d;
    }

    public final boolean a(DPoint dPoint) {
        return a(dPoint.f9303x, dPoint.f9304y);
    }

    private boolean a(double d10, double d11, double d12, double d13) {
        return d10 < this.f5340c && this.f5338a < d11 && d12 < this.f5341d && this.f5339b < d13;
    }

    public final boolean a(dg dgVar) {
        return a(dgVar.f5338a, dgVar.f5340c, dgVar.f5339b, dgVar.f5341d);
    }
}
