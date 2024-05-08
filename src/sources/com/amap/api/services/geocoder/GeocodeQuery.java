package com.amap.api.services.geocoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private String f8530a;

    /* renamed from: b, reason: collision with root package name */
    private String f8531b;

    /* renamed from: c, reason: collision with root package name */
    private String f8532c;

    public GeocodeQuery(String str, String str2) {
        this.f8530a = str;
        this.f8531b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        String str = this.f8531b;
        if (str == null) {
            if (geocodeQuery.f8531b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.f8531b)) {
            return false;
        }
        String str2 = this.f8530a;
        if (str2 == null) {
            if (geocodeQuery.f8530a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.f8530a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.f8531b;
    }

    public String getCountry() {
        return this.f8532c;
    }

    public String getLocationName() {
        return this.f8530a;
    }

    public int hashCode() {
        String str = this.f8531b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f8530a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f8531b = str;
    }

    public void setCountry(String str) {
        this.f8532c = str;
    }

    public void setLocationName(String str) {
        this.f8530a = str;
    }
}
