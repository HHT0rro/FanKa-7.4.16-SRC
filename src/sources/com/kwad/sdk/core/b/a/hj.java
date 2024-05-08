package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.a.a;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hj implements com.kwad.sdk.core.d<a.C0544a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0544a c0544a, JSONObject jSONObject) {
        a2(c0544a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0544a c0544a, JSONObject jSONObject) {
        return b2(c0544a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0544a c0544a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0544a.aND = jSONObject.optString("typeStr");
        if (JSONObject.NULL.toString().equals(c0544a.aND)) {
            c0544a.aND = "";
        }
        c0544a.aNE = jSONObject.optString("valueStr");
        if (JSONObject.NULL.toString().equals(c0544a.aNE)) {
            c0544a.aNE = "";
        }
        c0544a.aNF = jSONObject.optString("listValueType");
        if (JSONObject.NULL.toString().equals(c0544a.aNF)) {
            c0544a.aNF = "";
        }
        c0544a.aNG = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                c0544a.aNG.add((String) optJSONArray.opt(i10));
            }
        }
        c0544a.fieldName = jSONObject.optString("fieldName");
        if (JSONObject.NULL.toString().equals(c0544a.fieldName)) {
            c0544a.fieldName = "";
        }
        c0544a.className = jSONObject.optString(PushClientConstants.TAG_CLASS_NAME);
        if (JSONObject.NULL.toString().equals(c0544a.className)) {
            c0544a.className = "";
        }
        c0544a.aNH = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                a.C0544a c0544a2 = new a.C0544a();
                c0544a2.parseJson(optJSONArray2.optJSONObject(i11));
                c0544a.aNH.add(c0544a2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0544a c0544a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0544a.aND;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeStr", c0544a.aND);
        }
        String str2 = c0544a.aNE;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "valueStr", c0544a.aNE);
        }
        String str3 = c0544a.aNF;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listValueType", c0544a.aNF);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "valueStrList", c0544a.aNG);
        String str4 = c0544a.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fieldName", c0544a.fieldName);
        }
        String str5 = c0544a.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, PushClientConstants.TAG_CLASS_NAME, c0544a.className);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "childParamList", c0544a.aNH);
        return jSONObject;
    }
}
