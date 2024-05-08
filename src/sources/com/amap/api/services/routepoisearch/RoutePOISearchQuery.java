package com.amap.api.services.routepoisearch;

import com.amap.api.col.s.n;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoutePOISearchQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9076a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9077b;

    /* renamed from: c, reason: collision with root package name */
    private int f9078c;

    /* renamed from: d, reason: collision with root package name */
    private RoutePOISearch.RoutePOISearchType f9079d;

    /* renamed from: e, reason: collision with root package name */
    private int f9080e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f9081f;

    /* renamed from: g, reason: collision with root package name */
    private String f9082g;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i10, RoutePOISearch.RoutePOISearchType routePOISearchType, int i11) {
        this.f9076a = latLonPoint;
        this.f9077b = latLonPoint2;
        this.f9078c = i10;
        this.f9079d = routePOISearchType;
        this.f9080e = i11;
    }

    public String getChannel() {
        return this.f9082g;
    }

    public LatLonPoint getFrom() {
        return this.f9076a;
    }

    public int getMode() {
        return this.f9078c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f9081f;
    }

    public int getRange() {
        return this.f9080e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.f9079d;
    }

    public LatLonPoint getTo() {
        return this.f9077b;
    }

    public void setChannel(String str) {
        this.f9082g = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RoutePOISearchQuery m1994clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            n.a(e2, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f9081f;
        if (list != null && list.size() > 0) {
            RoutePOISearchQuery routePOISearchQuery = new RoutePOISearchQuery(this.f9081f, this.f9079d, this.f9080e);
            routePOISearchQuery.setChannel(this.f9082g);
            return routePOISearchQuery;
        }
        RoutePOISearchQuery routePOISearchQuery2 = new RoutePOISearchQuery(this.f9076a, this.f9077b, this.f9078c, this.f9079d, this.f9080e);
        routePOISearchQuery2.setChannel(this.f9082g);
        return routePOISearchQuery2;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i10) {
        this.f9081f = list;
        this.f9079d = routePOISearchType;
        this.f9080e = i10;
    }
}
