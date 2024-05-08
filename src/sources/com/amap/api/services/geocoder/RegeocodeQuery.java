package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RegeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f8554a;

    /* renamed from: b, reason: collision with root package name */
    private float f8555b;

    /* renamed from: c, reason: collision with root package name */
    private String f8556c = GeocodeSearch.AMAP;

    /* renamed from: d, reason: collision with root package name */
    private String f8557d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f8558e = "distance";

    /* renamed from: f, reason: collision with root package name */
    private String f8559f = "base";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f10, String str) {
        this.f8554a = latLonPoint;
        this.f8555b = f10;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        String str = this.f8556c;
        if (str == null) {
            if (regeocodeQuery.f8556c != null) {
                return false;
            }
        } else if (!str.equals(regeocodeQuery.f8556c)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f8554a;
        if (latLonPoint == null) {
            if (regeocodeQuery.f8554a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(regeocodeQuery.f8554a)) {
            return false;
        }
        if (Float.floatToIntBits(this.f8555b) != Float.floatToIntBits(regeocodeQuery.f8555b) || !this.f8558e.equals(regeocodeQuery.f8558e)) {
            return false;
        }
        String str2 = this.f8559f;
        if (str2 == null) {
            if (regeocodeQuery.f8559f != null) {
                return false;
            }
        } else if (!str2.equals(regeocodeQuery.f8559f)) {
            return false;
        }
        return true;
    }

    public String getExtensions() {
        return this.f8559f;
    }

    public String getLatLonType() {
        return this.f8556c;
    }

    public String getMode() {
        return this.f8558e;
    }

    public String getPoiType() {
        return this.f8557d;
    }

    public LatLonPoint getPoint() {
        return this.f8554a;
    }

    public float getRadius() {
        return this.f8555b;
    }

    public int hashCode() {
        String str = this.f8556c;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f8554a;
        return ((hashCode + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f8555b);
    }

    public void setExtensions(String str) {
        this.f8559f = str;
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
                this.f8556c = str;
            }
        }
    }

    public void setMode(String str) {
        this.f8558e = str;
    }

    public void setPoiType(String str) {
        this.f8557d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f8554a = latLonPoint;
    }

    public void setRadius(float f10) {
        this.f8555b = f10;
    }
}
