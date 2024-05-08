package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.as;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c azE;
    private double latitude;
    private double longitude;
    private int type;

    public static c Fb() {
        Location location;
        c cVar = azE;
        if (cVar != null) {
            return cVar;
        }
        try {
            azE = new c();
            com.kwad.sdk.utils.c.a bV = av.bV(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (bV != null && (location = bV.aSm) != null) {
                azE.latitude = location.getLatitude();
                azE.longitude = bV.aSm.getLongitude();
                azE.type = bV.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return azE;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, as.at, this.latitude);
        t.putValue(jSONObject, as.au, this.longitude);
        t.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }
}
