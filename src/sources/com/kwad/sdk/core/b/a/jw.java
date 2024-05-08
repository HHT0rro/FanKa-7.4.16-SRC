package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jw implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt("count");
        fVar.azP = jSONObject.optLong("lastModifiedTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = fVar.adStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i10);
        }
        int i11 = fVar.taskType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "taskType", i11);
        }
        int i12 = fVar.count;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "count", i12);
        }
        long j10 = fVar.azP;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastModifiedTime", j10);
        }
        return jSONObject;
    }
}
