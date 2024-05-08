package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.g;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.b.f;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "llsid", this.llsid);
        t.putValue(jSONObject, "extra", this.extra);
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, "hasAd", this.hasAd);
        t.putValue(jSONObject, "errorMsg", this.errorMsg);
        t.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        t.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString("errorMsg");
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String optString = jSONObject.optString("extra");
        if (!bg.isNullString(optString)) {
            this.extra = ((e) c.f(e.class)).getResponseData(optString);
        }
        g gVar = (g) c.f(g.class);
        if (gVar != null) {
            gVar.ak(jSONObject.optString("egid"));
            gVar.x(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        f.Fi().eq(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
