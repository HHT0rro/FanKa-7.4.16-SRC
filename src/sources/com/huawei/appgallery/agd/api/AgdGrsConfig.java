package com.huawei.appgallery.agd.api;

import android.content.Context;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdGrsConfig {
    @Deprecated
    public static void setAppName(Context context, String str) {
        CoreServiceApi.setAppName(context, str);
    }

    public static void setHomeCountry(Context context, String str) {
        CoreServiceApi.setHomeCountry(context, str);
    }
}
