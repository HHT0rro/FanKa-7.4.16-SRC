package com.bytedance.sdk.openadsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TTLocation implements LocationProvider {
    private double dk;

    /* renamed from: m, reason: collision with root package name */
    private double f11073m;

    public TTLocation(double d10, double d11) {
        this.f11073m = d10;
        this.dk = d11;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f11073m;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.dk;
    }

    public void setLatitude(double d10) {
        this.f11073m = d10;
    }

    public void setLongitude(double d10) {
        this.dk = d10;
    }
}
