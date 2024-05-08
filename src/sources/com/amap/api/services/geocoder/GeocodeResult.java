package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private GeocodeQuery f8533a;

    /* renamed from: b, reason: collision with root package name */
    private List<GeocodeAddress> f8534b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        new ArrayList();
        this.f8533a = geocodeQuery;
        this.f8534b = list;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f8534b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f8533a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f8534b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f8533a = geocodeQuery;
    }
}
