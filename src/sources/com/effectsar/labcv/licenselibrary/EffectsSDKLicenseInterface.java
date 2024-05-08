package com.effectsar.labcv.licenselibrary;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface EffectsSDKLicenseInterface {
    void clearParams();

    int getLicenseWithParams(HashMap<String, String> hashMap, boolean z10, LicenseCallback licenseCallback);

    String getParam(String str);

    void registerHttpProvider(HttpRequestProvider httpRequestProvider);

    void setParam(String str, String str2);

    int updateLicenseWithParams(HashMap<String, String> hashMap, boolean z10, LicenseCallback licenseCallback);
}
