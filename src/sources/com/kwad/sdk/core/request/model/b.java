package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;
import org.json.JSONArray;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static boolean aze;
    private static JSONArray azf;
    public String RN;
    public String WU;
    public int WV;
    public int WX;
    public String WY;
    public int Xa;
    public int Xb;
    public String atm;
    public String atn;
    public String azA;
    public String azC;
    public String azD;
    public String azg;
    public String azh;
    public String azi;
    public String azj;
    public String azk;
    public String azl;
    public int azm;
    public int azn;
    public String azo;
    public String azp;
    public String azq;
    public int azr;
    public String azs;
    public String azt;
    public String azu;
    public JSONArray azv;
    public String azw;
    public String azy;
    public String azz;
    public int azx = 0;
    public long azB = 0;

    public static b Fa() {
        b bVar = new b();
        try {
            bVar.atn = av.getOaid();
            bVar.azp = av.getDeviceId();
            bVar.azs = bi.MW();
            bVar.WV = 1;
            bVar.WX = bi.Ni();
            bVar.azl = bi.getOsVersion();
            bVar.azu = y.LL();
            com.kwad.sdk.components.g gVar = (com.kwad.sdk.components.g) com.kwad.sdk.components.c.f(com.kwad.sdk.components.g.class);
            if (gVar != null) {
                bVar.azt = gVar.ow();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.atm = av.cv(ServiceProvider.KO());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static synchronized JSONArray bh(Context context) {
        synchronized (b.class) {
            if (!aze) {
                aze = true;
                InstalledAppInfoManager.a(context, new com.kwad.sdk.g.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                    private static void g(JSONArray jSONArray) {
                        JSONArray unused = b.azf = jSONArray;
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(JSONArray jSONArray) {
                        g(jSONArray);
                    }
                });
            }
            JSONArray jSONArray = azf;
            if (jSONArray == null) {
                return null;
            }
            azf = null;
            return jSONArray;
        }
    }

    public static b h(boolean z10, int i10) {
        b bVar = new b();
        try {
            Context KO = ServiceProvider.KO();
            bVar.atm = av.cv(KO);
            bVar.azg = av.cy(KO);
            bVar.azh = av.cz(KO);
            bVar.azi = bi.cZ(KO);
            bVar.atn = av.getOaid();
            bVar.azs = bi.MW();
            bVar.WU = bi.MY();
            bVar.WV = 1;
            bVar.WX = bi.Ni();
            bVar.azl = bi.getOsVersion();
            bVar.WY = k.getLanguage();
            bVar.Xb = k.getScreenHeight(KO);
            bVar.Xa = k.getScreenWidth(KO);
            bVar.azm = k.bT(KO);
            bVar.azn = k.bU(KO);
            bVar.azo = av.cw(KO);
            if (z10) {
                bVar.azv = bh(KO);
            }
            bVar.azp = av.getDeviceId();
            bVar.azB = bi.MX();
            bVar.azq = bi.Nf();
            bVar.azu = y.LL();
            com.kwad.sdk.components.g gVar = (com.kwad.sdk.components.g) com.kwad.sdk.components.c.f(com.kwad.sdk.components.g.class);
            if (gVar != null) {
                bVar.azt = gVar.ow();
            }
            bVar.azr = bi.Ng();
            com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
            try {
                StringBuilder sb2 = new StringBuilder("i=");
                sb2.append(fVar.getAppId());
                sb2.append(",n=");
                sb2.append(fVar.getAppName());
                sb2.append(",external:");
                sb2.append(fVar.yp());
                sb2.append(",v1:");
                sb2.append(fVar.getApiVersion());
                sb2.append(",v2:3.3.59.1");
                sb2.append(",d:");
                sb2.append(bVar.azp);
                sb2.append(",dh:");
                String str = bVar.azp;
                sb2.append(str != null ? Integer.valueOf(str.hashCode()) : "");
                sb2.append(",o:");
                sb2.append(bVar.atn);
                sb2.append(",b:616");
                sb2.append(",p:");
                sb2.append(aq.isInMainProcess(KO));
                sb2.append(",dy:");
                sb2.append((Object) com.kwad.framework.a.a.adG);
                com.kwad.sdk.core.e.c.T("DeviceInfo", sb2.toString());
            } catch (Exception unused) {
            }
            bVar.azw = bi.Nh();
            bVar.azx = i10;
            if (yH()) {
                bVar.azy = com.kwad.sdk.b.b.Ao().getVersion(KO, "com.smile.gifmaker");
                bVar.azz = com.kwad.sdk.b.b.Ao().getVersion(KO, "com.kuaishou.nebula");
                bVar.azA = com.kwad.sdk.b.b.Ao().getVersion(KO, "com.tencent.mm");
            }
            bVar.RN = bi.Nd();
            bVar.azk = ae.ci(KO);
            bVar.azC = bi.Nm();
            bVar.azD = bi.ha("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static boolean yH() {
        return ((h) ServiceProvider.get(h.class)).yH();
    }
}
