package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PoiResult {

    /* renamed from: a, reason: collision with root package name */
    private int f8630a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItem> f8631b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearch.Query f8632c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearch.SearchBound f8633d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f8634e;

    /* renamed from: f, reason: collision with root package name */
    private List<SuggestionCity> f8635f;

    /* renamed from: g, reason: collision with root package name */
    private int f8636g;

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i10, int i11, ArrayList<PoiItem> arrayList) {
        this.f8631b = new ArrayList<>();
        this.f8632c = query;
        this.f8633d = searchBound;
        this.f8634e = list;
        this.f8635f = list2;
        this.f8636g = i10;
        this.f8630a = a(i11);
        this.f8631b = arrayList;
    }

    private int a(int i10) {
        return ((i10 + r0) - 1) / this.f8636g;
    }

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i10, int i11, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i10, i11, arrayList);
    }

    public final PoiSearch.SearchBound getBound() {
        return this.f8633d;
    }

    public final int getPageCount() {
        return this.f8630a;
    }

    public final ArrayList<PoiItem> getPois() {
        return this.f8631b;
    }

    public final PoiSearch.Query getQuery() {
        return this.f8632c;
    }

    public final List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f8635f;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f8634e;
    }
}
