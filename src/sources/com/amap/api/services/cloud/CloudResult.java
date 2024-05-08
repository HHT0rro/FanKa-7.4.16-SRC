package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CloudResult {

    /* renamed from: a, reason: collision with root package name */
    private int f8406a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<CloudItem> f8407b;

    /* renamed from: c, reason: collision with root package name */
    private int f8408c;

    /* renamed from: d, reason: collision with root package name */
    private int f8409d;

    /* renamed from: e, reason: collision with root package name */
    private CloudSearch.Query f8410e;

    /* renamed from: f, reason: collision with root package name */
    private CloudSearch.SearchBound f8411f;

    private CloudResult(CloudSearch.Query query, int i10, CloudSearch.SearchBound searchBound, int i11, ArrayList<CloudItem> arrayList) {
        this.f8410e = query;
        this.f8408c = i10;
        this.f8409d = i11;
        this.f8406a = a(i10);
        this.f8407b = arrayList;
        this.f8411f = searchBound;
    }

    private int a(int i10) {
        return ((i10 + r0) - 1) / this.f8409d;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i10, CloudSearch.SearchBound searchBound, int i11, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i10, searchBound, i11, arrayList);
    }

    public final CloudSearch.SearchBound getBound() {
        return this.f8411f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.f8407b;
    }

    public final int getPageCount() {
        return this.f8406a;
    }

    public final CloudSearch.Query getQuery() {
        return this.f8410e;
    }

    public final int getTotalCount() {
        return this.f8408c;
    }
}
