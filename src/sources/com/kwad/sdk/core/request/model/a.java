package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject azc;
    private String appId;
    private String azd;
    private String name;
    private String packageName;
    private String version;

    public static JSONObject EY() {
        if (!l(azc)) {
            azc = EZ().toJson();
        }
        return azc;
    }

    public static a EZ() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.KP().appId;
            aVar.name = ServiceProvider.KP().appName;
            aVar.packageName = ServiceProvider.KO().getPackageName();
            aVar.version = k.bQ(ServiceProvider.KO());
            aVar.azd = com.kwad.sdk.utils.e.bG(ServiceProvider.KO());
            if (!TextUtils.isEmpty(bj.getAppId())) {
                aVar.appId = bj.getAppId();
            }
            if (!TextUtils.isEmpty(bj.getPackageName())) {
                aVar.packageName = bj.getPackageName();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aVar;
    }

    private static boolean l(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(ServiceProvider.KP().appId) && optString2.equals(ServiceProvider.KP().appName);
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "appId", this.appId);
        t.putValue(jSONObject, "name", this.name);
        t.putValue(jSONObject, "packageName", this.packageName);
        t.putValue(jSONObject, "version", this.version);
        t.putValue(jSONObject, "sha1", this.azd);
        return jSONObject;
    }
}
