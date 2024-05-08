package com.huawei.hms.ads.templatead;

import com.huawei.hms.ads.annotation.AllApi;
import java.util.List;
import java.util.Map;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface TemplateAdListener {
    void onAdLoaded(Map<String, List<TemplateAd>> map);

    void onError(int i10);
}
