package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hf implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aHX = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(bVar.aHX)) {
            bVar.aHX = "";
        }
        bVar.aHY = jSONObject.optString("zipFileName");
        if (JSONObject.NULL.toString().equals(bVar.aHY)) {
            bVar.aHY = "";
        }
        bVar.aHZ = jSONObject.optString("zipPath");
        if (JSONObject.NULL.toString().equals(bVar.aHZ)) {
            bVar.aHZ = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (JSONObject.NULL.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.ajL = jSONObject.optString("checksum");
        if (JSONObject.NULL.toString().equals(bVar.ajL)) {
            bVar.ajL = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aIb = jSONObject.optBoolean("public");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aHX;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageId", bVar.aHX);
        }
        String str2 = bVar.aHY;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "zipFileName", bVar.aHY);
        }
        String str3 = bVar.aHZ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "zipPath", bVar.aHZ);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.ajL;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "checksum", bVar.ajL);
        }
        int i10 = bVar.loadType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadType", i10);
        }
        int i11 = bVar.packageType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageType", i11);
        }
        boolean z10 = bVar.aIb;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "public", z10);
        }
        return jSONObject;
    }
}
