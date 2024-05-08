package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class gi implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTag> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        a2(matrixTag, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        return b2(matrixTag, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTag.styleId = jSONObject.optInt("styleId");
        matrixTag.type = jSONObject.optString("type");
        if (JSONObject.NULL.toString().equals(matrixTag.type)) {
            matrixTag.type = "";
        }
        matrixTag.isHide = jSONObject.optBoolean("isHide");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = matrixTag.styleId;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "styleId", i10);
        }
        String str = matrixTag.type;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", matrixTag.type);
        }
        boolean z10 = matrixTag.isHide;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isHide", z10);
        }
        return jSONObject;
    }
}
