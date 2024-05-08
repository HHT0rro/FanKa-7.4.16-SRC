package com.huawei.appgallery.agd.common.flavor;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IFlavorConfig {
    void biLog(int i10, String str, LinkedHashMap<String, String> linkedHashMap);

    String getBiUrl(Context context);

    Map<String, String> getGrsOfProperties();

    String getRiskToken();

    boolean isMediaManager();

    boolean isPrintLog(int i10);

    boolean shouldCancelWhenWebSslError();

    boolean shouldRestrictUrlScheme();
}
