package com.kwad.sdk.collector.a;

import com.huawei.openalliance.ad.constant.bg;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.g;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends d {
    private C0511a anF;

    /* renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0511a {
        private List<String> anG;

        public C0511a(List<String> list) {
            this.anG = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "packageName", this.anG);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0511a c0511a = new C0511a(list);
        this.anF = c0511a;
        putBody("targetAppInfo", c0511a.toJson());
        putBody(bg.e.Code, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return g.ye();
    }
}
