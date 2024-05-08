package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BusStationResult {

    /* renamed from: a, reason: collision with root package name */
    private int f8391a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusStationItem> f8392b;

    /* renamed from: c, reason: collision with root package name */
    private BusStationQuery f8393c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f8394d;

    /* renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f8395e;

    private BusStationResult(BusStationQuery busStationQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.f8392b = new ArrayList<>();
        this.f8394d = new ArrayList();
        this.f8395e = new ArrayList();
        this.f8393c = busStationQuery;
        this.f8391a = a(i10);
        this.f8395e = list;
        this.f8394d = list2;
        this.f8392b = arrayList;
    }

    private int a(int i10) {
        int pageSize = ((i10 + r0) - 1) / this.f8393c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i10, list, list2, arrayList);
    }

    public final List<BusStationItem> getBusStations() {
        return this.f8392b;
    }

    public final int getPageCount() {
        return this.f8391a;
    }

    public final BusStationQuery getQuery() {
        return this.f8393c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f8395e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f8394d;
    }
}
