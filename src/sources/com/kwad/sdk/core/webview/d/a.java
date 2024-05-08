package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0532a extends com.kwad.sdk.core.response.a.a {
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
        public String aEF;
        public String aEG;
        public boolean aEH;
        public String aEI;
        public String appId;
        public String appName;
        public String appVersion;
        public String atm;
        public String atn;
        public String ayD;
        public String azF;
        public String azo;
        public String azt;
        public String azu;
        public String model;
        public int sdkType;

        public static C0532a Ha() {
            C0532a c0532a = new C0532a();
            c0532a.WO = BuildConfig.VERSION_NAME;
            c0532a.WP = BuildConfig.VERSION_CODE;
            c0532a.ayD = "5.1.7";
            c0532a.aEI = "1.3";
            c0532a.WQ = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0532a.WR = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0532a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0532a.appVersion = k.bQ(context);
            c0532a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0532a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0532a.aEF = "";
            c0532a.azu = y.LL();
            g gVar = (g) c.f(g.class);
            if (gVar != null) {
                c0532a.azt = gVar.ow();
            }
            c0532a.WS = String.valueOf(ag.ck(context));
            c0532a.WT = bi.Nf();
            c0532a.model = bi.MW();
            c0532a.WU = bi.MY();
            c0532a.WV = 1;
            c0532a.WW = bi.getOsVersion();
            c0532a.WX = bi.Ni();
            c0532a.WY = bi.getLanguage();
            c0532a.WZ = bi.getLocale();
            c0532a.aEH = ((f) ServiceProvider.get(f.class)).yp();
            c0532a.aEG = av.getDeviceId();
            c0532a.Xa = bi.getScreenWidth(context);
            c0532a.Xb = bi.getScreenHeight(context);
            c0532a.atm = av.cv(context);
            c0532a.atn = av.getOaid();
            c0532a.azo = av.cw(context);
            c0532a.azF = av.cx(context);
            c0532a.Xc = com.kwad.sdk.d.a.a.getStatusBarHeight(context);
            c0532a.Xd = com.kwad.sdk.d.a.a.a(context, 50.0f);
            return c0532a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(C0532a.Ha());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
