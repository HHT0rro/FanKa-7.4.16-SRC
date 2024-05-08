package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IRoutePOISearch {
    RoutePOISearchQuery getQuery();

    RoutePOISearchResult searchRoutePOI() throws AMapException;

    void searchRoutePOIAsyn();

    void setQuery(RoutePOISearchQuery routePOISearchQuery);

    void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener);
}
