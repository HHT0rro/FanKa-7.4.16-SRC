package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IGeocodeSearch {
    RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException;

    void getFromLocationAsyn(RegeocodeQuery regeocodeQuery);

    List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException;

    void getFromLocationNameAsyn(GeocodeQuery geocodeQuery);

    void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener);
}
