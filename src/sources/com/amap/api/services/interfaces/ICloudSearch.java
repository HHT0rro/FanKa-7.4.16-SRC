package com.amap.api.services.interfaces;

import com.amap.api.services.cloud.CloudSearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ICloudSearch {
    void searchCloudAsyn(CloudSearch.Query query);

    void searchCloudDetailAsyn(String str, String str2);

    void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener);
}
