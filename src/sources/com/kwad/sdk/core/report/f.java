package com.kwad.sdk.core.report;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public String axz;

    public f(List<n> list) {
        this.axz = "";
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<n> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            com.kwad.sdk.utils.t.a(jSONArray, iterator2.next().buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        if (encryptDisable() && !TextUtils.isEmpty(this.axz)) {
            putBody("actionListString", this.axz);
        }
        return super.getBody();
    }

    @Override // com.kwad.sdk.core.network.b
    public final String getBodyParamsString() {
        String bodyParamsString = super.getBodyParamsString();
        try {
            if (TextUtils.isEmpty(this.axz)) {
                return bodyParamsString;
            }
            StringBuilder sb2 = new StringBuilder(bodyParamsString);
            sb2.insert(sb2.length() - 1, this.axz);
            return sb2.toString();
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return bodyParamsString;
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.g.ya();
    }

    public f(String str) {
        this.axz = str;
    }
}
