package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.p0003l.hi;
import com.amap.api.col.p0003l.hj;
import com.amap.api.location.AMapLocation;

/* compiled from: LastLocationInfo.java */
@hi(a = "c")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @hj(a = "a2", b = 6)
    private String f9538a;

    /* renamed from: b, reason: collision with root package name */
    @hj(a = "a3", b = 5)
    private long f9539b;

    /* renamed from: c, reason: collision with root package name */
    @hj(a = "a4", b = 6)
    private String f9540c;

    /* renamed from: d, reason: collision with root package name */
    private AMapLocation f9541d;

    public final AMapLocation a() {
        return this.f9541d;
    }

    public final String b() {
        return this.f9540c;
    }

    public final String c() {
        return this.f9538a;
    }

    public final long d() {
        return this.f9539b;
    }

    public final void a(AMapLocation aMapLocation) {
        this.f9541d = aMapLocation;
    }

    public final void b(String str) {
        this.f9538a = str;
    }

    public final void a(String str) {
        this.f9540c = str;
    }

    public final void a(long j10) {
        this.f9539b = j10;
    }
}
