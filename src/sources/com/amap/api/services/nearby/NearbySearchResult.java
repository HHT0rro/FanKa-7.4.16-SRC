package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NearbySearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<NearbyInfo> f8600a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f8601b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f8600a;
    }

    public int getTotalNum() {
        return this.f8601b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f8600a = list;
        this.f8601b = list.size();
    }
}
