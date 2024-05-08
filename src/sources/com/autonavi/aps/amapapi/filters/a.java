package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.j;

/* compiled from: LocFilter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public com.autonavi.aps.amapapi.model.a f9374a = null;

    /* renamed from: b, reason: collision with root package name */
    public long f9375b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f9376c = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9381h = true;

    /* renamed from: d, reason: collision with root package name */
    public int f9377d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f9378e = 0;

    /* renamed from: f, reason: collision with root package name */
    public AMapLocation f9379f = null;

    /* renamed from: g, reason: collision with root package name */
    public long f9380g = 0;

    private com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.a(aVar)) {
            if (this.f9381h && com.autonavi.aps.amapapi.utils.a.a(aVar.getTime())) {
                if (aVar.getLocationType() == 5 || aVar.getLocationType() == 6) {
                    aVar.setLocationType(4);
                }
            } else {
                aVar.setLocationType(this.f9377d);
            }
        }
        return aVar;
    }

    public final void a() {
        this.f9374a = null;
        this.f9375b = 0L;
        this.f9376c = 0L;
        this.f9379f = null;
        this.f9380g = 0L;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.b() - this.f9378e > 30000) {
            this.f9374a = aVar;
            this.f9378e = j.b();
            return this.f9374a;
        }
        this.f9378e = j.b();
        if (!j.a(this.f9374a) || !j.a(aVar)) {
            this.f9375b = j.b();
            this.f9374a = aVar;
            return aVar;
        }
        if (aVar.getTime() == this.f9374a.getTime() && aVar.getAccuracy() < 300.0f) {
            return aVar;
        }
        if (GeocodeSearch.GPS.equals(aVar.getProvider())) {
            this.f9375b = j.b();
            this.f9374a = aVar;
            return aVar;
        }
        if (aVar.c() != this.f9374a.c()) {
            this.f9375b = j.b();
            this.f9374a = aVar;
            return aVar;
        }
        if (aVar.getBuildingId() != null && !aVar.getBuildingId().equals(this.f9374a.getBuildingId()) && !TextUtils.isEmpty(aVar.getBuildingId())) {
            this.f9375b = j.b();
            this.f9374a = aVar;
            return aVar;
        }
        this.f9377d = aVar.getLocationType();
        float a10 = j.a(aVar, this.f9374a);
        float accuracy = this.f9374a.getAccuracy();
        float accuracy2 = aVar.getAccuracy();
        float f10 = accuracy2 - accuracy;
        long b4 = j.b();
        long j10 = b4 - this.f9375b;
        boolean z10 = accuracy <= 100.0f && accuracy2 > 299.0f;
        boolean z11 = accuracy > 299.0f && accuracy2 > 299.0f;
        if (z10 || z11) {
            long j11 = this.f9376c;
            if (j11 == 0) {
                this.f9376c = b4;
            } else if (b4 - j11 > 30000) {
                this.f9375b = b4;
                this.f9374a = aVar;
                this.f9376c = 0L;
                return aVar;
            }
            com.autonavi.aps.amapapi.model.a b10 = b(this.f9374a);
            this.f9374a = b10;
            return b10;
        }
        if (accuracy2 < 100.0f && accuracy > 299.0f) {
            this.f9375b = b4;
            this.f9374a = aVar;
            this.f9376c = 0L;
            return aVar;
        }
        if (accuracy2 <= 299.0f) {
            this.f9376c = 0L;
        }
        if (a10 >= 10.0f || a10 <= 0.1d || accuracy2 <= 5.0f) {
            if (f10 < 300.0f) {
                this.f9375b = j.b();
                this.f9374a = aVar;
                return aVar;
            }
            if (j10 >= 30000) {
                this.f9375b = j.b();
                this.f9374a = aVar;
                return aVar;
            }
            com.autonavi.aps.amapapi.model.a b11 = b(this.f9374a);
            this.f9374a = b11;
            return b11;
        }
        if (f10 >= -300.0f) {
            com.autonavi.aps.amapapi.model.a b12 = b(this.f9374a);
            this.f9374a = b12;
            return b12;
        }
        if (accuracy / accuracy2 >= 2.0f) {
            this.f9375b = b4;
            this.f9374a = aVar;
            return aVar;
        }
        com.autonavi.aps.amapapi.model.a b13 = b(this.f9374a);
        this.f9374a = b13;
        return b13;
    }

    public final void a(boolean z10) {
        this.f9381h = z10;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (!j.a(aMapLocation)) {
            return aMapLocation;
        }
        long b4 = j.b() - this.f9380g;
        this.f9380g = j.b();
        if (b4 > 5000) {
            return aMapLocation;
        }
        AMapLocation aMapLocation2 = this.f9379f;
        if (aMapLocation2 == null) {
            this.f9379f = aMapLocation;
            return aMapLocation;
        }
        if (1 != aMapLocation2.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.f9379f.getProvider())) {
            this.f9379f = aMapLocation;
            return aMapLocation;
        }
        if (this.f9379f.getAltitude() == aMapLocation.getAltitude() && this.f9379f.getLongitude() == aMapLocation.getLongitude()) {
            this.f9379f = aMapLocation;
            return aMapLocation;
        }
        long abs = Math.abs(aMapLocation.getTime() - this.f9379f.getTime());
        if (30000 < abs) {
            this.f9379f = aMapLocation;
            return aMapLocation;
        }
        if (j.a(aMapLocation, this.f9379f) > (((this.f9379f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.f9379f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
            return this.f9379f;
        }
        this.f9379f = aMapLocation;
        return aMapLocation;
    }
}
