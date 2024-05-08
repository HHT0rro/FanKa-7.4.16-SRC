package com.kwad.sdk.collector.a;

import com.huawei.openalliance.ad.constant.bg;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.g;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends d {
    public b(Collection<e> collection) {
        putBody("collectData", a(collection));
        putBody("collectType", 1);
        putBody(bg.e.Code, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    private static JSONArray a(Collection<e> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<e> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            JSONObject AC = iterator2.next().AC();
            if (AC != null) {
                jSONArray.put(AC);
            }
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return g.yf();
    }
}
