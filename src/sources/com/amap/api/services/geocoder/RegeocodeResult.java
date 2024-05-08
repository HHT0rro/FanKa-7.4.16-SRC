package com.amap.api.services.geocoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RegeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private RegeocodeQuery f8560a;

    /* renamed from: b, reason: collision with root package name */
    private RegeocodeAddress f8561b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f8560a = regeocodeQuery;
        this.f8561b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f8561b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f8560a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f8561b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f8560a = regeocodeQuery;
    }
}
