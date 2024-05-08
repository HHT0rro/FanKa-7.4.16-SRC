package com.huawei.hms.ads.event;

import android.content.Context;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.en;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.z;
import java.util.Map;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppEventReporter {
    @AllApi
    public static void reportEventData(Context context, Map<String, String> map) {
        g.V(context).Code(en.S, z.V(map), null, null);
    }
}
