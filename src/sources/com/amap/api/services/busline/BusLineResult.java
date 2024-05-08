package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BusLineResult {

    /* renamed from: a, reason: collision with root package name */
    private int f8375a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<BusLineItem> f8376b;

    /* renamed from: c, reason: collision with root package name */
    private BusLineQuery f8377c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f8378d;

    /* renamed from: e, reason: collision with root package name */
    private List<SuggestionCity> f8379e;

    private BusLineResult(BusLineQuery busLineQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        this.f8376b = new ArrayList<>();
        this.f8378d = new ArrayList();
        this.f8379e = new ArrayList();
        this.f8377c = busLineQuery;
        this.f8375a = a(i10);
        this.f8379e = list;
        this.f8378d = list2;
        this.f8376b = arrayList;
    }

    private int a(int i10) {
        int pageSize = ((i10 + r0) - 1) / this.f8377c.getPageSize();
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public static BusLineResult createPagedResult(BusLineQuery busLineQuery, int i10, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        return new BusLineResult(busLineQuery, i10, list, list2, arrayList);
    }

    public final List<BusLineItem> getBusLines() {
        return this.f8376b;
    }

    public final int getPageCount() {
        return this.f8375a;
    }

    public final BusLineQuery getQuery() {
        return this.f8377c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f8379e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f8378d;
    }
}
