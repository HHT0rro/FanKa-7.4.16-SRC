package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.alipay.sdk.app.statistic.c;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.b;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WebViewCommercialMsg extends a implements Serializable {
    private static final long serialVersionUID = -1007322423487775751L;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject extraParam;
    public JSONObject msg;
    public String primaryKey;
    public double rate;
    public SubBusinessType subBiz;
    public String suffixRatio;
    public String tag;
    public b type;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("sub_biz")) {
            try {
                this.subBiz = SubBusinessType.valueOf(jSONObject.optString("sub_biz"));
            } catch (Exception unused) {
                this.subBiz = SubBusinessType.OTHER;
            }
        }
        if (jSONObject.has(c.f4432b)) {
            try {
                this.biz = BusinessType.valueOf(jSONObject.optString(c.f4432b));
            } catch (Exception unused2) {
                this.biz = BusinessType.OTHER;
            }
        }
        if (jSONObject.has("type")) {
            try {
                this.type = new b(jSONObject.optString("type"));
            } catch (Exception unused3) {
                this.type = new b("OTHER");
            }
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.putValue(jSONObject, c.f4432b, this.biz.value);
        t.putValue(jSONObject, "subBiz", this.subBiz.value);
        t.putValue(jSONObject, "type", this.type.getValue());
    }
}
