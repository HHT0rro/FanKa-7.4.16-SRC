package com.kwad.sdk.l.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends com.kwad.sdk.core.response.a.a {
    public int aNd = -1;
    public int aNe = -1;

    public static synchronized f Kz() {
        synchronized (f.class) {
            if (!((h) ServiceProvider.get(h.class)).yA()) {
                return null;
            }
            return az.Kz();
        }
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.aNd = jSONObject.optInt("phoneCount", -1);
        fVar.aNe = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(f fVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "phoneCount", fVar.aNd);
        t.putValue(jSONObject, "activePhoneCount", fVar.aNe);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b4 = b(this, new JSONObject());
        afterToJson(b4);
        return b4;
    }
}
