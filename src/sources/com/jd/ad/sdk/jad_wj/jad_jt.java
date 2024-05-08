package com.jd.ad.sdk.jad_wj;

import com.jd.ad.sdk.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JADResponse.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_jt {
    public int jad_an;
    public String jad_bo;
    public jad_hu jad_cp;

    public int jad_an() {
        return this.jad_an;
    }

    public String jad_bo() {
        return this.jad_bo;
    }

    public jad_hu jad_cp() {
        return this.jad_cp;
    }

    public static jad_jt jad_an(String str) {
        jad_jt jad_jtVar = new jad_jt();
        Logger.d("Gateway API Response: " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jad_jtVar.jad_an = jSONObject.optInt("statuscode");
            jad_jtVar.jad_bo = jSONObject.optString("msg");
            jSONObject.optString("id");
            jSONObject.optString("bidid");
            jad_jtVar.jad_cp = jad_hu.jad_an(jSONObject.optJSONObject("seatbid"));
            return jad_jtVar;
        } catch (JSONException e2) {
            throw e2;
        }
    }
}
