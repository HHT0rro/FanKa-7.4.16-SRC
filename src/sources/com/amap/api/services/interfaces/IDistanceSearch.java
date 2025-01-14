package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IDistanceSearch {
    DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException;

    void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery distanceQuery);

    void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener);
}
