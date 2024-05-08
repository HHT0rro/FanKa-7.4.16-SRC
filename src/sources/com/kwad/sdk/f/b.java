package com.kwad.sdk.f;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b implements a {
    private static volatile b aHT;
    private static c aHU;

    private b() {
    }

    public static synchronized b Is() {
        b bVar;
        synchronized (b.class) {
            if (aHT == null) {
                synchronized (b.class) {
                    if (aHT == null) {
                        aHT = new b();
                    }
                }
            }
            bVar = aHT;
        }
        return bVar;
    }

    private static String It() {
        return a(false, "", 2);
    }

    public static void a(c cVar) {
        aHU = cVar;
    }

    @Override // com.kwad.sdk.f.a
    public final String Ig() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Ig();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Ih() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Ih();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Ii() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Ii();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Ij() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Ij();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Ik() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Ik();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Il() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Il();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Im() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Im();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String In() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.In();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Io() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Io();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Ip() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Ip();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Iq() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Iq();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String Ir() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.Ir();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String getAppId() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.getAppId();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String getDeviceId() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.getDeviceId();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String getIccId() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.getIccId();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String getIp() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.getIp();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String getLocation() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.getLocation();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String getOaid() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.getOaid();
        }
        return It();
    }

    @Override // com.kwad.sdk.f.a
    public final String getSdkVersion() {
        c cVar = aHU;
        if (cVar != null) {
            return cVar.getSdkVersion();
        }
        return It();
    }

    public static String a(boolean z10, Object obj, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z10));
        hashMap.put("value", obj);
        hashMap.put("errorCode", String.valueOf(i10));
        return new JSONObject(hashMap).toString();
    }
}
