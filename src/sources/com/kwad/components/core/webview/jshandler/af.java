package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class af implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String WO;
        public int WP;
        public String WQ;
        public int WR;
        public String WS;
        public String WT;
        public String WU;
        public int WV;
        public String WW;
        public int WX;
        public String WY;
        public String WZ;
        public int Xa;
        public int Xb;
        public int Xc;
        public int Xd;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public int sdkType;

        public static a so() {
            a aVar = new a();
            aVar.WO = BuildConfig.VERSION_NAME;
            aVar.WP = BuildConfig.VERSION_CODE;
            aVar.WQ = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
            aVar.WR = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode();
            aVar.sdkType = 1;
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.k.bQ(context);
            aVar.appName = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppId();
            aVar.WS = String.valueOf(com.kwad.sdk.utils.ag.ck(context));
            aVar.WT = bi.Nf();
            aVar.model = bi.MW();
            aVar.WU = bi.MY();
            aVar.WV = 1;
            aVar.WW = bi.getOsVersion();
            aVar.WX = bi.Ni();
            aVar.WY = bi.getLanguage();
            aVar.WZ = bi.getLocale();
            aVar.Xa = bi.getScreenWidth(context);
            aVar.Xb = bi.getScreenHeight(context);
            aVar.Xc = com.kwad.sdk.d.a.a.getStatusBarHeight(context);
            aVar.Xd = com.kwad.sdk.d.a.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(a.so());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
