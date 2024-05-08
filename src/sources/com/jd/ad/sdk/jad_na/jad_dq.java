package com.jd.ad.sdk.jad_na;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import org.json.JSONObject;

/* compiled from: ANEvents.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_dq {
    public String jad_an;
    public int jad_bo;
    public int jad_cp;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("url", this.jad_an);
            jSONObject.putOpt("mn", Integer.valueOf(this.jad_bo));
            jSONObject.putOpt("ci", Integer.valueOf(this.jad_cp));
        } catch (Exception e2) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an events to json ");
            jad_an.append(e2.getMessage());
            Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANEvents{url='");
        jad_an.append(this.jad_an);
        jad_an.append('\'');
        jad_an.append(", mn=");
        jad_an.append(this.jad_bo);
        jad_an.append(", ci=");
        jad_an.append(this.jad_cp);
        jad_an.append('}');
        return jad_an.toString();
    }
}
