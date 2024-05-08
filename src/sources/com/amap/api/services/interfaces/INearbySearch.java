package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface INearbySearch {
    void addNearbyListener(NearbySearch.NearbyListener nearbyListener);

    void clearUserInfoAsyn();

    void destroy();

    void removeNearbyListener(NearbySearch.NearbyListener nearbyListener);

    NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException;

    void searchNearbyInfoAsyn(NearbySearch.NearbyQuery nearbyQuery);

    void setUserID(String str);

    void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i10);

    void stopUploadNearbyInfoAuto();

    void uploadNearbyInfoAsyn(UploadInfo uploadInfo);
}
