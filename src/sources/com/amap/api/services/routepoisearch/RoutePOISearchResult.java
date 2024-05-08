package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoutePOISearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<RoutePOIItem> f9083a;

    /* renamed from: b, reason: collision with root package name */
    private RoutePOISearchQuery f9084b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        new ArrayList();
        this.f9083a = arrayList;
        this.f9084b = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.f9084b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f9083a;
    }
}
