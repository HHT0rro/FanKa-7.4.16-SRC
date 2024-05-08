package com.kwad.sdk.core.b.a;

import com.inno.innosdk.pb.InnoMain;
import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ez implements com.kwad.sdk.core.d<h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.atm = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(aVar.atm)) {
            aVar.atm = "";
        }
        aVar.atn = jSONObject.optString(InnoMain.INNO_KEY_OAID);
        if (JSONObject.NULL.toString().equals(aVar.atn)) {
            aVar.atn = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.atm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", aVar.atm);
        }
        String str2 = aVar.atn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, InnoMain.INNO_KEY_OAID, aVar.atn);
        }
        return jSONObject;
    }
}
