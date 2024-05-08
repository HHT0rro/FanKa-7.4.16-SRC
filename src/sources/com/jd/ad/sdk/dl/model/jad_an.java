package com.jd.ad.sdk.dl.model;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JADExposureExtend.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an implements Serializable {
    public int jad_an;
    public int jad_bo;
    public int jad_cp;
    public int jad_dq;
    public int jad_er;

    public jad_an(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.jad_an = jSONObject.optInt("visible_area");
        this.jad_bo = jSONObject.optInt("width");
        this.jad_cp = jSONObject.optInt("height");
        this.jad_dq = jSONObject.optInt("visible_width");
        this.jad_er = jSONObject.optInt("visible_height");
    }

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible_area", this.jad_an);
            jSONObject.put("width", this.jad_bo);
            jSONObject.put("height", this.jad_cp);
            jSONObject.put("visible_width", this.jad_dq);
            jSONObject.put("visible_height", this.jad_er);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
