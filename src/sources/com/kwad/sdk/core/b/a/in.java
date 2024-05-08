package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.b;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class in implements com.kwad.sdk.core.d<b.C0541b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0541b c0541b, JSONObject jSONObject) {
        a2(c0541b, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0541b c0541b, JSONObject jSONObject) {
        return b2(c0541b, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.C0541b c0541b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0541b.aJG = jSONObject.optInt("enable_monitor");
        c0541b.aJH = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(c0541b.aJH)) {
            c0541b.aJH = "";
        }
        c0541b.aJI = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(c0541b.aJI)) {
            c0541b.aJI = "";
        }
        c0541b.aJJ = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(c0541b.aJJ)) {
            c0541b.aJJ = "";
        }
        c0541b.aJK = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(c0541b.aJK)) {
            c0541b.aJK = "";
        }
        c0541b.aJL = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(c0541b.aJL)) {
            c0541b.aJL = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.C0541b c0541b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = c0541b.aJG;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enable_monitor", i10);
        }
        String str = c0541b.aJH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_sc_name", c0541b.aJH);
        }
        String str2 = c0541b.aJI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_pcl_name", c0541b.aJI);
        }
        String str3 = c0541b.aJJ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gam_name", c0541b.aJJ);
        }
        String str4 = c0541b.aJK;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gsv_name", c0541b.aJK);
        }
        String str5 = c0541b.aJL;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gpv_name", c0541b.aJL);
        }
        return jSONObject;
    }
}
