package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.realidentity.build.aq;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    public d() {
        this(0, null);
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseBody() {
        try {
            putBody("protocolVersion", "2.0");
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
            int i10 = 1;
            putBody(ALBiometricsKeys.KEY_SDK_TYPE, 1);
            putBody("appInfo", com.kwad.sdk.core.request.model.a.EY());
            putBody("tkVersion", "5.1.7");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", com.kwad.sdk.core.request.model.d.Fc());
            if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).oK()) {
                i10 = 0;
            }
            putBody("liveSupportMode", i10);
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.Fb());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yu());
            putBody("ext", com.kwad.sdk.core.request.model.e.Fe());
            putBody("userInfo", com.kwad.sdk.core.request.model.g.Ff());
            putBody("requestSessionData", q.DQ().dP(getUrl()));
            putBody("timestamp", System.currentTimeMillis());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseHeader() {
        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        }
    }

    public boolean needAppList() {
        return false;
    }

    public d(int i10, @Nullable SceneImpl sceneImpl) {
        putBody(aq.F, com.kwad.sdk.core.request.model.b.h(needAppList(), i10));
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.c(sceneImpl));
        }
    }
}
