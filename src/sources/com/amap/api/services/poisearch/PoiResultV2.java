package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PoiResultV2 {

    /* renamed from: a, reason: collision with root package name */
    private int f8637a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<PoiItemV2> f8638b;

    /* renamed from: c, reason: collision with root package name */
    private PoiSearchV2.Query f8639c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearchV2.SearchBound f8640d;

    private PoiResultV2(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i10, ArrayList<PoiItemV2> arrayList) {
        new ArrayList();
        this.f8639c = query;
        this.f8640d = searchBound;
        this.f8637a = i10;
        this.f8638b = arrayList;
    }

    public static PoiResultV2 createPagedResult(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i10, ArrayList<PoiItemV2> arrayList) {
        return new PoiResultV2(query, searchBound, i10, arrayList);
    }

    public PoiSearchV2.SearchBound getBound() {
        return this.f8640d;
    }

    public int getCount() {
        return this.f8637a;
    }

    public ArrayList<PoiItemV2> getPois() {
        return this.f8638b;
    }

    public PoiSearchV2.Query getQuery() {
        return this.f8639c;
    }
}
